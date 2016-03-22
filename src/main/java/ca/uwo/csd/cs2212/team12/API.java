package ca.uwo.csd.cs2212.team12;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;

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
    public JSONArray getCalBurned() throws JSONException;

    /**
     * This method is used to fetch the number of active minutes.
     * @return JSONArray This returns the number of active minutes.
     */
    public JSONArray getActiveMinutes() throws JSONException;

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return JSONArray This returns the number of sedentary minutes.
     */
    public  JSONArray getSedentaryMinutes() throws JSONException;

    /**
     * This method is used to fetch the distance travelled.
     * @return JSONArray This returns the distance travelled.
     */

    public  JSONArray getDistance() throws JSONException;

    /**
     * This method is used to fetch the number of floors climbed.
     * @return JSONArray This returns the number of floors climbed.
     */
    
    public  JSONArray getFloors() throws JSONException;

    /**
     * This method is used to fetch the number of steps.
     * @return JSONArray This returns the number of steps.
     */

    public  JSONArray getSteps() throws JSONException;

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return JSONArray This returns the number of floors climbed in total.
     */

    public  JSONArray getLifeTime() throws JSONException;

    /**
     * This method is used to fetch the number of steps total.
     * @return JSONArray This returns the number of steps total.
     */
    public JSONArray getCalSeries() throws JSONException;

    /**
     * This method is used to fetch the total distance travelled.
     * @return JSONArray This returns the total distance travelled.
     */
    public  JSONArray getStepsSeries() throws JSONException;

    /**
     * This method is used to fetch the best number of steps.
     * @return JSONArray This returns the best number of steps.
     */
    public  JSONArray getFloorsSeries() throws JSONException;

    /**
     * This method is used to fetch the distance series.
     * @return JSONArray This returns the distance series.
     */
    public JSONArray getDistanceSeries() throws JSONException;
    
    
    public JSONArray getHeartRateSeries() throws JSONException;

}