/**
 * Write a description of class Enemy8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy8 extends Enemy
{
    //private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_08.png");
    public Enemy8()
    {
        id = 8;
        name = "EGGMG";
        hp = 250;
        maxHp = 250;
        atk = Math.floor(Math.random()*(24-20+1)+20);
        def = Math.floor(Math.random()*(12-8+1)+8);
        yieldXp = 6;
        yieldMoney = 10;
        speed = Math.floor(Math.random()*(10-9+1)+9);
        hitCount = 1;

        temporalVoidStack=0;
        isParalyzed=false;
        isPoisoned=false;
        poisonActiveTurns=0;
        isAggroed=false;
        memberAggro=0;
        aggroActiveTurns=0;
        hasDarkSigil=false;

        /*sprite.scale(sprite.getWidth()+100, sprite.getHeight()+100);
        sprite.mirrorHorizontally();
        setImage(sprite);*/
    }
    
    public void act(){
        super.act();
    }
}
