import java.util.*;
public class GuessTheWord {
//have a peer substitute a 6 letter as the seceret word; string word 
    public static void main(String[] args) 
    {
      Scanner pencil = new Scanner(System.in);
      
      int attempts = 10;
      boolean tries = false;
       
      String x = "";
      System.out.println("Welcome to Guess the word!! You can guess 1 letter at a time, You have " + attempts + " tries to guess the 6 letter word. ");
       System.out.println(" Have a peer substitute a 6 letter as the seceret word; string word before playing,"); 
          System.out.println(" you have " + attempts + " guesses remaining.");

        String word = "pencil";
        String secretword = createSecretWord(word);
        System.out.println("The Secret Word Is: " + secretword + " (" + word.length() + ")");
        do {System.out.print("Guess a letter: ");
            
        String guess = pencil.nextLine();
        boolean answer = false;
           for (int i = 0; i < word.length(); i++) 
           {
             if (guess.equals(Character.toString(word.charAt(i)))) 
             {
               answer= true;
               if (!tries)
                 x += Character.toString(word.charAt(i));
                    else 
                    {
                      String y = Character.toString(x.charAt(i)).replace("-", guess);
                        x = x.substring(0, i) + y + x.substring(i + 1, x.length());
                    }
                } 
             else 
             {
               if (!tries) 
               {
                x += "-";
               }
             }
           }
           tries = true;
           if (answer) 
           {
             System.out.println("The word has the letter " + guess + ".");
            } 
           else 
           {
             System.out.println("The word does not contain the letter " + guess + ".");
                attempts--;
             System.out.println("You have " + attempts + " tries remaining.");
            }
           System.out.println(x);
           if (x.equals(word)) {
           System.out.println("You guessed the secret word! The secret word was "+ word
                                + ".");
           break;
           }
        } while (attempts > 0);
        if (attempts <= 0) 
        {
          System.out.println("Sorry,you didn't guess the secret word in time, the secret word was" + word + "\".");
        } 
    }
    private static String createSecretWord(String word) 
    {
      String result = "";
        for (int i = 0; i < word.length(); i++) 
        {
            result += "-";
        }
        return result;
    }
}