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

public class LifePanel extends JPanel {

	// Data fields
	public String lifeDistance = "";
	public String lifeFloors = "";
	public String lifeSteps = "";

	private JFrame frame;

	protected Color shadowColor = Color.black;
	protected Dimension arcs = new Dimension(20, 20);

	protected int shadowGap = 5;

	/**
	 * Create the application.
	 */
	public LifePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the panel; sub-panels, labels, borders and
	 * etc.
	 */
	private void initialize() {

		CardLayout cl = new CardLayout(0, 0);
		this.setLayout(new CardLayout(0, 0));
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		this.add(panel_3, "3");
		panel_3.setLayout(cl);
		cl.show(panel_3, "2");
		JPanel paneldash = new JPanel();
		paneldash.setOpaque(false);
		// paneldash.setBackground(new Color(0, 128, 0));
		panel_3.add(paneldash, "2");
		paneldash.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		paneldash.add(panel_2, BorderLayout.SOUTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(225)
					.addComponent(verticalStrut_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(225, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(verticalStrut_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		paneldash.add(panel_1, BorderLayout.NORTH);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 84, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		paneldash.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				int width = getWidth();
				int height = getHeight();
				int shadowGap = 5;
				Color shadowColorA = new Color(shadowColor.getRed(),
						shadowColor.getGreen(), shadowColor.getBlue(), 150);
				Graphics2D graphics = (Graphics2D) g;

				// Draws shadow borders if any.
				if (true) {
					graphics.setColor(shadowColorA);
					graphics.fillRoundRect(4,// X position
							4,// Y position
							width - 1 - 4, // width
							height - 1 - 4, // height
							arcs.width, arcs.height);// arc Dimension
				} else {
					shadowGap = 1;
				}

				// Draws the rounded opaque panel with borders.
				graphics.setColor(getBackground());
				graphics.fillRoundRect(0, 0, width - shadowGap, height
						- shadowGap, arcs.width, arcs.height);
				graphics.setColor(getForeground());
				graphics.setStroke(new BasicStroke(1));
				graphics.drawRoundRect(0, 0, width - shadowGap, height
						- shadowGap, arcs.width, arcs.height);

				// Sets strokes to default, is better.
				graphics.setStroke(new BasicStroke());
			}
		};
		panel.add(panel_9, BorderLayout.CENTER);
		panel_9.setOpaque(false);
		panel_9.setBackground(new Color(169, 169, 169, 120));
		panel_9.setPreferredSize(new Dimension(400, 300));
		panel_9.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Lifetime");
		panel_9.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);

		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0,
				128, 0), new Color(0, 255, 0), new Color(255, 250, 250),
				new Color(210, 105, 30)));
		lblNewLabel.setIcon(ImageClass.getLifetimeIcon());
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 0), 24, true));

		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_9.add(panel_6, BorderLayout.CENTER);
		
		JLabel lblBestDistance = new JLabel("Lifetime Distance: " + lifeDistance);
		lblBestDistance.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblBestDistance.setForeground(new Color(255, 255, 255));
		
		JLabel lblBestFloors = new JLabel("Lifetime Floors:" + lifeFloors);
		lblBestFloors.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblBestFloors.setForeground(new Color(255, 255, 255));
		
		JLabel lblBestSteps = new JLabel("Lifetime Steps:" + lifeSteps);
		lblBestSteps.setForeground(new Color(255, 255, 255));
		lblBestSteps.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(241)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addComponent(lblBestSteps, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addGap(11))
								.addComponent(lblBestDistance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addGap(240)
							.addComponent(lblBestFloors, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
					.addGap(1))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(21)
					.addComponent(lblBestFloors, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBestSteps, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblBestDistance, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		paneldash.add(panel_5, BorderLayout.EAST);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(horizontalStrut_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addComponent(horizontalStrut_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		paneldash.add(panel_4, BorderLayout.WEST);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addComponent(horizontalStrut, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addComponent(horizontalStrut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		;
		;
		;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		// scrollPane.getVerticalScrollBar().setBorder(new
		// LineBorder(Color.GRAY));
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUI(new MyScrollbarUI());

		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		JViewport viewport = new JViewport();
		viewport.setPreferredSize(new Dimension(800, 800));
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setPreferredSize(new Dimension(400, 1000));
		viewport.setView(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 35, 830, 35, 0 };
		gbl_panel_8.rowHeights = new int[] { 80, 600, 80, 600, 80, 600, 70, 0 };
		gbl_panel_8.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);
		viewport.setOpaque(false);
		scrollPane.setViewport(viewport);

		scrollPane.setBackground(new Color(105, 105, 105));
		// scrollPane.setScrollPosition(new Point(20, 20));
		scrollPane.setSize(new Dimension(5, 5));
		scrollPane.setMinimumSize(new Dimension(5, 5));
		scrollPane.setPreferredSize(new Dimension(1000, 200));
		// cardPanel.add(scrollPane, BorderLayout.CENTER);

		/* Today Title */

		Date dateAndTime = Calendar.getInstance().getTime();

	}

}
