package ca.uwo.csd.cs2212.team12;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * An API Stringerface for offline testing of the StayFit application
 *
 * @author  Team 12
 * @version 1.0
 * @since   2016-02-27
 */

public interface API {

    /**
     * This method is used to fetch the number of calories burned.
     * @return String This returns the number of calories burned.
     */
    public JSONObject getCalBurned() throws JSONException;

    /**
     * This method is used to fetch the number of active minutes.
     * @return JSONArray This returns the number of active minutes.
     */
    public JSONObject getActiveMinutes() throws JSONException;

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return JSONArray This returns the number of sedentary minutes.
     */
    public  JSONObject getSedentaryMinutes() throws JSONException;

    /**
     * This method is used to fetch the distance travelled.
     * @return JSONArray This returns the distance travelled.
     */

    public  JSONObject getDistance() throws JSONException;

    /**
     * This method is used to fetch the number of floors climbed.
     * @return JSONArray This returns the number of floors climbed.
     */
    
    public  JSONObject getFloors() throws JSONException;

    /**
     * This method is used to fetch the number of steps.
     * @return JSONArray This returns the number of steps.
     */

    public  JSONObject getSteps() throws JSONException;

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return JSONArray This returns the number of floors climbed in total.
     */

    public  JSONObject getLifeTime() throws JSONException;

    /**
     * This method is used to fetch the number of steps total.
     * @return JSONArray This returns the number of steps total.
     */
    public JSONObject getCalSeries() throws JSONException;

    /**
     * This method is used to fetch the total distance travelled.
     * @return JSONArray This returns the total distance travelled.
     */
    public  JSONObject getStepsSeries() throws JSONException;

    /**
     * This method is used to fetch the best number of steps.
     * @return JSONArray This returns the best number of steps.
     */
    public  JSONObject getFloorsSeries() throws JSONException;

    /**
     * This method is used to fetch the distance series.
     * @return JSONArray This returns the distance series.
     */
    public JSONObject getDistanceSeries() throws JSONException;
    
    /**
     * This method is used to fetch the heart rate series.
     * @return JSONArray This returns the distance series.
     */
    public JSONObject getHeartRateSeries() throws JSONException;
    
    /**
     * This method is used to fetch the sedentary minutes series.
     * @return JSONArray This returns the distance series.
     */
    public JSONObject getSedentaryMinutesSeries() throws JSONException;
    
    /**
     * This method is used to fetch the sedentary minutes series.
     * @return JSONArray This returns the distance series.
     */
    public JSONObject getActiveMinutesSeries() throws JSONException;
    
    /**
     * This method is used to fetch the user's daily goals.
     * @return JSONArray This returns the distance series.
     */
    public JSONObject getGoals() throws JSONException;

}