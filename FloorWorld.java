import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class FloorWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class FloorWorld extends World
{
    public static final int OPEN = 1;
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
    public static final int UP = 0;
    public static final int DOWN = 1;

    protected int upDoorY = 70;
    protected int downDoorY = 650;
    protected int verticalDoorX = 640;
    protected int leftDoorX = 90;
    protected int rightDoorX = 1190;
    protected int horizontalDoorY = 360;

    public FloorWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
    }

    protected void buildWorld(File room){
        try(FileReader roomReader = new FileReader(room); BufferedReader bufferedRoomReader= new BufferedReader(roomReader);){
            String linea = bufferedRoomReader.readLine();
            while(linea != null){
                switch(linea){
                    case "upDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(getUpDoor(linea),verticalDoorX,upDoorY);
                    break;
                    case "downDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(getDownDoor(linea),verticalDoorX,downDoorY);
                    break;
                    case "leftDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(getLeftDoor(linea),leftDoorX,horizontalDoorY);
                    break;
                    case "rightDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(getRightDoor(linea),rightDoorX,horizontalDoorY);
                    break;
                    case "trapDoor":
                    addObject(getTrapDoor(linea),640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                }
                linea = bufferedRoomReader.readLine();
            }

        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public abstract Door getUpDoor(String linea);

    public abstract Door getDownDoor(String linea);

    public abstract Door getLeftDoor(String linea);

    public abstract Door getRightDoor(String linea);

    public abstract TrapDoor getTrapDoor(String linea);
}
