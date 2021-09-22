/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Box
    {
        public Verticies corners;
        public Sides sides;
        
        private int height  = 0;
        private int width   = 0;
        
        public Box(int x, int y, int width, int height)
        {
            this.width  = width;
            this.height = height;
            
            this.corners = new Verticies();
            this.sides = new Sides();
            
            this.update(x, y);
        }
        
        public void update(int x, int y)
        {
            sides.update(x, y);
            
            corners.update();
        }
        
        public class Sides
        {
            public int left      = 0;
            public int right     = 0;
            public int top       = 0;
            public int bottom    = 0;
            
            public void update(int x, int y)
            {
                this.left    = x - (width / 2);
                this.right   = x + (width / 2);
                this.top     = y - (height / 2);
                this.bottom  = y + (height / 2);
            }
        }
    
        public class Verticies
        {
            public Vertex topLeft       = new Vertex();
            public Vertex bottomLeft    = new Vertex();
            public Vertex topRight      = new Vertex();
            public Vertex bottomRight   = new Vertex();
            
            public void update()
            {
                this.topLeft.set(sides.left, sides.top);
                this.topRight.set(sides.right, sides.top);
                this.bottomLeft.set(sides.left, sides.bottom);
                this.bottomRight.set(sides.right, sides.bottom);
            }
        }
    
        public class Vertex
        {
            public int x;
            public int y;
        
            public Vertex() {}
        
            public Vertex(int x, int y)
            {
                this.set(x, y);
            }
        
            public void set(int x, int y)
            {
                this.x = x;
                this.y = y;
            }
        }
    }
