import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YesButtonSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YesButtonSelect extends Button
{
    private boolean mouseOver = false;
    private GreenfootImage state0 = new GreenfootImage("images/yn_menu/y_button.png");
    private GreenfootImage state1 = new GreenfootImage("images/yn_menu/y_button_hover.png");
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private int id;

    public YesButtonSelect(int id)
    {
        this.id=id;
    }

    public void act() 
    {
        changeState();   
        if(Greenfoot.mousePressed(this)){
            buttonClick.play();
            World world = getWorld();
            PrologueRoom room = (PrologueRoom)world;
            room.setProtagonist(id);
            
            
            getWorld().removeObjects(getWorld().getObjects(NoPromptButton.class));
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
