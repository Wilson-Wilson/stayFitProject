package ca.uwo.csd.cs2212.team12;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MovePanel extends JPanel{

	private JFrame frame;
    protected Color shadowColor = Color.black;
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
		         Color shadowColorA = new Color(shadowColor.getRed(),
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
		panel_9.setBackground(new Color(169, 169, 169,120));
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

				lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 128, 0), new Color(0, 255, 0), new Color(255, 250, 250), new Color(210, 105, 30)));
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/RunningIcon2.png"));
				lblNewLabel.setBackground(new Color(128, 128, 128));
				lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 0), 24, true));

				lblNewLabel.setBorder(null);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JPanel panel = new JPanel();
				panel.setOpaque(false);
				panel_9.add(panel, BorderLayout.CENTER);
				
				JLabel lblDistance = new JLabel("Distance:");
				lblDistance.setForeground(Color.WHITE);
				lblDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JLabel lblSteps = new JLabel("Steps:");
				lblSteps.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblSteps.setForeground(Color.WHITE);
				
				JLabel lblFloors = new JLabel("Floors:");
				lblFloors.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblFloors.setForeground(Color.WHITE);
				
				JLabel lblWeeksTotalSteps = new JLabel("Week's Total Steps:");
				lblWeeksTotalSteps.setForeground(Color.WHITE);
				lblWeeksTotalSteps.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JLabel lblWeeksTotalFloors = new JLabel("Week's Total Floors:");
				lblWeeksTotalFloors.setForeground(Color.WHITE);
				lblWeeksTotalFloors.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JLabel lblWeeksTotalDistance = new JLabel("Week's Total Distance:");
				lblWeeksTotalDistance.setForeground(Color.WHITE);
				lblWeeksTotalDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JLabel lblMonthsTotalSteps = new JLabel("Month's Total Steps:");
				lblMonthsTotalSteps.setForeground(Color.WHITE);
				lblMonthsTotalSteps.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JLabel lblMonthsTotalFloors = new JLabel("Month's Total Floors:");
				lblMonthsTotalFloors.setForeground(Color.WHITE);
				lblMonthsTotalFloors.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				
				JLabel lblMonthsTotalDistance = new JLabel("Month's Total Distance:");
				lblMonthsTotalDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
				lblMonthsTotalDistance.setForeground(Color.WHITE);
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMonthsTotalDistance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(146))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMonthsTotalFloors, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(163))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMonthsTotalSteps, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(167))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblWeeksTotalDistance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(150))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblWeeksTotalFloors, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(167))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblWeeksTotalSteps, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(171))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFloors, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(256))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSteps, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(260))
								.addComponent(lblDistance, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
							.addContainerGap())
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSteps)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDistance)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFloors)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWeeksTotalSteps)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWeeksTotalFloors)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWeeksTotalDistance)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMonthsTotalSteps)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMonthsTotalFloors)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMonthsTotalDistance)
							.addContainerGap(155, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);

		JPanel panel_10 = new JPanel() {
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadGap = 5;
			         Color shadowColorA = new Color(shadowColor.getRed(),
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
		panel_10.setBackground(new Color(105, 105, 105, 180));
		panel_10.setPreferredSize(new Dimension(400, 600));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 3;
		panel_8.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));



		JPanel panel_11 = new JPanel(){
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadGap = 5;
			         Color shadowColorA = new Color(shadowColor.getRed(),
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

				panel_11.setBackground(new Color(169, 169, 169,120));

		//panel_11.setBackground(new Color(105, 105, 105, 180));
		panel_11.setPreferredSize(new Dimension(400, 600));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 5;
		panel_8.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Accolades");
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/FireIcon2.png"));
		lblNewLabel_1.setBackground(new Color(196, 192, 192,180));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_11.add(lblNewLabel_1, BorderLayout.NORTH);
  	    viewport.setOpaque(false);
        scrollPane.setViewport(viewport);

        scrollPane.setBackground(new Color(105, 105, 105));
		//scrollPane.setScrollPosition(new Point(20, 20));
		scrollPane.setSize(new Dimension(5, 5));
		scrollPane.setMinimumSize(new Dimension(5, 5));
		scrollPane.setPreferredSize(new Dimension(1000, 200));
		cardPanel.add(scrollPane, BorderLayout.CENTER);


		/*Today Title*/

		Date dateAndTime = Calendar.getInstance().getTime();



	}


}
