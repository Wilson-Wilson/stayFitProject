package ca.uwo.csd.cs2212.team12;

import org.json.JSONArray;
import org.json.JSONException;
 /**
  * TimeSeriesData.java is a data structure class to store intraday TimeSeries data for the current day
 * @author Leo
 */
public class TimeSeriesData {
	
	/**
	 *  each "Set" is an int array with 1440 values, representing each minute within a day
	 *  serialVersionUTD will be used for serialization purposes
	 */
	private static int [] caloriesSet;
	private static int [] stepsSet;
	private static int [] heartRateSet;
	private static int [] distanceSet;
	private static final long serialVersionUID= 1L;
	
	/**
	 * Main Constructor method for TimeSeries Data.
	 * @param calData JSONArray of calories data
	 * @param stepsData JSONArray of steps data
	 * @param heartRateData JSONArray of heart rate data
	 * @param distanceData JSONArray of distance data
	 * @throws JSONException
	 */
	public TimeSeriesData(JSONArray calData, JSONArray stepsData, JSONArray heartRateData, JSONArray distanceData) throws JSONException{
		this.caloriesSet = new int [1440]; 
		int addCal, addSteps, addHeartRate, addDistance;
		
		for(int i=0; i < 1440; i++){
			addCal = calData.getJSONObject(i).getInt("value");
			addSteps = stepsData.getJSONObject(i).getInt("value");
			addHeartRate = heartRateData.getJSONObject(i).getInt("value");
			addDistance = distanceData.getJSONObject(i).getInt("value");
			
			caloriesSet[i] = addCal;
			stepsSet[i] = addSteps;
			heartRateSet[i] = addHeartRate;
			distanceSet[i] = addDistance;
		}
	}
	
	/**
	 * Returns the attribute caloriesSet
	 * @return static int [] variable caloriesSet
	 */
	public static int[] getCaloriesSet(){
		return caloriesSet;
	}
	
	/**
	 * Returns the attribute stepsSet
	 * @return static int [] variable stepsSet
	 */
	public static int[] getStepsSet(){
		return stepsSet;
	}
	
	/**
	 * Returns the attribute heartRateSet
	 * @return static int [] variable heartRateSet
	 */
	public static int[] getHeartRateSet(){
		return heartRateSet;
	}
	
	/**
	 * Returns the attribute distanceSet
	 * @return static int [] variable distanceSet
	 */
	public static int[] getDistanceSet(){
		return distanceSet;
	}

}
