package ca.uwo.csd.cs2212.team12;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	public UserInfo(JSONObject lifeStats) throws JSONException{
		
		this.distanceBestDay = lifeStats.getJSONObject("best").getJSONObject("total").getJSONObject("distance").getString("date");
		this.floorsBestDay = lifeStats.getJSONObject("best").getJSONObject("total").getJSONObject("floors").getString("date");
		this.stepsBestDay = lifeStats.getJSONObject("best").getJSONObject("total").getJSONObject("steps").getString("date");
		this.distanceBestVal = lifeStats.getJSONObject("best").getJSONObject("total").getJSONObject("distance").getInt("value");
		this.floorsBestVal = lifeStats.getJSONObject("best").getJSONObject("total").getJSONObject("floors").getInt("value");
		this.stepsBestVal = lifeStats.getJSONObject("best").getJSONObject("total").getJSONObject("steps").getInt("value");

		this.distanceLife = lifeStats.getJSONObject("lifetime").getJSONObject("total").getInt("distance");
		this.floorsLife = lifeStats.getJSONObject("lifetime").getJSONObject("total").getInt("floors");
		this.stepsLife = lifeStats.getJSONObject("lifetime").getJSONObject("total").getInt("steps");;
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
