package ca.uwo.csd.cs2212.team12;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
/**
 * An API for offline testing of the StayFit application
 *
 * @author  Team 12
 * @version 1.0
 * @since   2016-02-27
 */

public class TestAPI implements API {

    /**
     * This method is used to fetch the number of calories burned.
     * @return String This returns the number of calories burned.
     */
    public  JSONObject getCalBurned() throws JSONException {
    	String str ="{\"activities-calories\":[{\"dateTime\":\"2016-03-16\",\"value\":\"2331\"},{\"dateTime\":\"2016-03-17\",\"value\":\"2433\"},{\"dateTime\":\"2016-03-18\",\"value\":\"2296\"},{\"dateTime\":\"2016-03-19\",\"value\":\"2221\"},{\"dateTime\":\"2016-03-20\",\"value\":\"2337\"},{\"dateTime\":\"2016-03-21\",\"value\":\"2462\"},{\"dateTime\":\"2016-03-22\",\"value\":\"2727\"},{\"dateTime\":\"2016-03-23\",\"value\":\"2287\"}]}";
    	JSONObject thing = new JSONObject(str);
    	return thing;
    }
        /**
     * This method is used to fetch the number of active minutes.
     * @return JSONArray This returns the number of active minutes.
     */
    public  JSONObject getActiveMinutes() throws JSONException {
    	String str ="{\"activities-minutesFairlyActive\":[{\"dateTime\":\"2016-03-16\",\"value\":\"2331\"},{\"dateTime\":\"2016-03-17\",\"value\":\"2433\"},{\"dateTime\":\"2016-03-18\",\"value\":\"2296\"},{\"dateTime\":\"2016-03-19\",\"value\":\"2221\"},{\"dateTime\":\"2016-03-20\",\"value\":\"2337\"},{\"dateTime\":\"2016-03-21\",\"value\":\"2462\"},{\"dateTime\":\"2016-03-22\",\"value\":\"2727\"},{\"dateTime\":\"2016-03-23\",\"value\":\"2287\"}]}";
    	JSONObject thing = new JSONObject(str);
    	return thing;
    	}

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return String This returns the number of sedentary minutes.
     */
    public  JSONObject getSedentaryMinutes() throws JSONException {
    	String str ="{\"activities-minutesSedentary\":[{\"dateTime\":\"2016-03-16\",\"value\":\"2331\"},{\"dateTime\":\"2016-03-17\",\"value\":\"2433\"},{\"dateTime\":\"2016-03-18\",\"value\":\"2296\"},{\"dateTime\":\"2016-03-19\",\"value\":\"2221\"},{\"dateTime\":\"2016-03-20\",\"value\":\"2337\"},{\"dateTime\":\"2016-03-21\",\"value\":\"2462\"},{\"dateTime\":\"2016-03-22\",\"value\":\"2727\"},{\"dateTime\":\"2016-03-23\",\"value\":\"2287\"}]}";
    	JSONObject thing = new JSONObject(str);
    	return thing;
    	
    }
    	

    /**
     * This method is used to fetch the distance travelled.
     * @return JSONArray This returns the distance travelled.
     */
    public  JSONObject getDistance() throws JSONException {
    	String str ="{\"activities-distance\":[{\"dateTime\":\"2016-03-16\",\"value\":\"2331\"},{\"dateTime\":\"2016-03-17\",\"value\":\"2433\"},{\"dateTime\":\"2016-03-18\",\"value\":\"2296\"},{\"dateTime\":\"2016-03-19\",\"value\":\"2221\"},{\"dateTime\":\"2016-03-20\",\"value\":\"2337\"},{\"dateTime\":\"2016-03-21\",\"value\":\"2462\"},{\"dateTime\":\"2016-03-22\",\"value\":\"2727\"},{\"dateTime\":\"2016-03-23\",\"value\":\"2287\"}]}";
    	JSONObject thing = new JSONObject(str);
    	return thing;
    	}

