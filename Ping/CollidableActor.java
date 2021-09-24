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
     * checks if the ball colides with any Collidable actor.
     */
    public void checkCollision(Ball ball)
    {
       if (this.intersects(ball))
       {
           isTouchingBall = true;
       }
       else
       {
           isTouchingBall = false;
       }
    }
}
