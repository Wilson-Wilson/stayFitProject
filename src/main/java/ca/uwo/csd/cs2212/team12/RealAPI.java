package ca.uwo.csd.cs2212.team12;

/**
 * An API for offline real use of the StayFit application
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

public class RealAPI implements API {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method is used to fetch the number of calories burned.
     * @return int This returns the number of calories burned.
     */
    public  int getCalBurned() {return 0;}

    /**
     * This method is used to fetch the number of active minutes.
     * @return int This returns the number of active minutes.
     */
    public  int getActiveMinutes() {return 0;}

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return int This returns the number of sedentary minutes.
     */
    public  int getSedentaryMinutes() {return 0;}

    /**
     * This method is used to fetch the distance travelled.
     * @return int This returns the distance travelled.
     */
    public  int getDistance() {return 0;}

    /**
     * This method is used to fetch the number of floors climbed.
     * @return int This returns the number of floors climbed.
     */
    public  int getFloors() {return 0;}

    /**
     * This method is used to fetch the number of steps.
     * @return int This returns the number of steps.
     */
    public  int getSteps() {return 0;}

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return int This returns the number of floors climbed in total.
     */
    public  int getLifeTimeFloors() {return 0;}

    /**
     * This method is used to fetch the number of steps total.
     * @return int This returns the number of steps total.
     */
    public  int getLifetimeSteps() {return 0;}

    /**
     * This method is used to fetch the total distance travelled.
     * @return int This returns the total distance travelled.
     */
    public  int getLifetimeDistance() {return 0;}

    /**
     * This method is used to fetch the best number of floors climbed.
     * @return int This returns the best number of floors climbed.
     */
    public  int getBestFloors() {return 0;}

    /**
     * This method is used to fetch the best number of steps.
     * @return int This returns the best number of steps.
     */
    public  int getBestSteps() {return 0;}

    /**
     * This method is used to fetch the best distance travelled.
     * @return int This returns the best distance travelled.
     */
    public  int getBestDistance() {return 0;}

    /**
     * This method searches the JSON object for the required value.
     * @param dat The value required from the JSON object
     * @return int The integer requested.
     */
    private int getDat(String dat) {
        return 0;
    }
}