import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sokudo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sokudo extends Character
{
    private int headerX = 295;
    private int headerY = 90;

    private double defIgnorePercent;

    private final String skill1Name="Temporal Void";
    private final int skill1Type=1;
    private int skill1StacksRequired = 5;
    private double skill1defIgnorePercentIncrease;

    private final String skill2Name="Chaos Overlimit";
    private final int skill2Type=2;
    private int skill2HitCount = 1; //Quitar
    private double skill2AtkUsedPercent = 0.8; //Quitar
    private int skill2SpCost = 35; //Quitar

    private final String skill3Name="Warp Strike";
    private final int skill3Type=1;
    private int skill3HitCount;
    private double skill3AtkUsedPercent;

    private final String skill4Name="Static Charge";
    private final int skill4Type=2;
    private double skill4DamageMultiplier = 1.5;
    private int skill4SpCost = 5;

    private GreenfootImage sprite = new GreenfootImage("images/character_sprites/01/01_sideidle.png");

    public Sokudo()
    {
        id=1;
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
        baseAtk=4;
        atk=4;
        hitCount=2;
        baseDef=2;
        def=2;
        ultQuantity=5;
        maxSP=90;
        sp=90;
        baseSpeed=10;
        speed=10;

        defIgnorePercent=0;

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
                    skill1StacksRequired=8;
                    skill1defIgnorePercentIncrease=0.05;
                    break;
                case 2:
                    skill1StacksRequired=7;
                    skill1defIgnorePercentIncrease=0;
                    break;
                case 3:
                    skill1StacksRequired=7;
                    skill1defIgnorePercentIncrease=0.05;
                    break;
                case 4:
                    skill1StacksRequired=6;
                    skill1defIgnorePercentIncrease=0.05;
                    break;
                case 5:
                    skill1StacksRequired=6;
                    skill1defIgnorePercentIncrease=0;
                    break;
                case 6:
                    skill1StacksRequired=6;
                    skill1defIgnorePercentIncrease=0.05;
                    break;
                case 7:
                    skill1StacksRequired=5;
                    skill1defIgnorePercentIncrease=0;
                    break;
            }
            defIgnorePercent+=skill1defIgnorePercentIncrease;
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
                    skill2HitCount=1;
                    skill2AtkUsedPercent=0.8;
                    skill2SpCost=35;
                    break;
                case 2:
                    skill2HitCount=1;
                    skill2AtkUsedPercent=1;
                    skill2SpCost=35;
                    break;
                case 3:
                    skill2HitCount=1;
                    skill2AtkUsedPercent=1.1;
                    skill2SpCost=35;
                    break;
                case 4:
                    skill2HitCount=1;
                    skill2AtkUsedPercent=1.2;
                    skill2SpCost=35;
                    break;
                case 5:
                    skill2HitCount=2;
                    skill2AtkUsedPercent=1.3;
                    skill2SpCost=30;
                    break;
                case 6:
                    skill2HitCount=2;
                    skill2AtkUsedPercent=1.4;
                    skill2SpCost=30;
                    break;
                case 7:
                    skill2HitCount=2;
                    skill2AtkUsedPercent=1.5;
                    skill2SpCost=30;
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
                    skill3HitCount=1;
                    skill3AtkUsedPercent=0.4;
                    break;
                case 2:
                    skill3HitCount=1;
                    skill3AtkUsedPercent=0.42;
                    break;
                case 3:
                    skill3HitCount=1;
                    skill3AtkUsedPercent=0.43;
                    break;
                case 4:
                    skill3HitCount=1;
                    skill3AtkUsedPercent=0.44;
                    break;
                case 5:
                    skill3HitCount=1;
                    skill3AtkUsedPercent=0.46;
                    break;
                case 6:
                    skill3HitCount=1;
                    skill3AtkUsedPercent=0.48;
                    break;
                case 7:
                    skill3HitCount=2;
                    skill3AtkUsedPercent=0.5;
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
                    skill4DamageMultiplier=1.2;
                    skill4SpCost=5;
                    break;
                case 2:
                    skill4DamageMultiplier=1.3;
                    skill4SpCost=5;
                    break;
                case 3:
                    skill4DamageMultiplier=1.4;
                    skill4SpCost=5;
                    break;
                case 4:
                    skill4DamageMultiplier=1.5;
                    skill4SpCost=10;
                    break;
                case 5:
                    skill4DamageMultiplier=2;
                    skill4SpCost=10;
                    break;
                case 6:
                    skill4DamageMultiplier=2.5;
                    skill4SpCost=10;
                    break;
                case 7:
                    skill4DamageMultiplier=3;
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

    public String getSkill1Stats(){
        if(skill1 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Defense % ignore: " + (defIgnorePercent*100) + "%";
    }

    public String getSkill2Stats(){
        if(skill2 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Attack % used: " + (skill2AtkUsedPercent*100) + "%";
    }

    public String getSkill3Stats(){
        if(skill3 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Attack % used: " + (skill3AtkUsedPercent*100) + "%";
    }

    public String getSkill4Stats(){
        if(skill4 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Damage multiplier: +" + (skill4DamageMultiplier*100) + "%";
    }

    public String getName(){
        return "Sokudo";
    }

    public void activateSkill1(){

    }

    public void activateSkill2(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.chaosOverlimit();
    }

    public void activateSkill3(){

    }

    public void activateSkill4(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.staticCharge();
    }

    public int getStacksRequired(){
        return skill1StacksRequired;
    }

    public int getSkill2HitCount(){
        return skill2HitCount;
    }

    public double getSkill2AtkUsedPercent(){
        return skill2AtkUsedPercent;
    }

    public int getSkill2SpCost(){
        return skill2SpCost;
    }

    public double getSkill4DamageMultiplier(){
        return skill4DamageMultiplier;
    }

    public int getSkill4SpCost(){
        return skill4SpCost;
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
