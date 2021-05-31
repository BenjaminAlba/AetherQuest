import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Continue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Continue extends Button
{
    private GreenfootImage state0 = new GreenfootImage("images/menu/empty.png");
    private GreenfootImage state1 = new GreenfootImage("images/menu/button_menu_continue.png");
    /**
     * Act - do whatever the Continue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouse(state0,state1,955,215,325,120);
    }    
}
