import greenfoot.*;
/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound
{
    private boolean wallHit = false;
    private boolean ping1 = false;
    
    private static final String[] pongSounds = new String[] 
    {
        "ping1.wav", 
        "ping2.wav"
    };
    
    private static final String[] hitSounds = new String[] 
    {
        "ballwallhit1.wav",
        "ballwallhit2.wav"
    }; 
    
    private static final GreenfootSound boomSound = new GreenfootSound("ballboom.wav");
    
    public static final void playRandomPingPong()
    {
        int index = Greenfoot.getRandomNumber(pongSounds.length);
        
        Greenfoot.playSound(pongSounds[index]);
    }
    
    public static final void playRandomHit()
    {
        int index = Greenfoot.getRandomNumber(hitSounds.length);
        
        Greenfoot.playSound(hitSounds[index]);
    }
    
    public static final void playBallBoom()
    {
        boomSound.play();
    }

    public void playPingPong()
    {   
        if (ping1 == false)
        {
            Greenfoot.playSound("ping1.wav");
            ping1 = true;
        }
        else // if (ping1 = true)
        {
            Greenfoot.playSound("ping2.wav");
            ping1 = false;
        }
    }
    
    public void playWallHit()
    {
        if (wallHit == false)
        {
            Greenfoot.playSound("ballwallhit1.wav");
            wallHit = true;
        }
        else //if (wallHit = true)
        {
            Greenfoot.playSound("ballwallhit2.wav");
            wallHit = false;
        }
    }
}
