/* SlingshotApp
 * James English jpj68
 * 10/30
 * 
 * */


import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;

public class SlingshotApp implements Animator
{
//-------------------instance variables---------------------------------
  private Slingshot shooter;
  private Buildings building;
  private Projectile bullet;
  private AnimationTimer timer;
  private int x, y, r;
  private Boolean check = false;
  private Vector <Buildings> b;
  private Random randomNum;
  private Ashes ash;
  

//-------------------------constructor----------------------------------
  public SlingshotApp( int x, int y )
  {
    shooter = new Slingshot( x, y, this );

    this.x = x;
    this.y = y;
    int fps = 60;

    timer = new AnimationTimer( 1000/fps, this );
    timer.start();
    b = new Vector< Buildings>();
    
     randomNum = new Random();
     for(int i= 0; i< 11; i++)
    {
      r = randomNum.nextInt(115) + 15; // random number for diff heights
     
      
      building = new Buildings( 350, 400 );
      building.setSize(25, r );     
      building.setLocation( 290 + (i*30), 500 - r);
      building.setColor( Color.BLACK );
      building.setFrameColor(Color.GRAY );
      building.setFrameThickness( 3 );
      b.add(building);
    }
    
 
  }

//----------------shooting method--------------------------------------------
  public void shooting ( int dx, int dy )
  {
    
   if (bullet !=null)
   { 
   bullet.hideDots(); // hides path afterwards
   }
   bullet = new Projectile( shooter.getXLocation(), shooter.getYLocation(), -dx, -dy);
   bullet.setSize( 8, 8);
   bullet.setColor( Color.CYAN );

   

  }
  
//-----------------------animate method---------------------------------
  public void animate()
  {
    if (bullet !=null) 
    {
      bullet.move(); // method with gravity ect..
      for ( int i = 0; i < b.size(); i++ )
      {
        if (checkCollision(bullet, b.get(i))) 
        {
          
          b.get(i).hide();
          ash = new Ashes ( b.get(i).getXLocation() + 10, 460 );
          b.get(i).setLocation( -500, -500 );
          bullet.stopBullet(); // stops projectile after collision
          
          
        }
      }
    }
    
  }
  
//---------------------check collision---------------------------------
  public  boolean checkCollision(Projectile p, Buildings b )
  {
    
    /*Checks the collision between the projectile and buildings
     * uses booleans to see if its collison is true or false
     * 
     * */
    
    
    Point point1, point2, point3, point4;
    point1 = p.getLocation(); // upper left
    point2 = new Point (p.getXLocation() + p.getWidth(), 
                        p.getYLocation()); // upper right
    point3 = new Point(p.getXLocation(), p.getYLocation() 
                         - p.getHeight());
    point4 = new Point( p.getXLocation() + p.getWidth(), 
                       p.getYLocation() - p.getHeight());

      
      
      if ( b.contains(point1)) 
    {
      return true;
    }
    else if (b.contains(point2))
    {
      return true;
    }
    else if (b.contains(point3))
    {
      return true;
    }
    else if( b.contains(point4))
    {
      return true; 
    }
    else 
    {
      return false;
    }
    
    
    
    
  }
  
  

    
    
      

      
      
  

//---------------main----------------------------------------------------
  public static void main( String args[ ] )
   {
      Frame f = new Frame( );
      
      SlingshotApp  s = new SlingshotApp( 90, 400); 
   }


}