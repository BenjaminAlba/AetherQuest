import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstSkillButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillOverlayButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage state0 = new GreenfootImage("images/battle_resources/skill_button.png");
    private GreenfootImage state1 = new GreenfootImage("images/battle_resources/skill_button.png");
    private boolean mousePressed = false;
    private boolean mouseOver = false;
    public Character agressor;
    private int skillNumber;
    public SkillOverlayButton(Character agressor, int skillNumber){
        this.agressor = agressor;
        this.skillNumber = skillNumber;
        state0.setColor(Color.BLACK);
        state1.setColor(Color.RED);
        state0.setFont(new Font("Helvetica", false, false, 25));
        state1.setFont(new Font("Helvetica", false, false, 25));
        switch(skillNumber){
            case 1:
                state0.drawString(agressor.getSkill1Name(), 12, 22);
                state1.drawString(agressor.getSkill1Name(), 12, 22);
                break;
            case 2:
                state0.drawString(agressor.getSkill2Name(), 12, 22);
                state1.drawString(agressor.getSkill2Name(), 12, 22);
                break;
            case 3:
                state0.drawString(agressor.getSkill3Name(), 12, 22);
                state1.drawString(agressor.getSkill3Name(), 12, 22);
                break;
            case 4:
                state0.drawString(agressor.getSkill4Name(), 12, 22);
                state1.drawString(agressor.getSkill4Name(), 12, 22);
                break;
        }

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
        if(Greenfoot.mousePressed(null)){
            mousePressed = Greenfoot.mousePressed(this);
            if(mousePressed){
                buttonClick.play();
                switch(skillNumber){
                    case 1:
                        agressor.activateSkill1();
                        break;
                    case 2:
                        agressor.activateSkill2();
                        break;
                    case 3:
                        agressor.activateSkill3();
                        break;
                    case 4:
                        if(agressor.getId() != 2 && agressor.getId() != 3)
                            agressor.activateSkill4();
                        else{
                            BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
                            battleWorld.showTargetAllies(skillNumber);
                        }
                        break;
                }
                getWorld().removeObject(this);
            }
            else
                getWorld().removeObject(this);
        }
    }

    public void act()
    {
        changeState();
        checkClick();
    }
}
