/* Building 
 * James English jpj68
 * 10/30
 * 
 * */
import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;

public class Buildings extends Rectangle
{
//-------------instance variables---------------------------------------
  private Vector<Rectangle> buildings;
  private Rectangle building;
  private Random randomNum;
  private int r;

//---------------constructor-------------------------------------------- 
  public Buildings( int x, int y)
  {
    randomNum = new Random();
    
////      r = randomNum.nextInt(115) + 15;
//      buildings.add(building);
      
////      building = new Rectangle(x, y);
//      building.setSize(25, 50 );    
//      building.setColor( Color.BLACK );
//      building.setFrameColor(Color.GRAY );
//      building.setFrameThickness( 3 );
//      add(building);
    
   
  
  
  }

//-------------------------main method----------------------------------  
  public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      Buildings  s = new Buildings( 100, 200 ); 
   }



}