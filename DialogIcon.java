import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogIcon extends Actor
{
    private GreenfootImage img = new GreenfootImage("images/dialog/advance_icon.png");;
    private int counter=0;
    private int currentImage=0;
    private int transparency=255;
    
    public DialogIcon()
    {
        setImage(img);
    }
    
    public void flicker()
    {
        if(counter == 0){
            img.setTransparency(transparency);
            currentImage = (currentImage + 1) % 5;
            transparency-=51;
            if(transparency==0)
            {
                transparency=255;
            }
        }
        counter = (counter + 1)%8;
    }
    
    public void act() 
    {
        flicker();
    }    
}
