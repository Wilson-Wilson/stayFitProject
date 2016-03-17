package ca.uwo.csd.cs2212.team12;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class AccoDict implements Serializable {

  private List<Accolade> accoList;

  private static final long serialVersionUID= 1L;
  private static final String FILENAME= "accolades.boop";
  
  /**
   * Creates an AccoDict Object and initializes accoList = new ArrayList<Accolade>()
   */
  public AccoDict(){
    accoList= new ArrayList<Accolade>();
  }
  
  /**
   * Returns boolean value showing if the user has Accolades.
   * @param accoID int The unique accoladeID.
   * @return boolean This returns a value indicating if the user has Accolades.
   */
  public boolean userHasAcco(int accoID){
    if(accoList.get(accoID).getUserObtained() == true){
      return true;
    }

    return false;
  }


  //The following methods are used to persist AccoDict object between runs
  
  /**
	 * Saves the user's Accolade information to disk.
	 * @param accos AccoDict an instance of the AccoDict object to be stored.
	 */
  private static void storeAccolades(AccoDict accos){
    try{
      ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(FILENAME));
      out.writeObject(accos);
      out.close();
        } catch(IOException e){
            System.out.println("Accolades could not be saved to disk. IO error occured.");
            e.printStackTrace();
          }

    }

  /**
	 * Loads user's Accolade information from disk into an instance of AccoDict.
	 */
  private static void loadAccolades(){
    try{
      ObjectInputStream in= new ObjectInputStream( new FileInputStream(FILENAME));
      AccoDict accoList= (AccoDict) in.readObject();

      in.close();
        } catch (IOException e){
            System.out.println("Accolades could not be loaded from disk. IO error occured.");
            e.printStackTrace();
          }
    	catch (ClassNotFoundException e){
    		System.out.println("The class could not be found.");
    		e.printStackTrace();
    	}
    }

}
