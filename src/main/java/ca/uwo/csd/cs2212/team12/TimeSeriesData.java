package ca.uwo.csd.cs2212.team12;

import org.json.JSONArray;
import org.json.JSONException;
 /**
  * TimeSeriesData.java is a data structure class to store intraday TimeSeries data for the current day
 * @author Leo
 */
public class TimeSeriesData {
	
	private static DataPoint [] caloriesSet;
	private static DataPoint [] stepsSet;
	private static DataPoint [] heartRateSet;
	private static DataPoint [] distanceSet;
	private static DataPoint [] floorsSet;
	
	private static final long serialVersionUID= 1L;
	
	/**
	 * Main Constructor method for TimeSeries Data. Each set is has 1440 indices, each representing a minute
	 * in a day.
	 * @param calData JSONArray of calories data
	 * @param stepsData JSONArray of steps data
	 * @param heartRateData JSONArray of heart rate data
	 * @param distanceData JSONArray of distance data
	 * @param floorsData JSONArray of floors data
	 * 
	 * @throws JSONException
	 */
	public TimeSeriesData(JSONArray calData, JSONArray stepsData, JSONArray heartRateData, JSONArray distanceData, JSONArray floorsData) throws JSONException{
		this.caloriesSet = new DataPoint [1440];
		this.stepsSet = new DataPoint [1440]; 
		this.heartRateSet = new DataPoint [1440]; 
		this.distanceSet = new DataPoint [1440];
		this.floorsSet = new DataPoint [1440]; 
		DataPoint addCal, addSteps, addHeartRate, addDistance, addFloors;
		
		for(int i=0; i < 1440; i++){
			addCal = new DataPoint (calData.getJSONArray(1).getJSONArray(1).getJSONObject(i));
			addSteps = new DataPoint (stepsData.getJSONArray(1).getJSONArray(1).getJSONObject(i));
			addHeartRate = new DataPoint(heartRateData.getJSONArray(1).getJSONArray(0).getJSONObject(i));
			addDistance = new DataPoint (distanceData.getJSONArray(1).getJSONArray(1).getJSONObject(i));
			addFloors = new DataPoint (floorsData.getJSONArray(1).getJSONArray(1).getJSONObject(i));
			
			caloriesSet[i] = addCal;
			stepsSet[i] = addSteps;
			heartRateSet[i] = addHeartRate;
			distanceSet[i] = addDistance;
			floorsSet[i] = addFloors;
		}
	}
	
	/**
	 * Returns the attribute caloriesSet
	 * @return static DataPoint [] variable caloriesSet
	 */
	public static DataPoint[] getCaloriesSet(){
		return caloriesSet;
	}
	
	/**
	 * Returns the attribute stepsSet
	 * @return static DataPoint [] variable stepsSet
	 */
	public static DataPoint[] getStepsSet(){
		return stepsSet;
	}
	
	/**
	 * Returns the attribute heartRateSet
	 * @return static DataPoint [] variable heartRateSet
	 */
	public static DataPoint[] getHeartRateSet(){
		return heartRateSet;
	}
	
	/**
	 * Returns the attribute distanceSet
	 * @return static DataPoint [] variable distanceSet
	 */
	public static DataPoint[] getDistanceSet(){
		return distanceSet;
	}
	
	/**
	 * Returns the attribute floorsSet
	 * @return static DataPoint [] variable floorsSet
	 */
	public static DataPoint[] getFloorsSet(){
		return floorsSet;
	}

}
