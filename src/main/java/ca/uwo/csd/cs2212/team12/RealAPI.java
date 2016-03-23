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
    }
    
    /**
     * This method is used to fetch the number of calories burned.
     * @return String This returns the number of calories burned.
     * @throws JSONException 
     */
    public JSONArray getCalBurned() throws JSONException{
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
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getCalSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix = "activities/calories/date/"+frmt1+"/1d/1min.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getSteps() throws JSONException{
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
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getStepsSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix = "activities/steps/date/"+frmt1+"/1d/1min.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getFloors() throws JSONException{
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
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getFloorsSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix = "activities/floors/date/"+frmt1+"/1d/1min.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        service.signRequest(accessToken, request);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getSedentaryMinutes() throws JSONException{
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
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    
    public JSONArray getActiveMinutes() throws JSONException{
        calndr.setTime(enDate);
        calndr.add(calndr.YEAR, -1);
        baseDate = calndr.getTime();
        frmt1 = String.format("%tF", enDate);
        frmt2 = String.format("%tF", baseDate);
        requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt2+"/"+frmt1+".json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }
    
    public JSONArray getDistance() throws JSONException{
        calndr.setTime(enDate);
        calndr.add(calndr.YEAR, -1);
        baseDate = calndr.getTime();
        frmt1 = String.format("%tF", enDate);
        frmt2 = String.format("%tF", baseDate);
        requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt2+"/"+frmt1+".json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getDistanceSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix = "activities/minutesFairlyActive/date/"+frmt1+"/1d/1min.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }
    
    public JSONArray getHeartRateSeries() throws JSONException{
        frmt1 = String.format("%tF", enDate);
        requestUrlSuffix = "activities/heart/date/"+frmt1+"/1d/1min.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    public JSONArray getLifeTime() throws JSONException{
        requestUrlSuffix = "activities.json";
        requestUrl = requestUrlPrefix + requestUrlSuffix;
        request = new OAuthRequest(Verb.GET, requestUrl, service);
        response = request.send();
        refresh();
        JSONArray retVal = new JSONArray(response.getBody()); 
        return retVal;
    }

    

    /*private  int getDat(String dat) {
        int integerData = 0;
        try {
            String jsonStr = response.getBody();
            JSONObject o = new JSONObject(jsonStr);
            JSONObject element =  o.getJSONObject("summary");//needs to be edited to look through response json
            integerData = element.getInt(dat);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return integerData; //needs to return an array probably
    }*/

    //we still need to save/refresh the tokens
    //so either we add it to each method or have a refresh method
    private void refresh(){
        /*System.out.println();
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
*/

        BufferedWriter bufferedWriter=null;
        //  Save the current accessToken information for next time

        // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
        //   - contact Beth if this happens and she can reissue you a fresh set

        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter("src/main/resources/Team12Tokens.txt");
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

