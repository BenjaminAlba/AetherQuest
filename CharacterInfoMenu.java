import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterInfoMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterInfoMenu extends World
{

    /**
     * Constructor for objects of class CharacterInfoMenu.
     * 
     */
    public CharacterInfoMenu(int id)
    {    
        super(1280, 720, 1); 
        setBackground("images/menu/background.png");
        addObject(new Image("images/menu_help_characters_info/menu_help_characters_info_0" + id + ".png"),640,360);
        addObject(new LilReturn(1),640,360);
    }
}
