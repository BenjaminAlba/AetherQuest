import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class M1K3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mike extends Character
{
    private int headerX = 305;
    private int headerY = 90;

    private double defScalingPercent;

    private final String skill1Name="King's Shield";
    private final int skill1Type=2;
    private double skill1DamageTakenMultiplier;
    private int skill1ActiveTurns;
    private int skill1SpCost;

    private final String skill2Name="All Eyez On Me";
    private final int skill2Type=2;
    private int skill2ActiveTurns;
    private int skill2SpCost;

    private final String skill3Name="Shield Bash";
    private final int skill3Type=1;
    private double skill3DefScalingPercentIncrease;

    private final String skill4Name="Fighters Physique";
    private final int skill4Type=1;
    private double skill4BaseSpdIncrease;

    private GreenfootImage sprite = new GreenfootImage("images/character_sprites/04/04_sideidle.png");

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
                    skill1DamageTakenMultiplier=1.5;
                    skill1ActiveTurns=1;
                    skill1SpCost=10;
                    break;
                case 2:
                    skill1DamageTakenMultiplier=1.45;
                    skill1ActiveTurns=1;
                    skill1SpCost=10;
                    break;
                case 3:
                    skill1DamageTakenMultiplier=1.4;
                    skill1ActiveTurns=1;
                    skill1SpCost=10;
                    break;
                case 4:
                    skill1DamageTakenMultiplier=1.35;
                    skill1ActiveTurns=1;
                    skill1SpCost=15;
                    break;
                case 5:
                    skill1DamageTakenMultiplier=1.3;
                    skill1ActiveTurns=1;
                    skill1SpCost=15;
                    break;
                case 6:
                    skill1DamageTakenMultiplier=1.25;
                    skill1ActiveTurns=1;
                    skill1SpCost=20;
                    break;
                case 7:
                    skill1DamageTakenMultiplier=1.2;
                    skill1ActiveTurns=1;
                    skill1SpCost=20;
                    break;
            }
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
                    skill2ActiveTurns=1;
                    skill2SpCost=7;
                    break;
                case 2:
                    skill2ActiveTurns=1;
                    skill2SpCost=7;
                    break;
                case 3:
                    skill2ActiveTurns=1;
                    skill2SpCost=7;
                    break;
                case 4:
                    skill2ActiveTurns=2;
                    skill2SpCost=10;
                    break;
                case 5:
                    skill2ActiveTurns=2;
                    skill2SpCost=10;
                    break;
                case 6:
                    skill2ActiveTurns=2;
                    skill2SpCost=10;
                    break;
                case 7:
                    skill2ActiveTurns=3;
                    skill2SpCost=14;
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
                    skill3DefScalingPercentIncrease=0.1;
                    break;
                case 2:
                    skill3DefScalingPercentIncrease=0.15;
                    break;
                case 3:
                    skill3DefScalingPercentIncrease=0.15;
                    break;
                case 4:
                    skill3DefScalingPercentIncrease=0.15;
                    break;
                case 5:
                    skill3DefScalingPercentIncrease=0.15;
                    break;
                case 6:
                    skill3DefScalingPercentIncrease=0.15;
                    break;
                case 7:
                    skill3DefScalingPercentIncrease=0.15;
                    break;
            }
            defScalingPercent+=skill3DefScalingPercentIncrease;
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
                    skill4BaseSpdIncrease=0.2;
                    break;
                case 2:
                    skill4BaseSpdIncrease=0.1;
                    break;
                case 3:
                    skill4BaseSpdIncrease=0.1;
                    break;
                case 4:
                    skill4BaseSpdIncrease=0.2;
                    break;
                case 5:
                    skill4BaseSpdIncrease=0.2;
                    break;
                case 6:
                    skill4BaseSpdIncrease=0.2;
                    break;
                case 7:
                    skill4BaseSpdIncrease=0.2;
                    break;
            }
            baseSpeed+=skill4BaseSpdIncrease;
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
        return "Damage taken multiplier: " + (skill1DamageTakenMultiplier*100) + "%";
    }

    public String getSkill2Stats(){
        if(skill2 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Active turns: " + skill2ActiveTurns;
    }

    public String getSkill3Stats(){
        if(skill3 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Defense scaling %: " + (defScalingPercent) + "%";
    }

    public String getSkill4Stats(){
        if(skill4 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Speed increase: +" + baseSpeed;
    }

    public void activateSkill1(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.kingShield();
    }

    public void activateSkill2(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.allEyezOnMe();
    }

    public void activateSkill3(){

    }

    public void activateSkill4(){

    }

    public String getName(){
        return "M1K3";
    }

    public int getHeaderX(){
        return headerX;
    }

    public int getHeaderY(){
        return headerY;
    }

    public double getDamageTakenMultiplier(){
        return skill1DamageTakenMultiplier;
    }

    public int getSkill1ActiveTurns(){
        return skill1ActiveTurns;
    }

    public int getSkill1SpCost(){
        return skill1SpCost;
    }

    public int getSkill2ActiveTurns(){
        return skill2ActiveTurns;
    }

    public int getSkill2SpCost(){
        return skill2SpCost;
    }

    public double getDefScalingPercent(){
        return defScalingPercent;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
