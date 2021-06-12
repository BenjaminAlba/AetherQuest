import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_02.png");
    public Enemy2()
    {
        id = 2;
        name = "Lil' Pump";
        hp = 20;
        maxHp = 20;
        atk = Math.floor(Math.random()*(6-4+1)+4);
        def = Math.floor(Math.random()*(2-1+1)+1);
        yieldXp = 4;
        yieldMoney = 7;
        speed = Math.floor(Math.random()*(6-5+1)+5);
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
    
    public void act(){
        super.act();
    }
}
