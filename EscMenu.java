import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EscMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EscMenu extends World
{
    private int currentRoom;
    private int characterX;
    private int characterY;
    public EscMenu(int currentRoom, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("images/ESC_menu/esc_menu_background.png");
        addObject(new EscShopButton(),341,360);
        addObject(new EscCharacterButton(),940, 360);
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
    }

    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Room(currentRoom,characterX, characterY));
        }
    }
}
