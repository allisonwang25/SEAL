import java.util.*;
public class Deck {
    private ArrayList<Card> deck;

    public Deck(ArrayList<Card> d){
        deck = d;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle(){
        System.out.println("Shuffling....");
        ArrayList<Card> newDeck = new ArrayList<Card>();
        for(int i = 0; i < 52; i++){
            int temp = (int)(Math.random() * (52 - i));
            newDeck.add(deck.get(temp));
            deck.remove(temp);
        }
        deck = newDeck;
        System.out.println("Done!");
    }


}
