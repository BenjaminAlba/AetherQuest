import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstFloorTrapDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstFloorTrapDoor extends TrapDoor
{
    public static final int OPEN = 1;
    private GreenfootImage open = new GreenfootImage("images/trap_door/trap_door_open.png");
    private GreenfootImage closed = new GreenfootImage("images/trap_door/trap_door_closed.png");
    private int state;
    public FirstFloorTrapDoor(int state){
        open.scale(open.getWidth()+60,open.getHeight()+60);
        closed.scale(closed.getWidth()+60,closed.getHeight()+60);
        this.state = state;
        if(state == OPEN)
            setImage(open);
        else
            setImage(closed);
    }   

    public void changeFloor(){
        if(state == OPEN){
            FirstFloorRoom.stopMusic();
            SecondFloorRoom.playMusic();
            Greenfoot.setWorld(new SecondFloorRoom("01",640,360));
        }
    }
}
