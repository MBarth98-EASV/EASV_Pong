import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends GameWorld
{
     
    @Override
    public void ResetBackground() {}

    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    
    GreenfootSound gameOverSound = new GreenfootSound("gameover.wav");
    public GameOverWorld()
    {
        super(); 
        setPaintOrder(Overlay.class, EndingScore.class);
        
        endScore();
        addObject(new Overlay(), WORLD_WIDTH/2, WORLD_HEIGHT/2); //Adds and overlay than covers every object on screen.
        
        
        GreenfootImage gameoverBG = new GreenfootImage("gameoverbg.png");
        setBackground(gameoverBG);
        gameOverSound.play();
    }
    
    private void endScore()
    {
        if (ScoreKeeper.playerScore <= 9 && ScoreKeeper.playerScore >= 0)
        {
        addObject(new EndingScore(), (getWidth()/2)-1, getHeight()/2+150);
        }
        
        else if (ScoreKeeper.playerScore >= 10 && ScoreKeeper.playerScore < 100)
        {
        addObject(new EndingScore(), (getWidth()/2)-8, getHeight()/2+150);
        }
        
        else if (ScoreKeeper.playerScore >= 100 && ScoreKeeper.playerScore < 1000)
        {
        addObject(new EndingScore(), (getWidth()/2)-14, getHeight()/2+150);
        }
    }
}
