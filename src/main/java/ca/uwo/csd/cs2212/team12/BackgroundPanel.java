package ca.uwo.csd.cs2212.team12;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BackgroundPanel extends JPanel {

	ImageIcon backImage;
/**
 * This method creates the background panel with the given parameter 
 * as the background image
 * 
 * @param backImage the image to be used as the background
 */
public BackgroundPanel(ImageIcon backImage) {
    this.backImage= backImage;
}

@Override
/**
 * This method takes a Graphic object and manipulates it's dkmensions 
 * to fit the screen
 * 
 * @param g the Graphic object that will be scaled to fit the screen
 */
protected void paintComponent(Graphics g) {
    BufferedImage scaledImage = getScaledImage();
    super.paintComponent(g);
    g.drawImage(scaledImage, 0, 0, null);
//    g.draw3DRect(20, 20, 100, 50, true);
//	 g.fill3DRect(20, 20, 100, 50, true);
}
/**
 * This method changes backImage into a Graphic object
 * To make it easier to manipulate it's properties
 * in the paintComponent method
 * 
 * @return BufferredImage 
 */
private BufferedImage getScaledImage(){
    BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = (Graphics2D) image.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);

    return image;
}

}
