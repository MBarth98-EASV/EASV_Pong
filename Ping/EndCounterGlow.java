import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndCounterGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndCounterGlow extends Effects
{
     public EndCounterGlow()
    {
        GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
        setImage(counterGlow);
        counterGlow.scale(35, 50);
        
    }
    
    public void act()
    {
        scaleImage();
    }
    
    public void scaleImage()
    {   // Sets the glow effect to be scaled and repositioned depending on how many digits the current score has.
        if (ScoreKeeper.playerScore <= 9)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(25, 25);
            counterGlow.setTransparency(99);
            
            
        }
        else if (ScoreKeeper.playerScore >= 9 && ScoreKeeper.playerScore < 100)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(32, 25);
            counterGlow.setTransparency(99);
            
            
        }
        else if (ScoreKeeper.playerScore >= 99)
        {
            GreenfootImage counterGlow = new GreenfootImage("scorecounter glow.png");
            setImage(counterGlow);
            counterGlow.scale(45, 25);
            counterGlow.setTransparency(99);
            
        } 
    }
}