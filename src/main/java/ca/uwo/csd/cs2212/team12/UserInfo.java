package ca.uwo.csd.cs2212.team12;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;

public class UserInfo implements Serializable {

	private static final long serialVersionUID= 1L;

	private String distanceBestDay;
	private String floorsBestDay;
	private String stepsBestDay;
	private int distanceBestVal;
	private int floorsBestVal;
	private int stepsBestVal;
	private int distanceLife;
	private int floorsLife;
	private int stepsLife;

	/**
	 * Constructor that creates the UserInfo Object that stores information from API calls.
	 * @param lifeTotals The JSONObject containing the user's lifetime totals.
	 * @param bestDays The JSONArray containing the user's best days.
	 * @throws JSONException 
	 */
	public UserInfo(JSONArray lifeStats) throws JSONException{
		
		this.distanceBestDay = lifeStats.getJSONArray(0).getJSONArray(0).getJSONObject(1).getString("date");
		this.floorsBestDay = lifeStats.getJSONArray(0).getJSONArray(0).getJSONObject(2).getString("date");
		this.stepsBestDay = lifeStats.getJSONArray(0).getJSONArray(0).getJSONObject(3).getString("date");
		this.distanceBestVal = lifeStats.getJSONArray(0).getJSONArray(0).getJSONObject(1).getInt("value");
		this.floorsBestVal = lifeStats.getJSONArray(0).getJSONArray(0).getJSONObject(2).getInt("value");
		this.stepsBestVal = lifeStats.getJSONArray(0).getJSONArray(0).getJSONObject(3).getInt("value");

		this.distanceLife = lifeStats.getJSONArray(1).getJSONObject(0).getInt("distance");
		this.floorsLife = lifeStats.getJSONArray(1).getJSONObject(0).getInt("floors");
		this.stepsLife = lifeStats.getJSONArray(1).getJSONObject(0).getInt("steps");;
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
	* This method returns the value of floorsLife.
	* @return int This returns the value of floorsLife.
	*/
	public int getFloorsLife() {
		return this.floorsLife;
	}

	/**
	* This method returns the value of stepsLife.
	* @return int This returns the value of stepsLife.
	*/
	public int getStepsLife() {
		return this.stepsLife;
	}
	
	/**
	* This method returns the value of distanceBestDay.
	* @return String This returns the value of distanceBestDay.
	*/
	public String getDistanceBestDay(){
		return this.distanceBestDay;
	}
	
	/**
	* This method returns the value of floorsBestDay.
	* @return String This returns the value of floorsBestDay.
	*/
	public String getFloorsBestDay(){
		return this.floorsBestDay;
	}
	
	/**
	* This method returns the value of stepsBest.
	* @return String This returns the value of stepsBest.
	*/
	public String getStepsBestDay(){
		return this.stepsBestDay;
	}
	
	/**
	* This method returns the value of distanceBestVal.
	* @return int This returns the value of distanceBestVal.
	*/
	public int getDistanceBestVal(){
		return this.distanceBestVal;
	}

	/**
	* This method returns the value of floorsBestVal.
	* @return int This returns the value of floorsBestVal.
	*/
	public int getFloorsBestVal(){
		return this.floorsBestVal;
	}

	/**
	* This method returns the value of stepsBestVal.
	* @return int This returns the value of stepsBestVal.
	*/
	public int getStepsBestVal(){
		return this.stepsBestVal;
	}

}
