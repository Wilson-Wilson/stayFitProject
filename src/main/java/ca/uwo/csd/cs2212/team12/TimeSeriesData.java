package ca.uwo.csd.cs2212.team12;

import org.json.JSONArray;
import org.json.JSONException;

public class TimeSeriesData {
	
	private int [] caloriesSet;
	private int [] stepsSet;
	private int [] heartRateSet;
	private int [] distanceSet;
	private static final long serialVersionUID= 1L;
	
	public TimeSeriesData(JSONArray calData, JSONArray stepsData, JSONArray heartRateData, JSONArray distanceData) throws JSONException{
		this.caloriesSet = new int [1440]; 
		int addCal, addSteps, addHeartRate, addDistance;
		
		for(int i=0; i < 1440; i++){
			addCal = calData.getJSONObject(i).getInt("value");
			addSteps = stepsData.getJSONObject(i).getInt("value");
			addHeartRate = heartRateData.getJSONObject(i).getInt("value");
			addDistance = distanceData.getJSONObject(i).getInt("value");
			
			this.caloriesSet[i] = addCal;
			this.stepsSet[i] = addSteps;
			this.heartRateSet[i] = addHeartRate;
			this.distanceSet[i] = addDistance;
		}
	}
	
	public int[] getCaloriesSet(){
		return this.caloriesSet;
	}
	
	public int[] getStepsSet(){
		return this.stepsSet;
	}
	
	public int[] getHeartRateSet(){
		return this.heartRateSet;
	}
	
	public int[] getDistanceSet(){
		return this.distanceSet;
	}

}
