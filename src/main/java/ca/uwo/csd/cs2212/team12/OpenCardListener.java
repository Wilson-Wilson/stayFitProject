package ca.uwo.csd.cs2212.team12;
import javax.swing.GroupLayout.Alignment;
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

public class OpenCardListener extends JPanel{

    //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
    ImageIcon backImage = ImageClass.getBackImage();

    /**
     * Create the application.
     */
    public OpenCardListener(int num) {
        initialize(num);
    }

    /**
     * Initialize the contents of the panel; sub-panels, labels, borders and etc.
     * @param num int used to choose which details of the panel to display
     */
    private void initialize(int num) {

        final CardLayout cl = new CardLayout(0,0);
        this.setLayout(new CardLayout(0,0));
        final JPanel panel_3 = new JPanel();
        this.add(panel_3, "3");
        panel_3.setLayout(cl);
        cl.show(panel_3, "2");
        BackgroundPanel dashPanel = new BackgroundPanel(backImage);
        dashPanel.setBackground(new Color(0, 128, 0));
        panel_3.add(dashPanel, "2");
        JPanel cardPanel= new JPanel();

        /**
         * The details aforementioned being; calories, minutes, floors and etc.
         */
        if (num==1){
            CalPanel calPanel = new CalPanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
            calPanel.setOpaque(false);
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(calPanel, BorderLayout.CENTER);;;;
            cardPanel.setLayout(new BorderLayout(0, 0));
        }
        if (num==2 && Preferences.showMinutesCard==true){
            MinPanel minPanel = new MinPanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
            minPanel.setOpaque(false);
            //cardPanel.add(life, "9");
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(minPanel, BorderLayout.CENTER);
            cardPanel.setLayout(new BorderLayout(0, 0));
        }
        if (num==3 && Preferences.showMovementsCard==true){
            MovePanel movePanel = new MovePanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
            movePanel.setOpaque(false);
            //cardPanel.add(life, "9");
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(movePanel, BorderLayout.CENTER);
            cardPanel.setLayout(new BorderLayout(0, 0));
        }
        if (num==4 && Preferences.showLifetimeCard==true){
            LifePanel life = new LifePanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
            life.setOpaque(false);
            //cardPanel.add(life, "9");
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(life, BorderLayout.CENTER);;;;
            cardPanel.setLayout(new BorderLayout(0, 0));
        }
        if (num==5 && Preferences.showTimeSeriesCard==true){
            TimePanel timePanel = new TimePanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
            timePanel.setOpaque(false);
            //cardPanel.add(life, "9");
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(timePanel, BorderLayout.CENTER);
            cardPanel.setLayout(new BorderLayout(0, 0));
        }

        if (num==6 && Preferences.showBestDaysCard==true){
            BestPanel bestPanel = new BestPanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
            bestPanel.setOpaque(false);
            //cardPanel.add(life, "9");
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(bestPanel, BorderLayout.CENTER);
            cardPanel.setLayout(new BorderLayout(0, 0));
        }
        if (num==7){
            SettingsPanel settingsPanel= new SettingsPanel();
            settingsPanel.setOpaque(false);
            //cardPanel.add(life, "9");
            dashPanel.setLayout(new BorderLayout(0, 0));
            dashPanel.add(settingsPanel, BorderLayout.CENTER);
            cardPanel.setLayout(new BorderLayout(0, 0));

        }

        /**
         * End of the list of possible details to display
         */
        
        /**
         *panel_15 is a panel that acts as a taskbar in the south border of the dashpanel, 
         *holding the trophy, home and other buttons.
         */
		/*Trophy*/
        //setting the panel for trophy
        JPanel panel_15 = new JPanel();
        panel_15.setOpaque(false);
        dashPanel.add(panel_15, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(105, 105, 105,180));
        JButton trophyButton = new JButton("");
        trophyButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        trophyButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        trophyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        trophyButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        trophyButton.setContentAreaFilled(false);
        trophyButton.setHorizontalAlignment(SwingConstants.RIGHT);
        trophyButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        trophyButton.setVerticalAlignment(SwingConstants.BOTTOM);
        trophyButton.setBorder(null);
        trophyButton.setBorderPainted(false);
        trophyButton.setToolTipText("Goals & Accolades");

        trophyButton.setIcon(ImageClass.getTrophyIcon2());

        JButton userButton = new JButton("Beth Locke");
        userButton.setFont(new Font("Arial", Font.PLAIN, 15));
        userButton.setForeground(new Color(255, 255, 255));
        userButton.setContentAreaFilled(false);
        userButton.setBorder(null);
        userButton.setBorderPainted(false);

        JButton timeseriesButton = new JButton("");
        timeseriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        timeseriesButton.setContentAreaFilled(false);
        timeseriesButton.setIcon(ImageClass.getTimeseriesIcon());
        timeseriesButton.setBorder(null);
        timeseriesButton.setBorderPainted(false);
        timeseriesButton.setToolTipText("Time Series");
        timeseriesButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(5);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});
        JButton bestButton = new JButton("");
        bestButton.setBorder(null);
        bestButton.setIcon(ImageClass.getBestdayIcon());
        bestButton.setContentAreaFilled(false);
        bestButton.setToolTipText("Best Days");
        bestButton.setBorder(null);
        bestButton.setBorderPainted(false);
        bestButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bestButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(6);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});
        JButton caloriesButton = new JButton("");
        caloriesButton.setIcon(ImageClass.getCaloriesIcon());
        caloriesButton.setContentAreaFilled(false);
        caloriesButton.setBorder(null);
        caloriesButton.setBorderPainted(false);
        caloriesButton.setToolTipText("Calories");
        caloriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        caloriesButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(1);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});
        JButton movementButton = new JButton("");
        movementButton.setContentAreaFilled(false);
        movementButton.setBorder(null);
        movementButton.setBorderPainted(false);
        movementButton.setIcon(ImageClass.getMovementIcon());
        movementButton.setToolTipText("Movement");
		movementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        movementButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(3);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});
        JButton minutesButton = new JButton("");
        minutesButton.setIcon(ImageClass.getMinutesIcon());
        minutesButton.setBorder(null);
        minutesButton.setBorderPainted(false);
        minutesButton.setContentAreaFilled(false);
        minutesButton.setToolTipText("Minutes");
		minutesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minutesButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(2);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});
        JButton lifetimeButton = new JButton("");
        lifetimeButton.setContentAreaFilled(false);
        lifetimeButton.setBorder(null);
        lifetimeButton.setBorderPainted(false);
        lifetimeButton.setIcon(ImageClass.getLifetimeIcon());
        lifetimeButton.setToolTipText("Lifetime");
		lifetimeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lifetimeButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(4);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});
        
		JButton homebutton = new JButton("");
		homebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 homebutton.setToolTipText("Dashboard");
		homebutton.addActionListener(new ActionListener() {

	            
	            public void actionPerformed(ActionEvent ae) {
	                //cl.show(panel_3,"2");
	            	DashBoardPanel dash= new DashBoardPanel();
	        		panel_3.add(dash,"11");
	        		cl.show(panel_3,"11");
	        		dash.checkPref();

	            }});


		homebutton.setContentAreaFilled(false);
		homebutton.setIcon(ImageClass.getHomebuttonIcon());
		homebutton.setBorder(null);
		homebutton.setBorderPainted(false);
		 homebutton .addActionListener(new ActionListener() {

	            
	            public void actionPerformed(ActionEvent ae) {


	            	//cl.show(panel_3,"9");
	            	OpenCardListener opencard = new OpenCardListener(6);
	        		panel_3.add(opencard,"10") ;
	        		cl.show(panel_3,"10");

	            }});
            
		

		JButton settingsbutton = new JButton("");
		settingsbutton.setContentAreaFilled(false);
		settingsbutton.setBorder(null);
		settingsbutton.setIcon(ImageClass.getSettingsIcon());
		settingsbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(timeseriesButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bestButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caloriesButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(movementButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(minutesButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lifetimeButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(homebutton)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(userButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(settingsbutton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(trophyButton))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(homebutton, GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
						.addComponent(caloriesButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(timeseriesButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(userButton, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addComponent(bestButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(movementButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(minutesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(settingsbutton))
						.addComponent(trophyButton)
						.addComponent(lifetimeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		final JLabel lblToday = new JLabel(DashBoardPanel.dateString);
		lblToday.setToolTipText("Please go to the dashboard to change the date");
		settingsbutton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {


                //cl.show(panel_3,"9");
                OpenCardListener opencard = new OpenCardListener(7);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");
                lblToday.setText("Settings");

            }});
		settingsbutton.setToolTipText("Settings");
		 trophyButton.addActionListener(new ActionListener() {


	            public void actionPerformed(ActionEvent ae) {
	            	TrophyPanel trophypanel = new TrophyPanel();
	                panel_3.add( trophypanel,"11") ;
	                cl.show(panel_3,"11");

	            }});
		trophyButton.setToolTipText("Accolades and Goals");
		
		panel_15.setLayout(new BorderLayout(0, 0));
		panel_15.add(panel);
		/**
         * End of panel_15 set up
         */

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(105, 105, 105,180));


		/*Today Title*/

		Date dateAndTime = Calendar.getInstance().getTime();// can be used to display time if added to panel
		dashPanel.add(panel_16, BorderLayout.NORTH);
		panel_16.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblToday.setBackground(new Color(105, 105, 105,180));
		lblToday.setForeground(new Color(255, 255, 255));
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		panel_16.add(lblToday);



	
        
    }
  
    }
