import greenfoot.*;
import java.util.*;

public class AttackAnimation extends Actor
{
    GifImage attack = new GifImage("images/animations/attack_full.gif");
    GreenfootImage imageOne;
    boolean notImageOne;
     
    public AttackAnimation()
    {
        List<GreenfootImage> images = attack.getImages(); 
        imageOne = images.get(0); 
        /*for (GreenfootImage img : images) 
            img.scale(75, 75);*/
        setImage(attack.getCurrentImage()); 
    }
 
    public void act() 
    {
        setImage(attack.getCurrentImage()); 
        if ((getImage() != imageOne) != notImageOne) 
        {
            notImageOne = ! notImageOne; 
            if (! notImageOne) 
                getWorld().removeObject(this); 
        }
    }
}
