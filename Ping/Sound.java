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

    /**
     * Constructor for objects of class Sound
     */
    public Sound()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void playPingPong()
    {
        Greenfoot.playSound("ping1.wav");
    }
}
