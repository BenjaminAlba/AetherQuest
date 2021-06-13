import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Character extends Actor implements CharacterNameProvider
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    protected int id;
    protected int requiredExp = 20;
    protected int currentExp;
    protected int lvl;
    protected int skillPoints;
    protected int baseHp;
    protected int maxHP;
    protected int hp;
    protected int baseAtk;
    protected int atk;
    protected int hitCount;
    protected int baseDef;
    protected int def;
    protected int ultCharges;
    protected int ultQuantity;
    protected int maxSP;
    protected int sp;
    protected double baseSpeed;
    protected int speed;
    protected int skill1;
    protected int skill2;
    protected int skill3;
    protected int skill4;
    protected boolean healFlag;

    public void act() 
    {
        // Add your action code here.
    }  

    public int getId(){
        return id;
    }

    public int getLvl(){
        return lvl;
    }

    public int getAtk(){
        return atk;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxHp(){
        return maxHP;
    }

    public int getSp(){
        return sp;
    }

    public int getMaxSp(){
        return maxSP;
    }

    public int getDefense(){
        return def;
    }

    public int getSpeed(){
        return speed;
    }
    
    public int getSkill1Lvl(){
        return skill1;
    }

    public int getSkill2Lvl(){
        return skill2;
    }

    public int getSkill3Lvl(){
        return skill3;
    }

    public int getSkill4Lvl(){
        return skill4;
    }
    
    public int getSkillPoints(){
        return skillPoints;
    }
    
    public int getHitCount(){
        return hitCount;
    }
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public void setXp(int xp)
    {
        this.currentExp = xp;
    }
    
    public int getXp()
    {
        return currentExp;
    }
    
    public void levelUp()
    {
        if(currentExp>=requiredExp)
        {
            lvl+=1;
            requiredExp=(int)Math.floor(20*Math.pow((double)lvl,1.5));
            def=(int)Math.ceil(((baseDef*(lvl-1))/2)+2);
            if(hp>0)
            {
                hp=maxHP=(int)Math.ceil((baseHp*(lvl-1))+8);
            }else
                maxHP=(int)Math.ceil((baseHp*(lvl-1))+8);
            speed=(int)Math.floor(baseSpeed+(((baseSpeed*(lvl-1)))/(((baseSpeed)+lvl)/2))+3);
            atk=(int)Math.ceil((baseAtk*lvl)-(((baseAtk+1)*(lvl/2))/2));
            switch(id)
            {
                case 1:
                if(lvl<8)
                {
                    hitCount=2;
                }else if(lvl>=8 && lvl<16)
                {
                    hitCount=3;
                }else
                    hitCount=4;
                break;
                case 2:
                if(lvl<18)
                {
                    hitCount=1;
                }else
                    hitCount=2;
                break;
                case 3:
                if(lvl<18)
                {
                    hitCount=1;
                }else
                    hitCount=2;
                break;
                case 4:
                if(lvl<18)
                {
                    hitCount=1;
                }else
                    hitCount=2;
                break;
                case 5:
                if(lvl<18)
                {
                    hitCount=1;
                }else
                    hitCount=2;
                break;
                case 6:
                hitCount=1;
                break;
                case 7:
                hitCount=1;
                break;
                case 8:
                if(lvl<14)
                {
                    hitCount=1;
                }else
                    hitCount=2;
                break;
            }
        }
    }
    
    public abstract String getSkill1Stats();
    
    public abstract String getSkill2Stats();
    
    public abstract String getSkill3Stats();
    
    public abstract String getSkill4Stats();
    
    public abstract String getSkill1Name();

    public abstract String getSkill2Name();

    public abstract String getSkill3Name();

    public abstract String getSkill4Name();
    
    public abstract void upgradeS1();
    
    public abstract void upgradeS2();
    
    public abstract void upgradeS3();
    
    public abstract void upgradeS4();
    
}
