import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public class Ball extends Mover
{
    private static final int BALL_SIZE = 25;
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    
    public Ball()
    {
        increaseSpeed(new Vector(5, 2)); //Init speed of vector
        createImage();
    }
    
    public void act()
    {
        motion.setBallY(getY());
        motion.setBallX(getX());
        Colliding();
        edgeBounce();
        move();
    }
    
    private void edgeBounce()
    {
        if(isAtEdge())
        {
            if(getX() < 15 || getX() > getWorld().getWidth() - 15)
            motion.deflectX();
            if(getY() < 15 || getY() > getWorld().getHeight() - 15)
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

    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    }
    
    private void adjustDirectionUp(int F)
    {
        motion.setDirection(motion.getDirection() + F);
    }
}
