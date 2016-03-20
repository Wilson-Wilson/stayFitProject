package ca.uwo.csd.cs2212.team12;

import org.json.JSONArray;
import org.json.JSONException;

public class TimeSeriesData {
	
	private static int [] caloriesSet;
	private static int [] stepsSet;
	private static int [] heartRateSet;
	private static int [] distanceSet;
	private static final long serialVersionUID= 1L;
	
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
	
	public static int[] getCaloriesSet(){
		return caloriesSet;
	}
	
	public static int[] getStepsSet(){
		return stepsSet;
	}
	
	public static int[] getHeartRateSet(){
		return heartRateSet;
	}
	
	public static int[] getDistanceSet(){
		return distanceSet;
	}

}
