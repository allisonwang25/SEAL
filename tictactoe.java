import java.util.*;
  public class tictactoe {
    
    public static String[] tttboard;
    public static String playerturn;
    public static String checkWinner()
    {
        for (int n = 0; n < 8; n++) 
        {
            String ttt = null;
  
            switch (n) {
            case 0:
                ttt = tttboard[0] + tttboard[1] + tttboard[2];
                break;
            case 1:
               ttt = tttboard[3] + tttboard[4] + tttboard[5];
                break;
            case 2:
                ttt = tttboard[6] + tttboard[7] + tttboard[8];
                break;
            case 3:
                ttt = tttboard[0] + tttboard[3] + tttboard[6];
                break;
            case 4:
                ttt = tttboard[1] + tttboard[4] + tttboard[7];
                break;
            case 5:
                ttt = tttboard[2] + tttboard[5] + tttboard[8];
                break;
            case 6:
                ttt = tttboard[0] + tttboard[4] + tttboard[8];
                break;
            case 7:
                ttt = tttboard[2] + tttboard[4] + tttboard[6];
                break;
            }
            if (ttt.equals("XXX")) {
                return "X is the winner";
            }
              
            
            else if (ttt.equals("OOO")) {
                return "O is the winner";
            }
        }
          
        for (int x = 0; x < 9; x++) 
        {
            if (Arrays.asList(tttboard).contains(String.valueOf(x + 1))) 
            {
                break;
            }
            else if (x == 8) 
            {
                return "this match is a draw";
            }
        }
        System.out.println(playerturn + "'s turn; enter a coordinate to make your move ");
        return null;
    }
    public static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + tttboard[0] + " | "+ tttboard[1] + " | " + tttboard[2]+ " |");
        System.out.println("|-----------|");
        System.out.println("| " + tttboard[3] + " | " + tttboard[4] + " | " + tttboard[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tttboard[6] + " | " + tttboard[7] + " | " + tttboard[8] + " |");
        System.out.println("|---|---|---|");
    }
    public static void run()
    {
        Scanner pencil = new Scanner(System.in);
        tttboard = new String[9];
        playerturn = "X";
        String win = null;
  
        for (int y = 0; y < 9; y++) 
        {
            tttboard[y] = String.valueOf(y + 1);
        }
  
        System.out.println("Welcome to tic tac toe!");
        printBoard();
        System.out.println("X will make the first move. Enter a coordinate to make your move:");
         while (win == null) {
            int input;
             try {
                input = pencil.nextInt();
                if (!(input > 0 && input <= 9)) 
                {
                    System.out.println("invalid input; please enter a different coordinate:");
                    continue;
                }
            }
            catch (InputMismatchException e) 
            {
                System.out.println("invalid input; please enter a different coordinate:");
                continue;
            }
            if (tttboard[input - 1].equals(String.valueOf(input))) 
            {
              tttboard[input - 1] = playerturn;
              if (playerturn.equals("X")) 
              {
                    playerturn = "O";
                }
                else {
                    playerturn = "X";
                }
  
                printBoard();
                win = checkWinner();
            }
            else {
                System.out.println(
                    "this coordinate is already occupied, please enter a different coordinate:");
            }
        }
        if (win.equalsIgnoreCase("draw")) 
        {
            System.out.println("this match is a draw");
        }
        else 
        {
            System.out.println(win + " is the winner!.");
        }
    }
}
