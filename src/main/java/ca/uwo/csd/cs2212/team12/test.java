package ca.uwo.csd.cs2212.team12;

import java.text.ParseException;

public class test {
	
	public static void main(String[] args) throws ParseException{
		RealAPI test = new RealAPI("2016-03-23");
		/*test.getSedentaryMinutesSeries();
		try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }*/
		test.getActiveMinutesSeries();
		try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
		test.getLifeTime();
		System.out.println("\n");
		/*test.getHeartRateSeries();
		System.out.println("\n");
		//test.getFloorsSeries();
*/	}

}
