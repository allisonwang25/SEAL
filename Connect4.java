import java.util.*;
public class Connect4 
{
  public static void main(String[] args) 
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