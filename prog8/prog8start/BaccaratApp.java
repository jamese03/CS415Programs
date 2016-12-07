/**
 * BaccaratApp 
 * 
 * Starts the game of Baccarat a Board (written by us) and a Game
 * written by the student and makes them peers
 * 
 * mlb 9/11
 */


public class BaccaratApp
{  
    //-------------------- constructor -------------------------
    /**
     * 
     */
    public BaccaratApp( String [] a )
    {
       Board board;
       if(a.length > 0)
           board = new Board( 1 );//test mode
        else
           board = new Board( 0 );  //game mode
        
        Game game = new Game( board );
    }
    
   //----------------------------------------------------------
    public static void main( String a[])
    {
        new wheelsunh.users.Frame();
        BaccaratApp b = new BaccaratApp( a ); 
    }
    
}
