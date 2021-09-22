import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends GameWorld
{
    public GameOverWorld()
    {
        super(); 
        setPaintOrder(Overlay.class, EndingScore.class);
        
        addObject(new EndingScore(), getWidth()/2, getHeight()/3);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2); //Adds and overlay than covers every object on screen.
        
        
        GreenfootImage gameoverBG = new GreenfootImage("gameoverbg.png");
        setBackground(gameoverBG);
        
    }
    
    
}
