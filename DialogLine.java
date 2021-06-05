import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DialogLine extends Actor
{
    private String line;
    private GreenfootImage img;
    
    public DialogLine(String line, int location)
    {
        img = new GreenfootImage(1280, 600);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Helvetica", false, false, 25));
        switch(location)
        {
            case 1:
                img.drawString(line, 755, 355);
                break;
            case 2:
                img.drawString(line, 755, 405);
                break;
            case 3:
                img.drawString(line, 755, 455);
                break;
            case 4:
                img.drawString(line, 755, 515);
                break;
        }
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}