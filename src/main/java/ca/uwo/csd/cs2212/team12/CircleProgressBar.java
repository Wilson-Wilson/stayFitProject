package ca.uwo.csd.cs2212.team12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleProgressBar extends JPanel {
	 private final static int MAX_DRAW_PROGRESS = 100;
	  private final static int FADE_TIME = 5;
	  private static final int FRACTION_OF_OUTER_RING = 5;

	  private  int progress;
	  private  Color progresscolor;
	  
	public CircleProgressBar(int progress,Color progresscolor) {
		this.progress=progress;
		setBackground(progresscolor);
		setOpaque(false);
		
	   
	}

  // Sample program that dispalys the progress in a frame and runs it.
  
 @Override
  protected void paintComponent(Graphics g) {
     Graphics2D g2 = (Graphics2D) g;
     if (progress <= FADE_TIME + MAX_DRAW_PROGRESS) {
        // Here you paint your circle progress bar. Use the progress
        // variable to paint
        // as much progress as it indicates.

        int progressToDraw = Math.min(progress, MAX_DRAW_PROGRESS);
        // Clear the background
        g2.setColor(new Color(105,105,105,10));
        g2.fill(g.getClip());

        Color drawColor = getForeground();

        // Fade the progress out when it is fully complete
      
        // Fill in the arc
        g2.setColor(drawColor);
        int angle = -(int) (((float) progressToDraw / MAX_DRAW_PROGRESS) * 360);
        g.fillArc(0, 0, getWidth(), getHeight(), 90, angle);

        // Remove the inner circle
        g2.setColor(getBackground());
        g.fillArc(getWidth() / FRACTION_OF_OUTER_RING / 2, getHeight()
         / FRACTION_OF_OUTER_RING / 2, getWidth()
         * (FRACTION_OF_OUTER_RING - 1) / FRACTION_OF_OUTER_RING,
         getHeight() * (FRACTION_OF_OUTER_RING - 1)
         / FRACTION_OF_OUTER_RING, 90, angle);

        // Draw the outer circle
        g2.setColor(drawColor);
        g.drawOval(0, 0, getWidth(), getHeight());

        // Draw the inner circle
        g.drawOval(getWidth() / FRACTION_OF_OUTER_RING / 2, getHeight()
         / FRACTION_OF_OUTER_RING / 2, getWidth()
         * (FRACTION_OF_OUTER_RING - 1) / FRACTION_OF_OUTER_RING,
         getHeight() * (FRACTION_OF_OUTER_RING - 1)
         / FRACTION_OF_OUTER_RING);
     }
  }

  @Override
  public Dimension getPreferredSize() {
     // Change this to how big you want your component.
     // If you aren't using a LayoutManager, then this is not needed and you
     // can set the size
     // directly
     return new Dimension(100, 100);
  }

  @Override
  public Dimension getMinimumSize() {
     // If this component is put in a smaller aera, how small can it get
     // before you just let the
     // the aera clip your component off
     return new Dimension(50, 50);
  }

  
 
 
} 