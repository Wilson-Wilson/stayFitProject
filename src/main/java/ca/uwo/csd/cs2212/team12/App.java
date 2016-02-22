package ca.uwo.csd.cs2212.team12;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.SwingUtilities;

/**
 * App is responsible for handling the main(..) method and instantiating the application.
 */
public class App {

  static Logger logger = LogManager.getLogger (App.class.getName());

  public static void main ( String[] args ) {
    logger.trace("Entering main");
    logger.warn("Hello Maven/log4j World"); 
    logger.info("Our team name is team 12");

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        ///MainWindow window = new MainWindow();
        ///window.setVisible(true);
        try {
          DashBoard window = new DashBoard();
          window.frame.setSize(1000,600);
          window.frame.setVisible(true);
        } catch (Exception e) {
          logger.warn(e.getMessage());
        }
      }
    });
   logger.trace("Exiting main");
     }
}
