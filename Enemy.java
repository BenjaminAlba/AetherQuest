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
    
    public void setTemporalVoidStack(int stack){
        temporalVoidStack = stack;
    }
    
    public void setParalysisStatus(boolean status){
        isParalyzed = status;
        temporalVoidStack = 0;
    }
    
    public boolean isParalyzed()
    {
        return isParalyzed;
    }
    
    public boolean isPoisoned()
    {
        return isPoisoned;
    }
    
    public void setPoisonStatus(boolean status){
        isPoisoned = status;
    }
    
    public int getPoisonActiveTurns()
    {
        return poisonActiveTurns;
    }
    
    public void setPoisonActiveTurns(int poisonTurns){
        poisonActiveTurns = poisonTurns;
    }
    
    public boolean hasDarkSigil()
    {
        return hasDarkSigil;
    }
    
    public void setDarkSigil(boolean status){
        hasDarkSigil = status;
    }
    
    public void setAggroState(boolean state){
        isAggroed = state;
    }
    
    public boolean isAggroed(){
        return isAggroed();
    }
    
    public int getAggroActiveTurns(){
        return aggroActiveTurns;
    }
    
    public void setId(int id)
    {
        this.id=id;
    }
    
    public void setHp(int hp)
    {
        this.hp=hp;
    }
    
    public void setMaxHp(int maxHp)
    {
        this.maxHp=maxHp;
    }
    
    public void setAtk(double atk)
    {
        this.atk=atk;
    }
    
    public void setDef(double def)
    {
        this.def=def;
    }
    
    public void setYieldXp(int yieldXp)
    {
        this.yieldXp=yieldXp;
    }
    
    public int getXp()
    {
        return yieldXp;
    }
    
    public void setYieldMoney(int yieldMoney)
    {
        this.yieldMoney=yieldMoney;
    }
    
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    
    public int getSpeed(){
        return (int)speed;
    }
    
    public void setHitCount(int hitCount)
    {
        this.hitCount = hitCount;
    }
    
    public int getHitCount()
    {
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
    
    public Enemy checkClick(){
        if(Greenfoot.mousePressed(this)){
            return this;
        }
        return null;
    }
    
    public void act() 
    {

    }    
}
