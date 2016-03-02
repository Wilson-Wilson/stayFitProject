package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class DataDict implements Serializable{

  private String user;
  private List<DataEntry> collection;

  private static final long serialVersionUID= 1L;
  private static final String FILENAME= "dailydata.boop";
  //We may need to change our collection object to a more efficient one if we decide to store many days at a time

  public DataDict(){
    collection= new ArrayList<DataEntry>();
  }

  public DataDict(String user){
    this();
    this.user= user;
  }

  /**
	* Returns value of user
	* @return
	*/

  public String getUser(){
    return this.user;
  }

  /**
  * Sets new value of user
  * @param
  */

  public void setUser(String user){
    this.user= user;
  }



  //The following methods are used to persist DataDict object between runs

  private static void storeData(DataDict dat){
    try{
      ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(FILENAME));
      out.writeObject(dat);
      out.close();
        } catch(IOException e){
            System.out.println("DataDict could not be saved to disk. IO error occured.");
            e.printStackTrace();
          }

    }


  private static void loadData(){
    try{
      ObjectInputStream in= new ObjectInputStream( new FileInputStream(FILENAME));
      DataEntry data= (DataEntry) in.readObject();

      in.close();
        } catch (IOException e){
            System.out.println("DataDict could not be loaded from disk. IO error occured.");
            e.printStackTrace();
          }
    	catch (ClassNotFoundException e){
    		System.out.println("Class could not be Found!");
            e.printStackTrace();
    	}
    }

  }
