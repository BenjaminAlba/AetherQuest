import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SokudoImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SokudoImage extends CharacterImage
{

    private GreenfootImage image;

    public SokudoImage(){
        image = new GreenfootImage("images/character_sprites/01/01_downidle.png");
        image.scale(image.getWidth()+100,image.getHeight()+100);
        setImage(image);
    }

    public void recruitScene(){
        World room = getWorld();
        PrologueRoom actualRoom = (PrologueRoom)room;
        actualRoom.sokudoRecruitScene();
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
