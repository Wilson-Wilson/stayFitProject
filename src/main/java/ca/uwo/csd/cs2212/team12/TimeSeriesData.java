package ca.uwo.csd.cs2212.team12;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

public class TimeSeriesData {
	
	private int [] dataSet;
	private static final long serialVersionUID= 1L;
	private static final String FILENAME= "timeseriesdata.boop";
	
	public TimeSeriesData(JSONArray JSONData) throws JSONException{
		this.dataSet = new int [1440]; 
		int addMe;
		
		for(int i=0; i < 1440; i++){
			addMe = JSONData.getJSONObject(i).getInt("value");
			this.dataSet[i] = addMe;
		}
	}
	
	public int[] getDataSet(){
		return this.dataSet;
	}
	
  /**
   * This method is used to persist TimeSeriesData object between runs.
   * 
   * @param dat the TimeSeriesData to be stored/serialized to a file
   */
   private static void storeData(TimeSeriesData dat){
    try{
      ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(FILENAME));
      out.writeObject(dat);
      out.close();
        } catch(IOException e){
            System.out.println("TimeSeriesData could not be saved to disk. IO error occured.");
            e.printStackTrace();
          }

    }

  /**
   * This method loads serialized objects from a file
   */
  private static void loadData(){
    try{
      ObjectInputStream in= new ObjectInputStream( new FileInputStream(FILENAME));
      TimeSeriesData data= (TimeSeriesData) in.readObject();

      in.close();
        } catch (IOException e){
            System.out.println("TimeSeriesData could not be loaded from disk. IO error occured.");
            e.printStackTrace();
          }
    	catch (ClassNotFoundException e){
    		System.out.println("Class could not be Found!");
            e.printStackTrace();
    	}
    }

}
