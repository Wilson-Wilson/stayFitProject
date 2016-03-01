package ca.uwo.csd.cs2212.team12;
import javax.swing.*;
import java.awt.*;

public class StayFit{

  public static void main(String[] args) {

    if(args.length>0 && args[0]== "test"){
//      TestAPI api= new TestAPI();
    }
    else{
//      API api= new API();
    }

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

}
