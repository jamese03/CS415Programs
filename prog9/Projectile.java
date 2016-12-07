/* Projectile
 * James English jpj68
 * 10/30
 * 
 * */


import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;

public class Projectile extends Ellipse
{
//--------------------- instance variables------------------------------  
  private Vector<Ellipse> points;
  private Ellipse point;
  private final double G = .2;
  private final double SLING = .11;
  private int x, y, dx, dy;
  private int time = 0;
  private Boolean check = true;
  
//--------------constructor-----------------------------------------------
  public Projectile( int x, int y, int dx, int dy)
  {
    setLocation( x, y );
    this.x = x; 
    this.y = y;
    this.dx = dx;
    this.dy = dy;
   
     points = new Vector<Ellipse>();
  
  
  }
//---------------move method--------------------------------------------
 
  public void move()
  {
    if ( check )
    {  
    time++;
    double newX = x + time *SLING*dx;
    double grav = G*.5*time*time;
    double newY = y + time*-SLING*dy + grav;
    setLocation( (int)newX, (int)newY );
    
  
   
    point = new Ellipse ( this.getXLocation(), this.getYLocation());
    point.setSize( 2, 2 );
    point.setColor(Color.RED);
    points.add(point);
   
   }
  
  }
//-----------------------------hide method---------------------------------
  public void stopBullet()
  {
    check = false;
    this.hide();
    
  
  }
//---------------------------hide trail---------------------------------
  public void hideDots()
  {
    for ( int i = 0; i < points.size(); i++ )
    {
      points.get(i).hide();
    
    }
  
  }



}