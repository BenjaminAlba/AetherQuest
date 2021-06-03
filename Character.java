import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    protected int id;
    protected static final int REQUIRED_EXP = 20;
    protected int currentExp;
    protected int lvl;
    protected int skillPoints;
    protected int baseHp;
    protected int maxHP;
    protected int hp;
    protected int baseAtk;
    protected int atk;
    protected int hitCount;
    protected int baseDef;
    protected int def;
    protected int ultCharges;
    protected int ultQuantity;
    protected int maxSP;
    protected int sp;
    protected int baseSpeed;
    protected int speed;
    protected int skill1;
    protected int skill2;
    protected int skill3;
    protected int skill4;
    protected boolean healFlag;
    
    public void act() 
    {
        // Add your action code here.
    }    
}