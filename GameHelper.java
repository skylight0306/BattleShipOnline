 

import java.io.*;
import java.util.*;

public class GameHelper {

  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  private int [] grid = new int[gridSize];
  private int comCount = 0;
  
  public void showMap() {
      System.out.print( "  abcdefg" );
	  int j = 0 ;
      for ( int i = 0 ; i < gridSize ; i++ ) {
          if ( i % gridLength == 0 ) System.out.print( "\n" + j++ + " " );
          System.out.print( grid[i] );
      } //for
      System.out.print( "\n" );
  } // showmap

  public String getUserInput(String prompt) {
     String inputLine = null;
     System.out.print(prompt + "  ");
     try {
       BufferedReader is = new BufferedReader(
     new InputStreamReader(System.in));
       inputLine = is.readLine();
       if (inputLine.length() == 0 )  return null; 
     } catch (IOException e) {
       System.out.println("IOException: " + e);
     }
     return inputLine.toLowerCase();
  }

  ///////////////////////////////
  public void RemoveGrid( String userguess ) {
      int row = 0;
      int column = 0;
      if ( userguess.charAt(0) == 'A' || userguess.charAt(0) == 'a' ) row = 0 ;
      else if ( userguess.charAt(0) == 'B' || userguess.charAt(0) == 'b' ) row = 1 ;
      else if ( userguess.charAt(0) == 'C' || userguess.charAt(0) == 'c' ) row = 2 ;
      else if ( userguess.charAt(0) == 'D' || userguess.charAt(0) == 'd' ) row = 3 ;
      else if ( userguess.charAt(0) == 'E' || userguess.charAt(0) == 'e' ) row = 4 ;
      else if ( userguess.charAt(0) == 'F' || userguess.charAt(0) == 'f' ) row = 5 ;
      else if ( userguess.charAt(0) == 'G' || userguess.charAt(0) == 'g' ) row = 6 ;
      
      
      if ( userguess.charAt(1) == '0' ) column = 0 ; 
      else if ( userguess.charAt(1) == '1' ) column = 1 ;
      else if ( userguess.charAt(1) == '2' ) column = 2 ;
      else if ( userguess.charAt(1) == '3' ) column = 3 ;
      else if ( userguess.charAt(1) == '4' ) column = 4 ;
      else if ( userguess.charAt(1) == '5' ) column = 5 ;
      else if ( userguess.charAt(1) == '6' ) column = 6 ;
      int num = column * 7 + row ;
      grid[num] = 0;
  }
  
  public void RemoveOldLoc( ArrayList<String> oldCoords ) {
    int i = 0 ;
    int size = oldCoords.size();
    while ( i < size ) {
      int row = 0;
      int column = 0;
      if ( oldCoords.get(i).charAt(0) == 'A' || oldCoords.get(i).charAt(0) == 'a' ) row = 0 ;
      else if ( oldCoords.get(i).charAt(0) == 'B' || oldCoords.get(i).charAt(0) == 'b' ) row = 1 ;
      else if ( oldCoords.get(i).charAt(0) == 'C' || oldCoords.get(i).charAt(0) == 'c' ) row = 2 ;
      else if ( oldCoords.get(i).charAt(0) == 'D' || oldCoords.get(i).charAt(0) == 'd' ) row = 3 ;
      else if ( oldCoords.get(i).charAt(0) == 'E' || oldCoords.get(i).charAt(0) == 'e' ) row = 4 ;
      else if ( oldCoords.get(i).charAt(0) == 'F' || oldCoords.get(i).charAt(0) == 'f' ) row = 5 ;
      else if ( oldCoords.get(i).charAt(0) == 'G' || oldCoords.get(i).charAt(0) == 'g' ) row = 6 ;
      
      
      if ( oldCoords.get(i).charAt(1) == '0' ) column = 0 ; 
      else if ( oldCoords.get(i).charAt(1) == '1' ) column = 1 ;
      else if ( oldCoords.get(i).charAt(1) == '2' ) column = 2 ;
      else if ( oldCoords.get(i).charAt(1) == '3' ) column = 3 ;
      else if ( oldCoords.get(i).charAt(1) == '4' ) column = 4 ;
      else if ( oldCoords.get(i).charAt(1) == '5' ) column = 5 ;
      else if ( oldCoords.get(i).charAt(1) == '6' ) column = 6 ;
      int num = column * 7 + row ;
      grid[num] = 0;//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      i++ ;
    } // while
  } // RemoveOldLoc
  
  
  
  
  
  
  
