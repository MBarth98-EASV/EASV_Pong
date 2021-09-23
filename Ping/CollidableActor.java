import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColiderCollector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollidableActor extends Actor
{
           
    public static enum CollisionEdge
    {
        NULL,
        
        X_UP,   // right most edge
        X_DOWN, // left most edge
        
        Y_UP,   // top edge
        Y_DOWN  // bottom edge
    }
        
    public class CollisionData
    {
        public Actor target = null;
        public CollisionEdge collisionDirection = CollisionEdge.NULL;
    }
    
    public boolean isTouchingBall;
   
    protected Box collisionMesh;
    
    public CollidableActor()
    {
        isTouchingBall = false ;
        
        collisionMesh = new Box(0, 0, this.getImage().getHeight(), this.getImage().getWidth());
    }
    
    /**
     * Act - do whatever the ColiderCollector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {       
        collisionMesh.update(this.getX(), this.getY());
    }
    
    
    public CollisionData checkCollision(Ball source)
    {
        CollisionData data = new CollisionData();
        
        Box ballCollider = new Box(source.getX(), source.getY(), source.getImage().getHeight(), source.getImage().getWidth());
        
        
        return data;
    }
    
    /**
     * checks if the ball colides with any Collidable actor.
     */
    public void checkCollision()
    {
       Actor Ball = getOneIntersectingObject(Ball.class);
       if (Ball!=null)
       {
           isTouchingBall = true;
       }
       else
       {
           isTouchingBall = false;
       }
    }
}
