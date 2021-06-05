import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelectMenu extends World
{

    /**
     * Constructor for objects of class CharacterMenu.
     * 
     */
    public CharacterSelectMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        Greenfoot.delay(5);
        setBackground("images/menu/background.png");
        addObject(new Image("images/menu_help_characters/menu_help_characters_01.png"),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_01.png",127, 21,1),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_02.png",416, 21,2),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_03.png",706, 21,3),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_04.png",996, 21,4),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_05.png",127, 365,5),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_06.png",416, 365,6),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_07.png",706, 365,7),640,360);
        addObject(new CharacterSelectedButton("images/menu_help_characters/button_menu_help_characters_08.png",996, 365,8),640,360);
        addObject(new LilReturnButton(0),640,360);
    }
}
