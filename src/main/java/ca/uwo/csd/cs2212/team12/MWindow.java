import javax.swing.*;
import java.awt.*;



public class MWindow {

	private JFrame frame;
	
	
	 //Make sure to have these initialized with the right icon (smaller images i will put on the button of the ui page)
	ImageIcon backImage = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/background.png");
	ImageIcon caloriesIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/FireIcon2.png");
	ImageIcon minutesIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/TimeIcon2.png");
	ImageIcon movementIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/RunningIcon2.png");
	ImageIcon lifetimeIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/StarIcon2.png");
	ImageIcon timeseriesIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/BarGraphIcon2.png");
	ImageIcon bestdayIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/BlueStarIcon2.png");
	ImageIcon exitIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/closebutton2.png");
	ImageIcon rightarrowIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/rightArrow2.png");
	ImageIcon leftarrowIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/leftArrow2.png");
	ImageIcon trophyIcon = new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/Trophy.png");
	ImageIcon cardIcon =new ImageIcon("C:/Users/Wilson/courses/cs2212/labs/team12/src/main/resources/dash.png");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWindow window = new MWindow();
					window.frame.setSize(1000,600);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//main frame
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cl = new CardLayout(0,0);
		frame.getContentPane().setLayout(new CardLayout(0,0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		frame.getContentPane().add(panel_3, "3");
		panel_3.setLayout(cl);
		//panel_1.setBackground(Color.RED);
		
		
		
		DashBoardPanel dash= new DashBoardPanel();
		panel_3.add(dash,"2");
	
	}

}
