package ca.uwo.csd.cs2212.team12;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
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
	
	public Graph() {
		
    }
	
	/*public Graph2() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShowGUI2();
            }
        });
    }*/
    
    public JFXPanel ShowGUI2() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
    
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Number of Month");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Floors");
                //populating the series with data
                series1.getData().add(new XYChart.Data("1:00", 23));
                series1.getData().add(new XYChart.Data("1:15", 43));
                series1.getData().add(new XYChart.Data("1:30", 15));
                series1.getData().add(new XYChart.Data("1:45", 24));
                series1.getData().add(new XYChart.Data("2:00", 34));
                series1.getData().add(new XYChart.Data("2:15", 36));
                series1.getData().add(new XYChart.Data("2:30", 22));
                series1.getData().add(new XYChart.Data("2:45", 45));
                series1.getData().add(new XYChart.Data("3:00", 43));
                series1.getData().add(new XYChart.Data("3:15", 17));
                series1.getData().add(new XYChart.Data("3:30", 29));
                series1.getData().add(new XYChart.Data("3:45", 25));
                series1.getData().add(new XYChart.Data("4:00", 25));
                
                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Steps");
                //populating the series with data
                series2.getData().add(new XYChart.Data("1:00", 13));
                series2.getData().add(new XYChart.Data("1:15", 23));
                series2.getData().add(new XYChart.Data("1:30", 35));
                series2.getData().add(new XYChart.Data("1:45", 44));
                series2.getData().add(new XYChart.Data("2:00", 54));
                series2.getData().add(new XYChart.Data("2:15", 66));
                series2.getData().add(new XYChart.Data("2:30", 72));
                series2.getData().add(new XYChart.Data("2:45", 85));
                series2.getData().add(new XYChart.Data("3:00", 65));
                series2.getData().add(new XYChart.Data("3:15", 76));
                series2.getData().add(new XYChart.Data("3:30", 78));
                series2.getData().add(new XYChart.Data("3:45", 83));
                series2.getData().add(new XYChart.Data("4:00", 43));
                
                XYChart.Series series3 = new XYChart.Series();
                series3.setName("Calories");
                //populating the series with data
                series3.getData().add(new XYChart.Data("1:00", 3));
                series3.getData().add(new XYChart.Data("1:15", 4));
                series3.getData().add(new XYChart.Data("1:30", 23));
                series3.getData().add(new XYChart.Data("1:45", 34));
                series3.getData().add(new XYChart.Data("2:00", 58));
                series3.getData().add(new XYChart.Data("2:15", 39));
                series3.getData().add(new XYChart.Data("2:30", 67));
                series3.getData().add(new XYChart.Data("2:45", 63));
                series3.getData().add(new XYChart.Data("3:00", 78));
                series3.getData().add(new XYChart.Data("3:15", 13));
                series3.getData().add(new XYChart.Data("3:30", 20));
                series3.getData().add(new XYChart.Data("3:45", 24));
                series3.getData().add(new XYChart.Data("4:00", 24));
                
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().addAll(series1, series2, series3);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;

        /*Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });*/
        //return fxPanel;
    }

        
    /*public void initFX2(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene2();
        fxPanel.setScene(scene);
    }

        
    
    public Scene createScene2() {
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
    
}