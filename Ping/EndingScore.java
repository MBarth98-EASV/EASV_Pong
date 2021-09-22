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
        int imageHeight = 300;
        GreenfootImage image = new GreenfootImage(imageWidth , imageHeight);
        String scoreString = String.valueOf(ScoreKeeper.playerScore);
        Font font  = new Font("Consolas", 40);
        Font font2  = new Font("Consolas", 16);
        
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(font);
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
        image.drawString("Your final score",0, imageHeight/3);
        image.drawString(scoreString,imageWidth/2-20, image.getHeight()/2);
        image.setFont(font2);
        image.drawString("Press <Enter> to continue",image.getWidth()/5, image.getHeight()-30);
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
