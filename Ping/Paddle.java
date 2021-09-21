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
    
    protected double speed;
    
    protected final boolean isAxisDisabledX = true;
    protected final boolean isAxisDisabledY = false;

    
    public double xPos;
    public double yPos;
    public double xTarget;
    public double yTarget;
    
    protected Effects glowEffect = new PaddleGlow();

    protected java.time.Duration deltaTime = java.time.Duration.ZERO;
    protected double deltaTimeMS = 1.0;
    private java.time.Instant  beginTime = java.time.Instant.now();
    
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
    
    public abstract void moveKeys(); 
    
    public abstract void moveToTarget();
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveKeys();
        
        computeNewTarget();
       
        
        if ((xTarget != xPos) || (yTarget != yPos))
        {
            this.setLocation((int)this.xPos, (int)this.yPos);
        }
        
        glowEffect.setLocation((int)this.xPos, (int)this.yPos);
        
        checkCollision();
        
        deltaTime = java.time.Duration.between(beginTime, java.time.Instant.now());
        
        if (deltaTime.toMillis() > 0 == true)
        {
            deltaTimeMS = 1 / deltaTime.toMillis();
        }
        
        beginTime = java.time.Instant.now();
    }    

    
    private void computeNewTarget()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if (mouse != null)
        {
            this.xTarget = mouse.getX();
            this.yTarget = mouse.getY();  
        
            moveToTarget();
        }
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
