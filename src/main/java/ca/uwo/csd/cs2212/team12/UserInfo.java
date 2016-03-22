package ca.uwo.csd.cs2212.team12;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo implements Serializable {

	private static final long serialVersionUID= 1L;

	private int distanceLife;
	private int floorsLife;
	private int stepsLife;
	private String distanceBest;
	private String floorsBest;
	private String stepsBest;

	/**
	 * Creates the UserInfo Object that stores information from API calls.
	 * @param pref Preferences the Preference object for the custom dashboard.
	 * @throws JSONException 
	 */
	public UserInfo(Preferences pref, JSONObject lifeTotals, JSONArray bestDays) throws JSONException{
		
		this.distanceLife = lifeTotals.getInt("distance");
		this.floorsLife = lifeTotals.getInt("floors");
		this.stepsLife = lifeTotals.getInt("steps");;
		this.distanceBest = bestDays.getJSONObject(1).getString("date");
		this.floorsBest = bestDays.getJSONObject(2).getString("date");;
		this.stepsBest = bestDays.getJSONObject(3).getString("date");;
	}

	/**
	 * Constructor for UserInfo without params.
	 */
	public UserInfo(){
	}

	/**
	* This method returns the value of distanceLife.
	* @return int This returns the value of distanceLife.
	*/
	public int getDistanceLife() {
		return this.distanceLife;
	}

	/**
	* This method sets this.distanceLife to distanceLife.
	* @param distanceLife int The new distanceLife.
	*/
	public void setDistanceLife(int distanceLife) {
		this.distanceLife = distanceLife;
	}

	/**
	* This method returns the value of floorsLife.
	* @return int This returns the value of floorsLife.
	*/
	public int getFloorsLife() {
		return this.floorsLife;
	}

	/**
	* This method sets this.floorsLife to floorsLife.
	* @param floorsLife int The new floorsLife.
	*/
	public void setFloorsLife(int floorsLife) {
		this.floorsLife = floorsLife;
	}

	/**
	* This method returns the value of stepsLife.
	* @return int This returns the value of stepsLife.
	*/
	public int getStepsLife() {
		return this.stepsLife;
	}

	/**
	* This method sets this.stepsLife to stepsLife.
	* @param stepsLife int The new stepsLife.
	*/
	public void setStepsLife(int stepsLife) {
		this.stepsLife = stepsLife;
	}
	
	/**
	* This method returns the value of distanceBest.
	* @return String This returns the value of distanceBest.
	*/
	public String getDistanceBest(){
		return this.distanceBest;
	}
	
	/**
	* This method returns the value of floorsBest.
	* @return String This returns the value of floorsBest.
	*/
	public String getFloorsBest(){
		return this.floorsBest;
	}
	
	/**
	* This method returns the value of stepsBest.
	* @return String This returns the value of stepsBest.
	*/
	public String getStepsBest(){
		return this.stepsBest;
	}

}
