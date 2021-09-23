import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
/**
 * Write a description of class ColiderCollector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollidableActor extends Actor
{
    public static enum NormalEdge
    {
        NULL,
        
        X_UP,   // right most edge
        X_DOWN, // left most edge
        
        Y_UP,   // top edge
        Y_DOWN  // bottom edge
    }
        
    public boolean isTouchingBall;
    protected NormalEdge normal;
   
    protected BoxCollider collisionMesh;
    
    public CollidableActor()
    {
        isTouchingBall = false ;
        
        collisionMesh = new BoxCollider(0, 0, this.getImage().getHeight(), this.getImage().getWidth());
    }
    
    /**
     * Act - do whatever the ColiderCollector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {       
        this.calcNormal();
        collisionMesh.update(this.getX(), this.getY());
    }
    
    private void calcNormal()
    {
        if (this.getX() < (GameWorld.WORLD_WIDTH / 2))
        {
            this.normal = NormalEdge.X_UP;
        }
        else
        {
            this.normal = NormalEdge.X_DOWN;
        }
    }
    
    public Position checkCollision(Ball source)
    {        
        BoxCollider ballCollider = new BoxCollider(source.getX(), source.getY(), source.getImage().getHeight(), source.getImage().getWidth());
        
        boolean inVerticalRange = (collisionMesh.sides.top < ballCollider.sides.top) && (ballCollider.sides.top < collisionMesh.sides.bottom);
        

        
        if (inVerticalRange) // a collision is possible
        {
            boolean collideOnLeft   = (normal == NormalEdge.X_UP && (collisionMesh.sides.right < ballCollider.sides.left));
            boolean collideOnRight  = (normal == NormalEdge.X_DOWN && (collisionMesh.sides.left < ballCollider.sides.right));

            
            if (collideOnLeft || collideOnRight) 
            {   
                this.isTouchingBall = true;
            }
            else
            {
                this.isTouchingBall = false;
            }
        }
        
        return new Position(this.getX(), this.getY());
    }
    
    /**
     * checks if the ball colides with any Collidable actor.
     */
    public Position checkCollision()
    {
       Actor ball = getOneIntersectingObject(Ball.class);

       if (ball != null)
       {
           isTouchingBall = true;
       }
       else
       {
           isTouchingBall = false;
       }
       
       return new Position(this.getX(), this.getY());
    }
}
