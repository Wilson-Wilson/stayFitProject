package ca.uwo.csd.cs2212.team12;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import javax.swing.*;
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

public class SettingsPanel extends JPanel {

	// Make sure to have these initialized with the right icon (smaller images i
	// will put on the button of the ui page)
	ImageIcon backImage = ImageClass.getBackImage();

	/**
	 * Create the application.
	 */
	public SettingsPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the panel; sub-panels, labels, borders and
	 * etc.
	 * 
	 * @param num
	 *            int used to choose which details of the panel to display
	 */
	private void initialize() {

		// main frame
		/*
		 * frame = new JFrame(); frame.setResizable(false);
		 * frame.getContentPane().setBackground(Color.DARK_GRAY);
		 * frame.setBounds(100, 100, 450, 300);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
		final CardLayout cl = new CardLayout(0, 0);
		this.setLayout(new CardLayout(0, 0));
		final JPanel panel_3 = new JPanel();
		this.add(panel_3, "3");
		panel_3.setLayout(cl);
		cl.show(panel_3, "2");
		JPanel cardPanel = new JPanel();

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2, "name_393182417491696");
		panel_2.setBackground(new Color(0, 0, 0, 100));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("Goals Settings", null, panel_7, null);
		tabbedPane.setBackgroundAt(0, new Color(105, 105, 105));
		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel lblThemes = new JLabel("Themes ");
		lblThemes.setBackground(new Color(255, 255, 255));
		panel_7.add(lblThemes, BorderLayout.NORTH);

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_7.add(panel_8, BorderLayout.CENTER);

		JLabel lblCards = new JLabel("5 Cards ");

		JLabel lblCards_1 = new JLabel("4 cards");
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_8
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel_8
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCards)
										.addComponent(lblCards_1))
						.addContainerGap(317, Short.MAX_VALUE)));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_8.createSequentialGroup().addContainerGap()
						.addComponent(lblCards).addGap(18)
						.addComponent(lblCards_1)
						.addContainerGap(91, Short.MAX_VALUE)));
		panel_8.setLayout(gl_panel_8);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		tabbedPane.addTab("DashBoard Settings ", null, panel_6, null);
		tabbedPane.setForegroundAt(1, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(1, new Color(105, 105, 105));
		panel_6.setLayout(new GridLayout(0, 4, 0, 0));

		JCheckBox caloriesCheckBox = new JCheckBox("Calories");
		caloriesCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		caloriesCheckBox.setOpaque(false);

		caloriesCheckBox.setSelected(Preferences.isShowCaloriesCard());
		panel_6.add(caloriesCheckBox);

		JLabel label = new JLabel("");
		panel_6.add(label);

		JLabel label_1 = new JLabel("");
		panel_6.add(label_1);

		JLabel label_2 = new JLabel("");
		panel_6.add(label_2);

		JCheckBox MinutesCheckBox = new JCheckBox("Minutes");
		MinutesCheckBox.setOpaque(false);
		MinutesCheckBox.setSelected(Preferences.isShowMinutesCard());
		panel_6.add(MinutesCheckBox);

		JLabel label_3 = new JLabel("");
		panel_6.add(label_3);

		JLabel label_4 = new JLabel("");
		panel_6.add(label_4);

		JLabel label_5 = new JLabel("");
		panel_6.add(label_5);

		JCheckBox MovementCheckBox = new JCheckBox("Movements");
		MovementCheckBox.setOpaque(false);
		MovementCheckBox.setSelected(Preferences.isShowMovementsCard());
		panel_6.add(MovementCheckBox);

		JLabel label_6 = new JLabel("");
		panel_6.add(label_6);

		JLabel label_7 = new JLabel("");
		panel_6.add(label_7);

		JLabel label_8 = new JLabel("");
		panel_6.add(label_8);

		JCheckBox LifetimeCheckBox = new JCheckBox("Lifetime");
		LifetimeCheckBox.setOpaque(false);
		LifetimeCheckBox.setSelected(Preferences.isShowLifetimeCard());
		panel_6.add(LifetimeCheckBox);

		JLabel label_9 = new JLabel("");
		panel_6.add(label_9);

		JLabel label_10 = new JLabel("");
		panel_6.add(label_10);

		JLabel label_11 = new JLabel("");
		panel_6.add(label_11);

		JCheckBox TimeseriesCheckBox = new JCheckBox("Time Series");
		TimeseriesCheckBox.setOpaque(false);
		TimeseriesCheckBox.setSelected(Preferences.isShowTimeSeriesCard());
		panel_6.add(TimeseriesCheckBox);

		JLabel label_12 = new JLabel("");
		panel_6.add(label_12);

		JLabel label_13 = new JLabel("");
		panel_6.add(label_13);

		JLabel label_14 = new JLabel("");
		panel_6.add(label_14);

		JCheckBox BestdaysCheckBox = new JCheckBox("Best Days");
		BestdaysCheckBox.setOpaque(false);
		BestdaysCheckBox.setSelected(Preferences.isShowBestDaysCard());
		BestdaysCheckBox.panel_6.add(BestdaysCheckBox);

		JLabel label_15 = new JLabel("");
		panel_6.add(label_15);

		JLabel label_16 = new JLabel("");
		panel_6.add(label_16);

		JLabel label_17 = new JLabel("");
		panel_6.add(label_17);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addGap(107)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
								236, Short.MAX_VALUE).addGap(107)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addGap(61)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
								179, Short.MAX_VALUE).addGap(60)));
		panel_2.setLayout(gl_panel_2);

		/* Today Title */

		Date dateAndTime = Calendar.getInstance().getTime();

	}
}
