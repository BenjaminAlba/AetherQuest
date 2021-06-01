import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Luis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Luis extends Character
{
    private float acquiredMoneyMultiplier;
    private float itemDamageMultiplier;
    private int negateItemConsumptionRate;
    
    private final String skill1Name="Keen eye";
    private final int skill1Type=1;
    private float skill1AcquiredMoneyMultiplierIncrease;
    
    private final String skill2Name="Business Experience";
    private final int skill2Type=2;
    private float skill2ItemDamageMultiplierIncrease;
    
    private final String skill3Name="Crunching Numbers";
    private final int skill3Type=2;
    private int skill3NegateItemConsumptionRateIncrease;
    
    private final String skill4Name="Final Gamble";
    private final int skill4Type=2;
    private float skill4SelfHpDamagePercent;
    private float skill4HpDamagePercent;
    private int skill4SpCost;
    
    public Luis()
    {
        id=7;
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
        ultQuantity=5;
        maxSP=70;
        sp=70;
        baseSpeed=5;
        speed=5;
        
        acquiredMoneyMultiplier=0;
        itemDamageMultiplier=0;
        negateItemConsumptionRate=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
