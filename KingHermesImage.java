import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingHermesImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingHermesImage extends CharacterImage
{
    private GreenfootImage image;

    public KingHermesImage(){
        image = new GreenfootImage("images/character_sprites/06/06_upidle.png");
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
