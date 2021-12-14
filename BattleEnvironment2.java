import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleEnvironment2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleEnvironment2 extends World
{
    private Party party = Party.getInstance();

    private GreenfootSound music = new GreenfootSound("sounds/0" + party.getMember1().getId() + "_battle.mp3");
    private GreenfootSound burstVoice;
    private GreenfootSound burstMusic = new GreenfootSound("sounds/0" + party.getMember1().getId() + "_burst.mp3");
    private GreenfootSound[] attackSfx = new GreenfootSound[8];

    private EnemyFactory floorFactory;

    private Image characterIndicator;
    private Image targetIndicator;

    private Image member1;
    private Image member2;
    private Image member3;
    private Image member4;

    private Image[] paralysisIcon = new Image[4];
    private Image[] poisonIcon = new Image[4];
    private Image[] darkSigilIcon = new Image[4];

    private Bar member1HpBar;
    private Bar member2HpBar;
    private Bar member3HpBar;
    private Bar member4HpBar;

    private Bar member1SpBar;
    private Bar member2SpBar;
    private Bar member3SpBar;
    private Bar member4SpBar;

    private Bar enemyBar;

    private Enemy[] enemy = new Enemy[4];
    private Image[] enemyPortrait = new Image[4];

    private int characterX;
    private int characterY;
    private int floor = 1;

    private String id;

    private AttackButton attackButton = new AttackButton();
    private SkillButton skillButton = new SkillButton();
    private ItemButton itemButton = new ItemButton();
    private BurstButton burstButton = new BurstButton();
    private RunButton runButton = new RunButton();

    private Character agressor;
    private Enemy target;

    private boolean sokudoBurst = false;
    private int sokudoBurstAttackCount = 0;
    private boolean staticCharge = false;

    private int vileFeastActiveTurns = 0;
    private int decoyTacticsActiveTurns = 0;
    private Character characterProtected;
    private Shock shock = (Shock) findCharacter(3);

    private int kingShieldActiveTurns = 0;
    private int allEyezOnMeActiveTurns = 0;
    private Mike mike = (Mike) findCharacter(4);

    /**
     * Constructor for objects of class BattleEnvironment2.
     * 
     */
    public BattleEnvironment2()
    {    
        super(1280, 720, 1);

        //this.characterX = characterX;
        //this.characterY = characterY;
        //this.floor = floor;
        //this.id = id;

        music.setVolume(35);
        
        setBackground("images/battle_backgrounds/bg.png"); 

        generateEnemies();

        characterIndicator = new Image("images/battle_resources/character_selector_01.png");
        targetIndicator = new Image("images/battle_resources/enemy_selector_01.png");

        member1 = new Image("images/character_portraits/0" + party.getMember1().getId()+ ".gif");
        member2 = new Image("images/character_portraits/0" + party.getMember2().getId()+ ".gif");
        member3 = new Image("images/character_portraits/0" + party.getMember3().getId()+ ".gif");
        member4 = new Image("images/character_portraits/0" + party.getMember4().getId()+ ".gif");

        member1.scale(-375,-375);
        member2.scale(-375,-375);
        member3.scale(-375,-375);
        member4.scale(-375,-375);

        for(int i=0; i<4; i++){
            enemyPortrait[i] = new Image("images/enemy_portraits/0" + enemy[i].getId() + ".gif");
            enemyPortrait[i].scale(-350,-350);
            paralysisIcon[i] = new Image("images/battle_resources/paralysis_icon_0.png");
            darkSigilIcon[i] = new Image("images/battle_resources/dark_sigil_icon.png");
            poisonIcon[i] = new Image("images/battle_resources/poison_icon_0.png");
        }

        for(int i=0; i<8; i++){
            attackSfx[i] = new GreenfootSound("sounds/attack.mp3");
        }

        displayCharacterPortraits();

        addObject(enemy[0], 300, 65);
        addObject(enemy[1], 300, 200);
        addObject(enemy[2], 300, 335);
        addObject(enemy[3], 300, 470);

        addObject(party.getMember1(), 800, 65);
        addObject(party.getMember2(), 800, 200);
        addObject(party.getMember3(), 800, 335);
        addObject(party.getMember4(), 800, 470);

        addObject(paralysisIcon[0], 160, 65);
        addObject(poisonIcon[0], 100, 65);

        addObject(paralysisIcon[1], 160, 200);
        addObject(poisonIcon[1], 100, 200);

        addObject(paralysisIcon[2], 160, 335);
        addObject(poisonIcon[2], 100, 335);

        addObject(paralysisIcon[3], 160, 470);
        addObject(poisonIcon[3], 100, 470);

        addObject(attackButton, 1132, 570);
        addObject(skillButton, 1132, 600);
        addObject(itemButton, 1132, 630);
        addObject(burstButton, 1132, 660);
        addObject(runButton, 1132, 690);

        target = enemy[0];

        //music.play();
    }

    public void started(){
        music.playLoop();
    }

    public void generateEnemies(){
        switch(floor){
            case 1:
                floorFactory = new FirstFloorEnemyFactory();
                break;
            case 2:
                floorFactory = new SecondFloorEnemyFactory();
                break;
            case 3:
                floorFactory = new ThirdFloorEnemyFactory();
                break;
        }

        for(int i=0; i<4; i++){
            enemy[i] = floorFactory.createEnemy();
        }
    }

    public void act(){
        if(!sokudoBurst)
            changeAgressor();

        changeTarget();

        if(party.isPartyTurnOver()){
            enemyPartyAttack();
            checkVileFeast();
        }
    }

    public void changeAgressor(){
        if(party.getMember1().checkClick() != null && party.getMember1().getAttackStatus())
            agressor = party.getMember1().checkClick();
        if(party.getMember2().checkClick() != null && party.getMember2().getAttackStatus())
            agressor = party.getMember2().checkClick();
        if(party.getMember3().checkClick() != null && party.getMember3().getAttackStatus())
            agressor = party.getMember3().checkClick();
        if(party.getMember4().checkClick() != null && party.getMember4().getAttackStatus())
            agressor = party.getMember4().checkClick();

        attackButton.setAgressor(agressor);    

        showBattleElements();

    }

    public void changeTarget(){
        if(target.getHp() == 0){
            changeToTargetAlive();            
        }

        for(int i=0;i<4;i++){
            if(enemy[i].checkClick() != null){
                target = enemy[i];
            }
        }

        attackButton.setTarget(target);

        showBattleElements();

    }

    public void changeToTargetAlive(){
        for(int i=0;i<4;i++){
            if(enemy[i].getHp() > 0){
                target = enemy[i];
            }
        }
    }

    public void displayEnemySprites(){
        int x[] = new int[4];
        int y[] = new int [4];

        for(int i=0;i<4;i++){
            if(enemy[i].getWorld() != null){
                x[i] = enemy[i].getX();
                y[i] = enemy[i].getY();
            }
            removeObject(enemy[i]);
        }

        if(enemy[0].getHp() > 0)
            addObject(enemy[0], x[0], y[0]);
        if(enemy[1].getHp() > 0)
            addObject(enemy[1], x[1], y[1]);
        if(enemy[2].getHp() > 0)
            addObject(enemy[2], x[2], y[2]);
        if(enemy[3].getHp() > 0)
            addObject(enemy[3], x[3], y[3]);
    }

    public void displayPartySprites(){
        removeObject(party.getMember1());
        removeObject(party.getMember2());
        removeObject(party.getMember3());
        removeObject(party.getMember4());
        
        if(party.getMember1().getHp() > 0)
            addObject(party.getMember1(), 800, 65);
        if(party.getMember2().getHp() > 0)
            addObject(party.getMember2(), 800, 200);
        if(party.getMember3().getHp() > 0)
            addObject(party.getMember3(), 800, 335);
        if(party.getMember4().getHp() > 0)
            addObject(party.getMember4(), 800, 470);
    }

    public void displayCharacterPortraits(){
        addObject(member1,1056,73);
        addObject(member2,1056,204);
        addObject(member3,1056,335);
        addObject(member4,1056,466);
    }

    public void showBattleElements(){
        displayAgressorSelected();
        displayTargetSelected();
        displayTargetInfo();
        displayPartyInfo();
        displayEnemyStatus();
        displayEnemySprites();
    }

    public void displayAgressorSelected(){
        removeObject(characterIndicator);
        if(agressor == party.getMember1()){
            addObject(characterIndicator, 900, 65);
        }
        else if(agressor == party.getMember2()){
            addObject(characterIndicator, 900, 200);
        }
        else if(agressor == party.getMember3()){
            addObject(characterIndicator, 900, 335);
        }
        else if(agressor == party.getMember4()){
            addObject(characterIndicator, 900, 470);
        }
    }

    public void displayTargetSelected(){
        removeObject(targetIndicator);
        if(target == enemy[0]){
            addObject(targetIndicator, 220, 65);
        }
        else if(target == enemy[1]){
            addObject(targetIndicator, 220, 200);
        }
        else if(target == enemy[2]){
            addObject(targetIndicator, 220, 335);
        }
        else if(target == enemy[3]){
            addObject(targetIndicator, 220, 470);
        }
    }

    public void displayTargetInfo(){
        removeObject(enemyBar);
        for(int i=0; i<4; i++)
            removeObject(enemyPortrait[i]);

        for(int i=0; i<4; i++){
            if(target == enemy[i])
                addObject(enemyPortrait[i],92, 630);
        }

        if(target != null){
            showText(target.getName(), 300, 570);
            addObject(enemyBar = new Bar("HP","",target.getHp(),target.getMaxHp()), 300, 612);
            enemyBar.setBarWidth(150);
            showText("Atk: " + (int)target.getAtk(), 230, 650);
            showText("Def: " + (int)target.getDef(), 350, 650);
            showText("XP: " + target.getYieldXp(), 230, 690);
            showText("Money: " + target.getYieldMoney(), 350, 690);
        }
    }

    public void displayPartyInfo(){
        removeObject(member1HpBar);
        removeObject(member2HpBar);
        removeObject(member3HpBar);
        removeObject(member4HpBar);

        showText(party.getMember1().getName(), 1170, 30);
        showText(party.getMember2().getName(), 1170, 160);
        showText(party.getMember3().getName(), 1170, 290);
        showText(party.getMember4().getName(), 1170, 420);

        addObject(member1HpBar = new Bar("HP","",party.getMember1().getHp(),party.getMember1().getMaxHp()), 1190, 70);
        addObject(member2HpBar = new Bar("HP","",party.getMember2().getHp(),party.getMember2().getMaxHp()), 1190, 200);
        addObject(member3HpBar = new Bar("HP","",party.getMember3().getHp(),party.getMember3().getMaxHp()), 1190, 330);
        addObject(member4HpBar = new Bar("HP","",party.getMember4().getHp(),party.getMember4().getMaxHp()), 1190, 460);

        member1HpBar.setBarWidth(80);
        member2HpBar.setBarWidth(80);
        member3HpBar.setBarWidth(80);
        member4HpBar.setBarWidth(80);

        if(party.getMember1().getId() != 8){
            removeObject(member1SpBar);
            addObject(member1SpBar = new Bar("SP","",party.getMember1().getSp(),party.getMember1().getMaxSp()), 1190, 110);
            member1SpBar.setBarWidth(80);
            member1SpBar.setSafeColor(Color.BLUE);
        }
        if(party.getMember2().getId() != 8){
            removeObject(member2SpBar);
            addObject(member2SpBar = new Bar("SP","",party.getMember2().getSp(),party.getMember2().getMaxSp()), 1190, 240);
            member2SpBar.setBarWidth(80);
            member2SpBar.setSafeColor(Color.BLUE);
        }
        if(party.getMember3().getId() != 8){
            removeObject(member3SpBar);
            addObject(member3SpBar = new Bar("SP","",party.getMember3().getSp(),party.getMember3().getMaxSp()), 1190, 370);
            member3SpBar.setBarWidth(80);
            member3SpBar.setSafeColor(Color.BLUE);
        }
        if(party.getMember4().getId() != 8){
            removeObject(member4SpBar);
            addObject(member4SpBar = new Bar("SP","",party.getMember4().getSp(),party.getMember4().getMaxSp()), 1190, 500);
            member4SpBar.setBarWidth(80);
            member4SpBar.setSafeColor(Color.BLUE);
        }
    }

    public void attackAnimation(){
        int counter = 0;
        int x = agressor.getX();
        int y = agressor.getY();

        while(target.getX() + 50 < agressor.getX() || target.getY() != agressor.getY()){
            if(target.getX() + 50 < agressor.getX())
                agressor.setLocation(agressor.getX()-20, agressor.getY());
            if(target.getY() < agressor.getY())
                agressor.setLocation(agressor.getX(), agressor.getY()-15);
            else if(target.getY() > agressor.getY())
                agressor.setLocation(agressor.getX(), agressor.getY()+15);

            Greenfoot.delay(1);
            //counter ++;
        }

        for(int i=0;i<agressor.getHitCount();i++){
            attackSfx[i].play();
            int damage = (int)((agressor.getAtk()-target.getDef()));
            target.setHp(target.getHp()-damage);
            if(agressor.getId() == 1 && !target.isParalyzed()){
                target.setTemporalVoidStack(target.getTemporalVoidStack() + 1);
                if(target.getTemporalVoidStack() == ((Sokudo) agressor).getStacksRequired()){
                    target.setParalysisStatus(true);
                }
            }
            if(target.getHp() < 0)
                target.setHp(0);

            showBattleElements();
            Greenfoot.delay(15);
        }

        while(agressor.getX() != x || agressor.getY() != y){
            if(agressor.getX() < x)
                agressor.setLocation(agressor.getX() + 20, agressor.getY());
            if(agressor.getY() > y)
                agressor.setLocation(agressor.getX(), agressor.getY()-15);
            else if(agressor.getY() < y)
                agressor.setLocation(agressor.getX(), agressor.getY()+15);

            Greenfoot.delay(1);

        }
    }

    public void attack(Character agressor, Enemy target){
        attackAnimation();

        if(agressor.getId() == 1 && staticCharge){
            agressor.setAtk((int)(agressor.getAtk() / ((Sokudo)agressor).getSkill4DamageMultiplier()));
            staticCharge = false;
        }

        if(!sokudoBurst){
            agressor.setAttackStatus(false);
            this.agressor = null;
        }
        else{
            sokudoBurst();
        }
    }

    public void enemyPartyAttack(){
        for(int i=0;i<4;i++){
            if(enemy[i].getHp() > 0){
                enemyAttack(enemy[i]);
                displayPartySprites();
            }
        }
        if(decoyTacticsActiveTurns > 0)
            decoyTacticsActiveTurns --;
        if(kingShieldActiveTurns > 0)
            kingShieldActiveTurns --;
    }

    public void enemyAnimation(Enemy enemy, Character target){
        int counter = 0;
        int x = enemy.getX();
        int y = enemy.getY();

        while(target.getX() - 50 > enemy.getX() || target.getY() != enemy.getY()){
            if(target.getX() - 50 > enemy.getX())
                enemy.setLocation(enemy.getX() + 20, enemy.getY());
            if(target.getY() < enemy.getY())
                enemy.setLocation(enemy.getX(), enemy.getY()-15);
            else if(target.getY() > enemy.getY())
                enemy.setLocation(enemy.getX(), enemy.getY()+15);

            Greenfoot.delay(1);
            //counter ++;
        }

        for(int i=0;i<enemy.getHitCount();i++){
            attackSfx[i].play();
            if(target == shock && decoyTacticsActiveTurns > 0)
                target.setHp(target.getHp()-(int)((enemy.getAtk() - (enemy.getAtk() * shock.getDamageMitigationPercent()))-target.getDefense()));
            else if(target == mike && kingShieldActiveTurns > 0)
                target.setHp(target.getHp()-(int)((enemy.getAtk() - target.getDefense()) * mike.getDamageTakenMultiplier()));
            else
                target.setHp(target.getHp()-(int)(enemy.getAtk()-target.getDefense()));
            if(target.getHp()<0)
            {
                target.setHp(0);
            }
            showBattleElements();
            Greenfoot.delay(15);
        }

        while(enemy.getX() != x || enemy.getY() != y){
            if(enemy.getX() > x)
                enemy.setLocation(enemy.getX() - 20, enemy.getY());
            if(enemy.getY() > y)
                enemy.setLocation(enemy.getX(), enemy.getY()-15);
            else if(enemy.getY() < y)
                enemy.setLocation(enemy.getX(), enemy.getY()+15);

            Greenfoot.delay(1);

        }
    }

    public void enemyAttack(Enemy enemy){
        Character target = null;
        if(kingShieldActiveTurns <= 0){
            int drawRate = (int)(Math.random()*100+1);
            if((drawRate <= 25)){
                //addObject(new AttackAnimation(),member1Sprite.getX(),member1.getY());
                target = party.getMember1();
                if(decoyTacticsActiveTurns > 0 && target == characterProtected){
                    target = shock;
                }
            }
            else if(drawRate <= 50){
                //addObject(new AttackAnimation(),member1Sprite.getX(),member2.getY());
                target = party.getMember2();
                if(decoyTacticsActiveTurns > 0 && target == characterProtected){
                    target = shock;
                }
            }
            else if(drawRate <= 75){
                //addObject(new AttackAnimation(),member1Sprite.getX(),member3.getY());
                target = party.getMember3();
                if(decoyTacticsActiveTurns > 0 && target == characterProtected){
                    target = shock;
                }
            }
            else{
                //addObject(new AttackAnimation(),member1Sprite.getX(),member4.getY());
                target = party.getMember4();
                if(decoyTacticsActiveTurns > 0 && target == characterProtected){
                    target = shock;
                }
            }
        }
        else{
            target = mike;
        }
        enemyAnimation(enemy, target);
    }

    public void sokudoBurst(){
        int probability;
        sokudoBurstAttackCount++;
        switch(sokudoBurstAttackCount){
            case 1:
            case 2:
            case 3:
                probability = 100;
                break;
            case 4:
                probability = 90;
                break;
            case 5:
                probability = 80; 
                break;
            case 6:
                probability = 60; 
                break;
            case 7:
                probability = 40;  
                break;
            case 8:
                probability = 20;  
                break;
            case 9:
                probability = 10;
                break;
            default:
                probability = 5;
                break;
        }
        if(Math.random()*(100)+1 > probability){
            agressor.setAttackStatus(false);
            this.agressor = null;
            sokudoBurst = false;
            sokudoBurstAttackCount = 0;
        }
    }

    public void showSkills(){
        if(agressor != null && !sokudoBurst){
            switch(agressor.getId()){
                case 1:
                case 2:
                case 3:
                case 6:
                    addObject(new SkillOverlayButton(agressor,2), 902, 600);
                    addObject(new SkillOverlayButton(agressor,4), 902, 630);
                    break;
                case 4:
                    addObject(new SkillOverlayButton(agressor,1), 902, 600);
                    addObject(new SkillOverlayButton(agressor,2), 902, 630);
                    break;
                case 5:
                case 7:
                    addObject(new SkillOverlayButton(agressor,2), 902, 600);
                    addObject(new SkillOverlayButton(agressor,3), 902, 630);
                    addObject(new SkillOverlayButton(agressor,4), 902, 660);
                    break;
                case 8:
                    addObject(new SkillOverlayButton(agressor,3), 902, 600);
                    addObject(new SkillOverlayButton(agressor,4), 902, 630);
                    break;
            }
        }
    }

    public void showTargetAllies(int skillNumber){
        if(party.getMember1() != agressor || party.getMember1().getHp() == 0){
            addObject(new AllyButton(party.getMember1(),agressor,skillNumber), 902, 600);
        }
        if(party.getMember2() != agressor || party.getMember2().getHp() == 0){
            addObject(new AllyButton(party.getMember2(),agressor,skillNumber), 902, 630);
        }
        if(party.getMember3() != agressor || party.getMember3().getHp() == 0){
            addObject(new AllyButton(party.getMember3(),agressor,skillNumber), 902, 660);
        }
        if(party.getMember4() != agressor || party.getMember4().getHp() == 0){
            addObject(new AllyButton(party.getMember4(),agressor,skillNumber), 902, 690);
        }
    }

    public void chaosOverlimit(){
        Sokudo agressor = (Sokudo) this.agressor;
        attackSfx[0].play();
        for(int i=0; i<4; i++){
            for(int j=0; j<agressor.getSkill2HitCount(); j++){
                int damage = (int)(((agressor.getAtk()*agressor.getSkill2AtkUsedPercent())-enemy[i].getDef()));
                enemy[i].setHp(enemy[i].getHp()-damage);
                enemy[i].setTemporalVoidStack(enemy[i].getTemporalVoidStack() + 1);
                if(enemy[i].getHp() < 0)
                    enemy[i].setHp(0);
            }
        }

        if(staticCharge){
            agressor.setAtk((int)(agressor.getAtk() / ((Sokudo)agressor).getSkill4DamageMultiplier()));
            staticCharge = false;
        }

        agressor.setSp(agressor.getSp()-agressor.getSkill2SpCost());
        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
    }

    public void staticCharge(){
        Sokudo agressor = (Sokudo) this.agressor;
        agressor.setAtk((int)(agressor.getAtk() * agressor.getSkill4DamageMultiplier()));
        staticCharge = true;
        agressor.setSp(agressor.getSp() - agressor.getSkill4SpCost());

        agressor.setAttackStatus(false);
        this.agressor = null;
    }

    public void murderousGaze(){
        if(Math.random()*(100)+1 <= ((Light) agressor).getPoisonActivationRate()){
            target.setPoisonActiveTurns(((Light) agressor).getPoisonActiveTurns());
            target.setPoisonStatus(true);
        }
        agressor.setSp(agressor.getSp() - ((Light) agressor).getSkill2SpCost());
        agressor.setAttackStatus(false);
        agressor = null;

        showBattleElements();
    }

    public void transfusion(Character target){
        agressor.setHp(agressor.getHp() - (int)(agressor.getHp() * ((Light) agressor).getSelfHpDamagePercent()));
        target.setSp(target.getSp() + ((Light) agressor).getAllySpRecoveryPercent());
        agressor.setSp(agressor.getSp() - ((Light) agressor).getSkill4SpCost() + ((Light) agressor).getSelfSpRecovery());

        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
    }

    public void vileFeast(){
        vileFeastActiveTurns = ((Shock) agressor).getSkill2ActiveTurns();
        agressor.setSp(agressor.getSp() - ((Shock) agressor).getSkill2SpCost());

        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
    }

    public Character findCharacter(int id){
        Character character = null;
        if(party.getMember1().getId() == id)
            character = party.getMember1();
        else if(party.getMember2().getId() == id)
            character = party.getMember2();
        else if(party.getMember3().getId() == id)
            character = party.getMember3();
        else if(party.getMember4().getId() == id)
            character = party.getMember4();
        return character;
    }

    public void checkVileFeast(){
        if(vileFeastActiveTurns > 0){
            shock.setHp((int)(shock.getHp() + (shock.getHp() * shock.getHpRecoveryPercent())));
            vileFeastActiveTurns --;
        }
    }

    public void decoyTactics(Character target){
        decoyTacticsActiveTurns = ((Shock) agressor).getSkill4ActiveTurns();
        characterProtected = target;
        agressor.setSp(agressor.getSp() - ((Shock) agressor).getSkill4SpCost());

        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
    }

    public void kingShield(){
        kingShieldActiveTurns = ((Mike)agressor).getSkill1ActiveTurns();
        agressor.setSp(agressor.getSp() - ((Mike) agressor).getSkill1SpCost());

        agressor.setAttackStatus(false);
        agressor = null;

        showBattleElements();
    }

    public void allEyezOnMe(){
        allEyezOnMeActiveTurns = ((Mike)agressor).getSkill2ActiveTurns();
        
    }

    public void activateBurst(){
        if(agressor != null){
            burstVoice = new GreenfootSound("sounds/0" + agressor.getId() + "_burstVoice.mp3");
            burstVoice.play();

            if(agressor == party.getMember1()){
                music.stop();
                burstMusic.playLoop();
            }
        }

        if(agressor != null)
            switch(agressor.getId()){
                case 1:
                    sokudoBurst = true;
                    break;
            }
    }

    public void run(){
        if(agressor.getId() == 6){
            if(Math.random()*(100)+1 < ((KingHermes)agressor).getSkill3RunRate()){
                //return to World
            }
        }
        else{
            if(Math.random()*(100)+1 < 25){
                //return to world
            }
        }
    }

    public void displayEnemyStatus(){
        for(int i=0; i<4; i++){
            removeObject(paralysisIcon[i]);
            removeObject(poisonIcon[i]);
            removeObject(darkSigilIcon[i]);

            if(!enemy[i].isParalyzed())
                paralysisIcon[i] = new Image("images/battle_resources/paralysis_icon_" + enemy[i].getTemporalVoidStack() + ".png");
            else
                paralysisIcon[i] = new Image("images/battle_resources/paralysis_icon_paralyzed.png");

            poisonIcon[i] = new Image("images/battle_resources/poison_icon_" + enemy[i].getPoisonActiveTurns() + ".png");
        }
        if(enemy[0].getHp() > 0){
            addObject(paralysisIcon[0], 160, 65);
            addObject(poisonIcon[0], 100, 65);
        }
        if(enemy[1].getHp() > 0){
            addObject(paralysisIcon[1], 160, 200);
            addObject(poisonIcon[1], 100, 200);
        }
        if(enemy[2].getHp() > 0){
            addObject(paralysisIcon[2], 160, 335);
            addObject(poisonIcon[2], 100, 335);
        }
        if(enemy[3].getHp() > 0){
            addObject(paralysisIcon[3], 160, 470);
            addObject(poisonIcon[3], 100, 470);
        }
    }
}
