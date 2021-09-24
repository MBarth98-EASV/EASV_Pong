import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MultiplayerWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiplayerWorld extends GameWorld
{
    @Override
    public void ResetBackground() {}
    public MultiplayerWorld()
    {
        super();
        GreenfootImage background = new GreenfootImage("bg90.png");
        setBackground(background);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        setPaintOrder(Overlay.class, Paddle.class, Ball.class, ScoreCounter.class, ScoreCounterGlow.class, PaddleGlow.class);
        
        Ball ball = new Ball();
        addObject(ball, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        ball.addGlow();
            
        initializePlayers();
        

        
        
    }
    
    private void initializePlayers()
    {
        Paddle playerOne     = new PlayerPaddle(Paddle.SCREEN_POSITION.LEFT, "w", "s");
        Paddle playerTwo     = new PlayerPaddle(Paddle.SCREEN_POSITION.RIGHT, "Up","Down");
            
        addObject(playerOne, (int)playerOne.xPos, (int)playerOne.yPos);
        addObject(playerTwo, (int)playerTwo.xPos, (int)playerTwo.yPos);
            
        playerOne.addGlow();
        playerTwo.addGlow();
        
    }
    
    public void act()
    {
        winCondition();
    }
    
    public void winCondition()
    {
    if (getObjects(Ball.class).get(0).getX() <=5)
        {
        ScoreKeeper.playerOneWins = false;
        Greenfoot.setWorld(new MultiGameOverWorld());
        }
    if (getObjects(Ball.class).get(0).getX() >= getWidth()-5)
        {
        ScoreKeeper.playerOneWins = true;
        Greenfoot.setWorld(new MultiGameOverWorld());
        }
        
    
    }
}
