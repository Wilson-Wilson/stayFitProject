import java.awt.EventQueue;

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

import net.miginfocom.swing.MigLayout;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;



public class minpanel extends JPanel{

	private JFrame frame;
    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    protected Color shadowColor = Color.black;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(20, 20);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 5;
    /** The offset of shadow.  */
    protected int shadowOffset = 4;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 150;
	
	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaloriesPanel window = new CaloriesPanel();
					window.frame.setSize(1000,600);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public minpanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
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
		         Color shadowColorA = new Color(shadowColor.getRed(),
		         shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
		         Graphics2D graphics = (Graphics2D) g;

		        
		         //Draws shadow borders if any.
		         if (shady) {
		             graphics.setColor(shadowColorA);
		             graphics.fillRoundRect(
		                     shadowOffset,// X position
		                     shadowOffset,// Y position
		                     width - strokeSize - shadowOffset, // width
		                     height - strokeSize - shadowOffset, // height
		                     arcs.width, arcs.height);// arc Dimension
		         } else {
		             shadowGap = 1;
		         }

		         //Draws the rounded opaque panel with borders.
		         graphics.setColor(getBackground());
		         graphics.fillRoundRect(0, 0, width - shadowGap,
		         height - shadowGap, arcs.width, arcs.height);
		         graphics.setColor(getForeground());
		         graphics.setStroke(new BasicStroke(strokeSize));
		         graphics.drawRoundRect(0, 0, width - shadowGap,
		         height - shadowGap, arcs.width, arcs.height);

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
		
		JLabel lblNewLabel = new JLabel("Minutes");
		panel_9.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		
				lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 128, 0), new Color(0, 255, 0), new Color(255, 250, 250), new Color(210, 105, 30)));
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\TimeIcon2.png"));
				lblNewLabel.setBackground(new Color(128, 128, 128));
				lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 0), 24, true));
				
				lblNewLabel.setBorder(null);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
			
		JPanel panel_10 = new JPanel() {
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadowGap = 5;
			         Color shadowColorA = new Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
			         Graphics2D graphics = (Graphics2D) g;

			        
			         //Draws shadow borders if any.
			         if (shady) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     shadowOffset,// X position
			                     shadowOffset,// Y position
			                     width - strokeSize - shadowOffset, // width
			                     height - strokeSize - shadowOffset, // height
			                     arcs.width, arcs.height);// arc Dimension
			         } else {
			             shadowGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, arcs.width, arcs.height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(strokeSize));
			         graphics.drawRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, arcs.width, arcs.height);

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
			         int shadowGap = 5;
			         Color shadowColorA = new Color(shadowColor.getRed(),
			         shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
			         Graphics2D graphics = (Graphics2D) g;

			        
			         //Draws shadow borders if any.
			         if (shady) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     shadowOffset,// X position
			                     shadowOffset,// Y position
			                     width - strokeSize - shadowOffset, // width
			                     height - strokeSize - shadowOffset, // height
			                     arcs.width, arcs.height);// arc Dimension
			         } else {
			             shadowGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, arcs.width, arcs.height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(strokeSize));
			         graphics.drawRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, arcs.width, arcs.height);

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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Jodi-Marie\\Pictures\\Saved Pictures\\FireIcon2.png"));
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
