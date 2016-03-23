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
import javax.swing.border.SoftBevelBorder;



public class TrophyPanel extends JPanel{

	private JFrame frame;
  
    protected Color shadowColor = Color.black;
  
    protected Dimension arcs = new Dimension(20, 20);
   
    protected int shadGap = 5;
    protected int shadOffset = 4;
   
	
	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
	
	/**
	 * Create the window by calling initialize.
	 */
	public TrophyPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		final CardLayout cl = new CardLayout(0,0);
		this.setLayout(new CardLayout(0,0));
		final BackgroundPanel panel_3 = new BackgroundPanel(ImageClass.getBackImage());
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
		
		JLabel lblTrophy = new JLabel("Accolades & Goals");
		lblTrophy.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrophy.setIcon(ImageClass.getTrophyIcon2());
		lblTrophy.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTrophy.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(ImageClass.getHomebuttonAltIcon());
		btnNewButton.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
            	DashBoardPanel dash= new DashBoardPanel();
        		panel_3.add(dash,"11");
        		cl.show(panel_3,"11");
        		dash.checkPref();

            }});
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(338)
					.addComponent(lblTrophy)
					.addGap(19))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTrophy)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		panel_13.setLayout(gl_panel_13);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		cardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel11 = new JPanel();
		panel11.setOpaque(false);
		panel.add(panel11, BorderLayout.NORTH);
		JLabel lblNewLabel_5 = new JLabel("Steps Goal:");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel(" Floor Goal:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Distance Goal:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Calories Goal:");
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
		panel_2.setPreferredSize(new Dimension(800, 1000));
		panel_4.add(panel_2);
		panel_2.setBackground(new Color(105,105,105,180));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{155, 119, 142, 0, 233, 28, 0};
		gbl_panel_2.rowHeights = new int[]{33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
				
				
				JLabel lblNewLabel = new JLabel("Accolades");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 2;
				gbc_lblNewLabel.gridy = 0;
				panel_2.add(lblNewLabel, gbc_lblNewLabel);
				
		
				
				JLabel lblNewLabel_1 = new JLabel("Steps:");
				lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
				lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 1;
				panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				
				DataEntry d = new DataEntry();
				JLabel lblNewLabel_6 = new JLabel("1. 1,000 - Babysteps");
				if(d.getStepsTaken()>=1000){
					lblNewLabel_6.setOpaque(true);
					lblNewLabel_6.setBackground(Color.LIGHT_GRAY);
				}
				lblNewLabel_6.setIcon(ImageClass.getTimeseriesAltIcon());
				lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblNewLabel_6.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_6.gridx = 2;
				gbc_lblNewLabel_6.gridy = 2;
				panel_2.add(lblNewLabel_6, gbc_lblNewLabel_6);

				


				
				
				JLabel lblNewLabel_7 = new JLabel("2. 5,000 - Growing Calf");
				if(d.getStepsTaken()>=5000){
					lblNewLabel_7.setOpaque(true);
					lblNewLabel_7.setBackground(Color.LIGHT_GRAY);
				}

				lblNewLabel_7.setIcon(ImageClass.getTimeseriesAltIcon());
				lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblNewLabel_7.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
				gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_7.gridx = 2;
				gbc_lblNewLabel_7.gridy = 3;
				panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);
				
				
	
				
				JLabel lblNewLabel_8 = new JLabel("3. 10,000 - Marathon");
				if(d.getStepsTaken()>=10000){
					lblNewLabel_8.setOpaque(true);
					lblNewLabel_8.setBackground(Color.LIGHT_GRAY);
				}

				lblNewLabel_8.setIcon(ImageClass.getTimeseriesAltIcon());
				lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblNewLabel_8.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
				gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_8.gridx = 2;
				gbc_lblNewLabel_8.gridy = 4;
				panel_2.add(lblNewLabel_8, gbc_lblNewLabel_8);

				
				
				JLabel lblGet = new JLabel("4. 15,000 - Get a Bike");
				if(d.getStepsTaken()>=15000){
					lblGet.setOpaque(true);
					lblGet.setBackground(Color.LIGHT_GRAY);
				}
				lblGet.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblGet.setForeground(Color.WHITE);
				lblGet.setIcon(ImageClass.getTimeseriesAltIcon());
				GridBagConstraints gbc_lblGet = new GridBagConstraints();
				gbc_lblGet.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblGet.insets = new Insets(0, 0, 5, 5);
				gbc_lblGet.gridx = 2;
				gbc_lblGet.gridy = 5;
				panel_2.add(lblGet, gbc_lblGet);
				

				
				JLabel lblCal = new JLabel("Calories:");
				lblCal.setHorizontalAlignment(SwingConstants.CENTER);
				lblCal.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblCal.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblCal = new GridBagConstraints();
				gbc_lblCal.anchor = GridBagConstraints.NORTH;
				gbc_lblCal.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblCal.insets = new Insets(0, 0, 5, 5);
				gbc_lblCal.gridx = 1;
				gbc_lblCal.gridy = 6;
				panel_2.add(lblCal, gbc_lblCal);
				
				JLabel lblNewLabel_9 = new JLabel("1. BMR+750 - Kindle");
				if(d.getCalBurned()>=750){
					lblNewLabel_9.setOpaque(true);
					lblNewLabel_9.setBackground(Color.LIGHT_GRAY);
				}

				lblNewLabel_9.setIcon(ImageClass.getCaloriesAltIcon());
				lblNewLabel_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblNewLabel_9.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
				gbc_lblNewLabel_9.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_9.gridx = 2;
				gbc_lblNewLabel_9.gridy = 7;
				panel_2.add(lblNewLabel_9, gbc_lblNewLabel_9);
				
				
				JLabel lblNewLabel_11 = new JLabel("2. BMR+1250 - Fire Baby");
				if(d.getCalBurned()>=1250){
					lblNewLabel_11.setOpaque(true);
					lblNewLabel_11.setBackground(Color.LIGHT_GRAY);
				}
				lblNewLabel_11.setIcon(ImageClass.getCaloriesAltIcon());
				lblNewLabel_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_11.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
				gbc_lblNewLabel_11.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_11.gridx = 2;
				gbc_lblNewLabel_11.gridy = 8;
				panel_2.add(lblNewLabel_11, gbc_lblNewLabel_11);
				
				
				JLabel lblBmr = new JLabel("3. BMR+1750 - Human Torch");
				if(d.getCalBurned()>=1750){
					lblBmr.setOpaque(true);
					lblBmr.setBackground(Color.LIGHT_GRAY);
				}
				lblBmr.setIcon(ImageClass.getCaloriesAltIcon());
				lblBmr.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblBmr.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblBmr = new GridBagConstraints();
				gbc_lblBmr.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblBmr.insets = new Insets(0, 0, 5, 5);
				gbc_lblBmr.gridx = 2;
				gbc_lblBmr.gridy = 9;
				panel_2.add(lblBmr, gbc_lblBmr);
				
				
				JLabel lblBmr1 = new JLabel("4. BMR+2050 - Smoke and Fire");
				if(d.getCalBurned()>=2050){
					lblBmr1.setOpaque(true);
					lblBmr1.setBackground(Color.LIGHT_GRAY);
				}
				lblBmr1.setIcon(ImageClass.getCaloriesAltIcon());
				lblBmr1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblBmr1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblBmr1 = new GridBagConstraints();
				gbc_lblBmr1.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblBmr1.insets = new Insets(0, 0, 5, 5);
				gbc_lblBmr1.gridx = 2;
				gbc_lblBmr1.gridy = 10;
				panel_2.add(lblBmr1, gbc_lblBmr1);
				
				JLabel lblDistance = new JLabel("Distance:");
				lblDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblDistance.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblDistance = new GridBagConstraints();
				gbc_lblDistance.anchor = GridBagConstraints.NORTH;
				gbc_lblDistance.insets = new Insets(0, 0, 5, 5);
				gbc_lblDistance.gridx = 1;
				gbc_lblDistance.gridy = 11;
				panel_2.add(lblDistance, gbc_lblDistance);
				
				JLabel lblAnotherOne = new JLabel("1. 1km - Another One");
				if(d.getDistanceTravelled()>=1){
					lblAnotherOne.setOpaque(true);
					lblAnotherOne.setBackground(Color.LIGHT_GRAY);
				}
				lblAnotherOne.setIcon(ImageClass.getMovementAltIcon());
				lblAnotherOne.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblAnotherOne.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblAnotherOne = new GridBagConstraints();
				gbc_lblAnotherOne.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblAnotherOne.insets = new Insets(0, 0, 5, 5);
				gbc_lblAnotherOne.gridx = 2;
				gbc_lblAnotherOne.gridy = 12;
				panel_2.add(lblAnotherOne, gbc_lblAnotherOne);
				
				
				JLabel lblThird = new JLabel("2. 3km - Third Time's the Charm");
				if(d.getDistanceTravelled()>=3){
					lblThird.setOpaque(true);
					lblThird.setBackground(Color.LIGHT_GRAY);
				}
				lblThird.setIcon(ImageClass.getMovementAltIcon());
				lblThird.setForeground(Color.WHITE);
				lblThird.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				GridBagConstraints gbc_lblThird = new GridBagConstraints();
				gbc_lblThird.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblThird.insets = new Insets(0, 0, 5, 5);
				gbc_lblThird.gridx = 2;
				gbc_lblThird.gridy = 13;
				panel_2.add(lblThird, gbc_lblThird);
				
				
				JLabel lblMaking = new JLabel("3. 8km - Making an Album");
				if(d.getDistanceTravelled()>=8){
					lblMaking.setOpaque(true);
					lblMaking.setBackground(Color.LIGHT_GRAY);
				}
				lblMaking.setIcon(ImageClass.getMovementAltIcon());
				lblMaking.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblMaking.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblMaking = new GridBagConstraints();
				gbc_lblMaking.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblMaking.insets = new Insets(0, 0, 5, 5);
				gbc_lblMaking.gridx = 2;
				gbc_lblMaking.gridy = 14;
				panel_2.add(lblMaking, gbc_lblMaking);
				
				
				JLabel lblMaking1 = new JLabel("4. 12km - Need a map?");
				if(d.getDistanceTravelled()>=12){
					lblMaking1.setOpaque(true);
					lblMaking1.setBackground(Color.LIGHT_GRAY);
				}
				lblMaking1.setIcon(ImageClass.getMovementAltIcon());
				lblMaking1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblMaking1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblMaking1 = new GridBagConstraints();
				gbc_lblMaking1.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblMaking1.insets = new Insets(0, 0, 5, 5);
				gbc_lblMaking1.gridx = 2;
				gbc_lblMaking1.gridy = 15;
				panel_2.add(lblMaking1, gbc_lblMaking1);
				
				JLabel lblFlights = new JLabel("Flights:");
				lblFlights.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblFlights.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblFlights = new GridBagConstraints();
				gbc_lblFlights.anchor = GridBagConstraints.NORTH;
				gbc_lblFlights.insets = new Insets(0, 0, 5, 5);
				gbc_lblFlights.gridx = 1;
				gbc_lblFlights.gridy = 16;
				panel_2.add(lblFlights, gbc_lblFlights);
				
				JLabel lblUp = new JLabel("1. 10 - Up or Down");
				if(d.getFloorsClimbed()>=10){
					lblUp.setOpaque(true);
					lblUp.setBackground(Color.LIGHT_GRAY);
				}
				lblUp.setIcon(ImageClass.getFlightsIcon());
				lblUp.setForeground(Color.WHITE);
				lblUp.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				GridBagConstraints gbc_lblUp = new GridBagConstraints();
				gbc_lblUp.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblUp.insets = new Insets(0, 0, 5, 5);
				gbc_lblUp.gridx = 2;
				gbc_lblUp.gridy = 17;
				panel_2.add(lblUp, gbc_lblUp);
				
				
				JLabel lblStep = new JLabel("2. 20 - Step Machine?");
				if(d.getFloorsClimbed()>=20){
					lblStep.setOpaque(true);
					lblStep.setBackground(Color.LIGHT_GRAY);
				}
				lblStep.setIcon(ImageClass.getFlightsIcon());
				lblStep.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblStep.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblStep = new GridBagConstraints();
				gbc_lblStep.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblStep.insets = new Insets(0, 0, 5, 5);
				gbc_lblStep.gridx = 2;
				gbc_lblStep.gridy = 18;
				panel_2.add(lblStep, gbc_lblStep);
				
				
				JLabel lblElevator = new JLabel("3. 30 - Elevator");
				if(d.getFloorsClimbed()>=30){
					lblElevator.setOpaque(true);
					lblElevator.setBackground(Color.LIGHT_GRAY);
				}
				lblElevator.setIcon(ImageClass.getFlightsIcon());
				lblElevator.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblElevator.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblElevator = new GridBagConstraints();
				gbc_lblElevator.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblElevator.insets = new Insets(0, 0, 5, 5);
				gbc_lblElevator.gridx = 2;
				gbc_lblElevator.gridy = 19;
				panel_2.add(lblElevator, gbc_lblElevator);
		
		JLabel lblElevator1 = new JLabel("4. 50 - Calves for Days!");
		if(d.getFloorsClimbed()>=50){
			lblElevator1.setOpaque(true);
			lblElevator1.setBackground(Color.LIGHT_GRAY);
		}
		lblElevator1.setIcon(ImageClass.getFlightsIcon());
		lblElevator1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblElevator1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblElevator1 = new GridBagConstraints();
		gbc_lblElevator1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblElevator1.insets = new Insets(0, 0, 5, 5);
		gbc_lblElevator1.gridx = 2;
		gbc_lblElevator1.gridy = 20;
		panel_2.add(lblElevator1, gbc_lblElevator1);
		
		JLabel lblActiveMinutes = new JLabel("Active Minutes:");
		lblActiveMinutes.setForeground(Color.WHITE);
		lblActiveMinutes.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		GridBagConstraints gbc_lblActiveMinutes = new GridBagConstraints();
		gbc_lblActiveMinutes.anchor = GridBagConstraints.NORTH;
		gbc_lblActiveMinutes.insets = new Insets(0, 0, 5, 5);
		gbc_lblActiveMinutes.gridx = 1;
		gbc_lblActiveMinutes.gridy = 21;
		panel_2.add(lblActiveMinutes, gbc_lblActiveMinutes);
		
		JLabel lblUpOr_1 = new JLabel("1. 60 minutes - Power Hour");
		if(d.getActMins()>=60){
			lblUpOr_1.setOpaque(true);
			lblUpOr_1.setBackground(Color.LIGHT_GRAY);
		}
		lblUpOr_1.setIcon(ImageClass.getMinutesAltIcon());
		lblUpOr_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpOr_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUpOr_1 = new GridBagConstraints();
		gbc_lblUpOr_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUpOr_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpOr_1.gridx = 2;
		gbc_lblUpOr_1.gridy = 22;
		panel_2.add(lblUpOr_1, gbc_lblUpOr_1);
		
		JLabel lblNewLabel_10 = new JLabel("2. 120 minutes - Double Time");
		if(d.getActMins()>=120){
			lblNewLabel_10.setOpaque(true);
			lblNewLabel_10.setBackground(Color.LIGHT_GRAY);
		}
		lblNewLabel_10.setIcon(ImageClass.getMinutesAltIcon());
		lblNewLabel_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_10.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 23;
		panel_2.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_15 = new JLabel("3. 200 minutes - Need a Break?");
		if(d.getActMins()>=200){
			lblNewLabel_15.setOpaque(true);
			lblNewLabel_15.setBackground(Color.LIGHT_GRAY);
		}
		
		lblNewLabel_15.setIcon(ImageClass.getMinutesAltIcon());
		lblNewLabel_15.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_15.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 2;
		gbc_lblNewLabel_15.gridy = 24;
		panel_2.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		JLabel lblNewLabel_14 = new JLabel("4. 280 minutes - Marathoner");
		if(d.getActMins()>=280){
			lblNewLabel_14.setOpaque(true);
			lblNewLabel_14.setBackground(Color.LIGHT_GRAY);
		}
		lblNewLabel_14.setIcon(ImageClass.getMinutesAltIcon());
		lblNewLabel_14.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_14.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_14.gridx = 2;
		gbc_lblNewLabel_14.gridy = 25;
		panel_2.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
	
		

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
		
		

		
	
		/*Today Title*/
		
		Date dateAndTime = Calendar.getInstance().getTime();
		
		
		
	}
}
