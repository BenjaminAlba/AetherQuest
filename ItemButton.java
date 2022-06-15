import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage state0 = new GreenfootImage("images/battle_resources/item-icon.png");
    private GreenfootImage state1 = new GreenfootImage("images/battle_resources/item-icon-hover.png");
    private boolean mouseOver = false;
    
    public ItemButton(){
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
