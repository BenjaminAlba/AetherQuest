import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkillUpgradeMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillUpgradeMenu extends World
{
    Party party = Party.getInstance();
    private String currentRoom;
    private int characterX;
    private int characterY;
    public SkillUpgradeMenu(Character character, String currentRoom, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
        setBackground("images/ESC_menu/esc_menu_background.png");
        addObject(new Image("images/ESC_menu_characters_skills/0"+character.getId()+".png"),640,360);
        
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new CharacterSkillMenu(currentRoom,characterX, characterY));
        }
    }
}
