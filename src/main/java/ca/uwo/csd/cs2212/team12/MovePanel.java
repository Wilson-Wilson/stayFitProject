package ca.uwo.csd.cs2212.team12;

import javax.swing.*;
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
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MovePanel extends JPanel{

	// Percentage field for pie chart
	private int percent = 25;

	// Data fields
	public String dayDistance 	= String.valueOf(Controller.getDailyTotals(1));
	public String weekDistance 	= String.valueOf(Controller.getWeeklyTotals(1));
	public String monthDistance = String.valueOf(Controller.getMonthlyTotals(1));
	public String dayFloors 	= String.valueOf(Controller.getDailyTotals(2));
	public String weekFloors 	= String.valueOf(Controller.getWeeklyTotals(2));
	public String monthFloors 	= String.valueOf(Controller.getMonthlyTotals(2));
	public String daySteps 		= String.valueOf(Controller.getDailyTotals(3));
	public String weekSteps 	= String.valueOf(Controller.getWeeklyTotals(3));
	public String monthSteps 	= String.valueOf(Controller.getMonthlyTotals(3));

	private JFrame frame;
	public Graph graph = new Graph();
	public JFXPanel graph_panel;
    protected java.awt.Color shadowColor = java.awt.Color.black;
    protected Dimension arcs = new Dimension(20, 20);
    protected int shadGap = 5;
    /** The offset of shadow.  */
    protected int shadOffset = 4;


	/**
	 * Create the application.
	 */
	public MovePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the panel; sub-panels, labels, borders and etc.
	 */
	private void initialize() {


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
		         int shadGap = 5;
		         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
		         shadowColor.getGreen(), shadowColor.getBlue(), 150);
		         Graphics2D graphics = (Graphics2D) g;


		         //Draws shadow borders if any.
		         if (true) {
		             graphics.setColor(shadowColorA);
		             graphics.fillRoundRect(
		                     shadOffset,// X position
		                     shadOffset,// Y position
		                     width - 1 - shadOffset, // width
		                     height - 1 - shadOffset, // height
		                     arcs.width, arcs.height);// arc Dimension
		         } else {
		             shadGap = 1;
		         }

		         //Draws the rounded opaque panel with borders.
		         graphics.setColor(getBackground());
		         graphics.fillRoundRect(0, 0, width - shadGap,
		         height - shadGap, arcs.width, arcs.height);
		         graphics.setColor(getForeground());
		         graphics.setStroke(new BasicStroke(1));
		         graphics.drawRoundRect(0, 0, width - shadGap,
		         height - shadGap, arcs.width, arcs.height);

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

		JLabel lblNewLabel = new JLabel("Movement");
		panel_9.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);

				lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new java.awt.Color(0, 128, 0), new java.awt.Color(0, 255, 0), new java.awt.Color(255, 250, 250), new java.awt.Color(210, 105, 30)));
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/RunningIcon2.png"));
				lblNewLabel.setBackground(new java.awt.Color(128, 128, 128));
				lblNewLabel.setBorder(new LineBorder(new java.awt.Color(0, 128, 0), 24, true));

				lblNewLabel.setBorder(null);
				lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
				lblNewLabel.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				
				JPanel panel = new JPanel();
				panel.setOpaque(false);
				panel_9.add(panel, BorderLayout.CENTER);
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				
				JLabel lblSteps = new JLabel("Daily Distance(km): "+dayDistance);
				lblSteps.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				lblSteps.setForeground(java.awt.Color.WHITE);
				
				JLabel lblMonthsTotalDistance = new JLabel("Month's Total Distance(km): " + monthDistance);
				lblMonthsTotalDistance.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				lblMonthsTotalDistance.setForeground(java.awt.Color.WHITE);
				
				JLabel lblWeeksTotalFloors = new JLabel("Week's Total Distance(km): " + weekDistance);
				lblWeeksTotalFloors.setForeground(java.awt.Color.WHITE);
				lblWeeksTotalFloors.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				
				JLabel lblFloors_1 = new JLabel("Daily Floors: "+dayFloors);
				lblFloors_1.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				lblFloors_1.setForeground(new java.awt.Color(255, 255, 255));
				
				JLabel lblMonthsTotalFloors = new JLabel("Month's Total Floors: " + monthFloors);
				lblMonthsTotalFloors.setForeground(java.awt.Color.WHITE);
				lblMonthsTotalFloors.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				
				JLabel lblWeeksTotalDistance = new JLabel("Week's Total Floors: " + weekFloors);
				lblWeeksTotalDistance.setForeground(java.awt.Color.WHITE);
				lblWeeksTotalDistance.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				
				JLabel lblDistance = new JLabel("Daily Steps: "+daySteps);
				lblDistance.setForeground(java.awt.Color.WHITE);
				lblDistance.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				panel.add(panel_1);
				
				JLabel lblWeeksTotalSteps = new JLabel("Week's Total Steps: " + weekSteps);
				lblWeeksTotalSteps.setForeground(new java.awt.Color(255, 255, 255));
				lblWeeksTotalSteps.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				
				JLabel lblMonthsTotalSteps = new JLabel("Month's Total Steps: " + monthSteps);
				lblMonthsTotalSteps.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));
				lblMonthsTotalSteps.setForeground(new java.awt.Color(255, 255, 255));
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(350)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSteps, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblWeeksTotalSteps, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
										.addComponent(lblMonthsTotalSteps, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))))
							.addGap(56)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFloors_1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(lblWeeksTotalDistance)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblMonthsTotalFloors, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
									.addGap(18)))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblWeeksTotalFloors, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblMonthsTotalDistance, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
									.addGap(206))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblDistance, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(343))))
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSteps)
								.addComponent(lblFloors_1)
								.addComponent(lblDistance))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWeeksTotalFloors)
								.addComponent(lblWeeksTotalSteps)
								.addComponent(lblWeeksTotalDistance))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMonthsTotalSteps)
								.addComponent(lblMonthsTotalDistance)
								.addComponent(lblMonthsTotalFloors))
							.addGap(21))
				);
				panel_1.setLayout(gl_panel_1);
				CircleProgressBar stepsprogress=new CircleProgressBar(percent, new java.awt.Color(0,128,0));
				stepsprogress.setBackground(new java.awt.Color(0, 128, 0));
				stepsprogress.setToolTipText("Your Goal Progress!");
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panel.add(stepsprogress);
				
				CircleProgressBar distanceprogress=new CircleProgressBar(65,new java.awt.Color(0,128,0));
				distanceprogress.setBackground(new java.awt.Color(0,128, 0));
				distanceprogress.setToolTipText("Your Goal Progress!");
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				Component horizontalStrut_8 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_8);
				
				Component horizontalStrut_6 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_6);
				
				Component horizontalStrut_4 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_4);
				
				Component horizontalStrut_2 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_2);
				
				Component horizontalStrut = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut);
				panel.add(distanceprogress);
				CircleProgressBar floorprogress=new CircleProgressBar(90,new java.awt.Color(0,128,0));
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				floorprogress.setToolTipText("Your Goal Progress!");
				
				Component horizontalStrut_7 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_7);
				
				Component horizontalStrut_5 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_5);
				
				Component horizontalStrut_3 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_3);
				
				Component horizontalStrut_1 = Box.createHorizontalStrut(20);
				panel.add(horizontalStrut_1);
				panel.add(floorprogress);

		JPanel panel_10 = new JPanel() {
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadGap = 5;
			         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), 150);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     shadOffset,// X position
			                     shadOffset,// Y position
			                     width - 1 - shadOffset, // width
			                     height - 1 - shadOffset, // height
			                     arcs.width, arcs.height);// arc Dimension
			         } else {
			             shadGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadGap,
			         height - shadGap, arcs.width, arcs.height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(1));
			         graphics.drawRoundRect(0, 0, width - shadGap,
			         height - shadGap, arcs.width, arcs.height);

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
        
        graph_panel = graph.setMovementTest();
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
			         int shadGap = 5;
			         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), 150);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     shadOffset,// X position
			                     shadOffset,// Y position
			                     width - 1 - shadOffset, // width
			                     height - 1 - shadOffset, // height
			                     arcs.width, arcs.height);// arc Dimension
			         } else {
			             shadGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadGap,
			         height - shadGap, arcs.width, arcs.height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(1));
			         graphics.drawRoundRect(0, 0, width - shadGap,
			         height - shadGap, arcs.width, arcs.height);

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
