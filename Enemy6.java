import greenfoot.*;
/**
 * Write a description of class Enemy6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy6 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_06.png");
    public Enemy6()
    {
        id = 6;
        name = "President";
        hp = 160;
        maxHp = 160;
        atk = Math.floor(Math.random()*(16-10+1)+10);
        def = Math.floor(Math.random()*(7-4+1)+4);
        yieldXp = 6;
        yieldMoney = 10;
        speed = Math.floor(Math.random()*(9-7+1)+7);
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
        setImage(sprite);
    }
}
