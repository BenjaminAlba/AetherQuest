import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MikeImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MikeImage extends CharacterImage
{
    private GreenfootImage image;

    public MikeImage(){
        image = new GreenfootImage("images/character_sprites/04/04_downidle.png");
        image.scale(image.getWidth()+100,image.getHeight()+100);
        setImage(image);
    }

    public void recruitScene(){
        World room = getWorld();
        PrologueRoom actualRoom = (PrologueRoom)room;
        actualRoom.mikeRecruitScene();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
