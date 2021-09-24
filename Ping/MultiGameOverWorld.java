import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MultiGameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiGameOverWorld extends GameWorld
{
     private long lastAdded = System.currentTimeMillis();
    GreenfootSound gameOverSound = new GreenfootSound("gameover.wav");
    GreenfootImage multibg = new GreenfootImage("gameovermulti.png");
    private boolean textDrawn;
    public static boolean multiPlayerFinish = true;
    GreenfootImage backgroundWinner = new GreenfootImage("gameovermulti.png");
    GreenfootImage composite = multibg;


    @Override
    public void ResetBackground() {}
    public MultiGameOverWorld()
    {
        super();
        setPaintOrder(Overlay.class, EndingScore.class);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2); //Adds and overlay than covers every object on screen.
        drawWinner();
        


    }

    public void act()
    {
        flashingContinueText();

        goToIntro();
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
            setBackground(composite);
            textDrawn = false;
            lastAdded = curTime;
        }
    }
    public void goToIntro()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {

            Greenfoot.setWorld(new IntroWorld());
        }
    }


    private void drawWinner()
    {
        setBackground(multibg);
        GreenfootImage backgroundWinner = new GreenfootImage(getBackground());
        GreenfootImage composite = multibg;
        
        
        if (ScoreKeeper.playerOneWins == true)
        {
         String winner = "1";
         Font font  = new Font("Consolas", 34);


         composite.drawImage(backgroundWinner, 0, 0);
         composite.setColor(Color.WHITE);
         composite.setFont(font);
         composite.drawString(winner, 360, 286);
         composite.setColor(Color.BLACK);
         setBackground(composite);
        }
        
        else if (ScoreKeeper.playerOneWins == false)
        {
         String winner = "2";
         Font font  = new Font("Consolas", 34);


         composite.drawImage(backgroundWinner, 0, 0);
         composite.setColor(Color.WHITE);
         composite.setFont(font);
         composite.drawString(winner, 360, 286);
         composite.setColor(Color.BLACK);
         setBackground(composite);
        }
    }
}

