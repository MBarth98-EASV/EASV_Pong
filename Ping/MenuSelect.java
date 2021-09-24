import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuSelect here.
 * 
 * @author philip esmaeel zadeh
 * @author victor gugerel
 * @author mads rahr mandahl-barth
 * @author mikkel theut meier
 * @author rasmus scherning sandbæk   
 * @version (a version number or a date)
 */
public class MenuSelect extends Actor
{   
    
    public MenuSelect()
    {
        GreenfootImage selectIcon = new GreenfootImage("menuselect.png");
        selectIcon.scale(16, 16);
        setImage(selectIcon);
    }
    /**
     * Act - do whatever the MenuSelect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(290, 348);
            IntroWorld.multiPlayer = false;
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            setLocation(290, 372);
            IntroWorld.multiPlayer = true;
        }
        
    }    
   
}
