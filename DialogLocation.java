import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogLocation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogLocation extends Actor
{
    private GreenfootImage img;

    public DialogLocation(String location)
    {
        img = new GreenfootImage(1280,920);
        img.setColor(Color.WHITE);
        img.setFont(new Font("Helvetica", false, false, 50));
        img.drawString(location, 300, 55);
        setImage(img);
    }

    public void act()
    {
    }    
}