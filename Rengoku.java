import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rengoku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rengoku extends Character
{
    private int headerX = 290;
    private int headerY = 90;
    
    private double holyFlameHpDamagePercent;
    
    private final String skill1Name="Holy Flame";
    private final int skill1Type=1;
    private double skill1HolyFlameHpDamagePercentIncrease;
    
    private final String skill2Name="Prayer";
    private final int skill2Type=2;
    private double skill2AllyHpRecoveryPercent;
    private int skill2SpCost;
    
    private final String skill3Name="Entreat";
    private final int skill3Type=2;
    private double skill3AtkMultiplier;
    private int skill3SpCost;
    
    private final String skill4Name="Cheer";
    private final int skill4Type=2;
    private double skill4DefMultiplier;
    private int skill4SpCost;
    
    private GreenfootImage sprite = new GreenfootImage("images/character_sprites/05/05_sideidle.png");

    public Rengoku()
    {
        id=5;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=true;
        
        baseHp=8;
        hp=8;
        maxHP=8;
        hpBarrier = 0;
        baseAtk=2;
        atk=2;
        hitCount=1;
        baseDef=2;
        def=2;
        baseSpr=4;
        spr=4;
        ultQuantity=3;
        maxSP=100;
        sp=100;
        baseSpeed=8;
        speed=8;
        damageType = 1;
        
        holyFlameHpDamagePercent=0;
        
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
                    skill1HolyFlameHpDamagePercentIncrease=0.05;
                    break;
                case 2:
                    skill1HolyFlameHpDamagePercentIncrease=0.02;
                    break;
                case 3:
                    skill1HolyFlameHpDamagePercentIncrease=0.01;
                    break;
                case 4:
                    skill1HolyFlameHpDamagePercentIncrease=0.02;
                    break;
                case 5:
                    skill1HolyFlameHpDamagePercentIncrease=0.02;
                    break;
                case 6:
                    skill1HolyFlameHpDamagePercentIncrease=0.01;
                    break;
                case 7:
                    skill1HolyFlameHpDamagePercentIncrease=0.02;
                    break;
            }
            holyFlameHpDamagePercent+=skill1HolyFlameHpDamagePercentIncrease;
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
                    skill2AllyHpRecoveryPercent=0.1;
                    skill2SpCost=4;
                    break;
                case 2:
                    skill2AllyHpRecoveryPercent=0.14;
                    skill2SpCost=6;
                    break;
                case 3:
                    skill2AllyHpRecoveryPercent=0.18;
                    skill2SpCost=8;
                    break;
                case 4:
                    skill2AllyHpRecoveryPercent=0.25;
                    skill2SpCost=10;
                    break;
                case 5:
                    skill2AllyHpRecoveryPercent=0.30;
                    skill2SpCost=14;
                    break;
                case 6:
                    skill2AllyHpRecoveryPercent=0.35;
                    skill2SpCost=16;
                    break;
                case 7:
                    skill2AllyHpRecoveryPercent=0.40;
                    skill2SpCost=20;
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
                    skill3AtkMultiplier=0.2;
                    skill3SpCost=4;
                    break;
                case 2:
                    skill3AtkMultiplier=0.22;
                    skill3SpCost=6;
                    break;
                case 3:
                    skill3AtkMultiplier=0.24;
                    skill3SpCost=8;
                    break;
                case 4:
                    skill3AtkMultiplier=0.26;
                    skill3SpCost=10;
                    break;
                case 5:
                    skill3AtkMultiplier=0.3;
                    skill3SpCost=12;
                    break;
                case 6:
                    skill3AtkMultiplier=0.35;
                    skill3SpCost=12;
                    break;
                case 7:
                    skill3AtkMultiplier=0.4;
                    skill3SpCost=15;
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
                    skill4DefMultiplier=0.2;
                    skill4SpCost=4;
                    break;
                case 2:
                    skill4DefMultiplier=0.22;
                    skill4SpCost=6;
                    break;
                case 3:
                    skill4DefMultiplier=0.24;
                    skill4SpCost=8;
                    break;
                case 4:
                    skill4DefMultiplier=0.26;
                    skill4SpCost=10;
                    break;
                case 5:
                    skill4DefMultiplier=0.3;
                    skill4SpCost=12;
                    break;
                case 6:
                    skill4DefMultiplier=0.35;
                    skill4SpCost=12;
                    break;
                case 7:
                    skill4DefMultiplier=0.4;
                    skill4SpCost=15;
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
        return "Hp damage %: " + (holyFlameHpDamagePercent*100) + "%";
    }
    
    public String getSkill2Stats(){
        if(skill2 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Ally Hp recovery %: " + (skill2AllyHpRecoveryPercent*100) + "%";
    }
    
    public String getSkill3Stats(){
        if(skill3 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Attack Multiplier: " + (skill3AtkMultiplier*100) + "%";
    }
    
    public String getSkill4Stats(){
        if(skill4 == 0)
            return "Mejora esta habilidad para poder usarla";
        return "Defense multiplier: " + (skill4DefMultiplier*100) + "%";
    }
    
    public int getSkill2SpCost(){
        return skill2SpCost;
    }
    
    public int getSkill3SpCost(){
        return skill3SpCost;
    }
    
    public int getSkill4SpCost(){
        return skill4SpCost;
    }
    
    public double getHolyFlameHpDamagePercent(){
        return holyFlameHpDamagePercent;
    }
    
    public double getSkill2AllyHpRecoveryPercent(){
        return skill2AllyHpRecoveryPercent;
    }
    
    public double getSkill3AtkMultiplier(){
        return skill3AtkMultiplier;
    }
    
    public double getSkill4DefMultiplier(){
        return skill4DefMultiplier;
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
        return "Rengoku";
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
