import java.util.*;

public class ticTacToe {

    public static void run()
    {
        Scanner pencil = new Scanner(System.in);

        System.out.println("Welcome to TicTacToe! To make a move, enter the number of a space");
        String playerOne;
        String playerTwo;
        String sq1 = "1";
        String sq2 = "2";
        String sq3 = "3";
        String sq4 = "4";
        String sq5 = "5";
        String sq6 = "6";
        String sq7 = "7";
        String sq8 = "8";
        String sq9 = "9";
        int turns = 0;
        boolean loser=true;
        System.out.println("| "+sq1+" | "+sq2+" | "+sq3+" |\n| "+sq4+" | "+sq5+" | "+sq6+" |\n| "+sq7+" | "+sq8+" | "+sq9+" |");

        while(loser)
        {
            System.out.println("Player One make your move: ");
            playerOne = pencil.nextLine();
            if(playerOne.equals(sq1))
            {
                sq1 = "O";
            }
            else if(playerOne.equals(sq2))
            {
                sq2 = "O";
            }
            else if(playerOne.equals(sq3))
            {
                sq3 = "O";
            }
            else if(playerOne.equals(sq4))
            {
                sq4 = "O";
            }
            else if(playerOne.equals(sq5))
            {
                sq5 = "O";
            }
            else if(playerOne.equals(sq6))
            {
                sq6 = "O";
            }
            else if(playerOne.equals(sq7))
            {
                sq7 = "O";
            }
            else if(playerOne.equals(sq8))
            {
                sq8 = "O";
            }
            else
            {
                sq9 = "O";
            }

            turns++;

            System.out.println("| "+sq1+" | "+sq2+" | "+sq3+" |\n| "+sq4+" | "+sq5+" | "+sq6+" |\n| "+sq7+" | "+sq8+" | "+sq9+" |");

            if(sq1.equals("O")&& sq2.equals("O") && sq3.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!!!");
                break;
            }
            if(sq4.equals("O") && sq5.equals("O") && sq6.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }
            if(sq7.equals("O") && sq8.equals("O") && sq9.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }
            if(sq1.equals("O") && sq4.equals("O") && sq7.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }
            if(sq2.equals("O") && sq5.equals("O") && sq8.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }
            if(sq3.equals("O") && sq6.equals("O") && sq9.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }
            if(sq1.equals("O") && sq5.equals("O") && sq9.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }
            if(sq7.equals("O") && sq5.equals("O") && sq3.equals("O"))
            {
                System.out.println("THE WINNER IS PLAYER ONE!");
                break;
            }

            System.out.println("Player Two make your move: ");
            playerTwo = pencil.nextLine();
            if(playerTwo.equals(sq1))
            {
                sq1 = "X";
            }
            else if(playerTwo.equals(sq2))
            {
                sq2 = "X";
            }
            else if(playerTwo.equals(sq3))
            {
                sq3 = "X";
            }
            else if(playerTwo.equals(sq4))
            {
                sq4 = "X";
            }
            else if(playerTwo.equals(sq5))
            {
                sq5 = "X";
            }
            else if(playerTwo.equals(sq6))
            {
                sq6 = "X";
            }
            else if(playerTwo.equals(sq7))
            {
                sq7 = "X";
            }
            else if(playerTwo.equals(sq8))
            {
                sq8 = "X";
            }
            else if(playerTwo.equals(sq9))
            {
                sq9 = "X";
            }
            turns++;

            System.out.println("| "+sq1+" | "+sq2+" | "+sq3+" |\n| "+sq4+" | "+sq5+" | "+sq6+" |\n| "+sq7+" | "+sq8+" | "+sq9+" |");

            if(sq1.equals("X")&& sq2.equals("X") && sq3.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!!!");
                break;
            }
            else if(sq4.equals("X") && sq5.equals("X") && sq6.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }
            else if(sq7.equals("X") && sq8.equals("X") && sq9.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }
            else if(sq1.equals("X") && sq4.equals("X") && sq7.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }
            else if(sq2.equals("X") && sq5.equals("X") && sq8.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }
            else if(sq3.equals("X") && sq6.equals("X") && sq9.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }
            else if(sq1.equals("X") && sq5.equals("X") && sq9.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }
            else if(sq7.equals("X") && sq5.equals("X") && sq3.equals("X"))
            {
                System.out.println("THE WINNER IS PLAYER TWO!");
                break;
            }

            if(turns == 9)
            {
                System.out.println("STALEMATE--THERE IS NO WINNER!!");
            }

        }
    }
}