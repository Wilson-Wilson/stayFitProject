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
        
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
             
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date  = formatter.format(new Date());
                    
                    //Update TestFlag in Controller 
                    if(isTest){ Controller.setTestFlag(true);}
 
                    Controller.onStartUp();
                    
                    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                        public void run() {
                            Controller.onClose();
                        }
                    }, "Shutdown-thread"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            
                
            }
        });
    }
    
}