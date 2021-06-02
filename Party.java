import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Party here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Party extends Actor
{
    private static Party uniqueInstance;
    
    private Character member1;
    private Character member2;
    private Character member3;
    private Character member4;
    private int money;
    private int inventory[] = new int[12];
    
    private Party(){   
    }
    
    public static Party getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Party();
        return uniqueInstance;
    }
}
