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

    private int enemySpeed;
    private int partySpeed;
    private boolean firstTurn;

    Character rengokux = party.getMember1();
    Character hermes = party.getMember2();
    Character luis = party.getMember3();
    Character nacriko = party.getMember4();

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

    private Image furyStackIcon;

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
    private Enemy tauntedTarget;

    private boolean sokudoBurst = false;
    private int sokudoBurstAttackCount = 0;
    private boolean staticCharge = false;

    private int vileFeastActiveTurns = 0;
    private int decoyTacticsActiveTurns = 0;
    private Character characterProtected;
    private Shock shock = (Shock) findCharacter(3);
    private boolean shockBurst = false;

    private int kingShieldActiveTurns = 0;
    private int allEyezOnMeActiveTurns = 0;
    private Mike mike = (Mike) findCharacter(4);
    private boolean mikeBurst = false;
    private int mikeDamage = 0;

    private Rengoku rengoku = (Rengoku) findCharacter(5);
    private boolean entreatIsActive = false;
    private boolean cheerIsActive = false;

    private KingHermes kingHermes = (KingHermes) findCharacter(6);
    private boolean padalustroIsActive = false;
    private Character lustredCharacter;
    private boolean hermesBurst = false;

    //TERRORIST

    private Nagito nagito = (Nagito) findCharacter(8);
    private boolean nagitoBurst = false;

    /**
     * Constructor for objects of class BattleEnvironment2.
     * 
     */
    public BattleEnvironment2(String id, int characterX, int characterY, int floor)
    {    
        super(1280, 720, 1);

        this.characterX = characterX;
        this.characterY = characterY;
        this.floor = floor;
        this.id = id;

        if(party.getMember1().getHp() > 0)
            party.getMember1().setAttackStatus(true);
        if(party.getMember2().getHp() > 0)
            party.getMember2().setAttackStatus(true);
        if(party.getMember3().getHp() > 0)
            party.getMember3().setAttackStatus(true);
        if(party.getMember4().getHp() > 0)
            party.getMember4().setAttackStatus(true);

        if(findCharacter(8) != null && nagito.getCooldownTurns() > 0)
            nagito.setAttackStatus(false);

        music.setVolume(60);

        setBackground("images/battle_backgrounds/bg.png"); 

        generateEnemies();

        characterIndicator = new Image("images/battle_resources/character_selector_01.png");
        targetIndicator = new Image("images/battle_resources/enemy_selector_01.png");

        furyStackIcon = new Image("images/battle_resources/fury_stack_icon_0.png");

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

        displayPartySprites();

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
        agressor = party.getMember1();

        firstTurn = true;
        partySpeed = party.getMember1().getSpeed() + party.getMember2().getSpeed() + party.getMember3().getSpeed() + party.getMember4().getSpeed() + (int)(((Math.random() * 20) + 1) - 10);
        enemySpeed = enemy[0].getSpeed() + enemy[1].getSpeed() + enemy[2].getSpeed() + enemy[3].getSpeed() + (int)(((Math.random() * 20) + 1) - 10);
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
        if(partySpeed < enemySpeed && firstTurn){
            showBattleElements();
            enemyPartyAttack();
            firstTurn = false;
            endOfTurn();
        }
        if(!sokudoBurst){
            changeAgressor();
        }

        changeTarget();

        if(party.isPartyTurnOver() && hermesBurst){
            hermesBurst();
        }

        if(party.isPartyTurnOver()){
            enemyPartyAttack();
            endOfTurn();
        }
        checkBattle();
    }

    public boolean checkBattle(){
        if(party.getMember1().getHp() <= 0){
            removeObjects(getObjects(null));
            party.setMember1(null);
            party.setMember2(null);
            party.setMember3(null);
            party.setMember4(null);
            music.stop();
            burstMusic.stop();
            MainMenu.playMusic();
            Greenfoot.setWorld(new MainMenu());
            return true;
        }
        else if(enemy[0].getHp() <= 0 && enemy[1].getHp() <= 0 && enemy[2].getHp() <= 0 && enemy[3].getHp() <= 0){
            int xp = enemy[0].getXp()+enemy[1].getXp()+enemy[2].getXp()+enemy[3].getXp();
            if(findCharacter(6) != null)
                xp += xp * kingHermes.getAcquiredExpMultiplier();

            party.getMember1().setXp(party.getMember1().getXp()+xp);
            party.getMember2().setXp(party.getMember2().getXp()+xp);
            party.getMember3().setXp(party.getMember3().getXp()+xp);
            party.getMember4().setXp(party.getMember4().getXp()+xp);
            party.getMember1().levelUp();
            party.getMember2().levelUp();
            party.getMember3().levelUp();
            party.getMember4().levelUp();
            music.stop();
            burstMusic.stop();
            switch(floor)
            {
                case 1:
                    FirstFloorRoom.playMusic();
                    Greenfoot.setWorld(new FirstFloorRoom(id,characterX,characterY));
                    break;
                case 2:
                    SecondFloorRoom.playMusic();
                    Greenfoot.setWorld(new SecondFloorRoom(id,characterX,characterY));
                    break;
                case 3:
                    SecondFloorRoom.playMusic();
                    Greenfoot.setWorld(new ThirdFloorRoom(id,characterX,characterY));
                    break;
            }
            return true;
        }
        return false;
    }

    public void endOfTurn(){
        entreatIsActive = false;
        cheerIsActive = false;
        if(findCharacter(2) != null)
            enemyPoisonDamage();
        if(decoyTacticsActiveTurns > 0)
            decoyTacticsActiveTurns --;
        if(kingShieldActiveTurns > 0)
            kingShieldActiveTurns --;
        if(allEyezOnMeActiveTurns > 0){
            allEyezOnMeActiveTurns --;
            if(allEyezOnMeActiveTurns == 0){
                tauntedTarget = null;
            }
        }
        if(mikeBurst){
            if(mike.getHp() > 0){
                for(int i=0; i<4;i++){
                    if(enemy[i].getHp() > 0){
                        enemy[i].setHp(enemy[i].getHp() - mikeDamage);
                        if(enemy[i].getHp() < 0)
                            enemy[i].setHp(0);
                    }
                }
            }
            mikeBurst = false;
            mikeDamage = 0;
        }
        if(shockBurst){
            shockBurst = false;
        }
        if(nagitoBurst)
            nagitoBurst = false;
        checkVileFeast();
        if(findCharacter(1) != null && findCharacter(1).getSkill3Lvl() > 0 && findCharacter(1).getHp() > 0)
            warpStrike();
        if(findCharacter(8) != null && findCharacter(8).getHp() > 0 && nagito.getCooldownTurns() == 0){
            nagito.setHp(nagito.getHp() - (int)(nagito.getMaxHp() * .1));
            if(nagito.getHp() <= 0)
                nagito.setHp(1);
        }

        if(party.getMember1().getHp() > 0)
            party.getMember1().setAttackStatus(true);
        else
            party.getMember1().setAttackStatus(false);

        if(party.getMember2().getHp() > 0)
            party.getMember2().setAttackStatus(true);
        else
            party.getMember2().setAttackStatus(false);

        if(party.getMember3().getHp() > 0)
            party.getMember3().setAttackStatus(true);
        else
            party.getMember3().setAttackStatus(false);

        if(party.getMember4().getHp() > 0)
            party.getMember4().setAttackStatus(true);
        else
            party.getMember4().setAttackStatus(false);

        if(findCharacter(8) != null && findCharacter(8).getHp() > 0 && nagito.getCooldownTurns() > 0){
            if(nagito.getCooldownHeal()){
                nagito.setHp(nagito.getHp() + (int)(nagito.getMaxHp() * 0.5));

                if(nagito.getHp() > nagito.getMaxHp())
                    nagito.setHp(nagito.getMaxHp());
            }

            nagito.setCooldownTurns(nagito.getCooldownTurns() - 1);

            if(nagito.getCooldownTurns() > 0)
                nagito.setAttackStatus(false);

            if(nagito.getCooldownTurns() == 0)
                nagito.setCooldownHeal(false);
        }

        if(party.getMember1().getUltCharges() < party.getMember1().getUltQuantity()){
            party.getMember1().setUltCharges(party.getMember1().getUltCharges() + 1);
        }
        if(party.getMember2().getUltCharges() < party.getMember2().getUltQuantity()){
            party.getMember2().setUltCharges(party.getMember2().getUltCharges() + 1);
        }
        if(party.getMember3().getUltCharges() < party.getMember3().getUltQuantity()){
            party.getMember3().setUltCharges(party.getMember3().getUltCharges() + 1);
        }
        if(party.getMember4().getUltCharges() < party.getMember4().getUltQuantity()){
            party.getMember4().setUltCharges(party.getMember4().getUltCharges() + 1);
        }
    }

    public void changeAgressor(){
        if(agressor == null){
            changeToActiveAgressor();
        }

        if(party.getMember1().checkClick() != null && party.getMember1().getAttackStatus() && party.getMember1().getHp() > 0)
            agressor = party.getMember1().checkClick();
        if(party.getMember2().checkClick() != null && party.getMember2().getAttackStatus()  && party.getMember2().getHp() > 0)
            agressor = party.getMember2().checkClick();
        if(party.getMember3().checkClick() != null && party.getMember3().getAttackStatus() && party.getMember3().getHp() > 0)
            agressor = party.getMember3().checkClick();
        if(party.getMember4().checkClick() != null && party.getMember4().getAttackStatus() && party.getMember1().getHp() > 0)
            agressor = party.getMember4().checkClick();

        attackButton.setAgressor(agressor);
        runButton.setAgressor(agressor);

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

    public void changeToActiveAgressor(){
        if(party.getMember1().getAttackStatus() && party.getMember1().getHp() > 0){
            agressor = party.getMember1();
        }
        else if(party.getMember2().getAttackStatus() && party.getMember2().getHp() > 0){
            agressor = party.getMember2();
        }
        else if(party.getMember3().getAttackStatus() && party.getMember3().getHp() > 0){
            agressor = party.getMember3();
        }
        else if(party.getMember4().getAttackStatus() && party.getMember4().getHp() > 0){
            agressor = party.getMember4();
        }

        attackButton.setAgressor(agressor);
        runButton.setAgressor(agressor);

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
        removeObject(member1);
        removeObject(member2);
        removeObject(member3);
        removeObject(member4);

        if(party.getMember1().getHp() > 0)
            member1 = new Image("images/character_portraits/0" + party.getMember1().getId()+ ".gif");
        else
            member1 = new Image("images/character_portraits/0" + party.getMember1().getId()+ "d.png");

        if(party.getMember2().getHp() > 0)
            member2 = new Image("images/character_portraits/0" + party.getMember2().getId()+ ".gif");
        else
            member2 = new Image("images/character_portraits/0" + party.getMember2().getId()+ "d.png");

        if(party.getMember3().getHp() > 0)
            member3 = new Image("images/character_portraits/0" + party.getMember3().getId()+ ".gif");
        else
            member3 = new Image("images/character_portraits/0" + party.getMember3().getId()+ "d.png");

        if(party.getMember4().getHp() > 0)
            member4 = new Image("images/character_portraits/0" + party.getMember4().getId()+ ".gif");
        else
            member4 = new Image("images/character_portraits/0" + party.getMember4().getId()+ "d.png");

        member1.scale(-375,-375);
        member2.scale(-375,-375);
        member3.scale(-375,-375);
        member4.scale(-375,-375);

        addObject(member1,1056,73);
        addObject(member2,1056,204);
        addObject(member3,1056,335);
        addObject(member4,1056,466);
    }

    public void showBattleElements(){
        displayCharacterPortraits();
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
        else{
            removeObject(furyStackIcon);
            if(nagito.getCooldownTurns() == 0)
                furyStackIcon = new Image("images/battle_resources/fury_stack_icon_" + nagito.getFuryStacks() + ".png");
            else
                furyStackIcon = new Image("images/battle_resources/cooldown_icon_" + nagito.getCooldownTurns() + ".png");
            addObject(furyStackIcon, 1190, 110);
        }
        if(party.getMember2().getId() != 8){
            removeObject(member2SpBar);
            addObject(member2SpBar = new Bar("SP","",party.getMember2().getSp(),party.getMember2().getMaxSp()), 1190, 240);
            member2SpBar.setBarWidth(80);
            member2SpBar.setSafeColor(Color.BLUE);
        }
        else{
            removeObject(furyStackIcon);
            if(nagito.getCooldownTurns() == 0)
                furyStackIcon = new Image("images/battle_resources/fury_stack_icon_" + nagito.getFuryStacks() + ".png");
            else
                furyStackIcon = new Image("images/battle_resources/cooldown_icon_" + nagito.getCooldownTurns() + ".png");
            addObject(furyStackIcon, 1190, 240);
        }
        if(party.getMember3().getId() != 8){
            removeObject(member3SpBar);
            addObject(member3SpBar = new Bar("SP","",party.getMember3().getSp(),party.getMember3().getMaxSp()), 1190, 370);
            member3SpBar.setBarWidth(80);
            member3SpBar.setSafeColor(Color.BLUE);
        }
        else{
            removeObject(furyStackIcon);
            if(nagito.getCooldownTurns() == 0)
                furyStackIcon = new Image("images/battle_resources/fury_stack_icon_" + nagito.getFuryStacks() + ".png");
            else
                furyStackIcon = new Image("images/battle_resources/cooldown_icon_" + nagito.getCooldownTurns() + ".png");
            addObject(furyStackIcon, 1190, 370);
        }
        if(party.getMember4().getId() != 8){
            removeObject(member4SpBar);
            addObject(member4SpBar = new Bar("SP","",party.getMember4().getSp(),party.getMember4().getMaxSp()), 1190, 500);
            member4SpBar.setBarWidth(80);
            member4SpBar.setSafeColor(Color.BLUE);
        }
        else{
            removeObject(furyStackIcon);
            if(nagito.getCooldownTurns() == 0)
                furyStackIcon = new Image("images/battle_resources/fury_stack_icon_" + nagito.getFuryStacks() + ".png");
            else
                furyStackIcon = new Image("images/battle_resources/cooldown_icon_" + nagito.getCooldownTurns() + ".png");
            addObject(furyStackIcon, 1190, 500);
        }
    }

    public void attackAnimation(Character agressor, Enemy target, int type){
        if(checkBattle()){
            return;
        }

        int counter = 0;
        int x = agressor.getX();
        int y = agressor.getY();

        double entreatMultiplier = 1;
        double padalustroMultiplier = 1;
        if(entreatIsActive){
            entreatMultiplier = 1 + rengoku.getSkill3AtkMultiplier();
        }
        if(padalustroIsActive && agressor == lustredCharacter){
            padalustroMultiplier = 2;
        }

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

        switch(type){
            case 0:
                for(int i=0;i<agressor.getHitCount();i++){
                    attackSfx[i].play();
                    int damage = (int)padalustroMultiplier * (int)Math.ceil((((agressor.getAtk() * entreatMultiplier)-target.getDef())));
                    if(agressor.getId() == 1){
                        if(!target.isParalyzed() && agressor.getSkill1Lvl() > 0){
                            target.setTemporalVoidStack(target.getTemporalVoidStack() + 1);
                            if(target.getTemporalVoidStack() == ((Sokudo) agressor).getStacksRequired()){
                                target.setParalysisStatus(true);
                            }
                        }
                        damage = (int)padalustroMultiplier * (int)Math.ceil(((agressor.getAtk() * entreatMultiplier)-(target.getDef() * ((Sokudo) agressor).getDefIgnorePercent())));
                    }
                    else if(agressor.getId() == 2){
                        if(target.isPoisoned() && agressor.getSkill3Lvl() > 0){
                            agressor.setSp((int)Math.ceil(agressor.getSp() + (agressor.getMaxSp() * ((Light) agressor).getSpRecoveryRate())));
                            if(agressor.getSp() > agressor.getMaxSp())
                                agressor.setSp(agressor.getMaxSp());
                        }
                    }
                    else if(agressor.getId() == 4){
                        if(agressor.getSkill3Lvl() > 0){
                            damage = (int)padalustroMultiplier * (int)Math.ceil(((((agressor.getAtk() * entreatMultiplier) + Math.ceil(agressor.getDefense() * mike.getDefScalingPercent())) - target.getDef())));
                        }
                    }

                    else if(agressor.getId() == 8){
                        if(target.hasDarkSigil()){
                            nagito.setFuryStacks(nagito.getFuryStacks() + 2);
                            target.setDarkSigil(false);
                            for(int j = 0; j < 4; j++){
                                enemy[j].setHp(enemy[j].getHp() - (int)(damage * nagito.getMarkedEnemyDamageMultiplier()));
                                if(enemy[j].getHp() < 0){
                                    enemy[j].setHp(0);
                                }
                            }
                        }
                        else{
                            boolean exit = false;
                            nagito.setFuryStacks(nagito.getFuryStacks() + 1);
                            int enemiesAlive = 0;

                            for(int j = 0; j < 4; j++){
                                enemy[j].setDarkSigil(false);
                                if(enemy[j].getHp() > 0)
                                    enemiesAlive ++;
                            }

                            for(int j = 0; j < 4; j++){
                                if(enemy[j] != target && enemy[j].getHp() > 0){
                                    enemy[j].setDarkSigil(true);
                                    break;
                                }
                            }
                        }

                        if(nagito.getFuryStacks() > 10){
                            nagito.setFuryStacks(10);
                        }
                    }

                    if(damage < 0)
                        damage = 0;

                    target.setHp(target.getHp()-damage);

                    if(target.getHp() < 0)
                        target.setHp(0);

                    if(target.getHp() == 0)
                        changeToTargetAlive();

                    showBattleElements();
                    Greenfoot.delay(15);
                }
                break;
            case 1:
                for(int i=0;i<((Sokudo)agressor).getSkill3HitCount();i++){
                    attackSfx[i].play();
                    int damage;
                    if(!target.isParalyzed() && agressor.getSkill1Lvl() > 0){
                        target.setTemporalVoidStack(target.getTemporalVoidStack() + 1);
                        if(target.getTemporalVoidStack() == ((Sokudo) agressor).getStacksRequired()){
                            target.setParalysisStatus(true);
                        }
                    }
                    damage = (int)padalustroMultiplier * (int)Math.ceil((((agressor.getAtk() * entreatMultiplier) * ((Sokudo) agressor).getSkill3AtkPercent())-(target.getDef() * ((Sokudo) agressor).getDefIgnorePercent())));

                    target.setHp(target.getHp()-damage);

                    if(damage < 0)
                        damage = 0;

                    if(target.getHp() < 0)
                        target.setHp(0);

                    if(target.getHp() == 0)
                        changeToTargetAlive();

                    showBattleElements();
                    Greenfoot.delay(15);
                }
                break;
            case 2:
                attackSfx[0].play();
                int damage = (int)padalustroMultiplier * (int)Math.ceil((target.getMaxHp() * shock.getCounterDamage()));
                if(shockBurst)
                    damage *= 2;
                target.setHp(target.getHp() - damage);

                if(target.getHp() < 0)
                    target.setHp(0);

                if(target.getHp() == 0)
                    changeToTargetAlive();

                showBattleElements();
                Greenfoot.delay(15);
                break;
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
        attackAnimation(agressor, target, 0);

        checkBattle();

        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);

        if(agressor.getId() == 1 && staticCharge && !sokudoBurst){
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
            if(enemy[i].getHp() > 0 && !enemy[i].isParalyzed()){
                enemyAttack(enemy[i]);
                displayPartySprites();
            }
            else{
                enemy[i].setParalysisStatus(false);
            }
        }
    }

    public void enemyPoisonDamage(){
        int damage;
        for(int i = 0; i < 4; i ++){
            if(enemy[i].getHp() > 0 && enemy[i].isPoisoned()){
                damage = (int)Math.ceil(enemy[i].getMaxHp() * ((Light) findCharacter(2)).getPoisonHpPercentDamage());
                enemy[i].setHp(enemy[i].getHp() - damage);
                if(enemy[i].getHp()<0)
                {
                    enemy[i].setHp(0);
                }
                enemy[i].setPoisonActiveTurns(enemy[i].getPoisonActiveTurns() - 1);
                if(enemy[i].getPoisonActiveTurns() == 0)
                    enemy[i].setPoisonStatus(false);
            }
        }
    }

    public void enemyAnimation(Enemy enemy, Character target){
        double cheerMultiplier = 1;
        if(cheerIsActive){
            cheerMultiplier = 1 + rengoku.getSkill4DefMultiplier();
        }

        int counter = 0;
        int x = enemy.getX();
        int y = enemy.getY();
        int damage = (int)(enemy.getAtk() - (target.getDefense() * cheerMultiplier));

        if(damage < 0)
            damage = 0;

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
            if(enemy.getHp() > 0){
                attackSfx[i].play();
                if(shockBurst){
                    if(Math.random()*(100)+1 <= shock.getEvadeRate() && shock.getSkill3Lvl() > 0){
                        attackAnimation(shock, enemy, 2);
                    }
                    else{
                        target.setHp(target.getHp() - (int)(2 * (damage * shock.getDamageMitigationPercent())));
                        if(target.getHp() <= 0 && target.getSkill1Lvl() > 0){
                            if(Math.random()*(100)+1 <= shock.getGutsActivationRate()){
                                target.setHp(1);
                            }
                        }
                    }
                }
                else if(mikeBurst){
                    target.setHp(target.getHp()-(int)(damage * mike.getDamageTakenMultiplier()));
                    mikeDamage += damage * mike.getDamageTakenMultiplier();
                }
                else if(target == shock && decoyTacticsActiveTurns > 0){
                    if(Math.random()*(100)+1 <= shock.getEvadeRate() && shock.getSkill3Lvl() > 0){
                        attackAnimation(shock, enemy, 2);
                    }
                    else{
                        target.setHp(target.getHp() - (int)(damage * shock.getDamageMitigationPercent()));
                        if(target.getHp() <= 0 && target.getSkill1Lvl() > 0){
                            if(Math.random()*(100)+1 <= shock.getGutsActivationRate()){
                                target.setHp(1);
                            }
                        }
                    }
                }
                else if(target == mike && kingShieldActiveTurns > 0){
                    target.setHp(target.getHp()-(int)(damage * mike.getDamageTakenMultiplier()));
                }
                else{
                    if(target == shock){
                        if(Math.random()*(100)+1 <= shock.getEvadeRate() && shock.getSkill3Lvl() > 0){
                            attackAnimation(shock, enemy, 2);
                        }
                        else{
                            target.setHp(target.getHp()-(int)(damage));
                            if(target.getHp() <= 0 && target.getSkill1Lvl() > 0){
                                if(Math.random()*(100)+1 <= shock.getGutsActivationRate()){
                                    target.setHp(1);
                                }
                            }
                        }
                    }
                    else{
                        target.setHp(target.getHp()-(int)(damage));
                        if(target == nagito && target.getHp() <= 0 && nagito.getFuryStacks() >= 6){
                            target.setHp(1);
                            nagito.setCooldownTurns(2);
                            nagito.setFuryStacks(nagito.getFuryStacks() - 6);
                            nagito.setCooldownHeal(true);
                        }
                    }
                }
                if(target.getHp() < 0)
                {
                    target.setHp(0);
                }
                showBattleElements();
                Greenfoot.delay(15);
            }
        }

        if(enemy.getHp() != 0){
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

        showBattleElements();
    }

    public void enemyAttack(Enemy enemy){
        Character target = null;
        if(shockBurst && shock.getHp() > 0){
            target = shock;
        }
        else if(mikeBurst && mike.getHp() > 0){
            target = mike;
        }
        else if(enemy == tauntedTarget && mike.getHp() > 0){
            target = mike;
            if(decoyTacticsActiveTurns > 0 && target == characterProtected){
                target = shock;
            }
        }
        else if(kingShieldActiveTurns <= 0 || mike.getHp() <= 0){
            int drawRate = (int)(Math.random()*100+1);
            if((drawRate <= 25)){
                //addObject(new AttackAnimation(),member1Sprite.getX(),member1.getY());
                if(party.getMember1().getHp() > 0)
                    target = party.getMember1();
                else if(party.getMember2().getHp() > 0)
                    target = party.getMember2();
                else if(party.getMember3().getHp() > 0)
                    target = party.getMember3();
                else if(party.getMember4().getHp() > 0)
                    target = party.getMember4();

                if(decoyTacticsActiveTurns > 0 && target == characterProtected && shock.getHp() > 0){
                    target = shock;
                }
            }
            else if(drawRate <= 50){
                //addObject(new AttackAnimation(),member1Sprite.getX(),member2.getY());
                if(party.getMember2().getHp() > 0)
                    target = party.getMember2();
                else if(party.getMember3().getHp() > 0)
                    target = party.getMember3();
                else if(party.getMember4().getHp() > 0)
                    target = party.getMember4();
                else if(party.getMember1().getHp() > 0)
                    target = party.getMember1();

                if(decoyTacticsActiveTurns > 0 && target == characterProtected && shock.getHp() > 0){
                    target = shock;
                }
            }
            else if(drawRate <= 75){
                //addObject(new AttackAnimation(),member1Sprite.getX(),member3.getY());
                if(party.getMember3().getHp() > 0)
                    target = party.getMember3();
                else if(party.getMember4().getHp() > 0)
                    target = party.getMember4();
                else if(party.getMember1().getHp() > 0)
                    target = party.getMember1();
                else if(party.getMember2().getHp() > 0)
                    target = party.getMember2();

                if(decoyTacticsActiveTurns > 0 && target == characterProtected && shock.getHp() > 0){
                    target = shock;
                }
            }
            else{
                //addObject(new AttackAnimation(),member1Sprite.getX(),member4.getY());
                if(party.getMember4().getHp() > 0)
                    target = party.getMember4();
                else if(party.getMember1().getHp() > 0)
                    target = party.getMember1();
                else if(party.getMember2().getHp() > 0)
                    target = party.getMember2();
                else if(party.getMember3().getHp() > 0)
                    target = party.getMember3();
                if(decoyTacticsActiveTurns > 0 && target == characterProtected && shock.getHp() > 0){
                    target = shock;
                }
            }
        }
        else if(kingShieldActiveTurns > 0 && mike.getHp() > 0){
            target = mike;
            if(decoyTacticsActiveTurns > 0 && target == characterProtected && shock.getHp() > 0){
                target = shock;
            }
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
                    if(agressor.getSkill2Lvl() > 0)
                        addObject(new SkillOverlayButton(agressor,2), 902, 600);
                    if(agressor.getSkill4Lvl() > 0)
                        addObject(new SkillOverlayButton(agressor,4), 902, 630);
                    break;
                case 4:
                    if(agressor.getSkill1Lvl() > 0)
                        addObject(new SkillOverlayButton(agressor,1), 902, 600);
                    if(agressor.getSkill2Lvl() > 0)
                        addObject(new SkillOverlayButton(agressor,2), 902, 630);
                    break;
                case 5:
                case 7:
                    if(agressor.getSkill2Lvl() > 0)
                        addObject(new SkillOverlayButton(agressor,2), 902, 600);
                    if(agressor.getSkill3Lvl() > 0)
                        addObject(new SkillOverlayButton(agressor,3), 902, 630);
                    if(agressor.getSkill4Lvl() > 0)
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
        if(party.getMember1().getHp() > 0 && (party.getMember1().getId() == 5 || party.getMember1() != agressor)){
            addObject(new AllyButton(party.getMember1(),agressor,skillNumber), 902, 600);
        }
        if(party.getMember2().getHp() > 0 && (party.getMember2().getId() == 5 || party.getMember2() != agressor)){
            addObject(new AllyButton(party.getMember2(),agressor,skillNumber), 902, 630);
        }
        if(party.getMember3().getHp() > 0 && (party.getMember3().getId() == 5 || party.getMember3() != agressor)){
            addObject(new AllyButton(party.getMember3(),agressor,skillNumber), 902, 660);
        }
        if(party.getMember4().getHp() > 0 && (party.getMember4().getId() == 5 || party.getMember4() != agressor)){
            addObject(new AllyButton(party.getMember4(),agressor,skillNumber), 902, 690);
        }
    }

    public void chaosOverlimit(){
        Sokudo agressor = (Sokudo) this.agressor;
        attackSfx[0].play();

        double entreatMultiplier = 1;
        int padalustroMultiplier = 1;

        if(entreatIsActive){
            entreatMultiplier = 1 + rengoku.getSkill3AtkMultiplier();
        }

        if(padalustroIsActive && agressor == lustredCharacter){
            padalustroMultiplier = 2;
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<agressor.getSkill2HitCount(); j++){
                int damage = padalustroMultiplier * (int)Math.ceil(((((agressor.getAtk() * entreatMultiplier)*agressor.getSkill2AtkUsedPercent())-(enemy[i].getDef() * ((Sokudo) agressor).getDefIgnorePercent()))));
                enemy[i].setHp(enemy[i].getHp()-damage);
                if(!enemy[i].isParalyzed() && agressor.getSkill1Lvl() > 0){
                    enemy[i].setTemporalVoidStack(enemy[i].getTemporalVoidStack() + 1);
                    if(enemy[i].getTemporalVoidStack() == ((Sokudo) agressor).getStacksRequired()){
                        enemy[i].setParalysisStatus(true);
                    }
                }
                if(enemy[i].getHp() < 0)
                    enemy[i].setHp(0);
                if(target.getHp() == 0)
                    changeToTargetAlive();
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
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void staticCharge(){
        if(!staticCharge){
            Sokudo agressor = (Sokudo) this.agressor;
            agressor.setAtk((int)Math.ceil((agressor.getAtk() * agressor.getSkill4DamageMultiplier())));
            staticCharge = true;
            agressor.setSp(agressor.getSp() - agressor.getSkill4SpCost());

            agressor.setAttackStatus(false);
            this.agressor = null;
            if(nagitoBurst)
                attackAnimation(nagito, this.target, 0);
        }
    }

    public void warpStrike(){
        Enemy target = null;
        if(enemy[0].getHp() > 0){
            target = enemy[0];
            for(int i = 1; i < 4; i++){
                if(enemy[i].getHp() > 0 && enemy[i].getHp() < target.getHp()){
                    target = enemy[i];
                }
            }
        }
        else if(enemy[1].getHp() > 0){
            target = enemy[1];
            for(int i = 2; i < 4; i++){
                if(enemy[i].getHp() > 0 && enemy[i].getHp() < target.getHp()){
                    target = enemy[i];
                }
            }
        }
        else if(enemy[2].getHp() > 0){
            target = enemy[2];
            if(enemy[3].getHp() > 0 && enemy[3].getHp() < target.getHp())
                target = enemy[3];
        }
        else if(enemy[3].getHp() > 0)
            target = enemy[3];

        attackAnimation(findCharacter(1), target, 1);
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
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void transfusion(Character target){
        agressor.setHp(agressor.getHp() - (int)Math.ceil((agressor.getHp() * ((Light) agressor).getSelfHpDamagePercent())));
        target.setSp(target.getSp() + ((Light) agressor).getAllySpRecoveryPercent());
        if(target.getSp() > target.getMaxSp()){
            target.setSp(target.getMaxSp());
        }
        agressor.setSp(agressor.getSp() - ((Light) agressor).getSkill4SpCost() + ((Light) agressor).getSelfSpRecovery());

        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void vileFeast(){
        vileFeastActiveTurns = ((Shock) agressor).getSkill2ActiveTurns();
        agressor.setSp(agressor.getSp() - ((Shock) agressor).getSkill2SpCost());

        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
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
            shock.setHp((int)(shock.getHp() + (shock.getMaxHp() * shock.getHpRecoveryPercent())));
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
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void kingShield(){
        kingShieldActiveTurns = ((Mike)agressor).getSkill1ActiveTurns();
        agressor.setSp(agressor.getSp() - ((Mike) agressor).getSkill1SpCost());

        agressor.setAttackStatus(false);
        agressor = null;

        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void allEyezOnMe(){
        allEyezOnMeActiveTurns = ((Mike)agressor).getSkill2ActiveTurns();
        agressor.setSp(agressor.getSp() - ((Mike) agressor).getSkill2SpCost());
        tauntedTarget = target;

        agressor.setAttackStatus(false);
        agressor = null;

        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void holyFlameTrigger(){
        for(int i = 0; i < 4; i++){
            double burn = enemy[i].getMaxHp() * ((Rengoku)agressor).getHolyFlameHpDamagePercent();
            if(burn < 1)
                burn = 1;
            enemy[i].setHp(enemy[i].getHp()- (int)burn);
            if(enemy[i].getHp() < 0)
                enemy[i].setHp(0);
        }
    }

    public void prayer(Character target){
        double healAmount = target.getMaxHp() * ((Rengoku)agressor).getSkill2AllyHpRecoveryPercent();
        if(target.getHealFlag()){
            target.setHp(target.getHp() + (int)healAmount);
            if(target.getHp() > target.getMaxHp()){
                target.setHp(target.getMaxHp());
            }
        }
        holyFlameTrigger();

        agressor.setSp(agressor.getSp() - ((Rengoku) agressor).getSkill2SpCost());

        agressor.setAttackStatus(false);
        agressor = null;
        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void entreat(){
        entreatIsActive = true;
        agressor.setSp(agressor.getSp() - ((Rengoku) agressor).getSkill3SpCost());

        agressor.setAttackStatus(false);
        agressor = null;
        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void cheer(){
        cheerIsActive = true;
        agressor.setSp(agressor.getSp() - ((Rengoku) agressor).getSkill4SpCost());

        agressor.setAttackStatus(false);
        agressor = null;
        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void padalustro(Character target){
        if(Math.random()*(100)+1 <= kingHermes.getSkill4ActivationRate()){
            padalustroIsActive = true;
            lustredCharacter = target;
        }

        agressor.setSp(agressor.getSp() - ((KingHermes) agressor).getSkill4SpCost());

        agressor.setAttackStatus(false);
        agressor = null;
        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void uxiono(Character target){
        target.setSp(target.getSp() + (int)(target.getMaxSp() * ((KingHermes) agressor).getSkill2AllySpRecoveryPercent()));
        if(target.getSp() > target.getMaxSp()){
            target.setSp(target.getMaxSp());
        }
        agressor.setSp(agressor.getSp() - ((KingHermes) agressor).getSkill2SpCost());

        agressor.setAttackStatus(false);
        this.agressor = null;

        showBattleElements();
        if(nagitoBurst)
            attackAnimation(nagito, this.target, 0);
    }

    public void hermesBurst(){
        if(party.getMember1().getHp() > 0)
            party.getMember1().setAttackStatus(true);
        if(party.getMember2().getHp() > 0)
            party.getMember2().setAttackStatus(true);
        if(party.getMember3().getHp() > 0)
            party.getMember3().setAttackStatus(true);
        if(party.getMember4().getHp() > 0)
            party.getMember4().setAttackStatus(true);

        hermesBurst = false;
    }

    /////////////////LUIZZZ/////////////////////////

    /////////////////FIN DE LUIS////////////////////

    public void deepBreath(){
        if(nagito.getFuryStacks() > 0){
            double multiplier = (double)nagito.getFuryStacks()/10;
            nagito.setHp(nagito.getHp() + (int)(nagito.getMaxHp() * multiplier));

            if(nagito.getHp() > nagito.getMaxHp()){
                nagito.setHp(nagito.getMaxHp());
            }

            nagito.setFuryStacks(0);

            agressor.setAttackStatus(false);
            this.agressor = null;

            showBattleElements();
        }
    }

    public void boilingBlood(){
        if(nagito.getFuryStacks() >= 4){
            double multiplier = nagito.getFuryStacks() * nagito.getSkill3StackReleaseMultiplier();

            Nagito agressor = (Nagito) this.agressor;
            attackSfx[0].play();

            double entreatMultiplier = 1;
            int padalustroMultiplier = 1;
            if(entreatIsActive){
                entreatMultiplier = 1 + rengoku.getSkill3AtkMultiplier();
            }

            if(padalustroIsActive && agressor == lustredCharacter){
                padalustroMultiplier = 2;
            }

            for(int i=0; i<4; i++){
                int damage = padalustroMultiplier * (int)(multiplier * Math.ceil(((((agressor.getAtk() * entreatMultiplier))-(enemy[i].getDef())))));
                enemy[i].setHp(enemy[i].getHp()-damage);
                if(enemy[i].getHp() < 0)
                    enemy[i].setHp(0);
            }

            nagito.setFuryStacks(0);

            nagito.setCooldownTurns(2);

            agressor.setAttackStatus(false);
            this.agressor = null;
            showBattleElements();
        }
    }

    public void activateBurst(){
        if(agressor != null && agressor.getUltCharges() == agressor.getUltQuantity()){
            agressor.setUltCharges(0);
            burstVoice = new GreenfootSound("sounds/0" + agressor.getId() + "_burstVoice.mp3");
            burstVoice.play();

            if(agressor == party.getMember1() && !burstMusic.isPlaying()){
                music.stop();
                burstMusic.playLoop();
            }

            switch(agressor.getId()){
                case 1:
                    sokudoBurst = true;
                    break;
                case 2:
                    for(int i = 0; i < 4; i ++){
                        enemy[i].setAtk(enemy[i].getAtk()/2);
                        enemy[i].setDef(enemy[i].getDef()/2);
                    }
                    agressor.setAttackStatus(false);
                    this.agressor = null;
                    break;
                case 3:
                    shockBurst = true;
                    agressor.setAttackStatus(false);
                    this.agressor = null;
                    break;
                case 4:
                    mikeBurst = true;
                    agressor.setAttackStatus(false);
                    this.agressor = null;
                    break;
                case 5:
                    double healAmount;
                    if(party.getMember1().getHealFlag() && party.getMember1().getHp() > 0){
                        healAmount = party.getMember1().getMaxHp() * 0.5;
                        party.getMember1().setHp(party.getMember1().getHp() + (int)healAmount);
                        if(party.getMember1().getHp() > party.getMember1().getMaxHp()){
                            party.getMember1().setHp(party.getMember1().getMaxHp());
                        }
                    }
                    if(party.getMember2().getHealFlag() && party.getMember2().getHp() > 0){
                        healAmount = party.getMember2().getMaxHp() * 0.5;
                        party.getMember2().setHp(party.getMember2().getHp() + (int)healAmount);
                        if(party.getMember2().getHp() > party.getMember2().getMaxHp()){
                            party.getMember2().setHp(party.getMember2().getMaxHp());
                        }
                    }
                    if(party.getMember3().getHealFlag() && party.getMember3().getHp() > 0){
                        healAmount = party.getMember3().getMaxHp() * 0.5;
                        party.getMember3().setHp(party.getMember3().getHp() + (int)healAmount);
                        if(party.getMember3().getHp() > party.getMember3().getMaxHp()){
                            party.getMember3().setHp(party.getMember3().getMaxHp());
                        }
                    }
                    if(party.getMember4().getHealFlag() && party.getMember4().getHp() > 0){
                        healAmount = party.getMember4().getMaxHp() * 0.5;
                        party.getMember4().setHp(party.getMember4().getHp() + (int)healAmount);
                        if(party.getMember4().getHp() > party.getMember4().getMaxHp()){
                            party.getMember4().setHp(party.getMember4().getMaxHp());
                        }
                    }
                    holyFlameTrigger();

                    entreatIsActive = true;

                    agressor.setAttackStatus(false);
                    agressor = null;
                    showBattleElements();
                    break;
                case 6:
                    hermesBurst = true;

                    agressor.setAttackStatus(false);
                    agressor = null;
                    showBattleElements();
                    break;
                case 7:

                    break;
                case 8:
                    nagitoBurst = true;

                    agressor.setAttackStatus(false);
                    agressor = null;
                    showBattleElements();
                    break;
            }
        }
    }

    public void run(){
        if(agressor.getId() == 6 && kingHermes.getSkill3Lvl() > 0){
            if(Math.random()*(100)+1 < ((KingHermes)agressor).getSkill3RunRate()){
                switch(floor)
                {
                    case 1:
                        FirstFloorRoom.playMusic();
                        Greenfoot.setWorld(new FirstFloorRoom(id,characterX,characterY));
                        break;
                    case 2:
                        SecondFloorRoom.playMusic();
                        Greenfoot.setWorld(new SecondFloorRoom(id,characterX,characterY));
                        break;
                    case 3:
                        SecondFloorRoom.playMusic();
                        Greenfoot.setWorld(new ThirdFloorRoom(id,characterX,characterY));
                        break;
                }
            }
        }
        else{
            if(Math.random()*(100)+1 < 25){
                switch(floor)
                {
                    case 1:
                        FirstFloorRoom.playMusic();
                        Greenfoot.setWorld(new FirstFloorRoom(id,characterX,characterY));
                        break;
                    case 2:
                        SecondFloorRoom.playMusic();
                        Greenfoot.setWorld(new SecondFloorRoom(id,characterX,characterY));
                        break;
                    case 3:
                        SecondFloorRoom.playMusic();
                        Greenfoot.setWorld(new ThirdFloorRoom(id,characterX,characterY));
                        break;
                }
            }
        }
        agressor.setAttackStatus(false);
        agressor = null;
        showBattleElements();
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
            if(enemy[0].hasDarkSigil())
                addObject(darkSigilIcon[0], 40, 65);
        }
        if(enemy[1].getHp() > 0){
            addObject(paralysisIcon[1], 160, 200);
            addObject(poisonIcon[1], 100, 200);
            if(enemy[1].hasDarkSigil())
                addObject(darkSigilIcon[0], 40, 200);
        }
        if(enemy[2].getHp() > 0){
            addObject(paralysisIcon[2], 160, 335);
            addObject(poisonIcon[2], 100, 335);
            if(enemy[2].hasDarkSigil())
                addObject(darkSigilIcon[0], 40, 335);
        }
        if(enemy[3].getHp() > 0){
            addObject(paralysisIcon[3], 160, 470);
            addObject(poisonIcon[3], 100, 470);
            if(enemy[3].hasDarkSigil())
                addObject(darkSigilIcon[0], 40, 470);
        }
    }
}
