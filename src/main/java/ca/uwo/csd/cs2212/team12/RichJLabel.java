package ca.uwo.csd.cs2212.team12;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;

/*
 * A Label intended for titles. Has the ability to be outlined with a specified color. Anti-aliases text.
 */
public class RichJLabel extends JLabel {

    private int tracking = 0;
    private int left_x, left_y, right_x, right_y;
    private Color outlineColor;

    public RichJLabel(String text, int fontSize) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, fontSize));
    }

    public void setOutline(Color color) {
        right_x = 1;
        right_y = 1;
        outlineColor = color;
    }

    @Override public Dimension getPreferredSize() {
        String text = getText();
        FontMetrics fm = this.getFontMetrics(this.getFont());

        int w = fm.stringWidth(text);
        w += (text.length()-1)*tracking;
        w += left_x + right_x;

        int h = fm.getHeight();
        h += left_y + right_y;

        return new Dimension(w,h);
    }

    @Override public void paintComponent(Graphics g) {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        char[] chars = getText().toCharArray();

        FontMetrics fm = this.getFontMetrics(getFont());
        int h = fm.getAscent();
        LineMetrics lm = fm.getLineMetrics(getText(),g);
        g.setFont(getFont());

        this.getIcon().paintIcon(this, g, 0, 0);

        int x = 0;
        if (this.getIcon() != null) {
            x += this.getIcon().getIconWidth() + 3;
            h = ((this.getIcon().getIconHeight() / 2) + 7);
        }

        g.setColor(new Color(0, 0, 0, 180));
        g.drawString(this.getText(), ShiftWest(x, 1), ShiftNorth(h, 1));
        g.drawString(this.getText(), ShiftWest(x, 1), ShiftSouth(h, 1));
        g.drawString(this.getText(), ShiftEast(x, 1), ShiftNorth(h, 1));
        g.drawString(this.getText(), ShiftEast(x, 1), ShiftSouth(h, 1));
        g.drawString(this.getText(), x, h);

        for(int i=0; i<chars.length; i++) {
            char ch = chars[i];
            int w = fm.charWidth(ch) + tracking;

            g.drawString(""+chars[i],x-left_x,h-left_y);

            g.setColor(outlineColor);
            g.drawString(""+chars[i],x+right_x,h+right_y);

            g.setColor(getForeground());
            g.drawString(""+chars[i],x,h);

            x+=w;
        }

    }

    private int ShiftNorth(int p, int distance) {
        return (p - distance);
    }
    private int ShiftSouth(int p, int distance) {
        return (p + distance);
    }
    private int ShiftEast(int p, int distance) {
        return (p + distance);
    }
    private int ShiftWest(int p, int distance) {
        return (p - distance);
    }
}