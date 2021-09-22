import greenfoot.*;

/**
 * Write a description of class IntroWorld here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends GameWorld
{
    private long lastAdded = System.currentTimeMillis();
    private long lastPlayed = System.currentTimeMillis();
    private boolean textDrawn;
    GreenfootImage background = new GreenfootImage("introworldbg.png");
    GreenfootSound bgmusic = new GreenfootSound("insertcoin bgmusic.wav");
    
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        super(); 
        
        setBackground(background);
        
        
        setPaintOrder(Overlay.class, BallGlow.class, PaddleGlow.class, Paddle.class, Ball.class);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        
        // Adds two AI paddles and a ball.
        Paddle player1AI = new AIPaddle(Paddle.SCREEN_POSITION.LEFT);
        Paddle player2AI = new AIPaddle(Paddle.SCREEN_POSITION.RIGHT);
        Ball ball = new Ball();
        
        addObject(player1AI, (int)player1AI.xPos, (int)player1AI.yPos);
        addObject(player2AI, (int)player2AI.xPos, (int)player2AI.yPos);
        addObject(ball, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        player1AI.addGlow();
        player2AI.addGlow();
        ball.addGlow();
        
        
    }
    
    public void act()
    {
        flashingText();
        backgroundMusic();
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            bgmusic.stop();
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
    private void drawText()
    {
       GreenfootImage image = new GreenfootImage(getBackground());
       Font font  = new Font("Consolas", 20);
       image.setColor(Color.WHITE);
       image.setFont(font);
       image.drawString("Hit <enter> to start game", WORLD_WIDTH / 4 + 38, WORLD_HEIGHT / 2 + 100);
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
        setBackground(background);
        textDrawn = false;
        lastAdded = curTime;
        }
    }

    private void backgroundMusic()
    {   
        bgmusic.setVolume(50);
        
        long curTimeTwo = System.currentTimeMillis();
        // Measures real-world time and alternates between drawing the text 
        // and setting a background without the text. It will activate every 0,7 seconds.
        
        if (curTimeTwo >= lastPlayed + 21500 || curTimeTwo >= 100 ) //21,5 seconds
        {
        bgmusic.play();
        lastPlayed = curTimeTwo;
        }
        
    }  
}

