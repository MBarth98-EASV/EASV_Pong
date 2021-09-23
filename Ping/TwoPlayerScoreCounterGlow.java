import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TwoPlayerScoreCounterGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoPlayerScoreCounterGlow extends Effects
{   
    
    public static final int WORLD_WIDTH = 700;
    public static final int WORLD_HEIGHT = 500;
    
    public TwoPlayerScoreCounterGlow()
    {
        GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
        setImage(counterGlow);
        counterGlow.setTransparency(150);
        counterGlow.scale(35, 50);
        
    }
    
    public void act()
    {
        scaleImage();
    }
    
    public void scaleImage()
    {   // Sets the glow effect to be scaled and repositioned depending on how many digits the current score has.
        if (ScoreKeeper.multiPlayerScore <= 9)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(35, 50);
            counterGlow.setTransparency(190);
            setLocation((WORLD_WIDTH / 4) * 2 + 185, 50);
            
        }
        else if (ScoreKeeper.multiPlayerScore >= 9 && ScoreKeeper.multiPlayerScore < 100)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(65, 50);
            counterGlow.setTransparency(190);
            setLocation((WORLD_WIDTH / 4) * 2 + 195, 50);
            
        }
        else if (ScoreKeeper.multiPlayerScore >= 99)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(93, 50);
            counterGlow.setTransparency(190);
            setLocation((WORLD_WIDTH / 4) * 2 + 207, 50);
            
        }
    }
}
