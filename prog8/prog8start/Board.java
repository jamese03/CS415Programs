/**
 * Board -- generate a Baccarat board
 * 
 * public methods
 * ---------------
 *    int hitPlayer()
 *    int hitBanker()
 *    void newCoup()
 * 
 * 
 * @author mlb
 *    9/11
 *         
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;


public class Board
{
   
   //----------------- instance variables ------------------------
   private Vector<Image> downDeck;
   private boolean testMode = false;
   private Rectangle back;
   private Vector<Card> cards;
   
   private Vector<Card> dealtDeck;
   private int playerCount;
   private int bankerCount;
   private int cardIndex = 0;
   private Image edge;
   private Image lastDown;
   
   private TextBox pLabel, bLabel;
   
   
   private int x = 250,
      y = 130, 
      xOffset = 75,
      yOffset = 200 ;
   
   
   private Rectangle down[];
   
   //-------------------- constructor -------------------------
   /**
    * Construct a Bacarat coup 
    */
   public Board( int mode )
   {
      
      // Create Background
      back = new Rectangle(0,0);
      back.setColor( new Color( 0,66,0));
      back.setSize(700,500);
      
      // Create Empty Card Locations
      down = new Rectangle[6];
      for ( int r = 0; r<6;r++) 
      {
         down[r] = new Rectangle( Color.gray );
         down[r].setSize(70,95);
      }
      
      down[0].setLocation( x, y+yOffset);
      down[1].setLocation( x, y);
      down[2].setLocation( x + xOffset, y+yOffset);
      down[3].setLocation( x + xOffset, y);
      down[4].setLocation( x + 2*xOffset, y+yOffset);
      down[5].setLocation( x + 2*xOffset, y);
      
      pLabel = new TextBox("Player");
      pLabel.setLocation(x+80, y+100 );
      pLabel.setColor(Color.gray);
      pLabel.setWidth(60);
      
      bLabel = new TextBox("Banker");
      bLabel.setLocation(x+80, y+100+yOffset );
      bLabel.setColor(Color.gray);
      bLabel.setWidth(60);
      
      
      // If in test mode set the cards to a standard test sequence
      if(  mode == 1 )
         testMode = true;
      
      
      dealtDeck  = new Vector<Card>();
      
      // Create the deck of cards
      cards = new Vector<Card>();
      
      if( !testMode ) // shuffle cards
      {
         for ( int r = 1 ; r < 14 ; r++ )
            for ( int s = 1; s < 5 ; s++ )    
            cards.add( new Card(r,s) ); 
         
         initDownDeck(550, 30);
         updateDownDeck();
         reShuffle();
      }
      else  //set up cards
      {
         createTest();   
         initDownDeck(550, 30);
         updateDownDeck();
      }
   }
   
   //------------------------------------------------------------------------------
   /**
    *   Get the number of cards remaining in the down deck
    */
   private int getDeckCount()
   {
      return cards.size() - cardIndex;   
   }
   
   //------------------------------------------------------------------------------
   /**
    *   Get the number of cards remaining in the down deck
    */
   public void newCoup()
   {
      for(int i = 0; i< dealtDeck.size(); i++)
      {
         dealtDeck.get(i).hide();
      }
      dealtDeck.clear();
      playerCount = 0;
      bankerCount = 0;
   }
   
   
   //------------------------------------------------------------------------------
   /**
    *   Hit the player  with a new card
    */ 
   public int hitPlayer()
   {
      int a = getDeckCount();
      if(a<2)
         reShuffle();
      Card next = cards.get(cardIndex++);
      next.setLocation( x+playerCount*xOffset,y);
      updateDownDeck( );  
      dealtDeck.add( next );
      
      playerCount++;
      
      return next.getRank();
   }
   
   
   //------------------------------------------------------------------------------
   /**
    *   Hit the banker  with a new card
    */ 
   public int hitBanker()
   {
      int a = getDeckCount();
      if(a<2)
         reShuffle();
      Card next = cards.get(cardIndex++);
      next.setLocation( x+bankerCount*xOffset,y+yOffset);
      updateDownDeck( );  
      dealtDeck.add( next );
      bankerCount++;
      
      return next.getRank();
   }
   
   
   
   
   //------------------------------------------------------------------------------
   /**
    *  Creates a testing hand, see comments for sequence
    */
   private void createTest()
   {
      // banker natural
      cards.add(new Card( 10,1)); 
      cards.add(new Card( 8,1)); 
      cards.add(new Card( 5,1)); 
      cards.add(new Card( 12,1)); 
      
      // player natural
      cards.add(new Card( 1,1)); 
      cards.add(new Card( 5,1)); 
      cards.add(new Card( 8,1)); 
      cards.add(new Card( 6,1)); 
      
      // both natural, tie
      cards.add(new Card( 4,1)); 
      cards.add(new Card( 10,1)); 
      cards.add(new Card( 4,1)); 
      cards.add(new Card( 8,1)); 
      
      // both natural, banker wins
      cards.add(new Card( 4,1)); 
      cards.add(new Card( 10,1)); 
      cards.add(new Card( 4,1)); 
      cards.add(new Card( 9,1)); 
      
      // player stands banker stands
      cards.add(new Card( 3,1)); 
      cards.add(new Card( 4,1)); 
      cards.add(new Card( 3,1)); 
      cards.add(new Card( 3,1)); 
      
      
      // player stands banker hits
      cards.add(new Card( 7,1)); 
      cards.add(new Card( 11,1)); 
      cards.add(new Card( 9,1)); 
      cards.add(new Card( 5,1)); 
      cards.add(new Card( 10,2)); 
      
      // player hits (2) banker stands
      cards.add(new Card( 10,1)); 
      cards.add(new Card( 7,1)); 
      cards.add(new Card( 2,1)); 
      cards.add(new Card( 8,1)); 
      cards.add(new Card( 2,2));
      
      
        
      // player hits (2) banker hits
      cards.add(new Card( 10,1)); 
      cards.add(new Card( 4,1)); 
      cards.add(new Card( 2,1)); 
      cards.add(new Card( 13,1)); 
      cards.add(new Card( 2,2));
       cards.add(new Card( 5,2));
      
        // player hits (8) banker stands
      cards.add(new Card( 2,1)); 
      cards.add(new Card( 3,1)); 
      cards.add(new Card( 8,1)); 
      cards.add(new Card( 13,1)); 
      cards.add(new Card( 8,2));
      
      // player hits (8) banker hits
      cards.add(new Card( 3,1)); 
      cards.add(new Card( 2,1)); 
      cards.add(new Card( 8,1)); 
      cards.add(new Card( 10,1)); 
      cards.add(new Card( 8,2));
      cards.add(new Card( 5,2));

   }
   

   //------------------------------------------------------------------------------
   /**
    *  create the images
    */
   private void initDownDeck(int x, int y)
   {
      downDeck = new Vector<Image>();
      
      int count = cards.size();
      Image next;
      int i;
      for(i = 0;i<count;i++)
      {    
         next = new Image("cards_gif/b1pl.gif" );
         downDeck.add(next);
         next.setLocation(20 + 11*i , 20);
      }
      lastDown = new Image("cards_gif/b1fv.gif" );     
      lastDown.setLocation(20 + 11*i , 20);
   }
   
   //------------------------------------------------------------------------------
   /**
    *  remove cards from the deck
    */
   private void updateDownDeck( )
   {
      int count = cards.size() - cardIndex;
      
      int i;
      //  place cards from 0 to count-2
      for(i =0; i<count-2 ; i++ )
      {    
         downDeck.get(i).setLocation(20 + 11*i , 20 );
      }
      
      //  remove cards from count-1 to 51
      for(i = count -1; i<cards.size() ; i++ )
      {    
         downDeck.get(i).setLocation(-200,-200);
      }   
      lastDown.setLocation(20+11*(count-1),20);        
   }
   
   
   //------------------------------------------------------------------------------
   /**
    *  reshuffle the down deck
    */  
   public  void reShuffle()
   {
      Collections.shuffle(cards);  
      cardIndex = 0;
      updateDownDeck();
   }
   
   
    //------------------------------------------------------------------------------
   /**
    *  unit test
    */  
   public static void main(String s[])
   {
      new Frame();
      Board b = new Board( 0 );
      System.out.println( b.hitPlayer() );
      System.out.println( b.hitPlayer() );  
      System.out.println( b.hitPlayer() ); 
      
      System.out.println( b.hitBanker() );
      System.out.println( b.hitBanker() ); 
      System.out.println( b.hitBanker() ); 

   }
}
