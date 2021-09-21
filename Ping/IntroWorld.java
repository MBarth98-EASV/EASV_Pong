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
        
        
        setPaintOrder(Overlay.class, Paddle.class, Ball.class);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
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
        
        if (curTime >= lastAdded + 700 && textDrawn == false) 
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
}

