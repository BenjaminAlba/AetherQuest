import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HTPMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HTPMenu extends World
{

    /**
     * Constructor for objects of class HTPMenu.
     * 
     */
    public HTPMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        setBackground("images/menu/background.png");
        addObject(new Image("images/menu_help_howtoplay/menu_help_howtoplay_01.png"),640,360);
        addObject(new ReturnButton(1),640,360);
    }
}
