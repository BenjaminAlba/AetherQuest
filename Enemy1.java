import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_01.png");
    public Enemy1()
    {
        //Math.floor(Math.random()*(max-min+1)+min)
        id = 1;
        name = "Goblin";
        hp = 12;
        maxHp = 12;
        atk = Math.floor(Math.random()*(4-3+1)+3);
        def = Math.floor(Math.random()*(1-0+1)+0);
        yieldXp = 2;
        yieldMoney = 5;
        speed = Math.floor(Math.random()*(4-3+1)+3);
        hitCount = 1;
        
        temporalVoidStack=0;
        isParalyzed=false;
        isPoisoned=false;
        poisonActiveTurns=0;
        isAggroed=false;
        memberAggro=0;
        aggroActiveTurns=0;
        hasDarkSigil=false;
        
        sprite.scale(sprite.getWidth()+100, sprite.getHeight()+100);
        sprite.mirrorHorizontally();
        setImage(sprite);
    }
    
    public void act() 
    {
        super.act();
    }    
}
