public class Card {
    private String name;
    private String suit;
    private int value;

    public Card(String n, String s, int v){
        name = n;
        suit = s;
        value = v;
    }

    public String getName() {
        return name;
    }
    public String getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }

    public void setName(String n){
        name = n;
    }
    public void setSuit(String s) {
        suit = s;
    }
    public void setValue(int v){
        value = v;
    }

    public String toString(){
        return name + " of " + suit;
    }
}
