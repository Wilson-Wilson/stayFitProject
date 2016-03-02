
package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;

public class Preferences implements Serializable{

  private boolean showCaloriesCard;
  private boolean showMinutesCard;
  private boolean showMovementsCard;
  private boolean showLifetimeCard;
  private boolean showTimeSeriesCard;
  private boolean showBestDaysCard;

  private String preferredUnits;

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
	* @return
	*/
	public boolean isShowCaloriesCard() {
		return showCaloriesCard;
	}

	/**
	* Sets new value of showCaloriesCard
	* @param
	*/
	public void setShowCaloriesCard(boolean showCaloriesCard) {
		this.showCaloriesCard = showCaloriesCard;
	}

	/**
	* Returns value of showMinutesCard
	* @return
	*/
	public boolean isShowMinutesCard() {
		return showMinutesCard;
	}

	/**
	* Sets new value of showMinutesCard
	* @param
	*/
	public void setShowMinutesCard(boolean showMinutesCard) {
		this.showMinutesCard = showMinutesCard;
	}

	/**
	* Returns value of showMovementsCard
	* @return
	*/
	public boolean isShowMovementsCard() {
		return showMovementsCard;
	}

	/**
	* Sets new value of showMovementsCard
	* @param
	*/
	public void setShowMovementsCard(boolean showMovementsCard) {
		this.showMovementsCard = showMovementsCard;
	}

	/**
	* Returns value of showLifetimeCard
	* @return
	*/
	public boolean isShowLifetimeCard() {
		return showLifetimeCard;
	}

	/**
	* Sets new value of showLifetimeCard
	* @param
	*/
	public void setShowLifetimeCard(boolean showLifetimeCard) {
		this.showLifetimeCard = showLifetimeCard;
	}

	/**
	* Returns value of showTimeSeriesCard
	* @return
	*/
	public boolean isShowTimeSeriesCard() {
		return showTimeSeriesCard;
	}

	/**
	* Sets new value of showTimeSeriesCard
	* @param
	*/
	public void setShowTimeSeriesCard(boolean showTimeSeriesCard) {
		this.showTimeSeriesCard = showTimeSeriesCard;
	}

	/**
	* Returns value of showBestDaysCard
	* @return
	*/
	public boolean isShowBestDaysCard() {
		return showBestDaysCard;
	}

	/**
	* Sets new value of showBestDaysCard
	* @param
	*/
	public void setShowBestDaysCard(boolean showBestDaysCard) {
		this.showBestDaysCard = showBestDaysCard;
	}

	/**
	* Returns value of preferredUnits
	* @return
	*/
	public String getPreferredUnits() {
		return preferredUnits;
	}

	/**
	* Sets new value of preferredUnits
	* @param
	*/
	public void setPreferredUnits(String preferredUnits) {
		this.preferredUnits = preferredUnits;
	}
}
