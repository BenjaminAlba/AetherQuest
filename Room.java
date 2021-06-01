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
    private static String characterId = "00";
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
            addObject(new HorizontalDoor(0,2),1190,360);
            break;
            case 2:
            addObject(new HorizontalDoor(0,3),1190,360);
            addObject(new HorizontalDoor(1,1),90,360);
            break;
            case 3:
            addObject(new HorizontalDoor(1,2),90,360);
            addObject(new VerticalDoor(0,9),640,70);
            addObject(new VerticalDoor(1,18),640,650);
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
