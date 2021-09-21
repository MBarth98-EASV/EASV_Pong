/**
 * A 2D vector.
 * 
 */
public class Vector
{
    double dx = 0;
    double dy = 0;
    double direction = 0;
    double length;
    
    public Vector()
    {
    }

    public Vector(double direction, double length)
    {
       this.length = length;
       this.direction = direction;
       dx = length * Math.cos(Math.toRadians(direction));
       dy = length * Math.sin(Math.toRadians(direction));    
    }

    /**
     * Set the direction of this vector.
     */
    public void setDirection(double direction) {
        this.direction = direction;
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
    }
   
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other) {
        dx += other.dx;
        dy += other.dy;    
        this.direction = Math.toDegrees(Math.atan2(dy, dx));
        this.length = Math.sqrt(dx*dx+dy*dy);
    }   
    
    public void setX(double newX) //Sets new vector Y
        {
            dx = newX;
        }
    
    public void setY(double newY) //Sets new vector Y
        {
            dy = newY;
        }
    
    /**
     * Return the x offset of this vector.
     */
    public double getX() {
        return dx;
    }
     
    /**
     * Return the y offset of this vector.
     */
    public double getY() {
        return dy;
    }
    
    /**
     * Return the current direction (in degrees).
     */
    public double getDirection() {
        return direction;
    }
    
    /**
     * Return the current length of the vector.
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector copy() {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
    }    
}