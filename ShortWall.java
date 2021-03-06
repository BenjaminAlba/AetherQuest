import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShortWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShortWall extends Wall
{
    public static final int RIGHT = 0;
    private GreenfootImage shortWall;
    
    public ShortWall(int orientation, String floor)
    {
        shortWall = new GreenfootImage("images/" + floor + "_rf/shortwall.png");
        if(orientation==RIGHT)
        {
            shortWall.mirrorHorizontally();
        }
        setImage(shortWall);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
