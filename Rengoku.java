import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rengoku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rengoku extends Character
{
    private float holyFlameHpDamagePercent;
    
    private final String skill1Name="Holy Flame";
    private final int skill1Type=1;
    private float skill1HolyFlameHpDamagePercentIncrease;
    
    private final String skill2Name="Prayer";
    private final int skill2Type=2;
    private float skill2AllyHpRecoveryPercent;
    private int skill2SpCost;
    
    private final String skill3Name="Entreat";
    private final int skill3Type=2;
    private float skill3AtkMultiplier;
    private int skill3SpCost;
    
    private final String skill4Name="Cheer";
    private final int skill4Type=2;
    private float skill4DefMultiplier;
    private int skill4SpCost;
    
    public Rengoku()
    {
        id=5;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=true;
        
        baseHp=8;
        hp=8;
        maxHP=8;
        baseAtk=2;
        atk=2;
        hitCount=1;
        baseDef=2;
        def=2;
        ultQuantity=3;
        maxSP=100;
        sp=100;
        baseSpeed=8;
        speed=8;
        
        holyFlameHpDamagePercent=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
