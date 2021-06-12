import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StatDisplay extends Actor
{
    private String line;
    private GreenfootImage img;
    
    public StatDisplay(String line, int x, int y)
    {
        img = new GreenfootImage(1280, 720);
        img.setColor(Color.WHITE);
        img.setFont(new Font("Helvetica", false, false, 25));
        img.drawString(line, x, y);
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
