import javax.swing.ImageIcon;
import java.io.Serializable;

public class Accolade implements Serializable{

	private String accoType;
	private int accoID, accoThreshold;
	private ImageIcon accoIcon;
	private boolean userObtained;

	public Accolade(int id, String type, int thresh, ImageIcon icon, boolean userObt ){

		accoID= id;
		accoType= type;
		accoThreshold= thresh;
		accoIcon= icon;
		userObtained= userObt;

	}

	/**
	* Returns value of accoType
	* @return
	*/
	public String getAccoType() {
		return accoType;
	}

	/**
	* Sets new value of accoType
	* @param
	*/
	public void setAccoType(String accoType) {
		this.accoType = accoType;
	}

	/**
	* Returns value of accoID
	* @return
	*/
	public int getAccoID() {
		return accoID;
	}

	/**
	* Sets new value of accoID
	* @param
	*/
	public void setAccoID(int accoID) {
		this.accoID = accoID;
	}

	/**
	* Returns value of accoIcon
	* @return
	*/
	public ImageIcon getAccoIcon() {
		return accoIcon;
	}

	/**
	* Sets new value of accoIcon
	* @param
	*/
	public void setAccoIcon(ImageIcon accoIcon) {
		this.accoIcon = accoIcon;
	}

	/**
	* Returns value of userObtained
	* @return
	*/
	public boolean getUserObtained() {
		return userObtained;
	}

	/**
	* Sets new value of userObtained
	* @param
	*/
	public void setUserObtained(boolean userObtained) {
		this.userObtained = userObtained;
	}
}
