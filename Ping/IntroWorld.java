import greenfoot.*;
import java.util.List;

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
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2); //Adds and overlay than covers every object on screen.
        
        
        // Adds two AI paddles and a ball.
        Paddle player1AI = new AIPaddle(Paddle.SCREEN_POSITION.LEFT);
        Paddle player2AI = new AIPaddle(Paddle.SCREEN_POSITION.RIGHT);
        Ball ball = new Ball();
        
        addObject(player1AI, (int)player1AI.xPos, (int)player1AI.yPos);
        addObject(player2AI, (int)player2AI.xPos, (int)player2AI.yPos);
        addObject(ball, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        // Adds the glow effect that sits behind the objects and overlay.
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
            bgmusic.stop(); //stops the music when entering a new world.
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
    private void drawText()
    {
       // Draws text on top of the current background, and sets it as the background image.
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
        FlashingTextGlow flashGlow = new FlashingTextGlow();
        if (curTime >= lastAdded + 700 && textDrawn == false) //0,7 seconds
        {
        drawText();
        addObject(flashGlow, 350, 357);
        textDrawn = true;
        lastAdded = curTime;
        }
        else if (curTime >= lastAdded + 700 && textDrawn == true)
        {
        List<FlashingTextGlow> glow = getObjects(FlashingTextGlow.class);
    
        FlashingTextGlow currentglow = glow.get(0);
        
        removeObject(currentglow);
        setBackground(background);
        textDrawn = false;
        lastAdded = curTime;
        }
    }

    private void backgroundMusic()
    {   
        bgmusic.setVolume(50);
        
        long curTimeTwo = System.currentTimeMillis();
        // Measures real-world time and plays music when the world is initiated. 
        // The music will repeat after it's done playing, which is 21500 milliSeconds, or 21,5 seconds.
        // curTimeTwo is the measured realworld time, and lastPlayed is .
        
        if (curTimeTwo >= lastPlayed + 21500 || curTimeTwo >= 100 ) //21,5 seconds or 0.1 seconds after the world is started.
        {
        bgmusic.play();
        lastPlayed = curTimeTwo; //lastPlayed is set to the value of curTimeTwo, meaning another 21.5 seconds will pass before
        // the code will be run again.
        }
        
    }  
}

