import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prologue extends World
{
    private MovingCharacter unknown = new MovingCharacter("00");
    private ShortWall sh1 = new ShortWall(0);
    private ShortWall sh2 = new ShortWall(1);
    private LongWall lh1 = new LongWall(0);
    private LongWall lh2 = new LongWall(1);
    
    public Prologue()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("images/prologue_rf/floor.png");
        addObject(lh1, 640, 60);
        addObject(lh2, 640, 660);
        addObject(sh1, 70, 360);
        addObject(sh2, 1210, 360);
        addObject(unknown, 640, 360);
    }
}