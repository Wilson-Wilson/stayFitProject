package ca.uwo.csd.cs2212.team12;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;




import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;



public class TrophyPanel extends JPanel{

	private JFrame frame;
  
    protected Color shadowColor = Color.black;
  
    protected Dimension arcs = new Dimension(20, 20);
   
    protected int shadGap = 5;
    protected int shadOffset = 4;
   
	
	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaloriesPanel window = new CaloriesPanel();
					window.frame.setSize(1000,600);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public TrophyPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//main frame
		/*frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		CardLayout cl = new CardLayout(0,0);
		this.setLayout(new CardLayout(0,0));
		BackgroundPanel panel_3 = new BackgroundPanel( new ImageIcon("C:/Users/Jodi-Marie/Pictures/Saved Pictures/background.jpg"));
		panel_3.setOpaque(false);
		this.add(panel_3, "3");
		panel_3.setLayout(cl);
		cl.show(panel_3, "2");
		JPanel paneldash = new JPanel();
		paneldash.setOpaque(false);
		//paneldash.setBackground(new Color(0, 128, 0));
		panel_3.add(paneldash, "2");
		JPanel cardPanel = new JPanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
		cardPanel.setOpaque(false);
		cardPanel.setBounds(new Rectangle(200, 200, 200, 200));
		paneldash.setLayout(new BorderLayout(0, 0));
		paneldash.add(cardPanel, BorderLayout.CENTER);;;;
		
		
		
		
		cardPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(105, 105, 105,180));
		cardPanel.add(panel_13, BorderLayout.NORTH);
		
		JLabel lblTrophy = new JLabel("Trophy");
		lblTrophy.setIcon(new ImageIcon("C:\\Users\\Jodi-Marie\\courses\\cs2212\\labs\\team12\\src\\main\\resources\\Trophy2.png"));
		lblTrophy.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblTrophy.setForeground(new Color(255, 255, 255));
		panel_13.add(lblTrophy);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		cardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel11 = new JPanel();
		panel11.setOpaque(false);
		panel.add(panel11, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("Steps Goals:");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel(" Floor Goals:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Distance Goals:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Calories Goals:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel11.setLayout(new GridLayout(0, 2, 0, 0));
		panel11.add(lblNewLabel_5);
		panel11.add(lblNewLabel_3);
		panel11.add(lblNewLabel_4);
		panel11.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		scrollPane.setViewportBorder(null);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		//scrollPane.getVerticalScrollBar().setBorder(new LineBorder(Color.GRAY));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUI(new MyScrollbarUI());
		
	
	
		
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		JViewport viewport = new JViewport();
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setPreferredSize(new Dimension(400, 1400));
		viewport.setView(panel_8);
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_12.setForeground(Color.WHITE);
		panel_12.setPreferredSize(new Dimension(400, 600));
		panel_8.add(panel_12, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		panel_8.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_8.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setBackground(new Color(105,105,105,180));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{115, 265, 0};
		gbl_panel_2.rowHeights = new int[]{0, 24, 19, 19, 23, 19, 19, 35, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblAccolades = new JLabel("Accolades");
		lblAccolades.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblAccolades.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAccolades = new GridBagConstraints();
		gbc_lblAccolades.anchor = GridBagConstraints.WEST;
		gbc_lblAccolades.insets = new Insets(0, 0, 5, 0);
		gbc_lblAccolades.gridx = 1;
		gbc_lblAccolades.gridy = 0;
		panel_2.add(lblAccolades, gbc_lblAccolades);
		
		JLabel lblNewLabel_1 = new JLabel("Step:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("1. 1,000-babysteps");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		panel_2.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("2. 5,000-growing calf");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_7.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 2;
		panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("3. 10,000-marathon");
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_8.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 3;
		panel_2.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblCal = new JLabel("Cal:");
		lblCal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCal.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCal = new GridBagConstraints();
		gbc_lblCal.fill = GridBagConstraints.BOTH;
		gbc_lblCal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCal.gridx = 0;
		gbc_lblCal.gridy = 4;
		panel_2.add(lblCal, gbc_lblCal);
		
		JLabel lblNewLabel_9 = new JLabel("1. BMR+750- Kindle");
		lblNewLabel_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_9.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 4;
		panel_2.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("2. BMR+1250 - Fire Baby");
		lblNewLabel_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 5;
		panel_2.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		
		
		JLabel lblBmr = new JLabel("3. BMR +1750 - Human Torch");
		lblBmr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblBmr.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblBmr = new GridBagConstraints();
		gbc_lblBmr.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBmr.insets = new Insets(0, 0, 5, 0);
		gbc_lblBmr.gridx = 1;
		gbc_lblBmr.gridy = 6;
		panel_2.add(lblBmr, gbc_lblBmr);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblDistance.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDistance = new GridBagConstraints();
		gbc_lblDistance.anchor = GridBagConstraints.NORTH;
		gbc_lblDistance.insets = new Insets(0, 0, 5, 5);
		gbc_lblDistance.gridx = 0;
		gbc_lblDistance.gridy = 8;
		panel_2.add(lblDistance, gbc_lblDistance);
		
		JLabel lblAnotherOne = new JLabel("1. 1-Another One");
		lblAnotherOne.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblAnotherOne.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAnotherOne = new GridBagConstraints();
		gbc_lblAnotherOne.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnotherOne.insets = new Insets(0, 0, 5, 0);
		gbc_lblAnotherOne.gridx = 1;
		gbc_lblAnotherOne.gridy = 8;
		panel_2.add(lblAnotherOne, gbc_lblAnotherOne);
		
		JLabel lblThird = new JLabel("2. 3 Third Time's the Charm");
		lblThird.setForeground(Color.WHITE);
		lblThird.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		GridBagConstraints gbc_lblThird = new GridBagConstraints();
		gbc_lblThird.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblThird.insets = new Insets(0, 0, 5, 0);
		gbc_lblThird.gridx = 1;
		gbc_lblThird.gridy = 9;
		panel_2.add(lblThird, gbc_lblThird);
		
		JLabel lblMaking = new JLabel("3. 8 Making an Album");
		lblMaking.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblMaking.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMaking = new GridBagConstraints();
		gbc_lblMaking.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMaking.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaking.gridx = 1;
		gbc_lblMaking.gridy = 10;
		panel_2.add(lblMaking, gbc_lblMaking);
		
		JLabel lblFlights = new JLabel("Flights:");
		lblFlights.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblFlights.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblFlights = new GridBagConstraints();
		gbc_lblFlights.anchor = GridBagConstraints.NORTH;
		gbc_lblFlights.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlights.gridx = 0;
		gbc_lblFlights.gridy = 11;
		panel_2.add(lblFlights, gbc_lblFlights);
		
		JLabel lblUp = new JLabel("1. 10 Up or Down");
		lblUp.setForeground(Color.WHITE);
		lblUp.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		GridBagConstraints gbc_lblUp = new GridBagConstraints();
		gbc_lblUp.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUp.insets = new Insets(0, 0, 5, 0);
		gbc_lblUp.gridx = 1;
		gbc_lblUp.gridy = 11;
		panel_2.add(lblUp, gbc_lblUp);
		
		JLabel lblStep = new JLabel("2. 20 Step Machine?");
		lblStep.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblStep.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblStep = new GridBagConstraints();
		gbc_lblStep.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblStep.insets = new Insets(0, 0, 5, 0);
		gbc_lblStep.gridx = 1;
		gbc_lblStep.gridy = 12;
		panel_2.add(lblStep, gbc_lblStep);
		
		JLabel lblElevator = new JLabel("3. Elevator");
		lblElevator.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblElevator.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblElevator = new GridBagConstraints();
		gbc_lblElevator.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblElevator.insets = new Insets(0, 0, 5, 0);
		gbc_lblElevator.gridx = 1;
		gbc_lblElevator.gridy = 13;
		panel_2.add(lblElevator, gbc_lblElevator);
		
		JLabel lblActiveMinutes = new JLabel("Active Minutes:");
		lblActiveMinutes.setForeground(Color.WHITE);
		lblActiveMinutes.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		GridBagConstraints gbc_lblActiveMinutes = new GridBagConstraints();
		gbc_lblActiveMinutes.anchor = GridBagConstraints.NORTH;
		gbc_lblActiveMinutes.insets = new Insets(0, 0, 5, 5);
		gbc_lblActiveMinutes.gridx = 0;
		gbc_lblActiveMinutes.gridy = 14;
		panel_2.add(lblActiveMinutes, gbc_lblActiveMinutes);
		
		JLabel lblUpOr_1 = new JLabel("1. 60 Power Hour");
		lblUpOr_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpOr_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUpOr_1 = new GridBagConstraints();
		gbc_lblUpOr_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUpOr_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblUpOr_1.gridx = 1;
		gbc_lblUpOr_1.gridy = 14;
		panel_2.add(lblUpOr_1, gbc_lblUpOr_1);
		
		JLabel lblNewLabel_10 = new JLabel("2. 120 Double Time");
		lblNewLabel_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_10.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 15;
		panel_2.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblUpOr = new JLabel("3. 200 - Need a Break");
		lblUpOr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblUpOr.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUpOr = new GridBagConstraints();
		gbc_lblUpOr.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUpOr.gridx = 1;
		gbc_lblUpOr.gridy = 16;
		panel_2.add(lblUpOr, gbc_lblUpOr);
		viewport.setOpaque(false);
		scrollPane.setViewport(viewport);
		
		scrollPane.setBackground(new Color(105, 105, 105));
		//scrollPane.setScrollPosition(new Point(20, 20));
		scrollPane.setSize(new Dimension(5, 5));
		scrollPane.setMinimumSize(new Dimension(5, 5));
		scrollPane.setPreferredSize(new Dimension(1000, 200));
		
		JLabel label_6 = new JLabel("");
		
		JLabel label_17 = new JLabel("");
		
		JLabel label_23 = new JLabel("");
		
		
		JLabel lblNewLabel_12 = new JLabel("Flights");
		lblNewLabel_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setForeground(Color.WHITE);
		
	
		/*Today Title*/
		
		Date dateAndTime = Calendar.getInstance().getTime();
		
		
		
	}
}
