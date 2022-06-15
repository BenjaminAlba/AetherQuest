import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkillButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage state0 = new GreenfootImage("images/battle_resources/skill-icon.png");
    private GreenfootImage state1 = new GreenfootImage("images/battle_resources/skill-icon-hover.png");
    private boolean mouseOver = false;
    
    public SkillButton(){
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
    
    public void checkClick(){
        if(Greenfoot.mouseClicked(this)){
            buttonClick.play();
            BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
            battleWorld.showSkills();
        }
    }
    
    public void act()
    {
        changeState();
        checkClick();
    }
}
