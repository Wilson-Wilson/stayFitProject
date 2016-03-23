package ca.uwo.csd.cs2212.team12;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class ControllerTest {
	
	Controller theController;
	
	@Before
	public void createController(){
		this.theController= new Controller();
	}
	
	@Test
	public void testOnStartUp() {
	      Assert.assertEquals(9,9);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testChangeDate() throws Exception {

	}

	@Test
	public void testOnStartUp1() throws Exception {

	}

	@Test
	public void testOnClose() throws Exception {

	}
	
	 /*if some exception case
	        throw new Exception ("words"); */
}