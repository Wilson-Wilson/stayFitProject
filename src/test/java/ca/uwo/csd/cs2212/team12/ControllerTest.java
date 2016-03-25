package ca.uwo.csd.cs2212.team12;
import java.text.ParseException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	public void mainTest() throws JSONException, ParseException, IOException {
		
		//Test case1: no serialized data and internet is available:
		
/*		Files.deleteIfExists(Paths.get("datadict.boop"));
		Files.deleteIfExists(Paths.get("timeseries.boop"));
		Files.deleteIfExists(Paths.get("userinfo.boop"));
		Files.deleteIfExists(Paths.get("preferences.boop"));
		Files.deleteIfExists(Paths.get("dailygoals.boop"));
		*/
		
		Controller.onStartUp();
		
			//Assert that default Preference constructor was called successfully
		Assert.assertEquals(true, Preferences.isShowBestDaysCard());
		Assert.assertEquals(true, Preferences.isShowCaloriesCard());
		Assert.assertEquals(true, Preferences.isShowMinutesCard());
		Assert.assertEquals(true, Preferences.isShowMovementsCard());
		Assert.assertEquals(true, Preferences.isShowLifetimeCard());
		Assert.assertEquals(true, Preferences.isShowBestDaysCard());
			
		
		//Modify Preferences for serialization purposes
		Preferences.showCaloriesCard = false;
		
		Controller.onClose();
		System.exit(2);
		
/*		//Test case2: serialized data is available but internet is not available
		Controller.onStartUp();
		System.exit(2);*/
	      
	}
	


}