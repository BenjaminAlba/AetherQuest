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
    private double poisonHpPercentDamage;

    private final String skill1Name="Enfeeble";
    private final int skill1Type=1;
    private int skill1PoisonActivationRateIncrease;

    private final String skill2Name="Murderous Gaze";
    private final int skill2Type=2;
    private int skill2PoisonActivationRateIncrease;
    private double skill2PoisonHpPercentDamageIncrease;
    private int skill2PoisonActiveTurnsIncrease;
    private int skill2SpCost;

    private final String skill3Name="Dark Path";
    private final int skill3Type=1;
    private double skill3SpRecoveryRate;

    private final String skill4Name="Transfusion";
    private final int skill4Type=2;
    private double skill4SelfHpDamagePercent;
    private int skill4AllySpRecoveryPercent;
    private int skill4SelfSpRecovertPercent;
    private int skill4SpCost;

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

    public void upgradeS1()
    {
        if(skillPoints>0)
        {
            skill1++;
            switch(skill1)
            {
                case 1:
                    skill1PoisonActivationRateIncrease=5;
                    break;
                case 2:
                    skill1PoisonActivationRateIncrease=3;
                    break;
                case 3:
                    skill1PoisonActivationRateIncrease=3;
                    break;
                case 4:
                    skill1PoisonActivationRateIncrease=4;
                    break;
                case 5:
                    skill1PoisonActivationRateIncrease=5;
                    break;
                case 6:
                    skill1PoisonActivationRateIncrease=5;
                    break;
                case 7:
                    skill1PoisonActivationRateIncrease=5;
                    break;
            }
            poisonActivationRate+=skill1PoisonActivationRateIncrease;
            skillPoints-=1;
        }
    }

    public void upgradeS2()
    {
        if(skillPoints>0)
        {
            skill2++;
            switch(skill2)
            {
                case 1:
                    skill2PoisonActivationRateIncrease=20;
                    skill2PoisonHpPercentDamageIncrease=5;
                    skill2PoisonActiveTurnsIncrease=2;
                    skill2SpCost=10;
                    break;
                case 2:
                    skill2PoisonActivationRateIncrease=4;
                    skill2PoisonHpPercentDamageIncrease=1;
                    skill2PoisonActiveTurnsIncrease=2;
                    skill2SpCost=10;
                    break;
                case 3:
                    skill2PoisonActivationRateIncrease=2;
                    skill2PoisonHpPercentDamageIncrease=2;
                    skill2PoisonActiveTurnsIncrease=2;
                    skill2SpCost=10;
                    break;
                case 4:
                    skill2PoisonActivationRateIncrease=2;
                    skill2PoisonHpPercentDamageIncrease=1;
                    skill2PoisonActiveTurnsIncrease=2;
                    skill2SpCost=15;
                    break;
                case 5:
                    skill2PoisonActivationRateIncrease=4;
                    skill2PoisonHpPercentDamageIncrease=2;
                    skill2PoisonActiveTurnsIncrease=2;
                    skill2SpCost=20;
                    break;
                case 6:
                    skill2PoisonActivationRateIncrease=4;
                    skill2PoisonHpPercentDamageIncrease=2;
                    skill2PoisonActiveTurnsIncrease=3;
                    skill2SpCost=25;
                    break;
                case 7:
                    skill2PoisonActivationRateIncrease=4;
                    skill2PoisonHpPercentDamageIncrease=2;
                    skill2PoisonActiveTurnsIncrease=3;
                    skill2SpCost=25;
                    break;
            }
            poisonActivationRate+=skill2PoisonActivationRateIncrease;
            poisonActiveTurns=skill2PoisonActiveTurnsIncrease;
            poisonHpPercentDamage+=skill2PoisonHpPercentDamageIncrease;
            skillPoints-=1;
        }
    }

    public void upgradeS3()
    {
        if(skillPoints>0)
        {
            skill3++;
            switch(skill3)
            {
                case 1:
                skill3SpRecoveryRate=0.15;
                break;
                case 2:
                skill3SpRecoveryRate=0.18;
                break;
                case 3:
                skill3SpRecoveryRate=0.2;
                break;
                case 4:
                skill3SpRecoveryRate=0.22;
                break;
                case 5:
                skill3SpRecoveryRate=0.24;
                break;
                case 6:
                skill3SpRecoveryRate=0.26;
                break;
                case 7:
                skill3SpRecoveryRate=0.3;
                break;
            }
            skillPoints-=1;
        }
    }

    public void upgradeS4()
    {
        if(skillPoints>0)
        {
            skill4++;
            switch(skill4)
            {
                case 1:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=20;
                skill4SelfSpRecovertPercent=10;
                skill4SpCost=20;
                break;
                case 2:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=24;
                skill4SelfSpRecovertPercent=15;
                skill4SpCost=24;
                break;
                case 3:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=28;
                skill4SelfSpRecovertPercent=20;
                skill4SpCost=28;
                break;
                case 4:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=30;
                skill4SelfSpRecovertPercent=25;
                skill4SpCost=30;
                break;
                case 5:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=34;
                skill4SelfSpRecovertPercent=30;
                skill4SpCost=34;
                break;
                case 6:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=38;
                skill4SelfSpRecovertPercent=35;
                skill4SpCost=38;
                break;
                case 7:
                skill4SelfHpDamagePercent=0.2;
                skill4AllySpRecoveryPercent=40;
                skill4SelfSpRecovertPercent=40;
                skill4SpCost=40;
                break;
            }
            skillPoints-=1;
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
