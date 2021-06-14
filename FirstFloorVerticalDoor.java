import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstFloorVerticalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstFloorVerticalDoor extends Door
{
    public static final int DOWN = 1;
    private GreenfootImage verticalDoor = new GreenfootImage("images/floor1_rf/vertical_door.png");
    private String destination;
    private int positionX;
    private int positionY;
    public FirstFloorVerticalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == DOWN)
            verticalDoor.mirrorVertically();
        setImage(verticalDoor);
    }

    public void changeRoom(){
        if(getY()<360){
            FirstFloorRoom.addMapIconY(-1);
            positionX = 640;
            positionY = 540; 
        }
        else{
            FirstFloorRoom.addMapIconY(1);
            positionX = 640;
            positionY = 110;
        }
        Greenfoot.setWorld(new FirstFloorRoom(destination,positionX,positionY));
        ((FirstFloorRoom)getWorld()).generateBattle(destination,positionX,positionY);
    }
}
