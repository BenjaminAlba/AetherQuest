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
    protected static final int REQUIRED_EXP = 20;
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
    
    public void upgradeSkill1(){
        if(skill1<7 && skillPoints>0){
            skill1++;
            skillPoints--;
        }
    }
    
    public void upgradeSkill2(){
        if(skill2<7 && skillPoints>0){
            skill2++;
            skillPoints--;
        }
    }
    
    public void upgradeSkill3(){
        if(skill3<7 && skillPoints>0){
            skill3++;
            skillPoints--;
        }
    }
    
    public void upgradeSkill4(){
        if(skill4<7 && skillPoints>0){
            skill4++;
            skillPoints--;
        }
    }
    
    public int getSkillPoints(){
        return skillPoints;
    }
    
    public abstract String getSkill1Name();

    public abstract String getSkill2Name();

    public abstract String getSkill3Name();

    public abstract String getSkill4Name();
}
