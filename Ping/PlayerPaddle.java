import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPaddle extends Paddle
{   
    public PlayerPaddle(SCREEN_POSITION position)
    {
        super(position, HEIGHT, WIDTH);
    }
    
    public PlayerPaddle()
    {
        this(SCREEN_POSITION.LEFT);
    }
    
    @Override
    public final void move()
    {
        if (Greenfoot.isKeyDown("up"))
        {
            moveUp();
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            moveDown();
        }
    }
    
    /**
     * Act - do whatever the PlayerPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
