import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueVerticalDoor extends Door
{
    private GreenfootImage verticalDoor = new GreenfootImage("images/prologue_rf/vertical_door.png");
    private String destiny;
    public PrologueVerticalDoor(int orientation, String destiny){
        this.destiny = destiny;
        if(orientation == 1)
            verticalDoor.mirrorVertically();
        setImage(verticalDoor);
    }
    
    public void changeRoom(){
        if(getY()<360)
            Greenfoot.setWorld(new PrologueRoom(destiny,640,540));
        else
            Greenfoot.setWorld(new PrologueRoom(destiny,640,90));
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
