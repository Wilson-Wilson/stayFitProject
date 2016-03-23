package ca.uwo.csd.cs2212.team12;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class DataPoint implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int value;
	private String time;
	
	
	/**
	 * Constructor method for a DataPoint, an object to represent the x and y coordinate of the TimeSeries Graphs.
	 * The constructor takes JSONObject dataPoint and parses it into its int value and String time elements.
	 * @param dataPoint is a JSONObject carrying the value and time values.
	 * @throws JSONException
	 */
	public DataPoint (JSONObject dataPoint) throws JSONException{
		this.value = dataPoint.getInt("value");
		this.time = dataPoint.getString("time");
	}
	
	public DataPoint(){
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String getTime(){
		return this.time;
	}
}
