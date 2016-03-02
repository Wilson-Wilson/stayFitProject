package ca.uwo.csd.cs2212.team12;
import javax.swing.*;
import java.awt.*;

public class StayFit {
	
	/**
	 * This is the main method that start the whole programme
	 * 
	 * @param args command line arguments letting the programme know which mode to run
	 */
    public static void main(String[] args) {

        final boolean isTest = (args.length!=0 && args[0].equals("test"));

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    API api;
                    if(isTest){
                        api= new TestAPI();
                    }
                    else{
                        api= new RealAPI();
                    }
                    MWindow window = new MWindow(api);
                    window.frame.setSize(1000,600);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
