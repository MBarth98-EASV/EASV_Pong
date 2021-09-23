/**
 * Write a description of class Position here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Position
{
    private double x;
    private double y;
    
    public Position() {}
    
    public Position(double x, double y) 
    {
         this.setX(x);
         this.setY(y);
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public void setX(double value)
    {
        this.x = value;
    }
    
    public void setY(double value)
    {
        this.y = value;
    }
}
