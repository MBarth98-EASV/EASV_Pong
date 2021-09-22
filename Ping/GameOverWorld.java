import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends GameWorld
{
     
    @Override
    public void ResetBackground() {}


    private long lastAdded = System.currentTimeMillis();
    GreenfootSound gameOverSound = new GreenfootSound("gameover.wav");
    GreenfootImage gameoverBG = new GreenfootImage("gameoverbg.png");
    private boolean textDrawn;
    public GameOverWorld()
    {
        super(); 
        setPaintOrder(Overlay.class, EndingScore.class);
        
        endScore();
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2); //Adds and overlay than covers every object on screen.
        
        
        
        setBackground(gameoverBG);
        gameOverSound.play();
    }
   
    
    public void act()
    {
        flashingContinueText();
    }
    
    private void endScore()
    {
        EndCounterGlow endGlow = new EndCounterGlow();
        if (ScoreKeeper.playerScore <= 9 && ScoreKeeper.playerScore >= 0)
        {
        addObject(new EndingScore(), (getWidth()/2)-2, getHeight()/2+155);
        addObject(endGlow, (getWidth()/2)-1, getHeight()/2+148);
        }
        
        else if (ScoreKeeper.playerScore >= 10 && ScoreKeeper.playerScore < 100)
        {
        addObject(new EndingScore(), (getWidth()/2)-8, getHeight()/2+155);
        addObject(endGlow, (getWidth()/2)-1, getHeight()/2+148);
        }
        
        else if (ScoreKeeper.playerScore >= 100 && ScoreKeeper.playerScore < 1000)
        {
        addObject(new EndingScore(), (getWidth()/2)-14, getHeight()/2+155);
        addObject(endGlow, (getWidth()/2)-1, getHeight()/2+148);
        }
    }
    
    private void drawText()
    {
       // Draws text on top of the current background, and sets it as the background image.
       GreenfootImage image = new GreenfootImage(getBackground());
       Font font  = new Font("Consolas", 20);
       image.setColor(Color.WHITE);
       image.setFont(font);
       image.drawString("Hit <enter> to continue", WORLD_WIDTH / 4 + 45, WORLD_HEIGHT / 2 + 195);
       setBackground(image);
    }
    
    private void flashingContinueText()
    {
        long curTime = System.currentTimeMillis();
        // Measures real-world time and alternates between drawing the text 
        // and setting a background without the text. It will activate every 0,7 seconds.
        FlashingTextGlow flashGlow = new FlashingTextGlow();
        
        
        if (curTime >= lastAdded + 700 && textDrawn == false) //0,7 seconds
        {
        drawText();
        addObject(flashGlow, getWidth()/2-2, 450);
        List<FlashingTextGlow> glow = getObjects(FlashingTextGlow.class);
    
        FlashingTextGlow currentglow = glow.get(0);
        currentglow.getImage().scale(300, 60);
        textDrawn = true;
        lastAdded = curTime;
        }
        else if (curTime >= lastAdded + 700 && textDrawn == true)
        {
        List<FlashingTextGlow> glow = getObjects(FlashingTextGlow.class);
    
        FlashingTextGlow currentglow = glow.get(0);
        
        removeObject(currentglow);
        setBackground(gameoverBG);
        textDrawn = false;
        lastAdded = curTime;
        }
    }
}