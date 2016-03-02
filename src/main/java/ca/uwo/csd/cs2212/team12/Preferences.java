
package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
//NOT IMPLEMENTED IN STAGE TWO BUT WILL MOST LIKELY BE USED AS A FUTURE REFERENCE
public class Preferences implements Serializable{

  private boolean showCaloriesCard;
  private boolean showMinutesCard;
  private boolean showMovementsCard;
  private boolean showLifetimeCard;
  private boolean showTimeSeriesCard;
  private boolean showBestDaysCard;

  private String preferredUnits;
  
  /**
   * This would be the default layout of the dashboard
   */
  public Preferences(){
    showCaloriesCard= true;
    showMinutesCard= true;
    showMovementsCard= true;
    showLifetimeCard= true;
    showTimeSeriesCard= true;
    showBestDaysCard= true;
    preferredUnits= "metric";
  }

	/**
	* Returns value of showCaloriesCard
	* @return boolean lets the programme know this card's display status
	*/
	public boolean isShowCaloriesCard() {
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
	public boolean isShowMinutesCard() {
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
	public boolean isShowMovementsCard() {
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
	public boolean isShowLifetimeCard() {
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
	public boolean isShowTimeSeriesCard() {
		return showTimeSeriesCard;
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
	public boolean isShowBestDaysCard() {
		return showBestDaysCard;
	}

	/**
	* Sets new value of showBestDaysCard
	* @param showBestDaysCard determines whether this card will be displayed or not
	*/
	public void setShowBestDaysCard(boolean showBestDaysCard) {
		this.showBestDaysCard = showBestDaysCard;
	}

	/**
	* Returns value of preferredUnits
	* @return lets the programme know what unit sthe user wants the data in
	*/
	public String getPreferredUnits() {
		return preferredUnits;
	}

	/**
	* Sets new value of preferredUnits
	* @param preferredUnits determines what units the valu of the cards will be shown in
	*/
	public void setPreferredUnits(String preferredUnits) {
		this.preferredUnits = preferredUnits;
	}
}
