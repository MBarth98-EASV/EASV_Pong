import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class PaddleGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaddleGlow extends Actor
{
    
    public PaddleGlow()
    {
        GreenfootImage paddleglow = new GreenfootImage("paddleglow.png");
        setImage(paddleglow);
    }
    
    public void act()
    {
        /** Gets a list of every paddle object in the world, and returns the only paddle there is present.
            Thereafter, it sets the location of the glow asset to be behind the paddle, and follows the paddle's movement.
           */ 
        List<PlayerPaddle> objects = getWorld().getObjects(PlayerPaddle.class);
    
        PlayerPaddle currentPaddle = objects.get(0);
        int paddleX = currentPaddle.getX();
        int paddleY = currentPaddle.getY();
        
        setLocation(paddleX, paddleY);
    }
}
