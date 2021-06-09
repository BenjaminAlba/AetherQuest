import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HorizontalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueHorizontalDoor extends Door
{
    public static final int LEFT = 1;
    private GreenfootImage horizontalDoor = new GreenfootImage("images/prologue_rf/horizontal_door.png");
    private String destination;
    public PrologueHorizontalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == LEFT)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        if(getX()>640){
            PrologueRoom.addMapIconX(1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new PrologueRoom(destination,165,360));
        }
        else{
            PrologueRoom.addMapIconX(-1);
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new PrologueRoom(destination,1115,360));
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
