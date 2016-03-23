package ca.uwo.csd.cs2212.team12;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingUtilities;

public class StayFit {
	
	/**
	 * This is the main method that start the whole program
	 * 
	 * @param args command line arguments letting the program know which mode to run
	 */
    public static void main(String[] args) {

        final boolean isTest = (args.length!=0 && args[0].equals("test"));
        UserInfo uInfo= new UserInfo();
        
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    API api;
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date  = formatter.format(new Date());
                    if(isTest)  api= new TestAPI();
                    else        api= new RealAPI(date);
 
                    Controller.onStartUp();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
}