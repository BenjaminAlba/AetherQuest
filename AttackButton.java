import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage state0 = new GreenfootImage("images/battle_resources/attack-icon.png");
    private GreenfootImage state1 = new GreenfootImage("images/battle_resources/attack-icon-hover.png");
    private Character agressor;
    private Enemy target;
    private boolean mouseOver = false;
    public AttackButton(){
        setImage(state0);
    }

    public void changeState(){
        if(Greenfoot.mouseMoved(null))
            mouseOver = Greenfoot.mouseMoved(this);

        if(mouseOver)
            setImage(state1);
        else
            setImage(state0);
    }

    public void setAgressor(Character agressor){
        this.agressor = agressor;
    }

    public Character getAgressor(){
        return agressor;
    }

    public void setTarget(Enemy target){
        this.target = target;
    }

    public Enemy getTarget(){
        return target;
    }

    public void act()
    {
        changeState();
        if(agressor.getHp() == 0){
            BattleEnvironment battleWorld = (BattleEnvironment)getWorld();
            battleWorld.changeAgressor(agressor);
        }
        if(Greenfoot.mousePressed(this)){
            BattleEnvironment battleWorld = (BattleEnvironment)getWorld();
            buttonClick.play();
            battleWorld.attack(agressor, target);
            if(target.getHp() == 0)
                battleWorld.changeToTargetAlive();
            battleWorld.updateBattle();
        }
    }
}
