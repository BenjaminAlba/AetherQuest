import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGameButton extends Button
{
    private GreenfootImage state0 = new GreenfootImage("images/menu/empty.png");
    private GreenfootImage state1 = new GreenfootImage("images/menu/button_menu_ng.png");
    private boolean mouseClicked = false;
    
    public NewGameButton(Observer ... observers){
        super(observers);
    }
    
    public void act() 
    {
        mouseClicked = checkMouse(state0,state1,955,340,325,120);
        if(mouseClicked == true){
            checkClick(new PrologueRoom("01",640,360));
        }
    }    
}
