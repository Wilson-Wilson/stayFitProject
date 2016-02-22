import javax.swing.ImageIcon;

public class Accolade {
	
	private String accoType;
	private int accoID, accoThreshold;
	private ImageIcon accoIcon;
	
	
	public Accolade(int id, String type, int thresh, ImageIcon icon){
		
		accoID= id;
		accoType= type;
		accoThreshold= thresh;
		accoIcon= icon;
		
	}

}
