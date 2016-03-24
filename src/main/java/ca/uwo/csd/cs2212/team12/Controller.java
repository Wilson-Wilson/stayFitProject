package ca.uwo.csd.cs2212.team12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Controller.java handles all of the back-end logic between the local data, user interface and api classes.
 * @author Leo
 */
public class Controller implements Serializable{

	private static DataDict theDictionary;
	private static API theAPI;
	private static UserInfo theUserInfo;
	private static TimeSeriesData theTimeSeries;
	private static Preferences thePreferences;
	private static AccoDict	theAccoDict;
	private static DailyGoals theDailyGoals;
	//private UI theUI
	
	private static final long serialVersionUID= 1L;
	private static final String DATADICT= "datadict.boop";
	private static final String TIMESERIES= "timeseries.boop";
	private static final String USERINFO= "userinfo.boop";
	private static final String PREFERENCES= "preferences.boop";
	private static final String GOALS="dailygoals.boop";	
	
	/**
	 * Constructor that creates Controller object from apiParam. 
	 * The method is only used in StayFit.java with onStartUp() defined below.
	 * @param apiParam 
	 */
	//Add UI parameter and create initializeController() method in Stayfit that creates 
		//a controller object and calls onStartUp()
	public Controller(API apiParam){
		theAPI = apiParam;		
	}
	
	
	/**
	 * This method refreshes the user interface with the data relating to the newly 
	 * selected date.
	 * If there is no internet connection available, but the new date is within the range of theDictionary
	 * all data except for the time series view will be updated.
	 * If there is no internet connection available and the new date is out of range, then the view will not update.
	 * @param newer String representing the newly selected date.
	 * @param older String representing the current date.
	 * @throws JSONException 
	 * @throws ParseException 
	 */
	public void changeDate(String newer, String older) throws JSONException, ParseException{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate newDate = LocalDate.parse(newer, formatter);
		LocalDate oldDate = LocalDate.parse(older, formatter);
		
		if(testInet()){	
			
			theAPI = new RealAPI(newer);
			JSONArray timeCal = theAPI.getCalSeries();
			JSONArray timeSteps = theAPI.getStepsSeries();
			JSONArray timeHeartRate = theAPI.getHeartRateSeries();
			JSONArray timeDistance = theAPI.getCalSeries();
			JSONArray timeFloors = theAPI.getFloorsSeries();
			JSONArray timeSedentary = theAPI.getSedentaryMinutesSeries();
			JSONArray timeActive = theAPI.getActiveMinutesSeries();
			theTimeSeries = new TimeSeriesData (timeCal, timeSteps, timeHeartRate, timeDistance, timeFloors, timeSedentary, timeActive);
			
			if (!isWithinRange(newDate)){
				JSONArray dictCal = theAPI.getCalBurned();
				JSONArray dictDist = theAPI.getDistance();
				JSONArray dictFloors = theAPI.getFloors();
				JSONArray dictSteps = theAPI.getSteps();
				JSONArray dictActive = theAPI.getActiveMinutes();
				JSONArray dictSedentary = theAPI.getSedentaryMinutes();
						
				theDictionary = new DataDict(dictCal, dictDist, dictFloors, dictSteps, dictActive, dictSedentary);
			}
		}
		
		int [] dayValues = getDayData(newDate); 
		/* 
		 * UI.setCaloriesVariable(dayValues[0]);
		*/
		
		if(!isSameWeek(newDate, oldDate)){
			int[] weekValues = getWeekData(newDate);
			/*UI.setCaloriesVariable(weekValues[0]);
			...
			*/
		}
		
		if(!isSameMonth(newDate, oldDate)){
			int[] monthValues = getMonthData(newDate);
			/*UI.setCaloriesVariable(weekValues[0]);
			...
			*/
		}
		
		accoCheck(newDate);
		goalsCheck(newDate);
		
	}


