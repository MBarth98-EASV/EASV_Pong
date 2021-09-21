import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCounterGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounterGlow extends ScoreCounter
{
    public ScoreCounterGlow()
    {
        GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
        setImage(counterGlow);
        counterGlow.scale(35, 50);
        setLocation(70, 50);
    }
    
    public void act()
    {
        scaleImage();
    }
    
    public void scaleImage()
    {
        if (ScoreKeeper.playerScore <= 9)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(35, 50);
            setLocation(60, 50);
            
        }
        else if (ScoreKeeper.playerScore >= 9)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(65, 50);
            setLocation(70, 50);
            
        }
    }
}
