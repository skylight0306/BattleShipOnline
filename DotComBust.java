 
//資訊二甲10627134 許寓祥 10627149許峯僑
import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;
    
    private void setUpGame() {
        
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        
         for (DotCom dotComSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocation);
        }
        
        
        for ( int i = 0; i < 3; i++ ) {
            
            int shipsize = (int)(Math.random()*3 + 2);
            ArrayList<String> newLocation;
            if ( shipsize == 2 ) {
                LitDot temp = new LitDot();
                newLocation = helper.placeDotCom(2);
                temp.setLocationCells(newLocation);
                dotComsList.add(temp);
            }
            
            else if ( shipsize == 3 ) {
                MidDot temp = new MidDot();
                newLocation = helper.placeDotCom(3);
                temp.setLocationCells(newLocation);
                dotComsList.add(temp);
            }
            else if ( shipsize == 4 ) {
                BigDot temp = new BigDot();
                newLocation = helper.placeDotCom(4);
                temp.setLocationCells(newLocation);
                dotComsList.add(temp);
            }
            
        }
    }
    
    
    
    private void startPlaying() {
        System.out.println("如果想開地圖 請去 StartPlaying() 取消 showMap 的註解");
        while (!dotComsList.isEmpty()) {
            //helper.showMap() ;
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    
    
    
    
    
    private void checkUserGuess(String userGuess)
    {
        numOfGuesses++;
        String result = "miss";
        
        for (DotCom temp : dotComsList)
        {
            
            result = temp.checkYourself(userGuess);
            
            helper.RemoveGrid( userGuess );
            if (result.equals("HIT~") || result.equals("WHACK:)") || result.equals("SMASH!"))
            {
                temp.setloc( helper.MoveDotCom( temp ) ) ;
                break;
            }
            if (result.equals("kill"))
            {
                dotComsList.remove(temp);
                break;
            }
        }
        System.out.println(result);
    }
    
    
    
    
    
    private void finishGame() {
        System.out.println("All Dot Coms are dead!  Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses");
            System.out.println("You got out before your options sank.");
        }
        else
        {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
