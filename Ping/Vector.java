/**
 * A 2D vector.
 * 
 */
public class Vector
{
    private double deltaX = 0;
    private double deltaY = 0;
    
    double direction = 0;
    double length;
    
    int x = 0;
    int y = 0;
    
    public Vector() {}

    public Vector(double direction, double length)
    {
       this.length = length;
       
       setDirection(direction);  
    }

    /**
     * Set the direction of this vector.
     */
    public void setDirection(double direction) 
    {
        this.direction = direction;
        this.deltaX = this.length * Math.cos(Math.toRadians(direction));
        this.deltaY = this.length * Math.sin(Math.toRadians(direction));   
    }
   
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other) 
    {
        deltaX += other.deltaX;
        deltaY += other.deltaY;
        
        double angle = Math.atan2(deltaY, deltaX);
        
        double deltaXSquared = (deltaX * deltaX);
        double deltaYSquared = (deltaY * deltaY);
        
        this.direction = Math.toDegrees(angle);
        this.length = Math.sqrt(deltaXSquared + deltaYSquared);
    }   
    
    /**
     *  Sets new vector X
     */ 
    public void setDeltaX(double dx) 
    {
        deltaX = dx;
    }
    
    /**
     *  Sets new vector Y
     */
    public void setDeltaY(double dy) 
    {
        deltaY = dy;
    }
    
    /**
     *  Return the x offset of this vector.
     */
    public double getDeltaX() 
    {
        return deltaX;
    }
     
    /**
     * Return the y offset of this vector.
     */
    public double getDeltaY() 
    {
        return deltaY;
    }
    
    /**
     * Return the current direction (in degrees).
     */
    public double getDirection() 
    {
        return direction;
    }
    
    /**
     * Return the current length of the vector.
     */
    public double getLength() 
    {
        return length;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector copy() 
    {
        return new Vector(this.direction, this.length);
    }
    
    /**
     *  Inverse of delta x
     */
    public void deflectX()
    {
        this.deltaX *= -1;
    }
    
    /**
     *  Inverse of delta y
     */
    public void deflectY()
    {
        this.deltaY *= -1;
    }
    
    public int setBallX(int newX)
    {
        x = newX;
        return x;
    }
    
    public int setBallY(int newY)
    {
        y = newY;
        return y;
    }
    
    public int getBallX()
    {
        return x;
    }
    
    public int getBallY()
    {
        return y;
    }
}