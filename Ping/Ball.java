import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public class Ball extends Mover
{
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    
    public Ball()
    {
        increaseSpeed(new Vector(5, 2)); //IInit speed of vector
    }
    
    public void act()
    {
        Colliding();
        edgeBounce();
        move();
    }
    
    private void edgeBounce()
    {
        if(isAtEdge())
        {
            if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            motion.deflectX();
            if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            motion.deflectY();
        }
    }
    
    private void Colliding()
    {
        List<CollidableActor> objects = (getWorld().getObjects(CollidableActor.class));
            for (CollidableActor object : objects)
            {
                object.checkCollision();
                if (object.isTouchingBall == true)
                {
                    motion.deflectX();
                }
            }
    }
}
