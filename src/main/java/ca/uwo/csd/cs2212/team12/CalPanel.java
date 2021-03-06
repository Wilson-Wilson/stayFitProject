package ca.uwo.csd.cs2212.team12;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalScrollBarUI;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout.Alignment;

public class CalPanel extends JPanel{

	// Percentage field for pie chart
	private int percent = 30;

	// Data fields
	
	public String dayCalories 	= String.valueOf(Controller.getDailyTotals(0));
	public String weekCalories 	= String.valueOf(Controller.getWeeklyTotals(0));
	public String monthCalories = String.valueOf(Controller.getMonthlyTotals(0));

	private JFrame frame;
	public Graph graph = new Graph();
	public JFXPanel graph_panel;
    protected java.awt.Color shadowColor = java.awt.Color.black;
    protected int shadowGap = 5;
    /** The offset of shadow.  */


	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)


	/**
	 * Create the application.
	 */
	public CalPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the panels; sub-panels, labels, borders and etc.
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
		JPanel panel_3 = new JPanel();
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


		JScrollPane scrollPane = new JScrollPane();
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
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{35, 830, 35, 0};
		gbl_panel_8.rowHeights = new int[]{80, 600, 80, 600, 80, 600, 70, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);

		JPanel panel_9 = new JPanel() {
		     @Override
		     protected void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         int width = getWidth();
		         int height = getHeight();
		         int shadowGap = 5;
		         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
		         shadowColor.getGreen(), shadowColor.getBlue(), 150);
		         Graphics2D graphics = (Graphics2D) g;


		         //Draws shadow borders if any.
		         if (true) {
		             graphics.setColor(shadowColorA);
		             graphics.fillRoundRect(
		                     4,// X position
		                     4,// Y position
		                     width - 1 - 4, // width
		                     height - 1 - 4, // height
		                     (new Dimension(20,20)).width, (new Dimension(20,20)).height);// arc Dimension
		         } else {
		             shadowGap = 1;
		         }

		         //Draws the rounded opaque panel with borders.
		         graphics.setColor(getBackground());
		         graphics.fillRoundRect(0, 0, width - shadowGap,
		         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);
		         graphics.setColor(getForeground());
		         graphics.setStroke(new BasicStroke(1));
		         graphics.drawRoundRect(0, 0, width - shadowGap,
		         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);

		         //Sets strokes to default, is better.
		         graphics.setStroke(new BasicStroke());
		     }
		  };
		panel_9.setOpaque(false);
		panel_9.setBackground(new java.awt.Color(169, 169, 169,120));
		panel_9.setPreferredSize(new Dimension(400, 600));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 1;
		panel_8.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Calories");
		panel_9.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);

				lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new java.awt.Color(0, 128, 0), new java.awt.Color(0, 255, 0), new java.awt.Color(255, 250, 250), new java.awt.Color(210, 105, 30)));
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/FireIcon2.png"));
				lblNewLabel.setBackground(new java.awt.Color(128, 128, 128));
				lblNewLabel.setBorder(new LineBorder(new java.awt.Color(0, 128, 0), 24, true));

				lblNewLabel.setBorder(null);
				lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
				lblNewLabel.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				
				JPanel panel = new JPanel();
				panel.setOpaque(false);
				panel_9.add(panel, BorderLayout.CENTER);
				CircleProgressBar progress=new CircleProgressBar(percent,new java.awt.Color(0,128,0));
				progress.setBackground(new java.awt.Color(255, 69, 0));
				progress.setToolTipText("Your Goal Progress!");
				
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				
				JLabel lblCaloriesBurned = new JLabel("Current Calories Burned: "+dayCalories);
				lblCaloriesBurned.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				lblCaloriesBurned.setForeground(java.awt.Color.WHITE);
				
				JLabel lblCaloriesBurnedFor = new JLabel("Week's Calories Burned: " + weekCalories);
				lblCaloriesBurnedFor.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				lblCaloriesBurnedFor.setForeground(java.awt.Color.WHITE);
				panel.add(panel_1);
				
				JLabel lblCaloriesBurnedFor_1 = new JLabel("Month's Calories Burned: " + monthCalories);
				lblCaloriesBurnedFor_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
				lblCaloriesBurnedFor_1.setForeground(java.awt.Color.WHITE);
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(241)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblCaloriesBurnedFor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblCaloriesBurned, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(1))
										.addComponent(lblCaloriesBurnedFor_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(414))))
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblCaloriesBurned)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCaloriesBurnedFor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCaloriesBurnedFor_1)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panel_1.setLayout(gl_panel_1);
				panel.add(progress);
				
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
				
				JLabel lblYourProgressIs = new JLabel("Your Progress is:");
				panel.add(lblYourProgressIs);



		JPanel panel_10 = new JPanel() {
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadowGap = 5;
			         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), 150);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     4,// X position
			                     4,// Y position
			                     width - 1 - 4, // width
			                     height - 1 - 4, // height
			                     (new Dimension(20,20)).width, (new Dimension(20,20)).height);// arc Dimension
			         } else {
			             shadowGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(1));
			         graphics.drawRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);

			         //Sets strokes to default, is better.
			         graphics.setStroke(new BasicStroke());
			     }
			  };

		panel_10.setOpaque(false);
		panel_10.setBackground(new java.awt.Color(105, 105, 105, 180));
		panel_10.setPreferredSize(new Dimension(400, 600));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 3;
		panel_8.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel plh1= new JPanel();
        plh1.setOpaque(false);
        plh1.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh1.setForeground(new java.awt.Color(255, 255, 255));
        plh1.setLayout(new BorderLayout());
        
        JPanel plh2= new JPanel();
        plh2.setOpaque(false);
        plh2.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh2.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh3 = new JPanel();
        plh3.setOpaque(false);
        plh3.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh3.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh4 = new JPanel();
        plh4.setOpaque(false);
        plh4.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh4.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh5 = new JPanel();
        plh5.setOpaque(false);
        plh5.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh5.setForeground(new java.awt.Color(255, 255, 255));
        
        graph_panel = graph.setCalories();
        plh1.add(graph_panel, BorderLayout.CENTER);
        plh1.add(plh2,BorderLayout.WEST);
        plh1.add(plh3,BorderLayout.EAST);
        plh1.add(plh4,BorderLayout.SOUTH);
        plh1.add(plh5,BorderLayout.NORTH);
		panel_10.add(plh1,BorderLayout.CENTER);



		JPanel panel_11 = new JPanel(){
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadowGap = 5;
			         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), 150);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     4,// X position
			                     4,// Y position
			                     width - 1 - 4, // width
			                     height - 1 - 4, // height
			                     (new Dimension(20,20)).width, (new Dimension(20,20)).height);// arc Dimension
			         } else {
			             shadowGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(1));
			         graphics.drawRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);

			         //Sets strokes to default, is better.
			         graphics.setStroke(new BasicStroke());
			     }
			  };
		//panel_11.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(211, 211, 211,100), new Color(211, 211, 211,100), new Color(169, 169, 169,100), new Color(169, 169, 169,100)));
		panel_11.setOpaque(false);

				panel_11.setBackground(new java.awt.Color(169, 169, 169,120));

		//panel_11.setBackground(new java.awt.Color(105, 105, 105, 180));
		panel_11.setPreferredSize(new Dimension(400, 600));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 5;
		panel_8.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Accolades");
		lblNewLabel_1.setIcon(ImageClass.getTrophyIcon2());
		lblNewLabel_1.setBackground(new java.awt.Color(196, 192, 192,180));
		lblNewLabel_1.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		panel_11.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_11.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Please go to the Accolades and Goals Section to see a list of all the Accolades\r\n\r\n\r\n");
		lblNewLabel_2.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
		lblNewLabel_2.setForeground(java.awt.Color.WHITE);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
  	    viewport.setOpaque(false);
        scrollPane.setViewport(viewport);

        scrollPane.setBackground(new java.awt.Color(105, 105, 105));
		//scrollPane.setScrollPosition(new Point(20, 20));
		scrollPane.setSize(new Dimension(5, 5));
		scrollPane.setMinimumSize(new Dimension(5, 5));
		scrollPane.setPreferredSize(new Dimension(1000, 200));
		cardPanel.add(scrollPane, BorderLayout.CENTER);


		/*Today Title*/

		Date dateAndTime = Calendar.getInstance().getTime();



	}


}
