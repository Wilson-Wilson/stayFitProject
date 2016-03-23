package ca.uwo.csd.cs2212.team12;
import java.text.ParseException;

import org.json.JSONException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class ControllerTest {
	
	DataDict testDict;
	UserInfo testUser;
	Preferences testPref;
	TimeSeriesData testTimeSeries;
	
	@Test
	public void testOnStartUp() throws JSONException, ParseException {
		
		//Test case1: no serialized data to restore and Internet is available
		Controller.onStartUp();
		
		//Assert that default Preference constructor was called successfully
		testPref = Controller.getPreferences();
		Assert.assertEquals(true, Preferences.isShowBestDaysCard());
		Assert.assertEquals(true, Preferences.isShowCaloriesCard());
		Assert.assertEquals(true, Preferences.isShowMinutesCard());
		Assert.assertEquals(true, Preferences.isShowMovementsCard());
		Assert.assertEquals(true, Preferences.isShowLifetimeCard());
		Assert.assertEquals(true, Preferences.isShowBestDaysCard());
		
		//Assert that today's data was properly called into TimeSeriesData 
		testTimeSeries = Controller.getTimeSeries()
		Assert.assertEquals(true, TimeSeriesData.getCaloriesSet.));
		
	      
	}
	
	@Before
	public void tearDown() throws Exception{
		
		//create Serializable objects
	}
	
	@Test
	public void testChangeDate() throws Exception {

	}
	
	@Test
	public void testOnClose() throws Exception {
		Controller.onClose();

	}

	@Test
	public void testOnStartUp1() throws Exception {

	}


}