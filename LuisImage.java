import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LuisImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LuisImage extends CharacterImage
{
    private GreenfootImage image;

    public LuisImage(){
        image = new GreenfootImage("images/character_sprites/07/07_upidle.png");
        image.scale(image.getWidth()+100,image.getHeight()+100);
        setImage(image);
    }
    
    public void recruitScene(){
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
