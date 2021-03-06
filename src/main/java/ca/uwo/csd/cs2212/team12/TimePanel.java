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

public class TimePanel extends JPanel{

	private JFrame frame;
	public Graph graph = new Graph();
	public JFXPanel graph_panel;
    protected java.awt.Color shadowColor = java.awt.Color.black;
    protected Dimension arcs = new Dimension(20, 20);
    protected int shadGap = 5;
    protected int shadAlpha = 150;

	/**
	 * Creates the panel that holds time focused information
	 */
	public TimePanel() {
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
		         shadowColor.getGreen(), shadowColor.getBlue(), shadAlpha);
		         Graphics2D graphics = (Graphics2D) g;


		         //Draws shadow borders if any.
		         if (true) {
		             graphics.setColor(shadowColorA);
		             graphics.fillRoundRect(
		                     4,// X position
		                     4,// Y position
		                     width - 1 - 4, // width
		                     height - 1 - 4, // height
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
		panel_9.add(plh1,BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Calories");
		panel_9.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);

				lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new java.awt.Color(0, 128, 0), new java.awt.Color(0, 255, 0), new java.awt.Color(255, 250, 250), new java.awt.Color(210, 105, 30)));

				lblNewLabel.setIcon(ImageClass.getCaloriesIcon());

				lblNewLabel.setBackground(new java.awt.Color(128, 128, 128));
				lblNewLabel.setBorder(new LineBorder(new java.awt.Color(0, 128, 0), 24, true));

				lblNewLabel.setBorder(null);
				lblNewLabel.setForeground(new java.awt.Color(255, 255, 255));
				lblNewLabel.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));

		JPanel panel_10 = new JPanel() {
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadGap = 5;
			         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), shadAlpha);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     4,// X position
			                     4,// Y position
			                     width - 1 - 4, // width
			                     height - 1 - 4, // height
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
		
		JPanel plh6= new JPanel();
        plh6.setOpaque(false);
        plh6.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh6.setForeground(new java.awt.Color(255, 255, 255));
        plh6.setLayout(new BorderLayout());
        
        JPanel plh7= new JPanel();
        plh7.setOpaque(false);
        plh7.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh7.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh8 = new JPanel();
        plh8.setOpaque(false);
        plh8.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh8.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh9 = new JPanel();
        plh9.setOpaque(false);
        plh9.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh9.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh10= new JPanel();
        plh10.setOpaque(false);
        plh10.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh10.setForeground(new java.awt.Color(255, 255, 255));
        
        graph_panel = graph.setMovement();
        plh6.add(graph_panel, BorderLayout.CENTER);
        plh6.add(plh7,BorderLayout.WEST);
        plh6.add(plh8,BorderLayout.EAST);
        plh6.add(plh9,BorderLayout.SOUTH);
        plh6.add(plh10,BorderLayout.NORTH);
		panel_10.add(plh6,BorderLayout.CENTER);
		
		JLabel lblNewLabel2 = new JLabel("Movement");
		panel_10.add(lblNewLabel2, BorderLayout.NORTH);
		lblNewLabel2.setHorizontalAlignment(JLabel.LEFT);

				lblNewLabel2.setBorder(new BevelBorder(BevelBorder.RAISED, new java.awt.Color(0, 128, 0), new java.awt.Color(0, 255, 0), new java.awt.Color(255, 250, 250), new java.awt.Color(210, 105, 30)));
				lblNewLabel2.setIcon(new ImageIcon("src/main/resources/RunningIcon2.png"));
				lblNewLabel2.setBackground(new java.awt.Color(128, 128, 128));
				lblNewLabel2.setBorder(new LineBorder(new java.awt.Color(0, 128, 0), 24, true));

				lblNewLabel2.setBorder(null);
				lblNewLabel2.setForeground(new java.awt.Color(255, 255, 255));
				lblNewLabel2.setFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 15));




		JPanel panel_11 = new JPanel(){
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadGap = 5;
			         java.awt.Color shadowColorA = new java.awt.Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), shadAlpha);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     4,// X position
			                     4,// Y position
			                     width - 1 - 4, // width
			                     height - 1 - 4, // height
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

		//panel_11.setBackground(new Color(105, 105, 105, 180));
		panel_11.setPreferredSize(new Dimension(400, 600));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 5;
		panel_8.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel plh11= new JPanel();
        plh11.setOpaque(false);
        plh11.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh11.setForeground(new java.awt.Color(255, 255, 255));
        plh11.setLayout(new BorderLayout());
        
        JPanel plh12= new JPanel();
        plh12.setOpaque(false);
        plh12.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh12.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh13 = new JPanel();
        plh13.setOpaque(false);
        plh13.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh13.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh14 = new JPanel();
        plh14.setOpaque(false);
        plh14.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh14.setForeground(new java.awt.Color(255, 255, 255));
        
        JPanel plh15= new JPanel();
        plh15.setOpaque(false);
        plh15.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 13));
        plh15.setForeground(new java.awt.Color(255, 255, 255));
        
        graph_panel = graph.setMinutes();
        plh11.add(graph_panel, BorderLayout.CENTER);
        plh11.add(plh12,BorderLayout.WEST);
        plh11.add(plh13,BorderLayout.EAST);
        plh11.add(plh14,BorderLayout.SOUTH);
        plh11.add(plh15,BorderLayout.NORTH);
		panel_11.add(plh11,BorderLayout.CENTER);



		JLabel lblNewLabel_1 = new JLabel("Minutes");
		lblNewLabel_1.setIcon(ImageClass.getMinutesIcon());

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
