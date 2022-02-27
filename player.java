import java.util.ArrayList;
public class player
{
  private double money;
  public ArrayList <cards> playerhand = new ArrayList<cards>(); 
  
  public player()
  {
    money = 50;
  }
  public player(double m)
  {
    money = m;
  }
  
  public double getMoney()
  {
    return money;
  }
  
  public ArrayList <cards> GetPlayerHand()
  {
    return playerhand;
  }
  
  public void setMoney(double m)
  {
    money = m;
  }                
  
  public void setDeck(ArrayList <cards> p)
  {
    playerhand = p;
  }
} 