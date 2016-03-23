package ca.uwo.csd.cs2212.team12;

import javax.swing.*;
import java.awt.*;

public class MWindow {

    public JFrame frame;

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
        //panel_1.setBackground(Color.RED);
        DashBoardPanel dash= new DashBoardPanel();
        panel_3.add(dash,"2");
    }
}