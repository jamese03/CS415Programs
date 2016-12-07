/* Slingshot 
 * James English jpj68
 * 10/30
 * 
 * */


import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;


public class Ashes extends Rectangle
{
  Rectangle r1;
  Rectangle r2;
  Rectangle r3;
//--------------------------constructor---------------------------------
  public Ashes( int x, int y )
  {
    setLocation( x, y );
    setFrameColor(Color.RED);
    setFillColor(Color.ORANGE);
    setSize( 10, 40 );
    setRotation( 10);
    r1 = new Rectangle( x, y );
    r1.setFrameColor(Color.RED);
    r1.setFillColor(Color.ORANGE);
    r1.setSize( 15, 30 );
    r1.setRotation( 85);
    r2 = new Rectangle ( x + 5, y + 10 );
    r2.setFrameColor(Color.RED);
    r2.setFillColor(Color.ORANGE);
    r2.setSize( 10, 15 );
    r3 = new Rectangle ( x, y + 20 );
    
    r3.setFrameColor(Color.BLACK);
    r3.setFillColor(Color.GRAY);
    r3.setSize( 15, 30 );
    r3.setRotation( 90 );
  
  }

  public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      
      Ashes  app = new Ashes( 50, 10); 
   }

}