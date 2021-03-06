import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondFloorTrapDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondFloorTrapDoor extends TrapDoor
{
    public static final int OPEN = 1;
    private GreenfootImage open = new GreenfootImage("images/trap_door/trap_door_open.png");
    private GreenfootImage closed = new GreenfootImage("images/trap_door/trap_door_closed.png");
    private int state;
    public SecondFloorTrapDoor(int state){
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
            SecondFloorRoom.stopMusic();
            ThirdFloorRoom.playMusic();
            Greenfoot.setWorld(new ThirdFloorRoom("01",640,360));
        }
    } 
}
