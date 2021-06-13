import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondFloorHorizontalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondFloorHorizontalDoor extends Door
{
    public static final int LEFT = 1;
    private GreenfootImage horizontalDoor = new GreenfootImage("images/floor2_rf/horizontal_door.png");
    private String destination;
    private int positionX;
    private int positionY;
    
    public SecondFloorHorizontalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == LEFT)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        if(getX()>640){
            SecondFloorRoom.addMapIconX(1);
            positionX = 165;
            positionY = 360;
        }
        else{
            SecondFloorRoom.addMapIconX(-1);
            positionX = 1115;
            positionY = 360;
        }
        Greenfoot.setWorld(new SecondFloorRoom(destination,positionX,positionY));
        ((SecondFloorRoom)getWorld()).generateBattle(destination,positionX, positionY);
    }
}
