package ca.uwo.csd.cs2212.team12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public static void changeDate(String newDate){
		if (!isWithinRange(newDate)){
			
			// update day data
			DataEntry  newDate = theDictionary.getDictionary();
			/* UI.setCaloriesVariable(newDate.getCalories) ;
			...
			*/
			
			
			//update week data
			if(isSameWeek()){
				
			}
			
			//update month data
			
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
	
	
	private static boolean isWithinRange(String theDate) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date newDate = sdf.parse(theDate);
    	Date earliest = sdf.parse(theDictionary.getEarliest());
    	Date latest = sdf.parse(theDictionary.getLatest());

    	if(newDate.compareTo(earliest)>=0 && newDate.compareTo(latest)<=0)
    		return true;
    	else
    		return false;
		
	}
	
	private static boolean isSameWeek(String newDate, String oldDate){
		//A week is defined as Sunday - Saturday
		
		//convert dates 
		
	}

	private static boolean isSameMonth(String newDate, String oldDate){
		
	}
}