  public ArrayList<String> MoveDotCom( DotCom target ) { 
    
    ArrayList<String> oldloc = target.getloc() ; //old location
    ArrayList<String> newloc =  new ArrayList<String>() ; // new location
    int [] newcoordinate = new int[oldloc.size()];   
    int [] oldcoordinate = new int[oldloc.size()];                              
    int i = 0;
    int size = oldloc.size();
    while ( i < size ) { 
      int row = 0;
      int column = 0;
      if ( oldloc.get(i).charAt(0) == 'A' || oldloc.get(i).charAt(0) == 'a' ) row = 0 ;
      else if ( oldloc.get(i).charAt(0) == 'B' || oldloc.get(i).charAt(0) == 'b' ) row = 1 ;
      else if ( oldloc.get(i).charAt(0) == 'C' || oldloc.get(i).charAt(0) == 'c' ) row = 2 ;
      else if ( oldloc.get(i).charAt(0) == 'D' || oldloc.get(i).charAt(0) == 'd' ) row = 3 ;
      else if ( oldloc.get(i).charAt(0) == 'E' || oldloc.get(i).charAt(0) == 'e' ) row = 4 ;
      else if ( oldloc.get(i).charAt(0) == 'F' || oldloc.get(i).charAt(0) == 'f' ) row = 5 ;
      else if ( oldloc.get(i).charAt(0) == 'G' || oldloc.get(i).charAt(0) == 'g' ) row = 6 ;
      
      
      if ( oldloc.get(i).charAt(1) == '0' ) column = 0 ; 
      else if ( oldloc.get(i).charAt(1) == '1' ) column = 1 ;
      else if ( oldloc.get(i).charAt(1) == '2' ) column = 2 ;
      else if ( oldloc.get(i).charAt(1) == '3' ) column = 3 ;
      else if ( oldloc.get(i).charAt(1) == '4' ) column = 4 ;
      else if ( oldloc.get(i).charAt(1) == '5' ) column = 5 ;
      else if ( oldloc.get(i).charAt(1) == '6' ) column = 6 ;
      

      int num = column * 7 + row ;
      oldcoordinate[i] = num ;//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      i++;
    } // while
    RemoveOldLoc( target.getloc() ) ;
    i = 0 ;
    int length = oldcoordinate.length ;
    int move = target.countstep();
    while ( i < length ) {
      int temp = oldcoordinate[i] ; 
      if ( target.horizontal ) // horizontal
        temp += move  ;
      else // vertical
        temp += move * 7 ;
      

      if ( CheckEdge( temp ) ) 
        newcoordinate[i] = temp ;
      else {   
        System.out.print("The DotCom can not move\n");
        AddLoc( target.getloc() ) ;
        return target.getloc() ;
      } // else 
      i++;
    } // while
    
    i = 0;
    length = newcoordinate.length;

    while ( i < length ) {
      int row = (int) (newcoordinate[i] / gridLength);             // get row value
      int column = newcoordinate[i] % gridLength;                  // get numeric column value

      String temp = String.valueOf(alphabet.charAt(column));   // convert to alpha
      
      if ( ( oldloc.get(i).charAt( oldloc.get(i).length() - 1 ) == '*' ) ) newloc.add(temp.concat(Integer.toString(row) + "*" ));
      else newloc.add(temp.concat(Integer.toString(row)));
      i++;
    } // while
    
    i = 0;
    size = newloc.size();
    while ( i < size )
    {
      //System.out.println( newloc.get(i) );
      i++;
    }
    AddLoc( newloc ) ;
    return newloc ;
  } // MoveShip
  
  
  
  
    public void AddLoc( ArrayList<String> oldCoords ) {
    int i = 0;
    int size = oldCoords.size() ;
    while( i < size ) 
    {
      int row = 0;
      int column = 0;
      if ( oldCoords.get(i).charAt(0) == 'A' || oldCoords.get(i).charAt(0) == 'a' ) row = 0 ;
      else if ( oldCoords.get(i).charAt(0) == 'B' || oldCoords.get(i).charAt(0) == 'b' ) row = 1 ;
      else if ( oldCoords.get(i).charAt(0) == 'C' || oldCoords.get(i).charAt(0) == 'c' ) row = 2 ;
      else if ( oldCoords.get(i).charAt(0) == 'D' || oldCoords.get(i).charAt(0) == 'd' ) row = 3 ;
      else if ( oldCoords.get(i).charAt(0) == 'E' || oldCoords.get(i).charAt(0) == 'e' ) row = 4 ;
      else if ( oldCoords.get(i).charAt(0) == 'F' || oldCoords.get(i).charAt(0) == 'f' ) row = 5 ;
      else if ( oldCoords.get(i).charAt(0) == 'G' || oldCoords.get(i).charAt(0) == 'g' ) row = 6 ;
      
      
      if ( oldCoords.get(i).charAt(1) == '0' ) column = 0 ; 
      else if ( oldCoords.get(i).charAt(1) == '1' ) column = 1 ;
      else if ( oldCoords.get(i).charAt(1) == '2' ) column = 2 ;
      else if ( oldCoords.get(i).charAt(1) == '3' ) column = 3 ;
      else if ( oldCoords.get(i).charAt(1) == '4' ) column = 4 ;
      else if ( oldCoords.get(i).charAt(1) == '5' ) column = 5 ;
      else if ( oldCoords.get(i).charAt(1) == '6' ) column = 6 ;
      int num = column * 7 + row ;
      grid[num] = 1 ;  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      i++;
    } // while
  } // AddFlags
  
  
  
