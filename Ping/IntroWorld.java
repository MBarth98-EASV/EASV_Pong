import greenfoot.*;

/**
 * Write a description of class IntroWorld here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    
    private static final int WORLD_WIDTH = 700;
    private static final int WORLD_HEIGHT = (WORLD_WIDTH / 4) * 3;
    private static boolean introWorldActive = true;
    private long lastAdded = System.currentTimeMillis();
    private boolean textDrawn;
    
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        GreenfootImage background = new GreenfootImage("introworldbg.png");
        setBackground(background);
        
        
        setPaintOrder(Overlay.class, BallGlow.class, PaddleGlow.class, Paddle.class, Ball.class);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        addObject(new BallGlow(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        // Adds two AI paddles.
        Paddle player1AI = new AIPaddle();
        Paddle player2AI = new AIPaddle();
        
        addObject(player1AI, 25, WORLD_HEIGHT/2);
        addObject(player2AI, WORLD_WIDTH - 25, WORLD_HEIGHT / 2);
        
        player1AI.addGlow();
        player2AI.addGlow();
        
        
    }
    
    public void act()
    {
        flashingText();
        
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            introWorldActive = false;
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
    private void drawText()
    {
        
       GreenfootImage image = new GreenfootImage(getBackground());
       Font font  = new Font("Consolas", 20);
       image.setColor(Color.WHITE);
       image.setFont(font);
       image.drawString("Hit <enter> to start game...", WORLD_WIDTH / 4 + 25, WORLD_HEIGHT / 2 + 100);
       setBackground(image);
    }
    
    private void flashingText()
    {
        long curTime = System.currentTimeMillis();
        // Measures real-world time and alternates between drawing the text 
        // and setting a background without the text. It will activate every 0,7 seconds.
        
        if (curTime >= lastAdded + 700 && textDrawn == false) //0,7 seconds
        {
        drawText();
        textDrawn = true;
        lastAdded = curTime;
        }
        else if (curTime >= lastAdded + 700 && textDrawn == true)
        {
        GreenfootImage background = new GreenfootImage("introworldbg.png");
        setBackground(background);
        textDrawn = false;
        lastAdded = curTime;
        }
}

    private void backgroundMusic()
    {
        GreenfootSound bgmusic = new GreenfootSound("music.wav");
        bgmusic.playLoop();
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
        bgmusic.stop();
        }
    }
}

