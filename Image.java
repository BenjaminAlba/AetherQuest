import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    private GreenfootImage image;  
    
    public Image(){
        
    }
    
    public Image(GreenfootImage image){
        this.image = image;
        setImage(this.image);
    }
    
    public Image(String image){
        this.image = new GreenfootImage(image);
        setImage(this.image);
    }
    
    public void scale(int width, int height){
        this.image.scale(image.getWidth()+width, image.getHeight()+height);
    }
    
    public void rotate(int degrees){
        image.rotate(degrees);
    }
    
    public void setTransparency(int transparency){
        image.setTransparency(transparency);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
