package ca.uwo.csd.cs2212.team12;

import java.util.Calendar;
import java.util.Date;

public class TestGetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dat = new Date();
		RealAPI testVar = new RealAPI(dat);

		testVar.setCalories();
		testVar.getResults();
		testVar.setSteps();
		testVar.getResults();
		testVar.setFloors();
		testVar.getResults();
		testVar.setSedMins();
		testVar.getResults();
		testVar.setFairlyMins();
		testVar.getResults();
		testVar.getGoals();
		testVar.getResults();
		testVar.setLifetime();
		testVar.getResults();
		testVar.setGoals();
		testVar.getGoals();
		testVar.getResults();
		
	}

}
