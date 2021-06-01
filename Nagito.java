import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nagito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nagito extends Character
{
    private int furyStack;
    private int cooldownTurns;
    private int gutsActivationRate;
    private float markedEnemyDamageMultiplier;
    
    private final String skill1Name="Fleeting Moments";
    private final int skill1Type=1;
    
    private final String skill2Name="Bearer of the Dark Sigil";
    private final int skill2Type=1;
    
    private final String skill3Name="Boiling Blood";
    private final int skill3Type=2;
    private float skill3StackReleaseMultiplier;
    private int skill3SpCost;
    
    private final String skill4Name="Deep Breath";
    private final int skill4Type=2;
    private float skill4HpRecoveryMultiplier;
    private int skill4SpCost;
    
    public Nagito()
    {
        id=7;
        lvl=1;
        currentExp=0;
        skillPoints=0;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=false;
        
        baseHp=12;
        hp=12;
        maxHP=12;
        baseAtk=7;
        atk=7;
        hitCount=1;
        baseDef=2;
        def=2;
        ultQuantity=8;
        maxSP=0;
        sp=0;
        baseSpeed=5;
        speed=5;
        
        furyStack=0;
        cooldownTurns=0;
        gutsActivationRate=0;
        markedEnemyDamageMultiplier=0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
