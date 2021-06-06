import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NoPromptButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoPromptButton extends Button
{
    private boolean mouseOver = false;
    private GreenfootImage state0 = new GreenfootImage("images/yn_menu/n_button.png");
    private GreenfootImage state1 = new GreenfootImage("images/yn_menu/n_button_hover.png");
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private int xLocation;
    private int yLocation;
    
    public NoPromptButton(int x, int y)
    {
        xLocation=x;
        yLocation=y;
    }

    public void act() 
    {
        changeState();   
        if(Greenfoot.mousePressed(this)){
            buttonClick.play();
            getWorld().removeObjects(getWorld().getObjects(YesButtonSelect.class));
            getWorld().removeObjects(getWorld().getObjects(YesPromptButton.class));
            World room = getWorld();
            PrologueRoom actualRoom = (PrologueRoom)room;
            actualRoom.addMovingCharacter(xLocation,yLocation);
            removeSelf();
        }
    }  

    public void removeSelf()
    {
        getWorld().removeObject(this);
    }
    
    public void changeState(){
        if(Greenfoot.mouseMoved(null))
            mouseOver = Greenfoot.mouseMoved(this);

        if(mouseOver)
            setImage(state1);
        else
            setImage(state0);
    }  
}
