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
        tryChangeDirection();
        move();
    }    

    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void tryChangeDirection()
    {
        /**
         
         
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
        if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0)
        {
            //Change our 'x' direction to the inverted direction:
            dx = dx * -1;
        }
        
        */
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage("paddlewithglow.png");
        setImage(image);
    }
    
    
    

}
