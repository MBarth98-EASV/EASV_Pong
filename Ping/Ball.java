import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Ball extends Mover
{
    private static final int BALL_SIZE = 25;
    
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    public boolean hasBounced;
    private int ballReset;
    
    public Ball()
    {
        increaseSpeed(new Vector(5, 2)); //IInit speed of vector
        createImage();
        hasBounced = false;
        ballReset= 350;
    }
    
    public void act()
    {
        motion.setBallX(getX());
        motion.setBallY(getY());
        
        testForCollision();
        edgeBounce();
        move();
        
    }
    
    private void edgeBounce()
    {
        if(isAtEdge())
        {
            if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            {
                motion.deflectX();
            }

            if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            {
                motion.deflectY();
        
            }
        }
    }
    
    private void testForCollision()
    {
        List<CollidableActor> colliders = (getWorld().getObjects(CollidableActor.class));
        
        for (CollidableActor collider : colliders)
        {
            collider.checkCollision();
            
            if (collider.isTouchingBall == true && hasBounced == false)
            {
                hasBounced = true;
                motion.deflectX();
                
                if (collider.getClass() == PlayerPaddle.class)
                {
                    ScoreKeeper.playerScore++;
                }
            }
            else
            {
                if(ballReset == getX())
                {
                    hasBounced = false;
                }
            }
        }
    }

    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE, BALL_SIZE);
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    }
}
