import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    protected int id;
    protected String name;
    protected int hp;
    protected int maxHp;
    protected double atk;
    protected double def;
    protected int yieldXp;
    protected int yieldMoney;
    protected double speed;
    protected int hitCount;
    
    protected int temporalVoidStack;
    protected boolean isParalyzed;
    
    protected boolean isPoisoned;
    protected int poisonActiveTurns;
    
    protected boolean isAggroed;
    protected int memberAggro;
    protected int aggroActiveTurns;
    
    protected boolean hasDarkSigil;
    
    public Enemy()
    {
    }
    
    public int getTemporalVoidStack()
    {
        return temporalVoidStack;
    }
    
    public boolean getIsParalyzed()
    {
        return isParalyzed;
    }
    
    public boolean getIsPoisoned()
    {
        return isPoisoned;
    }
    
    public int getPoisonActiveTurns()
    {
        return poisonActiveTurns;
    }
    
    public boolean getHasDarkSigil()
    {
        return hasDarkSigil;
    }
    
    public int setId(int id)
    {
        this.id=id;
        return id;
    }
    
    public int setHp(int hp)
    {
        this.hp=hp;
        return hp;
    }
    
    public int setMaxHp(int maxHp)
    {
        this.maxHp=maxHp;
        return maxHp;
    }
    
    public double setAtk(double atk)
    {
        this.atk=atk;
        return atk;
    }
    
    public double setDef(double def)
    {
        this.def=def;
        return def;
    }
    
    public int setYieldXp(int yieldXp)
    {
        this.yieldXp=yieldXp;
        return yieldXp;
    }
    
    public int setYieldMoney(int yieldMoney)
    {
        this.yieldMoney=yieldMoney;
        return yieldMoney;
    }
    
    public double setSpeed(double speed)
    {
        this.speed = speed;
        return speed;
    }
    
    public int setHitCount(int hitCount)
    {
        this.hitCount = hitCount;
        return hitCount;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHp()
    {
        return hp;
    }
    
    public int getMaxHp()
    {
        return maxHp;
    }
    
    public double getAtk()
    {
        return atk;
    }
    
    public double getDef()
    {
        return def;
    }
    
    public int getYieldXp()
    {
        return yieldXp;
    }
    
    public int getYieldMoney()
    {
        return yieldMoney;
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            BattleEnvironment battleWorld = (BattleEnvironment)getWorld();
            battleWorld.changeTarget(this);
        }
    }    
}
