package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;

public class DailyGoals implements Serializable{
	
	 private int stepGoal;
	 private int floorGoal;
	 private float distGoal;
	 private int calGoal;
	 private static final long serialVersionUID= 1L;

	 public DailyGoals(JSONObject goals) throws JSONException{
	    stepGoal=goals.getJSONObject("goals").getInt("steps");
	    floorGoal=goals.getJSONObject("goals").getInt("floors");
	    distGoal=BigDecimal.valueOf(goals.getJSONObject("goals").getDouble("distance")).floatValue();
	    calGoal=goals.getJSONObject("goals").getInt("caloriesOut");
	  }
	
	 public DailyGoals(){
	 }
	
	/**
	* Returns value of stepGoal
	* @return
	*/
	public int getStepGoal() {
		return stepGoal;
	}
	
	/**
	* Sets new value of stepGoal
	* @param
	*/
	public void setStepGoal(int stepGoal) {
		this.stepGoal = stepGoal;
	}
	
	/**
	* Returns value of floorGoal
	* @return
	*/
	public int getFloorGoal() {
		return floorGoal;
	}
	
	/**
	* Sets new value of floorGoal
	* @param
	*/
	public void setFloorGoal(int floorGoal) {
		this.floorGoal = floorGoal;
	}
	
	/**
	* Returns value of distGoal
	* @return
	*/
	public float getDistGoal() {
		return distGoal;
	}
	
	/**
	* Sets new value of distGoal
	* @param
	*/
	public void setDistGoal(float distGoal) {
		this.distGoal = distGoal;
	}
	
	/**
	* Returns value of calGoal
	* @return
	*/
	public int getCalGoal() {
		return calGoal;
	}
	
	/**
	* Sets new value of calGoal
	* @param
	*/
	public void setCalGoal(int calGoal) {
		this.calGoal = calGoal;
	}

}



