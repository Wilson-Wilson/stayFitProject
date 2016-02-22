package ca.uwo.csd.cs2212.team12;
import java.awt.EventQueue;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
//import net.miginfocom.swing.MigLayout;

public class DashBoard {
	public JFrame frame;

	ImageIcon backImage;
	ImageIcon caloriesIcon;
	ImageIcon minutesIcon;
	ImageIcon movementIcon;
	ImageIcon lifetimeIcon;
	ImageIcon timeseriesIcon;
	ImageIcon bestdayIcon;
	ImageIcon exitIcon;
	ImageIcon rightarrowIcon;
	ImageIcon leftarrowIcon;
	ImageIcon trophyIcon;
	ImageIcon cardIcon;
	
	/**
	 * Launch the application.
	 * App.java should handle running the application, so we should use that instead of the commented code below.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.frame.setSize(1000,600);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DashBoard() throws IOException {
		//We'll need a special method responsible for caching resources like images.
		this.backImage = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("BackgroundImage.png")));
		this.caloriesIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("FireIcon.png")));
		this.minutesIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("TimeIcon.png")));
		this.movementIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("RunningIcon.png")));
		this.lifetimeIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("StarIcon.png")));
		this.timeseriesIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("BarGraphIcon.png")));
		this.bestdayIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("BlueStarIcon.png")));
		this.exitIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("CloseIcon.png")));
		this.rightarrowIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("RightArrow.png")));
		this.leftarrowIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("LeftArrow.png")));
		this.trophyIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("Trophy.png")));
		this.cardIcon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("DashboardCard.png")));

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
		frame.getContentPane().add(panel_3, "3");
		panel_3.setLayout(cl);
		cl.show(panel_3, "2");
		BackgroundPanel dashPanel = new BackgroundPanel(backImage);
		dashPanel.setBackground(new Color(0, 128, 0));
		panel_3.add(dashPanel, "2");
		final JPanel cardPanel = new JPanel();//Note the card panel holds all the card its at the center of the dash panel, the arrows and trophy and everything else are on other panels on the dashpanel
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
		 final JButton caloriesButton = new JButton("");
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
	            	JFrame caloriesframe= new JFrame("Calories");
	                caloriesframe.setVisible(true);
	                caloriesframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             	JPanel caloriespanel=new JPanel();
	             	
	              
	            	caloriesframe.getContentPane().add(caloriespanel);      	
	            	
	            	caloriesframe.pack();
	            	caloriesframe.setSize(600,600);
	               	
	            }});
		
		
		 
		//card panel for calories
		 JPanel pl= new JPanel();
		 pl.setForeground(new Color(255, 255, 255));
		 pl.setOpaque(false);
		// pl.setLayout(new MigLayout("", "[][][][209.00px][119.00px]", "[][][36px]"));
		 pl.setLayout(new GridLayout(0, 2, 0, 0));
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
		 final JButton minutesButton = new JButton("");
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
	            	JFrame minutesframe= new JFrame("Minutes");
	                 minutesframe.setVisible(true);
	               minutesframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             	JPanel minutespanel=new JPanel();
	             	
	              
	            	minutesframe.getContentPane().add(minutespanel);      	
	            	
	            	minutesframe.pack();
	            	minutesframe.setSize(600,600);
	               	
	            }});
		 
		//card panel for minutes
		 JPanel pl2= new JPanel();
		 pl2.setOpaque(false);
		 pl2.setForeground(new Color(255, 255, 255));
		 //pl2.setLayout(new MigLayout("", "[][][103.00px,grow]", "[][][][grow][][30px]"));
		 pl2.setLayout(new GridLayout(0, 2, 0, 0));
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
		 final JButton movementButton = new JButton("");
		 movementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 movementButton.setContentAreaFilled(false);
		 movementButton.setBorder(null);
		 movementButton.setIcon(cardIcon);
		 movementButton.setBorder(null);
		 movementButton.setLayout(new BorderLayout());
		 movementButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	JFrame movementframe= new JFrame("Movement");
	            	movementframe.setVisible(true);
	            	movementframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             	JPanel movementpanel=new JPanel();
	             	
	              
	             	movementframe.getContentPane().add(movementpanel);      	
	            	
	             	movementframe.pack();
	             	movementframe.setSize(600,600);
	               	
	            }});
		
		 
		 //card panel for movement
		 JPanel pl3= new JPanel();
		 pl3.setOpaque(false);
		 movementButton.add(pl3, BorderLayout.NORTH);
		 //pl3.setLayout(new MigLayout("", "[219.00][][54.00][67.00px]", "[][][][][][][30px]"));
		 pl3.setLayout(new GridLayout(0, 2, 0, 0));
		 
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
		 final JButton lifetimeButton = new JButton("");
		 lifetimeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 lifetimeButton.setContentAreaFilled(false);
		 lifetimeButton.setBorder(null);
		 lifetimeButton.setIcon(cardIcon);
		 lifetimeButton.setLayout(new BorderLayout());
	     lifetimeButton .addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent ae) {
		            	JFrame lifetimeframe= new JFrame("Lifetime");
		                lifetimeframe.setVisible(true);
		                lifetimeframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		             	JPanel lifetimepanel=new JPanel();
		             	
		              
		            	lifetimeframe.getContentPane().add(lifetimepanel);      	
		            	
		            	lifetimeframe.pack();
		            	lifetimeframe.setSize(600,600);
		               	
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
			 //pl4.setLayout(new MigLayout("", "[251.00px][114.00px]", "[30px]"));
		     pl4.setLayout(new GridLayout(0, 2, 0, 0));
			 pl4.add(lblLifetime_1, "cell 0 0,alignx left,aligny top");
			 pl4.add(lifeExit, "cell 1 0,alignx right,aligny top");
			 cardPanel.add(lifetimeButton);;
			 
			 /*Time Series card*/
			 
