import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public AIPaddle(SCREEN_POSITION position)
    {
        super(position, false, WIDTH, HEIGHT);
    }
    
    public AIPaddle()
    {
        this(SCREEN_POSITION.RIGHT);
    }

    @Override
    public final void moveToMouse()
    {
        return;
    }
    
    @Override
    public final void moveKeys()
    {
        java.util.List<Ball> balls = getWorld().getObjects(Ball.class);
        
        for (Actor ball : balls)
        {   
            selectTarget(ball);
            
            if (isHit == false)
            {
                movePaddleToCoord(ball.getX(), ball.getY());
            }
            else
            {
                movePaddleToCenter();
            }
            
        }
    }
    
    private void selectTarget(Actor ball)
    {
        int distance = Math.abs(this.getX() - ball.getX()); 
            
        if (distance > GameWorld.WORLD_HEIGHT / 4 * 3 )
        {
            isHit = false;
        }
            
        if (isTouchingBall == true)
        {
            isHit = true;
        }
    }
    
    private void movePaddleToCoord(double x, double y)
    {
      if (y < this.getY())
      {
         super.moveUp();
      }
      else
      {
          super.moveDown();
      }
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
