import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EndingScore extends Actor
{
    public EndingScore()
    {
        drawFinalScore();
    }
    
    public void act()
    {
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
    
    
}
