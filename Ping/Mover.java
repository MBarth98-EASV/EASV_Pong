import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A thing that can move around with a certain speed.
 */
public abstract class Mover extends Actor
{
    public Vector motion = new Vector();
    
    public double x = 0;
    public double y = 0;
    
    public Mover() {}
    
    /**
     * Create new thing initialised with given speed.
     */
    public Mover(Vector speed)
    {
        motion = speed;
    }
    
    /**
     * Move forward one step.
     */
    public void move() 
    {
        this.x += motion.getDeltaX();
        this.y += motion.getDeltaY();
        
        setLocation(x, y);
    }
    
    public void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
        super.setLocation((int)x, (int)y);
    }
    
    public void setLocation(int x, int y) 
    {
        setLocation((double)x, (double)y);
    }

    /**
     * Increase the speed with the given vector.
     */
    public void increaseSpeed(Vector modifier) 
    {
        motion.add(modifier);
    }
    
    /**
     * Return the current movement.
     */
    public Vector getMovement() 
    {
        return motion;
    }
}