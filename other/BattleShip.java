package hw2;

import java.util.ArrayList;

public abstract class BattleShip {
	
  protected abstract int countstep();

  private ArrayList<String> locations;
  private int HP ;
  protected boolean horizontal ;
  
 
  public ArrayList<String> getloc() {
	return locations ;
  } // getloc
  
  public void setHP( int num ) {
    HP = num ;
  } // setHP
  
  public void setloc( ArrayList<String> newloc ) {
	locations = newloc;
    if ( newloc.get(0).charAt(1) == newloc.get(1).charAt(1) )  horizontal = true ;
  } // setloc
    
  public String checkYourself( String userInput ) {
    String result = "miss" ;
    int index = locations.indexOf( userInput );
    if ( index >= 0 ) {
      //locations.remove( index );
      locations.set(index, userInput + "*" ) ;
      HP = HP - 1 ;
      if ( HP == 0 ) result = "kill" ;
      else result = "hit";
    } // if
    
    return result;
    
  } // checkYourself
  
} // BattleShip
