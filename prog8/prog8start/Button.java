/**
 * Button
 * 
 * James English 
 * 
 * 
 * */
import wheelsunh.users.*;
import java.awt.Color;

public class Button extends TextBox 
{
//---------instance variables-------------------------------------------
  int clickCount;
  Game game;
//----------------------------constructor-----------------------------  
  
  public Button( int x, int y, Game g )
  {
  
  super( x, y );
  
  game = g;
  
  }
//--------------------mouse pressed method----------------------------
  public void mousePressed(  java.awt.event.MouseEvent e )
    {
    game.gameMethod();
    
    }

  
//---------------------main--------------------------------------------  
  public static void main(String[] args)
    {
       new Frame();
       //Button stepButton = new Button( 400, 200 );
        
    }

}