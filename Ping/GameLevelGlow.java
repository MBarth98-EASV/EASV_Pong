import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameLevelGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameLevelGlow extends Effects
{
    public GameLevelGlow()
    {
        GreenfootImage levelglow = new GreenfootImage("levelcounter glow.png");
        setImage(levelglow);
    }
    
    /**
     * Act - do whatever the GameLevelGlow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        scaleScoreImage();
    }
    
    private void scaleScoreImage()
    {
        if (GameLevel.gameLevel <= 9)
        {
            GreenfootImage levelglow = new GreenfootImage("levelcounter glow.png");
            levelglow.scale(145, 52);
            levelglow.setTransparency(150);
            setImage(levelglow);
            setLocation(573, 56);
            
        }
        else if (GameLevel.gameLevel >= 10)
        {
            GreenfootImage levelglow = new GreenfootImage("levelcounter glow.png");
            levelglow.scale(165, 52);
            levelglow.setTransparency(150);
            setImage(levelglow);
            setLocation(580, 56);
            
        }
}
}
