package ca.uwo.csd.cs2212.team12;
import org.json.JSONObject;
import org.json.JSONArray;
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
    public  String getCalBurned() {return new Integer(getDat("calories")).toString();}

    /**
     * This method is used to fetch the number of active minutes.
     * @return String This returns the number of active minutes.
     */
    public  String getActiveMinutes() {return new Integer(getDat("activeMinutes")).toString();}

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return String This returns the number of sedentary minutes.
     */
    public  String getSedentaryMinutes() {return new Integer(getDat("sedentaryMinutes")).toString();}

    /**
     * This method is used to fetch the distance travelled.
     * @return String This returns the distance travelled.
     */
    public  String getDistance() {return new Integer(getDat("distance")).toString();}

    /**
     * This method is used to fetch the number of floors climbed.
     * @return String This returns the number of floors climbed.
     */
    public  String getFloors() {return new Integer(getDat("floors")).toString();}

    /**
     * This method is used to fetch the number of steps.
     * @return String This returns the number of steps.
     */
    public  String getSteps() {return new Integer(getDat("steps")).toString();}

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return String This returns the number of floors climbed in total.
     */
    public  String getLifeTimeFloors() {return new Integer(getDat("lifetimeFloors")).toString();}

    /**
     * This method is used to fetch the number of steps total.
     * @return String This returns the number of steps total.
     */
    public  String getLifetimeSteps() {return new Integer(getDat("lifetimeSteps")).toString();}

    /**
     * This method is used to fetch the total distance travelled.
     * @return String This returns the total distance travelled.
     */
    public  String getLifetimeDistance() {return new Integer(getDat("lifetimeDistance")).toString();}

    /**
     * This method is used to fetch the best number of floors climbed.
     * @return String This returns the best number of floors climbed.
     */
    public  String getBestFloors() {return new Integer(getDat("bestFloors")).toString();}

    /**
     * This method is used to fetch the best number of steps.
     * @return String This returns the best number of steps.
     */
    public  String getBestSteps() {return new Integer(getDat("bestSteps")).toString();}

    /**
     * This method is used to fetch the best distance travelled.
     * @return String This returns the best distance travelled.
     */
    public  String getBestDistance() {return new Integer(getDat("bestDistance")).toString();}
    
    //for the sake of the interface
    public String getLifeTime(){return null;}

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

}