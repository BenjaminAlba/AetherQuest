import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingHermes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingHermes extends Character
{
    private double acquiredExpMultiplier;
    
    private final String skill1Name="Royal Bloodline";
    private final int skill1Type=1;
    private double skill1acquiredExpMultiplierIncrease;
    
    private final String skill2Name="UXIONO";
    private final int skill2Type=2;
    private double skill2AllySpRecoveryPercent;
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
    
    public void upgradeS1()
    {
        if(skillPoints>0)
        {
            skill1++;
            switch(skill1)
            {
                case 1:
                    skill1acquiredExpMultiplierIncrease=0.1;
                    break;
                case 2:
                    skill1acquiredExpMultiplierIncrease=0.1;
                    break;
                case 3:
                    skill1acquiredExpMultiplierIncrease=0.1;
                    break;
                case 4:
                    skill1acquiredExpMultiplierIncrease=0.05;
                    break;
                case 5:
                    skill1acquiredExpMultiplierIncrease=0.05;
                    break;
                case 6:
                    skill1acquiredExpMultiplierIncrease=0.05;
                    break;
                case 7:
                    skill1acquiredExpMultiplierIncrease=0.05;
                    break;
            }
            acquiredExpMultiplier+=skill1acquiredExpMultiplierIncrease;
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
                    skill2AllySpRecoveryPercent=0.15;
                    skill2SpCost=4;
                    break;
                case 2:
                    skill2AllySpRecoveryPercent=0.16;
                    skill2SpCost=5;
                    break;
                case 3:
                    skill2AllySpRecoveryPercent=0.18;
                    skill2SpCost=7;
                    break;
                case 4:
                    skill2AllySpRecoveryPercent=0.22;
                    skill2SpCost=7;
                    break;
                case 5:
                    skill2AllySpRecoveryPercent=0.26;
                    skill2SpCost=7;
                    break;
                case 6:
                    skill2AllySpRecoveryPercent=0.3;
                    skill2SpCost=10;
                    break;
                case 7:
                    skill2AllySpRecoveryPercent=0.35;
                    skill2SpCost=10;
                    break;
            }
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
                    skill3RunRate=30;
                    skill3SpCost=0;
                    break;
                case 2:
                skill3RunRate=33;
                    skill3SpCost=0;
                    break;
                case 3:
                skill3RunRate=36;
                    skill3SpCost=0;
                    break;
                case 4:
                    skill3RunRate=40;
                    skill3SpCost=0;
                    break;
                case 5:
                    skill3RunRate=43;
                    skill3SpCost=0;
                    break;
                case 6:
                    skill3RunRate=46;
                    skill3SpCost=0;
                    break;
                case 7:
                    skill3RunRate=50;
                    skill3SpCost=0;
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
                    skill4ActivationRate=20;
                    skill4SpCost=4;
                    break;
                case 2:
                    skill4ActivationRate=30;
                    skill4SpCost=5;
                    break;
                case 3:
                    skill4ActivationRate=40;
                    skill4SpCost=7;
                    break;
                case 4:
                    skill4ActivationRate=50;
                    skill4SpCost=7;
                    break;
                case 5:
                    skill4ActivationRate=60;
                    skill4SpCost=7;
                    break;
                case 6:
                    skill4ActivationRate=80;
                    skill4SpCost=10;
                    break;
                case 7:
                    skill4ActivationRate=100;
                    skill4SpCost=10;
                    break;
            }
            skillPoints-=1;
        }
    }
    
    public String getSkill1Name(){
        return skill1Name;
    }
    public String getSkill2Name(){
        return skill2Name;
    }
    public String getSkill3Name(){
        return skill3Name;
    }
    public String getSkill4Name(){
        return skill4Name;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
