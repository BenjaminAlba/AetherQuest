import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThirdFloorVerticalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdFloorVerticalDoor extends Door
{
    public static final int DOWN = 1;
    private GreenfootImage verticalDoor = new GreenfootImage("images/floor3_rf/vertical_door.png");
    private String destination;
    private int positionX;
    private int positionY;
    
    public ThirdFloorVerticalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == DOWN)
            verticalDoor.mirrorVertically();
        setImage(verticalDoor);
    }

    public void changeRoom(){
        if(getY()<360){
            ThirdFloorRoom.addMapIconY(-1);
            positionX = 640;
            positionY = 540;
        }
        else{
            ThirdFloorRoom.addMapIconY(1);
            positionX = 640;
            positionY = 110;
        }
        Greenfoot.setWorld(new ThirdFloorRoom(destination,positionX,positionY));
        ((ThirdFloorRoom)getWorld()).generateBattle(destination,positionX,positionY);
    }
}
