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
    private int floor;
    public CharacterSkillMenu(String currentRoom, int floor, int characterX,int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("images/ESC_menu/esc_menu_background.png");
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
        this.floor = floor;
        addObject(new CharacterSkillButton(party.getMember1(),currentRoom,floor,characterX,characterY),640,128);
        addObject(new CharacterSkillButton(party.getMember2(),currentRoom,floor,characterX,characterY),640,282);
        addObject(new CharacterSkillButton(party.getMember3(),currentRoom,floor,characterX,characterY),640,436);
        addObject(new CharacterSkillButton(party.getMember4(),currentRoom,floor,characterX,characterY),640,590);
        
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new EscMenu(currentRoom, floor, characterX, characterY));
        }
    }
}
