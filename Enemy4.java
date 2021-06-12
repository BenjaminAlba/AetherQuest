/**
 * Write a description of class Enemy4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy4 extends Enemy
{
    //private GreenfootImage sprite = new GreenfootImage("images/enemy_sprites/enemy_04.png");
    public Enemy4()
    {
        id = 4;
        name = "Goblon";
        hp = 56;
        maxHp = 56;
        atk = Math.floor(Math.random()*(11-9+1)+9);
        def = Math.floor(Math.random()*(5-4+1)+4);
        yieldXp = 7;
        yieldMoney = 12;
        speed = Math.floor(Math.random()*(8-6+1)+6);
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
