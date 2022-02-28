import java.util.*;
public class blackJack{
    public static void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to iCrastinate Pro's Blackjack Table! What's your name?");
        String name = in.nextLine();
        ArrayList<Card> playerHand = null;
        ArrayList<Card> dealerHand = null;
        Player player = new Player(name, 500, playerHand);
        Player dealer = new Player("Dealer", 500, dealerHand);


        boolean continueOn = true;
        while(continueOn){
            playerHand = new ArrayList<Card>();;
            dealerHand = new ArrayList<Card>();;
            ArrayList<Card> cardDeck = makeDeck();
            Deck deck = new Deck(cardDeck);
            deck.shuffle();

            boolean greater = true;
            double points = 0;
            while(greater) {
                System.out.println(player.getName() + ", you have " + player.getBankroll() + " points! How many points would you like to bet?");
                points = in.nextDouble();
                in.nextLine();
                if(points > 0 && points <= player.getBankroll())
                    greater = false;
                else
                    System.out.println("You don't have this many points!");
            }

            dealerHand.add(deck.getDeck().get(0));
            dealerHand.add(deck.getDeck().get(1));
            playerHand.add(deck.getDeck().get(2));
            playerHand.add(deck.getDeck().get(3));

            int playerTotal = getTotal(playerHand);
            int dealerTotal = getTotal(dealerHand);
            System.out.println("The dealer has the card " + dealerHand.get(0) + " face up!");
            System.out.println(player.getName() + ", your cards are " + playerHand.get(0) + " and " + playerHand.get(1) + " adding to a total of " + playerTotal);

            int cardNumber = 4;
            boolean playerTurn = true;
            boolean playerBust = false;
            boolean playerJack = false;
            boolean dealerTurn = false;
            boolean dealerJack = false;
            boolean dealerBust = false;
            if(playerTotal == 21){
                playerTurn = false;
                playerJack = true;
            }
            while(playerTurn){
                System.out.println("Would you like to (a)hit or (b)stand?");
                String hitOrStand = in.nextLine();
                if(hitOrStand.equals("a")) {
                    playerHand.add(deck.getDeck().get(cardNumber));
                    cardNumber++;
                    playerTotal = getTotal(playerHand);

                    if(playerTotal >= 21){
                        playerTurn = false;
                        dealerTurn = true;
                        if(playerTotal > 21)
                            playerBust = true;
                    }

                    System.out.print(player.getName() + ", your cards are ");
                    for(int i = 0; i < playerHand.size()-1; i++)
                        System.out.print(playerHand.get(i) + ", ");
                    System.out.print(playerHand.get(playerHand.size()-1));
                    System.out.println(" adding to a total of " + playerTotal);
                }
                else if(hitOrStand.equals("b")) {
                    playerTurn = false;
                    dealerTurn = true;
                }
            }
            while(dealerTurn){
                if(playerBust) {
                    dealerTurn = false;
                }
                else if(dealerTotal == 21){
                    System.out.println("The dealer has a " + dealerHand.get(0) + " and a " + dealerHand.get(1) + " adding to a total of " + dealerTotal);
                    dealerJack = true;
                    dealerTurn = false;
                }
                else{
                    System.out.println("The dealer has a " + dealerHand.get(0) + " and a " + dealerHand.get(1) + " adding to a total of " + dealerTotal);
                    boolean go = true;
                    while(go && (dealerTotal < 17 || (dealerTotal == 17 && getAce(dealerHand)))) {
                        if(dealerTotal == 17 && getAce(dealerHand))
                            go = false;
                        dealerHand.add(deck.getDeck().get(cardNumber));
                        cardNumber++;
                        dealerTotal = getTotal(dealerHand);
                        System.out.print("The dealer has the cards ");
                        for(int i = 0; i < dealerHand.size()-1; i++)
                            System.out.print(dealerHand.get(i) + ", ");
                        System.out.print("and " + dealerHand.get(dealerHand.size()-1));
                        System.out.println(" adding to a total of " + dealerTotal);
                    }
                    if(dealerTotal > 21)
                        dealerBust = true;
                    dealerTurn = false;
                }
            }

            if(playerBust){
                player.setPoints(player.getBankroll() - points);
                System.out.println(player.getName() + ", you have busted with your cards adding to a total of " + playerTotal + " points! You have " + player.getBankroll() + " points to spend!");
                System.out.println("The dealer had a " + dealerHand.get(0) + " and a " + dealerHand.get(1) + " adding to a total of " + dealerTotal);
            }
            else if(dealerBust){
                player.setPoints(player.getBankroll() + points);
                System.out.println("The dealer has busted!");
                System.out.println(player.getName() + ", you win! You have " + player.getBankroll() + " points!");

            }
            else if(playerJack && dealerJack){
                System.out.println("It's a blackjack draw!");
                System.out.println(player.getName() + ", you have " + player.getBankroll() + " points!");
            }
            else if(playerJack){
                player.setPoints(player.getBankroll() * 1.5);
                System.out.println(player.getName() + ", you win! You got blackjack! You have " + player.getBankroll() + " points!");
            }
            else if(dealerJack) {
                player.setPoints(player.getBankroll() - points);
                System.out.println("The dealer wins! They got blackjack!");
                System.out.println(player.getName() + ", you have " + player.getBankroll() + " points!");
            }
            else if(playerTotal == dealerTotal) {
                System.out.println("It's a draw!");
                System.out.println(player.getName() + ", you have " + player.getBankroll() + " points!");
            }
            else if(playerTotal > dealerTotal){
                player.setPoints(player.getBankroll() + points);
                System.out.println(player.getName() + ", you win! You have " + player.getBankroll() + " points!");
            }
            else if(dealerTotal > playerTotal) {
                player.setPoints(player.getBankroll() - points);
                System.out.println("The dealer wins!");
                System.out.println(player.getName() + ", you have " + player.getBankroll() + " points!");
            }

            System.out.println();
            boolean valid = false;
            if(player.getBankroll() == 0){
                System.out.println("You have no more points! Thanks for playing, " + player.getName() + "!");
                continueOn = false;
            }
            else {
                System.out.println("Would you like to continue(y/n)?");
                String answer = in.nextLine();
                if (answer.equals("y")) {
                    continueOn = true;
                    valid = true;
                } else if (answer.equals("n")) {
                    continueOn = false;
                    System.out.println("Thanks for playing! Your final balance was " + player.getBankroll());
                }
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
    public static int getTotal(ArrayList<Card> hand){
        int total = 0;
        for(int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getValue();
            if (getAce(hand.get(i)) && total + 10 < 21)
                total += 10;
        }
        return total;
    }
    public static boolean getAce(Card card){
        boolean ace = false;
        if (card.getName().equals("A"))
            ace = true;
        return ace;
    }
    public static boolean getAce(ArrayList<Card> hand){
        boolean ace = false;
        int total = 0;
        for(int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getValue();
            if (getAce(hand.get(i)) && total + 10 < 21) {
                total += 10;
                ace = true;
            }
        }
        return ace;
    }
}
