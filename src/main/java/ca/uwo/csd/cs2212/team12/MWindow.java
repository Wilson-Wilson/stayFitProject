package ca.uwo.csd.cs2212.team12;

import javax.swing.*;
import java.awt.*;

public class MWindow {

    public JFrame frame;


    //Make sure to have these initialized with the right icon
    ImageIcon backImage = ImageClass.getBackImage();
    ImageIcon caloriesIcon = ImageClass.getCaloriesIcon();
    ImageIcon minutesIcon = ImageClass.getMinutesIcon();
    ImageIcon movementIcon = ImageClass.getMovementIcon();
    ImageIcon lifetimeIcon = ImageClass.getLifetimeIcon();
    ImageIcon timeseriesIcon = ImageClass.getTimeseriesIcon();
    ImageIcon bestdayIcon = ImageClass.getBestdayIcon();
    ImageIcon exitIcon = ImageClass.getExitIcon();
    ImageIcon rightarrowIcon = ImageClass.getRightarrowIcon();
    ImageIcon leftarrowIcon = ImageClass.getLeftarrowIcon();
    ImageIcon trophyIcon = ImageClass.getTrophyIcon();
    ImageIcon cardIcon =ImageClass.getCardIcon();




    /**
     * Create the application.
     */
    public MWindow() {initialize();}

    /**
     * Initialize the contents of the frame; panels, sub-panels, labels, borders and etc.
     */
    private void initialize() {
        //main frame
        frame = new JFrame("StayFit");
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cl = new CardLayout(0,0);
        frame.getContentPane().setLayout(new CardLayout(0,0));

        JPanel panel_3 = new JPanel();
        panel_3.setOpaque(false);
        frame.getContentPane().add(panel_3, "3");
        panel_3.setLayout(cl);




        DashBoardPanel dash= new DashBoardPanel();
      
        
        dash.checkPref();
  

        panel_3.add(dash,"2");
    }
}