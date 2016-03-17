	package ca.uwo.csd.cs2212.team12;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.MalformedURLException;
	import java.net.URL;
	import com.github.scribejava.apis.FitbitApi20;
	import com.github.scribejava.core.builder.ServiceBuilder;
	import com.github.scribejava.core.oauth.OAuthService;
	import com.github.scribejava.core.model.*;
	import com.github.scribejava.core.oauth.OAuth20Service;
	import com.github.scribejava.apis.service.FitbitOAuth20ServiceImpl;
	import com.github.scribejava.core.model.OAuthRequest;
	import java.awt.Desktop;
	import java.net.URI;
	import org.json.JSONObject;
	import org.json.JSONArray;

	import java.util.Arrays;
	import java.util.Calendar;
	import java.util.Date;
		
	public class RealAPI
	{
		private static String CALL_BACK_URI="http://localhost:8080";
		private static int CALL_BACK_PORT=8080;
		Date enDate;
	    Date baseDate;
		String frmt1 = new String();
		String frmt2 = new String();
		String requestUrlSuffix = new String();
		String requestUrl = new String();
        OAuthRequest request;
        String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";		   
		Calendar calndr = Calendar.getInstance();
		Response response;
		  
		BufferedReader bufferedReader=null;
		   // This will reference one line at a time
		String line = null;

		   //Need to save service credentials for Fitbit
		String apiKey = null;      
		String apiSecret = null;
		String clientID = null;

		   //holder for all the elements we will need to make an access token ( information about an authenticated session )
		String accessTokenItself =  null;
		String tokenType = null;
		String refreshToken = null;
		Long expiresIn = null;
		String rawResponse = null;

		   //This is the only scope you have access to currently
		String scope = "activity%20heartrate";
		  
		FitbitOAuth20ServiceImpl service;
		OAuth2AccessToken accessToken;
		   
		
		public RealAPI(Date thedate)
		{
			enDate = thedate;
			//read credentials from a file
			   
			   try {
			   // File with service credentials.
			   FileReader fileReader = new FileReader("C:/Users/Wilson/courses/cs2212/labs/jwils269/BATut/src/main/resources/Team12Credentials.txt");
			   
			   bufferedReader = new BufferedReader(fileReader);
			   clientID= bufferedReader.readLine();
			   apiKey= bufferedReader.readLine();
			   apiSecret = bufferedReader.readLine();
			   bufferedReader.close();
	
			   fileReader = new FileReader("C:/Users/Wilson/courses/cs2212/labs/jwils269/BATut/src/main/resources/Team12Tokens.txt");
			   bufferedReader = new BufferedReader(fileReader);
			   accessTokenItself = bufferedReader.readLine();
			   tokenType = bufferedReader.readLine();
			   refreshToken = bufferedReader.readLine();
			   expiresIn = Long.parseLong(bufferedReader.readLine());
			   rawResponse = bufferedReader.readLine();
			   }
	
			   catch(FileNotFoundException ex) {
			   System.out.println("Unable to open file\n"+ex.getMessage());
			   System.exit(1);
			   }
	
			   catch(IOException ex) {
			   System.out.println("Error reading/write file\n"+ex.getMessage());  
			   System.exit(1);
			   }
			 
			   finally{
	
			   try{
			   if (bufferedReader!=null)
			   // Always close files.
			   bufferedReader.close(); 
			   }
	
			   catch(Exception e){
			   System.out.println("Error closing file\n"+e.getMessage()); 
			   }
			   }
			   
			   service = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
			   .apiKey(clientID)       //fitbit uses the clientID here
			   .apiSecret(apiSecret)
			   .callback("http://localhost:8080")
			   .scope(scope)
			   .grantType("authorization_code")
			   .build(FitbitApi20.instance());
			   
			   accessToken = new OAuth2AccessToken(
					   accessTokenItself,
					   tokenType,
					   refreshToken,
					   expiresIn,
					   rawResponse);		 
			 }
		
		
		public void setCalories(){
			calndr.setTime(enDate);   
			calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/calories/date/"+frmt2+"/"+frmt1+".json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		
		public void setCaloriesSeries(){
			calndr.setTime(enDate);   
			calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/calories/date/"+frmt1+"/1d/15min.json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setSteps(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/steps/date/"+frmt2+"/"+frmt1+".json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setStepsSeries(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/steps/date/"+frmt1+"/1d/15min.json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setFloors(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/floors/date/"+frmt2+"/"+frmt1+".json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setFloorsSeries(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/floors/date/"+frmt1+"/1d/15min.json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setSedMins(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/minutesSedentary/date/"+frmt2+"/"+frmt1+".json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setSedMinsSeries(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/minutesSedentary/date/"+frmt1+"/1d/15min.json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
		   }
		   
		   public void setFairlyMins(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt2+"/"+frmt1+".json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   response = request.send();
		   }
		   
		   public void setFairlyMinsSeries(){
			   calndr.setTime(enDate);
			   calndr.add(calndr.YEAR, -1);
			   baseDate = calndr.getTime();
			   frmt1 = String.format("%tF", enDate);
			   frmt2 = String.format("%tF", baseDate);
			   requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt1+"/1d/15min.json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   response = request.send();
		   }
		   
		   public void setLifetime(){
			   requestUrlSuffix = "activities.json";
			   requestUrl = requestUrlPrefix + requestUrlSuffix;
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   response = request.send();
		   }
		   
		   
		   public void getResults(){
			   System.out.println();
			   System.out.println("HTTP response code: "+response.getCode());
			   int statusCode = response.getCode();
			   switch(statusCode){
			   case 200:
			   System.out.println("Success!");
			   System.out.println("HTTP response body:\n"+response.getBody());System.out.println("\n\n");
			   break;
			   case 400:
			   System.out.println("Bad Request - may have to talk to Beth");
			   System.out.println("HTTP response body:\n"+response.getBody());System.out.println("\n\n");
			   break;
			   case 401:
			   System.out.println("Likely Expired Token");
			   System.out.println("HTTP response body:\n"+response.getBody()); 
			   System.out.println("Try to refresh");System.out.println("\n\n");
			   // This uses the refresh token to get a completely new accessToken object
			   //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
			   // This accessToken is now the current one, and the old ones will not work
			   //   again.  You should save the contents of accessToken.
			   accessToken = service.refreshOAuth2AccessToken(accessToken);
			   // Now we can try to access the service again
			   // Make sure you create a new OAuthRequest object each time!
			   request = new OAuthRequest(Verb.GET, requestUrl, service);
			   service.signRequest(accessToken, request);
			   response = request.send();
			   // Hopefully got a response this time:
			   System.out.println("HTTP response code: "+response.getCode());
			   System.out.println("HTTP response body:\n"+response.getBody());
			   break;
			   case 429:
			   System.out.println("Rate limit exceeded");
			   System.out.println("HTTP response body:\n"+response.getBody());System.out.println("\n\n");
			   break;
	
			   default:
			  System.out.println("HTTP response code: "+response.getCode());
			  System.out.println("HTTP response body:\n"+response.getBody());System.out.println("\n\n");
			  }
	
			  System.out.println("\n\n\n\n");
			   
			   
			  BufferedWriter bufferedWriter=null;
			 //  Save the current accessToken information for next time
	
			 // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
			 //   - contact Beth if this happens and she can reissue you a fresh set
	
			  try {
				  FileWriter fileWriter; 
				  fileWriter = new FileWriter("C:/Users/Wilson/courses/cs2212/labs/jwils269/BATut/src/main/resources/Team12Tokens.txt");
				  bufferedWriter = new BufferedWriter(fileWriter);
				  bufferedWriter.write(accessToken.getToken());
				  bufferedWriter.newLine();
				  bufferedWriter.write(accessToken.getTokenType());
				  bufferedWriter.newLine();
				  bufferedWriter.write(accessToken.getRefreshToken());
				  bufferedWriter.newLine();
				  bufferedWriter.write(accessToken.getExpiresIn().toString() );
				  bufferedWriter.newLine();
				  bufferedWriter.write(accessToken.getRawResponse());
				  bufferedWriter.newLine();
				  bufferedWriter.close();
			 }catch(FileNotFoundException ex) {
			 System.out.println("Unable to open file\n"+ex.getMessage());               
			 }
			 catch(IOException ex) {
			 System.out.println("Error reading/write file\n"+ex.getMessage());                 
			 }
			 
			 finally{
			 try {
				 if (bufferedWriter!=null)
					 bufferedWriter.close(); 
			 }catch(Exception e){
			 System.out.println("Error closing file\n"+e.getMessage()); 
			 }
			   
		   }	
	
	}
		   
}
	
