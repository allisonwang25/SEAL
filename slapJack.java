package slapJack;

import java.util.*;
public class slapJack {
    public static void main(String[] args){
        boolean play = true;
        while(play) {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to Slap Jack!");
            System.out.println("This is a two player game, make sure you have a partner! Press enter to place a card! \n");

            System.out.println("Player 1, which key will be your slap? Choose any number, letter, or special character!");
            String p1 = input.nextLine();
            System.out.println("Player 2, which key will be your slap? Choose any number, letter, or special character!");
            String p2 = input.nextLine();

            ArrayList<Card> deck = new ArrayList<Card>();
            deck = makeDeck();
            deck = shuffle(deck);
            ArrayList<Card> deck1 = splitDeck(deck);
            ArrayList<Card> deck2 = deck;
            ArrayList<Card> stack = new ArrayList<Card>();

            boolean jack = false;
            boolean turn = true;
            while(turn) {
                while (!jack) {
                    System.out.print("Player 1: ");
                    input.nextLine();
                    System.out.println("Player one places a " + deck1.get(0));
                    stack.add(deck1.get(0));
                    deck1.remove(0);
                    if (stack.get(stack.size() - 1).getName().equals("J")) {
                        System.out.println("Slap! Type your marker only once!");
                        jack = true;
                        String slap = "";
                        boolean valid = false;
                        while(!valid) {
                            slap = input.nextLine();
                            if (slap.equals(p1 + p2)) {
                                deck1.addAll(stack);
                                stack.removeAll(stack);
                                System.out.println("Player 1 wins slap and has " + deck1.size() + " cards! Player 2 has " + deck2.size() + " cards!");
                                valid = true;
                            } else if (slap.equals(p2 + p1)) {
                                deck2.addAll(stack);
                                System.out.println("Player 2 wins slap and has " + deck2.size() + " cards! Player 1 has " + deck1.size() + " cards!");
                                valid = true;
                            } else {
                                System.out.println("Neither of you slapped/only one of you slapped/you used the wrong slap character! Try again!");
                            }
                        }
                        break;
                    }
                    System.out.print("Player 2: ");
                    input.nextLine();
                    System.out.println("Player two places a " + deck2.get(0));
                    stack.add(deck2.get(0));
                    deck2.remove(0);
                    if (stack.get(stack.size() - 1).getName().equals("J")) {
                        System.out.println("Slap! Type your marker only once!");
                        jack = true;
                        String slap = "";
                        boolean valid = false;
                        while(!valid) {
                            slap = input.nextLine();
                            if (slap.equals(p1 + p2)) {
                                deck1.addAll(stack);
                                stack.removeAll(stack);
                                System.out.println("Player 1 wins slap and has " + deck1.size() + " cards! Player 2 has " + deck2.size() + " cards!");
                                valid = true;
                            } else if (slap.equals(p2 + p1)) {
                                deck2.addAll(stack);
                                System.out.println("Player 2 wins slap and has " + deck2.size() + " cards! Player 1 has " + deck1.size() + " cards!");
                                valid = true;
                            } else {
                                System.out.println("Neither of you slapped/only one of you slapped/you used the wrong slap character! Try again!");
                            }
                        }
                    }
                }
                System.out.println("Shall we continue (y/n)?");
                String answer = input.nextLine();
                if(answer.equals("y"))
                    jack = false;
                else if(answer.equals("n"))
                    break;
            }
            if(deck1.size() > deck2.size())
                System.out.println("Player 1 wins with " + deck1.size() + " cards!");
            else if(deck2.size() > deck1.size())
                System.out.println("Player 2 wins with " + deck2.size() + " cards!");
            System.out.println("Would you like to play again(y/n)?");
            String answer = input.nextLine();
            if(answer.equals("n")) {
                play = false;
                System.out.println("See you next time!");
            }

        }
    }
    public static ArrayList<Card> makeDeck(){
        ArrayList<Card> deck = new ArrayList<Card>();
        Card aceClub = new Card("A", "clubs",1);
        Card aceDiam = new Card("A", "diamonds",1);
        Card aceHeart = new Card("A", "hearts",1);
        Card aceSpade = new Card("A", "spades",1);
        Card twoClub = new Card("2", "clubs",2);
        Card twoDiam = new Card("2", "diamonds",2);
        Card twoHeart = new Card("2", "hearts",2);
        Card twoSpade = new Card("2", "spades",2);
        Card threeClub = new Card("3", "clubs",3);
        Card threeDiam = new Card("3", "diamonds",3);
        Card threeHeart = new Card("3", "hearts",3);
        Card threeSpade = new Card("3", "spades",3);
        Card fourClub = new Card("4", "clubs",4);
        Card fourDiam = new Card("4", "diamonds",4);
        Card fourHeart = new Card("4", "hearts",4);
        Card fourSpade = new Card("4", "spades",4);
        Card fiveClub = new Card("5", "clubs",5);
        Card fiveDiam = new Card("5", "diamonds",5);
        Card fiveHeart = new Card("5", "hearts",5);
        Card fiveSpade = new Card("5", "spades",5);
        Card sixClub = new Card("6", "clubs",6);
        Card sixDiam = new Card("6", "diamonds",6);
        Card sixHeart = new Card("6", "hearts",6);
        Card sixSpade = new Card("6", "spades",6);
        Card sevenClub = new Card("7", "clubs",7);
        Card sevenDiam = new Card("7", "diamonds",7);
        Card sevenHeart = new Card("7", "hearts",7);
        Card sevenSpade = new Card("7", "spades",7);
        Card eightClub = new Card("8", "clubs",8);
        Card eightDiam = new Card("8", "diamonds",8);
        Card eightHeart = new Card("8", "hearts",8);
        Card eightSpade = new Card("8", "spades",8);
        Card nineClub = new Card("9", "clubs",9);
        Card nineDiam = new Card("9", "diamonds",9);
        Card nineHeart = new Card("9", "hearts",9);
        Card nineSpade = new Card("9", "spades",9);
        Card tenClub = new Card("10", "clubs",10);
        Card tenDiam = new Card("10", "diamonds",10);
        Card tenHeart = new Card("10", "hearts",10);
        Card tenSpade = new Card("10", "spades",10);
        Card jackClub = new Card("J", "clubs",10);
        Card jackDiam = new Card("J", "diamonds",10);
        Card jackHeart = new Card("J", "hearts",10);
        Card jackSpade = new Card("J", "spades",10);
        Card queenClub = new Card("Q", "clubs",10);
        Card queenDiam = new Card("Q", "diamonds",10);
        Card queenHeart = new Card("Q", "hearts",10);
        Card queenSpade = new Card("Q", "spades",10);
        Card kingClub = new Card("K", "clubs",10);
        Card kingDiam = new Card("K", "diamonds",10);
        Card kingHeart = new Card("K", "hearts",10);
        Card kingSpade = new Card("K", "spades",10);

        deck.add(aceClub);
        deck.add(aceDiam);
        deck.add(aceHeart);
        deck.add(aceSpade);
        deck.add(twoClub);
        deck.add(twoDiam);
        deck.add(twoHeart);
        deck.add(twoSpade);
        deck.add(threeClub);
        deck.add(threeDiam);
        deck.add(threeHeart);
        deck.add(threeSpade);
        deck.add(fourClub);
        deck.add(fourDiam);
        deck.add(fourHeart);
        deck.add(fourSpade);
        deck.add(fiveClub);
        deck.add(fiveDiam);
        deck.add(fiveHeart);
        deck.add(fiveSpade);
        deck.add(sixClub);
        deck.add(sixDiam);
        deck.add(sixHeart);
        deck.add(sixSpade);
        deck.add(sevenClub);
        deck.add(sevenDiam);
        deck.add(sevenHeart);
        deck.add(sevenSpade);
        deck.add(eightClub);
        deck.add(eightDiam);
        deck.add(eightHeart);
        deck.add(eightSpade);
        deck.add(nineClub);
        deck.add(nineDiam);
        deck.add(nineHeart);
        deck.add(nineSpade);
        deck.add(tenClub);
        deck.add(tenDiam);
        deck.add(tenHeart);
        deck.add(tenSpade);
        deck.add(jackClub);
        deck.add(jackDiam);
        deck.add(jackHeart);
        deck.add(jackSpade);
        deck.add(queenClub);
        deck.add(queenDiam);
        deck.add(queenHeart);
        deck.add(queenSpade);
        deck.add(kingClub);
        deck.add(kingDiam);
        deck.add(kingHeart);
        deck.add(kingSpade);

        return deck;
    }
    public static ArrayList<Card> shuffle(ArrayList<Card> deck){
        System.out.println("Shuffling....");
        ArrayList<Card> newDeck = new ArrayList<Card>();
        for(int i = 0; i < 52; i++){
            int temp = (int)(Math.random() * (52 - i));
            newDeck.add(deck.get(temp));
            deck.remove(temp);
        }
        System.out.println("Done!");
        return newDeck;
    }
    public static ArrayList<Card> splitDeck(ArrayList<Card> deck){
        ArrayList<Card> newDeck = new ArrayList<Card>();
        for(int i = 0; i < 26; i++){
            int temp = (int)(Math.random() * (52 - i));
            newDeck.add(deck.get(temp));
            deck.remove(temp);
        }
        return newDeck;
    }
}
