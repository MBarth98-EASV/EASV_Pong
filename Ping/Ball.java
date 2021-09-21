import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Ball extends Mover
{
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    
    public Ball()
    {
        increaseSpeed(new Vector(25, 5)); //Increase speed of vector
    }
    
    public void act()
    {
        edgeBounce();
        move();
    }
    
    private void edgeBounce()
    {
        if(isAtEdge())
        {
            if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            motion.setX((motion.getX() * -1));
            if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            motion.setY((motion.getY() * -1));
        }
    }
}
