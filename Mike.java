import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class M1K3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mike extends Character
{
    private float defScalingPercent;
    
    private final String skill1Name="King's Shield";
    private final int skill1Type=2;
    private float skill1DamageTakenMultiplier;
    private int skill1ActiveTurns;
    private int skill1SpCost;
    
    private final String skill2Name="All Eyez On Me";
    private final int skill2Type=2;
    private int skill2ActiveTurns;
    private int skill2SpCost;
    
    private final String skill3Name="Shield Bash";
    private final int skill3Type=1;
    private float skill3DefScalingPercentIncrease;
    
    private final String skill4Name="Fighters Physique";
    private final int skill4Type=1;
    private int skill4BaseSpdIncrease;
    
    public Mike()
    {
        id=4;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=true;
        
        baseHp=16;
        hp=16;
        maxHP=16;
        baseAtk=3;
        atk=3;
        hitCount=1;
        baseDef=4;
        def=4;
        ultQuantity=5;
        maxSP=70;
        sp=70;
        baseSpeed=3;
        speed=3;
        
        defScalingPercent=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
