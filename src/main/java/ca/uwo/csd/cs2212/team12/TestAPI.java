package ca.uwo.csd.cs2212.team12;
import org.json.JSONObject;

import java.util.Date;

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
    public  JSONArray getCalBurned() throws JSONException {return new JSONArray(new Integer(getDat("calories")).toString());}

    /**
     * This method is used to fetch the number of active minutes.
     * @return JSONArray This returns the number of active minutes.
     */
    public  JSONArray getActiveMinutes() throws JSONException {return new JSONArray(new Integer(getDat("activeMinutes")).toString());}

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return String This returns the number of sedentary minutes.
     */
    public  JSONArray getSedentaryMinutes() throws JSONException {return new JSONArray(new Integer(getDat("sedentaryMinutes")).toString());}

    /**
     * This method is used to fetch the distance travelled.
     * @return JSONArray This returns the distance travelled.
     */
    public  JSONArray getDistance() throws JSONException {return new JSONArray(new Integer(getDat("distance")).toString());}

    /**
     * This method is used to fetch the number of floors climbed.
     * @return JSONArray This returns the number of floors climbed.
     */
    public  JSONArray getFloors() throws JSONException {return new JSONArray(new Integer(getDat("floors")).toString());}

    /**
     * This method is used to fetch the number of steps.
     * @return JSONArray This returns the number of steps.
     */
    public  JSONArray getSteps() throws JSONException {return new JSONArray(new Integer(getDat("steps")).toString());}

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return JSONArray This returns the number of floors climbed in total.
     */
    public  JSONArray getLifeTimeFloors() throws JSONException {return new JSONArray(new Integer(getDat("lifetimeFloors")).toString());}

    /**
     * This method is used to fetch the number of steps total.
     * @return String This returns the number of steps total.
     */
    public  JSONArray getLifetimeSteps() throws JSONException {return new JSONArray(new Integer(getDat("lifetimeSteps")).toString());}

    /**
     * This method is used to fetch the total distance travelled.
     * @return JSONArray This returns the total distance travelled.
     */
    public  JSONArray getLifetimeDistance() throws JSONException {return new JSONArray(new Integer(getDat("lifetimeDistance")).toString());}

    /**
     * This method is used to fetch the best number of floors climbed.
     * @return JSONArray This returns the best number of floors climbed.
     */
    public  JSONArray getBestFloors() throws JSONException {return new JSONArray(new Integer(getDat("bestFloors")).toString());}

    /**
     * This method is used to fetch the best number of steps.
     * @return JSONArray This returns the best number of steps.
     */
    public  JSONArray getBestSteps() throws JSONException {return new JSONArray(new Integer(getDat("bestSteps")).toString());}

    /**
     * This method is used to fetch the best distance travelled.
     * @return String This returns the best distance travelled.
     */
    public  JSONArray getBestDistance() throws JSONException {return new JSONArray(new Integer(getDat("bestDistance")).toString());}
    
    //for the sake of the interface
    public JSONArray getLifeTime() throws JSONException{return null;}

    /**
     * This method searches the JSON object for the required value.
     * @param dat The value required from the JSON object
     * @return int The integer requested.
     */
    private  int getDat(String dat) {
        int integerData = 0;
        try {
            String jsonStr = "{\"summary\":{\"calories\":2300,\"activeMinutes\":119,\"sedentaryMinutes\":439,\"distance\":1324,\"floors\":14,\"steps\":14,\"lifetimeFloors\":1400,\"lifetimeSteps\":140321,\"lifetimeDistance\":14000,\"bestFloors\":21,\"bestSteps\":14000,\"bestDistance\":25000}}";
            JSONObject o = new JSONObject(jsonStr);
            JSONObject element =  o.getJSONObject("summary");
            integerData = element.getInt(dat);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return integerData;
    }

    public JSONArray getDistanceSeries() throws JSONException{
		// TODO Auto-generated method stub
		return null;
	}

    public JSONArray getStepsSeries() throws JSONException{
		// TODO Auto-generated method stub
		return null;
	}

    public JSONArray getCalSeries() throws JSONException{
		// TODO Auto-generated method stub
		return null;
	}

    public JSONArray getFloorsSeries() throws JSONException{
		// TODO Auto-generated method stub
		return null;
	}
    
    public JSONArray getHeartRateSeries() throws JSONException{
		// TODO Auto-generated method stub
		return null;
	}
    
    public JSONArray getGoals() throws JSONException{
		// TODO Auto-generated method stub
		return null;
	}

    
}