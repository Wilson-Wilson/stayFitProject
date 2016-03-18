package ca.uwo.csd.cs2212.team12;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.text.Format;
import java.text.SimpleDateFormat; 
import java.util.Date; 

import javafx.stage.Stage;

import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 

import org.jdesktop.swingx.JXDatePicker; 


/** 
* This is exactly like TableDemo, except that it uses a 
* custom cell editor to validate integer input. 
*/ 
public class DateandTime  extends javafx.application.Application { 
static String date;
static int i=0;
public String date2;
static JXDatePicker datePicker;


	public DateandTime(JXDatePicker jxdatePicker) { 
		
		datePicker=jxdatePicker;
		System.out.println("In Dateandtime constructor");

					intialize();
					
      
} 
	
	public static void intialize(){
		 
	//	Date date1=datePicker.getDate();
	//date=String.format("%tF",date1);
		 System.out.println("In iniatialize");
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println("In datepicker.addactionlistener");
				Format formatter = new SimpleDateFormat("MMMM" + " "+"d" + " "+"YYY"); 
				String s = formatter.format(datePicker.getDate());
				
				//label.setText(datePicker.getDate().toString());
				setDate(s);
			}
		});
		
		};
	public static void setDate(String daten){
		
       date= daten;
         System.out.println("insetdate");
       getDate();
	}
	public static String getDate(){
		System.out.println("vV"+date);
		return date;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}