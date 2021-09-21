import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public abstract class Paddle extends CollidableActor
{
    private int width;
    private int height;
    private int speed = 2;
    
    protected PaddleGlow glowEffect = new PaddleGlow();

    public void addGlow()
    {
       getWorld().addObject(this.glowEffect, 0, 0);
    }
    
    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        createImage();
    }

    public final void moveUp()
    {
        if (getY() - (this.height / 2) > 0)
        {
            setLocation(getX(), getY() - speed);
        }
    }
    
    public final void moveDown()
    {
        if (getY() + (this.height / 2) < getWorld().getHeight())
        {
            setLocation(getX(), getY() + speed);
        }
    }
    
    public abstract void move(); 
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        glowEffect.setLocation(this.getX(), this.getY());
        move();
        checkCollision();
    }    


    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.WHITE);
        image.fill();
        setImage(image);
    }
    
    
    

}