			 //Time Series button
			 final JButton timeseriesButton = new JButton("");
			 timeseriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 timeseriesButton.setContentAreaFilled(false);
			 timeseriesButton.setBorder(null);
			 timeseriesButton.setIcon(cardIcon);
			 timeseriesButton.setLayout(new BorderLayout());
			 timeseriesButton.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent ae) {
		            	JFrame timeseriesframe= new JFrame("Time Series");
		                timeseriesframe.setVisible(true);
		                timeseriesframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		             	JPanel timeseriespanel=new JPanel();
		             	              
		            	timeseriesframe.getContentPane().add(timeseriespanel);      	
		            	
		            	timeseriesframe.pack();
		            	timeseriesframe.setSize(600,600);
		               	
		            }});
			 
			 
			 
			//card panel for time series
			 JPanel pl5= new JPanel();
			 pl5.setOpaque(false);
			 pl5.setFont(new Font("Verdana", Font.BOLD, 13));
			 pl5.setForeground(new Color(255, 255, 255));
			
			 timeseriesButton.add(pl5,BorderLayout.NORTH);
			 //pl5.setLayout(new MigLayout("", "[188.00][95.00px]", "[][][30px]"));
		     pl5.setLayout(new GridLayout(0, 2, 0, 0));
			
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
			 
			 final JButton bestdayButton = new JButton("");
			 bestdayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 bestdayButton.setContentAreaFilled(false);
			 bestdayButton.setBorder(null);
			 bestdayButton.setIcon(cardIcon);
			 bestdayButton.setLayout(new BorderLayout());
			 bestdayButton .addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent ae) {
		            	JFrame bestdaysframe= new JFrame("Best Days");
		                bestdaysframe.setVisible(true);
		                bestdaysframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		             	JPanel bestdayspanel=new JPanel();
		             	
		              
		            	bestdaysframe.getContentPane().add(bestdayspanel);      	
		            	
		            	bestdaysframe.pack();
		            	bestdaysframe.setSize(600,600);
		               	
		            }});
			 
			//card panel for best day
			 JPanel pl6= new JPanel();
			 pl6.setOpaque(false);
			 pl6.setFont(new Font("Verdana", Font.BOLD, 13));
			 pl6.setForeground(new Color(255, 255, 255));
			 bestdayButton.add(pl6,BorderLayout.NORTH);
			 //pl6.setLayout(new MigLayout("", "[195.00][][61.00][107px]", "[][][][][][][30px]"));
		     pl6.setLayout(new GridLayout(0, 2, 0, 0));

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
		panel_15.setLayout(new BorderLayout(0, 0));
		JButton trophyButton = new JButton("");
		trophyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		trophyButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		trophyButton.setContentAreaFilled(false);
		trophyButton.setHorizontalAlignment(SwingConstants.RIGHT);
		trophyButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		trophyButton.setVerticalAlignment(SwingConstants.BOTTOM);
		trophyButton.setBorder(null);
		trophyButton.setIcon(trophyIcon);
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
		
		
		 
	
		panel_15.add(trophyButton);
		
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
		
		
		
	}

}
