import greenfoot.*;
/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound  extends Actor
{
    // instance variables - replace the example below with your own
    private int x;
    private boolean ping1 = false;
    /**
     * Constructor for objects of class Sound
     */
    public Sound()
    {
    }

    public void playWallHit()
    {
        Greenfoot.playSound("ballwallhit.wav");
    }
    
    public void playPingPong()
    {   
        if (ping1 = false)
        {
        Greenfoot.playSound("ping1.wav");
        ping1 = true;
        }
        else if (ping1 = true)
        Greenfoot.playSound("ping2.wav");
        ping1 = false;
    }
}
