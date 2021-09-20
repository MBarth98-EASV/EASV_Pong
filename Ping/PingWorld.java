import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        setPaintOrder(Overlay.class, Paddle.class, Ball.class);
        if (gameStarted)
        {
            GreenfootImage background = new GreenfootImage("bg.png");
            setBackground(background);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 50);
            addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }

}
