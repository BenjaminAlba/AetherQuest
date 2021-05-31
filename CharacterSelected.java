import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelected here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelected extends Button
{
    private final int length = 235;
    private int x, y, id;
    private GreenfootImage state0;
    private GreenfootImage state1;
    private boolean mouseClicked = false;
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    public CharacterSelected(String name, int x, int y, int id){
       this.x = x;
       this.y = y;
       this.id = id;
       state0 = new GreenfootImage("images/menu/empty.png");
       state1 = new GreenfootImage(name);
       setImage(state0);
    }
    
    public void act() 
    {            
        mouseClicked = checkMouse(state0, state1, x, y, length, length);
        if(mouseClicked == true)
        {
            buttonClick.play();
            mouseClicked = false;
            Greenfoot.setWorld(new CharacterInfoMenu(id));
        }
    }    
}
