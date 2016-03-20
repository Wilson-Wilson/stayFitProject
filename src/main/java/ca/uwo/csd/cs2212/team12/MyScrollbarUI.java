package ca.uwo.csd.cs2212.team12;

import javax.swing.*;
import javax.swing.plaf.metal.MetalScrollBarUI;
import java.awt.*;
import java.awt.image.BufferedImage;

class MyScrollbarUI extends MetalScrollBarUI {

    private Image imageThumb, imageTrack;
    private JButton b = new JButton() {


        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }

    };

    static public Image createScrollbarImage(int w, int h, Color c) {
        BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setPaint(c);
        g2d.fillRect(0, 0, w, h);
        g2d.dispose();
        return bi;
    }

    MyScrollbarUI() {
        imageThumb = createScrollbarImage(32, 32, Color.darkGray);
        imageTrack = createScrollbarImage(32, 32, Color.gray.darker());
    }

    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        g.setColor(Color.white);
        ((Graphics2D) g).drawImage(imageThumb,
            r.x, r.y, r.width, r.height, null);
    }

    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        ((Graphics2D) g).drawImage(imageTrack,
            r.x, r.y, r.width, r.height, null);
    }

    protected JButton createDecreaseButton(int orientation) {return b;}
    protected JButton createIncreaseButton(int orientation) {return b;}
}
