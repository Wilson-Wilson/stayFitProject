package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;

public class DataEntry implements Serializable {

	/**
	 * The data entries.
	 */
	private int calBurned;
	private int distanceTravelled;
	private int floorsClimbed;
	private int stepsTaken;
	private int actMins;
	private int sedMins;
	private String date;
	private static final long serialVersionUID= 1L;
	
	/**
	 * Takes integers representing the user's fitness data, and stores them.
	 * @param cal This is the number of calories burned by the user.
	 * @param dist This is the distance travelled by the user.
	 * @param floors This is the number of floors climbed by the user.
	 * @param steps This is the number of steps taken by the user.
	 * @param actMinutes This is the user's number of active minutes.
	 * @param sedMinutes This is the user's number of sedentary minutes.
	 * @param theDate This is the date at which the previous values were recorded.
	 */
	public DataEntry(int cal, int dist, int floors, int steps, int actMinutes, int sedMinutes, String theDate){
			 calBurned= cal;
			 distanceTravelled= dist;
			 floorsClimbed= floors;
			 stepsTaken= steps;
			 actMins= actMinutes;
			 sedMins= sedMinutes;
			 date= theDate;
	}

	/**
	 * The default constructor for the DataEntry class.
	 */
	public DataEntry(){
		calBurned=0;
		distanceTravelled= 0;
		floorsClimbed= 0;
		stepsTaken= 0;
		actMins= 0;
		sedMins= 0;
		date= null;
	}

	/**
	* This method returns the number of calories burned.
	* @return int This is the value of calBurned
	*/
	public int getCalBurned() {
		return calBurned;
	}

	/**
	* This method sets the number of calories burned.
	*/
	public void setCalBurned(int calBurned) {
		this.calBurned = calBurned;
	}

	/**
	* This method returns the distance travelled by the user.
	* @return int This is the value of distanceTravelled
	*/
	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	/**
	* This method sets the distance travelled by the user.
	*/
	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	/**
	* This method returns the number of floors climbed by the user
	* @return int This is the value of floorsClimbed.
	*/
	public int getFloorsClimbed() {
		return floorsClimbed;
	}

	/**
	* This method sets the number of floors climbed by the user.
	*/
	public void setFloorsClimbed(int floorsClimbed) {
		this.floorsClimbed = floorsClimbed;
	}

	/**
	* This method returns the number of steps taken by the user.
	* @return int This is the value of stepsTaken.
	*/
	public int getStepsTaken() {
		return stepsTaken;
	}

	/**
	* This method sets the number of steps taken by the user.
	*/
	public void setStepsTaken(int stepsTaken) {
		this.stepsTaken = stepsTaken;
	}

	/**
	* This method returns the number of active minutes.
	* @return int This is the value of actMins.
	*/
	public int getActMins() {
		return actMins;
	}

	/**
	* This method sets the number of active minutes.
	*/
	public void setActMins(int actMins) {
		this.actMins = actMins;
	}

	/**
	* This method returns the number of sedentary minutes.
	* @return int This is the value of sedMins.
	*/
	public int getSedMins() {
		return sedMins;
	}

	/**
	* This method sets the number of sedentary minutes.
	*/
	public void setSedMins(int sedMins) {
		this.sedMins = sedMins;
	}

	/**
	* This method returns the date at which the data entries were recorded.
	* @return String This is the value of the date.
	*/
	public String getDate() {
		return date;
	}

	/**
	* This method sets the date at which the data entries were recorded.
	*/
	public void setDate(String date) {
		this.date = date;
	}
}