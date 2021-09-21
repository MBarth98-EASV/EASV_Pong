import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class BallGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGlow extends Ball
{
    /**
     * Act - do whatever the BallGlow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BallGlow()
    {
        GreenfootImage ballglow = new GreenfootImage("ballglow.png");
        setImage(ballglow);
    }
    
    public void Act()
    {
        /** Gets a list of every ball object in the world, and returns the only ball there is present.
            Thereafter, it sets the location of the glow asset to be behind the ball, and follows the ball's movement.
           */ 
        List<Ball> objects = getWorld().getObjects(Ball.class);
    
        Ball currentBall = objects.get(0);
        int ballX = currentBall.getX();
        int ballY = currentBall.getY();
        setLocation(ballX, ballY);
    }
}
