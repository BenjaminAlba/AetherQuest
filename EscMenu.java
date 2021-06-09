import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EscMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EscMenu extends World
{
    private String currentRoom;
    private int characterX;
    private int characterY;
    private Image portrait1;
    private Image portrait2;
    private Image portrait3;
    private Image portrait4;
    private Party party = Party.getInstance();
    public EscMenu(String currentRoom, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("images/ESC_menu/esc_menu_background.png");
        portrait1 = new Image("images/character_portraits/0"+party.getMember1().getId()+".gif");
        portrait1.scale(-250,-250);
        portrait2 = new Image("images/character_portraits/0"+party.getMember2().getId()+".gif");
        portrait2.scale(-250,-250);
        portrait3 = new Image("images/character_portraits/0"+party.getMember3().getId()+".gif");
        portrait3.scale(-250,-250);
        portrait4 = new Image("images/character_portraits/0"+party.getMember4().getId()+".gif");
        portrait4.scale(-250,-250);
        addObject(portrait1,815,235);
        addObject(portrait2,1065,235);
        addObject(portrait3,815,485);
        addObject(portrait4,1065,485);
        addObject(new EscShopButton(currentRoom,characterX,characterY),341,360);
        addObject(new EscCharacterButton(currentRoom,characterX,characterY),940, 360);
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
    }

    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new PrologueRoom(currentRoom,characterX, characterY));
        }
    }
}
