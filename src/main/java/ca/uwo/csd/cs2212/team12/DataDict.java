package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

public class DataDict implements Serializable{
 
  /**
   * Declare theDictionary to store data entries	
   */
  private HashMap<String,DataEntry> theDictionary;
  private String earliest, latest;
  private static final long serialVersionUID= 1L;
  
  /**
   * Constructor.
   * Fills DataDict with a maximum 365 Data Entry objects.
   *
   * @param calories is the JSONObject carrying daily calorie burned data for a year.
   * @param distance is the JSONObject carrying daily distance traveled data for a year.
   * @param floors is the JSONObject carrying daily floors climbed data for a year.
   * @param steps is the JSONObject carrying daily steps climbed data for a year.
   * @param activeMins is the JSONObject carrying active minutes data for a year.
   * @param sedMins is the JSONObject carrying sedentary minutes data for a year.
   * @throws JSONException 
   */
  public DataDict(JSONArray calories, JSONArray distance, JSONArray floors, JSONArray steps, JSONArray activeMins, JSONArray sedMins) throws JSONException{
	  
	  this.theDictionary = new HashMap<String,DataEntry>(365);
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
   * This is the default constructor for the DataDict class.
   */
  public DataDict(){
  }

  /**
   * This method returns the value of the earliest data entry available.
   * @return String This returns the value of earliest.
   */
  public String getEarliest(){
	  return this.earliest;
  }

  /**
   * This method returns the value of the most recent data entry available.
   * @return String This returns the value of latest.
   */
  public String getLatest(){
	  return this.latest;
  }

  /**
   * This method returns the dictionary containing the user information.
   * @return HashMap<String,DataEntry> This returns the dictionary hash map.
   */
  public HashMap<String, DataEntry> getDictionary(){
	  return this.theDictionary;
  }

}
