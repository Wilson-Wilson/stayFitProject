package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;



public class GoalDict implements Serializable{

  private HashMap<String,Goal> dict;
  private static final long serialVersionUID= 1L;
  
  /**
   * Default constructor for goalDict
   */
  public GoalDict(){
    dict= new HashMap<String,Goal>();
  }
  
  
  /**
   * Method to add a Goal object to a given date
   * @param theGoal
   */
  public void addGoal(Goal theGoal){
    dict.put(theGoal.getDate(), theGoal);
  }
  
  
  /**
   * Method to return a Goal object for a given date
   * @param date
   * @return
   */
  public Goal getGoal(String date){
	  return dict.get(date);
  }
  
  
  /**
   * Method that returns true if goals are set for a given date
   * @param date
   * @return
   */
  public boolean hasGoal(String date){
	 return dict.containsValue(date);
  }
  
  
  /**
   * Method that changes the removes the current Goal object for a date and sets it instead to the specified Goal object
   * @param date
   * @param newGoal
   */
  public void changeGoal(String date, Goal newGoal){
	  dict.remove(date);
	  dict.put(date, newGoal);
  }
  
  
  /**
   * Method to return the HashMap filled with Goal objects
   * @return HashMap<String, Goal>
   */
  public HashMap<String, Goal> getDictionary(){
    return dict;
  }





}
