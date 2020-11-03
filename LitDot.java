
import java.util.ArrayList;

public class LitDot extends DotCom {

    
    //TODO:  all the following code was added and should have been included in the book

    protected int returnType() {
        return 0;
    }
    protected int countstep() {
      int index = (int) ( Math.random() * 4 );        // 0 = backward*1   1 = forward*1    2 = backward*2    3 = forward * 2
      int move = 0 ;     
      if ( index == 0 )   //backward
        move = -1;  
      else if ( index == 1 ) // forward
        move = 1;
      else if  ( index == 2 ) // backward*2
        move = -2;
      else if ( index == 3 ) // forward*2
        move = 2;
      return move ;
    } // countstep
    
}

 
    

    
