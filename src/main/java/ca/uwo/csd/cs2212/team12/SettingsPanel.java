package ca.uwo.csd.cs2212.team12;

import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SettingsPanel extends JPanel {


	ImageIcon backImage = ImageClass.getBackImage();

	/**
	 * Create the panel.
	 */
	public SettingsPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the panel; sub-panels, labels, borders and
	 * etc.
	 *          
	 */
	private void initialize() {
		
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
		
		final JEditorPane editorPane = new JEditorPane();
			
		final JEditorPane editorPane_1 = new JEditorPane();
		
		final JEditorPane editorPane_2 = new JEditorPane();
		
		JLabel lblCalories = new JLabel("Calories:");
		lblCalories.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCalories.setForeground(new Color(255, 255, 255));
		
		final JEditorPane editorPane_3 = new JEditorPane();
		
		
		JButton okbutton = new JButton("");
		okbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		okbutton.setContentAreaFilled(false);
		okbutton.setBorder(null);
		okbutton.setIcon(ImageClass.getOkIcon());
		okbutton.addActionListener(new ActionListener() {


	            public void actionPerformed(ActionEvent ae) {
	            	String stepInput = editorPane.getText();
	            	if( !stepInput.isEmpty() && isNumeric(stepInput) ){
	            		int add = Integer.parseInt(stepInput);
	            		Controller.getTheDailyGoals().setStepGoal(add);
	            	}
	            	
	            	String floorsInput = editorPane_1.getText();
	            	if( !floorsInput.isEmpty() && isNumeric(floorsInput) ){
	            		int add = Integer.parseInt(floorsInput);
	            		Controller.getTheDailyGoals().setFloorGoal(add);
	            		
	            	}
	            	
	            	String distInput = editorPane_2.getText();
	            	if( !distInput.isEmpty() && isNumeric(distInput) ){
	            		int add = Integer.parseInt(distInput);
	            		Controller.getTheDailyGoals().setDistGoal(add);
	            	}
	            	
	            	String calInput = editorPane_3.getText();
	            	if( !calInput.isEmpty() && isNumeric(calInput	) ){
	            		int add = Integer.parseInt(calInput);
	            		Controller.getTheDailyGoals().setCalGoal(add);
	            		
	            	}
	            	editorPane.setText("");
	            	editorPane_1.setText("");
	            	editorPane_2.setText("");
	            	editorPane_3.setText("");
	            }});
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_8.createSequentialGroup()
							.addComponent(lblCards, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(lblCards_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addComponent(editorPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(editorPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(409))
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(lblCalories)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(editorPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(okbutton)
					.addGap(309))
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
					.addGap(7)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCalories)
						.addComponent(editorPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(okbutton))
					.addGap(0, 3, Short.MAX_VALUE))
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
	        	        	Preferences.showCaloriesCard=true;
	        	        	System.out.println("SELECTED!!");
	        	        	System.out.println(Preferences.isShowCaloriesCard());
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showCaloriesCard=false;
	        	        	System.out.println("DESELCTED");
	        	        	System.out.println(Preferences.isShowCaloriesCard());

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
	        	        	Preferences.showMinutesCard=true;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showMinutesCard=false;
	        	        };
	        	    }
	        });

		JLabel label_5 = new JLabel("");


		JCheckBox LifetimeCheckBox = new JCheckBox("Lifetime");
		LifetimeCheckBox.setForeground(new Color(255, 255, 255));
		LifetimeCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		LifetimeCheckBox.setOpaque(false);
		LifetimeCheckBox.setSelected(Preferences.isShowLifetimeCard());
		LifetimeCheckBox.addItemListener(new ItemListener() {
	    	  
	        
	        	    public void itemStateChanged(ItemEvent e) {
	        	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	        	        	Preferences.showLifetimeCard=true;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showLifetimeCard=false;
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
	        	        	Preferences.showTimeSeriesCard=true;
	        	        } else {//checkbox has been deselected
	        	        	Preferences.showTimeSeriesCard=false;
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
	        	        	Preferences.showBestDaysCard=true;

	        	        } else {//checkbox has been deselected
	        	        	Preferences.showBestDaysCard=false;

	        	        };
	        	    }
	        });

		JLabel label_15 = new JLabel("");

		JLabel label_16 = new JLabel("");

		JLabel label_17 = new JLabel("");
		
		JCheckBox MovementsCheckBox = new JCheckBox("Movements");
		MovementsCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		MovementsCheckBox.setOpaque(false);
		MovementsCheckBox.setForeground(new Color(255, 255, 255));
		MovementsCheckBox.setSelected(Preferences.isShowMovementsCard());
		MovementsCheckBox.addItemListener(new ItemListener() {
	        
    	    public void itemStateChanged(ItemEvent e) {
    	        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
    	        	Preferences.showMovementsCard=true;
    	        	System.out.println("HELLO");
    	        } else {//checkbox has been deselected
    	        	Preferences.showMovementsCard=false;
    	        };
    	    }
    });
		
		JLabel lblPleaseCheckThe = new JLabel("Please check the dashboard cards you would like displayed");
		lblPleaseCheckThe.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblPleaseCheckThe.setForeground(Color.WHITE);
		
		
		GroupLayout gl_dashboardSettings = new GroupLayout(dashboardSettings);
		gl_dashboardSettings.setHorizontalGroup(
			gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardSettings.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_dashboardSettings.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPleaseCheckThe)
								.addGroup(gl_dashboardSettings.createSequentialGroup()
									.addComponent(caloriesCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(132)))
							.addGap(57)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(76))
						.addGroup(gl_dashboardSettings.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dashboardSettings.createSequentialGroup()
									.addComponent(MovementsCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(223))
								.addGroup(gl_dashboardSettings.createSequentialGroup()
									.addComponent(MinutesCheckBox, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(75))
						.addGroup(gl_dashboardSettings.createSequentialGroup()
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.TRAILING)
								.addComponent(BestdaysCheckBox, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(LifetimeCheckBox, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(TimeseriesCheckBox, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
							.addGap(8)
							.addGroup(gl_dashboardSettings.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_dashboardSettings.createSequentialGroup()
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
								.addGroup(gl_dashboardSettings.createSequentialGroup()
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
							.addComponent(lblPleaseCheckThe)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(caloriesCheckBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MovementsCheckBox)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
						.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(BestdaysCheckBox, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
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
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
