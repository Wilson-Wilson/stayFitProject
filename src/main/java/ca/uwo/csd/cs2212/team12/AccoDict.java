package ca.uwo.csd.cs2212.team12;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class AccoDict implements Serializable {

  private List<Accolade> accoList;

  private static final long serialVersionUID= 1L;
  private static final String FILENAME= "accolades.boop";

  public AccoDict(){
    accoList= new ArrayList<Accolade>();
  }

  public boolean userHasAcco(int accoID){
    if(accoList.get(accoID).getUserObtained() == true){
      return true;
    }

    return false;
  }


  //The following methods are used to persist AccoDict object between runs

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
