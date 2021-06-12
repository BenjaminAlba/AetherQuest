import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class BattleEnvironment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleEnvironment extends World
{
    private Party party = Party.getInstance();
    private Image member1;
    private Image member2;
    private Image member3; 
    private Image member4;

    private Image enemy1Image;
    private Image enemy2Image;
    private Image enemy3Image;
    private Image enemy4Image;

    private Image member1Sprite;
    private Image member2Sprite;
    private Image member3Sprite;
    private Image member4Sprite;

    private StatDisplay member1Name;
    private StatDisplay member2Name;
    private StatDisplay member3Name;
    private StatDisplay member4Name;

    private StatDisplay enemy1Name;
    private StatDisplay enemy2Name;
    private StatDisplay enemy3Name;
    private StatDisplay enemy4Name;

    private Bar member1Bar;
    private Bar member2Bar;
    private Bar member3Bar;
    private Bar member4Bar;

    private Bar enemy1Bar;
    private Bar enemy2Bar;
    private Bar enemy3Bar;
    private Bar enemy4Bar;

    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;

    private AttackButton attackButton = new AttackButton();
    private GreenfootSound attackSfx = new GreenfootSound("sounds/attack.mp3");

    private AttackAnimation attackAnimation = new AttackAnimation();

    public BattleEnvironment()
    {
        super(1280, 720, 1);
        setBackground("images/battle_backgrounds/battle_background_03.png");

        FirstFloorEnemyFactory firstFloorFactory = new FirstFloorEnemyFactory();
        enemy1 = firstFloorFactory.createEnemy();
        enemy2 = firstFloorFactory.createEnemy();
        enemy3 = firstFloorFactory.createEnemy();
        enemy4 = firstFloorFactory.createEnemy();

        enemy1Image = new Image("images/enemy_portraits/0"+enemy1.getId()+".gif");
        enemy2Image = new Image("images/enemy_portraits/0"+enemy2.getId()+".gif");
        enemy3Image = new Image("images/enemy_portraits/0"+enemy3.getId()+".gif");
        enemy4Image = new Image("images/enemy_portraits/0"+enemy4.getId()+".gif");

        member1Sprite = new Image("images/character_sprites/0"+party.getMember1().getId()+"/0"+party.getMember1().getId()+"_sideidle.png");
        member2Sprite = new Image("images/character_sprites/0"+party.getMember2().getId()+"/0"+party.getMember2().getId()+"_sideidle.png");
        member3Sprite = new Image("images/character_sprites/0"+party.getMember3().getId()+"/0"+party.getMember3().getId()+"_sideidle.png");
        member4Sprite = new Image("images/character_sprites/0"+party.getMember4().getId()+"/0"+party.getMember4().getId()+"_sideidle.png");

        member1Sprite.scale(100,100);
        member2Sprite.scale(100,100);
        member3Sprite.scale(100,100);
        member4Sprite.scale(100,100);

        member1 = new Image("images/character_portraits/0" + party.getMember1().getId() + ".gif");
        member2 = new Image("images/character_portraits/0" + party.getMember2().getId() + ".gif");
        member3 = new Image("images/character_portraits/0" + party.getMember3().getId() + ".gif");
        member4 = new Image("images/character_portraits/0" + party.getMember4().getId() + ".gif");

        member1.scale(-350,-350);
        member2.scale(-350,-350);
        member3.scale(-350,-350);
        member4.scale(-350,-350);

        addObject(member1, 135, 104);
        addObject(member2, 135, 273);
        addObject(member3, 135, 442);
        addObject(member4, 135, 611);

        addObject(enemy1Image, 1145, 104);
        addObject(enemy2Image, 1145, 273);
        addObject(enemy3Image, 1145, 442);
        addObject(enemy4Image, 1145, 611);

        enemy1Image.scale(-350,-350);
        enemy2Image.scale(-350,-350);
        enemy3Image.scale(-350,-350);
        enemy4Image.scale(-350,-350);

        displayCharacterSprites();
        displayPartyInfo();
        displayEnemyInfo();
        displayEnemySprites();
        addObject(attackButton, 640, 360);

        attackButton.setAgressor(party.getMember1());
        attackButton.setTarget(enemy1);
    }

    public void updateBattle(){
        removeObjects(getObjects(Image.class));
        removeObjects(getObjects(StatDisplay.class));
        removeObjects(getObjects(Button.class));
        removeObjects(getObjects(Enemy.class));
        removeObjects(getObjects(Bar.class));

        addObject(member1, 135, 104);
        addObject(member2, 135, 273);
        addObject(member3, 135, 442);
        addObject(member4, 135, 611);
        addObject(enemy1Image, 1145, 104);
        addObject(enemy2Image, 1145, 273);
        addObject(enemy3Image, 1145, 442);
        addObject(enemy4Image, 1145, 611);
        displayCharacterSprites();
        displayPartyInfo();
        displayEnemyInfo();
        displayEnemySprites();
        addObject(attackButton, 640, 360);
    }

    public void act(){
        showText("Hp: " + attackButton.getTarget().getHp(), 640, 200);
        showText("ID: " + attackButton.getAgressor().getId(), 640, 300);
        checkBattle();
    }

    public void attack(Character agressor, Enemy target){
        //addObject(attackAnimation,640,360);
        attackSfx.play();
        addObject(attackAnimation,target.getX(),target.getY());
        int damage = (int)((agressor.getAtk()-target.getDef())*agressor.getHitCount());
        target.setHp(target.getHp()-damage);
        if(target.getHp() < 0)
            target.setHp(0);
        changeAgressor(agressor);
    }

    public void changeAgressor(Character agressor){
        if(agressor == party.getMember1()){
            attackButton.setAgressor(party.getMember2());
        }
        else if(agressor == party.getMember2()){
            attackButton.setAgressor(party.getMember3());
        }
        else if(agressor == party.getMember3()){
            attackButton.setAgressor(party.getMember4());
        }
        else{
            attackButton.setAgressor(party.getMember1());
            enemyPartyAttack();
        }
    }

    public void enemyPartyAttack(){
        if(enemy1.getHp() > 0)
            enemyAttack(enemy1);
        if(enemy2.getHp() > 0)
            enemyAttack(enemy2);
        if(enemy3.getHp() > 0)
            enemyAttack(enemy3);
        if(enemy4.getHp() > 0)
            enemyAttack(enemy4);
    }

    public void enemyAttack(Enemy enemy){
        int drawRate = (int)(Math.random()*100+1);
        if((drawRate <= 25)){
            addObject(new AttackAnimation(),member1Sprite.getX(),member1.getY());
            party.getMember1().setHp(party.getMember1().getHp()-(int)(enemy.getAtk()-party.getMember1().getDefense())*enemy.getHitCount());
            if(party.getMember1().getHp()<0)
            {
                party.getMember1().setHp(0);
            }
        }
        else if(drawRate <= 50){
            addObject(new AttackAnimation(),member1Sprite.getX(),member2.getY());
            party.getMember2().setHp(party.getMember2().getHp()-(int)(enemy.getAtk()-party.getMember2().getDefense())*enemy.getHitCount());
            if(party.getMember2().getHp()<0)
            {
                party.getMember2().setHp(0);
            }
        }
        else if(drawRate <= 75){
            addObject(new AttackAnimation(),member1Sprite.getX(),member3.getY());
            party.getMember3().setHp(party.getMember3().getHp()-(int)(enemy.getAtk()-party.getMember3().getDefense())*enemy.getHitCount());
            if(party.getMember3().getHp()<0)
            {
                party.getMember3().setHp(0);
            }
        }
        else{
            addObject(new AttackAnimation(),member1Sprite.getX(),member4.getY());
            party.getMember4().setHp(party.getMember4().getHp()-(int)(enemy.getAtk()-party.getMember4().getDefense())*enemy.getHitCount());
            if(party.getMember4().getHp()<0)
            {
                party.getMember4().setHp(0);
            }
        }
    }

    public void displayPartyInfo()
    {
        if(party.getMember1().getHp()>0)
        {
            addObject(member1Name = new StatDisplay(party.getMember1().getName(),370,148),640,360);
            addObject(member1Bar = new Bar("HP","",party.getMember1().getHp(),party.getMember1().getMaxHp()), 435, 168);
            member1Bar.setBarWidth(80);
        }
        if(party.getMember2().getHp()>0)
        {
            addObject(member2Name = new StatDisplay(party.getMember2().getName(),370,281),640,360);
            addObject(member2Bar = new Bar("HP","",party.getMember2().getHp(),party.getMember2().getMaxHp()), 435, 301);
            member2Bar.setBarWidth(80);
        }
        if(party.getMember3().getHp()>0)
        {
            addObject(member3Name = new StatDisplay(party.getMember3().getName(),370,414),640,360);
            addObject(member3Bar = new Bar("HP","",party.getMember3().getHp(),party.getMember3().getMaxHp()), 435, 434);
            member3Bar.setBarWidth(80);
        }
        if(party.getMember4().getHp()>0)
        {
            addObject(member4Name = new StatDisplay(party.getMember4().getName(),370,547),640,360);
            addObject(member4Bar = new Bar("HP","",party.getMember4().getHp(),party.getMember4().getMaxHp()), 435, 567);
            member4Bar.setBarWidth(80);
        }
    }

    public void displayEnemyInfo()
    {
        if(enemy1.getHp()>0)
        {
            addObject(enemy1Name = new StatDisplay(enemy1.getName(),785,148),640,360);
            addObject(enemy1Bar = new Bar("HP","",enemy1.getHp(),enemy1.getMaxHp()), 860, 168);
            member1Bar.setBarWidth(80);
        }
        if(enemy2.getHp()>0)
        {
            addObject(enemy2Name = new StatDisplay(enemy2.getName(),785,281),640,360);
            addObject(enemy2Bar = new Bar("HP","",enemy2.getHp(),enemy2.getMaxHp()), 860, 301);
            member2Bar.setBarWidth(80);
        }
        if(enemy3.getHp()>0)
        {
            addObject(enemy3Name = new StatDisplay(enemy3.getName(),785,414),640,360);
            addObject(enemy3Bar = new Bar("HP","",enemy3.getHp(),enemy3.getMaxHp()), 860, 434);
            member3Bar.setBarWidth(80);
        }
        if(enemy4.getHp()>0)
        {
            addObject(enemy4Name = new StatDisplay(enemy4.getName(),785,547),640,360);
            addObject(enemy4Bar = new Bar("HP","",enemy4.getHp(),enemy4.getMaxHp()), 860, 567);
            member4Bar.setBarWidth(80);
        }
    }

    public void displayCharacterSprites()
    {
        if(party.getMember1().getHp()>0)
        {
            addObject(member1Sprite,308,148);
        }

        if(party.getMember2().getHp()>0)
        {
            addObject(member2Sprite,308,281);
        }

        if(party.getMember3().getHp()>0)
        {
            addObject(member3Sprite,308,414);
        }

        if(party.getMember4().getHp()>0)
        {
            addObject(member4Sprite,308,547);
        }
    }

    public void displayEnemySprites(){
        if(enemy1.getHp() > 0)
            addObject(enemy1, 1000, 148);
        if(enemy2.getHp() > 0)
            addObject(enemy2, 1000, 281);
        if(enemy3.getHp() > 0)
            addObject(enemy3, 1000, 414);
        if(enemy4.getHp() > 0)
            addObject(enemy4, 1000, 547);
    }

    public void checkBattle(){
        if(party.getMember1().getHp() <= 0){
            //GameOver
            removeObjects(getObjects(null));
            Greenfoot.stop();
        }
        else if(enemy1.getHp() == 0 && enemy2.getHp() == 0 && enemy3.getHp() == 0 && enemy4.getHp() == 0){
            //Return to world
        }
    }

    public void chingazoAnimation()
    {

    }

    public void changeToTargetAlive(){
        if(enemy1.getHp() > 0)
            attackButton.setTarget(enemy1);
        if(enemy2.getHp() > 0)
            attackButton.setTarget(enemy2);
        if(enemy3.getHp() > 0)
            attackButton.setTarget(enemy3);
        if(enemy4.getHp() > 0)
            attackButton.setTarget(enemy4);
    }

    public void changeTarget(Enemy enemy){
        attackButton.setTarget(enemy);
    }
}