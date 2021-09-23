import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;

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
public class Ball extends Mover
{
    
    
    private static final int BALL_SIZE = 25;
    
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    public boolean hasBounced;
    private int xValueResetMin = 300;
    private int xValueResetMax = 400;
    private int scoreToSpeedUp = 10;
    private int addedSpeed = 2;
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
            Position data = collider.checkCollision();
            

            if (collider.isTouchingBall == true && hasBounced == false)
            {
                System.out.println("x: " + data.getX());
                System.out.println("y: " + data.getY());
                hasBounced = true;
                motion.deflectX();
                Sound.playRandomPingPong();
                if (collider.getClass() == PlayerPaddle.class)
                {
                    ScoreKeeper.playerScore++;
                    adjustSpeed();
                }
                
            }
            else
            {
                if(getX() < xValueResetMax && getX() > xValueResetMin)
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
    
    private void adjustSpeed()
    {
        if (ScoreKeeper.playerScore % scoreToSpeedUp == 0 && ScoreKeeper.playerScore != 0){
            increaseSpeed(new Vector(0,addedSpeed));  
            GameLevel.gameLevel ++;
        }
    }
    
    public void addGlow()
    {
        getWorld().addObject(glowEffect, xPos, yPos);
    }
    
    private void checkForDeath()
    {
        if( getX() <= dieConditionOne || getX() >= dieConditionTwo)
        {
            Sound.playBallBoom();
            getWorld().removeObject(glowEffect);
            getWorld().removeObject(this);
            Greenfoot.delay(150);
            Greenfoot.setWorld( new GameOverWorld());
            
        }
    }
}
