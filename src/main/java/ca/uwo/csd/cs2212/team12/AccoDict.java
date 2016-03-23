package ca.uwo.csd.cs2212.team12;

public class AccoDict {

  /**
   * The list containing all of the users accolades.
   */
  private Accolade [] theList;

  /**
   * Initializes all of the available accolades for the user, setting their
   * completion status to false.
   */
  public AccoDict(){
	theList = new Accolade[20];
	  
	theList[0] = new Accolade("1,000 baby-steps","steps",1000, false);
	theList[1] = new Accolade("5,000 growing calf","steps",5000, false);
	theList[2] = new Accolade("10,000 marathon","steps",10000, false);
	theList[3] = new Accolade("Iron Man","steps",15000, false);
	theList[4] = new Accolade("BMR+750- Kindle","calories",750, false);
	theList[5] = new Accolade("BMR+1250- Fire Baby","calories",1250, false);
	theList[6] = new Accolade("BMR+1250- Human Torch","calories",1750, false);
	theList[7] = new Accolade("1-Another One","distance",1000, false);
	theList[8] = new Accolade("3-Third Time's the Charm","distance",3000, false);
	theList[9] = new Accolade("8-Making an Album","distance",8000, false);
	theList[10] = new Accolade("10 Up or Down?","floors",10, false);
	theList[11] = new Accolade("20 Step Machine","floors",20, false);
	theList[12] = new Accolade("Elevator","floors",30, false);
	theList[13] = new Accolade("60 Power Hour","activeMins",60, false);
	theList[14] = new Accolade("Double Time","activeMins",120, false);
	theList[15] = new Accolade("Need a Break","activeMins",200, false);
  }

	/**
	 * This method is used to retrieve the user's accolades.
	 * @return Accolade The list of the user's accolades
     */
	public Accolade [] getList(){
		return this.theList;
	}
}