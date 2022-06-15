import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_03.png");
    public Enemy3()
    {
        id = 3;
        name = "John Salchichon";
        hp = 30;
        maxHp = 30;
        atk = Math.floor(Math.random()*(8-5+1)+10);
        def = Math.floor(Math.random()*(3-2+1)+2);
        yieldXp = 6;
        yieldMoney = 10;
        speed = Math.floor(Math.random()*(8-6+1)+6);
        hitCount = 2;
        
        temporalVoidStack=0;
        isParalyzed=false;
        isPoisoned=false;
        poisonActiveTurns=0;
        isAggroed=false;
        memberAggro=0;
        aggroActiveTurns=0;
        hasDarkSigil=false;
        
        sprite.scale(sprite.getWidth()+100, sprite.getHeight()+100);
        setImage(sprite);
    }
}
