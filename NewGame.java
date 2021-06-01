import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGame extends Button
{
    private GreenfootImage state0 = new GreenfootImage("images/menu/empty.png");
    private GreenfootImage state1 = new GreenfootImage("images/menu/button_menu_ng.png");
    private boolean mouseClicked = false;
    /**
     * Act - do whatever the NewGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mouseClicked = checkMouse(state0,state1,955,340,325,120);
        if(mouseClicked == true)
            checkClick(new Room(1,640,360));
    }    
}
