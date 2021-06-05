import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RengokuImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RengokuImage extends CharacterImage
{
    private GreenfootImage image;

    public RengokuImage(){
        image = new GreenfootImage("images/character_sprites/05/05_upidle.png");
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
