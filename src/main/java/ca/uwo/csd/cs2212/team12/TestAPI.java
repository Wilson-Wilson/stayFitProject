//package ca.uwo.csd.cs2212.team12;

/**
 * An API for offline testing of the StayFit application
 *
 * @author  Team 12
 * @version 1.0
 * @since   2016-02-27
 */

//<dependency>
//<groupId>org.json</groupId>
//<artifactId>json</artifactId>
//<version>20090211</version>
//</dependency>
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestAPI {

    /**
     * The JSON data to be used in the testing mode.
     */
    private static String jsonStr = "{\"summary\":{\"calories\":2300,\"activeMinutes\":119,\"sedentaryMinutes\":439,\"distance\":1324,\"floors\":14,\"steps\":14,\"lifetimeFloors\":1400,\"lifetimeSteps\":140321,\"lifetimeDistance\":14000,\"bestFloors\":21,\"bestSteps\":14000,\"bestDistance\":25000}}";
    private static JSONObject o = new JSONObject(jsonStr);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method is used to fetch the number of calories burned.
     * @return int This returns the number of calories burned.
     */
    public static int getCalBurned() {return getDat("calories");}

    /**
     * This method is used to fetch the number of active minutes.
     * @return int This returns the number of active minutes.
     */
    public static int getActiveMinutes() {return getDat("activeMinutes");}

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return int This returns the number of sedentary minutes.
     */
    public static int getSedentaryMinutes() {return getDat("sedentaryMinutes");}

    /**
     * This method is used to fetch the distance travelled.
     * @return int This returns the distance travelled.
     */
    public static int getDistance() {return getDat("distance");}

    /**
     * This method is used to fetch the number of floors climbed.
     * @return int This returns the number of floors climbed.
     */
    public static int getFloors() {return getDat("floors");}

    /**
     * This method is used to fetch the number of steps.
     * @return int This returns the number of steps.
     */
    public static int getSteps() {return getDat("steps");}

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return int This returns the number of floors climbed in total.
     */
    public static int getLifeTimeFloors() {return getDat("lifetimeFloors");}

    /**
     * This method is used to fetch the number of steps total.
     * @return int This returns the number of steps total.
     */
    public static int getLifetimeSteps() {return getDat("lifetimeSteps");}

    /**
     * This method is used to fetch the total distance travelled.
     * @return int This returns the total distance travelled.
     */
    public static int getLifetimeDistance() {return getDat("lifetimeDistance");}

    /**
     * This method is used to fetch the best number of floors climbed.
     * @return int This returns the best number of floors climbed.
     */
    public static int getBestFloors() {return getDat("bestFloors");}

    /**
     * This method is used to fetch the best number of steps.
     * @return int This returns the best number of steps.
     */
    public static int getBestSteps() {return getDat("bestSteps");}

    /**
     * This method is used to fetch the best distance travelled.
     * @return int This returns the best distance travelled.
     */
    public static int getBestDistance() {return getDat("bestDistance");}

    /**
     * This method searches the JSON object for the required value.
     * @param dat The value required from the JSON object
     * @return int The integer requested.
     */
    private static int getDat(String dat) {
        int integerData = 0;
        try {
            JSONObject element =  o.getJSONObject("summary");
            integerData = element.getInt(dat);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return integerData;
    }
}