package ca.uwo.csd.cs2212.team12;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class BackgroundPanel extends JPanel {

	ImageIcon backImage;
public BackgroundPanel(ImageIcon backImage) {
    this.backImage= backImage;
}

@Override
protected void paintComponent(Graphics g) {
    BufferedImage scaledImage = getScaledImage();
    super.paintComponent(g);
    g.drawImage(scaledImage, 0, 0, null);
//    g.draw3DRect(20, 20, 100, 50, true);
//	 g.fill3DRect(20, 20, 100, 50, true);
}

private BufferedImage getScaledImage(){
    BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = (Graphics2D) image.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);

    return image;
}

}
