 


import java.util.ArrayList;

public class MidDot extends DotCom {
 
    //TODO:  all the following code was added and should have been included in the book

    
    protected int returnType() {
        return 1;
    }
    protected int countstep() {
      int index = (int) ( Math.random() * 2 );        // 0 = backward      1 = forward
      int move = 0 ;     
      if ( index == 0 )   //backward
          move = -1;  
      else if ( index == 1 ) // forward
          move = 1;
    return move ;
    } // countstep
}
