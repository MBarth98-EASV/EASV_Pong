/**
 * 2D vector.
 * 
 */
public class Vector
{
    double dx = 0;
    double dy = 0;
    double direction = 0;
    double length;
    int x = 0;
    int y = 0;
    
    
    public Vector()
    {
    }

    public Vector(double direction, double length) //Creates a vector
    {
       this.length = length;
       this.direction = direction;
       dx = length * Math.cos(Math.toRadians(direction));
       dy = length * Math.sin(Math.toRadians(direction));    
    }

    public void setDirection(double direction) //Sets direction of this vector
        {
        this.direction = direction;
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
        }
   
    public void add(Vector other) // Add vector to this vector
        {
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
    
    public double getX() //Returns the x offset of this vector
        {
        return dx;
        }
     
    public double getY() //Returns the y offset of this vector
        {
        return dy;
        }
    
    public double getDirection() //returns the curret direction in degrees
        {
        return direction;
        }
    
    public double getLength() //Returns the current length of the vector
        {
        return length;
        }
    
    public Vector copy() //Creates a copy of this vector
        {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
        }
    
    public void deflectX() //Inverses delta X
        {
        setX((getX() * -1));
        }
    
    public void deflectY() //Inverses delta Y
        {
        setY((getY() * -1));
        }
        
    public int getBallX() //Returns X of ball
        {
            return x;
        }
        
    public int getBallY() //Returns Y of ball
        {
            return y;
        }

    public int setBallX(int newX) //Sets the position of the ball
        {
            x = newX;
            return x;
        }
        
    public int setBallY(int newY)
        {
            y = newY;
            return y;
        }
}