
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World implements Observer
{
    private static GreenfootSound menuMusic = new GreenfootSound("sounds/menu.mp3");
    private Image[] gears = new Image[8];
    private GreenfootSound gearTurn = new GreenfootSound("sounds/ticking_clock.mp3");
    private int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("images/menu/background.png");
        addGears();
        addObject(new Image("images/menu/menu_01.png"),640,360);
        addObject(new Image("images/menu/menu_02.png"),640,360);
        addObject(new Continue(),640,360);
        addObject(new NewGame(this),640,360);
        addObject(new Help(),640,360);
    }
    
    public void eventOcurred(){
        MainMenu.menuMusic.stop();
    }

    public void addGears(){
        gears[0] = new Image("images/menu/menu_cog.png");
        gears[1] = new Image("images/menu/menu_cog.png");
        gears[2] = new Image("images/menu/menu_cog.png");
        gears[3] = new Image("images/menu/menu_cog.png");
        gears[4] = new Image("images/menu/menu_cog.png");
        gears[5] = new Image("images/menu/menu_cog.png");
        gears[6] = new Image("images/menu/menu_cog.png");
        gears[7] = new Image("images/menu/menu_cog.png");

        gears[1].scale(-200,-200);
        gears[2].scale(-300,-300);
        gears[4].scale(-100,-100);
        gears[6].scale(-300,-300);
        gears[7].scale(-100,-100);

        addObject(gears[0], 400, 350);
        addObject(gears[1], 1010, 400);
        addObject(gears[2], 750, 325);
        addObject(gears[3], 950, 0);
        addObject(gears[4], 750, 650);
        addObject(gears[5], 50, 720);
        addObject(gears[6], 615, 75);
        addObject(gears[7], 50, 50);
    }

    public void rotateGears(){
        if(counter == 0){
            gearTurn.play();
            for(int i=0;i<8;i++){
                gears[i].rotate(120);
            }
        }
        counter = (counter + 1)%60;
    }

    public void act(){
        rotateGears();
    }

    public void started(){
        menuMusic.playLoop();
    }
}
