/**
 * Write a description of class ThirdFloorEnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdFloorEnemyFactory implements EnemyFactory
{
    private Enemy enemy;
    private Party party;
    
    public ThirdFloorEnemyFactory()
    {
        party = Party.getInstance();
    }
    
    public Enemy createEnemy()
    {
        double spawnRate = Math.floor(Math.random()*(10-1+1)+1);
        if(party.getMember1().getLvl() <= 14)
        {
            if(spawnRate <= 8)
            {
                enemy = new Enemy7();
            }
            else
                enemy = new Enemy8();
        }
        else if(party.getMember1().getLvl() <= 16)
        {
            if(spawnRate <= 5)
            {
                enemy = new Enemy7();
            }
            else if(spawnRate <= 9)
            {
                enemy = new Enemy8();
            }
            else
                enemy = new Enemy9();
        }
        else if(party.getMember1().getLvl() <= 18)
        {
            if(spawnRate <= 2)
            {
                enemy = new Enemy7();
            }
            else if(spawnRate <= 8)
            {
                enemy = new Enemy8();
            }
            else
                enemy = new Enemy9();
        }
        else
        {
            enemy = new Enemy7();
        }
        return enemy;
    }
}
