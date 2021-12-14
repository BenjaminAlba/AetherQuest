import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Party here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Party extends Actor
{
    private static Party uniqueInstance;
    
    private Character member1 = new Sokudo();
    private Character member2 = new Light();
    private Character member3 = new Shock();
    private Character member4 = new Mike();
    private int money;
    private int[] inventory = new int[12];
    private int [] flags = new int[250];
    
    private Party(){   
    }
    
    public static Party getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Party();
        return uniqueInstance;
    }
    
    public boolean isPartyTurnOver(){
        if(member1.getAttackStatus() == false && member2.getAttackStatus() == false && member3.getAttackStatus() == false && member4.getAttackStatus() == false){
            member1.setAttackStatus(true);
            member2.setAttackStatus(true);
            member3.setAttackStatus(true);
            member4.setAttackStatus(true);
            return true;
        }
        return false;
    }
    
    public Character getMember1(){
        return member1;
    }
    
    public Character getMember2(){
        return member2;
    }
    
    public Character getMember3(){
        return member3;
    }
    
    public Character getMember4(){
        return member4;
    }
    
    public boolean getPartyFlags(int flagToCheck)
    {
        if(flags[flagToCheck]==1)
        {
            return true; 
        }
        return false;
    }

    public void setPartyFlags(int flagToSet)
    {
        flags[flagToSet]=1;
    }

    public void setMember1(Character character)
    {
        member1=character;
    }
    public void setMember2(Character character)
    {
        member2=character;
    }
    public void setMember3(Character character)
    {
        member3=character;
    }
    public void setMember4(Character character)
    {
        member4=character;
    }
}
