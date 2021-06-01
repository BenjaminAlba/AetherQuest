import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private Image image;
    GreenfootImage buttons = new GreenfootImage("images/menu/menu_02.png");
    GreenfootSound button_click = new GreenfootSound("sounds/button_click.mp3");
    private List<Observer> observers = new LinkedList();

    public Button(){
        setImage(buttons);
    }

    public void addObserver(Observer observer){
        observers.add(observer);
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
            for(Observer observer: observers){
                observer.eventOcurred();
            }
            button_click.play();
            Greenfoot.setWorld(world);
    }
}
