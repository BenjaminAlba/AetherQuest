
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World implements Observer
{
    private GreenfootSound menuMusic = new GreenfootSound("sounds/menu.mp3");
    private Image[] cogs = new Image[8];
    private GreenfootSound cogTurn = new GreenfootSound("sounds/ticking_clock.mp3");
    private int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        NewGame newGameButton = new NewGame();
        
        setBackground("images/menu/background.png");
        addCogs();
        addObject(new Image("images/menu/menu_01.png"),640,360);
        addObject(new Button(),640,360);
        addObject(new Continue(),640,360);
        addObject(newGameButton,640,360);
        addObject(new Help(),640,360);
        
        newGameButton.addObserver(this);
    }
    
    public void eventOcurred(){
        menuMusic.stop();
    }
    
    public void addCogs(){
        cogs[0] = new Image("images/menu/menu_cog.png");
        cogs[1] = new Image("images/menu/menu_cog.png");
        cogs[2] = new Image("images/menu/menu_cog.png");
        cogs[3] = new Image("images/menu/menu_cog.png");
        cogs[4] = new Image("images/menu/menu_cog.png");
        cogs[5] = new Image("images/menu/menu_cog.png");
        cogs[6] = new Image("images/menu/menu_cog.png");
        cogs[7] = new Image("images/menu/menu_cog.png");

        cogs[1].scale(-200,-200);
        cogs[2].scale(-300,-300);
        cogs[4].scale(-100,-100);
        cogs[6].scale(-300,-300);
        cogs[7].scale(-100,-100);

        addObject(cogs[0], 400, 350);
        addObject(cogs[1], 1010, 400);
        addObject(cogs[2], 750, 325);
        addObject(cogs[3], 950, 0);
        addObject(cogs[4], 750, 650);
        addObject(cogs[5], 50, 720);
        addObject(cogs[6], 615, 75);
        addObject(cogs[7], 50, 50);
    }

    public void rotateCogs(){
        if(counter == 0){
            cogTurn.play();
            for(int i=0;i<8;i++){
                cogs[i].rotate(120);
            }
        }
        counter = (counter + 1)%60;
    }

    public void act(){
        rotateCogs();
    }

    public void started(){
        menuMusic.playLoop();
    }
}
