package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
import java.io.*;

//NOT IMPLEMENTED IN STAGE TWO BUT WILL MOST LIKELY BE USED AS A FUTURE REFERENCE
//ITS MAIN PURPOSE IS TO SERVE AS A REFERENCE FOR FUTURE CLASSES
public class UserInfo implements Serializable {

	private static final long serialVersionUID= 1L;
	private static final String FILENAME= "userinfo.boop";

	private String userName;
	private Preferences userPrefs;

	private int calLife;
	private int distanceLife;
	private int floorsLife;
	private int stepsLife;
	private int actMinsLife;
	private int sedMinsLife;

	/**
	 * Creates the UserInfo Object that stores information from API calls.
	 * @param name String the name of the user.
	 * @param pref Preferences the Preference object for the custom dashboard.
	 * @param cal int the lifetime total for calories.
	 * @param distance int the lifetime total for distance.
	 * @param floors the lifetime total for floors.
	 * @param steps the lifetime total for steps.
	 * @param actMin the lifetime total for active minutes.
	 * @param sedMin the lifetime total for sedentary minutes.
	 */

	public UserInfo(String name, Preferences pref, int cal, int distance, int floors, int steps, int actMin, int sedMin){
		userName= name;
		userPrefs= pref;
		calLife= cal;
		distanceLife= distance;
		floorsLife= floors;
		stepsLife= steps;
		actMinsLife= actMin;
		sedMinsLife= sedMin;
	}

	/**
	 * Constructor for UserInfo without params.
	 */
	public UserInfo(){
		userName= null;
		userPrefs= null;
		calLife= 0;
		distanceLife= 0;
		floorsLife= 0;
		stepsLife= 0;
		actMinsLife= 0;
		sedMinsLife= 0;
	}

	//The following methods are used to persist UserInfo object between runs
	
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


	/**
	* This method returns the value of userName.
	* @return String This returns the value of userName.
	*/
	public String getUserName() {
		return userName;
	}

	/**
	* This method sets this.userName to userName.
	* @param userName String The new userName.
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	* This method returns the value of calLife.
	* @return int This returns the value of calLife.
	*/
	public int getCalLife() {
		return calLife;
	}

	/**
	* This method sets this.calLife to calLife.
	* @param calLife int The new calLife.
	*/
	public void setCalLife(int calLife) {
		this.calLife = calLife;
	}

	/**
	* This method returns the value of distanceLife.
	* @return int This returns the value of distanceLife.
	*/
	public int getDistanceLife() {
		return distanceLife;
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
		return floorsLife;
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
		return stepsLife;
	}

	/**
	* This method sets this.stepsLife to stepsLife.
	* @param stepsLife int The new stepsLife.
	*/
	public void setStepsLife(int stepsLife) {
		this.stepsLife = stepsLife;
	}

	/**
	* This method returns the value of actMinsLife.
	* @return int This returns the value of actMinsLife.
	*/
	public int getActMinsLife() {
		return actMinsLife;
	}

	/**
	* This method sets this.actMinsLife to actMinsLife.
	* @param actMinsLife int The new actMinsLife.
	*/
	public void setActMinsLife(int actMinsLife) {
		this.actMinsLife = actMinsLife;
	}

	/**
	* This method returns the value of sedMinsLife.
	* @return int This returns the value of sedMinsLife.
	*/
	public int getSedMinsLife() {
		return sedMinsLife;
	}

	/**
	* This method sets this.sedMinsLife to sedMinsLife.
	* @param sedMinsLife int The new sedMinsLife.
	*/
	public void setSedMinsLife(int sedMinsLife) {
		this.sedMinsLife = sedMinsLife;
	}

}
