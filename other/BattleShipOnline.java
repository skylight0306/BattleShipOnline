package hw2;

import java.util.ArrayList;

public class BattleShipOnline {
  private GameHelper helper = new GameHelper();
  private ArrayList<BattleShip> shiplist = new ArrayList<BattleShip>();
  private int numOfGuesses = 0;

  private void Setup() {
    System.out.println("Your goal is to sink three dot coms.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Try to sink them all in the fewest number of guesses");
      
    for( int i = 0 ; i < 3 ; i++ ) {
      int max = 4, min = 2 ;
      int shipsize = (int) ( Math.random() * ( max - min + 1) ) + min ;
      ArrayList<String> newloc ;
      if ( shipsize == 2  ) {
        SmallShip temp = new SmallShip() ;
        newloc = helper.PlaceShip( 2 ) ;
        temp.setloc( newloc ) ;
        temp.setHP( 2 ) ;
        shiplist.add( temp ) ;
      } // if
      else if ( shipsize == 3 ) {
        MiddleShip temp = new MiddleShip() ;
        newloc = helper.PlaceShip( 3 ) ;
        temp.setloc( newloc ) ;
        temp.setHP( 3 ) ;
        shiplist.add( temp ) ;    	  
      } // else if
      else if ( shipsize == 4 ) {
        LargeShip temp = new LargeShip() ;
        newloc = helper.PlaceShip( 4 ) ;
        temp.setloc( newloc ) ;
        temp.setHP( 4 ) ;
        shiplist.add( temp ) ;
      } // else if   	  
    } // for
  } // Setup
  
  private void startgame() {
    while (!shiplist.isEmpty()) {
	  helper.showMap() ;
	  String userinput = helper.UserInput("\nEnter a guess: ");	 
	  checkUserGuess(userinput);
	} // while 
	      
	finish();
  } // startgame
  
  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "" ;
    for ( BattleShip temp : shiplist) {
      result = temp.checkYourself(userGuess);
      if ( result.equals("hit") ) {
    	temp.setloc( helper.MoveShip( temp ) ) ;
        break;
      } // if
      else if (result.equals("kill") ) {
    	shiplist.remove(temp);
    	helper.removeOldFlags( temp.getloc() ) ;
        break;
      } // else if
    } // for
      
    System.out.println( result );
  } // checkUserGuess
  
  private void finish() {
    System.out.println("All Dot Coms are dead!  Your stock is now worthless");
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses");
      System.out.println("You got out before your options sank.");
    } // if
    else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options.");
    } // else
  } // finish
  
  public static void main(String[] args) {
      BattleShipOnline game = new BattleShipOnline();
      game.Setup();
      game.startgame();
  } // main
} // BattleShipOnline
