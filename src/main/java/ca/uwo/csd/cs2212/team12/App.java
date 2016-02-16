package ca.uwo.csd.cs2212.team12;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.SwingUtilities;

public class App {

  static Logger logger = LogManager.getLogger (App.class.getName());

  public static void main ( String[] args ) {
    logger.trace("Entering main");
    logger.warn("Hello Maven/log4j World"); 
    logger.info("Our team name is team 12");

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        MainWindow window = new MainWindow();
        window.setVisible(true);
      }
    });
   logger.trace("Exiting main");  
     }
}
