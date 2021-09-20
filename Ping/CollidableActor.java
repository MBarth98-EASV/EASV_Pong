import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColiderCollector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollidableActor extends Actor
{
    public boolean isTouchingBall; 
    
    public CollidableActor()
    {
        isTouchingBall = false ;
    }
    
    /**
     * Act - do whatever the ColiderCollector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void checkCollision(int x, int y, int width, int height)
    {
        if (getX() < x )
        {
            //isColliding = true;
        }
        else
        {
            //isColliding = false;
        }
    }
    
    /**
     * checks if the ball colides with any Collidable actor.
     */
    public void checkCollision()
    {
       Actor Ball = getOneIntersectingObject(Ball.class);
       if (Ball!=null)
       {
           isTouchingBall = true;
       }
       else
       {
           isTouchingBall = false;
       }
       
    }
    
    
    
}
