/**
 * Write a description of class SecondFloorEnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondFloorEnemyFactory implements EnemyFactory
{
    private Enemy enemy;
    private Party party;
    
    public SecondFloorEnemyFactory()
    {
        party = Party.getInstance();
    }
    
    public Enemy createEnemy()
    {
        double spawnRate = Math.floor(Math.random()*(10-1+1)+1);
        if(party.getMember1().getLvl() <= 8)
        {
            if(spawnRate <= 8)
            {
                enemy = new Enemy4();
            }
            else
                enemy = new Enemy5();
        }
        else if(party.getMember1().getLvl() <= 10)
        {
            if(spawnRate <= 5)
            {
                enemy = new Enemy4();
            }
            else if(spawnRate <= 9)
            {
                enemy = new Enemy5();
            }
            else
                enemy = new Enemy6();
        }
        else if(party.getMember1().getLvl() <= 12)
        {
            if(spawnRate <= 2)
            {
                enemy = new Enemy4();
            }
            else if(spawnRate <= 8)
            {
                enemy = new Enemy5();
            }
            else
                enemy = new Enemy6();
        }
        else
        {
            enemy = new Enemy4();
        }
        return enemy;
    }
}
