import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private int currentImage;
    private int counter;
    private int direccion;
    private GreenfootImage downidle;
    private GreenfootImage downwalk1;
    private GreenfootImage downwalk2;
    private GreenfootImage downwalk3;
    private GreenfootImage downwalk4;
    private GreenfootImage upidle;
    private GreenfootImage upwalk1;
    private GreenfootImage upwalk2;
    private GreenfootImage upwalk3;
    private GreenfootImage upwalk4;
    private GreenfootImage rightidle;
    private GreenfootImage rightwalk1;
    private GreenfootImage rightwalk2;
    private GreenfootImage rightwalk3;
    private GreenfootImage rightwalk4;
    private GreenfootImage rightwalk5;
    private GreenfootImage rightwalk6;
    private GreenfootImage rightwalk7;
    private GreenfootImage rightwalk8;
    private GreenfootImage rightwalk9;
    private GreenfootImage leftidle;
    private GreenfootImage[] leftWalk;
    private GreenfootImage leftwalk1;
    private GreenfootImage leftWalk[1];
    private GreenfootImage leftWalk[2];
    private GreenfootImage leftWalk[3];
    private GreenfootImage leftWalk[4];
    private GreenfootImage leftWalk[5];
    private GreenfootImage leftWalk[6];
    private GreenfootImage leftWalk[7];
    private GreenfootImage leftwalk9;

    public MovingCharacter(){
        downidle = new GreenfootImage("images/character_sprites/00/00_downidle.png");
        downidle.scale(downidle.getWidth()+100,downidle.getHeight()+100);

        downwalk1 = new GreenfootImage("images/character_sprites/00/00_downwalk1.png");
        downwalk1.scale(downwalk1.getWidth()+100,downwalk1.getHeight()+100);

        downwalk2 = new GreenfootImage("images/character_sprites/00/00_downwalk2.png");
        downwalk2.scale(downwalk2.getWidth()+100,downwalk2.getHeight()+100);

        downwalk3 = new GreenfootImage("images/character_sprites/00/00_downwalk3.png");
        downwalk3.scale(downwalk3.getWidth()+100,downwalk3.getHeight()+100);

        downwalk4 = new GreenfootImage("images/character_sprites/00/00_downwalk4.png");
        downwalk4.scale(downwalk4.getWidth()+100,downwalk4.getHeight()+100);

        upidle = new GreenfootImage("images/character_sprites/00/00_upidle.png");
        upidle.scale(upidle.getWidth()+100,upidle.getHeight()+100);

        upwalk1 = new GreenfootImage("images/character_sprites/00/00_upwalk1.png");
        upwalk1.scale(upwalk1.getWidth()+100,upwalk1.getHeight()+100);

        upwalk2 = new GreenfootImage("images/character_sprites/00/00_upwalk2.png");
        upwalk2.scale(upwalk2.getWidth()+100,upwalk2.getHeight()+100);

        upwalk3 = new GreenfootImage("images/character_sprites/00/00_upwalk3.png");
        upwalk3.scale(upwalk3.getWidth()+100,upwalk3.getHeight()+100);

        upwalk4 = new GreenfootImage("images/character_sprites/00/00_upwalk4.png");
        upwalk4.scale(upwalk4.getWidth()+100,upwalk4.getHeight()+100);

        rightidle = new GreenfootImage("images/character_sprites/00/00_sideidle.png");
        rightidle.scale(rightidle.getWidth()+100,rightidle.getHeight()+100);

        rightwalk1 = new GreenfootImage("images/character_sprites/00/00_sidewalk1.png");
        rightwalk1.scale(rightwalk1.getWidth()+100,rightwalk1.getHeight()+100);

        rightwalk2 = new GreenfootImage("images/character_sprites/00/00_sidewalk2.png");
        rightwalk2.scale(rightwalk2.getWidth()+100,rightwalk2.getHeight()+100);

        rightwalk3 = new GreenfootImage("images/character_sprites/00/00_sidewalk3.png");
        rightwalk3.scale(rightwalk3.getWidth()+100,rightwalk3.getHeight()+100);

        rightwalk4 = new GreenfootImage("images/character_sprites/00/00_sidewalk4.png");
        rightwalk4.scale(rightwalk4.getWidth()+100,rightwalk4.getHeight()+100);

        rightwalk5 = new GreenfootImage("images/character_sprites/00/00_sidewalk5.png");
        rightwalk5.scale(rightwalk5.getWidth()+100,rightwalk5.getHeight()+100);

        rightwalk6 = new GreenfootImage("images/character_sprites/00/00_sidewalk6.png");
        rightwalk6.scale(rightwalk6.getWidth()+100,rightwalk6.getHeight()+100);

        rightwalk7 = new GreenfootImage("images/character_sprites/00/00_sidewalk7.png");
        rightwalk7.scale(rightwalk7.getWidth()+100,rightwalk7.getHeight()+100);

        rightwalk8 = new GreenfootImage("images/character_sprites/00/00_sidewalk8.png");
        rightwalk8.scale(rightwalk8.getWidth()+100,rightwalk8.getHeight()+100);

        rightwalk9 = new GreenfootImage("images/character_sprites/00/00_sidewalk9.png");
        rightwalk9.scale(rightwalk9.getWidth()+100,rightwalk9.getHeight()+100);

        leftidle = new GreenfootImage("images/character_sprites/00/00_sideidle.png");
        leftidle.scale(leftidle.getWidth()+100,leftidle.getHeight()+100);
        leftidle.mirrorHorizontally();

        leftWalk = new GreenfootImage[8];
        leftWalk[0] = new GreenfootImage("images/character_sprites/00/00_sidewalk1.png");
        leftWalk[0].scale(leftWalk[0].getWidth()+100,leftWalk[0].getHeight()+100);
        leftWalk[0].mirrorHorizontally();

        leftWalk[1] = new GreenfootImage("images/character_sprites/00/00_sidewalk2.png");
        leftWalk[1].scale(leftWalk[1].getWidth()+100,leftWalk[1].getHeight()+100);
        leftWalk[1].mirrorHorizontally();

        leftWalk[2] = new GreenfootImage("images/character_sprites/00/00_sidewalk3.png");
        leftWalk[2].scale(leftWalk[2].getWidth()+100,leftWalk[2].getHeight()+100);
        leftWalk[2].mirrorHorizontally();

        leftWalk[3] = new GreenfootImage("images/character_sprites/00/00_sidewalk4.png");
        leftWalk[3].scale(leftWalk[3].getWidth()+100,leftWalk[3].getHeight()+100);
        leftWalk[3].mirrorHorizontally();

        leftWalk[4] = new GreenfootImage("images/character_sprites/00/00_sidewalk5.png");
        leftWalk[4].scale(leftWalk[4].getWidth()+100,leftWalk[4].getHeight()+100);
        leftWalk[4].mirrorHorizontally();

        leftWalk[5] = new GreenfootImage("images/character_sprites/00/00_sidewalk6.png");
        leftWalk[5].scale(leftWalk[5].getWidth()+100,leftWalk[5].getHeight()+100);
        leftWalk[5].mirrorHorizontally();

        leftWalk[6] = new GreenfootImage("images/character_sprites/00/00_sidewalk7.png");
        leftWalk[6].scale(leftWalk[6].getWidth()+100,leftWalk[6].getHeight()+100);
        leftWalk[6].mirrorHorizontally();

        leftWalk[7] = new GreenfootImage("images/character_sprites/00/00_sidewalk8.png");
        leftWalk[7].scale(leftWalk[7].getWidth()+100,leftWalk[7].getHeight()+100);
        leftWalk[7].mirrorHorizontally();

        leftwalk9 = new GreenfootImage("images/character_sprites/00/00_sidewalk9.png");
        leftwalk9.scale(leftWalk[8].getWidth()+100,leftWalk[8].getHeight()+100);
        leftWalk[8].mirrorHorizontally();

        setImage(downidle);
    }

    public void act() 
    {
        handleDirection();
    }

    public void handleDirection(){
        int speed = 3;
        int x = getX();
        int y = getY();

        if(Greenfoot.isKeyDown("w")){
            Actor collide=getOneObjectAtOffset(0,12,Wall.class);
            if(collide!=null)
                speed=0;
            setLocation(x, y - speed);
            upWalk();
            direccion = 1;
        }
        else if(!Greenfoot.isKeyDown("w") && direccion == 1){
            counter = 0;
            currentImage = 0;
            direccion = 0;
            setImage(upidle);
        }
        if(Greenfoot.isKeyDown("s")){
            Actor collide=getOneObjectAtOffset(0,51,Wall.class);
            if(collide!=null)
                speed=0;
            setLocation(x, y + speed);
            downWalk();
            direccion = 2;
        }
        else if(!Greenfoot.isKeyDown("s") && direccion == 2){
            counter = 0;
            currentImage = 0;
            direccion = 0;
            setImage(downidle);
        }
        if(Greenfoot.isKeyDown("a")){
            Actor collide=getOneObjectAtOffset(-18,20,Wall.class);
            if(collide!=null)
                speed=0;
            setLocation(x - speed, y);
            leftWalk();
            direccion = 3;
        }
        else if(!Greenfoot.isKeyDown("a") && direccion == 3){
            counter = 0;
            currentImage = 0;
            direccion = 0;
            setImage(leftidle);
        }
        if(Greenfoot.isKeyDown("d")){
            Actor collide=getOneObjectAtOffset(18,20,Wall.class);
            if(collide!=null)
                speed=0;
            setLocation(x + speed, y);
            rightWalk();
            direccion = 4;
        }
        else if(!Greenfoot.isKeyDown("d") && direccion == 4){
            counter = 0;
            currentImage = 0;
            direccion = 0;
            setImage(rightidle);
        }
    }

    public void leftWalk(){
        if(counter == 0){
            if(currentImage == 0)
                setImage(leftidle);
            if(currentImage == 1)
                setImage(leftwalk1);
            if(currentImage == 2)
                setImage(leftWalk[1]);
            if(currentImage == 3)
                setImage(leftWalk[2]);
            if(currentImage == 4)
                setImage(leftWalk[3]);
            if(currentImage == 5)
                setImage(leftWalk[4]);
            if(currentImage == 6)
                setImage(leftWalk[5]);
            if(currentImage == 7)
                setImage(leftWalk[6]);
            if(currentImage == 8)
                setImage(leftWalk[7]);
            if(currentImage == 9)
                setImage(leftWalk[8]);
            currentImage = (currentImage + 1)%10;            
        }
        counter = (counter + 1)%3;
    }

    public void rightWalk(){
        if(counter == 0){
            if(currentImage == 0)
                setImage(rightidle);
            if(currentImage == 1)
                setImage(rightwalk1);
            if(currentImage == 2)
                setImage(rightwalk2);
            if(currentImage == 3)
                setImage(rightwalk3);
            if(currentImage == 4)
                setImage(rightwalk4);
            if(currentImage == 5)
                setImage(rightwalk5);
            if(currentImage == 6)
                setImage(rightwalk6);
            if(currentImage == 7)
                setImage(rightwalk7);
            if(currentImage == 8)
                setImage(rightwalk8);
            if(currentImage == 9)
                setImage(rightwalk9);
            currentImage = (currentImage + 1)%10;            
        }
        counter = (counter + 1)%3;
    }

    public void upWalk(){
        if(counter == 0){
            if(currentImage == 0)
                setImage(upwalk1);
            if(currentImage == 1)
                setImage(upwalk2);
            if(currentImage == 2)
                setImage(upidle);
            if(currentImage == 3)
                setImage(upwalk3);
            if(currentImage == 4)
                setImage(upwalk4);
            if(currentImage == 5)
                setImage(upidle);
            currentImage = (currentImage + 1)%6;            
        }
        counter = (counter + 1)%6;
    }

    public void downWalk(){
        if(counter == 0){
            if(currentImage == 0)
                setImage(downwalk1);
            if(currentImage == 1)
                setImage(downwalk2);
            if(currentImage == 2)
                setImage(downidle);
            if(currentImage == 3)
                setImage(downwalk3);
            if(currentImage == 4)
                setImage(downwalk4);
            if(currentImage == 5)
                setImage(downidle);
            currentImage = (currentImage + 1)%6;            
        }
        counter = (counter + 1)%6;
    }
}
