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
	private static boolean testFlag = false;
	
	/*
	 * For the weeklyTotals and monthlyTotal arrays
	 * 0 - calories
	 * 1 - distance
	 * 2 - floors
	 * 3 - steps
	 * 4 - active minutes
	 * 5 - sedentary minutes
	 * */
	private static float [] dailyTotals;
	private static float [] weeklyTotals;
	private static float [] monthlyTotals;

	
	public static float getDailyTotals(int i) {
		return dailyTotals[i];
	}
	public static float getWeeklyTotals(int i) {
		return weeklyTotals[i];
	}
	public static float getMonthlyTotals(int i) {
		return monthlyTotals[i];
	}

	
	private static final long serialVersionUID= 1L;
	private static final String DATADICT= "datadict.boop";
	private static final String TIMESERIES= "timeseries.boop";
	private static final String USERINFO= "userinfo.boop";
	private static final String PREFERENCES= "preferences.boop";
	private static final String GOALS="dailygoals.boop";	
	
	/**
<<<<<<< HEAD
	 * Constructor that creates Controller object from apiParam. 
	 * The method is only used in StayFit.java with onStartUp() defined below.
	 * @param apiParam 
	 */
	//Add UI parameter and create initializeController() method in Stayfit that creates 
		//a controller object and calls onStartUp()
	public Controller(){	
	}
	
	
	/**
=======
>>>>>>> dev
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
	public static void changeDate(String newer, String older) throws JSONException, ParseException{
		
		if(testFlag == true){
			return;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate newDate = LocalDate.parse(newer, formatter);
		LocalDate oldDate = LocalDate.parse(older, formatter);
		
		if(testInet()){	
		
			theAPI = new RealAPI(newer);
			JSONObject timeCal = theAPI.getCalSeries();
			JSONObject timeSteps = theAPI.getStepsSeries();
			JSONObject timeHeartRate = theAPI.getHeartRateSeries();
			JSONObject timeDistance = theAPI.getDistanceSeries();
			JSONObject timeFloors = theAPI.getFloorsSeries();
			JSONObject timeSedentary = theAPI.getSedentaryMinutesSeries();
			JSONObject timeActive = theAPI.getActiveMinutesSeries();
			theTimeSeries = new TimeSeriesData (timeCal, timeSteps, timeHeartRate, timeDistance, timeFloors, timeSedentary, timeActive);
			
			JSONObject lifeStats = theAPI.getLifeTime();
			theUserInfo = new UserInfo(lifeStats);
			
			if (!isWithinRange(newDate)){
				JSONObject dictCal = theAPI.getCalBurned();
				JSONObject dictDist = theAPI.getDistance();
				JSONObject dictFloors = theAPI.getFloors();
				JSONObject dictSteps = theAPI.getSteps();
				JSONObject dictActive = theAPI.getActiveMinutes();
				JSONObject dictSedentary = theAPI.getSedentaryMinutes();
						
				theDictionary = new DataDict(dictCal, dictDist, dictFloors, dictSteps, dictActive, dictSedentary);
			}
		}
		
		dailyTotals = getDayData(newDate);
		
		if(!isSameWeek(newDate, oldDate)){
			weeklyTotals = getWeekData(newDate);
		}
		
		if(!isSameMonth(newDate, oldDate)){
			monthlyTotals = getMonthData(newDate);
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
	public static void onStartUp() throws JSONException, ParseException{
		

		if(testFlag == true){
			Preferences.setAllTrue();
			theAPI = new TestAPI();
			
			JSONObject timeCal = theAPI.getCalSeries();
			JSONObject timeSteps = theAPI.getStepsSeries();
			JSONObject timeHeartRate = theAPI.getHeartRateSeries();
			JSONObject timeDistance = theAPI.getDistanceSeries();
			JSONObject timeFloors = theAPI.getFloorsSeries();
			JSONObject timeSedentary = theAPI.getSedentaryMinutesSeries();
			JSONObject timeActive = theAPI.getActiveMinutesSeries();
			theTimeSeries = new TimeSeriesData (timeCal, timeSteps, timeHeartRate, timeDistance, timeFloors, timeSedentary, timeActive);
			
			JSONObject lifeStats = theAPI.getLifeTime();
			theUserInfo = new UserInfo(lifeStats);
			
			JSONObject dictCal = theAPI.getCalBurned();
			JSONObject dictDist = theAPI.getDistance();
			JSONObject dictFloors = theAPI.getFloors();
			JSONObject dictSteps = theAPI.getSteps();
			JSONObject dictActive = theAPI.getActiveMinutes();
			JSONObject dictSedentary = theAPI.getSedentaryMinutes();
			theDictionary = new DataDict(dictCal, dictDist, dictFloors, dictSteps, dictActive, dictSedentary);
			
			JSONObject dailyGoals = theAPI.getGoals();
			theDailyGoals = new DailyGoals(dailyGoals);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate addDate = LocalDate.parse(theDictionary.getLatest(), formatter);
		    
			dailyTotals = getDayData(addDate); 
			weeklyTotals = getWeekData(addDate);
			monthlyTotals = getMonthData(addDate);
	        theAccoDict = new AccoDict();
			accoCheck(addDate);
			goalsCheck(addDate);
			
			MWindow window = new MWindow();
	        window.frame.setSize(1000,600);
	        window.frame.setVisible(true);
	       
			return;
		}
		
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
			
			System.out.println("internet works!");
			
			theAPI = new RealAPI(curDate);
			
			JSONObject timeCal = theAPI.getCalSeries();
			JSONObject timeSteps = theAPI.getStepsSeries();
			try {
	            Thread.sleep(1000);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
			JSONObject timeHeartRate = theAPI.getHeartRateSeries();
			JSONObject timeDistance = theAPI.getDistanceSeries();
			try {
	            Thread.sleep(1000);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
			JSONObject timeFloors = theAPI.getFloorsSeries();
			JSONObject timeSedentary = theAPI.getSedentaryMinutesSeries();
			try {
	            Thread.sleep(1000);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
			JSONObject timeActive = theAPI.getActiveMinutesSeries();
			theTimeSeries = new TimeSeriesData (timeCal, timeSteps, timeHeartRate, timeDistance, timeFloors, timeSedentary, timeActive);
			
			JSONObject lifeStats = theAPI.getLifeTime();
			theUserInfo = new UserInfo(lifeStats);
			
			JSONObject dictCal = theAPI.getCalBurned();
			JSONObject dictDist = theAPI.getDistance();
			JSONObject dictFloors = theAPI.getFloors();
			JSONObject dictSteps = theAPI.getSteps();
			JSONObject dictActive = theAPI.getActiveMinutes();
			JSONObject dictSedentary = theAPI.getSedentaryMinutes();
			theDictionary = new DataDict(dictCal, dictDist, dictFloors, dictSteps, dictActive, dictSedentary);
			
			 try{
				 JSONObject dailyGoals = theAPI.getGoals();
				 theDailyGoals = new DailyGoals(dailyGoals);
	            }
	            catch(Exception e){
	                System.out.println(
	                        "no goals to fetch"+e.getMessage());
	                theDailyGoals = new DailyGoals();
	    			theDailyGoals.setCalGoal(0);
	    			theDailyGoals.setDistGoal(0);
	    			theDailyGoals.setFloorGoal(0);
	    			theDailyGoals.setStepGoal(0);
	            }
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
		
        MWindow window = new MWindow();
        window.frame.setSize(1000,600);
        window.frame.setVisible(true);
        
        dailyTotals = getDayData(now); 
        weeklyTotals = getWeekData(now);
		monthlyTotals = getMonthData(now);
        theAccoDict = new AccoDict();
		accoCheck(now);
		goalsCheck(now);
	}
	
	/**
	 * This method serializes all data-related instance variables.
	 * The method is disabled in test mode.
	 */
	public static void onClose(){
		if(testFlag == true){
			return;
		}
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
	 
	public static DataDict getTheDictionary() {
		return theDictionary;
	}


	public static void setTheDictionary(DataDict theDictionary) {
		Controller.theDictionary = theDictionary;
	}


	public static API getTheAPI() {
		return theAPI;
	}


	public static void setTheAPI(API theAPI) {
		Controller.theAPI = theAPI;
	}


	public static UserInfo getTheUserInfo() {
		return theUserInfo;
	}


	public static void setTheUserInfo(UserInfo theUserInfo) {
		Controller.theUserInfo = theUserInfo;
	}


	public static TimeSeriesData getTheTimeSeries() {
		return theTimeSeries;
	}


	public static void setTheTimeSeries(TimeSeriesData theTimeSeries) {
		Controller.theTimeSeries = theTimeSeries;
	}


	public static Preferences getThePreferences() {
		return thePreferences;
	}


	public static void setThePreferences(Preferences thePreferences) {
		Controller.thePreferences = thePreferences;
	}


	public static AccoDict getTheAccoDict() {
		return theAccoDict;
	}


	public static void setTheAccoDict(AccoDict theAccoDict) {
		Controller.theAccoDict = theAccoDict;
	}


	public static DailyGoals getTheDailyGoals() {
		return theDailyGoals;
	}


	public static void setTheDailyGoals(DailyGoals theDailyGoals) {
		Controller.theDailyGoals = theDailyGoals;
	}


	public static boolean isTestFlag() {
		return testFlag;
	}


	public static void setTestFlag(boolean testFlag) {
		Controller.testFlag = testFlag;
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
	private static float[] getDayData(LocalDate theDate){
		
		float [] dayValues = new float[6];
		
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
	private static float[] getWeekData(LocalDate theDate){
		
		LocalDate dayObject = null;
		String dayString;
		DataEntry currentDay;
		float i;
		float [] weekValues = new float[6];
		
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
			dayObject = dayObject.plusDays(1);
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
	private static float[] getMonthData(LocalDate theDate){
		
		LocalDate dayObject;
		String dayString;
		DataEntry currentDay;
		float [] monthValues = new float[6];
		float currentMonth = theDate.getMonthValue();
		
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
			dayObject = dayObject.plusDays(1);
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
		
		float [] dayValues = getDayData(theDate);

		for (int i = 0; i < 20; i++){
			  
			  Accolade acco = theAccoDict.getList()[i];
			  
			  if (acco.getType().equals("steps") && (int)dayValues[3] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("calories") && (int)dayValues[0] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("distance") && dayValues[1] >= (float)acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("floors") && (int)dayValues[2] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else if(acco.getType().equals("activeMins") && (int)dayValues[4] >= acco.getThreshold()){
				  acco.setObtained(true);
			  }
			  else {
				  if(acco.getType().equals("sedentaryMins") && (int)dayValues[5] >= acco.getThreshold()){
					  acco.setObtained(true);
				  }
			  }
		  }
	}
	
	private static void goalsCheck(LocalDate theDate) {
		
		float [] dayValues = getDayData(theDate);
		
		if(theDailyGoals.getStepGoal() > (int)dayValues[3]){
			//update UI
		}
		
		if(theDailyGoals.getFloorGoal() > (int)dayValues[2]){
			//update UI
		}
		if((float)theDailyGoals.getDistGoal() > dayValues[1]){
			//update UI
		}
		if(theDailyGoals.getCalGoal() > (int)dayValues[0]){
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