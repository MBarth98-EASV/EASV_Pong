import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Ball extends Mover
{
    private static final int BALL_SIZE = 25;
    private boolean isTouchingEdge = false; //Check if touching the walls again.
    
    public Ball()
    {
        increaseSpeed(new Vector(25, 5)); //Increase speed of vector
        createImage();
    }
    
    public void act()
    {
        edgeBounce();
        move();
    }
    
    private void edgeBounce()
    {
        if(isAtEdge())
        {
            if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            motion.setX((motion.getX() * -1));
            if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            motion.setY((motion.getY() * -1));
        }
    }
    
        private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    }
}
