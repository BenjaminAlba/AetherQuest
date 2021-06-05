import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LongWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LongWall extends Wall
{
    public static final int DOWN = 1;
    private GreenfootImage longWall;
    public LongWall(int orientation)
    {
        longWall = new GreenfootImage("images/prologue_rf/longwall.png");
        if(orientation==DOWN)
        {
            longWall.mirrorVertically();
        }
        setImage(longWall);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
