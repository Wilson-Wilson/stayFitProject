package ca.uwo.csd.cs2212.team12;

import java.awt.*;
import java.awt.event.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.stage.Stage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.GroupLayout.*;
import javax.swing.*;
import javax.swing.LayoutStyle.*;


import javafx.embed.swing.JFXPanel;
import org.jdesktop.swingx.JXDatePicker;
import org.json.JSONException;

import no.tornado.databinding.support.jxdatepicker.*;


public class DashBoardPanel extends JPanel {

    // Data fields that are updated by the Controller on refresh
    String labelDate =  (new SimpleDateFormat("YYYY-MM-dd")).format(date);
    public String caloriesBurned        = String.valueOf(Controller.getTheDictionary().getDictionary().get(labelDate).getCalBurned());
    public String activeMinutes         = String.valueOf(Controller.getTheDictionary().getDictionary().get(labelDate).getActMins());
    public String sedentaryMinutes      = String.valueOf(Controller.getTheDictionary().getDictionary().get(labelDate).getSedMins());
    public String distance              = String.valueOf(Controller.getTheDictionary().getDictionary().get(labelDate).getDistanceTravelled());
    public String floors                = String.valueOf(Controller.getTheDictionary().getDictionary().get(labelDate).getFloorsClimbed());
    public String steps                 = String.valueOf(Controller.getTheDictionary().getDictionary().get(labelDate).getStepsTaken());

    public String lifetimeFloors        = String.valueOf(Controller.getTheUserInfo().getFloorsLife());
    public String lifetimeSteps         = String.valueOf(Controller.getTheUserInfo().getStepsLife());
    public String lifetimeDistance      = String.valueOf(Controller.getTheUserInfo().getDistanceLife());
    public String bestFloors            = String.valueOf(Controller.getTheUserInfo().getFloorsBestVal());
    public String bestSteps             = String.valueOf(Controller.getTheUserInfo().getStepsBestVal());
    public String bestDistance          = String.valueOf(Controller.getTheUserInfo().getDistanceBestVal());

	final JPanel cardPanel = new JPanel();
    final JButton caloriesButton = new JButton("");
    final JButton minutesButton = new JButton("");
    final JButton movementButton = new JButton("");
    final JButton lifetimeButton = new JButton("");
    final JButton timeseriesButton = new JButton("");
    final JButton bestdayButton = new JButton("");


	final static Format formatter = new SimpleDateFormat("MMMM" + " "+"d" + " "+"YYY");
    static Date date= stringToDate(Controller.getTheDictionary().getLatest());
    public static Date stringToDate(String sdate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }



    static Date oldDate = new Date();

    static String oldDateString= formatter.format(oldDate);
    static String dateString= formatter.format(date); //dateString is the unique key used to access the dataEntry hashmap called DataDict

    final JLabel lblNewLabel_3 = new JLabel(dateString);

    
    private JFrame frame;
    public Graph graph = new Graph();
    public JFXPanel graph_panel;

    //Images from the resource folder used throughout the programme


    /**
     * Create the application.
     */
    public DashBoardPanel() {
        initialize();
    }
    
    
    /**
     * Initialize the contents of the panels; sub-panels, labels, borders and etc.
     */
    private void initialize() {
    
   	 final Date dNow = new Date( );
        final SimpleDateFormat timeft =  new SimpleDateFormat ("hh:mm:ss");

        System.out.println("Current Date: " + timeft.format(dNow));
   	

    	
    	
        //main frame

        final CardLayout cl = new CardLayout(0,0);
        this.setLayout(new CardLayout(0,0));

        final JPanel panel_3 = new JPanel();
        this.add(panel_3, "3");
        panel_3.setLayout(cl);
        //panel_1.setBackground(Color.RED);


        BackgroundPanel dashPanel = new BackgroundPanel(ImageClass.getBackImage());
        //dashPanel.setBackground(new Color(0, 128, 0));
        panel_3.add(dashPanel,"1");


        /**Note the card panel holds all the card its at the center of the dash panel,
         * the arrows, trophy and etc are on other sub-panels of the dashpanel
         */

        cardPanel.setOpaque(false);
        cardPanel.setBounds(new Rectangle(200, 200, 200, 200));
        dashPanel.setLayout(new BorderLayout(0, 0));
        dashPanel.add(cardPanel, BorderLayout.CENTER);
        //BasicInternalFrameUI bi = (BasicInternalFrameUI)internalFrame_5.getUI(); //could be used to hide internal frame title bar
        //bi.setNorthPane(null);
        cardPanel.setLayout(new GridLayout(2, 3, 20, 20));
        cardPanel.setLayout(new GridLayout(2, 3, 20, 50));;

        /**
         *These are the individual cards, which are buttons with nested components.
         *each of these are on the card panel.         *
         */

        /*Calories card*/

        //Calories Button
        caloriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        caloriesButton.setBorder(null);
        caloriesButton.setContentAreaFilled(false);
        caloriesButton.setOpaque(false);
        caloriesButton.setMinimumSize(new Dimension(15, 11));
        caloriesButton.setMaximumSize(new Dimension(15, 11));
        caloriesButton.setPreferredSize(new Dimension(15, 11));
        caloriesButton.setIcon(ImageClass.getCardIcon());
        caloriesButton.setLayout(new BorderLayout());
        caloriesButton.setBorder(BorderFactory.createEmptyBorder());
        caloriesButton.addActionListener(new ActionListener() {



            public void actionPerformed(ActionEvent ae) {
                //cl.show(panel_3,"2");
                OpenCardListener opencard = new OpenCardListener(1);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});



        //card panel for calories
        JPanel pl= new JPanel();
        pl.setForeground(new Color(255, 255, 255));
        pl.setOpaque(false);
        caloriesButton.add(pl,BorderLayout.NORTH);

        //exit button for the calories card
        JButton calExit = new JButton("");
        calExit. addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( caloriesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
                Preferences.showCaloriesCard=false;
                dialogHandler();
            }



        });