	/**
	 * This method is called to initialize the data in the view of the StayFit application.
	 * Preference and goal related data persist through sessions.
	 * 
	 * In the test mode:
	 * Date changing will be disabled, and the views will be populated using the data available in TestAPI.
	 * 
	 * In the regular mode:
	 * If there is internet connection available, the method will make the appropriate API calls 
	 * to instantiate the data-related classes.
	 * If there is no internet connection available, theDictionary, theTimeSeries and theUserInfo 
	 * will be restored from last session's serialized data. If there is no data available,
	 * the application will not start.
	 * 
	 * @throws IOException
	 * @throws ParseException 
	 * @throws JSONException 
	 */
	public static void onStartUp() throws IOException, ParseException, JSONException{
		
		
		
		File c = new File("preferences.boop");
		if (c.exists()){
			Preferences pref = loadPreferences();
			
			System.out.println(pref.isSaveBestDaysCard());
			System.out.println(pref.isSaveCaloriesCard());
			
			Preferences.showBestDaysCard=pref.isSaveBestDaysCard();
			Preferences.showCaloriesCard=pref.isSaveCaloriesCard();
			Preferences.showMovementsCard=pref.isSaveMovementsCard();
			Preferences.showMinutesCard=pref.isSaveMinutesCard();
			Preferences.showLifetimeCard=pref.isSaveLifetimeCard();
			Preferences.showTimeSeriesCard=pref.isSaveTimeSeriesCard();
		}
		else{
			Preferences.setAllTrue();
		}
		
		File d = new File("dailygoals.boop");
		if (d.exists()){
			theDailyGoals = loadGoals();
		}
		
		LocalDate now = LocalDate.now();
		String curDate = now.toString();
		
		if(testInet()){
			
			theAPI = new RealAPI(curDate);
			
			JSONArray timeCal = theAPI.getCalSeries();
			JSONArray timeSteps = theAPI.getStepsSeries();
			JSONArray timeHeartRate = theAPI.getHeartRateSeries();
			JSONArray timeDistance = theAPI.getCalSeries();
			JSONArray timeFloors = theAPI.getFloorsSeries();
			JSONArray timeSedentary = theAPI.getSedentaryMinutesSeries();
			JSONArray timeActive = theAPI.getActiveMinutesSeries();
			theTimeSeries = new TimeSeriesData (timeCal, timeSteps, timeHeartRate, timeDistance, timeFloors, timeSedentary, timeActive);
			
			JSONArray lifeStats = theAPI.getLifeTime();
			theUserInfo = new UserInfo(lifeStats);
			
			JSONArray dictCal = theAPI.getCalBurned();
			JSONArray dictDist = theAPI.getDistance();
			JSONArray dictFloors = theAPI.getFloors();
			JSONArray dictSteps = theAPI.getSteps();
			JSONArray dictActive = theAPI.getActiveMinutes();
			JSONArray dictSedentary = theAPI.getSedentaryMinutes();
			theDictionary = new DataDict(dictCal, dictDist, dictFloors, dictSteps, dictActive, dictSedentary);
			
			JSONObject dailyGoals = theAPI.getGoals();
			theDailyGoals = new DailyGoals(dailyGoals);
		}
		else{
			File f = new File("datadict.boop"),g = new File("timeseries.boop"),h = new File("userinfo.boop");
			
			if(f.exists() && g.exists() && h.exists()) { 
				theDictionary = loadDataDict();
				theUserInfo = loadUserInfo();
				
				
				theTimeSeries = loadTimeSeries();
				TimeSeriesData.caloriesSet=theTimeSeries.getSaveCaloriesSet();
				TimeSeriesData.distanceSet=theTimeSeries.getSaveDistanceSet();
				TimeSeriesData.stepsSet=theTimeSeries.getSaveStepsSet();
				TimeSeriesData.heartRateSet=theTimeSeries.getSaveHeartRateSet();
				TimeSeriesData.floorsSet=theTimeSeries.getSaveFloorsSet();
				TimeSeriesData.ActiveMinutesSet=theTimeSeries.getSaveActiveMinutesSet();
				TimeSeriesData.SedentaryMinutesSet=theTimeSeries.getSaveSedentaryMinutesSet();
				
			}
			else{
				System.exit(2);   //Close application: ERROR you have neither Internet or serialized data!
			}				
		}
		
		AccoDict theAccoDict = new AccoDict();
		//accoCheck(now);
		//goalsCheck(now);
	}
	
