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




public class DashBoardPanel extends JPanel {

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
					DashBoardPanel window = new DashBoardPanel();
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
	public DashBoardPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//main frame
		
		CardLayout cl = new CardLayout(0,0);
		this.setLayout(new CardLayout(0,0));
		
		JPanel panel_3 = new JPanel();
		this.add(panel_3, "3");
		panel_3.setLayout(cl);
		//panel_1.setBackground(Color.RED);
		
		
		BackgroundPanel dashPanel = new BackgroundPanel(backImage);
		//dashPanel.setBackground(new Color(0, 128, 0));
		panel_3.add(dashPanel,"1");
		
	
		CaloriesPanel calPanel = new CaloriesPanel();
		//panel_2.setBackground(new Color(0, 128, 0));
		panel_3.add(calPanel, "2");
		
		MinutesPanel minPanel= new MinutesPanel();
		panel_3.add(minPanel,"4");
		
		MovementPanel movePanel= new MovementPanel();
		panel_3.add(movePanel,"6");
		
		
		LifetimePanel lifePanel= new LifetimePanel();
		panel_3.add(lifePanel,"7");
		
		
		TimeSeriesPanel timePanel= new TimeSeriesPanel();
		panel_3.add(timePanel,"8");

		BestDaysPanel bestPanel= new BestDaysPanel();
		panel_3.add(bestPanel,"9");
		
		
		JPanel cardPanel = new JPanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
		cardPanel.setOpaque(false);
		cardPanel.setBounds(new Rectangle(200, 200, 200, 200));
		dashPanel.setLayout(new BorderLayout(0, 0));
		dashPanel.add(cardPanel, BorderLayout.CENTER);
		//BasicInternalFrameUI bi = (BasicInternalFrameUI)internalFrame_5.getUI(); //could be used to hide internal frame title bar
		//bi.setNorthPane(null);
		cardPanel.setLayout(new GridLayout(2, 3, 20, 20));
		cardPanel.setLayout(new GridLayout(2, 3, 20, 50));;
		
		/*Calories card*/
		
