import java.util.ArrayList;
import java.lang.Math;
import java.util.*;
public class CardWar
{
  ArrayList <cards> deck = new ArrayList<cards>(); 
  
  public CardWar()
  {
    deck.add(new cards(14, "ace"));
    deck.add(new cards(14, "ace"));
    deck.add(new cards(14, "ace"));
    deck.add(new cards(14, "ace"));
    
    deck.add(new cards(2, "two"));
    deck.add(new cards(2, "two"));
    deck.add(new cards(2, "two"));
    deck.add(new cards(2, "two"));
    
    deck.add(new cards(3, "three"));
    deck.add(new cards(3, "three"));
    deck.add(new cards(3, "three"));
    deck.add(new cards(3, "three"));
    
    deck.add(new cards(4, "four"));
    deck.add(new cards(4, "four"));
    deck.add(new cards(4, "four"));
    deck.add(new cards(4, "four"));
    
    deck.add(new cards(5, "five"));
    deck.add(new cards(5, "five"));
    deck.add(new cards(5, "five"));
    deck.add(new cards(5, "five"));
    
    deck.add(new cards(6, "six"));
    deck.add(new cards(6, "six"));
    deck.add(new cards(6, "six"));
    deck.add(new cards(6, "six"));
    
    deck.add(new cards(7, "seven"));
    deck.add(new cards(7, "seven"));
    deck.add(new cards(7, "seven"));
    deck.add(new cards(7, "seven"));
    
    deck.add(new cards(8, "eight"));
    deck.add(new cards(8, "eight"));
    deck.add(new cards(8, "eight"));
    deck.add(new cards(8, "eight"));
    
    deck.add(new cards(9, "nine"));
    deck.add(new cards(9, "nine"));
    deck.add(new cards(9, "nine"));
    deck.add(new cards(9, "nine"));
    
    deck.add(new cards(10, "ten"));
    deck.add(new cards(10, "ten"));
    deck.add(new cards(10, "ten"));
    deck.add(new cards(10, "ten"));
    
    deck.add(new cards(11, "jack"));
    deck.add(new cards(11, "jack"));
    deck.add(new cards(11, "jack"));
    deck.add(new cards(11, "jack"));
    
    deck.add(new cards(12, "queen"));
    deck.add(new cards(12, "queen"));
    deck.add(new cards(12, "queen"));
    deck.add(new cards(12, "queen"));
    
    deck.add(new cards(13, "king"));
    deck.add(new cards(13, "king"));
    deck.add(new cards(13, "king"));
    deck.add(new cards(13, "king"));
  }
  
  
  public void shuffle()
  {
    cards temp;
    for(int i = 0; i < 200; i++)
    {
      int number1 = (int)(Math.random()*52);
      int number2 = (int)(Math.random()*52);
      temp = deck.get(number2);
      deck.set(number2,deck.get(number1) );
      deck.set(number1, temp);
    }
  }
  
  
  public void ShowDeck ()
  {
    for(int i = 0; i<deck.size();i++)
    {
      int number = deck.get(i).getNumber();
      String type = deck.get(i).getType();
      System.out.println("This card is a " + type + ", and holds " + number + " points.");
      
    }
  }
  
  public int draw(PlayerWar player)
  {
    
    int number = player.playerhand.get(0).getNumber();
    String type = player.playerhand.get(0).getType();
    System.out.println("This card is a " + type + ", and holds " + number + " points.");
    System.out.println("");
    int value = player.playerhand.get(0).getNumber();
    return value;
  }
  
