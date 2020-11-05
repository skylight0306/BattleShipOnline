package hw2;

public class MiddleShip extends BattleShip {
  
  protected int countstep() {
    int direction = (int) ( Math.random() * 2 ) ;               // 0 for backward 1 for forward
    int steps = 1 ;     // most 2 least 1
    if ( direction == 0 )
	  steps = steps * -1 ;
    return steps ;
  } // countstep
} // MiddleShip
