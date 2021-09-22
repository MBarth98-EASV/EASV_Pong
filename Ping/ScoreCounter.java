import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class scoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
    GreenfootImage image;
    int imageWidth;
    int imageHeight;
    Font font  = new Font("Consolas", 40);
    
    
    public ScoreCounter()
    {
        imageWidth = 1000;
        imageHeight = 100;
        image = new GreenfootImage(imageWidth , imageHeight);
        
        resetScore();
    }
    
    public void act()
    {
        drawScore();
        if (Greenfoot.isKeyDown("g"))
        {
            Greenfoot.setWorld(new GameOverWorld());
        }
    }
    
    /*
     * Draws the score to the screen
     */
    public void drawScore()
    {
        String scoreString = String.valueOf(ScoreKeeper.playerScore);
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(font);
        image.drawString(scoreString,imageWidth/2, imageHeight/3);
        setImage(image);
    }
    
    public void resetScore()
    {
        ScoreKeeper.playerScore = 0;
    }
    
    
    
}
