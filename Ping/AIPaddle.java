import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class AIPaddle here.
 * 
 * @author philip esmaeel zadeh
 * @author victor gugerel
 * @author mads rahr mandahl-barth
 * @author mikkel theut meier
 * @author rasmus scherning sandbæk   
 * @version (a version number or a date)
 */
public class AIPaddle extends Paddle
{   
    private int SEARCH_RADIUS = GameWorld.WORLD_WIDTH / 4 * 3;
    private boolean isHit = true;
    private int SPEED = 8;

    public AIPaddle(SCREEN_POSITION position)
    {
        super(position, true, WIDTH, HEIGHT);
    }
    
    public AIPaddle()
    {
        this(SCREEN_POSITION.RIGHT);
    }

    @Override
    public final void moveToMouse()
    {
        List<Ball> Balls = getObjectsInRange(SEARCH_RADIUS, Ball.class);
        
        for(Ball ball : Balls)
        {
            int distanceToBall = Math.abs(this.getX() - ball.getX());
            if ( ball.hasBounced == true)
                {
                    isHit = true;
                }
            else if ( distanceToBall > (GameWorld.WORLD_HEIGHT / 4 * 3))
                {
                    isHit = false;
                }
            
            if ( isHit == false)
            {
                searchTarget(ball.getX(), ball.getY());
            }
            else
            {
               movePaddleToCenter();
            }  
        }
    }
    
    private void searchTarget(double X, double Y)
    {
    super.xTarget = X;
    super.yTarget = Y;  
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
    }
    
    private void movePaddleToCenter()
    {
            if (getY() < GameWorld.WORLD_HEIGHT / 2)
            {
                super.moveDown();
            }
            else if (getY() > GameWorld.WORLD_HEIGHT / 2)
            {
                super.moveUp();
            }
        // else in center (do nothing)!!!
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
