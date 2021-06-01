import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalDoor extends Door
{
    private GreenfootImage verticalDoor = new GreenfootImage("images/prologue_rf/vertical_door.png");
    private int destiny;
    public VerticalDoor(int orientation, int destiny){
        this.destiny = destiny;
        if(orientation == 1)
            verticalDoor.mirrorVertically();
        setImage(verticalDoor);
    }
    
    public void changeRoom(){
        if(getY()<360)
            Greenfoot.setWorld(new Room(destiny,640,540));
        else
            Greenfoot.setWorld(new Room(destiny,640,90));
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
