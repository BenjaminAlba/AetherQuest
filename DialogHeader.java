import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DialogHeader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogHeader extends Actor
{
    private String name;
    private GreenfootImage img;
    public DialogHeader(CharacterNameProvider character)
    {
        img = new GreenfootImage(500, 200);
        img.setColor(Color.WHITE);
        img.setFont(new Font("Helvetica", false, false, 30));

        img.drawString(character.getName(),character.getHeaderX(),character.getHeaderY());
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}