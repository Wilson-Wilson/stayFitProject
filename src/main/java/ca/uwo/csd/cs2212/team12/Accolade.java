package ca.uwo.csd.cs2212.team12;

import javax.swing.ImageIcon;
import java.io.Serializable;

public class Accolade {

	private String name;
	private String type;
	private int threshold;
	private boolean obtained;
	
	/**
	 * Creates Accolade object that stores user's accolade information.
	 * @param type String The type of accolade.
	 * @param thresh int The accolade threshold.
	 * @param obtained boolean The indicator if the user has achieved the accolade.
	 */
	public Accolade(String name, String type, int thresh, boolean userObt){
		
		this.name = name;
		this.type= type;
		this.threshold= thresh;
		this.obtained= userObt;

	}

	/**
	* This method returns the value of accoType.
	* @return String This returns the value of accoType.
	*/
	public String getType() {
		return this.type;
	}
	
	/**
	* This method returns the value of threshold.
	* @return int This returns the value of threshold.
	*/
	public int getThreshold() {
		return threshold;
	}

	/**
	* This method returns the value of userObtained.
	* @return boolean This returns the value of userObtained.
	*/
	public boolean isObtained() {
		return obtained;
	}

	/**
	* This method sets this.userObtained to userObtained.
	* @param userObtained boolean The new userObtained.
	*/
	public void setObtained(boolean status) {
		this.obtained = status;
	}
}
