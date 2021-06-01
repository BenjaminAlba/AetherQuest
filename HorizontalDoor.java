import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HorizontalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorizontalDoor extends Door
{
    private GreenfootImage horizontalDoor = new GreenfootImage("images/prologue_rf/horizontal_door.png");
    private int destiny;
    public HorizontalDoor(int orientation, int destiny){
        this.destiny = destiny;
        if(orientation == 1)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        if(getX()>640)
            Greenfoot.setWorld(new Room(destiny,165,360));
        else
            Greenfoot.setWorld(new Room(destiny,1115,360));

    }

    public void act() 
    {
        // Add your action code here.
    }    
}
