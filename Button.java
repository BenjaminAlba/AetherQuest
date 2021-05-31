import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private Image image;
    private GreenfootImage buttons = new GreenfootImage("images/menu/menu_02.png");
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    public Button(){
        setImage(buttons);
    }

    protected boolean checkMouse(GreenfootImage state0, GreenfootImage state1, int x1, int y1, int width, int height){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int x=0, y=0;
        if(mouse != null){
            x = mouse.getX();
            y = mouse.getY();
        }
        if((x>x1 && x<x1+width) && (y>y1 && y<y1+height)){
            setImage(state1);
            if(mouse.getButton() == 1)
                return true;
        }
        else
            setImage(state0);
        return false;
    }

    protected void checkClick(World world){
            buttonClick.play();
            Greenfoot.setWorld(world);
    }
}
