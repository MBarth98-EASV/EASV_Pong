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
        
        /*
        //add ball with glow effect
        Ball ball = new Ball();
        addObject(ball, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        ball.addGlow();
        */

        //initializeScoreCounters();

        
        addObject(new ScoreCounter(), WORLD_WIDTH / 4, 80);
        addObject(new MultiScoreCounter(), (WORLD_WIDTH / 4) * 3, 80);
    }
    
    public void act()
    {
        
    }
    
    public void initializeScoreCounters()
    {
        
    }
}
