import greenfoot.*;
/**
 * Write a description of class Enemy7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy7 extends Enemy
{
    private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_07.png");
    public Enemy7()
    {
        id = 7;
        name = "Girlrilla";
        hp = 200;
        maxHp = 200;
        atk = Math.floor(Math.random()*(18-10+1)+35);
        def = Math.floor(Math.random()*(10-8+1)+35);
        yieldXp = 6;
        yieldMoney = 10;
        speed = Math.floor(Math.random()*(10-9+1)+9);
        hitCount = 6;
        
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