        //the label for the title of the calories card
        RichJLabel lblCalories_1 = new RichJLabel("Calories", 16);
        lblCalories_1.setOutline(new Color(0, 0, 0, 180));
        lblCalories_1.setIcon(ImageClass.getCaloriesIcon());
        lblCalories_1.setForeground(new Color(255, 255, 255));
        calExit.setContentAreaFilled(false);
        calExit.setBorder(null);
        calExit.setBorderPainted(false);
        calExit.setIcon(ImageClass.getExitIcon());
        GroupLayout gl_pl = new GroupLayout(pl);
        gl_pl.setHorizontalGroup(
                gl_pl.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblCalories_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(125)
                                .addComponent(calExit, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
        );
        gl_pl.setVerticalGroup(
                gl_pl.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(lblCalories_1)
                                        .addComponent(calExit))
                                .addGap(11))
        );
        pl.setLayout(gl_pl);
        calExit. addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( caloriesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
            }

        });


        cardPanel.add(caloriesButton);

        JPanel calinfoPanel= new JPanel();
        calinfoPanel.setOpaque(false);
        caloriesButton.add(calinfoPanel, BorderLayout.CENTER);
        
        JLabel lblCaloriesBurned = new JLabel("Calories Burned: "+caloriesBurned);
        lblCaloriesBurned.setForeground(Color.WHITE);
        lblCaloriesBurned.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        GroupLayout gl_calinfoPanel = new GroupLayout(calinfoPanel);
        gl_calinfoPanel.setHorizontalGroup(
        	gl_calinfoPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_calinfoPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblCaloriesBurned, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(17))
        );
        gl_calinfoPanel.setVerticalGroup(
        	gl_calinfoPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_calinfoPanel.createSequentialGroup()
        			.addComponent(lblCaloriesBurned)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        calinfoPanel.setLayout(gl_calinfoPanel);


		 /*Minutes card*/

        //Minutes Button
        minutesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        minutesButton.setContentAreaFilled(false);
        minutesButton.setOpaque(false);
        minutesButton.setBorder(null);
        minutesButton.setIcon(ImageClass.getCardIcon());
        minutesButton.setBorder(null);
        minutesButton.setLayout(new BorderLayout());
        
        
        minutesButton .addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {


                //cl.show(panel_3,"4");
                OpenCardListener opencard = new OpenCardListener(2);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");


            }});

        //card panel for minutes
        JPanel pl2= new JPanel();
        pl2.setOpaque(false);
        pl2.setForeground(new Color(255, 255, 255));
        pl2.setForeground(new Color(255, 255, 255));
        minutesButton.add(pl2,BorderLayout.NORTH);
        cardPanel.add(minutesButton);//adding it to the cardpanel
        //button for minute exit
        JButton minExit = new JButton("");
        minExit.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( minutesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
                Preferences.showMinutesCard=false;
                dialogHandler();
            }

        });


        minExit .setContentAreaFilled(false);
        minExit .setBorder(null);
        minExit.setBorderPainted(false);
        minExit .setIcon(ImageClass.getExitIcon());

        //the label for the title of the minutes card
        RichJLabel lblMinutes = new RichJLabel("Minutes", 16);
        lblMinutes.setOutline(new Color(0, 0, 0, 180));
        lblMinutes.setForeground(new Color(255, 255, 255));
        lblMinutes.setIcon(ImageClass.getMinutesIcon());


        GroupLayout gl_pl2 = new GroupLayout(pl2);
        gl_pl2.setHorizontalGroup(
                gl_pl2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl2.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblMinutes)
                                .addGap(130)
                                .addComponent(minExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl2.setVerticalGroup(
                gl_pl2.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl2.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl2.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblMinutes)
                                        .addComponent(minExit)))
        );
        pl2.setLayout(gl_pl2);

        JPanel mininfoPanel= new JPanel();
        mininfoPanel.setOpaque(false);
        minutesButton.add(mininfoPanel, BorderLayout.CENTER);
        
        JLabel lblSedimentaryMinutes = new JLabel("Sedentary Minutes: "+sedentaryMinutes);
        lblSedimentaryMinutes.setForeground(Color.WHITE);
        lblSedimentaryMinutes.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        
        JLabel lblActiveMinutes = new JLabel("Active Minutes: " + activeMinutes);
        lblActiveMinutes.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblActiveMinutes.setForeground(Color.WHITE);
        GroupLayout gl_mininfoPanel = new GroupLayout(mininfoPanel);
        gl_mininfoPanel.setHorizontalGroup(
        	gl_mininfoPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_mininfoPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSedimentaryMinutes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(19))
        		.addGroup(gl_mininfoPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblActiveMinutes, GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
        			.addGap(41))
        );
        gl_mininfoPanel.setVerticalGroup(
        	gl_mininfoPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_mininfoPanel.createSequentialGroup()
        			.addComponent(lblActiveMinutes, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblSedimentaryMinutes, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        mininfoPanel.setLayout(gl_mininfoPanel);

		 /*Movement card */

        //Movement Button
        movementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        movementButton.setContentAreaFilled(false);
        movementButton.setBorder(null);
        movementButton.setIcon(ImageClass.getCardIcon());
        movementButton.setBorder(null);
        movementButton.setLayout(new BorderLayout());
        movementButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {

                //cl.show(panel_3,"6");
                OpenCardListener opencard = new OpenCardListener(3);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});


        //card panel for movement
        JPanel pl3= new JPanel();
        pl3.setOpaque(false);
        movementButton.add(pl3, BorderLayout.NORTH);

        //the label for the title of the movements card
        RichJLabel lblMovements = new RichJLabel("Movements", 16);
        lblMovements.setOutline(new Color(0, 0, 0, 180));
        lblMovements.setForeground(new Color(255, 255, 255));
        lblMovements.setIcon(ImageClass.getMovementIcon());


        //exit button for movement
        JButton moveExit = new JButton("");
        moveExit. addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( movementButton);
                cardPanel.invalidate();
                cardPanel.repaint();
                Preferences.showMovementsCard=false;
                dialogHandler();
            }

        });
        moveExit.setContentAreaFilled(false);
        moveExit.setBorder(null);
        moveExit.setIcon(ImageClass.getExitIcon());
        moveExit.setBorderPainted(false);
        GroupLayout gl_pl3 = new GroupLayout(pl3);
        gl_pl3.setHorizontalGroup(
                gl_pl3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl3.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblMovements)
                                .addGap(115)
                                .addComponent(moveExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl3.setVerticalGroup(
                gl_pl3.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl3.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl3.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblMovements)
                                        .addComponent(moveExit)))
        );
        pl3.setLayout(gl_pl3);




        cardPanel.add(movementButton);;

        JPanel moveinfoPanel= new JPanel();
        moveinfoPanel.setOpaque(false);
        movementButton.add(moveinfoPanel, BorderLayout.CENTER);
        
        JLabel lblSteps = new JLabel("Steps: " + steps);
        lblSteps.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSteps.setForeground(Color.WHITE);

        JLabel lblFloors = new JLabel("Floors: " + floors);
        lblFloors.setFont(new Font("Arial", Font.PLAIN, 15));
        lblFloors.setForeground(Color.WHITE);

        JLabel lblDistance = new JLabel("Distance: "+distance);
        lblDistance.setFont(new Font("Arial", Font.PLAIN, 15));
        lblDistance.setForeground(Color.WHITE);
        GroupLayout gl_moveinfoPanel = new GroupLayout(moveinfoPanel);
        gl_moveinfoPanel.setHorizontalGroup(
        	gl_moveinfoPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_moveinfoPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_moveinfoPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_moveinfoPanel.createSequentialGroup()
        					.addComponent(lblFloors, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        					.addGap(10))
        				.addComponent(lblSteps, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        				.addComponent(lblDistance, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
        );
        gl_moveinfoPanel.setVerticalGroup(
        	gl_moveinfoPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_moveinfoPanel.createSequentialGroup()
        			.addGap(16)
        			.addComponent(lblDistance)
        			.addGap(18)
        			.addComponent(lblFloors)
        			.addGap(20)
        			.addComponent(lblSteps)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        moveinfoPanel.setLayout(gl_moveinfoPanel);

		 /*Lifetime  card*/


        //Lifetime button
        lifetimeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lifetimeButton.setContentAreaFilled(false);
        lifetimeButton.setBorder(null);
        lifetimeButton.setIcon(ImageClass.getCardIcon());
        lifetimeButton.setLayout(new BorderLayout());
        lifetimeButton .addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {

                //cl.show(panel_3,"7");
                OpenCardListener opencard = new OpenCardListener(4);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");
            }});



        //card panel for lifetime
        JPanel pl4= new JPanel();
        pl4.setOpaque(false);
        pl4.setFont(new Font("Verdana", Font.BOLD, 13));
        pl4.setForeground(new Color(255, 255, 255));
        lifetimeButton.add(pl4,BorderLayout.NORTH);

        //the label for the title of the lifetime card
        RichJLabel lblLifetime_1 = new RichJLabel("Lifetime", 16);
        lblLifetime_1.setOutline(new Color(0, 0, 0, 180));
        lblLifetime_1.setForeground(new Color(255, 255, 255));
        lblLifetime_1.setIcon(ImageClass.getLifetimeIcon());

        //exit button for lifetime card
        final JButton lifeExit= new JButton("");
        lifeExit.setContentAreaFilled(false);
        lifeExit. addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove(lifetimeButton);
                cardPanel.invalidate();
                //cardPanel.revalidate();
                cardPanel.repaint();
                Preferences.showLifetimeCard=false;
                dialogHandler();
            }

        });
        lifeExit.setIcon(ImageClass.getExitIcon());
        lifeExit.setBorder(null);
        lifeExit.setBorderPainted(false);
        GroupLayout gl_pl4 = new GroupLayout(pl4);
        gl_pl4.setHorizontalGroup(
                gl_pl4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl4.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblLifetime_1)
                                .addGap(125)
                                .addComponent(lifeExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl4.setVerticalGroup(
                gl_pl4.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl4.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl4.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblLifetime_1)
                                        .addComponent(lifeExit)))
        );
        pl4.setLayout(gl_pl4);
        cardPanel.add(lifetimeButton);;

        JPanel lifeinfoPanel= new JPanel();
        lifeinfoPanel.setOpaque(false);
        lifetimeButton.add(lifeinfoPanel, BorderLayout.CENTER);

        JLabel lblNewLabel_2 = new JLabel("Lifetime Floors: " + lifetimeFloors);
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel_2.setForeground(Color.WHITE);

        JLabel lblNewLabel_1 = new JLabel("Lifetime Steps: " + lifetimeSteps);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));

        JLabel lblLifetimeCalories = new JLabel("Lifetime Distance: " + lifetimeDistance);
        lblLifetimeCalories.setFont(new Font("Arial", Font.PLAIN, 15));
        lblLifetimeCalories.setForeground(Color.WHITE);
        GroupLayout gl_lifeinfoPanel = new GroupLayout(lifeinfoPanel);
        gl_lifeinfoPanel.setHorizontalGroup(
                gl_lifeinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_lifeinfoPanel.createSequentialGroup()
                                .addGroup(gl_lifeinfoPanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING, gl_lifeinfoPanel.createSequentialGroup()
                                                .addGap(8)
                                                .addComponent(lblNewLabel_2))
                                        .addGroup(Alignment.LEADING, gl_lifeinfoPanel.createSequentialGroup()
                                                .addGap(9)
                                                .addGroup(gl_lifeinfoPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblLifetimeCalories, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 106, Short.MAX_VALUE)
                                                        .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                                .addGap(0))
        );
        gl_lifeinfoPanel.setVerticalGroup(
                gl_lifeinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_lifeinfoPanel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblNewLabel_2)
                                .addGap(21)
                                .addComponent(lblNewLabel_1)
                                .addGap(23)
                                .addComponent(lblLifetimeCalories)
                                .addContainerGap())
        );
        lifeinfoPanel.setLayout(gl_lifeinfoPanel);
			 /*Time Series card*/

        //Time Series button
        timeseriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        timeseriesButton.setContentAreaFilled(false);
        timeseriesButton.setBorder(null);
        timeseriesButton.setIcon(ImageClass.getCardIcon());
        timeseriesButton.setLayout(new BorderLayout());
        timeseriesButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {

                //cl.show(panel_3,"8");
                OpenCardListener opencard = new OpenCardListener(5);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});


        //card panel for time series
        JPanel pl5= new JPanel();
        pl5.setOpaque(false);
        pl5.setFont(new Font("Verdana", Font.BOLD, 13));
        pl5.setForeground(new Color(255, 255, 255));
        

        timeseriesButton.add(pl5,BorderLayout.NORTH);
        JPanel plh1= new JPanel();
        plh1.setOpaque(false);
        plh1.setFont(new Font("Verdana", Font.BOLD, 13));
        plh1.setForeground(new Color(255, 255, 255));
        plh1.setLayout(new BorderLayout());
        
        JPanel plh2= new JPanel();
        plh2.setOpaque(false);
        plh2.setFont(new Font("Verdana", Font.BOLD, 13));
        plh2.setForeground(new Color(255, 255, 255));
        
        JPanel plh3 = new JPanel();
        plh3.setOpaque(false);
        plh3.setFont(new Font("Verdana", Font.BOLD, 13));
        plh3.setForeground(new Color(255, 255, 255));
        
        JPanel plh4 = new JPanel();
        plh4.setOpaque(false);
        plh4.setFont(new Font("Verdana", Font.BOLD, 13));
        plh4.setForeground(new Color(255, 255, 255));
        
        JPanel plh5 = new JPanel();
        plh5.setOpaque(false);
        plh5.setFont(new Font("Verdana", Font.BOLD, 13));
        plh5.setForeground(new Color(255, 255, 255));
        
        graph_panel = graph.setAll();
        plh1.add(graph_panel, BorderLayout.CENTER);
        plh1.add(plh2,BorderLayout.WEST);
        plh1.add(plh3,BorderLayout.EAST);
        plh1.add(plh4,BorderLayout.SOUTH);
        plh1.add(plh5,BorderLayout.NORTH);
        timeseriesButton.add(plh1,BorderLayout.CENTER);
        
        
        //the label for the title of the time series card
        RichJLabel lastupdatedSeries = new RichJLabel("Time Series", 16);
        lastupdatedSeries.setOutline(new Color(0, 0, 0, 180));
        lastupdatedSeries.setForeground(new Color(255, 255, 255));
        lastupdatedSeries.setIcon(ImageClass.getTimeseriesIcon());

        //Exit button for time series card
        JButton timeExit = new JButton("");
        timeExit. addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( timeseriesButton);
                cardPanel.invalidate();
                cardPanel.repaint();
                Preferences.showTimeSeriesCard=false;
                dialogHandler();
            }

        });
        timeExit.setContentAreaFilled(false);
        timeExit.setIcon(ImageClass.getExitIcon());
        timeExit.setBorder(null);
        timeExit.setBorderPainted(false);
        GroupLayout gl_pl5 = new GroupLayout(pl5);
        gl_pl5.setHorizontalGroup(
                gl_pl5.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl5.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lastupdatedSeries)
                                .addGap(105)
                                .addComponent(timeExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pl5.setVerticalGroup(
                gl_pl5.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl5.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl5.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lastupdatedSeries)
                                        .addComponent(timeExit)))
        );
        pl5.setLayout(gl_pl5);

        cardPanel.add(timeseriesButton);

			 /*Best Days*/


        //Best Days button

        bestdayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bestdayButton.setContentAreaFilled(false);
        bestdayButton.setBorder(null);
        bestdayButton.setIcon(ImageClass.getCardIcon());
        bestdayButton.setLayout(new BorderLayout());
        bestdayButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {


                //cl.show(panel_3,"9");
                OpenCardListener opencard = new OpenCardListener(6);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});

        //card panel for best day
        JPanel pl6= new JPanel();
        pl6.setOpaque(false);
        pl6.setFont(new Font("Verdana", Font.BOLD, 13));
        pl6.setForeground(new Color(255, 255, 255));
        bestdayButton.add(pl6,BorderLayout.NORTH);

        //the label for the title of the best days card
        RichJLabel lblBestDays_1 = new RichJLabel("Best Days", 16);
        lblBestDays_1.setOutline(new Color(0, 0, 0, 180));
        lblBestDays_1.setForeground(new Color(255, 255, 255));
        lblBestDays_1.setIcon(ImageClass.getBestdayIcon());

        //exit button for best days card
        JButton bestExit = new JButton("");
        bestExit. addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cardPanel.remove( bestdayButton);
                cardPanel.invalidate();
                cardPanel.repaint();
                Preferences.showBestDaysCard=false;
                dialogHandler();
            }

        });
        bestExit.setContentAreaFilled(false);
        bestExit.setBorder(null);
        bestExit.setIcon(ImageClass.getExitIcon());
        bestExit.setBorderPainted(false);
        GroupLayout gl_pl6 = new GroupLayout(pl6);
        gl_pl6.setHorizontalGroup(
                gl_pl6.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl6.createSequentialGroup()
                                .addGap(7)
                                .addComponent(lblBestDays_1)
                                .addGap(125)
                                .addComponent(bestExit))
        );
        gl_pl6.setVerticalGroup(
                gl_pl6.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_pl6.createSequentialGroup()
                                .addGap(4)
                                .addGroup(gl_pl6.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblBestDays_1)
                                        .addComponent(bestExit)))
        );
        pl6.setLayout(gl_pl6);
        cardPanel.add(bestdayButton);

        JPanel bestinfoPanel= new JPanel();
        bestinfoPanel.setOpaque(false);
        bestdayButton.add(bestinfoPanel, BorderLayout.CENTER);

        JLabel lblBestFloors = new JLabel("Best Floors: " + bestFloors);
        lblBestFloors.setFont(new Font("Arial", Font.PLAIN, 15));
        lblBestFloors.setForeground(Color.WHITE);

        JLabel lblBestSteps = new JLabel("Best Steps: " + bestSteps);
        lblBestSteps.setFont(new Font("Arial", Font.PLAIN, 15));
        lblBestSteps.setForeground(Color.WHITE);

        JLabel lblBestDistance = new JLabel("Best Distance: " + bestDistance);
        lblBestDistance.setFont(new Font("Arial", Font.PLAIN, 15));
        lblBestDistance.setForeground(Color.WHITE);
        GroupLayout gl_bestinfoPanel = new GroupLayout(bestinfoPanel);
        gl_bestinfoPanel.setHorizontalGroup(
                gl_bestinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bestinfoPanel.createSequentialGroup()
                                .addGap(11)
                                .addComponent(lblBestFloors, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(21))
                        .addGroup(gl_bestinfoPanel.createSequentialGroup()
                                .addGap(12)
                                .addComponent(lblBestSteps, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14))
                        .addGroup(Alignment.TRAILING, gl_bestinfoPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBestDistance, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_bestinfoPanel.setVerticalGroup(
                gl_bestinfoPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bestinfoPanel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblBestFloors)
                                .addGap(21)
                                .addComponent(lblBestSteps)
                                .addGap(25)
                                .addComponent(lblBestDistance)
                                .addContainerGap())
        );
        bestinfoPanel.setLayout(gl_bestinfoPanel);
        /**
         * End of the card panel and it's subcomponent set up.
         */



        /**
         * The left and right arrows are on the actual dashPanel,
         * in the west and east borers of it's layout respectively.         *
         */

        //Left Arrow
        JButton leftarrow = new JButton("");
        leftarrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leftarrow.setBorder(null);
        leftarrow.setBorderPainted(false);
        leftarrow.setContentAreaFilled(false);
        leftarrow.setOpaque(false);
        leftarrow.setIcon(ImageClass.getLeftarrowIcon());
        leftarrow.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {

            	oldDate = date;
				oldDateString = dateString;
				date= subtractDay(date);
				dateString = formatter.format(date);
				
				System.out.println(date.toString());
				try {
					Controller.changeDate(dateString, oldDateString);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				lblNewLabel_3.setText(dateString);
            	DashBoardPanel dash= new DashBoardPanel();
        		panel_3.add(dash,"11");
        		cl.show(panel_3,"11");
        		dash.checkPref();
                

            }});
        
        dashPanel.add(leftarrow, BorderLayout.WEST);


        //RightArrow
        JButton rightarrow = new JButton("");
        rightarrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rightarrow.setBorder(null);
        rightarrow.setContentAreaFilled(false);
        rightarrow.setBorderPainted(false);
        rightarrow.setOpaque(false);
        rightarrow.setIcon(ImageClass.getRightarrowIcon());
        rightarrow.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {

            	oldDate = date;
				oldDateString = dateString;
				date= addDay(date);
				dateString = formatter.format(date);
				
				System.out.println(date.toString());
				try {
					Controller.changeDate(dateString, oldDateString);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				lblNewLabel_3.setText(dateString);
            	DashBoardPanel dash= new DashBoardPanel();
        		panel_3.add(dash,"11");
        		cl.show(panel_3,"11");
        		dash.checkPref();
                

            }});
        
        dashPanel.add(rightarrow, BorderLayout.EAST);



        /**
         *panel_15 is a panel that acts as a taskbar in the south border of the dashpanel,
         *holding the settings, trophy and other buttons
         */

		/*Trophy*/

        //setting the panel for trophy
        JPanel panel_15 = new JPanel();
        panel_15.setOpaque(false);
        dashPanel.add(panel_15, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(105, 105, 105,180));
        GroupLayout gl_panel_15 = new GroupLayout(panel_15);
        gl_panel_15.setHorizontalGroup(
        	gl_panel_15.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        gl_panel_15.setVerticalGroup(
        	gl_panel_15.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_15.createSequentialGroup()
        			.addContainerGap(31, Short.MAX_VALUE)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        JButton trophyButton = new JButton("");
        trophyButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        trophyButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        trophyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        trophyButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        trophyButton.setContentAreaFilled(false);
        trophyButton.setToolTipText("Accolades and Goals");
        trophyButton.setHorizontalAlignment(SwingConstants.RIGHT);
        trophyButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        trophyButton.setVerticalAlignment(SwingConstants.BOTTOM);
        trophyButton.setBorder(null);
        trophyButton.setBorderPainted(false);
        trophyButton.setIcon(ImageClass.getTrophyIcon2());

        JButton btnUser = new JButton("Beth Locke");
        btnUser.setFont(new Font("Arial", Font.PLAIN, 15));
        btnUser.setForeground(new Color(255, 255, 255));
        btnUser.setContentAreaFilled(false);
        btnUser.setBorder(null);
        
        JLabel lblStayfit = new JLabel("StayFit");
        lblStayfit.setForeground(Color.WHITE);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblStayfit)
        			.addPreferredGap(ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
        			.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(trophyButton))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnUser, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        					.addComponent(lblStayfit))
        				.addComponent(trophyButton))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        trophyButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
            	TrophyPanel trophypanel = new TrophyPanel();
                panel_3.add( trophypanel,"11") ;
                cl.show(panel_3,"11");

            }});
        panel_15.setLayout(gl_panel_15);
        /**
         * End of panel_15 set up
         */



        /**
         * panel_16 acts as a title bar,
         * holding the date in the north border of the dashpanel.         *
         */
        JPanel panel_16 = new JPanel();
        panel_16.setOpaque(false);
        panel_16.setBackground(new Color(169, 169, 169,100));


		/*Today Title*/

		 
        
		
       
        dashPanel.add(panel_16, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        panel_1.setBackground(new Color(105, 105, 105,180));
        GroupLayout gl_panel_16 = new GroupLayout(panel_16);
        gl_panel_16.setHorizontalGroup(
        	gl_panel_16.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gl_panel_16.setVerticalGroup(
        	gl_panel_16.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_16.createSequentialGroup()
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(67, Short.MAX_VALUE))
        );

        JButton refreshbutton = new JButton("");
        refreshbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshbutton.setContentAreaFilled(false);
        refreshbutton.setBorder(null);
        refreshbutton.setIcon(ImageClass.getRefreshIcon());
        refreshbutton.setToolTipText("Refresh");
        final JLabel lastupdated = new JLabel("Last updated: "+timeft.format(new Date()));
        refreshbutton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {
            	
				try {
					Controller.changeDate(dateString, oldDateString);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                final SimpleDateFormat timeft =  new SimpleDateFormat ("hh:mm:ss");
            	lastupdated.setText("Last updated: "+timeft.format(new Date()));
                
            }});

       

       
        lastupdated.setHorizontalTextPosition(SwingConstants.RIGHT);
        lastupdated.setForeground(new Color(255, 255, 255));
        lastupdated.setBackground(new Color(255, 255, 255));

        final JPanel panel_2 = new JPanel();
        panel_2.setOpaque(false);
        panel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel_2.setSize(new Dimension(10, 10));
        panel_2.setMaximumSize(new Dimension(10, 10));
        panel_2.setPreferredSize(new Dimension(5, 5));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(224)
        			.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        			.addGap(45)
        			.addComponent(lastupdated)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(refreshbutton))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(refreshbutton)
        				.addComponent(lastupdated)
        				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE))
        			.addContainerGap())
        );
        final CardLayout cl3 = new CardLayout(0,0);
        panel_2.setLayout(cl3);

        final JPanel panel_4 = new JPanel();
        final JPanel panel_5 = new JPanel();
       
        panel_4.setOpaque(false);
        
        final JXDatePicker datePicker = new JXDatePicker();
        
        datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldDate = date;
				oldDateString = dateString;
				dateString = formatter.format(datePicker.getDate());
				date= datePicker.getDate();
				System.out.println(date.toString());
				try {
					Controller.changeDate(dateString, oldDateString);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				lblNewLabel_3.setText(dateString);
			 
			 
				
			}
		});
    
        lblNewLabel_3.setVerticalTextPosition(SwingConstants.TOP);
        lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_3.setBackground(new Color(105, 105, 105));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        

        JButton calendarButton = new JButton("");
        calendarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        calendarButton.setIconTextGap(0);
        calendarButton.setIcon(ImageClass.getCalendarIcon());
        calendarButton.setContentAreaFilled(false);
        calendarButton.setToolTipText("Pick a date!");
        calendarButton.setBorder(null);
        calendarButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				panel_2.add(panel_5, "calendarpanel");
				cl3.show(panel_2,"calendarpanel");			
			}
        });
        panel_4.add(calendarButton);
        panel_4.add(lblNewLabel_3);
        
             
        panel_5.setOpaque(false);
        panel_5.setAlignmentY(Component.TOP_ALIGNMENT);
        panel_2.add(panel_4, "datepanel");
        panel_2.add(panel_5, "calendarpanel");
        
        JButton okbutton = new JButton("");
        okbutton.setContentAreaFilled(false);
        okbutton.setBorder(null);
        okbutton.setIcon(ImageClass.getOkIcon());
        okbutton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				panel_2.add(panel_4, "datepanel");
				cl3.show(panel_2,"datepanel");			
			}
        });
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_5.add(datePicker);
        panel_5.add(okbutton);
        panel_1.setLayout(gl_panel_1);
        panel_16.setLayout(gl_panel_16);
        /**
         * End of panel_16 set up
         */

        //CaloriesPanel panel_1 = new CaloriesPanel();
        //panel_3.add(panel_1, "5");

        /*SETTINGS*/

        JButton settingsbutton = new JButton("");
        settingsbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsbutton.setContentAreaFilled(false);
        settingsbutton.setBorder(null);
        settingsbutton.setBorderPainted(false);
        settingsbutton.setIcon(ImageClass.getSettingsIcon());
        settingsbutton.setToolTipText("Settings");
        settingsbutton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent ae) {


                //cl.show(panel_3,"9");
                OpenCardListener opencard = new OpenCardListener(7);
                panel_3.add(opencard,"10") ;
                cl.show(panel_3,"10");

            }});



        GroupLayout gl_panel1= new GroupLayout(panel);
        gl_panel1.setHorizontalGroup(
        	gl_panel1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel1.createSequentialGroup()
        			.addContainerGap(346, Short.MAX_VALUE)
        			.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(settingsbutton)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(trophyButton))
        );
        gl_panel1.setVerticalGroup(
        	gl_panel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel1.createSequentialGroup()
        			.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
        				.addComponent(settingsbutton)
        				.addComponent(trophyButton)
        				.addComponent(btnUser, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        			.addContainerGap())
        );
        panel.setLayout(gl_panel1);






    }
    
    /**
     * A method to move the global date backward one day
     * @param date
     * @return
     */
    
    public static Date subtractDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    
    /**
     * A method to move the global date forward by one day
     * @param date
     * @return
     */
    
    public static Date addDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, +1);
        return cal.getTime();
    }
    
    
    /**
     * A method to check the Preferences object for card show/hide booleans upon load of dashboard
     */
    public void checkPref(){
    	if(!Preferences.showCaloriesCard){
    		cardPanel.getComponent(0).setVisible(false);
    	}
    	if(!Preferences.showMinutesCard){
    		cardPanel.getComponent(1).setVisible(false);
    	}
    	if(!Preferences.showMovementsCard){
    		cardPanel.getComponent(2).setVisible(false);
    	}
    	if(!Preferences.showLifetimeCard){
    		cardPanel.getComponent(3).setVisible(false);
    	}
    	if(!Preferences.showTimeSeriesCard){
    		cardPanel.getComponent(4).setVisible(false);
    	}
    	if(!Preferences.showBestDaysCard){
    		cardPanel.getComponent(5).setVisible(false);
    	}

    }



    private void dialogHandler() {
        if (Preferences.noCardsShowing()) {
            JOptionPane.showMessageDialog(frame, "To Restore Your Dashboard Cards, Go To Settings and Click on the Dashboard Settings Tab.");
        }
    
    
}
}

