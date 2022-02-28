import java.util.ArrayList;
public class PlayerWar
{
  public ArrayList <cards> playerhand = new ArrayList<cards>(); 
  
  public ArrayList <cards> GetPlayerHand()
  {
    return playerhand;
  }
  
  public void setDeck(ArrayList <cards> p)
  {
    playerhand = p;
  }
} 