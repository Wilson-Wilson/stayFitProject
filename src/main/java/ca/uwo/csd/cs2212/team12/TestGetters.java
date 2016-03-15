package ca.uwo.csd.cs2212.team12;

import java.util.Calendar;
import java.util.Date;

public class TestGetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dat = new Date();
		realAPI testVar = new realAPI(dat);

		realApi.setCalories();
		testVar.setSteps();
		testVar.setFloors();
		testVar.setSedMins();
		testVar.setFairlyMins();
		
	}

}
