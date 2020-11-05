package hw2;

import java.io.*;
import java.util.*;

public class GameHelper {

  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  private int [] grid = new int[gridSize];
  private int shipamt = 0;


  public void showMap() {
      System.out.print( "  abcdefg" );
	  int j = 0 ;
      for ( int i = 0 ; i < gridSize ; i++ ) {
          if ( i % gridLength == 0 ) System.out.print( "\n" + j++ + " " );
          System.out.print( grid[i] );
      } //for
      System.out.print( "\n" );
  } // showmap
  
  public String UserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + "  ");
    try {
      BufferedReader is = new BufferedReader( new InputStreamReader(System.in)) ;
      inputLine = is.readLine();
      if (inputLine.length() == 0 )  return null; 
    } // try
    catch (IOException e) {
      System.out.println("IOException: " + e);
    } // catch
     return inputLine.toLowerCase();
  } // UserInput

  
  public ArrayList<String> MoveShip( BattleShip target ) { 
	ArrayList<String> oldloc = target.getloc() ;
    ArrayList<String> newloc =  new ArrayList<String>() ;
    int [] oldcoords = new int[oldloc.size()];                 
    int [] newcoords = new int[oldloc.size()];                 
    int moveamt = target.countstep() ;
    // a, b, c, d, e, f, g, horizontal   row
    // 0, 1, 2, 3, 4, 5, 6, vertical     column
	for( int i = 0 ; i < oldloc.size() ; i++ ) { 
  	  int row = ( (int) oldloc.get(i).charAt(0) ) - 97 ;
	  int column = ( (int) oldloc.get(i).charAt(1) ) - 48 ;

  	  int index = column*7 + row ;
  	  oldcoords[i] = index ;
  	} // while
  

    removeOldFlags( target.getloc() ) ;
    
    for ( int i = 0 ; i < oldcoords.length ; i++ ) {
      int temp = oldcoords[i] ; 
      if ( target.horizontal == true )
        temp = temp + moveamt  ;
      else
        temp = temp + moveamt * 7 ;
      

      if ( checkLocation( temp ) == true ) 
        newcoords[i] = temp ;
      else {   
    	System.out.print("cant move ship\n");
        AddFlags( target.getloc() ) ;
    	return target.getloc() ;
      } // else	
    } // for
    

    for ( int i = 0 ; i < newcoords.length ; i++ ) {//System.out.print( newcoords[i] + "\n" );
      int row = (int) (newcoords[i] / gridLength);             // get row value
      int column = newcoords[i] % gridLength;                  // get numeric column value

      String temp = String.valueOf(alphabet.charAt(column));   // convert to alpha
      
      if ( ( oldloc.get(i).charAt( oldloc.get(i).length() - 1 ) == '*' ) ) 
        newloc.add(temp.concat(Integer.toString(row) + "*" ));
      else
        newloc.add(temp.concat(Integer.toString(row)));

    } // for
    
    for ( int i = 0 ; i < newloc.size() ; i++ )
      System.out.print( newloc.get(i) + "\n" );
    
    AddFlags( newloc ) ;
    
    return newloc ;
  } // MoveShip

  public void removeOldFlags( ArrayList<String> oldCoords ) {

    for ( int i = 0 ; i < oldCoords.size() ; i++ ) {
      int row = ( (int) oldCoords.get(i).charAt(0) ) - 97 ;
      int column = ( (int) oldCoords.get(i).charAt(1) ) - 48 ;
      int index = column*7 + row ;
      grid[index] = 0;
    } // for
  } // removeOldFlags
  
  public void AddFlags( ArrayList<String> oldCoords ) {
    for ( int i = 0 ; i < oldCoords.size() ; i++ ) {
	  int row = ( (int) oldCoords.get(i).charAt(0) ) - 97 ;
	  int column = ( (int) oldCoords.get(i).charAt(1) ) - 48 ;
	  int index = column*7 + row ;
	  //grid[index] = 3 ;
	  grid[index] = 1 ;

	} // for
  } // AddFlags
  
  public boolean checkLocation( int oneloc ) {
    boolean success = true ;
    if ( oneloc < 0 ) 
      return false ;
      
	if ( grid[oneloc] == 0 ) {                      // if not already used
	  if ( oneloc >= gridSize ) {                    // out of bounds - 'bottom'
	    success = false;                            // failure
	    System.out.print( "out of bounds bottom error\n" );
	  } // if
	  if ( oneloc % gridLength == 0 ) {              // out of bounds - right edge
	    success = false;                            // failure
	    System.out.print( "out of bounds right edge error\n" );
	  } // if
	} // if
	else {                                           // found already used location
	  success = false;                              // failure
	  System.out.print( "location used error\n" );

	} // else
	
	return success ;
  } // checkLocation
  
  public ArrayList<String> PlaceShip (int comSize) {                 
    ArrayList<String> alphaCells = new ArrayList<String>();
    String [] alphacoords = new String [comSize];    
    String temp = null;                                
    int [] coords = new int[comSize];                 
    int attempts = 0;                                
    boolean success = false;                          
    int location = 0;                                 
    
    shipamt++;                                        
    int incr = 1;                               
    if ((shipamt % 2) == 1) {                        
      incr = gridLength;                            
    } // if

    while ( !success & attempts++ < 200 ) {             // main search loop  (32)
	  location = (int) (Math.random() * gridSize);      // get random starting point
	  int x = 0;                                        // nth position in dotcom to place
      success = true;                                   // assume success
      while (success && x < comSize) {                  // look for adjacent unused spots
    	 
        if (grid[location] == 0) {                      // if not already used
          coords[x++] = location;                       // save location
          location += incr;                             // try 'next' adjacent
          if (location >= gridSize)                     // out of bounds - 'bottom'
            success = false;                            // failure
          if (x>0 & (location % gridLength == 0))       // out of bounds - right edge
            success = false;                            // failure
        } // if
        else {                                          // found already used location
          success = false;                              // failure
        } // else
      
      } // while
    } // while                                        // end while    
    
    int x = 0;                                          // turn good location into alpha coords
    int row = 0;
    int column = 0;
    while (x < comSize) {
      grid[coords[x]] = 1;                              // mark master grid pts. as 'used'
      row = (int) (coords[x] / gridLength);             // get row value
      column = coords[x] % gridLength;                  // get numeric column value

      temp = String.valueOf(alphabet.charAt(column));   // convert to alpha
      
      alphaCells.add(temp.concat(Integer.toString(row)));
      x++;

      System.out.print("  coord "+x+" = " + alphaCells.get(x-1) );
      
    } // while
    
    System.out.println("\n");
    
    return alphaCells;
  } // PlaceShip
  
} // GameHelper