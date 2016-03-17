package ca.uwo.csd.cs2212.team12;

import javax.swing.ImageIcon;
import java.io.Serializable;

public class Accolade implements Serializable{

	private String accoType;
	private int accoID, accoThreshold;
	private ImageIcon accoIcon;
	private boolean userObtained;
	
	/**
	 * Creates Accolade object that stores user's accolade information.
	 * @param id int The accodlade ID.
	 * @param type String The type of accolade.
	 * @param thresh int The accolade threshold.
	 * @param icon ImageIcon The image representative of the accolade.
	 * @param userObt boolean The indicator if the user has achieved the accolade.
	 */
	public Accolade(int id, String type, int thresh, ImageIcon icon, boolean userObt ){

		accoID= id;
		accoType= type;
		accoThreshold= thresh;
		accoIcon= icon;
		userObtained= userObt;

	}

	/**
	* This method returns the value of accoType.
	* @return String This returns the value of accoType.
	*/
	public String getAccoType() {
		return accoType;
	}

	/**
	* This method sets this.accoType to accoType.
	* @param accoType String The new accoType.
	*/
	public void setAccoType(String accoType) {
		this.accoType = accoType;
	}

	/**
	* This method returns the value of accoID.
	* @return int This returns the value of accoID.
	*/
	public int getAccoID() {
		return accoID;
	}

	/**
	* This method sets this.accoID to accoID.
	* @param accoID int The new accoID.
	*/
	public void setAccoID(int accoID) {
		this.accoID = accoID;
	}

	/**
	* This method returns the value of accoIcon.
	* @return ImageIcon This returns the value of accoIcon.
	*/
	public ImageIcon getAccoIcon() {
		return accoIcon;
	}

	/**
	* This method sets this.accoIcon to accoIcon.
	* @param accoIcon ImageIcon The new accoIcon.
	*/
	public void setAccoIcon(ImageIcon accoIcon) {
		this.accoIcon = accoIcon;
	}

	/**
	* This method returns the value of userObtained.
	* @return boolean This returns the value of userObtained.
	*/
	public boolean getUserObtained() {
		return userObtained;
	}

	/**
	* This method sets this.userObtained to userObtained.
	* @param userObtained boolean The new userObtained.
	*/
	public void setUserObtained(boolean userObtained) {
		this.userObtained = userObtained;
	}
}