  public boolean CheckEdge( int temploc ) {
    boolean exist = true ;
    if ( temploc < 0 ) return false ;
    if ( grid[temploc] == 0 )                     // if not already used
    {
	  if ( temploc >= gridSize ) exist = false;                  // out of bounds - 'bottom'                       
	  if ( temploc % gridLength == 0 ) exist = false;            // out of bounds - right edge
    } 
    else exist = false;  // found already location
	return exist ;
  } // CheckEdge
  
  
  /////////////////////////////////////
 public ArrayList<String> placeDotCom(int comSize) {                 // line 19
    ArrayList<String> alphaCells = new ArrayList<String>();
    String [] alphacoords = new String [comSize];      // holds 'f6' type coords
    String temp = null;                                // temporary String for concat
    int [] coords = new int[comSize];                  // current candidate coords
    int attempts = 0;                                  // current attempts counter
    boolean success = false;                           // flag = found a good location ?
    int location = 0;                                  // current starting location
    
    comCount++;                                        // nth dot com to place
    int incr = 1;                                      // set horizontal increment
    if ((comCount % 2) == 1) {                         // if odd dot com  (place vertically)
      incr = gridLength;                               // set vertical increment
    }

    while ( !success & attempts++ < 200 ) {             // main search loop  (32)
    location = (int) (Math.random() * gridSize);      // get random starting point
        //System.out.print(" try " + location);
    int x = 0;                                        // nth position in dotcom to place
        success = true;                                 // assume success
        while (success && x < comSize) {                // look for adjacent unused spots
          if (grid[location] == 0) {                    // if not already used
             coords[x++] = location;                    // save location
             location += incr;                          // try 'next' adjacent
             if (location >= gridSize){                 // out of bounds - 'bottom'
               success = false;                         // failure
             }
             if (x>0 & (location % gridLength == 0)) {  // out of bounds - right edge
               success = false;                         // failure
             }
          } else {                                      // found already used location
              // System.out.print(" used " + location);  
              success = false;                          // failure
          }
        }
    }                                                   // end while

    int x = 0;                                          // turn good location into alpha coords
    int row = 0;
    int column = 0;
    // System.out.println("\n");
    while (x < comSize) {
      grid[coords[x]] = 1;                              // mark master grid pts. as 'used'
      row = (int) (coords[x] / gridLength);             // get row value
      column = coords[x] % gridLength;                  // get numeric column value
      temp = String.valueOf(alphabet.charAt(column));   // convert to alpha
      
      alphaCells.add(temp.concat(Integer.toString(row)));
      x++;

      // System.out.print("  coord "+x+" = " + alphaCells.get(x-1));
      
    }
    // System.out.println("\n");
    
    return alphaCells;
   }
}