package team12;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Graph {
	
	protected static java.awt.Color shadowColor = java.awt.Color.black;
	protected static javafx.scene.paint.Color shadowColor2 = javafx.scene.paint.Color.BLACK;
    protected static int shadowGap = 5;
    
    public static void ShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();/* {
			  @Override
			     protected void paintComponent(Graphics g) {
			         super.paintComponent(g);
			         int width = getWidth();
			         int height = getHeight();
			         int shadowGap = 5;
			         javafx.scene.paint.Color shadowColorA = new javafx.scene.paint.Color(shadowColor2.getRed(),
			         shadowColor2.getGreen(), shadowColor2.getBlue(), 150);
			         Graphics2D graphics = (Graphics2D) g;


			         //Draws shadow borders if any.
			         if (true) {
			             graphics.setColor(shadowColorA);
			             graphics.fillRoundRect(
			                     4,// X position
			                     4,// Y position
			                     width - 1 - 4, // width
			                     height - 1 - 4, // height
			                     (new Dimension(20,20)).width, (new Dimension(20,20)).height);// arc Dimension
			         } else {
			             shadowGap = 1;
			         }

			         //Draws the rounded opaque panel with borders.
			         graphics.setColor(getBackground());
			         graphics.fillRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);
			         graphics.setColor(getForeground());
			         graphics.setStroke(new BasicStroke(1));
			         graphics.drawRoundRect(0, 0, width - shadowGap,
			         height - shadowGap, (new Dimension(20,20)).width, (new Dimension(20,20)).height);

			         //Sets strokes to default, is better.
			         graphics.setStroke(new BasicStroke());
			     }
			  };*/
        fxPanel.setBackground(new java.awt.Color(255, 255, 255, 0));
    
        Platform.runLater(new Runnable() {
        	@Override
        	public void run() {
        		final NumberAxis xAxis = new NumberAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Number of Month");
                //creating the chart
                final LineChart<Number,Number> lineChart = 
                        new LineChart<Number,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Stock Monitoring, 2010");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Floors");
                //populating the series with data
                series1.getData().add(new XYChart.Data(1, 0));
                series1.getData().add(new XYChart.Data(2, 14));
                series1.getData().add(new XYChart.Data(3, 15));
                series1.getData().add(new XYChart.Data(4, 24));
                series1.getData().add(new XYChart.Data(5, 34));
                series1.getData().add(new XYChart.Data(6, 36));
                series1.getData().add(new XYChart.Data(7, 22));
                series1.getData().add(new XYChart.Data(8, 45));
                series1.getData().add(new XYChart.Data(9, 43));
                series1.getData().add(new XYChart.Data(10, 17));
                series1.getData().add(new XYChart.Data(11, 29));
                series1.getData().add(new XYChart.Data(12, 25));
                
                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Steps");
                //populating the series with data
                series2.getData().add(new XYChart.Data(1, 0));
                series2.getData().add(new XYChart.Data(2, 14));
                series2.getData().add(new XYChart.Data(3, 10));
                series2.getData().add(new XYChart.Data(4, 4));
                series2.getData().add(new XYChart.Data(5, 34));
                series2.getData().add(new XYChart.Data(6, 36));
                series2.getData().add(new XYChart.Data(7, 22));
                series2.getData().add(new XYChart.Data(8, 52));
                series2.getData().add(new XYChart.Data(9, 43));
                series2.getData().add(new XYChart.Data(10, 17));
                series2.getData().add(new XYChart.Data(11, 22));
                series2.getData().add(new XYChart.Data(12, 15));
                
                XYChart.Series series3 = new XYChart.Series();
                series3.setName("Calories");
                //populating the series with data
                series3.getData().add(new XYChart.Data(1, 0));
                series3.getData().add(new XYChart.Data(2, 10));
                series3.getData().add(new XYChart.Data(3, 20));
                series3.getData().add(new XYChart.Data(4, 30));
                series3.getData().add(new XYChart.Data(5, 40));
                series3.getData().add(new XYChart.Data(6, 50));
                series3.getData().add(new XYChart.Data(7, 20));
                series3.getData().add(new XYChart.Data(8, 30));
                series3.getData().add(new XYChart.Data(9, 55));
                series3.getData().add(new XYChart.Data(10, 45));
                series3.getData().add(new XYChart.Data(11, 70));
                series3.getData().add(new XYChart.Data(12, 60));
                
                Scene scene  = new Scene(lineChart,800,600);
                scene.setFill(new javafx.scene.paint.Color(1, 1, 1, 0));
                //scene.setFill(new javafx.scene.paint.Color(shadowColor2.getRed(), shadowColor2.getGreen(), shadowColor2.getBlue(), 150));
                lineChart.getData().addAll(series1, series2, series3);
                fxPanel.setScene(scene);
        	}
        });
        JPanel panel = new JPanel();
        panel.setBackground(java.awt.Color.black);
        panel.add(fxPanel);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });*/
        //return fxPanel;
    }
    

    /*public static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        //Scene scene = createScene();
    	final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Floors");
        //populating the series with data
        series1.getData().add(new XYChart.Data(1, 23));
        series1.getData().add(new XYChart.Data(2, 14));
        series1.getData().add(new XYChart.Data(3, 15));
        series1.getData().add(new XYChart.Data(4, 24));
        series1.getData().add(new XYChart.Data(5, 34));
        series1.getData().add(new XYChart.Data(6, 36));
        series1.getData().add(new XYChart.Data(7, 22));
        series1.getData().add(new XYChart.Data(8, 45));
        series1.getData().add(new XYChart.Data(9, 43));
        series1.getData().add(new XYChart.Data(10, 17));
        series1.getData().add(new XYChart.Data(11, 29));
        series1.getData().add(new XYChart.Data(12, 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Steps");
        //populating the series with data
        series2.getData().add(new XYChart.Data(1, 60));
        series2.getData().add(new XYChart.Data(2, 14));
        series2.getData().add(new XYChart.Data(3, 10));
        series2.getData().add(new XYChart.Data(4, 4));
        series2.getData().add(new XYChart.Data(5, 34));
        series2.getData().add(new XYChart.Data(6, 36));
        series2.getData().add(new XYChart.Data(7, 22));
        series2.getData().add(new XYChart.Data(8, 52));
        series2.getData().add(new XYChart.Data(9, 43));
        series2.getData().add(new XYChart.Data(10, 17));
        series2.getData().add(new XYChart.Data(11, 22));
        series2.getData().add(new XYChart.Data(12, 15));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Calories");
        //populating the series with data
        series3.getData().add(new XYChart.Data(1, 0));
        series3.getData().add(new XYChart.Data(2, 10));
        series3.getData().add(new XYChart.Data(3, 20));
        series3.getData().add(new XYChart.Data(4, 30));
        series3.getData().add(new XYChart.Data(5, 40));
        series3.getData().add(new XYChart.Data(6, 50));
        series3.getData().add(new XYChart.Data(7, 20));
        series3.getData().add(new XYChart.Data(8, 30));
        series3.getData().add(new XYChart.Data(9, 55));
        series3.getData().add(new XYChart.Data(10, 45));
        series3.getData().add(new XYChart.Data(11, 70));
        series3.getData().add(new XYChart.Data(12, 60));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3);
        fxPanel.setScene(scene);
    }*/
    
   
    /*public static Scene createScene() {
    	final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Floors");
        //populating the series with data
        series1.getData().add(new XYChart.Data(1, 23));
        series1.getData().add(new XYChart.Data(2, 14));
        series1.getData().add(new XYChart.Data(3, 15));
        series1.getData().add(new XYChart.Data(4, 24));
        series1.getData().add(new XYChart.Data(5, 34));
        series1.getData().add(new XYChart.Data(6, 36));
        series1.getData().add(new XYChart.Data(7, 22));
        series1.getData().add(new XYChart.Data(8, 45));
        series1.getData().add(new XYChart.Data(9, 43));
        series1.getData().add(new XYChart.Data(10, 17));
        series1.getData().add(new XYChart.Data(11, 29));
        series1.getData().add(new XYChart.Data(12, 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Steps");
        //populating the series with data
        series2.getData().add(new XYChart.Data(1, 60));
        series2.getData().add(new XYChart.Data(2, 14));
        series2.getData().add(new XYChart.Data(3, 10));
        series2.getData().add(new XYChart.Data(4, 4));
        series2.getData().add(new XYChart.Data(5, 34));
        series2.getData().add(new XYChart.Data(6, 36));
        series2.getData().add(new XYChart.Data(7, 22));
        series2.getData().add(new XYChart.Data(8, 52));
        series2.getData().add(new XYChart.Data(9, 43));
        series2.getData().add(new XYChart.Data(10, 17));
        series2.getData().add(new XYChart.Data(11, 22));
        series2.getData().add(new XYChart.Data(12, 15));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Calories");
        //populating the series with data
        series3.getData().add(new XYChart.Data(1, 0));
        series3.getData().add(new XYChart.Data(2, 10));
        series3.getData().add(new XYChart.Data(3, 20));
        series3.getData().add(new XYChart.Data(4, 30));
        series3.getData().add(new XYChart.Data(5, 40));
        series3.getData().add(new XYChart.Data(6, 50));
        series3.getData().add(new XYChart.Data(7, 20));
        series3.getData().add(new XYChart.Data(8, 30));
        series3.getData().add(new XYChart.Data(9, 55));
        series3.getData().add(new XYChart.Data(10, 45));
        series3.getData().add(new XYChart.Data(11, 70));
        series3.getData().add(new XYChart.Data(12, 60));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3);
    	
    	Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
        Text  text  =  new  Text();
        
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);

        return (scene);
    }*/
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShowGUI();
            }
        });
    }
    
    /*public static void idk(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShowGUI();
            }
        });
    }*/
}

