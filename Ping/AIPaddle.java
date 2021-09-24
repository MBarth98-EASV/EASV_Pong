import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class AIPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIPaddle extends Paddle
{
    private boolean isHit = false;
    //private int SEARCH_RADIUS = GameWorld.WORLD_WIDTH / 4 * 3;
    private int SPEED = 8;
    
    public AIPaddle(SCREEN_POSITION position)
    {
        super(position, false, HEIGHT, WIDTH);
    }
    
    public AIPaddle()
    {
        this(SCREEN_POSITION.RIGHT);
    }

    @Override
    public final void moveToMouse()
    {
        List<Ball> Balls = getWorld().getObjects(Ball.class);
        
        for(Ball ball : Balls)
        {
            int distanceToBall = Math.abs(this.getX() - ball.getX());
        
            if (distanceToBall > GameWorld.WORLD_HEIGHT/4 * 3 )
            {
                isHit = false;
            } 
            
            if (isTouchingBall == true)
            {
                isHit = true;
            }

            if (!isHit)
            {
                 moveToTarget(ball.getX(), ball.getY());
            }
            else
            {
                moveToHome();
            }
        }
        
        return;
    }
    
    @Override
    public final void moveKeys()
    {
        java.util.List<Ball> balls = getWorld().getObjects(Ball.class);
        
        for (Actor ball : balls)
        {   
            int dist = Math.abs(getX() - ball.getX()); 
            
            if (dist > GameWorld.WORLD_HEIGHT/4 * 3 )
            {
                isHit = false;
            }
            
            if (isTouchingBall == true)
            {
                isHit = true;
            }
            
            if ( isHit == false)
            {
                moveToTarget(ball.getX(), ball.getY());
            }
            else
            {
                if( isHit == true)
                {
                   moveToHome();
                }
            }
            
        }
    }
    
    private void moveToTarget(double x, double y)
    {

            super.xTarget = x;
            super.yTarget = y;  
            
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
    
    private void moveToHome()
    {
        if ( getY() < GameWorld.WORLD_HEIGHT/2 )
        {
            super.moveDown();
        }
        else
        {   
            if ( getY() > GameWorld.WORLD_HEIGHT/2 )
            {
                super.moveUp();
            }
        }
    }
    
    
    /**
     * Act - do whatever the AIPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
