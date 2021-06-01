import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Light here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Light extends Character
{
    private int poisonActivationRate;
    private int poisonActiveTurns;
    private float poisonHpPercentDamage;
    
    private final String skill1Name="Enfeeble";
    private final int skill1Type=1;
    private int skill1PoisonActivationRateIncrease;
    
    private final String skill2Name="Murderous Gaze";
    private final int skill2Type=2;
    private int skill2PoisonActivationRateIncrease;
    private float skill2PoisonHpPercentDamageIncrease;
    private int skill2PoisonActiveTurnsIncrease;
    private int skill2SpCost;
    
    private final String skill3Name="Dark Path";
    private final int skill3Type=1;
    private float skill3SpRecoveryRate;
    
    private final String skill4Name="Transfusion";
    private final int skill4Type=2;
    private float skill4SelfHpDamagePercent;
    private float skill4AllySpRecoveryPercent;
    private float skill4SelfSpRecovertPercent;
    private float skill4SpCost;
    
    public Light()
    {
        id=2;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=true;
        
        baseHp=12;
        hp=12;
        maxHP=12;
        baseAtk=3;
        atk=3;
        hitCount=1;
        baseDef=2;
        def=2;
        ultQuantity=6;
        maxSP=100;
        sp=100;
        baseSpeed=5;
        speed=5;
        
        poisonActivationRate=0;
        poisonActiveTurns=0;
        poisonHpPercentDamage=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
