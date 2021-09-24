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
    private static final int SEARCH_RADIUS = (Math.min(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT) / 8) + BALL_SIZE;
    private static final double SPRED_AMOUT = 9.0;

    public boolean hasBounced;

    private int scoreToSpeedUp = 10;
    private int addedSpeed = 2;
    private int dieConditionOne = 5;
    private int dieConditionTwo = GameWorld.WORLD_WIDTH - 5;
    Random randomNumberGenerator;;
    private double xPos = GameWorld.WORLD_WIDTH / 2;
    private double yPos = GameWorld.WORLD_HEIGHT / 2;
    
    protected Effects glowEffect = new BallGlow();
    
    public Ball()
    {
        increaseSpeed(new Vector(5, 2)); //IInit speed of vector
        createImage();
        hasBounced = false;

        randomNumberGenerator = new Random(java.time.Instant.now().toEpochMilli());
    }
    
    public void act()
    {
        motion.setBallX(getX());
        motion.setBallY(getY());

        collisionTest();
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
    
    private void collisionTest()
    {
        List<Paddle> collisionCandidates = getObjectsInRange(SEARCH_RADIUS, Paddle.class);

        // only loop through the paddles in proximity
        for (Paddle paddle : collisionCandidates)
        {
            if (this.intersects(paddle))
            {
                // only run this once per alternating paddles (if multiple collisions are registered)
                if (hasBounced == false)
                {
                    motion.deflectX();
                    double spred = randomNumberGenerator.nextDouble() * SPRED_AMOUT;

                    if (randomNumberGenerator.nextBoolean())
                    {
                        if (this.getY() > GameWorld.WORLD_HEIGHT / 2)
                        {
                            motion.setDirection(motion.getDirection() + 180 - spred);
                        }
                        else
                        {
                            motion.setDirection(motion.getDirection() + 180 + spred);
                        }
                    }
                    else
                    {
                       motion.setDirection(motion.getDirection() + 180);
                    }
                    

                    Sound.playRandomPingPong();
                
                    if (paddle.getClass() == PlayerPaddle.class)
                    {
                        ScoreKeeper.playerScore++;
                        adjustSpeed();
                    }
                }
                
                hasBounced = true;
            }
            else
            {
                hasBounced = false;
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
            increaseSpeed(new Vector(0, addedSpeed));  
            
            GameLevel.gameLevel ++;
        }
    }
    
    public void addGlow()
    {
        getWorld().addObject(glowEffect, (int)xPos, (int)yPos);
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
