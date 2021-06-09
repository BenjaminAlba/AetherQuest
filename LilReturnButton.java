import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LilReturn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LilReturnButton extends Button
{
    private GreenfootImage blink = new GreenfootImage("images/menu_help_characters/button_return_small_01.png");
    private GreenfootImage state0 = new GreenfootImage("images/menu_help_characters/return_small_01.png");
    private GreenfootImage state1 = new GreenfootImage("images/menu_help_characters/return_small_01.png");
    private boolean mouseClicked = false;
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private int menuChange;
    public LilReturnButton(int menuChange){
        this.menuChange = menuChange;
        state1.drawImage(blink, 0, 0);
        setImage(state0);
    }

    public void act() 
    {
        mouseClicked = checkMouse(state0, state1, 62,613,155,75);

        if(Greenfoot.mousePressed(this) && mouseClicked == true){
            buttonClick.play();
            if(menuChange == 0)
                Greenfoot.setWorld(new HelpMenu());
            else
                Greenfoot.setWorld(new CharacterSelectMenu());
        }
    }    
}
