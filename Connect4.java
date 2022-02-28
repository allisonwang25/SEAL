
import java.util.Scanner;
public class Connect4 {
 public static void run(){
  boolean cont = true;
  String marker = "_";
  int count = 0;
  Scanner bub = new Scanner(System.in);
  String[][] board = new String[6][7];

  //actual game
  int player = 0;
  int c = 0;
  int column = 0;
  while(cont){
   //filling in empty board
   for(int i = 0; i < 6; i++){
    for(int j = 0; j < 7; j++){
     board[i][j] = "_";
    }
   }

   cont = false;
   boolean win = false;
   boolean valid = false;
   while(!win) {
    print(board);
    valid = false;

    if (count % 2 == 0) {
     player = 1;
     marker = "X";
    }
    else {
     player = 2;
     marker = "O";
    }

    while (!valid) { //doesn't move on until the player has chosen a valid move
     System.out.println("Player " + player + ", choose a column!");
     c = bub.nextInt();
     bub.nextLine();
     column = c - 1; //user inputs row starting with one
     if (board[0][column] != ("_")) //checks if there is space at the top
      System.out.println("Column " + c + " is full! Choose again!");
     else
      valid = true;
    }
    count++;

    for (int i = 0; i < 6; i++) {
     if (board[5 - i][column].equals("_")) {
      board[5 - i][column] = marker;
      board[5 - i][column] = marker;
      i = 6;
     }
    }

    //checking horizontal
    for (int j = 0; j < 6; j++) {
     for(int k = 0; k < 4; k++) {
      if (board[j][k].equals(marker) && board[j][k + 1].equals(marker) && board[j][k + 2].equals(marker) && board[j][k + 3].equals(marker)){
       print(board);
       System.out.println("Player " + player + " wins!");
       win = true;
      }

     }
    }
    //checking vertical
    for(int j = 0; j < 7; j++){
     for(int k = 0; k < 3; k++){
      if (board[k][j].equals(marker) && board[k + 1][j].equals(marker) && board[k + 2][j].equals(marker) && board[k + 3][j].equals(marker)){
       print(board);
       System.out.println("Player " + player + " wins!");
       win = true;
      }
     }
    }
    //checking diagonal
    // going to up and to the left
    for(int i = 0; i < 6; i++){
     for(int j = 0; j < 7; j++){
      if(board[i][j].equals(marker) && j - 1 > 0 && i - 1 > 0){
       if(board[i - 1][j - 1].equals(marker) && j - 2 > 0 && i - 2 > 0){
        if(board[i - 2][j - 2].equals(marker) && j - 3 > 0 && i - 3 > 0){
         if(board[i - 3][j - 3].equals(marker) && j - 4 > 0 && i - 4 > 0){
          print(board);
          System.out.println("Player " + player + " wins!");
          win = true;
         }
        }
       }
      }
     }
    }
    //going down and to the right
    for(int i = 0; i < 6; i++){
     for(int j = 0; j < 7; j++){
      if(board[i][j].equals(marker) && j + 1 < 7 && i - 1 > 0){
       if(board[i - 1][j + 1].equals(marker) && j + 2 < 7 && i - 2 > 0){
        if(board[i - 2][j + 2].equals(marker) && j + 3 < 7 && i - 3 > 0){
         if(board[i - 3][j + 3].equals(marker) && j + 4 < 7 && i - 4 > 0){
          print(board);
          System.out.println("Player " + player + " wins!");
          win = true;
         }
        }
       }
      }
     }
    }
    //going up and to the right
    for(int i = 0; i < 6; i++){
     for(int j = 0; j < 7; j++){
      if(board[i][j].equals(marker) && j + 1 < 7 && i + 1 < 6){
       if(board[i + 1][j + 1].equals(marker) && j + 2 < 7 && i + 2 < 6){
        if(board[i + 2][j + 2].equals(marker) && j + 3 < 7 && i + 3 < 6){
         if(board[i + 3][j + 3].equals(marker) && j + 4 < 7 && i + 4 < 6){
          print(board);
          System.out.println("Player " + player + " wins!");
          win = true;
         }
        }
       }
      }
     }
    }
    //going up and to the left
    for(int i = 0; i < 6; i++){
     for(int j = 0; j < 7; j++){
      if(board[i][j].equals(marker) && j - 1 > 0 && i + 1 < 6){
       if(board[i + 1][j - 1].equals(marker) && j - 2 > 0 && i + 2 < 6){
        if(board[i + 2][j - 2].equals(marker) && j - 3 > 0 && i + 3 < 6){
         if(board[i + 3][j - 3].equals(marker) && j - 4 > 0 && i + 4 < 6){
          print(board);
          System.out.println("Player " + player + " wins!");
          win = true;
         }
        }
       }
      }
     }
    }



    //board fills up with no victor case
    if(board[0][0] != "_" && board[0][1] != "_" && board[0][2] != "_" && board[0][3] != "_" && board[0][4] != "_" && board[0][5] != "_" && board[0][6] != "_") {
     print(board);
     System.out.println("Draw!");
     win = true;
    }
   }
   System.out.println("Would you like to play again(yes/no)?");
   if(bub.nextLine().equals("yes"))
    cont = true;
  }
 }

