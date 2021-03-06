import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class SecondFloorRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondFloorRoom extends FloorWorld
{
    public static final int CURRENT_FLOOR = 2;
    private static GreenfootSound music = new GreenfootSound("sounds/Act2OWS.mp3");
    private static int mapIconX = 0;
    private static int mapIconY = 0;
    private String id;
    private String characterId;
    private MovingCharacter protagonist;
    private ShortWall leftWall = new ShortWall(LEFT, "floor2");
    private ShortWall rightWall = new ShortWall(RIGHT, "floor2");
    private LongWall topWall = new LongWall(UP, "floor2");
    private LongWall bottomWall = new LongWall(DOWN, "floor2");
    private Image map = new Image("images/maps/map_floor2.png");
    private Image mapIcon = new Image("images/maps/map_icon.png");
    private Image textBox;
    private GreenfootSound buttonPress;
    private DialogPortrait portrait;
    private DialogHeader header;
    private DialogLine line1;
    private DialogLine line2;
    private DialogLine line3;
    private DialogIcon icon;
    private DialogLocation locationDisplay;
    private Party party = Party.getInstance();
    private YesPromptButton yesButton;
    private YesButtonSelect yesButtonSelect;
    private NoPromptButton noButton;
    /**
     * Constructor for objects of class FirstFloorRoom.
     * 
     */
    public SecondFloorRoom(String id, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        File room = new File("rooms/floor2/"+id+".room");
        characterId="0"+party.getMember1().getId();

        protagonist = new MovingCharacter(characterId);
        setBackground("images/floor2_rf/floor.png");
        addObject(topWall, 640, 60);
        addObject(bottomWall, 640, 660);
        addObject(leftWall, 70, 360);
        addObject(rightWall, 1210, 360);
        textBox = new Image("images/dialog/dialog_box.png");
        icon = new DialogIcon();
        buttonPress = new GreenfootSound("sounds/button_click.mp3");
        this.id = id;
        if (id.equals("01")){
            mapIconX = 0;
            mapIconY = 0;
        }
        buildWorld(room);
        addObject(protagonist, characterX, characterY);
        map.setTransparency(100);
        addObject(map,145,135);
        mapIcon.setTransparency(200);
        addObject(mapIcon,85 + 10 * mapIconX,135 + 10 * mapIconY);
    }

    public void generateBattle(String destination, int x, int y)
    {
        if((Math.floor(Math.random()*(100)+1))<=40){
            music.stop();
            Greenfoot.setWorld(new BattleEnvironment(destination,x,y,CURRENT_FLOOR));
        }
    }
    
    public static void addMapIconX(int number){
        mapIconX+=number;
    }

    public static void addMapIconY(int number){
        mapIconY+=number;
    }

    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new EscMenu(id,CURRENT_FLOOR,protagonist.getX(),protagonist.getY()));
        }
    }

    public static void playMusic(){
        music.playLoop();
    }

    public static void stopMusic(){
        music.stop();
    }
    
    public Door getUpDoor(String linea){
        return new SecondFloorVerticalDoor(UP,linea);
    }
    
    public Door getDownDoor(String linea){
        return new SecondFloorVerticalDoor(DOWN,linea);
    }
    
    public Door getLeftDoor(String linea){
        return new SecondFloorHorizontalDoor(LEFT,linea);
    }
    
    public Door getRightDoor(String linea){
        return new SecondFloorHorizontalDoor(RIGHT,linea);
    }
    
    public TrapDoor getTrapDoor(String linea){
        return new SecondFloorTrapDoor(OPEN);
    }
}
