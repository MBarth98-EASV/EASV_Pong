import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AIPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIPaddle extends Paddle

{
    private boolean isHit = false;
    
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
                if (ball.getY() < this.getY())
                {
                    super.moveUp();
                }
                else
                {
                    super.moveDown();
                }
            }
            else
            {
                if( isHit == true)
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
