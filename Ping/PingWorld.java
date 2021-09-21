import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 700;
    private static final int WORLD_HEIGHT = (WORLD_WIDTH / 4) * 3;

    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        // Adds Overlay object to world and set the paint order to put it on top.
        setPaintOrder(Overlay.class, Paddle.class, Ball.class);
        if (gameStarted)
        {
            GreenfootImage background = new GreenfootImage("bg90.png");
            setBackground(background);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new PlayerPaddle(), 25, WORLD_HEIGHT/2);
            addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new ScoreCounter(), 50, 80);
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }

}
