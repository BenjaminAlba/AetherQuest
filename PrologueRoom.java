import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueRoom extends World 
{
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
    public static final int UP = 0;
    public static final int DOWN = 1;
    private static int mapIconX = 0;
    private static int mapIconY = 0;
    private String id;
    private int upDoorY = 70;
    private int downDoorY = 650;
    private int verticalDoorX = 640;
    private int leftDoorX = 90;
    private int rightDoorX = 1190;
    private int horizontalDoorY = 360;
    private String characterId = "00";
    private MovingCharacter unknown;
    private ShortWall sh1 = new ShortWall(LEFT);
    private ShortWall sh2 = new ShortWall(RIGHT);
    private LongWall lh1 = new LongWall(UP);
    private LongWall lh2 = new LongWall(DOWN);
    private Image map = new Image("images/maps/map_prologue.png");
    private Image mapIcon = new Image("images/maps/map_icon.png");
    private Image textBox;
    private GreenfootSound prologueIntro;
    private GreenfootSound openSfx;
    private GreenfootSound staticSfx;
    private GreenfootSound buttonPress;
    private DialogPortrait portrait;
    private DialogHeader header;
    private DialogLine line1;
    private DialogLine line2;
    private DialogLine line3;
    private DialogIcon icon;
    private DialogLocation locationDisplay;
    private Party party = Party.getInstance();
    
    public PrologueRoom(String id, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        File room = new File("rooms/prologue/"+id+".room");
        unknown = new MovingCharacter(characterId);
        setBackground("images/prologue_rf/floor.png");
        addObject(lh1, 640, 60);
        addObject(lh2, 640, 660);
        addObject(sh1, 70, 360);
        addObject(sh2, 1210, 360);
        textBox = new Image("images/dialog/dialog_box.png");
        icon = new DialogIcon();
        prologueIntro = new GreenfootSound("sounds/chapterStart.mp3");
        buttonPress = new GreenfootSound("sounds/button_click.mp3");
        openSfx = new GreenfootSound("sounds/open_sfx.mp3");
        staticSfx = new GreenfootSound("sounds/static_sfx.mp3");
        this.id = id;
        if(id.equals("01")){
            PrologueRoom.mapIconX = 0;
            PrologueRoom.mapIconY = 0;
        }
        try{
            FileReader roomReader = new FileReader(room);
            BufferedReader bufferedRoomReader= new BufferedReader(roomReader);

            String linea = bufferedRoomReader.readLine();

            while(linea != null){
                switch(linea){
                    case "upDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueVerticalDoor(UP,linea),verticalDoorX,upDoorY);
                    break;
                    case "downDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueVerticalDoor(DOWN,linea),verticalDoorX,downDoorY);
                    break;
                    case "leftDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueHorizontalDoor(LEFT,linea),leftDoorX,horizontalDoorY);
                    break;
                    case "rightDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueHorizontalDoor(RIGHT,linea),rightDoorX,horizontalDoorY);
                    break;
                    case "Sokudo":
                    CharacterImage sokudo = new SokudoImage();
                    addObject(sokudo,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Light":
                    CharacterImage light = new LightImage();
                    addObject(light,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Shock":
                    CharacterImage shock = new ShockImage();
                    addObject(shock,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Mike":
                    CharacterImage mike = new MikeImage();
                    addObject(mike,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Rengoku":
                    CharacterImage rengoku = new RengokuImage();
                    addObject(rengoku,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "KingHermes":
                    CharacterImage kingHermes = new KingHermesImage();
                    addObject(kingHermes,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Luis":
                    CharacterImage luis = new LuisImage();
                    addObject(luis,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Nagito":
                    CharacterImage nagito = new NagitoImage();
                    addObject(nagito,640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    default:
                    linea = bufferedRoomReader.readLine();
                    break;
                }
            }

        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        addObject(unknown, characterX, characterY);
        map.setTransparency(100);
        addObject(map,145,135);
        mapIcon.setTransparency(200);
        addObject(mapIcon,85 + 10 * mapIconX,135 + 10 * mapIconY);
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
            Greenfoot.setWorld(new EscMenu(id,unknown.getX(),unknown.getY()));
        }
    }
    
    public void sokudoRecruitScene()
    {
        //if(!party.getPartyFlags(1))
       // {
            dialogChunk("¿Quién se acerca?","Déjame verte.","Qué extraño...",0);
            dialogChunk("Dime qué quieres.","[..]","[..]",0);
            dialogChunk("Entiendo.","No queda más remedio que ayudarte.","Sólo prométeme qué no cambiarás mis recuerdos.",0);
            dialogChunk("¡Mi magia nos sacará de aquí!","[..]","[..]",0);

            //boton de si o no
        //}
        //else
        //{

        //}
        //party.setPartyFlags(1);
    }
    
    public void waitForInput()
    {
        Greenfoot.delay(20);
        while(!Greenfoot.isKeyDown("enter"));
        buttonPress.play(); 
        Greenfoot.delay(20);
    }

    public void dialogChunk(String line1, String line2, String line3, int character)
    {
        addObject(textBox,644,549);
        addObject(portrait = new DialogPortrait(character),380,558);
        addObject(header = new DialogHeader(character),350,460);

        addObject(this.line1 = new DialogLine(line1,1),350,460);
        if(line2=="")
        {
            addObject(icon,973,634);
            waitForInput();
        }
        else if(line2!="")
        {
            waitForInput();
            addObject(this.line2 = new DialogLine(line2,2),350,460);
            if(line3=="")
            {
                addObject(icon,973,634);
                waitForInput();
            }else
            {
                waitForInput();
            }
        }
        if(line3!="")
        {
            addObject(this.line3 = new DialogLine(line3,3),350,460);
            addObject(icon,973,634);
            waitForInput();
        }

        removeObject(this.line1);

        if(line2!="")
        {
            removeObject(this.line2);
        }
        if(line3!="")
        {
            removeObject(this.line3);
        }
        removeObject(textBox);
        removeObject(portrait);
        removeObject(header);
        removeObject(icon);
    }

    public void showLocation(String location, boolean displayStatus)
    {
        if(displayStatus==true)
        {
            addObject(locationDisplay = new DialogLocation(location),350,460);
        }else
        {
            removeObject(locationDisplay);
        }
    }
}
