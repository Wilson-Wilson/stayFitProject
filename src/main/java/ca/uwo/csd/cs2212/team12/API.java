package ca.uwo.csd.cs2212.team12;

/**
 * An API interface for offline testing of the StayFit application
 *
 * @author  Team 12
 * @version 1.0
 * @since   2016-02-27
 */

public interface API {

    /**
     * This method is used to fetch the number of calories burned.
     * @return int This returns the number of calories burned.
     */
    public int getCalBurned();

    /**
     * This method is used to fetch the number of active minutes.
     * @return int This returns the number of active minutes.
     */
    public int getActiveMinutes();

    /**
     * This method is used to fetch the number of sedentary minutes.
     * @return int This returns the number of sedentary minutes.
     */
    public  int getSedentaryMinutes();

    /**
     * This method is used to fetch the distance travelled.
     * @return int This returns the distance travelled.
     */
    public  int getDistance();

    /**
     * This method is used to fetch the number of floors climbed.
     * @return int This returns the number of floors climbed.
     */
    public  int getFloors();

    /**
     * This method is used to fetch the number of steps.
     * @return int This returns the number of steps.
     */
    public  int getSteps();

    /**
     * This method is used to fetch the number of floors climbed in total.
     * @return int This returns the number of floors climbed in total.
     */
    public  int getLifeTimeFloors();

    /**
     * This method is used to fetch the number of steps total.
     * @return int This returns the number of steps total.
     */
    public  int getLifetimeSteps();

    /**
     * This method is used to fetch the total distance travelled.
     * @return int This returns the total distance travelled.
     */
    public  int getLifetimeDistance();

    /**
     * This method is used to fetch the best number of floors climbed.
     * @return int This returns the best number of floors climbed.
     */
    public  int getBestFloors();

    /**
     * This method is used to fetch the best number of steps.
     * @return int This returns the best number of steps.
     */
    public  int getBestSteps();

    /**
     * This method is used to fetch the best distance travelled.
     * @return int This returns the best distance travelled.
     */
    public  int getBestDistance();


}