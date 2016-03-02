package ca.uwo.csd.cs2212.team12;
import javax.swing.*;
import java.awt.*;

public class StayFit{

    public static void main(String[] args) {



        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    API api;
                    if(args.length>0 && args[0]== "test"){
                        api= new TestAPI();
                    }
                    else{
                        api= new RealAPI();
                    }
                    MWindow window = new MWindow();
                    window.setAPI(api);
                    window.frame.setSize(1000,600);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
