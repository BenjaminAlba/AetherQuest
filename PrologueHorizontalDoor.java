import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HorizontalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueHorizontalDoor extends Door
{
    private GreenfootImage horizontalDoor = new GreenfootImage("images/prologue_rf/horizontal_door.png");
    private String destiny;
    public PrologueHorizontalDoor(int orientation, String destiny){
        this.destiny = destiny;
        if(orientation == 1)
            horizontalDoor.mirrorHorizontally();
        setImage(horizontalDoor);
    }

    public void changeRoom(){
        if(getX()>640)
            Greenfoot.setWorld(new PrologueRoom(destiny,165,360));
        else
            Greenfoot.setWorld(new PrologueRoom(destiny,1115,360));

    }

    public void act() 
    {
        // Add your action code here.
    }    
}
