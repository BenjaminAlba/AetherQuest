import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int id;
    private static final int requiredExp = 20;
    private int currentExp;
    private int lvl;
    private int skillPoints;
    private int baseHp;
    private int maxHP;
    private int hp;
    private int baseAtk;
    private int atk;
    private int hitCount;
    private int baseDef;
    private int def;
    private int ultCharges;
    private int ultQuantity;
    private int sp;
    private int baseSpeed;
    private int speed;
    private int skill1;
    private int skill2;
    private int skill3;
    private int skill4;
    
    public Character(int id)
    {
        this.id=id;
        lvl=1;
        currentExp=0;
        skillPoints=1;
        ultCharges=0;
        skill1=0;
        skill2=0;
        skill3=0;
        skill4=0;
        
        switch(id)
        {
            case 1:
                baseHp=10;
                hp=10;
                maxHP=10;
                baseAtk=4;
                atk=4;
                hitCount=2;
                baseDef=2;
                def=2;
                ultQuantity=5;
                sp=90;
                baseSpeed=10;
                speed=10;
                break;
            case 2:
                baseHp=12;
                hp=12;
                maxHP=12;
                baseAtk=3;
                atk=3;
                hitCount=1;
                baseDef=2;
                def=2;
                ultQuantity=6;
                sp=100;
                baseSpeed=5;
                speed=5;
                break;
            case 3:
                baseHp=18;
                hp=18;
                maxHP=18;
                baseAtk=3;
                atk=3;
                hitCount=1;
                baseDef=3;
                def=3;
                ultQuantity=5;
                sp=70;
                baseSpeed=7;
                speed=7;
                break;
            case 4:
                baseHp=16;
                hp=16;
                maxHP=16;
                baseAtk=3;
                atk=3;
                hitCount=1;
                baseDef=4;
                def=4;
                ultQuantity=5;
                sp=70;
                baseSpeed=3;
                speed=3;
                break;
            case 5:
                baseHp=8;
                hp=8;
                maxHP=8;
                baseAtk=2;
                atk=2;
                hitCount=1;
                baseDef=2;
                def=2;
                ultQuantity=3;
                sp=100;
                baseSpeed=8;
                speed=8;
                break;
            case 6:
                baseHp=10;
                hp=10;
                maxHP=10;
                baseAtk=2;
                atk=2;
                hitCount=1;
                baseDef=2;
                def=2;
                ultQuantity=8;
                sp=70;
                baseSpeed=7;
                speed=7;
                break;
            case 7:
                baseHp=10;
                hp=10;
                maxHP=10;
                baseAtk=2;
                atk=2;
                hitCount=1;
                baseDef=2;
                def=2;
                ultQuantity=5;
                sp=70;
                baseSpeed=5;
                speed=5;
                break;
            case 8:
                baseHp=12;
                hp=12;
                maxHP=12;
                baseAtk=7;
                atk=7;
                hitCount=1;
                baseDef=2;
                def=2;
                ultQuantity=8;
                sp=0;
                baseSpeed=5;
                speed=5;
                break;
        }
    }
    
    
    public void act() 
    {
        // Add your action code here.
    }    
}
