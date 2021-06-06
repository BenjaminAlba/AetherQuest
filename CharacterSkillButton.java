import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSkillsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSkillButton extends Button
{
    private Character character;
    private GreenfootSound buttonClick = new GreenfootSound("sounds/button_click.mp3");
    private GreenfootImage characterSkillButton;
    private String currentRoom;
    private int characterX;
    private int characterY;
    public CharacterSkillButton(Character character, String currentRoom, int characterX, int characterY){
        this.character = character;
        this.currentRoom = currentRoom;
        this.characterX = characterX;
        this.characterY = characterY;
        characterSkillButton = new GreenfootImage("images/ESC_menu_characters/0"+this.character.getId()+".png");
        characterSkillButton.setColor(Color.WHITE);
        characterSkillButton.setFont(new Font("Helvetica", false, false, 30));
        characterSkillButton.drawString(String.valueOf(character.getLvl()),240,47);
        characterSkillButton.drawString(String.valueOf(character.getAtk()),245,120);
        characterSkillButton.setFont(new Font("Helvetica", false, false, 23));
        characterSkillButton.drawString(String.valueOf(character.getHp()+"/"+character.getMaxHp()),385,46);
        characterSkillButton.setFont(new Font("Helvetica", false, false, 30));
        characterSkillButton.drawString(String.valueOf(character.getDefense()),390,120);
        characterSkillButton.setFont(new Font("Helvetica", false, false, 29));
        characterSkillButton.drawString(String.valueOf(character.getSp()+"/"+character.getMaxSp()),533,47);
        characterSkillButton.setFont(new Font("Helvetica", false, false, 29));
        characterSkillButton.drawString(String.valueOf(character.getSpeed()),560,120);
        setImage(characterSkillButton);
    }

    public void act() 
    {  
        if(Greenfoot.mousePressed(this)){
            buttonClick.play();
            Greenfoot.setWorld(new SkillUpgradeMenu(character,currentRoom,characterX,characterY));
        }
    }    
}
