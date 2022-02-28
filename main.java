import java.util.*;

public class main {

    public static void main(String[] args)
    {
        Scanner pencil = new Scanner(System.in);
        System.out.println("hey there you procrastinator, you lazy human, you greasy sloth--what would you like to do to evade productivity?");
        while(true){
            System.out.println("WORD GAMES:" +
                               "(1) Hangman : word wrong --> neck gone \n" +
                               "(2) Guess the Word : hangman but for pacifists :DD \n" +
                               "(3) pressTheP : press the 'p' and nothing else!\n" +
                               "(4) Typing Test : type your fingers off to quotes from your favorite TV shows! \n\n" +
                               "NUMBER GAMES:" +
                               "(5) Mystery Number : guess in 5 tries or else!!! \n" +
                               "(6) HighLow : guess strategically & hope... \n\n"+
                               "BOARD GAMES:" +
                               "(7) Connect 4 : very self explanatory ;) \n" +
                               "(8) ticTacToe : X's & O's " + 
                               "(9) Checkers : big brain gamesz\n\n" +
                               "CARD GAMES:" +
                               "(10)Slap Jack : slap that jackussy... \n" + 
                               "(11)CardWar : we take no prisoners!\n" + 
                               "(12)Black Jack : casino casinooo don't get addicted and don't count cards aaaa");
            int input = pencil.nextInt();
            pencil.nextLine();
            if(input==1)
                Hangman.run();
            else if(input==2)
                GuessTheWord.run();
            else if(input==3)
                pressTheP.run();
            else if(input==4)
                typingTest.run();
            else if(input==5)
                MysteryNumber.run();
            else if(input==6)
                slapJack.run();
            else if(input==7)
                Connect4.run();
            else if(input==8)
                tictactoe.run();
            else if(input==9)
                checkers.run();
            else if(input==10)
                HighLow.run();
            else if(input==11)
                CardWar.run();
            else if(input==12)
                blackJack.run();
            System.out.println("(1)quit or (2) play again?");
            input = pencil.nextInt();
            pencil.nextLine();
            if(input==1)
                break;
        }
    }

}
