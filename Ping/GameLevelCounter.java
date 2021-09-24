import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameLevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameLevelCounter extends Actor
{
    GreenfootImage image;
    int imageWidth;
    int imageHeight;
    Font font  = new Font("Consolas", 25);
    public static int gameLevel = 0;
    
    public GameLevelCounter()
    {
        resetScore();
        imageWidth = 1000;
        imageHeight = 100;
        image = new GreenfootImage(imageWidth , imageHeight);
    }
    
    /**
     * Act - do whatever the GameLevelCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        drawGameLevel();
    }
    
    private void drawGameLevel()
    {
        String scoreString = String.valueOf("level"+":" + gameLevel);
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(font);
        image.drawString(scoreString,imageWidth/2, imageHeight/3);
        setImage(image);
    }
    
    private void resetScore()
    {
        gameLevel = 0;
    }
}