  public void deal (PlayerWar activeplayer, PlayerWar computer)
  {
    for(int i = 0; i <= 26; i++)
    {
      activeplayer.playerhand.add(deck.get(i));
    }
    for(int i = 26; i < 52; i++)
    {
      computer.playerhand.add(deck.get(i));
    }
  }
  
  
  public static void run ()
  {
    boolean cont = true;
    PlayerWar activeplayer = new PlayerWar ();
    PlayerWar computer = new PlayerWar ();
    CardWar game = new CardWar();
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to War (the Card Game). Would you like the rules explained? (Yes/No)");
    String rules = input.next();
    if(rules.equals("yes")||rules.equals("Yes")||rules.equals("y")||rules.equals("y"))
    {
      System.out.println("In war, a shuffled deck is divided evenly against two players. You will be playing against a computer.");
      System.out.println("You will put down a card from your hand, and so will the computer. Whoever has the higher card wins both cards.");
      System.out.println("If both cards are equal, there is a 'war.' Both players will then place their next three cards face down, and another one face-up.");
      System.out.println("Whoever has the higher face-up card wins all 10 cards.");
      System.out.println("Cards won will automatically be moved to the bottom of the winner's pile.");
      System.out.println("Whoever runs out of cards first loses, and the other player is declared the winner. Have fun!");
      System.out.println(" ");
    }
    
    while(cont==true)
    {
      game.shuffle();
      game.deal(activeplayer, computer);
      
      System.out.println("The computer is drawing...");
      int computervalue = game.draw(computer);
      System.out.println("You are drawing...");
      int playervalue = game.draw(activeplayer);
      
      if(computervalue>playervalue)
      {
        cards cardlose = activeplayer.playerhand.get(0);
        cards cardwin = computer.playerhand.get(0);
        activeplayer.playerhand.remove(0);
        computer.playerhand.remove(0);
        computer.playerhand.add(cardlose);
        computer.playerhand.add(cardwin);
        System.out.println("You have a lower value! The computer took both cards.");
      }
      if(computervalue<playervalue)
      {
        cards cardwin = activeplayer.playerhand.get(0);
        cards cardlose = computer.playerhand.get(0);
        computer.playerhand.remove(0); 
        activeplayer.playerhand.remove(0); 
        activeplayer.playerhand.add(cardlose);
        activeplayer.playerhand.add(cardwin); 
        System.out.println("The computer has a lower value! You took both cards.");
      }
      if(computervalue==playervalue)
      {
        System.out.println("You both have cards of the same value. This initiates a war.");
        System.out.println("You and the computer both draw three cards, and a fourth card that lies face-up...");
        
        System.out.println("The computer is drawing their fourth card...");
        int comptie = game.draw(computer);
        System.out.println("You are drawing your fourth card...");
        int playertie = game.draw(activeplayer);
        
        cards playerduplicate = activeplayer.playerhand.get(0);
        cards face1 = activeplayer.playerhand.get(1);
        cards face2 = activeplayer.playerhand.get(2);
        cards face3 = activeplayer.playerhand.get(3);
        cards face4 = activeplayer.playerhand.get(4);
        cards computerduplicate = computer.playerhand.get(0);
        cards face5 = computer.playerhand.get(1);
        cards face6 = computer.playerhand.get(2);
        cards face7 = computer.playerhand.get(3);
        cards face8 = computer.playerhand.get(4);
        
        if(comptie<playertie)
        {
          System.out.println("You have a higher card! You take all 10 cards.");
          activeplayer.playerhand.remove(0);
          activeplayer.playerhand.remove(1);
          activeplayer.playerhand.remove(2);
          activeplayer.playerhand.remove(3);
          activeplayer.playerhand.remove(4);
          
          activeplayer.playerhand.add(playerduplicate);
          activeplayer.playerhand.add(face1);
          activeplayer.playerhand.add(face2);
          activeplayer.playerhand.add(face3);
          activeplayer.playerhand.add(face4);
          activeplayer.playerhand.add(computerduplicate);
          activeplayer.playerhand.add(face5);
          activeplayer.playerhand.add(face6);
          activeplayer.playerhand.add(face7);
          activeplayer.playerhand.add(face8);
        }else{
          System.out.println("The computer has a higher card! It takes all 10 cards.");
          
          computer.playerhand.remove(0);
          computer.playerhand.remove(1);
          computer.playerhand.remove(2);
          computer.playerhand.remove(3);
          computer.playerhand.remove(4);
          
          computer.playerhand.add(playerduplicate);
          computer.playerhand.add(face1);
          computer.playerhand.add(face2);
          computer.playerhand.add(face3);
          computer.playerhand.add(face4);
          computer.playerhand.add(computerduplicate);
          computer.playerhand.add(face5);
          computer.playerhand.add(face6);
          computer.playerhand.add(face7);
          computer.playerhand.add(face8);
        }
        
        
        
        
      }
      System.out.println("Would you like to draw again? If you surrender before you have run out of cards, you will automatically lose.");
      String choice = input.next();
      if(choice.equals("yes")||choice.equals("Yes")||choice.equals("y")||choice.equals("y"))
      {
        cont = true;
      }else{
        cont = false;
        System.out.println("You lose.");
      }
      
      if(computer.playerhand.size()==0||activeplayer.playerhand.size()==0)
      {
        if(computer.playerhand.size()==0)
        {
          System.out.println("The computer has run out of cards. You win!");
          cont = false;
        }else{
          System.out.println("The computer has run out of cards. You win!");
          cont = false;
        }
      }
    }    
  }
}
