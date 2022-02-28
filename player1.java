import java.util.ArrayList;
public class player1
{
    private double money;
    public ArrayList <cards> playerhand = new ArrayList<cards>();

    public player1()
    {
        money = 50;
    }
    public player1(double m)
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