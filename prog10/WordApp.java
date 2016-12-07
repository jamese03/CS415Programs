/* James English
 * 
 * jpj68 
 * program 10
 * */
import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;

public class WordApp implements KeyListener, Animator
{
//--------------------instance variables-------------------------------
  private  TextBox tb, hintBox, userBox;
  private Vector <String> answers;
  private Vector <String> hints;
  private Vector<String> combined;
  private Vector<String> words; 
  private String current, hint, scrambledWord, sofar = "";
  private int wordIndex;
  private Random randomNum;
  private int r, n, score;
  private double time = 1200;
  private AnimationTimer timer;
  
  
  
//---------------constructor---------------------------------------------
  public WordApp( int x, int y )
  {
    tb = new TextBox( 50, 50 );
     tb.setText( "Current Word: \nTime: " );
     tb.setWidth(250);
    
    hintBox = new TextBox( 400, 50 );
    hintBox.setText("HINT: ");
    userBox = new TextBox( 50, 200 );
    userBox.setText("ENTER WORD: \nScore: ");
    
    combined =  FileUtilities.getStrings( );
    
    answers = new Vector<String>();
    hints = new Vector<String>();
    
    for( int i = 0; i < combined.size(); i++)
    {
      
      String s = combined.get(i);
      int idx = s.indexOf(":");
      answers.add(s.substring(0, idx));
      hints.add(s.substring(idx));
      
    }
    
    timer = new AnimationTimer( 100, this );
    timer.start();
    
    this.setWord();
   
    scrambledWord = scrambleWord( current );
    
    refreshDisplay();
   // System.out.println(timer);
    
    
  }
  
  
//------------------seting up word-------------------------------------
  public void setWord()
  {
  
    current = answers.get(wordIndex);
    hint = hints.get(wordIndex);
    wordIndex++;
    time = 1200;
  
  }
  
//-----------------------scramble method ---------------------------------
  public String scrambleWord(String s)
  {
    randomNum = new Random();
    
    String scram = "";
    String str = current;
    
    while ( str.length() > 0 )
    {
      int n = str.length();
      r = randomNum.nextInt(n);
      
   
      scram += str.charAt(r);
      str = deleteString(str, r);
    
    }

    return scram;
  }
  
//-------------string delete method-------------------------------------
  public String deleteString(String str, int i )
  {
    
    String s = str.substring(0,i);
    String st = str.substring(i+1);
    
    String deletedString = s + st;
    
    return deletedString;
  
  }

//---------------------key pressed method-------------------------------
   public void keyPressed(KeyEvent e) 
   {
          // empty to satisfy keylistener
      
   }
   
//--------------------------key released--------------------------
   public void keyReleased(KeyEvent e) 
   {
     
     // empty to satisfy keylistener
     
   }
   
//-----------------------key typed method------------------------------
   public void keyTyped( KeyEvent e ) 
   {
     
      String s  =  Character.toString( e.getKeyChar( )); // give hint
      if ( s.equals("?"))                               // on "?"
      {
        hintBox.setText("HINT: " + hint );
        score = score - 4;
        System.out.println("? Pressed for Hint");
      }
      
      else if ( s.equals("\n"))  // new word on enter
      {
        
        setWord();
        scrambledWord = scrambleWord( current );
        score--;
        sofar = "";
        hintBox.setText("HINT: ");
        
      }
        
      else if ( s.equals (" ") ) // sets it to blank on space
      {
       sofar = "";
      }
      

      
      // converts 
      else if ( current.contains( s.toUpperCase() )) 
      {
        
        if (sofar.length() < current.length())
        {
          sofar += s;
           
        }
        
      }
      
      
      if ( sofar.equalsIgnoreCase(current) )
      {
      
        score++;
        this.setWord();
        System.out.println("SCORE UPDATE " );
        sofar = "";
        scrambledWord = scrambleWord( current );
      
      }          
               
      
   
      System.out.println(sofar);
      userBox.setText("ENTER WORD: " + sofar + "\nScore: " + score);
      
     // refreshDisplay( );
   }
//--------------------------animate method------------------------------
   public void animate()
   {
    time--;
    refreshDisplay();
   
   }
   
//------------------------------refresh display------------------------
   private void refreshDisplay()
   {
     
     tb.setText( "Current Word: " + scrambledWord + "\nTime: "
                  + time/10 );
     tb.setWidth(250);
     
     
     
   }   
//------------------------main------------------------------------------
  public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      
      WordApp  s = new WordApp( 90, 400); 
      f.addKeyListener(s);
      
   }



}