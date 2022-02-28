import java.util.*;
public class Player {
    private String name;
    private double points;
    private ArrayList<Card> deck;

    public Player(String n, double p, ArrayList<Card> d){
        name = n;
        points = p;
        deck = d;
    }

    public String getName() {
        return name;
    }
    public double getBankroll() {
        return points;
    }

    public void setName(String n){
        name = n;
    }
    public void setPoints(double p) {
        points = p;
    }
}
