import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersButton extends Button
{
    private GreenfootImage blink = new GreenfootImage("images/menu_help/button_menu_help_01.png");
    private GreenfootImage state0 = new GreenfootImage("images/menu_help/menu_help_01.png");
    private GreenfootImage state1 = new GreenfootImage("images/menu_help/menu_help_01.png");
    private boolean mouseClicked = false;
    public CharactersButton(){
        state1.drawImage(blink,0,0);
        setImage(state0);   
    }

    public void act() 
    {
        mouseClicked = checkMouse(state0, state1, 480, 435, 430, 210);
        if(mouseClicked==true){
            checkClick(new CharacterSelectMenu());
        }    
    }
}
