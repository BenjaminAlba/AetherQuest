import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EscCharacterButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EscCharacterButton extends Button
{
    private boolean mouseOver = false;
    private GreenfootImage state0 = new GreenfootImage("images/ESC_menu/button_esc_menu_characters01.png");
    private GreenfootImage state1 = new GreenfootImage("images/ESC_menu/button_esc_menu_characters02.png");
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private String currentRoom;
    private int characterX;
    private int characterY;
    public EscCharacterButton(String currentRoom, int characterX,int characterY){
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
    }

    public void act() 
    {
        changeState();   
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new CharacterSkillMenu(currentRoom,characterX,characterY));
            buttonClick.play();
        }
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
