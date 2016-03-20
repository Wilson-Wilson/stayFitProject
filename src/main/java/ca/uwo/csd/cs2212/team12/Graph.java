package ca.uwo.csd.cs2212.team12;

<<<<<<< HEAD
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
	
	/**
	 * Constructor creates an instance of Graph
	 */
	
	public Graph() {
		
    }
	
	/**
	 * Creates a Line Chart with calories data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setCalories() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
    
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Calories");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series1.getData().add(new XYChart.Data("1:00", i));
                }
                                
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().add(series1);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
	
	
	/**
	 * Creates a Line Chart with preset calories data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setCaloriesTest() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
        final int [] testCal = {23,45,23,21,7,8,9,14,56,67};
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Calories");
                //populating the series with data
                int hh = 1;int mm = 0;int hour_check;
                for(int i : testCal){
                	if(mm==0 && hh==1){
                		series1.getData().add(new XYChart.Data(hh+":"+mm+"0", i));
                		mm+=15;
                	}
                	else{
                		if(mm>45){
                			hh+=1;mm=0;
                			series1.getData().add(new XYChart.Data(hh+":"+mm+"0", i));         
                			mm+=15;
                		}
                		else{
                			series1.getData().add(new XYChart.Data(hh+":"+mm, i));
                			mm+=15;
                		}
                	}
                }
                                
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().add(series1);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
	
	
	/**
	 * Creates a Line Chart with movement data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setMovement() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
    
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Steps");
                //populating the series with data
                for(int i : TimeSeriesData.getStepsSet()){
                	series1.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Distance");
                //populating the series with data
                for(int i : TimeSeriesData.getStepsSet()){
                	series2.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series3 = new XYChart.Series();
                series3.setName("Floors");
                //populating the series with data
                for(int i : TimeSeriesData.getStepsSet()){
                	series3.getData().add(new XYChart.Data("1:00", i));
                }
                                
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().addAll(series1,series2,series3);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
	
	
	/**
	 * Creates a Line Chart with preset movement data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setMovementTest() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
        final int [] testSteps = {120,200,567,486,538,809,57,14,56,637};
        final int [] testDistance = {253,56,203,101,79,80,90,114,76,67};
        final int [] testFloors = {10,45,20,54,70,89,99,124,56,78};
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Steps");
                //populating the series with data
                int hh = 1;int mm = 0;
                for(int i : testSteps){
                	if(mm==0 && hh==1){
                		series1.getData().add(new XYChart.Data(hh+":"+mm+"0", i));      
                		mm+=15;
                	}
                	else{
                		if(mm>45){
                			hh+=1;mm=0;
                			series1.getData().add(new XYChart.Data(hh+":"+mm+"0", i));   
                			mm+=15;
                		}
                		else{
                			series1.getData().add(new XYChart.Data(hh+":"+mm, i));
                			mm+=15;
                		}
                	}
                }
                
              //defining a series
                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Floors");
                //populating the series with data
                hh = 1;mm = 0;
                for(int i : testDistance){
                	if(mm==0 && hh==1){
                		series2.getData().add(new XYChart.Data(hh+":"+mm+"0", i));    
                		mm+=15;
                	}
                	else{
                		if(mm>45){
                			hh+=1;mm=0;
                			series2.getData().add(new XYChart.Data(hh+":"+mm+"0", i));
                			mm+=15;
                		}
                		else{
                			series2.getData().add(new XYChart.Data(hh+":"+mm, i));
                			mm+=15;
                		}
                	}
                }
                
              //defining a series
                XYChart.Series series3 = new XYChart.Series();
                series3.setName("Distance");
                //populating the series with data
                hh = 1;mm = 0;
                for(int i : testFloors){
                	if(mm==0 && hh==1){
                		series3.getData().add(new XYChart.Data(hh+":"+mm+"0", i));   
                		mm+=15;
                	}
                	else{
                		if(mm>45){
                			hh+=1;mm=0;
                			series3.getData().add(new XYChart.Data(hh+":"+mm+"0", i));  
                			mm+=15;
                		}
                		else{
                			series3.getData().add(new XYChart.Data(hh+":"+mm, i));
                			mm+=15;
                		}
                	}
                }
                                
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().addAll(series1,series2,series3);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
	
	
	/**
	 * Creates a Line Chart with minutes data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setMinutes() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
    
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Sedentary Mins");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series1.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series2 = new XYChart.Series();
                series1.setName("Active Mins");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series1.getData().add(new XYChart.Data("1:00", i));
                }         
                                                
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().addAll(series1,series2);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
	
	
	/**
	 * Creates a Line Chart with preset minutes data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setMinutesTest() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
        final int [] testSedentary = {20,20,10,5,15,5,60,14,30,24};
        final int [] testActive = {60,45,120,101,79,86,90,34,76,67};
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Sedentary Mins");
                //populating the series with data
                int hh = 1;int mm = 0;
                for(int i : testSedentary){
                	if(mm==0 && hh==1){
                		series1.getData().add(new XYChart.Data(hh+":"+mm+"0", i));   
                		mm+=15;
                	}
                	else{
                		if(mm>45){
                			hh+=1;mm=0;
                			series1.getData().add(new XYChart.Data(hh+":"+mm+"0", i));
                			mm+=15;
                		}
                		else{
                			series1.getData().add(new XYChart.Data(hh+":"+mm, i));
                			mm+=15;
                		}
                	}
                }
                
              //defining a series
                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Active Mins");
                //populating the series with data
                hh = 1;mm = 0;
                for(int i : testActive){
                	if(mm==0 && hh==1){
                		series2.getData().add(new XYChart.Data(hh+":"+mm+"0", i));    
                		mm+=15;
                	}
                	else{
                		if(mm>45){
                			hh+=1;mm=0;
                			series2.getData().add(new XYChart.Data(hh+":"+mm+"0", i));
                			mm+=15;
                		}
                		else{
                			series2.getData().add(new XYChart.Data(hh+":"+mm, i));
                			mm+=15;
                		}
                	}
                }
                                               
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().addAll(series1,series2);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
	
	
	/**
	 * Creates a Line Chart with the user's collective data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
	public JFXPanel setAll() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
    
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
                //creating the chart
                final LineChart<String,Number> lineChart = 
                        new LineChart<String,Number>(xAxis,yAxis);
                        
                lineChart.setTitle("Time Series");
                //defining a series
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Calories");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series1.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Active Mins");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series2.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series3 = new XYChart.Series();
                series3.setName("Sedentary Mins");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series3.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series4 = new XYChart.Series();
                series4.setName("Steps");
                //populating the series with data
                for(int i : TimeSeriesData.getStepsSet()){
                	series4.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series5 = new XYChart.Series();
                series5.setName("Floors");
                //populating the series with data
                for(int i : TimeSeriesData.getCaloriesSet()){
                	series5.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series6 = new XYChart.Series();
                series6.setName("Distance");
                //populating the series with data
                for(int i : TimeSeriesData.getDistanceSet()){
                	series6.getData().add(new XYChart.Data("1:00", i));
                }
                
              //defining a series
                XYChart.Series series7 = new XYChart.Series();
                series7.setName("Calories");
                //populating the series with data
                for(int i : TimeSeriesData.getHeartRateSet()){
                	series7.getData().add(new XYChart.Data("1:00", i));
                }
                                               
                Scene scene  = new Scene(lineChart,800,600);
                lineChart.getData().addAll(series1,series2,series3,series4,series5,series6,series7);
                fxPanel.setScene(scene);
        	}
        });
        return fxPanel;
    }
    
	
	/**
	 * Creates a Line Chart with the preset collective data, a Scene and a JavaFXPanel,
	 * then adds the Line Chart to the Scene and the Scene to the JFXPanel.
	 * @return JFXPanel the newly created JFXPanel is returned
	 */
    public JFXPanel setAllTest() {
    	// This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
    
        Platform.runLater(new Runnable() {
        	public void run() {
        		final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Time of Day");
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
    }
    
}
=======

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class Graph extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}


>>>>>>> feature/W162212T12-64-setup-basic-api-acceess
