import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AllyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllyButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage state0 = new GreenfootImage("images/battle_resources/skill_button.png");
    private GreenfootImage state1 = new GreenfootImage("images/battle_resources/skill_button.png");
    private boolean mousePressed = false;
    private boolean mouseOver = false; 
    private Character target;
    private Character agressor;
    private int skillNumber;
    public AllyButton(Character target, Character agressor, int skillNumber){
        this.target = target;
        this.skillNumber = skillNumber;
        this.agressor = agressor;
        state0.setColor(Color.BLACK);
        state1.setColor(Color.RED);
        state0.setFont(new Font("Helvetica", false, false, 25));
        state1.setFont(new Font("Helvetica", false, false, 25));

        state0.drawString(target.getName(), 12, 22);
        state1.drawString(target.getName(), 12, 22);

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
                BattleEnvironment2 battleWorld = (BattleEnvironment2)getWorld();
                switch(skillNumber){
                    case 2:
                        if(agressor.getSp() >= agressor.getSkill2SpCost()){
                            if(agressor.getId() == 5){
                                battleWorld.prayer(target);
                            }
                            else if(agressor.getId() == 6){
                                battleWorld.uxiono(target);
                            }
                        }
                        break;
                    case 3:
                        if(agressor.getSp() >= agressor.getSkill3SpCost()){
                            if(agressor.getId() == 5){
                                battleWorld.entreat();
                            }
                        }
                        break;
                    case 4:
                        if(agressor.getSp() >= agressor.getSkill4SpCost()){
                            if(agressor.getId() == 2)
                                battleWorld.transfusion(target);
                            else if(agressor.getId() == 3)
                                battleWorld.decoyTactics(target);
                            else if(agressor.getId() == 5)
                                battleWorld.cheer();
                            else if(agressor.getId() == 6)
                                battleWorld.padalustro(target);
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