import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sokudo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sokudo extends Character
{
    private float defIgnorePercent;
    
    private final String skill1Name="Temporal Void";
    private final int skill1Type=1;
    private int skill1StacksRequired;
    private float skill1defIgnorePercentIncrease;
    
    private final String skill2Name="Chaos Overlimit";
    private final int skill2Type=2;
    private int skill2HitCount;
    private float skill2AtkUsedPercent;
    private int skill2SpCost;
    
    private final String skill3Name="Warp Strike";
    private final int skill3Type=1;
    private int skill3HitCount;
    private float skill3AtkUsedPercent;
    
    private final String skill4Name="Static Charge";
    private final int skill4Type=2;
    private float skill4DamageMultiplier;
    private int skill4SpCost;
    
    public Sokudo()
    {
        id=1;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=true;
        
        baseHp=10;
        hp=10;
        maxHP=10;
        baseAtk=4;
        atk=4;
        hitCount=2;
        baseDef=2;
        def=2;
        ultQuantity=5;
        maxSP=90;
        sp=90;
        baseSpeed=10;
        speed=10;
        
        defIgnorePercent=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
