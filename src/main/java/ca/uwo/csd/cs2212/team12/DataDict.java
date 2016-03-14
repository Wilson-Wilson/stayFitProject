package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

public class DataDict implements Serializable{
 
  /**
   * Declare theDictionary to store data entries	
   */
  private HashMap<String,DataEntry> theDictionary;
  private String earliest, latest;
  
  private static final long serialVersionUID= 1L;
  private static final String FILENAME= "dailydata.boop";
  
  /**
   * Constructor.
   * Fills DataDict with a maximum 365 Data Entry objects.
   * 
   * @param firstDate is the first date which 365 days prior to today's date.
   * @param calories is the JSONObject carrying daily calorie burned data for a year.
   * @param distance is the JSONObject carrying daily distance traveled data for a year.
   * @param floors is the JSONObject carrying daily floors climbed data for a year.
   * @param steps is the JSONObject carrying daily steps climbed data for a year.
   * @param activeMins is the JSONObject carrying active minutes data for a year.
   * @param sedMins is the JSONObject carrying sedentary minutes data for a year.
   * @throws JSONException 
   */
  public DataDict(JSONArray calories, JSONArray distance, JSONArray floors, JSONArray steps, JSONArray activeMins, JSONArray sedMins) throws JSONException{
	  
	  this.theDictionary = new HashMap<String,DataEntry>();
	  int numdays = calories.length();
	  this.earliest = sedMins.getJSONObject(0).getString("dateTime");
	  this.latest = sedMins.getJSONObject(numdays-1).getString("dateTime");
	  
	  
	  for(int i=0; i < numdays; i++){
		  
		  int addCal = calories.getJSONObject(i).getInt("value");
		  int addDistance = distance.getJSONObject(i).getInt("value");
		  int addFloors = floors.getJSONObject(i).getInt("value");
		  int addSteps = steps.getJSONObject(i).getInt("value");
		  int addActive = activeMins.getJSONObject(i).getInt("value");
		  int addSedentary= sedMins.getJSONObject(i).getInt("value");
		  String addDate = sedMins.getJSONObject(i).getString("dateTime");
		  
		  DataEntry addMe = new DataEntry(addCal, addDistance, addFloors, addSteps, addActive, addSedentary, addDate);
		  
		  this.theDictionary.put(addDate, addMe);
		   
	  }	   
    
  }

  /**
   * This method is used to persist DataDict object between runs.
   * 
   * @param dat the DataDict to be stored/serialized to a file
   */
 
  private static void storeData(DataDict dat){
    try{
      ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(FILENAME));
      out.writeObject(dat);
      out.close();
        } catch(IOException e){
            System.out.println("DataDict could not be saved to disk. IO error occured.");
            e.printStackTrace();
          }

    }

  /**
   * This method loads serialized objects from a file
   */
  private static void loadData(){
    try{
      ObjectInputStream in= new ObjectInputStream( new FileInputStream(FILENAME));
      DataEntry data= (DataEntry) in.readObject();

      in.close();
        } catch (IOException e){
            System.out.println("DataDict could not be loaded from disk. IO error occured.");
            e.printStackTrace();
          }
    	catch (ClassNotFoundException e){
    		System.out.println("Class could not be Found!");
            e.printStackTrace();
    	}
    }

  }
