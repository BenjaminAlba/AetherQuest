import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NagitoImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NagitoImage extends CharacterImage
{
    private GreenfootImage image;

    public NagitoImage(){
        image = new GreenfootImage("images/character_sprites/08/08_upidle.png");
        image.scale(image.getWidth()+100,image.getHeight()+100);
        setImage(image);
    }
    
    public void recruitScene(){
        World room = getWorld();
        PrologueRoom actualRoom = (PrologueRoom)room;
        actualRoom.nagitoRecruitScene();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
