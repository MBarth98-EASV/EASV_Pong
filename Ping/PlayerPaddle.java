import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPaddle extends Paddle
{   
    public PlayerPaddle(SCREEN_POSITION position, boolean useMouse)
    {
        super(position, useMouse, WIDTH, HEIGHT);
    }
    
    public PlayerPaddle(SCREEN_POSITION position)
    {
        super(position, true, WIDTH, HEIGHT);
    }
    
    public PlayerPaddle()
    {
        this(SCREEN_POSITION.LEFT);
    }

    @Override
    public final void moveToMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if (mouse != null)
        {
            super.xTarget = mouse.getX();
            super.yTarget = mouse.getY();  
        }
        
        if (!this.isAxisDisabledX) // handle x component for movement
        {
            if (xPos > super.xTarget) // mouse is the right of current position
            {
                xPos -= ((xPos - super.xTarget) + this.speed) * this.deltaTime; 
            }
            else // left side
            {
                xPos += ((super.xTarget - xPos) + this.speed) * this.deltaTime; 
            }
        }
        
        if (!this.isAxisDisabledY) // handle y component for movement
        {
            if (yPos < super.yTarget) // mouse is below the current position
            {
                yPos -= ((yPos - super.yTarget) + this.speed) * this.deltaTime; 
            }
            else // above
            {
                yPos += ((super.yTarget - yPos) + this.speed) * this.deltaTime; 
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
