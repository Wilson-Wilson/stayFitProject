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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import org.json.JSONException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class RealAPI implements API
{
    private static String CALL_BACK_URI="http://localhost:8080";
    private static int CALL_BACK_PORT=8080;
    Date enDate;
    Date baseDate;
    String frmt1 = new String();
    String frmt2 = new String();
    String requestUrlSuffix = new String(),requestUrlSuffix2 = new String();
    String requestUrl = new String(),requestUrl2 = new String();
    OAuthRequest request,request2;
    String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
    Calendar calndr = Calendar.getInstance();
    Response response,response2;

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

    FitbitOAuth20ServiceImpl service,service2;
    OAuth2AccessToken accessToken;


    public RealAPI(String thedate) throws ParseException
    {
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        enDate = formatter.parse(thedate);
        //read credentials from a file

        try {
            // File with service credentials.
            FileReader fileReader = new FileReader("src/main/resources/Team12Credentials.txt");

            bufferedReader = new BufferedReader(fileReader);
            clientID= bufferedReader.readLine();
            apiKey= bufferedReader.readLine();
            apiSecret = bufferedReader.readLine();
            bufferedReader.close();

            fileReader = new FileReader("src/main/resources/Team12Tokens.txt");
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
        
        service2 = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
        	.apiKey(clientID)       //fitbit uses the clientID here
        	.apiSecret(apiSecret)
        	.callback("http://localhost:8080")
        	.scope(scope)
        	.grantType("authorization_code")
        	.build(FitbitApi20.instance());

    }
    
    /**
     * This method is used to fetch the number of calories burned.
     * @return String This returns the number of calories burned.
     * @throws JSONException 
     */
    public JSONObject getCalBurned() throws JSONException{
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
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getCalSeries() throws JSONException{
    	
    	frmt1 = String.format("%tF", enDate);
        requestUrlSuffix2 = "activities/calories/date/"+frmt1+"/1d/15min.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getSteps() throws JSONException{
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
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getStepsSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix2 = "activities/steps/date/"+frmt1+"/1d/15min.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getFloors() throws JSONException{
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
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getFloorsSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix2 = "activities/floors/date/"+frmt1+"/1d/15min.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getSedentaryMinutes() throws JSONException{
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
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }
    
    public JSONObject getSedentaryMinutesSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix2 = "activities/minutesSedentary/date/"+frmt1+"/1d/15min.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    
    public JSONObject getActiveMinutes() throws JSONException{
        calndr.setTime(enDate);
        calndr.add(calndr.YEAR, -1);
        baseDate = calndr.getTime();
        frmt1 = String.format("%tF", enDate);
        frmt2 = String.format("%tF", baseDate);
        //requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt1+"15min.json";
        requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt2+"/"+frmt1+".json";
        //[resource-path]/date/[date]/1d/[detail-level].json
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        response = request.send();
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }
    
    public JSONObject getActiveMinutesSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix2 = "activities/minutesFairlyActive/date/"+frmt1+"/1d/15min.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }		
    
    public JSONObject getDistance() throws JSONException{
        calndr.setTime(enDate);
        calndr.add(calndr.YEAR, -1);
        baseDate = calndr.getTime();
        frmt1 = String.format("%tF", enDate);
        frmt2 = String.format("%tF", baseDate);
        requestUrlSuffix = "activities/distance/date/"+frmt2+"/"+frmt1+".json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        response = request.send();
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getDistanceSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix2 = "activities/distance/date/"+frmt1+"/1d/15min.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }
    
    public JSONObject getHeartRateSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix = "activities/heart/date/"+frmt1+"/1d/15min.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        response = request.send();
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    public JSONObject getLifeTime() throws JSONException{
        requestUrlSuffix2 = "activities.json";
        requestUrl2 = requestUrlPrefix + requestUrlSuffix2;
        request2 = new OAuthRequest(Verb.GET, requestUrl2, service2);
        service2.signRequest(accessToken, request2);
        response2 = request2.send();
        System.out.println(response2.getBody());
        refresh(response2);
        JSONObject retVal = new JSONObject(response2.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }
    
    public JSONObject getGoals() throws JSONException{
        requestUrlSuffix = "activities/goals/daily.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        response = request.send();
        System.out.println(response.getBody());
        refresh(response);
        JSONObject retVal = new JSONObject(response.getBody()); 
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return retVal;
    }

    
    
    private void refresh(Response response){
        int statusCode = response.getCode();
        
        System.out.println("HTTP response code: "+response.getCode());
    	String result = response.getBody();
    	BufferedWriter bufferedWriter=null;
        //  Save the current accessToken information for next time
         
        // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
        //   - contact Beth if this happens and she can reissue you a fresh set
         
        try {
            FileWriter fileWriter; 
            fileWriter =
                    new FileWriter("src/main/resources/Team12Tokens.txt");
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
            System.out.println(
                    "Unable to open file\n"+ex.getMessage());               
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading/write file\n"+ex.getMessage());                 
        }
        finally{
            try{
                if (bufferedWriter!=null)
                    bufferedWriter.close(); 
            }
            catch(Exception e){
                System.out.println(
                        "Error closing file\n"+e.getMessage()); 
            }
        }
    }
  
}

