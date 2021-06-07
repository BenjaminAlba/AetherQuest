import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeSkillButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeSkillButton extends Button
{
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private Character character;
    private int skillNumber;
    public UpgradeSkillButton(int skillNumber, Character character){
        this.character = character;
        this.skillNumber = skillNumber;
        setImage("images/ESC_menu_characters_skills/upgrade_icon.png");
    }

    public void checkSkillNumber(){
        World world = getWorld();
        SkillUpgradeMenu menu = (SkillUpgradeMenu) world;
        switch(skillNumber){
            case 1:
            character.upgradeSkill1();
            break;
            case 2:
            character.upgradeSkill2();
            break;
            case 3:
            character.upgradeSkill3();
            break;
            case 4:
            character.upgradeSkill4();
            break;
        }
        menu.updateText();
    }

    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            buttonClick.play();
            checkSkillNumber();
        }
    }    
}
