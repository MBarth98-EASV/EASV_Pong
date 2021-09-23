import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class BallGlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGlow extends Effects
{
    public static int BallGlowX = 0;
    public static int BallGlowY = 0;
    
    
    public BallGlow()
    {
        GreenfootImage ballglow = new GreenfootImage("ballglow.png");
        setImage(ballglow);
    }
    
    public void act()
    {
        returnBallXY();
    }
    
    public void returnBallXY()
    {
        List<Ball> objects = getWorld().getObjects(Ball.class);
    
        Ball currentBall = objects.get(0);
        int ballX = currentBall.motion.getBallX();
        int ballY = currentBall.motion.getBallY();
        setLocation(ballX, ballY);
    }
 
    }

    

