package ca.uwo.csd.cs2212.team12;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Object;
import java.util.logging.LogManager;

public class AlternativeBackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public AlternativeBackgroundPanel() {
        this.setLayout(new BorderLayout());
        try {
            this.backgroundImage = ImageIO.read(ClassLoader.getSystemResource("BackgroundImage.png"));
        } catch (Exception e) {
            LogManager.getLogManager().getLogger(App.class.getName()).warning(e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage.getScaledInstance(950, -1, Image.SCALE_SMOOTH), 0, 0, this);
    }
}