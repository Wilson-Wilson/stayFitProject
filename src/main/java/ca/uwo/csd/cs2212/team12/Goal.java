package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;

public class Goal implements Serializable{

 private int stepGoal;
 private int floorGoal;
 private int distGoal;
 private int calGoal;
 private String date;

 private static final long serialVersionUID= 1L;

  public Goal(int step, int floor, int distance, int calories, String theDate){
    stepGoal=step;
    floorGoal=floor;
    distGoal=distance;
    calGoal=calories;
    date=theDate;
  }

  public Goal(){
    stepGoal=0;
    floorGoal=0;
    distGoal=0;
    calGoal=0;
    date="";
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
	public int getDistGoal() {
		return distGoal;
	}

	/**
	* Sets new value of distGoal
	* @param
	*/
	public void setDistGoal(int distGoal) {
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

	/**
	* Returns value of date
	* @return
	*/
	public String getDate() {
		return date;
	}

	/**
	* Sets new value of date
	* @param
	*/
	public void setDate(String date) {
		this.date = date;
	}

	/**
	* Returns value of serialVersionUID
	* @return
	*/
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
