import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public abstract class Paddle extends CollidableActor
{
    public static final int HEIGHT = 20;
    public static final int WIDTH = 100;
    
    public static final int BASE_OFFSET_X = 25;
    public static final int BASE_OFFSET_Y = PingWorld.WORLD_HEIGHT / 2;
    
    public static enum SCREEN_POSITION
    {
        LEFT,
        RIGHT
    }
    
    public static final double BASE_SPEED = 2.0;
  
    private int width;
    private int height;
    
    private double speed;
    public double xPos;
    public double yPos;
    
    protected Effects glowEffect = new PaddleGlow();

    
        /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(SCREEN_POSITION position, int width, int height)
    {
        this.speed = BASE_SPEED;
        this.width = width;
        this.height = height;
        
        switch (position)
        {
            case LEFT:
            {
                this.xPos = BASE_OFFSET_X;
                this.yPos = BASE_OFFSET_Y;  
            } 
            break;
            
            case RIGHT:
            {
                this.xPos = GameWorld.WORLD_WIDTH - BASE_OFFSET_X;
                this.yPos = BASE_OFFSET_Y; 
            } 
            break;
            
            default:
                break;
        }
        
        createImage();
    }
    
    public void addGlow()
    {
       getWorld().addObject(this.glowEffect, (int)xPos, (int)yPos);
    }

    public final void moveUp()
    {
        if (getY() - (this.height / 2) > 0)
        {
            this.yPos -= this.speed;
            setLocation((int)this.xPos, (int)this.yPos);
        }
    }
    
    public final void moveDown()
    {
        if (getY() + (this.height / 2) < getWorld().getHeight())
        {
            this.yPos += this.speed;
            setLocation((int)this.xPos, (int)this.yPos);
        }
    }
    
    public abstract void move(); 
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        glowEffect.setLocation((int)this.xPos, (int)this.yPos);
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
