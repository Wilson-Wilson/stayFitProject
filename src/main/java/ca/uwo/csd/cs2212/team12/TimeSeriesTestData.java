package ca.uwo.csd.cs2212.team12;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
 /**
  * TimeSeriesData.java is a data structure class to store intraday TimeSeries data for the current day
 * @author Leo
 */
public class TimeSeriesTestData {
	
	private static ArrayList<DataPoint> caloriesSet;
	private static ArrayList<DataPoint> stepsSet;
	private static ArrayList<DataPoint> heartRateSet;
	private static ArrayList<DataPoint> distanceSet;
	private static ArrayList<DataPoint> floorsSet;
	private static ArrayList<DataPoint> SedentaryMinutesSet;
	private static ArrayList<DataPoint> ActiveMinutesSet;
	
	private static final long serialVersionUID= 1L;
	
	
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
