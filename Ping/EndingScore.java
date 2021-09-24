import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AIPaddle here.
 * 
 * @author philip esmaeel zadeh
 * @author victor gugerel
 * @author mads rahr mandahl-barth
 * @author mikkel theut meier
 * @author rasmus scherning sandbæk   
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
        
    }
    
    public void drawFinalScore()
    {
        int imageWidth = 360;
        int imageHeight = 100;
        GreenfootImage image = new GreenfootImage(imageWidth , imageHeight);
        
        if (GameOverWorld.multiPlayerFinish == false)
        {
            String scoreString = String.valueOf(ScoreKeeper.playerScore);
            Font font  = new Font("Consolas", 20);
       
            image.clear();
            image.setColor(Color.WHITE);
            image.setFont(font);
            image.drawString(scoreString, imageWidth/2-4, image.getHeight()/2);
            setImage(image);
        }
        
        else if  (MultiGameOverWorld.multiPlayerFinish == true && ScoreKeeper.playerScore > ScoreKeeper.multiPlayerScore)
        {
            
            String scoreString = String.valueOf(ScoreKeeper.playerScore);
            Font font  = new Font("Consolas", 20);
       
            image.clear();
            image.setColor(Color.WHITE);
            image.setFont(font);
            image.drawString(scoreString, imageWidth/2-4, image.getHeight()/2);
            setImage(image);
        }
       
        else if (MultiGameOverWorld.multiPlayerFinish == true && ScoreKeeper.playerScore < ScoreKeeper.multiPlayerScore)
        {
            
            String scoreString = String.valueOf(ScoreKeeper.multiPlayerScore);
            Font font  = new Font("Consolas", 20);
            
            image.clear();
            image.setColor(Color.WHITE);
            image.setFont(font);
            image.drawString(scoreString, imageWidth/2-4, image.getHeight()/2);
            setImage(image);
        }
        
    }
    
    
}
