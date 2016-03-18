package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;

public class DataEntry implements Serializable {

	private int calBurned;
	private int distanceTravelled;
	private int floorsClimbed;
	private int stepsTaken;
	private int actMins;
	private int sedMins;
	private String date;
	
	/**
	 * Takes integers and stores them
	 * @param cal
	 * @param dist
	 * @param floors
	 * @param steps
	 * @param actMinutes
	 * @param sedMinutes
	 * @param theDate
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
	* Returns value of calBurned
	* @return
	*/
	public int getCalBurned() {
		return calBurned;
	}

	/**
	* Sets new value of calBurned
	* @param
	*/
	public void setCalBurned(int calBurned) {
		this.calBurned = calBurned;
	}

	/**
	* Returns value of distanceTravelled
	* @return
	*/
	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	/**
	* Sets new value of distanceTravelled
	* @param
	*/
	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	/**
	* Returns value of floorsClimbed
	* @return
	*/
	public int getFloorsClimbed() {
		return floorsClimbed;
	}

	/**
	* Sets new value of floorsClimbed
	* @param
	*/
	public void setFloorsClimbed(int floorsClimbed) {
		this.floorsClimbed = floorsClimbed;
	}

	/**
	* Returns value of stepsTaken
	* @return
	*/
	public int getStepsTaken() {
		return stepsTaken;
	}

	/**
	* Sets new value of stepsTaken
	* @param
	*/
	public void setStepsTaken(int stepsTaken) {
		this.stepsTaken = stepsTaken;
	}

	/**
	* Returns value of actMins
	* @return
	*/
	public int getActMins() {
		return actMins;
	}

	/**
	* Sets new value of actMins
	* @param
	*/
	public void setActMins(int actMins) {
		this.actMins = actMins;
	}

	/**
	* Returns value of sedMins
	* @return
	*/
	public int getSedMins() {
		return sedMins;
	}

	/**
	* Sets new value of sedMins
	* @param
	*/
	public void setSedMins(int sedMins) {
		this.sedMins = sedMins;
	}

	/**
	* Returns value of date
	* @return
	*/
	public String getDate() {
		return date;
	}

	/**
	* Sets new value of date
	* @param
	*/
	public void setDate(String date) {
		this.date = date;
	}
}
