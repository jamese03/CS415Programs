//-------------------------------------------------------
/**
 * Correct Snake.java for 12A
 * Rectangles
 *
 * Fall 2011
 * mlb
 * 
 */

import wheelsunh.users.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Point;
import java.awt.Color;

public class Snake  
{
//---------------- instance variables-----------------------
  private int dx = 0, dy = 0; 
  private Vector<Ellipse> body;
  Ellipse headLoc;
  private int curX, curY, prevX, prevY;
  private int SIZE = 12;
  private Boolean moving = false;
  
 // ------------------constructor--------------------------- 
  public Snake(int x, int y, int s)
  {
   
    body = new Vector<Ellipse>();
   
    
    for ( int i = 0; i < 5; i++)
    {
      
       Ellipse e = new Ellipse(x, y);
       e.setSize( SIZE, SIZE );

       body.add(e);
       
    }
    

    headLoc = body.get(body.size() -1 );
    
    
    
  }
//--------------move method-----------------------------------
  public boolean move()
  {
    if(moving)
    {
      Point next = new Point( getNextX(), getNextY());
      for ( int i = 0; i < body.size()-1; i++)
      {
        if ( body.get(i).getLocation().equals(next))
          return false;
      }
      
      
      for ( int j = 0; j < body.size()-1; j++)
      { 
        
        prevX = body.get(j).getXLocation();
        prevY = body.get(j).getYLocation();
        curX = body.get(j+1).getXLocation();
        curY = body.get(j+1).getYLocation();
        body.get(j).setLocation( curX, curY );
        
        
        
      }
      
      headLoc.setLocation(headLoc.getXLocation() + dx,
                          headLoc.getYLocation() + dy );
    }
    return true;
    
  
  }
//-----------get next x method of the head-----------------------
  public int getNextX()
  {
    
    return  headLoc.getXLocation( ) + dx;
  
  }

 //----------------get next y of the head method-----------------------------     
   public int getNextY( )
   {
      return  headLoc.getYLocation( ) + dy;
   }

   
// ------------set the next move method-------------------------------   
      public void setNextMove( int x, int y)
   {
      if (( dx == SIZE && x == -SIZE) || (dx  == -SIZE && x == SIZE ))
        return;
      
      if (( dy == SIZE && y == -SIZE) || ( dy == -SIZE && y == SIZE ))
        return;
        
      dx = x;
      dy = y;
   }
//------------------------add body part ( grow) method -------------------------
      public void addBody()
      {
        
       
        
        Ellipse e = new Ellipse(body.get(0).getXLocation(), 
                                body.get(0).getYLocation());
        e.setSize( SIZE, SIZE);
        body.add(0,e);
        
        
      }
//----------------------eating red method--------------------------------
      public void eatRed()
      {
        int bodysize;
        for ( bodysize = 0; bodysize < 5; bodysize++)
        {
           Ellipse e = new Ellipse(body.get(0).getXLocation(), 
                                body.get(0).getYLocation());
        e.setSize( SIZE, SIZE);
        body.add(0,e);
        
        }
       
        
        
      }
//=--------------------get head loc method ----------------------------
      public Point getHeadLoc()
      {
        return headLoc.getLocation();
            
      }
//------------get next row method for finding food----------------
     public int nextRow()
     {
       return getHeadLoc().y / SIZE;
     }
//------------get next column for finding food-------------
     public int nextCol()
     {
      return getHeadLoc().x / SIZE;
     
     }
//----------hide method-----------------------
     public void hide()
     {
       for ( int i = 0; i < body.size(); i++)
       {
         body.get(i).hide();
       
      }
     
     }
     
     public void start()
     {
       moving = true;
     }
//--------------stop moving method--------------------------------------
     public void stop()
     {
       moving = false;
       return;
     
     }
     
//-----------------------shrink method---------------------------------
       public void shrink()
     {
       int remove = body.size()/2;
       for( int i = 0; i < remove; i++)
       {
         Ellipse e = body.remove(i);
         e.setLocation( -100, -100);
       }
      
       
     
     
     }
           
     
}

