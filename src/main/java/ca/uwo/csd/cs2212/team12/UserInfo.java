public class UserInfo {

	private String userName;

	private int calLife;
	private int distanceLife;
	private int floorsLife;
	private int stepsLife;
	private int actMinsLife;
	private int sedMinsLife;

	public UserInfo(String name, int cal, int distance, int floors, int steps, int actMin, int sedMin){
		userName= name;
		calLife= cal;
		distanceLife= distance;
		floorsLife= floors;
		stepsLife= steps;
		actMinsLife= actMin;
		sedMinsLife= sedMin;
	}

	public UserInfo(){
		userName= null;
		calLife= 0;
		distanceLife= 0;
		floorsLife= 0;
		stepsLife= 0;
		actMinsLife= 0;
		sedMinsLife= 0;
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
