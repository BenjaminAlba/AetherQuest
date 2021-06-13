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
    public ThirdFloorHorizontalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == LEFT)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        ((ThirdFloorRoom)getWorld()).generateBattle();
        if(getX()>640){
            ThirdFloorRoom.addMapIconX(1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new ThirdFloorRoom(destination,165,360));
        }
        else{
            ThirdFloorRoom.addMapIconX(-1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new ThirdFloorRoom(destination,1115,360));
        }
    }
}
