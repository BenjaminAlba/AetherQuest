import greenfoot.*;
/**
 * Write a description of class Enemy9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy9 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_09.png");
    public Enemy9()
    {
        id = 9;
        name = "El jajas";
        hp = 300;
        maxHp = 300;
        atk = Math.floor(Math.random()*(28-24+1)+24);
        def = Math.floor(Math.random()*(15-8+1)+8);
        yieldXp = 6;
        yieldMoney = 10;
        speed = Math.floor(Math.random()*(12-10+1)+10);
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