		//Calories Button		 
		 JButton caloriesButton = new JButton("");
		 caloriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 caloriesButton.setBorder(null);
		 caloriesButton.setContentAreaFilled(false);
		 caloriesButton.setOpaque(false);
		 caloriesButton.setMinimumSize(new Dimension(15, 11));
		 caloriesButton.setMaximumSize(new Dimension(15, 11));
		 caloriesButton.setPreferredSize(new Dimension(15, 11));
		 caloriesButton.setIcon(cardIcon);
		 caloriesButton.setLayout(new BorderLayout());
		 caloriesButton.setBorder(BorderFactory.createEmptyBorder());
		 caloriesButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                //cl.show(panel_3,"2");	
	            	OpenedCard opencard = new OpenedCard(1);
	        		panel_3.add(opencard,"10") ;	
	        		cl.show(panel_3,"10");
	            	
	            }});
		
		
		 
		//card panel for calories
		 JPanel pl= new JPanel();
		 pl.setForeground(new Color(255, 255, 255));
		 pl.setOpaque(false);
		 pl.setLayout(new MigLayout("", "[][][][209.00px][119.00px]", "[][][36px]"));
		 caloriesButton.add(pl,BorderLayout.NORTH);
		 
		 //exit button for the calories card
		 JButton calExit = new JButton("");
		 calExit. addActionListener(new java.awt.event.ActionListener() {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	
	    	            	 cardPanel.remove( caloriesButton);
	    	            	 cardPanel.invalidate();
	    	            	 cardPanel.repaint();
	            }
	    	         
	        });
		 
		 
		 
		 
		 //the label for the title of the calories card
		 JLabel lblCalories_1 = new JLabel("Calories");
		 lblCalories_1.setFont(new Font("Verdana", Font.BOLD, 14));
		 lblCalories_1.setForeground(new Color(255, 255, 255));
		 lblCalories_1.setIcon(caloriesIcon);
		 pl.add(lblCalories_1, "flowy,cell 0 0,alignx right,aligny bottom");
		 calExit.setContentAreaFilled(false);
		 calExit.setBorder(null);
		 calExit.setIcon(exitIcon);
		 pl.add(calExit, "cell 1 0 4 1,alignx right,aligny top");
		 calExit. addActionListener(new java.awt.event.ActionListener() {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	
	    	            	 cardPanel.remove( caloriesButton);
	    	            	 cardPanel.invalidate();
	    	            	 cardPanel.repaint();
	            }
	    	         
	        });
		
		 cardPanel.add(caloriesButton);
		
		 
		 
		 /*Minutes card*/
		 
		 //Minutes Button
		 JButton minutesButton = new JButton("");
		 minutesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 minutesButton.setContentAreaFilled(false);
		 minutesButton.setOpaque(false);
		 minutesButton.setBorder(null);
		 minutesButton.setIcon(cardIcon);
		 minutesButton.setBorder(null);
		 minutesButton.setLayout(new BorderLayout());
		 minutesButton .addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            
	            	
	            	//cl.show(panel_3,"4");	
	            	OpenedCard opencard = new OpenedCard(2);
	        		panel_3.add(opencard,"10") ;	
	        		cl.show(panel_3,"10");
	            	
	               	
	            }});
		 
		//card panel for minutes
		 JPanel pl2= new JPanel();
		 pl2.setOpaque(false);
		 pl2.setForeground(new Color(255, 255, 255));
		 pl2.setLayout(new MigLayout("", "[][][103.00px,grow]", "[][][][grow][][30px]"));
		 pl2.setForeground(new Color(255, 255, 255));
		 minutesButton.add(pl2,BorderLayout.NORTH);
		 cardPanel.add(minutesButton);//adding it to the cardpanel
		 
		 //the label for the title of the minutes card
		 JLabel lblMinutes = new JLabel("Minutes");
		 lblMinutes.setFont(new Font("Verdana", Font.BOLD, 13));
		 lblMinutes.setForeground(new Color(255, 255, 255));
		 lblMinutes.setIcon(minutesIcon);
		 pl2.add(lblMinutes, "cell 0 0,alignx right,aligny top");
		 
		 //button for minute exit
		 JButton minExit = new JButton("");
		 minExit.addActionListener(new java.awt.event.ActionListener() {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	
	    	            	 cardPanel.remove( minutesButton);
	    	            	 cardPanel.invalidate();
	    	            	 cardPanel.repaint();
	            }
	    	         
	        });
		 
		 
		 minExit .setContentAreaFilled(false);
		 minExit .setBorder(null);
		 minExit .setIcon(exitIcon);
		 pl2.add(minExit , "cell 2 0,alignx right,aligny top");
		 
		 
		 
		 
		 
		 /*Movement card */
		 
		 //Movement Button
		 JButton movementButton = new JButton("");
		 movementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 movementButton.setContentAreaFilled(false);
		 movementButton.setBorder(null);
		 movementButton.setIcon(cardIcon);
		 movementButton.setBorder(null);
		 movementButton.setLayout(new BorderLayout());
		 movementButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	           
	             	//cl.show(panel_3,"6");	
	            	OpenedCard opencard = new OpenedCard(3);
	        		panel_3.add(opencard,"10") ;	
	        		cl.show(panel_3,"10");
	            	
	            }});
		
		 
		 //card panel for movement
		 JPanel pl3= new JPanel();
		 pl3.setOpaque(false);
		 movementButton.add(pl3, BorderLayout.NORTH);
		 pl3.setLayout(new MigLayout("", "[219.00][][54.00][67.00px]", "[][][][][][][30px]"));
		 
		 //the label for the title of the movements card
		 JLabel lblMovements = new JLabel("Movements");
		 lblMovements.setForeground(new Color(255, 255, 255));
		 lblMovements.setFont(new Font("Verdana", Font.BOLD, 13));
		 lblMovements.setIcon(movementIcon);
		 pl3.add(lblMovements, "cell 0 0,growx,aligny top");
		  
		 
		 //exit button for movement
		 JButton moveExit = new JButton("");
		 moveExit. addActionListener(new java.awt.event.ActionListener() {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	
	    	            	 cardPanel.remove( movementButton);
	    	            	 cardPanel.invalidate();
	    	            	 cardPanel.repaint();
	            }
	    	         
	        });
		 moveExit.setContentAreaFilled(false);
		 moveExit.setBorder(null);
		 moveExit.setIcon(exitIcon);
		 pl3.add(moveExit, "flowy,cell 1 0 3 1,alignx right,aligny top");
		 
		
		 cardPanel.add(movementButton);;
			 
		
		 /*Lifetime  card*/
		 
		 
		 //Lifetime button
		 JButton lifetimeButton = new JButton("");
		 lifetimeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 lifetimeButton.setContentAreaFilled(false);
		 lifetimeButton.setBorder(null);
		 lifetimeButton.setIcon(cardIcon);
		 lifetimeButton.setLayout(new BorderLayout());
	     lifetimeButton .addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent ae) {
		            	
		            	//cl.show(panel_3,"7");	
		            	OpenedCard opencard = new OpenedCard(4);
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
			 JLabel lblLifetime_1 = new JLabel("Lifetime");
			 lblLifetime_1.setForeground(new Color(255, 255, 255));
			 lblLifetime_1.setFont(new Font("Verdana", Font.BOLD, 13));
			 lblLifetime_1.setIcon(lifetimeIcon);
			 
			 //exit button for lifetime card
			 JButton lifeExit= new JButton("");
			 lifeExit.setContentAreaFilled(false);
			 lifeExit. addActionListener(new java.awt.event.ActionListener() {
		            @Override
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	
		    	            	 cardPanel.remove(lifetimeButton);
		    	            	 cardPanel.invalidate();
		    	            	 //cardPanel.revalidate();
		    	                 cardPanel.repaint();
		            }
		    	         
		        });
			 lifeExit.setIcon(exitIcon);
			 lifeExit.setBorder(null);
			 pl4.setLayout(new MigLayout("", "[251.00px][114.00px]", "[30px]"));
			 pl4.add(lblLifetime_1, "cell 0 0,alignx left,aligny top");
			 pl4.add(lifeExit, "cell 1 0,alignx right,aligny top");
			 cardPanel.add(lifetimeButton);;
			 
			 /*Time Series card*/
			 
			 //Time Series button
			 JButton timeseriesButton = new JButton("");
			 timeseriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 timeseriesButton.setContentAreaFilled(false);
			 timeseriesButton.setBorder(null);
			 timeseriesButton.setIcon(cardIcon);
			 timeseriesButton.setLayout(new BorderLayout());
			 timeseriesButton.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent ae) {
		            
		            	//cl.show(panel_3,"8");
		            	OpenedCard opencard = new OpenedCard(5);
		        		panel_3.add(opencard,"10") ;	
		        		cl.show(panel_3,"10");
		            	
		            }});
			 
			 
			 
			//card panel for time series
			 JPanel pl5= new JPanel();
			 pl5.setOpaque(false);
			 pl5.setFont(new Font("Verdana", Font.BOLD, 13));
			 pl5.setForeground(new Color(255, 255, 255));
			
			 timeseriesButton.add(pl5,BorderLayout.NORTH);
			 pl5.setLayout(new MigLayout("", "[188.00][95.00px]", "[][][30px]"));
			
			//the label for the title of the time series card
			JLabel lblTimeSeries = new JLabel("Time Series");
			lblTimeSeries.setForeground(Color.WHITE);
			lblTimeSeries.setFont(new Font("Verdana", Font.BOLD, 13));
			lblTimeSeries.setIcon(timeseriesIcon);
			pl5.add(lblTimeSeries, "cell 0 0,alignx left,aligny top");
			
			//Exit button for time series card
			JButton timeExit = new JButton("");
			timeExit. addActionListener(new java.awt.event.ActionListener() {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	
	    	            	 cardPanel.remove( timeseriesButton);
	    	            	 cardPanel.invalidate();
	    	                cardPanel.repaint();
	            }
	    	         
	        });
			timeExit.setContentAreaFilled(false);
			timeExit.setIcon(exitIcon);
			timeExit.setBorder(null);
			pl5.add(timeExit, "cell 1 0,alignx right,aligny top");
			 
			 cardPanel.add(timeseriesButton);
			
			 /*Best Days*/
			 
			 
			 //Best Days button
			 
			 JButton bestdayButton = new JButton("");
			 bestdayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 bestdayButton.setContentAreaFilled(false);
			 bestdayButton.setBorder(null);
			 bestdayButton.setIcon(cardIcon);
			 bestdayButton.setLayout(new BorderLayout());
			 bestdayButton .addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent ae) {
		            	
		               	
		            	//cl.show(panel_3,"9");	
		            	OpenedCard opencard = new OpenedCard(6);
		        		panel_3.add(opencard,"10") ;	
		        		cl.show(panel_3,"10");
		            	
		            }});
			 
			//card panel for best day
			 JPanel pl6= new JPanel();
			 pl6.setOpaque(false);
			 pl6.setFont(new Font("Verdana", Font.BOLD, 13));
			 pl6.setForeground(new Color(255, 255, 255));
			 bestdayButton.add(pl6,BorderLayout.NORTH);
			 pl6.setLayout(new MigLayout("", "[195.00][][61.00][107px]", "[][][][][][][30px]"));
			 
			//the label for the title of the best days card
			 JLabel lblBestDays_1 = new JLabel("Best Days");
			 lblBestDays_1.setFont(new Font("Verdana", Font.BOLD, 13));
			 lblBestDays_1.setForeground(Color.WHITE);
			 lblBestDays_1.setIcon(bestdayIcon);
			 pl6.add(lblBestDays_1, "cell 0 0,alignx left,aligny top");
			 
			 //exit button for best days card
			 JButton bestExit = new JButton("");
			 bestExit. addActionListener(new java.awt.event.ActionListener() {
		            @Override
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	
		    	            	 cardPanel.remove( bestdayButton);
		    	            	 cardPanel.invalidate();
		    	                 cardPanel.repaint();
		            }
		    	         
		        });
			 bestExit.setContentAreaFilled(false);
			 bestExit.setBorder(null);
			 bestExit.setIcon(exitIcon);
			 pl6.add(bestExit, "cell 1 0 3 1,alignx right,aligny top");
			 cardPanel.add(bestdayButton);
		
		//Left Arrow	 
		JButton leftarrow = new JButton("");
		leftarrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		leftarrow.setBorder(null);
		leftarrow.setContentAreaFilled(false);
		leftarrow.setOpaque(false);
		leftarrow.setIcon(leftarrowIcon);
		dashPanel.add(leftarrow, BorderLayout.WEST);
		
		
		//RightArrow
		JButton rightarrow = new JButton("");
		rightarrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rightarrow.setBorder(null);
		rightarrow.setContentAreaFilled(false);
		rightarrow.setOpaque(false);
		rightarrow.setIcon(rightarrowIcon);
		dashPanel.add(rightarrow, BorderLayout.EAST);
		
		
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
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
		);
		gl_panel_15.setVerticalGroup(
			gl_panel_15.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_15.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		);
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
		trophyButton.setIcon(new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\Trophy2.png"));
		
		JButton btnJodimarie = new JButton("Jodi-Marie");
		btnJodimarie.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnJodimarie.setForeground(new Color(255, 255, 255));
		btnJodimarie.setContentAreaFilled(false);
		btnJodimarie.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(323, Short.MAX_VALUE)
					.addComponent(btnJodimarie, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(trophyButton))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnJodimarie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(trophyButton, Alignment.LEADING))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		trophyButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	JFrame trophyframe= new JFrame("Goals and Accolades");
	                trophyframe.setVisible(true);
	                trophyframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             	JPanel trophypanel=new JPanel();
	             	
	              
	            	trophyframe.getContentPane().add(trophypanel);      	
	            	
	            	trophyframe.pack();
	            	trophyframe.setSize(600,600);
	               	
	            }});
		panel_15.setLayout(gl_panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setOpaque(false);
		panel_16.setBackground(new Color(169, 169, 169,100));
		
	
		/*Today Title*/
		
		Date dateAndTime = Calendar.getInstance().getTime();// can be used to display time if added to panel
		dashPanel.add(panel_16, BorderLayout.NORTH);
		JLabel lblToday = new JLabel("Today");
		lblToday.setBackground(new Color(105, 105, 105,180));
		lblToday.setOpaque(true);
		lblToday.setForeground(new Color(255, 255, 255));
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		GroupLayout gl_panel_16 = new GroupLayout(panel_16);
		gl_panel_16.setHorizontalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addComponent(lblToday, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_panel_16.setVerticalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addComponent(lblToday, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		panel_16.setLayout(gl_panel_16);
		
		CaloriesPanel panel_1 = new CaloriesPanel();
		panel_3.add(panel_1, "5");
		
		
		
	}

}
