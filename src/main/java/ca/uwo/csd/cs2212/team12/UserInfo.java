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

	//Constructor for UserInfo with params

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

//Constructor for UserInfo without params
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
	* Returns value of user
	* @return
	*/
	public String getUserName() {
		return userName;
	}

	/**
	* Sets new value of user
	* @param
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	* Returns value of calLife
	* @return
	*/
	public int getCalLife() {
		return calLife;
	}

	/**
	* Sets new value of calLife
	* @param
	*/
	public void setCalLife(int calLife) {
		this.calLife = calLife;
	}

	/**
	* Returns value of distanceLife
	* @return
	*/
	public int getDistanceLife() {
		return distanceLife;
	}

	/**
	* Sets new value of distanceLife
	* @param
	*/
	public void setDistanceLife(int distanceLife) {
		this.distanceLife = distanceLife;
	}

	/**
	* Returns value of floorsLife
	* @return
	*/
	public int getFloorsLife() {
		return floorsLife;
	}

	/**
	* Sets new value of floorsLife
	* @param
	*/
	public void setFloorsLife(int floorsLife) {
		this.floorsLife = floorsLife;
	}

	/**
	* Returns value of stepsLife
	* @return
	*/
	public int getStepsLife() {
		return stepsLife;
	}

	/**
	* Sets new value of stepsLife
	* @param
	*/
	public void setStepsLife(int stepsLife) {
		this.stepsLife = stepsLife;
	}

	/**
	* Returns value of actMinsLife
	* @return
	*/
	public int getActMinsLife() {
		return actMinsLife;
	}

	/**
	* Sets new value of actMinsLife
	* @param
	*/
	public void setActMinsLife(int actMinsLife) {
		this.actMinsLife = actMinsLife;
	}

	/**
	* Returns value of sedMinsLife
	* @return
	*/
	public int getSedMinsLife() {
		return sedMinsLife;
	}

	/**
	* Sets new value of sedMinsLife
	* @param
	*/
	public void setSedMinsLife(int sedMinsLife) {
		this.sedMinsLife = sedMinsLife;
	}

}
