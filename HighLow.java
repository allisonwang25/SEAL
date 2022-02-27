import java.util.ArrayList;
import java.lang.Math;
import java.util.*;
public class HighLow
{
  
  ArrayList <cards> deck = new ArrayList<cards>(); 
  
  public HighLow()
  {deck.add(new cards(14, "ace"));
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
  
  public int draw(player activeplayer)
  {
    String cardtype = deck.get(0).getType();
    int cardnumber = deck.get(0).getNumber();
    activeplayer.playerhand.add(deck.get(0));
    deck.remove(0);
    System.out.println("You pulled a " + cardtype + "! It has " + cardnumber + " points!");
    return cardnumber;
    
  }
  
  
  
  public int computerdraw(player activeplayer)
  {
    String cardtype = deck.get(0).getType();
    int cardnumber = deck.get(0).getNumber();
    activeplayer.playerhand.add(deck.get(0));
    deck.remove(0);
    return cardnumber;
    
  }
  
  public static void main(String [] args)
  {
    String yn = "yes";
    int wager = 0;
    player activeplayer = new player (50);
    player computer = new player (50000);
    boolean valid_wager=false;
    HighLow game = new HighLow();
    game.shuffle();
    
    
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to High&Low! Would you like the rules explained? (Yes/No)");
    String rules = input.next();
    if(rules.equals("yes")||rules.equals("Yes")||rules.equals("y")||rules.equals("y"))
    {
      System.out.println("In High&Low, a computer will draw a random card from a shuffled deck. You will not know their card.");
      System.out.println("You will do the same, and will be given the value of your card. You will then have to guess whether the computers' card has a higher or lower value than yours.");
      System.out.println("For example, if the computer draws a 6 and you draw a 9, if you guessed 'lower,' you would be right.");
      System.out.println("If both cards are equal and you correctly guess equal, the amount of money you bet will be doubled. Likewise, if you do not guess equal, you lose twice the amount of money.");
      System.out.println("If both cards are NOT equal and you guess equal, you will lose the same amount you bet (not doubled).");
      System.out.println("You will start off with 50 dollars.");
    }
    
    System.out.println("Let's begin!");
    System.out.println(" ");
    
    while(yn.equals("yes"))
    {
      valid_wager = false;
      while(valid_wager==false)
      {
        System.out.println("Please enter your wager. You have " + activeplayer.getMoney() + " dollars.");
        wager = input.nextInt();
        input.nextLine();
        if(wager>activeplayer.getMoney()||wager<0)
        {
          System.out.println("Please enter a valid wager.");
        }else{
          valid_wager = true;
        }
      }
      
      int computervalue = game.computerdraw(computer);
      int playervalue = game.draw(activeplayer);
      
      if(computervalue<playervalue)
      {
        System.out.println("Do you think the card the computer pulled is lower, greater, or equal to yours? (Type 'lower', 'greater', or 'equal'.");
        String guess = input.next();
        
        if(guess.equals("lower"))
        {
          System.out.println("Correct! You won some money.");
          activeplayer.setMoney(activeplayer.getMoney()+wager);
        }else{
          System.out.println("Incorrect! You lost some money.");
          activeplayer.setMoney(activeplayer.getMoney()-wager);
        }
      }
      
      if(computervalue>playervalue)
      {
        System.out.println("Do you think the card the computer pulled is lower, greater, or equal to yours? (Type 'lower', 'greater', or 'equal').");
        String guess = input.next();
        
        if(guess.equals("greater"))
        {
          System.out.println("Correct! You won some money.");
          activeplayer.setMoney(activeplayer.getMoney()+wager);
        }else{
          System.out.println("Incorrect! You lost some money.");
          activeplayer.setMoney(activeplayer.getMoney()-wager);
        }
      }
      
      if(computervalue==playervalue)
      {
        System.out.println("Do you think the card the computer pulled is lower, greater, or equal to yours? (Type 'lower', 'greater', or 'equal').");
        String guess = input.next();
        
        if(guess.equals("equal"))
        {
          System.out.println("Correct! You won double the money, the cards were equal.");
          activeplayer.setMoney(activeplayer.getMoney()+(wager*2));
        }else{
          System.out.println("Incorrect! You lost double the money, the cards were equal.");
          activeplayer.setMoney(activeplayer.getMoney()-(wager*2));
        }
      }
      
      System.out.println(" ");
      System.out.println("Do you want to play again?");
      yn = input.next();
      input.nextLine();
      if(activeplayer.getMoney()==0)
      {
        System.out.println("Sorry, you are broke.");
        yn = "no";
      }
    }
  }
}