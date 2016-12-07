/**
 * Card.java 
 * 
 * Uses images from: http://www.jfitz.com/cards/
 * These images were created using GIFCon, XnView and Paint Shop Pro.
 * Feel free to use for personal or professional purposes
 * 
 * @author mlb
 *   3/25/09
 */
import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;

public class Card extends ShapeGroup 
{
    //------------------------ instance variables --------------------------
    private Image face;
    private int suit;
    private int rank;
    private int x, y;
    public  static final int WIDTH = 71;        // gif width 71
    public static final int HEIGHT = 96;        // gif height 96
 
    
    private final static String DIR = "cards_gif/";
    private final static String BACK = "b1fv.gif";// 1 blue, 2 red
    private final static String EXT = ".gif";


    private static String[] rankString = { "r",  "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "j", "q", "k"  };
    private static String[] suitString = { "j",  "s", "h", "d", "c" };
    
    
    //------------------------------------------------------
    /**
     * 
     */
    public Card( int rank, int  suit)
    {     
        this.rank = rank;
        this.suit = suit;
        // gets image from cards_gif
        face = new Image(DIR + suitString[suit] + rankString[rank] + EXT );
    
        face.setLocation(-80,0);
    }
    

    
    //-------------------------------------------------------
    //
    public void setLocation( int x, int y )
    {
        this.x = x;
        this.y = y;
        face.setLocation(x,y);
    }
    
 
    
    //-------------------------------------------------------
    //1-ace; 2- 2; 3-3; 4-4; 10-10; 11-J; 12-Q; 13-K
    public int getRank( )
    {
        return rank;
    } 
    
    //-------------------------------------------------------
    //1-spade; 2-heart; 3-diamond; 4-club
    public int getSuit( )
    {
        return suit;
    } 
    
    //-------------------------------------------------------
    // 
    public void hide( )
    {
       setLocation( -100, -100 );    
    }
    
    
    //------------------------------------------------------------------------------
    /**
     *   Return the card as a String
     */
    public String toString()
    {
        String s = "";
        if( rank ==1)
            s+="Ace of ";
        else if(rank == 11)
            s+="Jack of ";
        else if(rank == 12)
            s+="Queen of ";
        else if(rank == 13)
            s+="King of ";
        else
            s+= (rank + " of ");
        
        if(suit == 1)
            s+= "Spades";
           else if(suit == 2)
            s+= "Hearts"; 
           else  if(suit == 3)
            s+= "Diamonds";
        else
            s+= "Clubs";
        
        return s;
    }
} 