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
    public SecondFloorHorizontalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == LEFT)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        ((SecondFloorRoom)getWorld()).generateBattle();
        if(getX()>640){
            SecondFloorRoom.addMapIconX(1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new SecondFloorRoom(destination,165,360));
        }
        else{
            SecondFloorRoom.addMapIconX(-1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new SecondFloorRoom(destination,1115,360));
        }
    }
}
