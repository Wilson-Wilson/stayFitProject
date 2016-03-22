package ca.uwo.csd.cs2212.team12;

import org.json.JSONException;
import org.json.JSONObject;

public class DataPoint {
	
	private int value;
	private String time;
	
	public DataPoint (JSONObject dataPoint) throws JSONException{
		this.value = dataPoint.getInt("value");
		this.time = dataPoint.getString("time");
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String getTime(){
		return this.time;
	}
}
