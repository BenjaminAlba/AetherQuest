/**
 * Write a description of class FirstFloorRoomFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstFloorEnemyFactory implements EnemyFactory
{
    private Enemy enemy;
    private Party party;
    
    public FirstFloorEnemyFactory()
    {
        party = Party.getInstance();
    }
    
    public Enemy createEnemy()
    {
        double spawnRate = Math.floor(Math.random()*(10-1+1)+1);
        if(party.getMember1().getLvl() <= 2)
        {
            if(spawnRate <= 8)
            {
                enemy = new Enemy1();
            }
            else
                enemy = new Enemy2();
        }
        else if(party.getMember1().getLvl() <= 4)
        {
            if(spawnRate <= 5)
            {
                enemy = new Enemy1();
            }
            else if(spawnRate <= 9)
            {
                enemy = new Enemy2();
            }
            else
                enemy = new Enemy3();
        }
        else if(party.getMember1().getLvl() <= 6)
        {
            if(spawnRate <= 2)
            {
                enemy = new Enemy1();
            }
            else if(spawnRate <= 8)
            {
                enemy = new Enemy2();
            }
            else
                enemy = new Enemy3();
        }
        else
        {
            enemy = new Enemy1();
        }
        return enemy;
    }
}
