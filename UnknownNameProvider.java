/**
 * Write a description of class UnknownNameProvider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnknownNameProvider implements CharacterNameProvider
{
    private int headerX = 305;
    private int headerY = 90;
    
    public String getName(){
        return "????";
    }
    
    public int getHeaderX(){
        return headerX;
    }
    
    public int getHeaderY(){
        return headerY;
    }
    
    public int getId(){
        return 0;
    }
}
