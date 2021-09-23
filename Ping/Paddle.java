import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public abstract class Paddle extends CollidableActor
{
    public static enum SCREEN_POSITION
    {
        LEFT,
        RIGHT
    }
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 100;
    public static final int BASE_OFFSET_X = 25;
    public static final int BASE_OFFSET_Y = PingWorld.WORLD_HEIGHT / 2;
    public static final double BASE_SPEED = 2.0;
   
    protected final boolean isAxisDisabledX = true;
    protected final boolean isAxisDisabledY = false;

    public double xPos;
    public double yPos;
    
    protected double speed;
    protected double xTarget;
    protected double yTarget;
    protected double deltaTime = 1.0;
    protected double beginTime = java.time.Instant.now().toEpochMilli();
    protected Effects glowEffect = new PaddleGlow();
  
    private int width;
    private int height;    
    private boolean isMouseControlled;
    
    public abstract void moveKeys(); 
    public abstract void moveToMouse();
    
    /**
     *  Constructs a new basic paddle
     */
    public Paddle(SCREEN_POSITION position, boolean isMouseControlled, int width, int height)
    {
        this.isMouseControlled = isMouseControlled;
        
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
        
        this.xTarget = this.xPos;
        this.yTarget = this.yPos;
        
        createImage();
    }
    
    public void addGlow()
    {
       getWorld().addObject(this.glowEffect, (int)xPos, (int)yPos);
    }

    public final void moveUp()
    {
        boolean isBelowTopEdge = (getY() - (this.height / 2) > 0);
        
        if (!isAxisDisabledY && isBelowTopEdge)
        {
            this.yPos -= this.speed;
        }
    }
    
    public final void moveDown()
    {
        boolean isAboveBottomEdge = getY() + (this.height / 2) < getWorld().getHeight();
        
        if (!isAxisDisabledY && isAboveBottomEdge)
        {
            this.yPos += this.speed;
        }
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        
        checkCollision();
        
        computeDeltaTime();
    }    

    private void move()
    {
        if (isMouseControlled)
        {
            moveToMouse();
        } 
        else
        {
            moveKeys();
        }
        
        this.setLocation((int)this.xPos, (int)this.yPos);
        glowEffect.setLocation((int)this.xPos, (int)this.yPos);
    }
    
    private void computeDeltaTime()
    {
        deltaTime = java.time.Instant.now().toEpochMilli() -  beginTime;
        
        if (deltaTime > 0)
        {
            deltaTime = 1 / deltaTime;
        }
        
        beginTime = java.time.Instant.now().toEpochMilli();
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
