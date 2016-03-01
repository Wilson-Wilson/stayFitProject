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
import java.awt.Desktop;
import java.net.URI;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Date;

public class AppRefreshTokens
{
   private static String CALL_BACK_URI="http://localhost:8080";
   private static int CALL_BACK_PORT=8080;
   
   public static void main( String[] args )
   {
   //read credentials from a file
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
   try {
   // File with service credentials.
   FileReader fileReader = new FileReader("C:/Users/Shanice/courses/cs2212/labs/shanlon/BATut/src/main/resources/Team12Credentials.txt");
   
   bufferedReader = new BufferedReader(fileReader);
   clientID= bufferedReader.readLine();
   apiKey= bufferedReader.readLine();
   apiSecret = bufferedReader.readLine();
   bufferedReader.close();

   fileReader = new FileReader("C:/Users/Shanice/courses/cs2212/labs/shanlon/BATut/src/main/resources/Team12Tokens.txt");
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

   //  Create the Fitbit service - you will ask this to ask for access/refresh pairs
   //     and to add authorization information to the requests to the API
   FitbitOAuth20ServiceImpl service = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
   .apiKey(clientID)       //fitbit uses the clientID here
   .apiSecret(apiSecret)
   .callback("http://localhost:8080")
   .scope(scope)
   .grantType("authorization_code")
   .build(FitbitApi20.instance());

   //  The access token contains everything you will need to authenticate your requests
   //  It can expire - at which point you will use the refresh token to refresh it
   //See: https://dev.fitbit.com/docs/oauth2/#refreshing-tokens
   //    I have authenticated and given you the contents of the response to use

   OAuth2AccessToken accessToken = new OAuth2AccessToken(
   accessTokenItself,
   tokenType,
   refreshToken,
   expiresIn,
   rawResponse);
   
   OAuth2AccessToken accessToken2 = new OAuth2AccessToken(
   accessTokenItself,
   tokenType,
   refreshToken,
   expiresIn,
   rawResponse);
   
   OAuth2AccessToken accessToken3 = new OAuth2AccessToken(
   accessTokenItself,
   tokenType,
   refreshToken,
   expiresIn,
   rawResponse);
   
   OAuth2AccessToken accessToken4 = new OAuth2AccessToken(
   accessTokenItself,
   tokenType,
   refreshToken,
   expiresIn,
   rawResponse);
   
   OAuth2AccessToken accessToken5 = new OAuth2AccessToken(
   accessTokenItself,
   tokenType,
   refreshToken,
   expiresIn,
   rawResponse);
   
   
   
   
   
   
   // Now let's go and ask for a protected resource!
   System.out.println("Now we're going to access a protected resource...");
   System.out.println();

   //Example request:
   //    This is always the prefix (for my account)
   Date date = new Date();
   String frmt = String.format("%tF", date);
   String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
   String requestsumUrlSuffix = "activities/date/"+frmt+".json";
   
   String requestcalYearUrlSuffix = "activities/calories/date/2015-02-20/"+frmt+".json";
   String requestfloorsYearUrlSuffix = "activities/floors/date/2016-02-29/"+frmt+".json";
   String requestsedYearUrlSuffix = "activities/minutesSedentary/date/2016-02-29/"+frmt+".json";
   String requeststepsYearUrlSuffix = "activities/steps/date/2016-02-29/"+frmt+".json";
   String requestfairYearUrlSuffix = "activities/minutesFairlyActive/date/2016-02-29/"+frmt+".json";
   //String requeststepsYearUrlSuffix = "activities//date/2016-02-29/"+frmt+".json";
   String requestcalYearUrl;
   String requeststepsYearUrl;
   String requestfloorsYearUrl;
   String requestsedYearUrl;
   String requestfairYearUrl;

   //    The URL from this point is how you ask for different information
  // requestUrl = requestUrlPrefix + requestsumUrlSuffix;
   System.out.println("\n\n");
   requestcalYearUrl = requestUrlPrefix + requestcalYearUrlSuffix;
   requeststepsYearUrl = requestUrlPrefix + requestfloorsYearUrlSuffix;
   requestfloorsYearUrl = requestUrlPrefix + requestsedYearUrlSuffix;
   requestsedYearUrl = requestUrlPrefix + requeststepsYearUrlSuffix;
   requestfairYearUrl = requestUrlPrefix + requestfairYearUrlSuffix;

   // This actually generates an HTTP request from the URL
   //    -it has a header, body ect.
   OAuthRequest request = new OAuthRequest(Verb.GET, requestcalYearUrl, service);
   OAuthRequest request2 = new OAuthRequest(Verb.GET, requeststepsYearUrl, service);
   OAuthRequest request3 = new OAuthRequest(Verb.GET, requestfloorsYearUrl, service);
   OAuthRequest request4 = new OAuthRequest(Verb.GET, requestsedYearUrl, service);
   OAuthRequest request5 = new OAuthRequest(Verb.GET, requestfairYearUrl, service);
   // This adds the information required by Fitbit to add the authorization information to the HTTP request
   // You must do this before the request will work
   // See: https://dev.fitbit.com/docs/oauth2/#making-requests
   service.signRequest(accessToken, request);
   service.signRequest(accessToken2, request2);
   service.signRequest(accessToken3, request3);
   service.signRequest(accessToken4, request4);
   service.signRequest(accessToken5, request5);

   //  If you are curious
   System.out.println(request.toString());
   System.out.println(request.getHeaders());
   System.out.println(request.getBodyContents());

   //  This actually sends the request:
   Response response = request.send();
   Response response2 = request2.send();
   Response response3 = request3.send();
   Response response4 = request4.send();
   Response response5 = request5.send();

   //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
   //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
   System.out.println();
   System.out.println("HTTP response code: "+response.getCode());
   int statusCode = response.getCode();
   switch(statusCode){
   case 200:
   System.out.println("Success!");
   System.out.println("HTTP response body:\n"+response.getBody());
   break;
   case 400:
   System.out.println("Bad Request - may have to talk to Beth");
   System.out.println("HTTP response body:\n"+response.getBody());
   break;
   case 401:
   System.out.println("Likely Expired Token");
   System.out.println("HTTP response body:\n"+response.getBody()); 
   System.out.println("Try to refresh");
   // This uses the refresh token to get a completely new accessToken object
   //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
   // This accessToken is now the current one, and the old ones will not work
   //   again.  You should save the contents of accessToken.
   accessToken = service.refreshOAuth2AccessToken(accessToken);
   // Now we can try to access the service again
   // Make sure you create a new OAuthRequest object each time!
   request = new OAuthRequest(Verb.GET, requestcalYearUrl, service);
   service.signRequest(accessToken, request);
   response = request.send();
   // Hopefully got a response this time:
                         System.out.println("HTTP response code: "+response.getCode());
 System.out.println("HTTP response body:\n"+response.getBody());
 break;
                         case 429:
 System.out.println("Rate limit exceeded");
 System.out.println("HTTP response body:\n"+response.getBody());
 break;

 default:
 System.out.println("HTTP response code: "+response.getCode());
 System.out.println("HTTP response body:\n"+response.getBody());
 }

   System.out.println("\n\n\n\n");
   
 //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
   //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
   System.out.println();
   System.out.println("HTTP response code: "+response2.getCode());
   int statusCode2 = response.getCode();
   switch(statusCode2){
   case 200:
   System.out.println("Success!");
   System.out.println("HTTP response body:\n"+response2.getBody());
   break;
   case 400:
   System.out.println("Bad Request - may have to talk to Beth");
   System.out.println("HTTP response body:\n"+response2.getBody());
   break;
   case 401:
   System.out.println("Likely Expired Token");
   System.out.println("HTTP response body:\n"+response2.getBody()); 
   System.out.println("Try to refresh");
   // This uses the refresh token to get a completely new accessToken object
   //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
   // This accessToken is now the current one, and the old ones will not work
   //   again.  You should save the contents of accessToken.
   accessToken2 = service.refreshOAuth2AccessToken(accessToken2);
   // Now we can try to access the service again
   // Make sure you create a new OAuthRequest object each time!
   request2 = new OAuthRequest(Verb.GET, requeststepsYearUrl, service);
   service.signRequest(accessToken2, request2);
   response2 = request2.send();
   // Hopefully got a response this time:
                         System.out.println("HTTP response code: "+response2.getCode());
 System.out.println("HTTP response body:\n"+response2.getBody());
 break;
                         case 429:
 System.out.println("Rate limit exceeded");
 System.out.println("HTTP response body:\n"+response2.getBody());
 break;

 default:
 System.out.println("HTTP response code: "+response2.getCode());
 System.out.println("HTTP response body:\n"+response2.getBody());
 }  
   
   
 //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
   //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
   System.out.println();
   System.out.println("HTTP response code: "+response3.getCode());
   int statusCode3 = response3.getCode();
   switch(statusCode3){
   case 200:
   System.out.println("Success!");
   System.out.println("HTTP response body:\n"+response3.getBody());
   break;
   case 400:
   System.out.println("Bad Request - may have to talk to Beth");
   System.out.println("HTTP response body:\n"+response3.getBody());
   break;
   case 401:
   System.out.println("Likely Expired Token");
   System.out.println("HTTP response body:\n"+response3.getBody()); 
   System.out.println("Try to refresh");
   // This uses the refresh token to get a completely new accessToken object
   //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
   // This accessToken is now the current one, and the old ones will not work
   //   again.  You should save the contents of accessToken.
   accessToken3 = service.refreshOAuth2AccessToken(accessToken3);
   // Now we can try to access the service again
   // Make sure you create a new OAuthRequest object each time!
   request3 = new OAuthRequest(Verb.GET, requestfloorsYearUrl, service);
   service.signRequest(accessToken3, request3);
   response3 = request3.send();
   // Hopefully got a response this time:
                         System.out.println("HTTP response code: "+response3.getCode());
 System.out.println("HTTP response body:\n"+response3.getBody());
 break;
                         case 429:
 System.out.println("Rate limit exceeded");
 System.out.println("HTTP response body:\n"+response3.getBody());
 break;

 default:
 System.out.println("HTTP response code: "+response3.getCode());
 System.out.println("HTTP response body:\n"+response3.getBody());
 }  
   
   
  System.out.println("\n\n\n\n");
  
  
  //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
   //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
   System.out.println();
   System.out.println("HTTP response code: "+response4.getCode());
   int statusCode4 = response4.getCode();
   switch(statusCode4){
   case 200:
   System.out.println("Success!");
   System.out.println("HTTP response body:\n"+response4.getBody());
   break;
   case 400:
   System.out.println("Bad Request - may have to talk to Beth");
   System.out.println("HTTP response body:\n"+response4.getBody());
   break;
   case 401:
   System.out.println("Likely Expired Token");
   System.out.println("HTTP response body:\n"+response4.getBody()); 
   System.out.println("Try to refresh");
   // This uses the refresh token to get a completely new accessToken object
   //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
   // This accessToken is now the current one, and the old ones will not work
   //   again.  You should save the contents of accessToken.
   accessToken4 = service.refreshOAuth2AccessToken(accessToken4);
   // Now we can try to access the service again
   // Make sure you create a new OAuthRequest object each time!
   request4 = new OAuthRequest(Verb.GET, requestsedYearUrl, service);
   service.signRequest(accessToken4, request4);
   response4 = request4.send();
   // Hopefully got a response this time:
                         System.out.println("HTTP response code: "+response4.getCode());
 System.out.println("HTTP response body:\n"+response4.getBody());
 break;
                         case 429:
 System.out.println("Rate limit exceeded");
 System.out.println("HTTP response body:\n"+response4.getBody());
 break;

 default:
 System.out.println("HTTP response code: "+response4.getCode());
 System.out.println("HTTP response body:\n"+response4.getBody());
 }
   
   
   System.out.println("\n\n\n\n");
   
   
   //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
   //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
   System.out.println();
   System.out.println("HTTP response code: "+response5.getCode());
   int statusCode5 = response5.getCode();
   switch(statusCode5){
   case 200:
   System.out.println("Success!");
   System.out.println("HTTP response body:\n"+response5.getBody());
   break;
   case 400:
   System.out.println("Bad Request - may have to talk to Beth");
   System.out.println("HTTP response body:\n"+response5.getBody());
   break;
   case 401:
   System.out.println("Likely Expired Token");
   System.out.println("HTTP response body:\n"+response5.getBody()); 
   System.out.println("Try to refresh");
   // This uses the refresh token to get a completely new accessToken object
   //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
   // This accessToken is now the current one, and the old ones will not work
   //   again.  You should save the contents of accessToken.
   accessToken5 = service.refreshOAuth2AccessToken(accessToken5);
   // Now we can try to access the service again
   // Make sure you create a new OAuthRequest object each time!
   request5 = new OAuthRequest(Verb.GET, requestfairYearUrl, service);
   service.signRequest(accessToken5, request5);
   response5 = request5.send();
   // Hopefully got a response this time:
                         System.out.println("HTTP response code: "+response5.getCode());
 System.out.println("HTTP response body:\n"+response5.getBody());
 break;
                         case 429:
 System.out.println("Rate limit exceeded");
 System.out.println("HTTP response body:\n"+response5.getBody());
 break;

 default:
 System.out.println("HTTP response code: "+response5.getCode());
 System.out.println("HTTP response body:\n"+response5.getBody());
 }
   
   
 BufferedWriter bufferedWriter=null;
 //  Save the current accessToken information for next time

 // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
 //   - contact Beth if this happens and she can reissue you a fresh set

 try {
 FileWriter fileWriter; 
 fileWriter = new FileWriter("C:/Users/Shanice/courses/cs2212/labs/shanlon/BATut/src/main/resources/Team12Tokens.txt");
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
 }
 
 catch(FileNotFoundException ex) {
 System.out.println("Unable to open file\n"+ex.getMessage());               
 }
 
 catch(IOException ex) {
 System.out.println("Error reading/write file\n"+ex.getMessage());                 
 }
 
 finally{
 try {
 if (bufferedWriter!=null)
 bufferedWriter.close(); 
 }
 
 catch(Exception e){
 System.out.println("Error closing file\n"+e.getMessage()); 
 }
 
 }//end try
 
 }//end main
 
 }//end class