 public static void print(String[][] x){
  for(int i = 0; i < 6; i++){
   for(int j = 0; j < 7; j++){
    System.out.print(x[i][j]);
   }
   System.out.println();
  }
 }
}
/*import java.util.*;
public class Connect4 
{
  public static void run() 
  {
   Scanner pencil = new Scanner(System.in);
   char[][] cfgrid = new char[6][7];
   for (int i = 0; i < cfgrid.length; i++)
   {
    for (int j = 0; j < cfgrid[0].length; j++)
    {
     cfgrid[i][j] = ' ';
   }
  }
  int playerturn = 1;
  char playermove = 'R';
  boolean win = false;  
  
  while (win == false && playerturn <= 42)
  {
   boolean playerplay;
   int play;
   do 
   {
    display(cfgrid);
    System.out.print("Player " + playermove + ", choose a column to move: ");
    play = pencil.nextInt();
    playerplay = validate(play,cfgrid);
    }
   while (playerplay == false);
   
   for (int i = cfgrid.length-1; i >= 0; i--)
   {
    for (int j = 0; j < cfgrid[0].length; j++)
    {
    if(cfgrid[i][j] == ' ')
    {
     cfgrid[i][j] = playermove;
     break;
    }
   }
   win = istheWinner(playermove,cfgrid);
   if (playermove == 'R')
   {
    playermove = 'B';
   }
   else
   {
    playermove = 'R';
   }
   
   playerturn++; 
   
  }
  display(cfgrid);
  
  if (win)
  {
   if (playermove=='R')
   {
    System.out.println("Black is the winner!");
   }
   else
   {
    System.out.println("Red is the winner");
   }
  }
  else
  {
   System.out.println("This match is a draw");
  }
 }
  }
 public static void display(char[][] cfgrid)
 {
  System.out.println(" 0 1 2 3 4 5 6");
  System.out.println("---------------");
  for (int i = 0; i < cfgrid.length; i++)
  {
   System.out.print("|");
   for (int j = 0; j < cfgrid[0].length; j++)
   {
    System.out.print(cfgrid[i][j]);
    System.out.print("|");
   }
   System.out.println();
   System.out.println("---------------");
  }
  System.out.println(" 0 1 2 3 4 5 6");
  System.out.println();
 }
 
 public static boolean validate(int col, char[][] cfgrid)
 {
  if (col < 0 || col > cfgrid[0].length)
  {
   return false;
  }
  if (cfgrid[0][col] != ' ')
  {
   return false;
  }
  
  return true;
 }

 public static boolean istheWinner(char playerwin, char[][] cfgrid)
 {
   for(int i = 0; i < cfgrid.length; i++)
  {
   for (int j = 0; j <cfgrid[0].length - 3; j++)
   {
    if (cfgrid[i][j] == playerwin && cfgrid[i][j+1] == playerwin && cfgrid[i][j+2] == playerwin && cfgrid[i][j+3] == playerwin)
    {
     return true;
    }
   }   
  }
  for(int i = 0; i < cfgrid.length - 3; i++)
  {
   for(int j = 0; j < cfgrid[0].length; j++)
   {
    if (cfgrid[i][j] == playerwin && cfgrid[i+1][j] == playerwin && cfgrid[i+2][j] == playerwin && cfgrid[i+3][j] == playerwin)
    {
     return true;
    }
   }
  }
  for(int i = 3; i < cfgrid.length; i++)
  {
   for(int j = 0; j < cfgrid[0].length - 3; j++)
   {
    if (cfgrid[i][j] == playerwin && cfgrid[i-1][j+1] == playerwin && cfgrid[i-2][j+2] == playerwin && cfgrid[i-3][j+3] == playerwin)
    {
     return true;
    }
   }
  }
  for(int i = 0; i < cfgrid.length - 3; i++)
  {
   for(int j = 0; j < cfgrid[0].length - 3; j++)
   {
    if (cfgrid[i][j] == playerwin && cfgrid[i+1][j+1] == playerwin && cfgrid[i+2][j+2] == playerwin && cfgrid[i+3][j+3] == playerwin)
    {
     return true;
    }
   }
  }
  return false;
 }
}

 */
