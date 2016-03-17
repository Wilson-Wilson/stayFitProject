package ca.uwo.csd.cs2212.team12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID= 1L;
	private static final String FILENAME= "userinfo.boop";

	private String userName;
	private Preferences userPrefs;

	private int distanceLife;
	private int floorsLife;
	private int stepsLife;
	private String distanceBest;
	private String floorsBest;
	private String stepsBest;

	/**
	 * Creates the UserInfo Object that stores information from API calls.
	 * @param name String the name of the user.
	 * @param pref Preferences the Preference object for the custom dashboard.
	 * @param distance int the lifetime total for distance.
	 * @param floors the lifetime total for floors.
	 * @param steps the lifetime total for steps.
	 */
	public UserInfo(String name, Preferences pref, int distance, int floors, int steps, String distanceBest, String floorsBest, String stepsBest){
		
		this.userName = name;
		this.userPrefs = pref;
		this.distanceLife = distance;
		this.floorsLife = floors;
		this.stepsLife = steps;
		this.distanceBest = distanceBest;
		this.floorsBest = floorsBest;
		this.stepsBest = stepsBest;
	}

	/**
	 * Constructor for UserInfo without params.
	 */
	public UserInfo(){
		
		this.userName= null; //get this and other data from API unless UserInfo is serialized
		this.userPrefs= new Preferences();
		this.distanceLife= 0;
		this.floorsLife= 0;
		this.stepsLife= 0;
		this.distanceBest = null;
		this.floorsBest = null;
		this.stepsBest = null;
	}
	
	/**
	* This method returns the value of userName.
	* @return String This returns the value of userName.
	*/
	public String getUserName() {
		return this.userName;
	}

	/**
	* This method sets this.userName to userName.
	* @param userName String The new userName.
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	* This method returns the value of distanceLife.
	* @return int This returns the value of distanceLife.
	*/
	public int getDistanceLife() {
		return this.distanceLife;
	}

	/**
	* This method sets this.distanceLife to distanceLife.
	* @param distanceLife int The new distanceLife.
	*/
	public void setDistanceLife(int distanceLife) {
		this.distanceLife = distanceLife;
	}

	/**
	* This method returns the value of floorsLife.
	* @return int This returns the value of floorsLife.
	*/
	public int getFloorsLife() {
		return this.floorsLife;
	}

	/**
	* This method sets this.floorsLife to floorsLife.
	* @param floorsLife int The new floorsLife.
	*/
	public void setFloorsLife(int floorsLife) {
		this.floorsLife = floorsLife;
	}

	/**
	* This method returns the value of stepsLife.
	* @return int This returns the value of stepsLife.
	*/
	public int getStepsLife() {
		return this.stepsLife;
	}

	/**
	* This method sets this.stepsLife to stepsLife.
	* @param stepsLife int The new stepsLife.
	*/
	public void setStepsLife(int stepsLife) {
		this.stepsLife = stepsLife;
	}
	
	/**
	* This method returns the value of distanceBest.
	* @return String This returns the value of distanceBest.
	*/
	public String getDistanceBest(){
		return this.distanceBest;
	}
	
	/**
	* This method returns the value of floorsBest.
	* @return String This returns the value of floorsBest.
	*/
	public String getFloorsBest(){
		return this.floorsBest;
	}
	
	/**
	* This method returns the value of stepsBest.
	* @return String This returns the value of stepsBest.
	*/
	public String getStepsBest(){
		return this.stepsBest;
	}
	
	/**
	 * Saves the user information to disk.
	 * @param userInf UserInfo an instance of the UserInfo object to be stored.
	 */
	private static void storeUser(UserInfo userInf){
		try{
			ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(FILENAME));
			out.writeObject(userInf);
			out.close();
				} catch(IOException e){
						System.out.println("User could not be saved to disk. IO error occured.");
						e.printStackTrace();
					}

		}

	/**
	 * Loads user information from disk into an instance of UserInfo.
	 */
	private static void loadUser(){
		try{
			ObjectInputStream in= new ObjectInputStream( new FileInputStream(FILENAME));
			UserInfo user= (UserInfo) in.readObject();

			in.close();
				} catch (IOException e){
						System.out.println("User could not be loaded from disk. IO error occured.");
						e.printStackTrace();
					}
			catch (ClassNotFoundException e){
    		System.out.println("Class could not be Found!");
            e.printStackTrace();
    	}

	}

}
