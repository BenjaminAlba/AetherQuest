import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSkillMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSkillMenu extends World
{
    Party party = Party.getInstance();
    private String currentRoom;
    private int characterX;
    private int characterY;
    public CharacterSkillMenu(String currentRoom, int characterX,int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("images/ESC_menu/esc_menu_background.png");
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
        addObject(new Image("images/ESC_menu_characters/0"+party.getMember1().getId()+".png"),640,128);
        addObject(new Image("images/ESC_menu_characters/0"+party.getMember2().getId()+".png"),640,282);
        addObject(new Image("images/ESC_menu_characters/0"+party.getMember3().getId()+".png"),640,436);
        addObject(new Image("images/ESC_menu_characters/0"+party.getMember4().getId()+".png"),640,590);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new EscMenu(currentRoom,characterX, characterY));
        }
    }
}
