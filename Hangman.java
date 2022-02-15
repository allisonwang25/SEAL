import java.util.*;
public class Hangman {
    public static void main(String[] args){
        //System.out.println("Welcome to Three-Letter Hangman! This troll game has only three letter words so if you reach hangman, you're a disgrace!");
        System.out.println("Welcome to Hangman! The word bank includes various words, ranging from music, to books, to nature. Good luck!");

        //String[] words = {"ink", "aid", "bad", "cat", "dog", "eat", "fig", "god", "hat", "jug", "let", "may",
                          //"net", "our", "pet", "rub", "sit", "tag", "urn", "van", "war", "yes", "zip"};
        String[] words = {"seals", "jazz", "kayak", "yacht", "twelfth", "samoyed", "ASMR", "random", "circle",
                          "quadrilateral", "triangle", "answer", "question", "public", "flute", "piano", "benches",
                          "birch tree", "rosemary", "the great gatsby"};

        Scanner in = new Scanner(System.in);

        int random = (int)(Math.random() * words.length);
        String word = words[random];

        int wrong = 0;
        printMan(wrong);

        for(int i = 0; i < word.length(); i++) {
            if(word.substring(i, i+1).equals(" "))
                System.out.print("  ");
            else
                System.out.print("_ ");
        }
        System.out.println();

        ArrayList<String> previousGuesses = new ArrayList<String>();
        ArrayList<String> rights = new ArrayList<String>();
        ArrayList<String> wrongs = new ArrayList<String>();
        boolean play = true;
        while(play){
            String finalWord = "";
            boolean repeat1 = true;
            String guess = "";
            while(repeat1) {
                System.out.println("Guess a letter! Please guess lowercase letters!");
                guess = in.nextLine();
                repeat1 = repeat(guess, previousGuesses);
                if(repeat1)
                    System.out.println("You've already guessed that! Choose another letter!");
            }

            previousGuesses.add(guess);

            boolean found = false;
            for(int i = 0; i < word.length(); i++){
                if(word.substring(i, i+1).equals(guess))
                    found = true;
            }

            if(!found) {
                wrong++;
                System.out.println("This letter wasn't found in the word!");
                wrongs.add(guess);
                printMan(wrong);
                for(int i = 0; i < word.length(); i++){
                    boolean found1 = false;
                    for(int j = 0; j < rights.size(); j++) {
                        if (word.substring(i, i + 1).equals(rights.get(j))) {
                            System.out.print(rights.get(j) + " ");
                            found1 = true;
                        }
                    }
                    if(word.substring(i, i + 1).equals(" "))
                        System.out.print("  ");
                    else if(!found1)
                        System.out.print("_ ");
                }
                System.out.println();
                System.out.println("Wrong Answers:");
                for(int i = 0; i < wrongs.size(); i++)
                    System.out.print(wrongs.get(i) + " ");
                System.out.println();
            }
            else if(found){
                rights.add(guess);
                printMan(wrong);
                for(int i = 0; i < word.length(); i++){
                    boolean found1 = false;
                    for(int j = 0; j < rights.size(); j++) {
                        if (word.substring(i, i + 1).equals(rights.get(j))) {
                            System.out.print(rights.get(j) + " ");
                            finalWord += rights.get(j);
                            found1 = true;
                        }
                    }
                    if(word.substring(i, i + 1).equals(" ")) {
                        System.out.print("  ");
                        finalWord += " ";
                    }
                    else if(!found1)
                        System.out.print("_ ");

                }
                System.out.println();
                System.out.println("Wrong Answers:");
                for(int i = 0; i < wrongs.size(); i++){
                    System.out.print(wrongs.get(i) + " ");
                }
                System.out.println();
            }


            boolean fullWord = true;
            if(finalWord.equals(word)) {
                play = false;
                System.out.println("You win! Congratulations!");
            }
            else if(wrong == 6) {
                play = false;
                System.out.println("The word was " + word + "!");
            }


        }
    }
    public static boolean repeat(String guess, ArrayList<String> previousGuesses){
        boolean repeat = false;
        for(int i = 0; i < previousGuesses.size(); i++){
            if(guess.equals(previousGuesses.get(i)))
                repeat = true;
        }
        return repeat;
    }
    public static void printMan(int wrong){
        if(wrong == 0){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("----+----");
        }
        else if(wrong == 1){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |      -");
            System.out.println("    |     / \\");
            System.out.println("    |     \\ /");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |        ");
            System.out.println("    |        ");
            System.out.println("    |        ");
            System.out.println("----+----");
        }
        else if(wrong == 2){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |      -");
            System.out.println("    |     / \\");
            System.out.println("    |     \\ /");
            System.out.println("    |      | ");
            System.out.println("    |      - ");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |        ");
            System.out.println("    |        ");
            System.out.println("    |        ");
            System.out.println("----+----");
        }
        else if(wrong == 3){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |      -");
            System.out.println("    |     / \\");
            System.out.println("    |     \\ /");
            System.out.println("    |      | ");
            System.out.println("    |      - ");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |     /  ");
            System.out.println("    |    /   ");
            System.out.println("    |        ");
            System.out.println("----+----");
        }
        else if(wrong == 4){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |      -");
            System.out.println("    |     / \\");
            System.out.println("    |     \\ /");
            System.out.println("    |      | ");
            System.out.println("    |      - ");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |     / \\ ");
            System.out.println("    |    /   \\");
            System.out.println("    |        ");
            System.out.println("----+----");
        }
        else if(wrong == 5){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |      -");
            System.out.println("    |     / \\");
            System.out.println("    |     \\ /");
            System.out.println("    |    \\ | ");
            System.out.println("    |     \\-");
            System.out.println("    |      |");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |     / \\");
            System.out.println("    |    /   \\");
            System.out.println("    |       ");
            System.out.println("----+----");
        }
        else if(wrong == 6){
            System.out.println("    +------+");
            System.out.println("    |      |");
            System.out.println("    |      -");
            System.out.println("    |     / \\");
            System.out.println("    |     \\ /");
            System.out.println("    |    \\ | /");
            System.out.println("    |     \\-/");
            System.out.println("    |      |");
            System.out.println("    |      | ");
            System.out.println("    |      | ");
            System.out.println("    |     / \\");
            System.out.println("    |    /   \\");
            System.out.println("    |       ");
            System.out.println("----+----");
            System.out.println("Oh no! You've been hanged! Better luck next time!");
        }
    }
}
