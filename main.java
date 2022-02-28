import java.util.*;

public class main {

    public static void main(String[] args)
    {
        Scanner pencil = new Scanner(System.in);
        System.out.println("hey there you procrastinator, you lazy human, you greasy sloth--what would you like to do to evade productivity?");
        while(true){
            System.out.println("(1)Hangman : word wrong --> neck gone \n(2) pressTheP : press the 'p' and nothing else!\n(3) CardWar : we take no prisoners!\n(4) HighLow : guess strategically & hope... ;\n(5) ticTacToe : X's & O's \n(6) Slap Jack : slap that jackussy... \n(7) Typing Test : type your fingers off to quotes from your favorite TV shows");
            int input = pencil.nextInt();
            pencil.nextLine();
            if(input==1)
                Hangman.run();
            if(input==2)
                pressTheP.run();
            if(input==3)
                CardWar.run();
            if(input==4)
                HighLow.run();
            if(input==5)
                ticTacToe.run();
            if(input==6)
                slapJack.run();
            if(input==7)
                typingTest.run();
            System.out.println("(1)quit or (2) play again?");
            input = pencil.nextInt();
            pencil.nextLine();
            if(input==1)
                break;
        }
    }

}
