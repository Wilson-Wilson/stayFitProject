package ca.uwo.csd.cs2212.team12;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 /**
  * TimeSeriesData.java is a data structure class to store intraday TimeSeries data for the current day
 * @author Leo
 */
public class TimeSeriesData {
	
	private static ArrayList<DataPoint> caloriesSet;
	private static ArrayList<DataPoint> stepsSet;
	private static ArrayList<DataPoint> heartRateSet;
	private static ArrayList<DataPoint> distanceSet;
	private static ArrayList<DataPoint> floorsSet;
	private static ArrayList<DataPoint> SedentaryMinutesSet;
	private static ArrayList<DataPoint> ActiveMinutesSet;
	
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
	public TimeSeriesData(JSONObject calData, JSONObject stepsData, JSONObject heartRateData, JSONObject distanceData, JSONObject floorsData, JSONObject SedentaryData, JSONObject ActiveData) throws JSONException{
		caloriesSet = new ArrayList<DataPoint>();
		stepsSet = new ArrayList<DataPoint>(); 
		heartRateSet = new ArrayList<DataPoint>(); 
		distanceSet = new ArrayList<DataPoint>();
		floorsSet = new ArrayList<DataPoint>();
		SedentaryMinutesSet = new ArrayList<DataPoint>();
		ActiveMinutesSet = new ArrayList<DataPoint>();
				
		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			caloriesSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}

/*		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			stepsSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			heartRateSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			distanceSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			floorsSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			SedentaryMinutesSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").length(); i++){
			ActiveMinutesSet.add(new DataPoint (calData.getJSONObject("activities-log-calories-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}*/
		
		for(int i = 0; i < stepsData.getJSONObject("activities-log-steps-intraday").getJSONArray("dataset").length(); i++){
			stepsSet.add(new DataPoint (stepsData.getJSONObject("activities-log-steps-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < floorsData.getJSONObject("activities-log-floors-intraday").getJSONArray("dataset").length(); i++){
			floorsSet.add(new DataPoint (floorsData.getJSONObject("activities-log-floors-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < distanceData.getJSONObject("activities-log-distance-intraday").getJSONArray("dataset").length(); i++){
			distanceSet.add(new DataPoint (distanceData.getJSONObject("activities-log-distance-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < SedentaryData.getJSONObject("activities-log-minutesSedentary-intraday").getJSONArray("dataset").length(); i++){
			SedentaryMinutesSet.add(new DataPoint (SedentaryData.getJSONObject("activities-log-minutesSedentary-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < ActiveData.getJSONObject("activities-log-minutesFairlyActive-intraday").getJSONArray("dataset").length(); i++){
			ActiveMinutesSet.add(new DataPoint(ActiveData.getJSONObject("activities-log-minutesFairlyActive-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
		
		for(int i = 0; i < heartRateData.getJSONObject("activities-heart-intraday").getJSONArray("dataset").length(); i++){
			heartRateSet.add(new DataPoint(heartRateData.getJSONObject("activities-heart-intraday").getJSONArray("dataset").getJSONObject(i)));			
		}
	}
	
	public TimeSeriesData(){
	}
	/**
	 * Returns the attribute caloriesSet
	 * @return static ArrayList<DataPoint> variable caloriesSet
	 */
	public static ArrayList<DataPoint> getCaloriesSet(){
		return caloriesSet;
	}
	
	/**
	 * Returns the attribute stepsSet
	 * @return static ArrayList<DataPoint> variable stepsSet
	 */
	public static ArrayList<DataPoint> getStepsSet(){
		return stepsSet;
	}
	
	/**
	 * Returns the attribute heartRateSet
	 * @return static ArrayList<DataPoint> variable heartRateSet
	 */
	public static ArrayList<DataPoint> getHeartRateSet(){
		return heartRateSet;
	}
	
	/**
	 * Returns the attribute distanceSet
	 * @return static ArrayList<DataPoint> variable distanceSet
	 */
	public static ArrayList<DataPoint> getDistanceSet(){
		return distanceSet;
	}
	
	/**
	 * Returns the attribute floorsSet
	 * @return static ArrayList<DataPoint> variable floorsSet
	 */
	public static ArrayList<DataPoint> getFloorsSet(){
		return floorsSet;
	}
	
	/**
	 * Returns the attribute SedentaryMinutesSet
	 * @return static ArrayList<DataPoint> variable SedentaryMinutesSet
	 */
	public static ArrayList<DataPoint> getSedentaryMinutesSet(){
		return SedentaryMinutesSet;
	}
	
	/**
	 * Returns the attribute ActiveMinutesSet
	 * @return static ArrayList<DataPoint> variable ActiveMinutesSet
	 */
	public static ArrayList<DataPoint> getActiveMinutesSet(){
		return ActiveMinutesSet;
	}

}
