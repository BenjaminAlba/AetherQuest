import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shock extends Character
{
    private int GutsActivationRate;
    private int EvadeRate;
    private float CounterHpDamageScalingPercent;
    
    private final String skill1Name="OK";
    private final int skill1Type=1;
    private int skill1GutsActivationRateIncrease;
    
    private final String skill2Name="Vile Feast";
    private final int skill2Type=2;
    private float skill2HpRecoveryPercent;
    private int skill2ActiveTurns;
    private int skill2SpCost;
    
    private final String skill3Name="Sheer Luck";
    private final int skill3Type=1;
    private int skill3EvadeRateIncrease;
    private float skill3CounterHpDamageScalingPercentIncrease;
    
    private final String skill4Name="Decoy Tactics";
    private final int skill4Type=2;
    private float skill4DamageMitigationPercent;
    private int skill4ActiveTurns;
    private int skill4SpCost;
    
    public Shock()
    {
        id=3;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=true;
        
        baseHp=18;
        hp=18;
        maxHP=18;
        baseAtk=3;
        atk=3;
        hitCount=1;
        baseDef=3;
        def=3;
        ultQuantity=5;
        maxSP=70;
        sp=70;
        baseSpeed=7;
        speed=7;
        
        GutsActivationRate=0;
        EvadeRate=0;
        CounterHpDamageScalingPercent=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
