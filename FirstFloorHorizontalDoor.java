import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstFloorHorizontalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstFloorHorizontalDoor extends Door
{
    public static final int LEFT = 1;
    private GreenfootImage horizontalDoor = new GreenfootImage("images/floor1_rf/horizontal_door.png");
    private String destination;
    public FirstFloorHorizontalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == LEFT)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        if(getX()>640){
            FirstFloorRoom.addMapIconX(1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new FirstFloorRoom(destination,165,360));
        }
        else{
            FirstFloorRoom.addMapIconX(-1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new FirstFloorRoom(destination,1115,360));
        }
    }
}