    /**
     * This method is used to fetch the number of floors climbed.
     * @return JSONArray This returns the number of floors climbed.
     */public JSONObject getFloors() throws JSONException {
    	 String str ="{\"activities-floors\":[{\"dateTime\":\"2016-03-16\",\"value\":\"2331\"},{\"dateTime\":\"2016-03-17\",\"value\":\"2433\"},{\"dateTime\":\"2016-03-18\",\"value\":\"2296\"},{\"dateTime\":\"2016-03-19\",\"value\":\"2221\"},{\"dateTime\":\"2016-03-20\",\"value\":\"2337\"},{\"dateTime\":\"2016-03-21\",\"value\":\"2462\"},{\"dateTime\":\"2016-03-22\",\"value\":\"2727\"},{\"dateTime\":\"2016-03-23\",\"value\":\"2287\"}]}";
     	JSONObject thing = new JSONObject(str);
     	return thing;
    	 }

    /**
     * This method is used to fetch the number of steps.
     * @return JSONArray This returns the number of steps.
     */
    public  JSONObject getSteps() throws JSONException {
    	String str ="{\"activities-steps\":[{\"dateTime\":\"2016-03-16\",\"value\":\"2331\"},{\"dateTime\":\"2016-03-17\",\"value\":\"2433\"},{\"dateTime\":\"2016-03-18\",\"value\":\"2296\"},{\"dateTime\":\"2016-03-19\",\"value\":\"2221\"},{\"dateTime\":\"2016-03-20\",\"value\":\"2337\"},{\"dateTime\":\"2016-03-21\",\"value\":\"2462\"},{\"dateTime\":\"2016-03-22\",\"value\":\"2727\"},{\"dateTime\":\"2016-03-23\",\"value\":\"2287\"}]}";
    	JSONObject thing = new JSONObject(str);
    	return thing;
    	}


    public JSONObject getDistanceSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-distance-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
	}

    public JSONObject getStepsSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-steps-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
	}

    public JSONObject getCalSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-calories-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
	}

    public JSONObject getFloorsSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-floors-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
	}
    
    public JSONObject getHeartRateSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-heart-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
	}
    
    public JSONObject getSedentaryMinutesSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-minutesSedentary-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
    	}

    
    public JSONObject getActiveMinutesSeries() throws JSONException{
    	String str = "{\"activities-calories\":[{\"dateTime\":\"2016-03-23\",\"value\":\"68.19\"}],\"activities-minutesFairlyActive-intraday\":{\"dataset\":[{\"level\":0,\"mets\":150,\"time\":\"03:00:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:15:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:30:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":150,\"time\":\"03:45:00\",\"value\":16.76849937438965},{\"level\":0,\"mets\":10,\"time\":\"04:00:00\",\"value\":1.117900013923645}],\"datasetInterval\":15,\"datasetType\":\"minute\"}}";
    	JSONObject thing = new JSONObject (str);
    	return thing;
	}
    
    public JSONObject getGoals() throws JSONException{
    	String str ="{\"best\":{\"total\":{\"distance\":{\"date\":\"2016-03-01\",\"value\":12.35489},\"floors\":{\"date\":\"2016-03-16\",\"value\":41.000000062320005},\"steps\":{\"date\":\"2016-03-01\",\"value\":14709}},\"tracker\":{\"distance\":{\"date\":\"2016-03-01\",\"value\":12.35489},\"floors\":{\"date\":\"2016-03-16\",\"value\":41.000000062320005},\"steps\":{\"date\":\"2016-03-01\",\"value\":14709}}},\"lifetime\":{\"total\":{\"activeScore\":-1,\"caloriesOut\":-1,\"distance\":300.85,\"floors\":857,\"steps\":401635},\"tracker\":{\"activeScore\":-1,\"caloriesOut\":-1,\"distance\":300.85,\"floors\":857,\"steps\":401635}}}";
    	JSONObject thing = new JSONObject(str);
    	return thing;
	}
	public JSONObject getLifeTime() throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

    
}