import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShockImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShockImage extends CharacterImage
{
    private GreenfootImage image;

    public ShockImage(){
        image = new GreenfootImage("images/character_sprites/03/03_downidle.png");
        image.scale(image.getWidth()+100,image.getHeight()+100);
        setImage(image);
    }
    
    public void recruitScene(){
        World room = getWorld();
        PrologueRoom actualRoom = (PrologueRoom)room;
        actualRoom.shockRecruitScene();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
