import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class scoreCounter here.
 * 
 * @author philip esmaeel zadeh
 * @author victor gugerel
 * @author mads rahr mandahl-barth
 * @author mikkel theut meier
 * @author rasmus scherning sandbæk   
 * @version (a version number or a date)
 */
public class MultiScoreCounter extends Actor
{
    private int imageWidth = 1000;
    private int imageHeight = 100;
    private boolean gotGlow;
    private Font font  = new Font("Consolas", 40);
    
    public MultiScoreCounter()
    {
        resetScore();
        gotGlow = false;
    }
    
    public void act()
    {
        drawScore();
    }
    
    public void drawGlow()
    {
        if(!gotGlow)
        {
            getWorld().addObject(new TwoPlayerScoreCounterGlow(), getX(), getY());
            gotGlow=true;
        }
    }
    
    /*
     * Draws the score to the screen
     */
    public void drawScore()
    {
        GreenfootImage image = new GreenfootImage(imageWidth , imageHeight);
        String scoreString = String.valueOf(ScoreKeeper.multiPlayerScore);

        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(font);
        image.drawString(scoreString,imageWidth/2, imageHeight/3);
        setImage(image);
        drawGlow();
    }
        
    public void resetScore()
    {
        if (ScoreKeeper.multiPlayerScore>=7 || MultiplayerWorld.multiPlayerActive == false)
        {
            ScoreKeeper.multiPlayerScore = 0;    
        }
    }
}
