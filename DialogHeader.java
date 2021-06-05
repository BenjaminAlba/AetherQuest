import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DialogHeader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogHeader extends Actor
{
    private String name;
    private GreenfootImage img;
    public DialogHeader(int characterId)
    {
        img = new GreenfootImage(500, 200);
        img.setColor(Color.WHITE);
        img.setFont(new Font("Helvetica", false, false, 30));
        
        switch(characterId)
        {
            case 0:
                name="????";
                img.drawString(name, 305, 90);
                break;
            case 1:
                name="Sokudo";
                img.drawString(name, 295, 90);
                break;
            case 2:
                name="Light";
                img.drawString(name, 310, 90);
                break;
            case 3:
                name="Shock";
                img.drawString(name, 305, 90);
                break;
            case 4:
                name="M1K3";
                img.drawString(name, 305, 90);
                break;
            case 5:
                name="Rengoku";
                img.drawString(name, 290, 90);
                break;
            case 6:
                name="King Hermes";
                img.drawString(name, 265, 90);
                break;
            case 7:
                name="Luis";
                img.drawString(name, 320, 90);
                break;
            case 8:
                name="Nagito";
                img.drawString(name, 305, 90);
                break;
            case 9:
                name="";
                img.drawString(name, 255, 90);
                break;
        }
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}