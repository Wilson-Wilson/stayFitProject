package ca.uwo.csd.cs2212.team12;

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
    public String getCalBurned();

    /**
     * This method is used to fetch the number of active minutes.
     * @return String This returns the number of active minutes.
     */
    public String getActiveMinutes();

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return String This returns the number of sedentary minutes.
     */
    public String getSedentaryMinutes();

    /**
     * This method is used to fetch the distance travelled.
     * @return String This returns the distance travelled.
     */
    public String getDistance();

    /**
     * This method is used to fetch the number of floors climbed.
     * @return String This returns the number of floors climbed.
     */
    public String getFloors();

    /**
     * This method is used to fetch the number of steps.
     * @return String This returns the number of steps.
     */
    public String getSteps();

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return String This returns the number of floors climbed in total.
     */
    public String getLifeTime();
    
}