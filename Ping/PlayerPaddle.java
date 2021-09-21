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
    public final void moveToTarget()
    {
        if (!this.isAxisDisabledX) // handle x component for movement
        {
            if (xPos > super.xTarget) // mouse is the right of current position
            {
                xPos -= ((xPos - super.xTarget) + this.speed) * this.deltaTimeMS; 
            }
            else // left side
            {
                xPos += ((super.xTarget - xPos) + this.speed) * this.deltaTimeMS; 
            }
        }
        
        if (!this.isAxisDisabledY) // handle y component for movement
        {
            if (yPos < super.yTarget) // mouse is below the current position
            {
                yPos -= ((yPos - super.yTarget) + this.speed) * this.deltaTimeMS; 
            }
            else // above
            {
                yPos += ((super.yTarget - yPos) + this.speed) * this.deltaTimeMS; 
            }
        }
    }

    @Override
    public final void moveKeys()
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
