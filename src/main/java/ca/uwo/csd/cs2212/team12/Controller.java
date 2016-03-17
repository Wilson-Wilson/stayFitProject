package ca.uwo.csd.cs2212.team12;
;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.omg.CORBA.INITIALIZE;

public class Controller {

	private static DataDict theDictionary;
	private API theAPI;
	//private UI, theUI
	
	//Add UI parameter and create initializeController() method that creates 
	//a controller object and calls onStartUp()
	public Controller(API theAPI, DataDict theDictionary){
		this.theAPI = theAPI;
		this.theDictionary = theDictionary;		
	}
	
	public static void changeDate(String newer, String older){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		LocalDate newDate = LocalDate.parse(newer, formatter);
		LocalDate oldDate = LocalDate.parse(older, formatter);
		
		if (!isWithinRange(newDate)){
			
			// update day data
			DataEntry  theDay = theDictionary.getDictionary();
			/* UI.setCaloriesVariable(newDate.getCalories) ;
			...
			*/
			
			//update week data
			if(isSameWeek(newDate, oldDate)){
				
			}
			
			//update month data
			if(isSameMonth(newDate, oldDate){
				
			}
			
			//update data from UserInfo class
		}
		
	}
	/**
	 * 
	 * When will the application require the API?
	 * 
	 * Application starts up w internet
	 * 
	 * User presses refresh
	 * User changes date
	 * Application closes
	 */
	
	/**
	 * 
	 * When will the application require the local data?
	 * 
	 * Application starts up without internet
	 * User changes date
	 */
	
	/**
	 * When will the application require serialization shit?
	 * 
	 * 
	 * Application starts up
	 * Application closes
	 * @throws ParseException 
	 * 
	 * 
	 */
	
	
	private static boolean isWithinRange(LocalDate theDate){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		
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
		
		LocalDate startOfWeek;
		LocalDate endOfWeek;
		
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