	/**
	 * This method serializes all data-related instance variables.
	 * The method is disabled in test mode.
	 */
	public static void onClose(){
		//instantiate static classes
		
		Preferences savePref= new Preferences();
		savePref.setSaveBestDaysCard(Preferences.showBestDaysCard);
		savePref.setSaveCaloriesCard(Preferences.showCaloriesCard);
		savePref.setSaveLifetimeCard(Preferences.showLifetimeCard);
		savePref.setSaveMinutesCard(Preferences.showMinutesCard);
		savePref.setSaveMovementsCard(Preferences.showMovementsCard);
		savePref.setSaveTimeSeriesCard(Preferences.showTimeSeriesCard);
		
		
		
		TimeSeriesData saveSeries= new TimeSeriesData();
		saveSeries.setSaveCaloriesSet(TimeSeriesData.caloriesSet);
		saveSeries.setSaveDistanceSet(TimeSeriesData.distanceSet);
		saveSeries.setSaveStepsSet(TimeSeriesData.stepsSet);
		saveSeries.setSaveHeartRateSet(TimeSeriesData.heartRateSet);
		saveSeries.setSaveFloorsSet(TimeSeriesData.floorsSet);
		saveSeries.setSaveActiveMinutesSet(TimeSeriesData.ActiveMinutesSet);
		saveSeries.setSaveSedentaryMinutesSet(TimeSeriesData.SedentaryMinutesSet);
		
		storeDataDict(theDictionary);
		storeUserInfo(theUserInfo);
		storeGoals(theDailyGoals);
		
		storeTimeSeries(saveSeries);
		storePreferences(savePref);
		
		
	}
	 
	/**
	 * This method returns an int array with each index representing a different type of 
	 * data corresponding to the date parameter.
	 * 0 - calories
	 * 1 - distance
	 * 2 - floors
	 * 3 - steps
	 * 4 - active minutes
	 * 5 - sedentary minutes
	 * @param theDate the date to retrieve data from.
	 * @return int [] the array containing the data values of the theDate.
	 */
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
	
