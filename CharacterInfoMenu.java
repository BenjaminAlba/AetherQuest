import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterInfoMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterInfoMenu extends World
{
    public static final int CHARACTER_SELECT_MENU = 1;
    public CharacterInfoMenu(int id)
    {    
        super(1280, 720, 1); 
        setBackground("images/menu/background.png");
        addObject(new Image("images/menu_help_characters_info/menu_help_characters_info_0" + id + ".png"),640,360);
        addObject(new LilReturnButton(CHARACTER_SELECT_MENU),640,360);
    }
}
