import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndingScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndingScore extends Actor
{
    public EndingScore()
    {
        drawFinalScore();
    }
    
    public void act()
    {
        goToIntro();
    }
    
    public void drawFinalScore()
    {
        int imageWidth = 360;
        int imageHeight = 100;
        GreenfootImage image = new GreenfootImage(imageWidth , imageHeight);
        String scoreString = String.valueOf(ScoreKeeper.playerScore);
        Font font  = new Font("Consolas", 20);
       
        
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(font);
        image.drawString(scoreString,imageWidth/2-4, image.getHeight()/2);
        setImage(image);
    }
    
    public void goToIntro()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            
            Greenfoot.setWorld(new IntroWorld());
        }
    }
}
