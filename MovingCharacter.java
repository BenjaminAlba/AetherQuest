import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Sokudo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingCharacter extends Actor
{
    /**
     * Act - do whatever the Sokudo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 5;
    private int verticalCurrentImage;
    private int horizontalCurrentImage;
    private int counter;
    private int direccion;
    private GreenfootImage downIdle;
    private ArrayList<GreenfootImage> downWalk;
    private GreenfootImage upIdle;
    private ArrayList<GreenfootImage> upWalk;
    private GreenfootImage rightIdle;
    private ArrayList<GreenfootImage> rightWalk;
    private GreenfootImage leftIdle;
    private ArrayList<GreenfootImage> leftWalk;
    private List<Observer> observers = new LinkedList();
    
    public MovingCharacter(String id){
        GreenfootImage walkInstance;

        downWalk = new ArrayList<>();

        downIdle = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_downidle.png");
        downIdle.scale(downIdle.getWidth()+100,downIdle.getHeight()+100);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_downwalk1.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        downWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_downwalk2.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        downWalk.add(walkInstance);

        downWalk.add(downIdle);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_downwalk3.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        downWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_downwalk4.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        downWalk.add(walkInstance);

        downWalk.add(downIdle);

        upWalk = new ArrayList<>();

        upIdle = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_upidle.png");
        upIdle.scale(upIdle.getWidth()+100,upIdle.getHeight()+100);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_upwalk1.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        upWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_upwalk2.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        upWalk.add(walkInstance);

        upWalk.add(upIdle);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_upwalk3.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        upWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_upwalk4.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        upWalk.add(walkInstance);

        upWalk.add(upIdle);

        rightWalk = new ArrayList<>();

        rightIdle = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sideidle.png");
        rightIdle.scale(rightIdle.getWidth()+100,rightIdle.getHeight()+100);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk1.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk2.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk3.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk4.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk5.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk6.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk7.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk8.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk9.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        rightWalk.add(walkInstance);

        leftWalk = new ArrayList<>();

        leftIdle = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sideidle.png");
        leftIdle.scale(leftIdle.getWidth()+100,leftIdle.getHeight()+100);
        leftIdle.mirrorHorizontally();

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk1.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk2.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk3.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk4.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk5.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk6.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk7.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk8.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        walkInstance = new GreenfootImage("images/character_sprites/"+id+"/"+id+"_sidewalk9.png");
        walkInstance.scale(walkInstance.getWidth()+100,walkInstance.getHeight()+100);
        walkInstance.mirrorHorizontally();
        leftWalk.add(walkInstance);

        setImage(downIdle);
    }

    public void act() 
    {
        handleDirection();
        characterInteract();
    }
    
    void characterInteract(){
        if(Greenfoot.isKeyDown("enter") && isTouching(Image.class)){
            World room = getWorld();
            PrologueRoom actualRoom = (PrologueRoom)room;
            actualRoom.sokudoRecruitScene();
        }
    }
    
    public void checkCollision(int x, int y){
        if(getOneObjectAtOffset(x,y,Door.class) != null){
            Door door = (Door)getOneObjectAtOffset(x,y,Door.class);
            door.changeRoom();
        }
        if(getOneObjectAtOffset(x,y,Image.class) != null){
            speed = 0;
        }
    }

    public void handleDirection(){
        speed = 5;
        int x = getX();
        int y = getY();

        if(Greenfoot.isKeyDown("w")){
            Actor collide=getOneObjectAtOffset(0,12,Wall.class);
            if(collide!=null)
                speed=0;
            checkCollision(0,12);
            setLocation(x, y - speed);
            upWalk();
            direccion = 1;
        }
        else if(!Greenfoot.isKeyDown("w") && direccion == 1){
            counter = 0;
            verticalCurrentImage = 0;
            direccion = 0;
            setImage(upIdle);
        }
        else if(Greenfoot.isKeyDown("s")){
            Actor collide=getOneObjectAtOffset(0,51,Wall.class);
            if(collide!=null)
                speed=0;
            checkCollision(0,51);
            setLocation(x, y + speed);
            downWalk();
            direccion = 2;
        }
        else if(!Greenfoot.isKeyDown("s") && direccion == 2){
            counter = 0;
            verticalCurrentImage = 0;
            direccion = 0;
            setImage(downIdle);
        }
        else if(Greenfoot.isKeyDown("a")){
            Actor collide=getOneObjectAtOffset(-18,20,Wall.class);
            if(collide!=null)
                speed=0;
            checkCollision(-18,20);
            setLocation(x - speed, y);
            leftWalk();
            direccion = 3;
        }
        else if(!Greenfoot.isKeyDown("a") && direccion == 3){
            counter = 0;
            horizontalCurrentImage = 0;
            direccion = 0;
            setImage(leftIdle);
        }
        else if(Greenfoot.isKeyDown("d")){
            Actor collide=getOneObjectAtOffset(18,20,Wall.class);
            if(collide!=null)
                speed=0;
            checkCollision(18,20);
            setLocation(x + speed, y);
            rightWalk();
            direccion = 4;
        }
        else if(!Greenfoot.isKeyDown("d") && direccion == 4){
            counter = 0;
            horizontalCurrentImage = 0;
            direccion = 0;
            setImage(rightIdle);
        }
    }

    public void leftWalk(){
        if(counter == 0){
            setImage(leftWalk.get(horizontalCurrentImage));
            horizontalCurrentImage = (horizontalCurrentImage + 1) % leftWalk.size();            
        }
        counter = (counter + 1)%3;
    }

    public void rightWalk(){
        if(counter == 0){
            setImage(rightWalk.get(horizontalCurrentImage));
            horizontalCurrentImage = (horizontalCurrentImage + 1) % rightWalk.size();   
        }
        counter = (counter + 1)%3;
    }

    public void upWalk(){
        if(counter == 0){
            setImage(upWalk.get(verticalCurrentImage));
            verticalCurrentImage = (verticalCurrentImage + 1) % upWalk.size();            
        }
        counter = (counter + 1)%6;
    }

    public void downWalk(){
        if(counter == 0){
            setImage(downWalk.get(verticalCurrentImage));
            verticalCurrentImage = (verticalCurrentImage + 1) % downWalk.size();            
        }
        counter = (counter + 1)%6;
    }
}