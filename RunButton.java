import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RunButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage state0 = new GreenfootImage("images/battle_resources/run-icon.png");
    private GreenfootImage state1 = new GreenfootImage("images/battle_resources/run-icon-hover.png");
    private boolean mouseOver = false;
    
    public RunButton(){
        setImage(state0);
    }
    
    public void changeState(){
        if(Greenfoot.mouseMoved(null))
            mouseOver = Greenfoot.mouseMoved(this);

        if(mouseOver)
            setImage(state1);
        else
            setImage(state0);
    }
    
    public void act()
    {
        changeState();
    }
}
