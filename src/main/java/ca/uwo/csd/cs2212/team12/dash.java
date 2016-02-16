import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JInternalFrame;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import static java.awt.GraphicsDevice.WindowTranslucency.*;
import javax.swing.JLabel;
import java.awt.FlowLayout;


public class dash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dash frame = new dash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 134, 0, 134, 0, 134, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 110, 0, 90, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JInternalFrame internalFrame = new JInternalFrame("Carbs Burned");
		internalFrame.setFrameIcon(new ImageIcon("C:\\Users\\Wilson\\workspace\\images\\FireIcon.png"));
		//((Container) ((Component) internalFrame)).setOpacity(0.35f);
		GridBagConstraints gbc_internalFrame = new GridBagConstraints();
		gbc_internalFrame.fill = GridBagConstraints.BOTH;
		gbc_internalFrame.ipadx = 90;
		gbc_internalFrame.ipady = 50;
		gbc_internalFrame.insets = new Insets(0, 0, 5, 5);
		gbc_internalFrame.gridx = 1;
		gbc_internalFrame.gridy = 1;
		panel.add(internalFrame, gbc_internalFrame);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_1.setForeground(Color.BLACK);
		internalFrame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Minutes");
		internalFrame_1.setFrameIcon(new ImageIcon("C:\\Users\\Wilson\\workspace\\images\\TimeIcon.png"));
		GridBagConstraints gbc_internalFrame_1 = new GridBagConstraints();
		gbc_internalFrame_1.fill = GridBagConstraints.BOTH;
		gbc_internalFrame_1.ipadx = 90;
		gbc_internalFrame_1.ipady = 50;
		gbc_internalFrame_1.insets = new Insets(0, 0, 5, 5);
		gbc_internalFrame_1.gridx = 3;
		gbc_internalFrame_1.gridy = 1;
		panel.add(internalFrame_1, gbc_internalFrame_1);
		
		JPanel panel_2 = new JPanel();
		internalFrame_1.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JInternalFrame internalFrame_2 = new JInternalFrame("Movement");
		internalFrame_2.setFrameIcon(new ImageIcon("C:\\Users\\Wilson\\workspace\\images\\RunningIcon.png"));
		GridBagConstraints gbc_internalFrame_2 = new GridBagConstraints();
		gbc_internalFrame_2.fill = GridBagConstraints.BOTH;
		gbc_internalFrame_2.ipadx = 90;
		gbc_internalFrame_2.ipady = 50;
		gbc_internalFrame_2.insets = new Insets(0, 0, 5, 5);
		gbc_internalFrame_2.gridx = 5;
		gbc_internalFrame_2.gridy = 1;
		panel.add(internalFrame_2, gbc_internalFrame_2);
		
		JPanel panel_3 = new JPanel();
		internalFrame_2.getContentPane().add(panel_3, BorderLayout.CENTER);
		internalFrame_2.setVisible(true);
		
		JInternalFrame internalFrame_3 = new JInternalFrame("Time Series");
		internalFrame_3.setFrameIcon(new ImageIcon("C:\\Users\\Wilson\\workspace\\images\\BarGraphIcon.png"));
		GridBagConstraints gbc_internalFrame_3 = new GridBagConstraints();
		gbc_internalFrame_3.fill = GridBagConstraints.BOTH;
		gbc_internalFrame_3.ipadx = 90;
		gbc_internalFrame_3.ipady = 50;
		gbc_internalFrame_3.insets = new Insets(0, 0, 5, 5);
		gbc_internalFrame_3.gridx = 1;
		gbc_internalFrame_3.gridy = 3;
		panel.add(internalFrame_3, gbc_internalFrame_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		internalFrame_3.getContentPane().add(panel_4, BorderLayout.CENTER);
		
		JInternalFrame internalFrame_4 = new JInternalFrame("Lifetime Total");
		internalFrame_4.setOpaque(true);
		internalFrame_4.setFrameIcon(new ImageIcon("C:\\Users\\Wilson\\workspace\\images\\BlueStarIcon.png"));
		GridBagConstraints gbc_internalFrame_4 = new GridBagConstraints();
		gbc_internalFrame_4.fill = GridBagConstraints.BOTH;
		gbc_internalFrame_4.ipadx = 90;
		gbc_internalFrame_4.ipady = 50;
		gbc_internalFrame_4.insets = new Insets(0, 0, 5, 5);
		gbc_internalFrame_4.gridx = 3;
		gbc_internalFrame_4.gridy = 3;
		panel.add(internalFrame_4, gbc_internalFrame_4);
		
		JPanel panel_5 = new JPanel();
		internalFrame_4.getContentPane().add(panel_5, BorderLayout.CENTER);
		
		JInternalFrame internalFrame_5 = new JInternalFrame("Peronal Best");
		internalFrame_5.setOpaque(true);
		internalFrame_5.setFrameIcon(new ImageIcon("C:\\Users\\Wilson\\workspace\\images\\StarIcon.png"));
		GridBagConstraints gbc_internalFrame_5 = new GridBagConstraints();
		gbc_internalFrame_5.fill = GridBagConstraints.BOTH;
		gbc_internalFrame_5.ipadx = 90;
		gbc_internalFrame_5.insets = new Insets(0, 0, 5, 5);
		gbc_internalFrame_5.ipady = 50;
		gbc_internalFrame_5.gridx = 5;
		gbc_internalFrame_5.gridy = 3;
		panel.add(internalFrame_5, gbc_internalFrame_5);
		
		JPanel panel_6 = new JPanel();
		
		internalFrame_5.getContentPane().add(panel_6, BorderLayout.CENTER);
		internalFrame_5.setVisible(true);
		internalFrame_4.setVisible(true);
		internalFrame_3.setVisible(true);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}

}
