import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AIPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIPaddle extends Paddle
{
    public AIPaddle(SCREEN_POSITION position)
    {
        super(position, HEIGHT, WIDTH);
    }
    
    public AIPaddle()
    {
        this(SCREEN_POSITION.RIGHT);
    }
    
    @Override
    public final void move()
    {
        java.util.List<Ball> balls = getWorld().getObjects(Ball.class);
        
        for (Actor ball : balls)
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
