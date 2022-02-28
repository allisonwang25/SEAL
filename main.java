import java.util.*;

public class main {

    public static void main(String[] args)
    {
        Scanner pencil = new Scanner(System.in);
        System.out.println("hey there you procrastinator, you lazy human, you greasy sloth--what would you like to do to evade productivity?");
        while(true){
            System.out.println("(1) Hangman : word wrong --> neck gone \n" +
                               "(2) pressTheP : press the 'p' and nothing else!\n" +
                               "(3) CardWar : we take no prisoners!\n" +
                               "(4) HighLow : guess strategically & hope... \n" +
                               "(5) ticTacToe : X's & O's \n" +
                               "(6) Slap Jack : slap that jackussy... \n" +
                               "(7) Typing Test : type your fingers off to quotes from your favorite TV shows! \n"
                               "(8) Mystery Number : guess in 5 tries or else!!! \n" + 
                               "(9) Connect 4 : very self explanatory ;) \n" + 
                               "(10)Guess the Word : \n" + 
                               "(11) Black Jack : casino casinooo don't get addicted and don't count cards aaaa");
            int input = pencil.nextInt();
            pencil.nextLine();
            if(input==1)
                Hangman.run();
            else if(input==2)
                pressTheP.run();
            else if(input==3)
                CardWar.run();
            else if(input==4)
                HighLow.run();
            else if(input==5)
                tictactoe.run();
            else if(input==6)
                slapJack.run();
            else if(input==7)
                typingTest.run();
            else if(input==8)
                MysteryNumber.run();
            else if(input==9)
                Connect4.run();
            else if(input==10)
                GuessTheWord.run();
            //else if(input==11)
                //blackJack.run();
            System.out.println("(1)quit or (2) play again?");
            input = pencil.nextInt();
            pencil.nextLine();
            if(input==1)
                break;
        }
    }

}
