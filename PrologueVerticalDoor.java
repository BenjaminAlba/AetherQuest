import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueVerticalDoor extends Door
{
    public static final int DOWN = 1;
    private GreenfootImage verticalDoor = new GreenfootImage("images/prologue_rf/vertical_door.png");
    private String destination;
    public PrologueVerticalDoor(int orientation, String destination){
        this.destination = destination;
        if(orientation == DOWN)
            verticalDoor.mirrorVertically();
        setImage(verticalDoor);
    }

    public void changeRoom(){
        if(getY()<360){
            PrologueRoom.addMapIconY(-1);
            Greenfoot.setWorld(new PrologueRoom(destination,640,540));
        }
        else{
            PrologueRoom.addMapIconY(1);
            Greenfoot.setWorld(new PrologueRoom(destination,640,110));
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
