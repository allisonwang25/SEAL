import java.util.*;
public class MysteryNumber 
{
  public static void
    guessTheNumber()
    {
    Scanner pencil = new Scanner(System.in);
    int num = 1 + (int)(100* Math.random());
    int tries = 5;
    int i, guess;System.out.println( "Welcome to Mystery Number! A mystery number between 1 and 100 is chosen"
            + " you have 5 tries to guess the mystery number.");
        for (i = 0; i < tries; i++) 
        {
          System.out.println("guess a number:");
            guess = pencil.nextInt();
            
            if (num == guess) 
            {
              System.out.println("Congratulations! You guessed the mystery number.");
                break;
            }
            else if 
              (num > guess && i != tries - 1) 
            {
              System.out.println("the mystery number is larger than " + guess);
            }
            else if (num < guess && i != tries - 1) 
            {
              System.out.println("The mystery number is less than " + guess);
            }
        }
        {
        if (i == num) 
          System.out.println("You ran out of tries,the mystery number was " + num);
        }
    }
    public static void main(String[]args)
    {
        guessTheNumber();
    }
}