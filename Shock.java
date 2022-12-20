import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shock extends Character
{
    private int headerX = 305;
    private int headerY = 90;

    private int gutsActivationRate;
    private int evadeRateP;
    private int evadeRateM;
    private double counterHpDamageScalingPercent;

    private final String skill1Name="OK";
    private final int skill1Type=1;
    private int skill1GutsActivationRateIncrease;

    private final String skill2Name="Vile Feast";
    private final int skill2Type=2;
    private double skill2HpRecoveryPercent = 0.1;
    private int skill2ActiveTurns = 2;
    private int skill2SpCost = 15;

    private final String skill3Name="Sheer Luck";
    private final int skill3Type=1;
    private int skill3EvadeRateIncreaseP;
    private int skill3EvadeRateIncreaseM;
    private double skill3CounterHpDamageScalingPercentIncrease;

    private final String skill4Name="Decoy Tactics";
    private final int skill4Type=2;
    private double skill4DamageMitigationPercent = 0.03;
    private int skill4ActiveTurns = 1;
    private int skill4SpCost = 10;

    private GreenfootImage sprite = new GreenfootImage("images/character_sprites/03/03_sideidle.png");

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
        hpBarrier = 0;
        baseAtk=3;
        atk=3;
        hitCount=1;
        baseDef=3;
        def=3;
        baseSpr=3;
        spr=3;
        ultQuantity=5;
        maxSP=70;
        sp=70;
        baseSpeed=7;
        speed=7;
        damageType = 0;
        
        gutsActivationRate=0;
        evadeRateP=0;
        evadeRateM=0;
        counterHpDamageScalingPercent=0;

        sprite.mirrorHorizontally();
        sprite.scale(sprite.getWidth()+100, sprite.getHeight()+100);

        setImage(sprite);
    }

    public void upgradeS1()
    {
        if(skillPoints>0)
        {
            skill1++;
            switch(skill1)
            {
                case 1:
                    skill1GutsActivationRateIncrease=20;
                    break;
                case 2:
                    skill1GutsActivationRateIncrease=5;
                    break;
                case 3:
                    skill1GutsActivationRateIncrease=5;
                    break;
                case 4:
                    skill1GutsActivationRateIncrease=5;
                    break;
                case 5:
                    skill1GutsActivationRateIncrease=5;
                    break;
                case 6:
                    skill1GutsActivationRateIncrease=5;
                    break;
                case 7:
                    skill1GutsActivationRateIncrease=5;
                    break;
            }
            gutsActivationRate+=skill1GutsActivationRateIncrease;
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
                    skill2HpRecoveryPercent=0.1;
                    skill2ActiveTurns=2;
                    skill2SpCost=15;
                    break;
                case 2:
                    skill2HpRecoveryPercent=0.15;
                    skill2ActiveTurns=2;
                    skill2SpCost=15;
                    break;
                case 3:
                    skill2HpRecoveryPercent=0.18;
                    skill2ActiveTurns=2;
                    skill2SpCost=15;
                    break;
                case 4:
                    skill2HpRecoveryPercent=0.25;
                    skill2ActiveTurns=2;
                    skill2SpCost=20;
                    break;
                case 5:
                    skill2HpRecoveryPercent=0.3;
                    skill2ActiveTurns=2;
                    skill2SpCost=20;
                    break;
                case 6:
                    skill2HpRecoveryPercent=0.35;
                    skill2ActiveTurns=2;
                    skill2SpCost=25;
                    break;
                case 7:
                    skill2HpRecoveryPercent=0.4;
                    skill2ActiveTurns=3;
                    skill2SpCost=25;
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
                    skill3EvadeRateIncreaseP=30;
                    skill3EvadeRateIncreaseM=20;
                    skill3CounterHpDamageScalingPercentIncrease=0.1;
                    break;
                case 2:
                    skill3EvadeRateIncreaseP=10;
                    skill3EvadeRateIncreaseM=5;
                    skill3CounterHpDamageScalingPercentIncrease=0.02;
                    break;
                case 3:
                    skill3EvadeRateIncreaseP=10;
                    skill3EvadeRateIncreaseM=5;
                    skill3CounterHpDamageScalingPercentIncrease=0.04;
                    break;
                case 4:
                    skill3EvadeRateIncreaseP=5;
                    skill3EvadeRateIncreaseM=5;
                    skill3CounterHpDamageScalingPercentIncrease=0.06;
                    break;
                case 5:
                    skill3EvadeRateIncreaseP=5;
                    skill3EvadeRateIncreaseM=5;
                    skill3CounterHpDamageScalingPercentIncrease=0.03;
                    break;
                case 6:
                    skill3EvadeRateIncreaseP=5;
                    skill3EvadeRateIncreaseM=5;
                    skill3CounterHpDamageScalingPercentIncrease=0.03;
                    break;
                case 7:
                    skill3EvadeRateIncreaseP=5;
                    skill3EvadeRateIncreaseM=5;
                    skill3CounterHpDamageScalingPercentIncrease=0.04;
                    break;
            }
            evadeRateP+=skill3EvadeRateIncreaseP;
            evadeRateM+=skill3EvadeRateIncreaseM;
            counterHpDamageScalingPercent+=skill3CounterHpDamageScalingPercentIncrease;
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
                    skill4DamageMitigationPercent=0.2;
                    skill4ActiveTurns=1;
                    skill4SpCost=10;
                    break;
                case 2:
                    skill4DamageMitigationPercent=0.25;
                    skill4ActiveTurns=1;
                    skill4SpCost=10;
                    break;
                case 3:
                    skill4DamageMitigationPercent=0.28;
                    skill4ActiveTurns=1;
                    skill4SpCost=10;
                    break;
                case 4:
                    skill4DamageMitigationPercent=0.31;
                    skill4ActiveTurns=1;
                    skill4SpCost=10;
                    break;
                case 5:
                    skill4DamageMitigationPercent=0.34;
                    skill4ActiveTurns=2;
                    skill4SpCost=14;
                    break;
                case 6:
                    skill4DamageMitigationPercent=0.37;
                    skill4ActiveTurns=2;
                    skill4SpCost=14;
                    break;
                case 7:
                    skill4DamageMitigationPercent=0.4;
                    skill4ActiveTurns=2;
                    skill4SpCost=14;
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

    public String getSkill1Stats(){
        if(skill1 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Guts activation rate: " + gutsActivationRate + "%";
    }

    public String getSkill2Stats(){
        if(skill2 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Hp recovery %: " + (skill2HpRecoveryPercent*100) + "%";
    }

    public String getSkill3Stats(){
        if(skill3 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Evade rate: " + evadeRateP + "%";
    }

    public String getSkill4Stats(){
        if(skill4 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Damage mitigation %:" + (skill4DamageMitigationPercent*100) + "%";
    }

    public void activateSkill1(){

    }

    public void activateSkill2(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.vileFeast();
    }

    public void activateSkill3(){

    }

    public void activateSkill4(){

    }

    public int getGutsActivationRate(){
        return gutsActivationRate;
    }
    
    public double getHpRecoveryPercent(){
        return skill2HpRecoveryPercent;
    }

    public int getSkill2ActiveTurns(){
        return skill2ActiveTurns;
    }

    public int getSkill2SpCost(){
        return skill2SpCost;
    }
    
    public int getEvadeRateP(){
        return evadeRateP;
    }
    
    public int getEvadeRateM(){
        return evadeRateM;
    }
    
    public double getDamageMitigationPercent(){
        return 1 - skill4DamageMitigationPercent;
    }

    public double getCounterDamage(){
        return counterHpDamageScalingPercent;
    }
    
    public int getSkill4ActiveTurns(){
        return skill4ActiveTurns;
    }

    public int getSkill4SpCost(){
        return skill4SpCost;
    }
    
    public String getName(){
        return "Shock";
    }

    public int getHeaderX(){
        return headerX;
    }

    public int getHeaderY(){
        return headerY;
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
