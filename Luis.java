import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Luis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Luis extends Character
{
    private int headerX = 320;
    private int headerY = 90;
    
    private double acquiredMoneyMultiplier;
    private double itemDamageMultiplier;
    private int negateItemConsumptionRate;
    
    private final String skill1Name="Keen eye";
    private final int skill1Type=1;
    private double skill1AcquiredMoneyMultiplierIncrease;
    
    private final String skill2Name="Business Experience";
    private final int skill2Type=2;
    private double skill2ItemDamageMultiplierIncrease;
    
    private final String skill3Name="Crunching Numbers";
    private final int skill3Type=2;
    private int skill3NegateItemConsumptionRateIncrease;
    
    private final String skill4Name="Final Gamble";
    private final int skill4Type=2;
    private double skill4SelfHpDamagePercent;
    private double skill4HpDamagePercent;
    private int skill4SpCost;
    
    private GreenfootImage sprite = new GreenfootImage("images/character_sprites/07/07_sideidle.png");

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
                    skill1AcquiredMoneyMultiplierIncrease=0.1;
                    break;
                case 2:
                    skill1AcquiredMoneyMultiplierIncrease=0.1;
                    break;
                case 3:
                    skill1AcquiredMoneyMultiplierIncrease=0.1;
                    break;
                case 4:
                    skill1AcquiredMoneyMultiplierIncrease=0.05;
                    break;
                case 5:
                    skill1AcquiredMoneyMultiplierIncrease=0.05;
                    break;
                case 6:
                    skill1AcquiredMoneyMultiplierIncrease=0.05;
                    break;
                case 7:
                    skill1AcquiredMoneyMultiplierIncrease=0.05;
                    break;
            }
            acquiredMoneyMultiplier+=skill1AcquiredMoneyMultiplierIncrease;
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
                    skill2ItemDamageMultiplierIncrease=0.3;
                    break;
                case 2:
                    skill2ItemDamageMultiplierIncrease=0.3;
                    break;
                case 3:
                    skill2ItemDamageMultiplierIncrease=0.2;
                    break;
                case 4:
                    skill2ItemDamageMultiplierIncrease=0.2;
                    break;
                case 5:
                    skill2ItemDamageMultiplierIncrease=0.5;
                    break;
                case 6:
                    skill2ItemDamageMultiplierIncrease=0.3;
                    break;
                case 7:
                    skill2ItemDamageMultiplierIncrease=0.2;
                    break;
            }
            itemDamageMultiplier+=skill2ItemDamageMultiplierIncrease;
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
                    skill3NegateItemConsumptionRateIncrease=10;
                    break;
                case 2:
                    skill3NegateItemConsumptionRateIncrease=10;
                    break;
                case 3:
                    skill3NegateItemConsumptionRateIncrease=10;
                    break;
                case 4:
                    skill3NegateItemConsumptionRateIncrease=5;
                    break;
                case 5:
                    skill3NegateItemConsumptionRateIncrease=5;
                    break;
                case 6:
                    skill3NegateItemConsumptionRateIncrease=5;
                    break;
                case 7:
                    skill3NegateItemConsumptionRateIncrease=5;
                    break;
            }
            negateItemConsumptionRate+=skill3NegateItemConsumptionRateIncrease;
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
                    skill4SelfHpDamagePercent=0.3;
                    skill4HpDamagePercent=0.3;
                    skill4SpCost=50;
                    break;
                case 2:
                    skill4SelfHpDamagePercent=0.35;
                    skill4HpDamagePercent=0.35;
                    skill4SpCost=45;
                    break;
                case 3:
                    skill4SelfHpDamagePercent=0.4;
                    skill4HpDamagePercent=0.4;
                    skill4SpCost=40;
                    break;
                case 4:
                    skill4SelfHpDamagePercent=0.5;
                    skill4HpDamagePercent=0.5;
                    skill4SpCost=35;
                    break;
                case 5:
                    skill4SelfHpDamagePercent=0.6;
                    skill4HpDamagePercent=0.6;
                    skill4SpCost=30;
                    break;
                case 6:
                    skill4SelfHpDamagePercent=0.8;
                    skill4HpDamagePercent=0.8;
                    skill4SpCost=25;
                    break;
                case 7:
                    skill4SelfHpDamagePercent=1;
                    skill4HpDamagePercent=1;
                    skill4SpCost=20;
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
        return "Money multiplier: " + (acquiredMoneyMultiplier*100) + "%";
    }
    
    public String getSkill2Stats(){
        if(skill2 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Item damage multiplier: " + (itemDamageMultiplier*100) + "%";
    }
    
    public String getSkill3Stats(){
        if(skill3 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Preserve item rate: " + (negateItemConsumptionRate*100) + "%";
    }
    
    public String getSkill4Stats(){
        if(skill4 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Self damage %: " + (skill4SelfHpDamagePercent*100) + "%";
    }
    
    public void activateSkill1(){
        
    }
    
    public void activateSkill2(){
        
    }
    
    public void activateSkill3(){
        
    }
    
    public void activateSkill4(){
        
    }
    
    public String getName(){
        return "Luis";
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
