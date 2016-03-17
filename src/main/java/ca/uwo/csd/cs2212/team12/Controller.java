package ca.uwo.csd.cs2212.team12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.omg.CORBA.INITIALIZE;

public class Controller {

	private static DataDict theDictionary;
	private API theAPI;
	//private UI, theUI
	
	//Add UI parameter and create initializeController() method in Stayfit that creates 
	//a controller object and calls onStartUp()
	public Controller(API theAPI, DataDict theDictionary){
		this.theAPI = theAPI;
		this.theDictionary = theDictionary;		
	}
	
	public void changeDate(String newer, String older){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate newDate = LocalDate.parse(newer, formatter);
		LocalDate oldDate = LocalDate.parse(older, formatter);
		
		if (!isWithinRange(newDate)){
			
			// update day data
			int [] dayValues = getDayData(newDate); 
			/* 
			 * UI.setCaloriesVariable(dayValues[0]);
			*/
			
			//update week data if different week
			if(!isSameWeek(newDate, oldDate)){
				int[] weekValues = getWeekData(newDate);
				/*UI.setCaloriesVariable(weekValues[0]);
				...
				*/
			}
			
			//update month data if different month
			if(!isSameMonth(newDate, oldDate)){
				int[] monthValues = getMonthData(newDate);
				/*UI.setCaloriesVariable(weekValues[0]);
				...
				*/
			}

			
			//update data from UserInfo class
		}
		
	}
	
	public void refresh(){
	}
	
	public void onStartUp(){
		//Call API if connects
		//refresh dictionary
		
		//If no connect restore serialized data
	}
	
	public void onClose(){
		
		//serialize current dictionary, accolades/goal and user prefs
		
	}
	
	public void pushGoals(){
		
	}
	
	private static int[] getDayData(LocalDate theDate){
		
		int [] dayValues = new int[6];
		
		String dayString = theDate.toString();
		DataEntry theDay = theDictionary.getDictionary().get(dayString);
		
		dayValues[0] = theDay.getCalBurned();
		dayValues[1] = theDay.getDistanceTravelled();
		dayValues[2] = theDay.getFloorsClimbed();
		dayValues[3] = theDay.getStepsTaken();
		dayValues[4] = theDay.getActMins();
		dayValues[5] = theDay.getSedMins();
		
		return dayValues;
		
	}
	
	private static int[] getWeekData(LocalDate theDate){
		
		LocalDate dayObject;
		String dayString;
		DataEntry currentDay;
		int i;
		int [] weekValues = new int[6];
		
		//Find the Sunday in the same week as the newer date
		switch(theDate.getDayOfWeek()){
			case SUNDAY:	dayObject = theDate;
							break;
			case MONDAY:	dayObject = theDate.minusDays(1);
			 			 	break;
			case TUESDAY:	dayObject = theDate.minusDays(2);
			 			 	break;
			case WEDNESDAY:	dayObject = theDate.minusDays(3);
			 				break;
			case THURSDAY:	dayObject = theDate.minusDays(4);
							break;	
			case FRIDAY:	dayObject = theDate.minusDays(5);
							break;
			case SATURDAY:	dayObject = theDate.minusDays(6);
							break;
			default:		break;
		}
		
		dayString = dayObject.toString();
		
		for (i = 0; i < 7; i++){
			
			currentDay = theDictionary.getDictionary.get(dayString);
			
			weekValues[0] += currentDay.getCalBurned();
			weekValues[1] += currentDay.getDistanceTravelled();
			weekValues[2] += currentDay.getFloorsClimbed();
			weekValues[3] += currentDay.getStepsTaken();
			weekValues[4] += currentDay.getActMins();
			weekValues[5] += currentDay.getSedMins();
			
			dayObject.plusDays(1);
			dayString = dayObject.toString();
			
		}
		return weekValues;
	}
	
	private static int[] getMonthData(LocalDate theDate){
		
		LocalDate dayObject;
		String dayString;
		DataEntry currentDay;
		int [] monthValues = new int[6];
		int currentMonth = theDate.getMonthValue();
		
		//get first day of the month
		dayObject = theDate.withDayOfMonth(1);
		
		while(dayObject.getMonthValue()==currentMonth){
			
			currentDay = theDictionary.getDictionary.get(dayString);
			
			monthValues[0] += currentDay.getCalBurned();
			monthValues[1] += currentDay.getDistanceTravelled();
			monthValues[2] += currentDay.getFloorsClimbed();
			monthValues[3] += currentDay.getStepsTaken();
			monthValues[4] += currentDay.getActMins();
			monthValues[5] += currentDay.getSedMins();
			
			dayObject.plusDays(1);
			dayString = dayObject.toString();
			
		}
	}
	
	private static boolean isWithinRange(LocalDate theDate){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
    	LocalDate earliest = LocalDate.parse(theDictionary.getEarliest(), formatter);
    	LocalDate latest = LocalDate.parse(theDictionary.getLatest(), formatter);
    	

    	if(theDate.isAfter(earliest) && theDate.isBefore(latest))
    		return true;
    	else if (theDate.isEqual(earliest) || theDate.isEqual(latest))
    		return true;
    	else
    		return false;
    	
	}
	
	private static boolean isSameWeek(LocalDate newer, LocalDate older){
		//A week is defined as Sunday - Saturday
		
		LocalDate startOfWeek = null, endOfWeek = null;
		
		//Define the Sunday and Saturday corresponding to the week of the older date
		switch(older.getDayOfWeek()){
			case SUNDAY:	startOfWeek = older;
							endOfWeek = older.plusDays(6);
							break;
			case MONDAY:	startOfWeek = older.minusDays(1);
			 			 	endOfWeek = older.plusDays(5);
			 			 	break;
			case TUESDAY:	startOfWeek = older.minusDays(2);
			 			 	endOfWeek = older.plusDays(4);
			 			 	break;
			case WEDNESDAY:	startOfWeek = older.minusDays(3);
			 				endOfWeek = older.plusDays(3);
			 				break;
			case THURSDAY:	startOfWeek = older.minusDays(4);
							endOfWeek = older.plusDays(2);
							break;	
			case FRIDAY:	startOfWeek = older.minusDays(5);
							endOfWeek = older.plusDays(1);
							break;
			case SATURDAY:	startOfWeek = older.minusDays(6);
							endOfWeek = older;
							break;
			default:		break;

		}
	
		//Perform a range test on the newer date
		if(newer.isAfter(startOfWeek) && newer.isBefore(endOfWeek))
    		return true;
    	else if (newer.isEqual(startOfWeek) || newer.isEqual(endOfWeek))
    		return true;
    	else
    		return false;
	
	}

	private static boolean isSameMonth(LocalDate newer, LocalDate older){
		
		if(newer.getYear() == older.getYear() && newer.getMonth() == older.getMonth()){
			return true;
		}
		else
			return false;
		
	}
}

