import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogPortrait extends Actor
{
    private GreenfootImage portrait;

    public DialogPortrait(int characterId)
    {
        portrait = new GreenfootImage("images/character_portraits/0"+characterId+".gif");
        portrait.scale(portrait.getWidth()-367,portrait.getHeight()-367);
        setImage(portrait);
    }

    public void act() 
    {

    }

}
