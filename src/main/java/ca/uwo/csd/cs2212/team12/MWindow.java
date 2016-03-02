package ca.uwo.csd.cs2212.team12;
import javax.swing.*;

import java.awt.*;



public class MWindow {

	public JFrame frame;

	 //Make sure to have these initialized with the right icon
	 ImageIcon backImage = new ImageIcon("../src/main/resources/background.jpg");
	 	ImageIcon caloriesIcon = new ImageIcon("../src/main/resources/FireIcon2.png");
	 	ImageIcon minutesIcon = new ImageIcon("../src/main/resources/TimeIcon2.png");
	 	ImageIcon movementIcon = new ImageIcon("../src/main/resources/RunningIcon2.png");
	 	ImageIcon lifetimeIcon = new ImageIcon("../src/main/resources/StarIcon2.png");
	 	ImageIcon timeseriesIcon = new ImageIcon("../src/main/resources/BarGraphIcon2.png");
	 	ImageIcon bestdayIcon = new ImageIcon("../src/main/resources/BlueStarIcon2.png");
	 	ImageIcon exitIcon = new ImageIcon("../src/main/resources/closebutton2.png");
	 	ImageIcon rightarrowIcon = new ImageIcon("../src/main/resources/rightArrow2.png");
	 	ImageIcon leftarrowIcon = new ImageIcon("../src/main/resources/leftArrow2.png");
	 	ImageIcon trophyIcon = new ImageIcon("../src/main/resources/Trophy.png");
	 	ImageIcon cardIcon =new ImageIcon("../src/main/resources/dash.png");



	/**
	 * Create the application.
	 */
	public MWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//main frame
		frame = new JFrame();
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
