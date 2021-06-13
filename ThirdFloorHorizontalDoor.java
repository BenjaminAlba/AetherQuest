import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThirdFloorHorizontalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdFloorHorizontalDoor extends Door
{
    public static final int LEFT = 1;
    private GreenfootImage horizontalDoor = new GreenfootImage("images/floor3_rf/horizontal_door.png");
    private String destination;
    private int positionX;
    private int positionY;
    public ThirdFloorHorizontalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == LEFT)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        if(getX()>640){
            ThirdFloorRoom.addMapIconX(1);
            positionX = 165;
            positionY = 360;
        }
        else{
            ThirdFloorRoom.addMapIconX(-1);
            positionX = 1115;
            positionY = 360;
        }
        Greenfoot.setWorld(new ThirdFloorRoom(destination,positionX,positionY));
        ((ThirdFloorRoom)getWorld()).generateBattle(destination,positionX, positionY);
    }
}
