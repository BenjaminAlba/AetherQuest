import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingHermes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingHermes extends Character
{
    private float acquiredExpMultiplier;
    
    private final String skill1Name="Royal Bloodline";
    private final int skill1Type=1;
    private float skill1acquiredExpMultiplierIncrease;
    
    private final String skill2Name="UXIONO";
    private final int skill2Type=2;
    private float skill2AllySpRecoveryPercent;
    private int skill2SpCost;
    
    private final String skill3Name="PERMATRAGO";
    private final int skill3Type=2;
    private int skill3RunRate;
    private int skill3SpCost;
    
    private final String skill4Name="PADALUSTRO";
    private final int skill4Type=2;
    private int skill4ActivationRate;
    private int skill4SpCost;
    
    public KingHermes()
    {
        id=6;
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
        baseAtk=2;
        atk=2;
        hitCount=1;
        baseDef=2;
        def=2;
        ultQuantity=8;
        maxSP=70;
        sp=70;
        baseSpeed=7;
        speed=7;
                
        acquiredExpMultiplier=0;
    }    
    
    public void act() 
    {
        // Add your action code here.
    }    
}
