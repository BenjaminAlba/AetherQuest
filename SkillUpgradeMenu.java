import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkillUpgradeMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillUpgradeMenu extends World
{
    public static final int NAGITO = 8;
    private Party party = Party.getInstance();
    private String currentRoom;
    private int characterX;
    private int characterY;
    private GreenfootImage skillsInfo;
    private Character character;
    public SkillUpgradeMenu(Character character, String currentRoom, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        this.character = character;
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
        setBackground("images/ESC_menu/esc_menu_background.png");
        updateText();

    }

    public void updateText(){
        skillsInfo = new GreenfootImage("images/ESC_menu_characters_skills/0"+character.getId()+".png");
        removeObjects(getObjects(null));
        if(character.getId() != NAGITO){
            skillsInfo.setColor(Color.WHITE);
            skillsInfo.setFont(new Font("Helvetica", false, false, 25));
            skillsInfo.drawString("Skill Points: "+character.getSkillPoints(),580,370);
            skillsInfo.drawString(String.valueOf(character.getSkill1Lvl()),100,279);
            skillsInfo.drawString(String.valueOf(character.getSkill2Lvl()),740,279);
            skillsInfo.drawString(String.valueOf(character.getSkill3Lvl()),100,639);
            skillsInfo.drawString(String.valueOf(character.getSkill4Lvl()),740,639);
            addObject(new Image(skillsInfo),640,360);
            addObject(new UpgradeSkillButton(1,character),580,320);
            addObject(new UpgradeSkillButton(2,character),1220,320);
            addObject(new UpgradeSkillButton(3,character),580,680);
            addObject(new UpgradeSkillButton(4,character),1220,680);
        }
        else
            addObject(new Image(skillsInfo),640,360); 

    }

    public void act(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new CharacterSkillMenu(currentRoom,characterX, characterY));
        }
    }
}
