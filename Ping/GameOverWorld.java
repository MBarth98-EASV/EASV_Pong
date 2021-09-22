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
        addObject(new EndingScore(), getWidth()/2, getHeight()/3);
    }
    
    
}