	/**
	 * This method returns an int array with each index representing a different type of 
	 * data, identical to getDayData. The values are the sums from the week linked to theDate parameter.
	 * @param theDate the Date belonging to the week whose values are being queried.
	 * @return int [] the array containing the weekly sum values
	 */
	private static int[] getWeekData(LocalDate theDate){
		
		LocalDate dayObject = null;
		String dayString;
		DataEntry currentDay;
		int i;
		int [] weekValues = new int[6];
		
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
			
			if (theDictionary.getDictionary().get(dayString) != null)
			{
				currentDay = theDictionary.getDictionary().get(dayString);
				
				weekValues[0] += currentDay.getCalBurned();
				weekValues[1] += currentDay.getDistanceTravelled();
				weekValues[2] += currentDay.getFloorsClimbed();
				weekValues[3] += currentDay.getStepsTaken();
				weekValues[4] += currentDay.getActMins();
				weekValues[5] += currentDay.getSedMins();
			}
			dayObject.plusDays(1);
			dayString = dayObject.toString();
			
		}
		return weekValues;
	}
	
	/**
	 * This method returns an int array with each index representing a different type of 
	 * data, identical to getDayData. The values are the sums from the month linked to theDate parameter.
	 * @param theDate the Date belonging to the month whose values are being queried.
	 * @return int [] the array containing the month sum values
	 */
	private static int[] getMonthData(LocalDate theDate){
		
		LocalDate dayObject;
		String dayString;
		DataEntry currentDay;
		int [] monthValues = new int[6];
		int currentMonth = theDate.getMonthValue();
		
		dayObject = theDate.withDayOfMonth(1);
		dayString = dayObject.toString();
		
		while(dayObject.getMonthValue()==currentMonth){
			
			if(theDictionary.getDictionary().get(dayString)!= null)
			{
				currentDay = theDictionary.getDictionary().get(dayString);
				
				monthValues[0] += currentDay.getCalBurned();
				monthValues[1] += currentDay.getDistanceTravelled();
				monthValues[2] += currentDay.getFloorsClimbed();
				monthValues[3] += currentDay.getStepsTaken();
				monthValues[4] += currentDay.getActMins();
				monthValues[5] += currentDay.getSedMins();
			}
			dayObject.plusDays(1);
			dayString = dayObject.toString();
			
		}
		return monthValues;
	}
	
	/**
	 * This method returns a boolean value indicating if theDate is within theDictionary's range.
	 * If the key returns a null value, it does not exist within theDictionary and the method returns false.
	 * Otherwise it returns true.
	 * @param theDate The date to test if it is within theDictionary's range.
	 * @return boolean The indicator if the date is within the range or not.
	 */
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
	
	/**
	 * This method compares if newer is in the same week as older. The method returns
	 * a boolean value indicating the test result. A week is defined as Sunday - Saturday
	 * @param newer The date to test if it is within range.
	 * @param older The "anchoring date" that determine's the week's range.
	 * @return boolean The indicator if the newer is within the range or not.
	 */
	private static boolean isSameWeek(LocalDate newer, LocalDate older){
		
		LocalDate startOfWeek = null, endOfWeek = null;
		
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

		if(newer.isAfter(startOfWeek) && newer.isBefore(endOfWeek))
    		return true;
    	else if (newer.isEqual(startOfWeek) || newer.isEqual(endOfWeek))
    		return true;
    	else
    		return false;
	
	}
	
	/**
	 * This method compares if newer is in the same month as older. The method returns
	 * a boolean value indicating the test result.
	 * @param newer The date to test if it is within range.
	 * @param older The "anchoring date" that determine's the month range.
	 * @return boolean The indicator if the newer is within the range or not.
	 */
	private static boolean isSameMonth(LocalDate newer, LocalDate older){
		
		if(newer.getYear() == older.getYear() && newer.getMonth() == older.getMonth()){
			return true;
		}
		else
			return false;
		
	}
	
	/**
	 * This method runs a check on the daily data values associated with theDate to determine if the 
	 * user is eligible for the predefined accolades.
	 * If so, the accolade's obtained variable is set to true, and is displayed on the user interface
	 * to indicate achievement. If not, then the accolade remains hidden.
	 * 
	 * @param theDate The date to perform the accolade check on.
	 */
	private static void accoCheck(LocalDate theDate){
		
		int [] dayValues = getDayData(theDate);

		for (int i = 0; i < 20; i++){
			  
			  Accolade acco = theAccoDict.getList()[i];
			  
			  if (acco.getType().equals("steps") && dayValues[3] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("calories") && dayValues[0] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("distance") && dayValues[1] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("floors") && dayValues[2] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("activeMins") && dayValues[4] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else {
				  if(acco.getType().equals("sedentaryMins") && dayValues[5] >= acco.getThreshold()){
					  acco.setObtained(true);
				  }
			  }
		  }
		//update UI
	}
	
	private static void goalsCheck(LocalDate theDate) {
		
		int [] dayValues = getDayData(theDate);
		
		if(theDailyGoals.getStepGoal() > dayValues[3]){
			//update UI
		}
		
		if(theDailyGoals.getFloorGoal() > dayValues[2]){
			//update UI
		}
		if(theDailyGoals.getDistGoal() > dayValues[1]){
			//update UI
		}
		if(theDailyGoals.getCalGoal() > dayValues[0]){
			//update UI
		}
		
	}
	
	/**
	 * This method determines if internet connection is present.
	 * @return boolean Indicates true, if internet connection is available and false if not.
	 */
	private static boolean testInet() {
	    Socket sock = new Socket();
	    InetSocketAddress addr = new InetSocketAddress("google.ca",80);
	    try {
	        sock.connect(addr,3000);
	        return true;
	    } catch (IOException e) {
	        return false;
	    } finally {
	        try {sock.close();}
	        catch (IOException e) {}
	    }
	}

	/**This method is used to persist DataDict object between runs.
	 * @param dat the DataDict to be stored/serialized to a file
	 */
	private static void storeDataDict(DataDict dat){
	    try{
	      ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(DATADICT));
	      out.writeObject(dat);
	      out.close();
	     } 
	    catch(IOException e){
		    System.out.println("DataDict could not be saved to disk. IO error occured.");
		    e.printStackTrace();
		 }
	 }

   /**
    * This method loads serialized objects from a file
    */
   private static DataDict loadDataDict(){
	    try{
	      ObjectInputStream in= new ObjectInputStream( new FileInputStream(DATADICT));
	      DataDict data= (DataDict) in.readObject();
	      in.close();
	      return data;
	    } 
	    catch (IOException e){
		    System.out.println("DataDict could not be loaded from disk. IO error occured.");
		    e.printStackTrace();
		  }
		catch (ClassNotFoundException e){
			System.out.println("Class could not be Found!");
	        e.printStackTrace();
		}
		return null;
    }
   
   /**
    * This method is used to persist TimeSeriesData object between runs.
    * 
    * @param dat the TimeSeriesData to be stored/serialized to a file
    */
    private static void storeTimeSeries(TimeSeriesData dat){
     try{
       ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(TIMESERIES));
       out.writeObject(dat);
       out.close();
         } catch(IOException e){
             System.out.println("TimeSeriesData could not be saved to disk. IO error occured.");
             e.printStackTrace();
           }

     }

   /**
    * This method loads serialized objects from a file
    */
   private static TimeSeriesData loadTimeSeries(){
     try{
       ObjectInputStream in= new ObjectInputStream( new FileInputStream(TIMESERIES));
       TimeSeriesData data= (TimeSeriesData) in.readObject();

       in.close();
       return data;
         } catch (IOException e){
             System.out.println("TimeSeriesData could not be loaded from disk. IO error occured.");
             e.printStackTrace();
           }
     	catch (ClassNotFoundException e){
     		System.out.println("Class could not be Found!");
             e.printStackTrace();
     	}
     return null;
   }
   
   /**
    * This method is used to persist UserInfo object between runs.
    * 
    * @param dat the UserInfo to be stored/serialized to a file
    */
    private static void storeUserInfo(UserInfo dat){
     try{
       ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(USERINFO));
       out.writeObject(dat);
       out.close();
         } catch(IOException e){
             System.out.println("UserInfo could not be saved to disk. IO error occured.");
             e.printStackTrace();
           }

     }

   /**
    * This method loads serialized objects from a file
    */
   private static UserInfo loadUserInfo(){
     try{
       ObjectInputStream in= new ObjectInputStream( new FileInputStream(USERINFO));
       UserInfo data= (UserInfo) in.readObject();

       in.close();
       return data;
         } catch (IOException e){
             System.out.println("TimeSeriesData could not be loaded from disk. IO error occured.");
             e.printStackTrace();
           }
     	catch (ClassNotFoundException e){
     		System.out.println("Class could not be Found!");
             e.printStackTrace();
     	}
     return null;
   }
   
   /**
    * This method is used to persist Preferences object between runs.
    * 
    * @param dat the Preferences to be stored/serialized to a file
    */
    private static void storePreferences(Preferences dat){
     try{
       ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(PREFERENCES));
       out.writeObject(dat);
       out.close();
         } catch(IOException e){
             System.out.println("Preferences could not be saved to disk. IO error occured.");
             e.printStackTrace();
           }

     }

   /**
    * This method loads serialized objects from a file
    */
   private static Preferences loadPreferences(){
     try{
       ObjectInputStream in= new ObjectInputStream( new FileInputStream(PREFERENCES));
       Preferences data= (Preferences) in.readObject();

       in.close();
       return data;
         } catch (IOException e){
             System.out.println("Preferences could not be loaded from disk. IO error occured.");
             e.printStackTrace();
           }
     	catch (ClassNotFoundException e){
     		System.out.println("Class could not be Found!");
             e.printStackTrace();
     	}
     return null;
   }
   
   /**
    * This method is used to persist DailyGoals object between runs.
    * 
    * @param goals the DailyGoals to be stored/serialized to a file
    */
   private static void storeGoals(DailyGoals goals){
	     try{
	       ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(GOALS));
	       out.writeObject(goals);
	       out.close();
	         } catch(IOException e){
	             System.out.println("DailyGoals could not be saved to disk. IO error occured.");
	             e.printStackTrace();
	           }

	     }

	   /**
	    * This method loads serialized objects from a file
	    */
	   private static DailyGoals loadGoals(){
	     try{
	       ObjectInputStream in= new ObjectInputStream( new FileInputStream(GOALS));
	       DailyGoals goals= (DailyGoals) in.readObject();

	       in.close();
	       return goals;
	         } catch (IOException e){
	             System.out.println("DailyGoals could not be loaded from disk. IO error occured.");
	             e.printStackTrace();
	           }
	     	catch (ClassNotFoundException e){
	     		System.out.println("Class could not be Found!");
	             e.printStackTrace();
	     	}
	     return null;
	   }

}