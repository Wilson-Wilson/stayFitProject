package ca.uwo.csd.cs2212.team12;

import java.io.Serializable;

public class Preferences implements Serializable{

  private static final long serialVersionUID= 1L;	
  public static boolean showCaloriesCard;
  public static boolean showMinutesCard;
  public static boolean showMovementsCard;
  public static boolean showLifetimeCard;
  public static boolean showTimeSeriesCard;
  public static boolean showBestDaysCard;
  
  public boolean saveCaloriesCard;
  public boolean saveMinutesCard;
  public boolean saveMovementsCard;
  public boolean saveLifetimeCard;
  public boolean saveTimeSeriesCard;
  public boolean saveBestDaysCard;
  
  /**
   * This would be the default layout of the dashboard
   */
  public Preferences(){
    
  }
  
  
  /**
 * @return the saveCaloriesCard
 */
public boolean isSaveCaloriesCard() {
	return saveCaloriesCard;
}


/**
 * @param saveCaloriesCard the saveCaloriesCard to set
 */
public void setSaveCaloriesCard(boolean saveCaloriesCard) {
	this.saveCaloriesCard = saveCaloriesCard;
}


/**
 * @return the saveMinutesCard
 */
public boolean isSaveMinutesCard() {
	return saveMinutesCard;
}


/**
 * @param saveMinutesCard the saveMinutesCard to set
 */
public void setSaveMinutesCard(boolean saveMinutesCard) {
	this.saveMinutesCard = saveMinutesCard;
}


/**
 * @return the saveMovementsCard
 */
public boolean isSaveMovementsCard() {
	return saveMovementsCard;
}


/**
 * @param saveMovementsCard the saveMovementsCard to set
 */
public void setSaveMovementsCard(boolean saveMovementsCard) {
	this.saveMovementsCard = saveMovementsCard;
}


/**
 * @return the saveLifetimeCard
 */
public boolean isSaveLifetimeCard() {
	return saveLifetimeCard;
}


/**
 * @param saveLifetimeCard the saveLifetimeCard to set
 */
public void setSaveLifetimeCard(boolean saveLifetimeCard) {
	this.saveLifetimeCard = saveLifetimeCard;
}


/**
 * @return the saveTimeSeriesCard
 */
public boolean isSaveTimeSeriesCard() {
	return saveTimeSeriesCard;
}


/**
 * @param saveTimeSeriesCard the saveTimeSeriesCard to set
 */
public void setSaveTimeSeriesCard(boolean saveTimeSeriesCard) {
	this.saveTimeSeriesCard = saveTimeSeriesCard;
}


/**
 * @return the saveBestDaysCard
 */
public boolean isSaveBestDaysCard() {
	return saveBestDaysCard;
}


/**
 * @param saveBestDaysCard the saveBestDaysCard to set
 */
public void setSaveBestDaysCard(boolean saveBestDaysCard) {
	this.saveBestDaysCard = saveBestDaysCard;
}


public static void setAllTrue(){
	    Preferences.showCaloriesCard= true;
	    Preferences.showMinutesCard= true;
	    Preferences.showMovementsCard= true;
	    Preferences.showLifetimeCard= true;
	    Preferences.showTimeSeriesCard= true;
	    Preferences.showBestDaysCard= true;
  }
  
	/**
	* Returns value of showCaloriesCard
	* @return boolean lets the programme know this card's display status
	*/
	public static boolean isShowCaloriesCard() {
		return showCaloriesCard;
	}

	/**
	* Sets new value of showCaloriesCard
	* @param showCaloriesCard determines whether this card will be displayed or not
	*/
	public void setShowCaloriesCard(boolean showCaloriesCard) {
		this.showCaloriesCard = showCaloriesCard;
	}

	/**
	* Returns value of showMinutesCard
	* @return lets the programme know this card's display status
	*/
	public static boolean isShowMinutesCard() {
		return showMinutesCard;
	}

	/**
	* Sets new value of showMinutesCard
	* @param showMinutesCard determines whether this card will be displayed or not
	*/
	public void setShowMinutesCard(boolean showMinutesCard) {
		this.showMinutesCard = showMinutesCard;
	}

	/**
	* Returns value of showMovementsCard
	* @return lets the programme know this card's display status
	*/
	public static boolean isShowMovementsCard() {
		return showMovementsCard;
	}

	/**
	* Sets new value of showMovementsCard
	* @param showMovementsCard determines whether this card will be displayed or not
	*/
	public void setShowMovementsCard(boolean showMovementsCard) {
		this.showMovementsCard = showMovementsCard;
	}

	/**
	* Returns value of showLifetimeCard
	* @return lets the programme know this card's display status
	*/
	public static boolean isShowLifetimeCard() {
		return showLifetimeCard;
	}

	/**
	* Sets new value of showLifetimeCard
	* @param showLifetimeCard determines whether this card will be displayed or not
	*/
	public void setShowLifetimeCard(boolean showLifetimeCard) {
		this.showLifetimeCard = showLifetimeCard;
	}

	/**
	* Returns value of showTimeSeriesCard
	* @return lets the programme know this card's display status
	*/
	public static boolean isShowTimeSeriesCard() {
		return showTimeSeriesCard;
	}

	/**
	 * Returns value of noCardsShowing
	 * @return lets the program know if any cards are visible onscreen.
	 */

	public static boolean noCardsShowing() {
		if (!showBestDaysCard && !showCaloriesCard && !showLifetimeCard && !showMinutesCard && !showMovementsCard && !showTimeSeriesCard) {
			return true;
		}
		return false;
	}

	/**
	* Sets new value of showTimeSeriesCard
	* @param showTimeSeriesCard determines whether this card will be displayed or not
	*/
	public void setShowTimeSeriesCard(boolean showTimeSeriesCard) {
		this.showTimeSeriesCard = showTimeSeriesCard;
	}

	/**
	* Returns value of showBestDaysCard
	* @return lets the programme know this card's display status
	*/
	public static boolean isShowBestDaysCard() {
		return showBestDaysCard;
	}

	/**
	* Sets new value of showBestDaysCard
	* @param showBestDaysCard determines whether this card will be displayed or not
	*/
	public void setShowBestDaysCard(boolean showBestDaysCard) {
		this.showBestDaysCard = showBestDaysCard;
	}

	
}
