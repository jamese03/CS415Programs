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



public class Slingshot extends Ellipse
{
//-------------instance variables---------------------------------------
  private Rectangle base;
  private Ellipse projectile;
  private Line sling;
  private int myX, myY, startX, startY, endX, endY;
  private Point lastMouse, p1, p2;
  private Projectile p;
  private SlingshotApp s;
  private AnimationTimer timer;
//--------------constructor---------------------------------------------
  public Slingshot(int x, int y, SlingshotApp shot)
  {

    
    setLocation( x, y );
    setSize( 8, 8 );
    setColor(Color.BLACK );
    startX = x;
    startY = y;
    s = shot;
    
  

  }
  
//------------------mouse pressed method--------------------------------
  public void mousePressed( MouseEvent me )
  {
    lastMouse = me.getPoint();   
    
    sling = new Line();
    p1 = getLocation();
    sling.setP1( p1 );
    sling.setP2( p1 );
  }
//----------------mouse dragged method----------------------------------
   public void mouseDragged( MouseEvent me )
    {
     
        Point curMouse = me.getPoint();
  
        int newX = getXLocation() + curMouse.x - lastMouse.x;
        int newY =  getYLocation() + curMouse.y - lastMouse.y;

      
        setLocation( newX, newY);   
        lastMouse = curMouse;  
        sling.setP2(lastMouse);
        
        endX = getXLocation();
        endY = getYLocation();
        
        
    }

   

   
  
//-----------------mouse released----------------------------------------
   public void mouseReleased( MouseEvent me)
   {
     setLocation(startX, startY);
     sling.hide();
     s.shooting( -getXLocation() + endX, getYLocation() - endY  );  
     
     
 
     
   }

  
  
//---------------main----------------------------------------------------
  public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      SlingshotApp p = new SlingshotApp( 90, 300 );
      
   }

}