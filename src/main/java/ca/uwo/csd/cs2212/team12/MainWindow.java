package ca.uwo.csd.cs2212.team12;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Object;
import java.util.logging.LogManager;

public class MainWindow extends JFrame {

    private JPanel mainPanel;

    public MainWindow() {
        this.initUI();
    }

    private void initUI() {
        this.setTitle("StayFit");
        this.setSize(950, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        try {
            this.mainPanel = new BackgroundPanel(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("BackgroundImage.png"))));
        } catch (Exception e) {
            LogManager.getLogManager().getLogger(App.class.getName()).warning(e.getMessage());
        }
        this.add(this.mainPanel, BorderLayout.CENTER);
        //JLabel background = new JLabel();
        //background.setIcon(backgroundImageIcon);
        this.presentPanel(new LoginPanel());
    }

    /**
     * Replaces the panel currently being shown in MainWindow and replaces it with a new one.
     * @param panel
     */
    public void presentPanel(JPanel panel) {
        this.mainPanel.removeAll();
        this.mainPanel.add(panel, BorderLayout.CENTER);
    }

}