import greenfoot.*;
/**
 * Write a description of class Enemy5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy5 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_05.png");
    public Enemy5()
    {
        id = 5;
        name = "Mk Leo";
        hp = 100;
        maxHp = 100;
        atk = Math.floor(Math.random()*(12-8+1)+8);
        def = Math.floor(Math.random()*(7-5+1)+5);
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
        sprite.mirrorHorizontally();
        setImage(sprite);
    }
    
    public void act(){
        super.act();
    }
}
