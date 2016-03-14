package ca.uwo.csd.cs2212.team12;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Calendar;

public class Controller {

	DataDict theDictionary;
	API theAPI;
	String currentDate;
	
	public static void changeDate(String newDate){
		if (!isWithinRange(newDate)){
			
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
	 * 
	 * 
	 */
	
	
	private static boolean isWithinRange(String newDate){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd", Locale.ENGLISH);
		
		
		//convert newdate to Date object
		//grab earliest date in dictionary
		
		//if newdate >= earliest && <= latest
			//	within range, return true
		//else false
		
	}
	
}

