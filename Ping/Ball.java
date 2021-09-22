import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Ball extends Mover
{
    private static final int BALL_SIZE = 25;
    
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    public boolean hasBounced;
    private int ballReset;
    private int dieConditionOne = 5;
    private int dieConditionTwo = GameWorld.WORLD_WIDTH - 5;
    private int xPos = GameWorld.WORLD_WIDTH/2;
    private int yPos = GameWorld.WORLD_HEIGHT/2;
    
    protected Effects glowEffect = new BallGlow();

    
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
        getPosition();
        checkForDeath();
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
            
            Sound.playRandomHit();
        
        }
    }
    
    private void getPosition()
    {
        xPos = getX();
        yPos = getY();
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
                Sound.playRandomPingPong();
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
    
    public void addGlow()
    {
        getWorld().addObject(glowEffect, xPos, yPos);
    }
    
    private void checkForDeath()
    {
        if( getX() <= dieConditionOne || getX() >= dieConditionTwo)
        {
            getWorld().removeObject(glowEffect);
            getWorld().removeObject(this);
        }
    }
}
