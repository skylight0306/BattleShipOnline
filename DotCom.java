 

import java.util.ArrayList;

public abstract class DotCom {
    
    protected abstract int countstep();
    protected abstract int returnType();
    private ArrayList<String> locationCells;
    protected boolean horizontal = false ;
    
    public void setLocationCells(ArrayList<String> loc)
    {
        locationCells = loc;
        if ( loc.get(0).charAt(1) == loc.get(1).charAt(1) )  horizontal = true ;
    }
    
    public String checkYourself(String userInput)
    {
        String result = "miss";
        
        int index = locationCells.indexOf(userInput); 
        if (index >= 0) {
            locationCells.remove(index);
            
            if (locationCells.isEmpty()) {
                result = "kill";
            }
            else
            {
                if ( returnType() == 0 ) result = "HIT~";
                else if ( returnType() == 1 ) result = "WHACK:)";
                else if ( returnType() == 2 ) result = "SMASH!";
            }
        }
        return result;
    }
    
    public ArrayList<String> getloc() {
	return locationCells ;
    } // getloc
    
    public void setloc( ArrayList<String> newlocation ) {
	locationCells = newlocation;
    } // setloc
    //TODO:  all the following code was added and should have been included in the book
    
    private String name;
    public void setName(String string) {
        name = string;
    }
    
}
