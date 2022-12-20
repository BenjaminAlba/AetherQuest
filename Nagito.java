import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nagito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nagito extends Character
{
    private int headerX = 305;
    private int headerY = 90;
    
    private int furyStack;
    private int cooldownTurns;
    private boolean cooldownHeal;
    private double markedEnemyDamageMultiplier;

    private final String skill1Name="Fleeting Moments";
    private final int skill1Type=1;

    private final String skill2Name="Bearer of the Dark Sigil";
    private final int skill2Type=1;

    private final String skill3Name="Boiling Blood";
    private final int skill3Type=2;
    private double skill3StackReleaseMultiplier;
    private int skill3SpCost;

    private final String skill4Name="Deep Breath";
    private final int skill4Type=2;
    private double skill4HpRecoveryMultiplier;
    private int skill4SpCost;

    private GreenfootImage sprite = new GreenfootImage("images/character_sprites/08/08_sideidle.png");

    public Nagito()
    {
        id=8;
        lvl=1;
        currentExp=0;
        skillPoints=0;
        ultCharges=8;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        healFlag=false;

        baseHp=12;
        hp=12;
        maxHP=12;
        hpBarrier = 0;
        baseAtk=7;
        atk=7;
        hitCount=1;
        baseDef=2;
        def=2;
        baseSpr=2;
        spr=2;
        ultQuantity=8;
        maxSP=0;
        sp=0;
        baseSpeed=5;
        speed=5;
        damageType = 0;

        furyStack=0;
        cooldownTurns=0;
        markedEnemyDamageMultiplier=0.6;
        cooldownHeal = false;
        
        skill3StackReleaseMultiplier=0.2;
        skill3SpCost=0;
        skill4HpRecoveryMultiplier=0.1;
        skill4SpCost=0;
        
        sprite.mirrorHorizontally();
        sprite.scale(sprite.getWidth()+100, sprite.getHeight()+100);
        
        setImage(sprite);
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
        return null;
    }

    public String getSkill2Stats(){
        return null;
    }

    public String getSkill3Stats(){
        return null;
    }

    public double getSkill3StackReleaseMultiplier(){
        return skill3StackReleaseMultiplier;
    }
    
    public double getMarkedEnemyDamageMultiplier(){
        return markedEnemyDamageMultiplier;
    }
    
    public void setFuryStacks(int stacks){
        furyStack = stacks;
    }
    
    public int getFuryStacks(){
        return furyStack;
    }
    
    public int getCooldownTurns(){
        return cooldownTurns;
    }
    
    public void setCooldownTurns(int cooldownTurns){
        this.cooldownTurns = cooldownTurns;
    }
    
    public boolean getCooldownHeal(){
        return cooldownHeal;
    }
    
    public void setCooldownHeal(boolean status){
        cooldownHeal = status;
    }
    
    public String getSkill4Stats(){
        return null;
    }
    
    public void upgradeS1(){}
    
    public void upgradeS2(){}
    
    public void upgradeS3(){}
    
    public void upgradeS4(){}
    
    public void activateSkill1(){
        
    }
    
    public void activateSkill2(){
        
    }
    
    public void activateSkill3(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.boilingBlood();
    }
    
    public void activateSkill4(){
        BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
        battleWorld.deepBreath();
    }
    
    public String getName(){
        return "Nagito";
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
