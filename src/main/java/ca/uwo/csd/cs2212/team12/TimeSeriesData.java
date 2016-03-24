package ca.uwo.csd.cs2212.team12;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
 /**
  * TimeSeriesData.java is a data structure class to store intraday TimeSeries data for the current day
 * @author Leo
 */
public class TimeSeriesData implements Serializable {
	
	public static ArrayList<DataPoint> caloriesSet;
	public static ArrayList<DataPoint> stepsSet;
	public static ArrayList<DataPoint> heartRateSet;
	public static ArrayList<DataPoint> distanceSet;
	public static ArrayList<DataPoint> floorsSet;
	public static ArrayList<DataPoint> SedentaryMinutesSet;
	public static ArrayList<DataPoint> ActiveMinutesSet;
	
	public ArrayList<DataPoint> saveCaloriesSet;
	public ArrayList<DataPoint> saveStepsSet;
	public ArrayList<DataPoint> saveHeartRateSet;
	public ArrayList<DataPoint> saveDistanceSet;
	public ArrayList<DataPoint> saveFloorsSet;
	public ArrayList<DataPoint> saveSedentaryMinutesSet;
	public ArrayList<DataPoint> saveActiveMinutesSet;
	
	/**
	 * @return the saveCaloriesSet
	 */
	public ArrayList<DataPoint> getSaveCaloriesSet() {
		return saveCaloriesSet;
	}

	/**
	 * @param saveCaloriesSet the saveCaloriesSet to set
	 */
	public void setSaveCaloriesSet(ArrayList<DataPoint> saveCaloriesSet) {
		this.saveCaloriesSet = saveCaloriesSet;
	}

	/**
	 * @return the saveStepsSet
	 */
	public ArrayList<DataPoint> getSaveStepsSet() {
		return saveStepsSet;
	}

	/**
	 * @param saveStepsSet the saveStepsSet to set
	 */
	public void setSaveStepsSet(ArrayList<DataPoint> saveStepsSet) {
		this.saveStepsSet = saveStepsSet;
	}

	/**
	 * @return the saveHeartRateSet
	 */
	public ArrayList<DataPoint> getSaveHeartRateSet() {
		return saveHeartRateSet;
	}

	/**
	 * @param saveHeartRateSet the saveHeartRateSet to set
	 */
	public void setSaveHeartRateSet(ArrayList<DataPoint> saveHeartRateSet) {
		this.saveHeartRateSet = saveHeartRateSet;
	}

	/**
	 * @return the saveDistanceSet
	 */
	public ArrayList<DataPoint> getSaveDistanceSet() {
		return saveDistanceSet;
	}

	/**
	 * @param saveDistanceSet the saveDistanceSet to set
	 */
	public void setSaveDistanceSet(ArrayList<DataPoint> saveDistanceSet) {
		this.saveDistanceSet = saveDistanceSet;
	}

	/**
	 * @return the saveFloorsSet
	 */
	public ArrayList<DataPoint> getSaveFloorsSet() {
		return saveFloorsSet;
	}

	/**
	 * @param saveFloorsSet the saveFloorsSet to set
	 */
	public void setSaveFloorsSet(ArrayList<DataPoint> saveFloorsSet) {
		this.saveFloorsSet = saveFloorsSet;
	}

	/**
	 * @return the saveSedentaryMinutesSet
	 */
	public ArrayList<DataPoint> getSaveSedentaryMinutesSet() {
		return saveSedentaryMinutesSet;
	}

	/**
	 * @param saveSedentaryMinutesSet the saveSedentaryMinutesSet to set
	 */
	public void setSaveSedentaryMinutesSet(ArrayList<DataPoint> saveSedentaryMinutesSet) {
		this.saveSedentaryMinutesSet = saveSedentaryMinutesSet;
	}

	/**
	 * @return the saveActiveMinutesSet
	 */
	public ArrayList<DataPoint> getSaveActiveMinutesSet() {
		return saveActiveMinutesSet;
	}

	/**
	 * @param saveActiveMinutesSet the saveActiveMinutesSet to set
	 */
	public void setSaveActiveMinutesSet(ArrayList<DataPoint> saveActiveMinutesSet) {
		this.saveActiveMinutesSet = saveActiveMinutesSet;
	}

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
	 * Sets the attribute caloriesSet
	 * @param ArrayList<DataPoint> calSet
	 */
	
	public static void setCaloriesSet(ArrayList<DataPoint> calSet){
		caloriesSet=calSet;
	}
	
	/**
	 * Returns the attribute stepsSet
	 * @return static ArrayList<DataPoint> variable stepsSet
	 */
	public static ArrayList<DataPoint> getStepsSet(){
		return stepsSet;
	}
	
	/**
	 * Sets the attribute stepsSet
	 * @param ArrayList<DataPoint> steps
	 */
	
	public static void setStepsSet(ArrayList<DataPoint> steps){
		stepsSet=steps;
	}
	
	/**
	 * Returns the attribute heartRateSet
	 * @return static ArrayList<DataPoint> variable heartRateSet
	 */
	public static ArrayList<DataPoint> getHeartRateSet(){
		return heartRateSet;
	}
	
	/**
	 * Sets the attribute heartRateSet
	 * @param ArrayList<DataPoint> heartSet
	 */
	
	public static void setHeartRateSet(ArrayList<DataPoint> heartSet){
		heartRateSet=heartSet;
	}
	
	/**
	 * Returns the attribute distanceSet
	 * @return static ArrayList<DataPoint> variable distanceSet
	 */
	public static ArrayList<DataPoint> getDistanceSet(){
		return distanceSet;
	}
	
	/**
	 * Sets the attribute distanceSet
	 * @param ArrayList<DataPoint> distSet
	 */
	
	public static void setDistanceSet(ArrayList<DataPoint> distSet){
		distanceSet=distSet;
	}
	
	/**
	 * Returns the attribute floorsSet
	 * @return static ArrayList<DataPoint> variable floorsSet
	 */
	public static ArrayList<DataPoint> getFloorsSet(){
		return floorsSet;
	}
	
	/**
	 * Sets the attribute floorsSet
	 * @param ArrayList<DataPoint> floors
	 */
	
	public static void setFloorsSet(ArrayList<DataPoint> floors){
		floorsSet=floors;
	}
	
	/**
	 * Returns the attribute SedentaryMinutesSet
	 * @return static ArrayList<DataPoint> variable SedentaryMinutesSet
	 */
	public static ArrayList<DataPoint> getSedentaryMinutesSet(){
		return SedentaryMinutesSet;
	}
	
	/**
	 * Sets the attribute SedentaryMinutesSet
	 * @param ArrayList<DataPoint> sedSet
	 */
	
	public static void setSedentaryMinutesSet(ArrayList<DataPoint> sedSet){
		caloriesSet=sedSet;
	}
	
	/**
	 * Returns the attribute ActiveMinutesSet
	 * @return static ArrayList<DataPoint> variable ActiveMinutesSet
	 */
	public static ArrayList<DataPoint> getActiveMinutesSet(){
		return ActiveMinutesSet;
	}
	
	/**
	 * Sets the attribute ActiveMinutesSet
	 * @param ArrayList<DataPoint> actSet
	 */
	
	public static void setActiveMinutesSet(ArrayList<DataPoint> actSet){
		caloriesSet=actSet;
	}

}
