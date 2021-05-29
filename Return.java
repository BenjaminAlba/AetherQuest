
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Return here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Return extends Button
{
    private GreenfootImage blink = new GreenfootImage("images/menu_help/button_menu_help_03.png");
    private GreenfootImage state0 = new GreenfootImage("images/menu_help/menu_help_03.png");
    private GreenfootImage state1 = new GreenfootImage("images/menu_help/menu_help_03.png");
    private boolean mouseClicked = false;
    private int menuChange;
    public Return(int menuChange){
        this.menuChange = menuChange;
        state1.drawImage(blink, 0, 0);
        setImage(state0);
    }

    public void act() 
    {
        mouseClicked = checkMouse(state0, state1, 62,613,155,75);

        if(Greenfoot.mousePressed(this) && mouseClicked == true){
            if(menuChange == 0)
                Greenfoot.setWorld(new MainMenu());
            else
                Greenfoot.setWorld(new HelpMenu());
        }
    }
}
