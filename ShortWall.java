import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShortWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShortWall extends Wall
{
    
    private GreenfootImage shortWall;
    
    public ShortWall(int orientation)
    {
        shortWall = new GreenfootImage("images/prologue_rf/shortwall.png");
        if(orientation==1)
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
