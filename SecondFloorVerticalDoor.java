import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondFloofVerticalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondFloorVerticalDoor extends Door
{
    public static final int DOWN = 1;
    private GreenfootImage verticalDoor = new GreenfootImage("images/floor2_rf/vertical_door.png");
    private String destination;
    public SecondFloorVerticalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == DOWN)
            verticalDoor.mirrorVertically();
        setImage(verticalDoor);
    }

    public void changeRoom(){
        ((SecondFloorRoom)getWorld()).generateBattle();
        if(getY()<360){
            SecondFloorRoom.addMapIconY(-1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new SecondFloorRoom(destination,640,540));
        }
        else{
            SecondFloorRoom.addMapIconY(1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new SecondFloorRoom(destination,640,110));
        }
    }  
}
