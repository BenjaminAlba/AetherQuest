import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightImage extends CharacterImage
{
    private GreenfootImage image;

    public LightImage(){
        image = new GreenfootImage("images/character_sprites/02/02_downidle.png");
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
