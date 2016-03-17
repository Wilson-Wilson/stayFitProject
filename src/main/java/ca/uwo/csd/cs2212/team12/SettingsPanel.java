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
		tabbedPane.setBackground(new Color(192, 192, 192));
		tabbedPane.setBorder(null);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel goalSettings = new JPanel();
		goalSettings.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("Goals Settings", null, goalSettings, null);
		tabbedPane.setBackgroundAt(0, new Color(105, 105, 105));
		goalSettings.setLayout(new BorderLayout(0, 0));

		JLabel lblThemes = new JLabel("Set Your Goals!");
		lblThemes.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblThemes.setForeground(new Color(255, 255, 255));
		lblThemes.setBackground(new Color(255, 255, 255));
		goalSettings.add(lblThemes, BorderLayout.NORTH);

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		goalSettings.add(panel_8, BorderLayout.CENTER);

		JLabel lblCards = new JLabel("Steps:");
		lblCards.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCards.setForeground(new Color(255, 255, 255));

		JLabel lblCards_1 = new JLabel("Floors:");
		lblCards_1.setForeground(new Color(255, 255, 255));
		lblCards_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Distance: ");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JEditorPane editorPane = new JEditorPane();
		
		JEditorPane editorPane_1 = new JEditorPane();
		
		JEditorPane editorPane_2 = new JEditorPane();
		
		JLabel lblCalories = new JLabel("Calories:");
		lblCalories.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCalories.setForeground(new Color(255, 255, 255));
		
		JEditorPane editorPane_3 = new JEditorPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(lblCards, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editorPane)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(lblCards_1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addComponent(editorPane_2)
								.addComponent(editorPane_1))))
					.addGap(409))
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(lblCalories)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editorPane_3)
					.addGap(410))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCards, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCards_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(editorPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(editorPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCalories)
						.addComponent(editorPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_8.setLayout(gl_panel_8);

		JPanel dashboardSettings = new JPanel();
		dashboardSettings.setBackground(new Color(105, 105, 105));
		tabbedPane.addTab("DashBoard Settings ", null, dashboardSettings, null);
		tabbedPane.setForegroundAt(1, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(1, new Color(105, 105, 105));

		JCheckBox caloriesCheckBox = new JCheckBox("Calories");
		caloriesCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		caloriesCheckBox.setForeground(new Color(255, 255, 255));
		caloriesCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		caloriesCheckBox.setOpaque(false);

		caloriesCheckBox.setSelected(Preferences.isShowCaloriesCard());
		caloriesCheckBox.addItemListener(new ItemListener() {
	    	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showCaloriesCard=false;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showCaloriesCard=true;
	        	        };
	        	    }
	        });

		JLabel label_1 = new JLabel("");

		JLabel label_2 = new JLabel("");

		JCheckBox MinutesCheckBox = new JCheckBox("Minutes");
		MinutesCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		MinutesCheckBox.setForeground(new Color(255, 255, 255));
		MinutesCheckBox.setOpaque(false);
		MinutesCheckBox.setSelected(Preferences.isShowMinutesCard());
		MinutesCheckBox.addItemListener(new ItemListener() {
	        
	        	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showMinutesCard=false;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showMinutesCard=true;
	        	        };
	        	    }
	        });

		JLabel label_5 = new JLabel("");

		JCheckBox MovementsCheckBox = new JCheckBox("Movements");
		MovementsCheckBox.setOpaque(false);
		MovementsCheckBox.setSelected(Preferences.isShowMovementsCard());
		MovementsCheckBox.addItemListener(new ItemListener() {
	    	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showMovementsCard=false;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showMovementsCard=true;
	        	        };
	        	    }
	        });
		dashboardSettings.add(MovementsCheckBox);

		JCheckBox LifetimeCheckBox = new JCheckBox("Lifetime");
		LifetimeCheckBox.setForeground(new Color(255, 255, 255));
		LifetimeCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		LifetimeCheckBox.setOpaque(false);
		LifetimeCheckBox.setSelected(Preferences.isShowLifetimeCard());
		LifetimeCheckBox.addItemListener(new ItemListener() {
	    	  
	        
	        	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showLifetimeCard=false;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showLifetimeCard=true;
	        	        };
	        	    }
	        });

		JLabel label_10 = new JLabel("");

		JLabel label_11 = new JLabel("");

		JCheckBox TimeseriesCheckBox = new JCheckBox("Time Series");
		TimeseriesCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		TimeseriesCheckBox.setForeground(new Color(255, 255, 255));
		TimeseriesCheckBox.setOpaque(false);
		TimeseriesCheckBox.setSelected(Preferences.isShowTimeSeriesCard());
		TimeseriesCheckBox.addItemListener(new ItemListener() {
	    	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showTimeSeriesCard=false;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showTimeSeriesCard=true;
	        	        };
	        	    }
	        });

		JLabel label_12 = new JLabel("");

		JLabel label_13 = new JLabel("");

		JLabel label_14 = new JLabel("");

		JCheckBox BestdaysCheckBox = new JCheckBox("Best Days");
		BestdaysCheckBox.setForeground(new Color(255, 255, 255));
		BestdaysCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BestdaysCheckBox.setOpaque(false);
		BestdaysCheckBox.setSelected(Preferences.isShowBestDaysCard());
		BestdaysCheckBox.addItemListener(new ItemListener() {
	    	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showTimeSeriesCard=false;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showTimeSeriesCard=true;
	        	        };
	        	    }
	        });

		JLabel label_15 = new JLabel("");

		JLabel label_16 = new JLabel("");

		JLabel label_17 = new JLabel("");
		
		JCheckBox chckbxMovements = new JCheckBox("Movements");
		chckbxMovements.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxMovements.setOpaque(false);
		chckbxMovements.setForeground(new Color(255, 255, 255));
		GroupLayout gl_dashboardSettings = new GroupLayout(dashboardSettings);
		gl_dashboardSettings.setHorizontalGroup(
			gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardSettings.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dashboardSettings.createSequentialGroup()
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
								.addComponent(caloriesCheckBox, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addGroup(gl_dashboardSettings.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chckbxMovements, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
									.addGap(31)))
							.addGap(57)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(76))
						.addGroup(gl_dashboardSettings.createSequentialGroup()
							.addComponent(MinutesCheckBox, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addGap(132)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(75))
						.addGroup(Alignment.TRAILING, gl_dashboardSettings.createSequentialGroup()
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.TRAILING)
								.addComponent(LifetimeCheckBox, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addComponent(TimeseriesCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(BestdaysCheckBox, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
							.addGap(8)
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_dashboardSettings.createSequentialGroup()
									.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_dashboardSettings.createSequentialGroup()
											.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_dashboardSettings.createSequentialGroup()
											.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
									.addGap(42))
								.addGroup(Alignment.TRAILING, gl_dashboardSettings.createSequentialGroup()
									.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addGap(113))))))
		);
		gl_dashboardSettings.setVerticalGroup(
			gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardSettings.createSequentialGroup()
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_dashboardSettings.createSequentialGroup()
							.addComponent(caloriesCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxMovements)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(MinutesCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(LifetimeCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(TimeseriesCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(BestdaysCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		dashboardSettings.setLayout(gl_dashboardSettings);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(107)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 236, Short.MAX_VALUE)
					.addGap(107))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(61)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 179, Short.MAX_VALUE)
					.addGap(60))
		);
		panel_2.setLayout(gl_panel_2);

		/* Today Title */

		Date dateAndTime = Calendar.getInstance().getTime();

	}
}
