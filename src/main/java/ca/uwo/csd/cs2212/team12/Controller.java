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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller implements Serializable{

	private static DataDict theDictionary;
	private static API theAPI;
	private static UserInfo theUserInfo;
	private static TimeSeriesData theTimeSeries;
	private static Preferences thePreferences;
	private static AccoDict	theAccoDict;
	//private UI theUI
	
	private static final long serialVersionUID= 1L;
	private static final String DATADICT= "datadict.boop";
	private static final String TIMESERIES= "timeseries.boop";
	private static final String USERINFO= "userinfo.boop";
	private static final String PREFERENCES= "preferences.boop";
	  
	//Add UI parameter and create initializeController() method in Stayfit that creates 
	//a controller object and calls onStartUp()
	public Controller(API apiParam){
		theAPI = apiParam;		
	}
	
	public void changeDate(String newer, String older){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate newDate = LocalDate.parse(newer, formatter);
		LocalDate oldDate = LocalDate.parse(older, formatter);
		
		if(testInet()){
			LocalDate back = newDate.minusDays(365);
			String curDate = newDate.toString();
			String earlyDate = back.toString();
			
			//timeseries data request to api using curdate
			//theTimeSeries = new TimeSeriesData (JSONarrays)
			
			if (!isWithinRange(newDate)){
				
				//pass in curDate and earlyDate to API requests
				//theDictionary = new Dictionary (returned JSONArrays)
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
		
		//theAccoDict.checkAccolades(); 	<-- updates the true/false flags for each accolade
		//Some UI action
		//goalsStuff
		
	}
	
	public static void onStartUp() throws IOException{
		
		
		File d = new File("../preferences.boop");
		if (d.exists()){
			thePreferences = loadPreferences();
		}
		else{
			thePreferences = new Preferences();
		}
		
		if(testInet()){
			LocalDate now = LocalDate.now();
			LocalDate back = now.minusDays(365);
			String curDate = now.toString();
			String earlyDate = back.toString();
			//pass in curDate and earlyDate to datadict data API requests
			//pass in curDate for timeseries data request
			//pass in cur date for userinfo data request
			
			//theDictionary = new Dictionary (returned JSONArrays)
			//theTimeSeries = new TimeSeriesData (JSONarrays)
			//theUserInfo = new UserInfo(JSONObject, JSONarray)
			
			// goals
		}
		else{
			File f = new File("../datadict.boop"),g = new File("../timeseries.boop"),h = new File("../userinfo.boop");
			
			if(f.exists() && g.exists() && h.exists()) { 
				theDictionary = loadDataDict();
				theUserInfo = loadUserInfo();
				theTimeSeries = loadTimeSeries();
			}
			else{
				//this.theDictionary = new Dictionary (fake Json arrays)
				//this.theTimeSeries = new TimeSeriesData (fake Json arrays)
				//theUserInfo = new UserInfo (fake shit)
			}				
		}
		
		AccoDict theAccoDict = new AccoDict();
		//theAccoDict.checkAccolades(); 	<-- updates the true/false flags for each accolade
		//Some UI action
		
	}
	
	public static void onClose(){
		
		storeDataDict(theDictionary);
		storeUserInfo(theUserInfo);
		storeTimeSeries(theTimeSeries);
		storePreferences(thePreferences);
		//store methods for goals
		
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
		
		LocalDate dayObject = null;
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
	
	private static int[] getMonthData(LocalDate theDate){
		
		LocalDate dayObject;
		String dayString;
		DataEntry currentDay;
		int [] monthValues = new int[6];
		int currentMonth = theDate.getMonthValue();
		
		//get first day of the month
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
	
	private static boolean testInet() {
	    Socket sock = new Socket();
	    InetSocketAddress addr = new InetSocketAddress("https://api.fitbit.com/ca",80);
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
	
	 /**
	   * This method is used to persist DataDict object between runs.
	   * 
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

}

