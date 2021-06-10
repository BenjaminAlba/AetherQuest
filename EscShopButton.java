import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EscShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EscShopButton extends Button
{
    private boolean mouseOver = false;
    private GreenfootImage state0 = new GreenfootImage("images/ESC_menu/button_esc_menu_itemshop01.png");
    private GreenfootImage state1 = new GreenfootImage("images/ESC_menu/button_esc_menu_itemshop02.png");
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private String currentRoom;
    private int characterX;
    private int characterY;

    public EscShopButton(String currentRoom, int characterX,int characterY){
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
    }

    public void act() 
    {
        changeState();   
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
