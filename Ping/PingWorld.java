import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends GameWorld
{
    
     
    @Override
    public void ResetBackground()
    {
       setBackground(new GreenfootImage("bg90.png"));
    }
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(); 
        
        // Adds Overlay object to world and set the paint order to put it on top.
        setPaintOrder(Overlay.class, Paddle.class, Ball.class, ScoreCounter.class, ScoreCounterGlow.class, PaddleGlow.class);
        
        if (gameStarted)
        {
            GreenfootImage background = new GreenfootImage("bg90.png");
            setBackground(background);
            
            //add ball with glow effect
            Ball ball = new Ball();
            addObject(ball, WORLD_WIDTH/2, WORLD_HEIGHT/2);
            ball.addGlow();
            
            
            initializePlayers();
            
            addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            
            addObject(new ScoreCounter(), WORLD_WIDTH / 4, 80);
            addObject(new ScoreCounterGlow(),WORLD_WIDTH / 4, 80);
            
            addObject(new GameLevelCounter(),(WORLD_WIDTH/4)*3, 80);
            addObject(new GameLevelGlow(), 573, 54);
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }
    
    private void initializePlayers()
    {
        Paddle playerHuman  = new PlayerPaddle();
        Paddle playerAI     = new AIPaddle();
            
        addObject(playerHuman, (int)playerHuman.xPos, (int)playerHuman.yPos);
        addObject(playerAI, (int)playerAI.xPos, (int)playerAI.yPos);
            
        playerHuman.addGlow();
        playerAI.addGlow();
    }
}
