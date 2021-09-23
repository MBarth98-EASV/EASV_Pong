/**
 * Write a description of class Position here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Position<T>
{
    private T x;
    private T y;
    
    public Position() {}
    
    public Position(T x, T y) 
    {
         this.setX(x);
         this.setY(y);
    }
    
    public T getX()
    {
        return x;
    }
    
    public T getY()
    {
        return y;
    }
    
    public void setX(T value)
    {
        this.x = value;
    }
    
    public void setY(T value)
    {
        this.y = value;
    }
}
