package ca.uwo.csd.cs2212.team12;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Accoladssssss extends JPanel {

	/**
	 * Create the panel.
	 */
	public Accoladssssss() {
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_1078553577093178");
		
		JLabel lblNewLabel = new JLabel("Accolade2");
		
		JLabel lblAccolade = new JLabel("Accolade 1");
		
		JLabel lblAccolade_1 = new JLabel("Accolade3");
		
		JLabel lblAccolade_2 = new JLabel("Accolade4");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(163)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAccolade_2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(206))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAccolade_1, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
									.addGap(4))
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblAccolade, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(188))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(65)
					.addComponent(lblAccolade)
					.addGap(46)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(lblAccolade_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(lblAccolade_2)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}

}
