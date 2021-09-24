import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPaddle here.
 * 
 * @author philip esmaeel zadeh
 * @author victor gugerel
 * @author mads rahr mandahl-barth
 * @author mikkel theut meier
 * @author rasmus scherning sandbæk   
 * @version (a version number or a date)
 */
public class PlayerPaddle extends Paddle
{   
    private String KeyUp;
    private String KeyDown;
    
    public PlayerPaddle(SCREEN_POSITION position, String KeyUp, String KeyDown)
    {
        super(position, false, WIDTH, HEIGHT);
        this.KeyUp = KeyUp;
        this.KeyDown = KeyDown;
    }
    
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
            if (this.xPos > super.xTarget) // mouse is to the right of current position
            {
                this.xPos -= ((this.xPos - super.xTarget) + this.speed) * this.deltaTime; 
            }
            else // mouse is to the right of current position
            {
                this.xPos += ((super.xTarget - this.xPos) + this.speed) * this.deltaTime; 
            }
        }
        
        if (!this.isAxisDisabledY) // handle y component for movement
        {
            if (this.yPos < super.yTarget) // mouse is below the current position
            {
                this.yPos -= ((this.yPos - super.yTarget) + this.speed) * this.deltaTime; 
            }
            else // mouse is above the current position
            {
                this.yPos += ((super.yTarget - this.yPos) + this.speed) * this.deltaTime; 
            }
        }
    }

    @Override
    public final void moveKeys()
    {
        if (Greenfoot.isKeyDown(KeyUp))
        {
            moveUp();
        }
        else if (Greenfoot.isKeyDown(KeyDown))
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
