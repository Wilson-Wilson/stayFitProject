import java.awt.EventQueue;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

import net.miginfocom.swing.MigLayout;

import javax.swing.LayoutStyle.ComponentPlacement;




public class Window {

	private JFrame frame;
	
	
	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
	ImageIcon backImage = new ImageIcon("C:/Users/Jodi-Marie/Pictures/Saved Pictures/background.jpg");
	ImageIcon caloriesIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\FireIcon2.png");
	ImageIcon minutesIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\TimeIcon2.png");
	ImageIcon movementIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\RunningIcon2.png");
	ImageIcon lifetimeIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\StarIcon2.png");
	ImageIcon timeseriesIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\BarGraphIcon2.png");
	ImageIcon bestdayIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\BlueStarIcon2.png");
	ImageIcon exitIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\closebutton2.png");
	ImageIcon rightarrowIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\rightArrow2.png");
	ImageIcon leftarrowIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\leftArrow2.png");
	ImageIcon trophyIcon = new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\Trophy.png");
	ImageIcon cardIcon =new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\dash.png");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setSize(1000,600);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
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
