import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends GameWorld
{

    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {
        setPaintOrder(Overlay.class);
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        
        GreenfootImage gameoverBG = new GreenfootImage("gamoverbg.png");
        setBackground(gameoverBG);
        
    }
}
