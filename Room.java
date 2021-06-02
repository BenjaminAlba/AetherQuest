import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room extends World
{
    private int id;
    private int upDoorY = 70;
    private int downDoorY = 650;
    private int verticalDoorX = 640;
    private int leftDoorX = 90;
    private int rightDoorX = 1190;
    private int horizontalDoorY = 360;
    private String characterId = "00";
    private MovingCharacter unknown;
    private ShortWall sh1 = new ShortWall(0);
    private ShortWall sh2 = new ShortWall(1);
    private LongWall lh1 = new LongWall(0);
    private LongWall lh2 = new LongWall(1);
    public Room(int id, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        unknown = new MovingCharacter(characterId);
        setBackground("images/prologue_rf/floor.png");
        addObject(lh1, 640, 60);
        addObject(lh2, 640, 660);
        addObject(sh1, 70, 360);
        addObject(sh2, 1210, 360);
        this.id = id;
        switch(id){
            case 1:
            addObject(new HorizontalDoor(0,2),rightDoorX,horizontalDoorY);
            break;
            case 2:
            addObject(new HorizontalDoor(0,3),rightDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(1,1),leftDoorX,horizontalDoorY);
            break;
            case 3:
            addObject(new HorizontalDoor(1,2),leftDoorX,horizontalDoorY);
            addObject(new VerticalDoor(0,9),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,18),verticalDoorX,downDoorY);
            break;
            case 4:
            addObject(new VerticalDoor(0,12),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,21),verticalDoorX,downDoorY);
            break;
            case 5:
            addObject(new VerticalDoor(0,14),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,23),verticalDoorX,downDoorY);
            break;
            case 6:
            addObject(new VerticalDoor(0,17),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,26),verticalDoorX,downDoorY);
            addObject(new HorizontalDoor(0,7),rightDoorX,horizontalDoorY);
            break;
            case 7:
            addObject(new HorizontalDoor(1,6),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,8),rightDoorX,horizontalDoorY);
            break;
            case 8:
            addObject(new HorizontalDoor(1,7),leftDoorX,horizontalDoorY);
            break;
            case 9:
            addObject(new HorizontalDoor(0,10),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(1,3),verticalDoorX,downDoorY);
            break;
            case 10:
            addObject(new VerticalDoor(0,27),verticalDoorX,upDoorY);
            addObject(new HorizontalDoor(1,9),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,11),rightDoorX,horizontalDoorY);
            break;
            case 11:
            addObject(new HorizontalDoor(1,10),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,12),rightDoorX,horizontalDoorY);
            break;
            case 12:
            addObject(new HorizontalDoor(1,11),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,13),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(0,28),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,4),verticalDoorX,downDoorY);
            break;
            case 13:
            addObject(new HorizontalDoor(1,12),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,14),rightDoorX,horizontalDoorY);
            break;
            case 14:
            addObject(new HorizontalDoor(1,13),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,15),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(0,29),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,5),verticalDoorX,downDoorY);
            break;
            case 15:
            addObject(new HorizontalDoor(1,14),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,16),rightDoorX,horizontalDoorY);
            break;
            case 16:
            addObject(new HorizontalDoor(1,15),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,17),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(0,30),verticalDoorX,upDoorY);
            break;
            case 17:
            addObject(new HorizontalDoor(1,16),leftDoorX,horizontalDoorY);
            addObject(new VerticalDoor(1,6),verticalDoorX,downDoorY);
            break;
            case 18:
            addObject(new HorizontalDoor(0,19),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(0,3),verticalDoorX,upDoorY);
            break;
            case 19:
            addObject(new HorizontalDoor(1,18),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,20),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(1,31),verticalDoorX,downDoorY);
            break;
            case 20:
            addObject(new HorizontalDoor(1,19),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,21),rightDoorX,horizontalDoorY);
            break;
            case 21:
            addObject(new HorizontalDoor(1,22),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,20),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(1,32),verticalDoorX,downDoorY);
            addObject(new VerticalDoor(0,4),verticalDoorX,upDoorY);
            break;
            case 22:
            addObject(new HorizontalDoor(1,23),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,21),rightDoorX,horizontalDoorY);
            break;
            case 23:
            addObject(new HorizontalDoor(1,24),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,22),rightDoorX,horizontalDoorY);
            addObject(new VerticalDoor(1,33),verticalDoorX,downDoorY);
            addObject(new VerticalDoor(0,5),verticalDoorX,upDoorY);
            break;
            case 24:
            addObject(new HorizontalDoor(1,25),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,23),rightDoorX,horizontalDoorY);
            break;
            case 25:
            addObject(new HorizontalDoor(1,26),leftDoorX,horizontalDoorY);
            addObject(new HorizontalDoor(0,24),rightDoorX,horizontalDoorY);
            break;
            case 26:
            addObject(new HorizontalDoor(1,25),leftDoorX,horizontalDoorY);
            addObject(new VerticalDoor(0,6),verticalDoorX,upDoorY);
            break;
            case 27:
            addObject(new VerticalDoor(0,35),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,10),verticalDoorX,downDoorY);
            break;
            case 28:
            addObject(new VerticalDoor(0,36),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,12),verticalDoorX,downDoorY);
            break;
            case 29:
            addObject(new VerticalDoor(0,37),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,14),verticalDoorX,downDoorY);
            break;
            case 30:
            addObject(new VerticalDoor(0,38),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,16),verticalDoorX,downDoorY);
            break;
            case 31:
            addObject(new VerticalDoor(0,19),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,39),verticalDoorX,downDoorY);
            break;
            case 32:
            addObject(new VerticalDoor(0,21),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,40),verticalDoorX,downDoorY);
            break;
            case 33:
            addObject(new VerticalDoor(0,23),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,41),verticalDoorX,downDoorY);
            break;
            case 34:
            addObject(new VerticalDoor(0,25),verticalDoorX,upDoorY);
            addObject(new VerticalDoor(1,42),verticalDoorX,downDoorY);
            break;
            case 35:
            addObject(new VerticalDoor(1,27),verticalDoorX,downDoorY);
            break;
            case 36:
            addObject(new VerticalDoor(1,28),verticalDoorX,downDoorY);
            break;
            case 37:
            addObject(new VerticalDoor(1,29),verticalDoorX,downDoorY);
            break;
            case 38:
            addObject(new VerticalDoor(1,30),verticalDoorX,downDoorY);
            break;
            case 39:
            addObject(new VerticalDoor(0,31),verticalDoorX,upDoorY);
            break;
            case 40:
            addObject(new VerticalDoor(0,32),verticalDoorX,upDoorY);
            break;
            case 41:
            addObject(new VerticalDoor(0,33),verticalDoorX,upDoorY);
            break;
            case 42:
            addObject(new VerticalDoor(0,34),verticalDoorX,upDoorY);
            break;
        }

        addObject(unknown, characterX, characterY);
    }

    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new EscMenu(id,unknown.getX(),unknown.getY()));
        }
    }
}
