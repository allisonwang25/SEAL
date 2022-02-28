import java.util.Scanner;
public class checkers {
    public static void run(){
        //setting up the board
        piece[][] board = new piece[8][8];
        for(int i = 0; i < 8; i++){
            if(i <= 2) {
                if (i % 2 == 0) {
                    for (int j = 0; j < 8; j++) {
                        if (j % 2 == 0)
                            board[i][j] = new piece("—", i, j, false);
                        else
                            board[i][j] = new piece("1", i, j, false);
                    }
                }
                else{
                    for (int j = 0; j < 8; j++) {
                        if (j % 2 == 0)
                            board[i][j] = new piece("1", i, j, false);
                        else
                            board[i][j] = new piece("—", i, j, false);
                    }
                }
            }
            else if(i <= 4){
                for(int j = 0; j < 8; j++)
                    board[i][j] = new piece("—", i, j, false);
            }
            else{
                if (i % 2 == 0) {
                    for (int j = 0; j < 8; j++) {
                        if (j % 2 == 0)
                            board[i][j] = new piece("—", i, j, false);
                        else
                            board[i][j] = new piece("2", i, j, false);
                    }
                }
                else{
                    for (int j = 0; j < 8; j++) {
                        if (j % 2 == 0)
                            board[i][j] = new piece("2", i, j, false);
                        else
                            board[i][j] = new piece("—", i, j, false);
                    }
                }
            }
        }

        int count = 0;
        String player = "";
        Scanner input = new Scanner(System.in);
        boolean continueOn = true;
        while(continueOn) { //one cycle for every turn: one for player 1, one for player 2
            printBoard(board);
            if(count > 0) {
                System.out.println("Do you want to keep playing?(yes/no)");
                String answer = input.nextLine();
                if (answer.equals("no")) {
                    System.out.println("ewww productivity");
                    break;
                }
            }

            //change based on which player is going, count increases by one every turn
            int posNeg = 1;
            if(count % 2 == 0) {
                player = "1";
                posNeg = 1;
            }
            else {
                player = "2";
                posNeg = -1;
            }

            //beginning of each turn
            System.out.println("Player " + player + ", it's your turn!");
            boolean valid = false;
            while(!valid) { //will run until the user inputs valid move
                //input move using normal counting rather than index counting
                System.out.println("Which piece would you like to move? Enter column number:");
                int column = input.nextInt() - 1;
                input.nextLine();
                System.out.println("Enter row number:");
                int row = input.nextInt() - 1;
                input.nextLine();

                int column1 = 0;
                int row1 = 0;
                int count1 = 0;
                boolean movable = true;
                while(movable) { //will run until there are no more takes possible
                    System.out.println("Where would you like to move it? Enter column number:");
                    column1 = input.nextInt() - 1;
                    input.nextLine();
                    System.out.println("Enter row number:");
                    row1 = input.nextInt() - 1;
                    input.nextLine();

                    valid = validCheck(board, player, row, column, row1, column1); //checks if move is valid

                    boolean outOBound = false;
                    boolean newKing = false;

                    if(count1 > 0 && Math.abs(column1-column) != 2 && Math.abs(row1-row) != 2) //count1 is only greater on a double take so the next move must be 2 spaces away
                        valid = false;

                    if (valid) {
                        board[row1][column1].setMarker(player);
                        if(board[row][column].getKing()){ //set king for if the original piece was king
                            board[row][column].setKing(false);
                            board[row1][column1].setKing(true);
                            if(player.equals("1"))
                                board[row1][column1].setMarker("1̶"); //marker for kings player 1
                            else if(player.equals("2"))
                                board[row1][column1].setMarker("2̶");//marker for kings player 2
                        }
                        board[row][column].setMarker("—");

                        newKing = kingCheck(board[row1][column1]);

                        if (Math.abs(column - column1) == 2 && Math.abs(row - row1) == 2) { //conditions for moves that are takes
                            int row2 = (row + row1) / 2;
                            int column2 = (column + column1) / 2;
                            board[row2][column2].setMarker("—");
                            if(board[row2][column2].getKing())
                                board[row2][column2].setKing(false);

                            movable = moveCheck(board, player, row1, column1, posNeg); //checks if there are any takes around the last move
                            if(newKing) //if piece becomes king during take, it can no longer take again so movable must be false
                                movable = false;
                            if(movable){ //if it is movable, print board again and change row and column to row1 and column1
                                count1++;
                                row = row1;
                                column = column1;
                                printBoard(board);
                            }
                        }
                        else{
                            movable = false;
                        }
                    }
                    else {
                        if(row < 0 || row > 8 || column < 0 || column > 8)  //move invalid because chosen piece is out of bounds
                            outOBound = true;
                        if(outOBound || !moveCheck(board,board[row][column]) || count1<1)
                            movable = false;
                        printBoard(board);
                    }
                }
            }
            boolean player1Win = true;
            boolean player2Win = true;
            //check for win player 1
            for(piece[] temp : board){
                for(piece temp1 : temp){
                    if(temp1.getMarker().equals("2") || temp1.getMarker().equals("2̶")) { //if any piece is player 2's then player 1 has not won (neccesarily)
                        player1Win = false;
                    }
                }
            }
            for(piece[] temp : board){
                for(piece temp1 : temp){
                    if(temp1.getMarker().equals("1") || temp1.getMarker().equals("1̶")) { //if any piece is player 1's then player 2 has not won (neccesarily)
                        player2Win = false;
                    }
                }
            }
            for(piece[] temp : board){
                for(piece temp1 : temp){
                    if(moveCheck(board,temp1) && (temp1.getMarker().equals("1") || temp1.getMarker().equals("1̶"))) { //if player 1 can move any piece then player 2 has not won (neccesarily)
                        player2Win = false;
                    }
                    else if(moveCheck(board,temp1) && temp1.getMarker().equals("2") || temp1.getMarker().equals("2̶")){ //if player 2 can move any piece then player 1 has not won (neccesarily)
                        player1Win = false;
                    }
                }
            }




            if(player1Win && player2Win){
                System.out.println("It's a tie!");
                continueOn = false;
            }
            else if(player1Win) {
                System.out.println("Player 1 wins!");
                continueOn = false;
            }
            else if(player2Win){
                System.out.println("Player 2 wins!");
                continueOn = false;
            }
            count++;

        }
    }

    public static void printBoard(piece[][] x){
        System.out.println("    1   2   3   4   5   6   7   8");
        System.out.println("  ————+———+———+———+———+———+———+————");
        for(int i = 0; i < 8; i++){
            System.out.print(i+1 + " |");
            for(int j = 0; j < 8; j++){
                System.out.print(" " + x[i][j] + " |");
            }
            System.out.println();
            System.out.println("  ————+———+———+———+———+———+———+————");
        }
    }
    public static boolean kingCheck(piece x){
        boolean newKing = false;
        if(x.getMarker().equals("1") && x.getYCor() == 7) {
            x.setKing(true);
            x.setMarker("1̶");
            newKing = true;
        }
        else if(x.getMarker().equals("2") && x.getYCor() == 0) {
            x.setKing(true);
            x.setMarker("2̶");
            newKing = true;
        }
        return newKing;
    }
    public static boolean validCheck(piece[][] board, String player, int row1, int column1, int row2, int column2){ //checks if move is valid
        boolean valid = true;
        String reason = "";
        if(row1 < 0 || row1 > 7 || column1 < 0 || column1 > 7) { //move is outside the board
            valid = false;
            reason = "The chosen piece is out of bounds!";
        }
        else if(row2 < 0 || row2 > 7 || column2 < 0 || column2 > 7){
            valid = false;
            reason = "The chosen space is out of bounds!";
        }
        else if(board[row1][column1].getMarker().equals("—")){
            valid = false;
            reason = "The chosen piece is empty!";
        }
        else if(!board[row1][column1].getMarker().equals(player) && (player.equals("1") && !board[row1][column1].getMarker().equals("1̶"))) { //the piece chosen is NOT the player's piece
            valid = false;
            reason = "The chosen piece isn't your piece!1";
        }
        else if(!board[row1][column1].getMarker().equals(player) && (player == "2" && !board[row1][column1].getMarker().equals("2̶"))) { //the piece chosen is NOT the player's piece
            valid = false;
            reason = "The chosen piece isn't your piece!2";
        }
        else if(!board[row2][column2].getMarker().equals("—")) {//the space chosen isn't empty
            valid = false;
            reason = "This chosen space isn't empty!";
        }

        //non-king pieces
        else if(player.equals("1") && ((row2 != row1 + 1 || (column2 != column1 + 1 && column2 != column1 - 1))) && !board[row1][column1].getKing()){ //player 1 piece does not go diagonal or in the correct direction
            if(row2 != row1 + 2 || column2 != column1 + 2 || (!board[row1 + 1][column1 + 1].getMarker().equals("2") && !board[row1+1][column1+1].getMarker().equals("2̶"))) { //take piece possibility 1
                if(row2 != row1 + 2 || column2 != column1 - 2 || (!board[row1 + 1][column1 - 1].getMarker().equals("2") && !board[row1+1][column1-1].getMarker().equals("2̶"))) { //take piece possibiility 2
                    valid = false;
                    reason = "The chosen space is either too far or not diagonal from the chosen piece!";
                }
            }
        }
        else if(player.equals("2") && (row2 != row1 - 1 || (column2 != column1 + 1 && column2 != column1 - 1)) && !board[row1][column1].getKing()){ //player 2 piece does not go diagonal or in the correct direction
            if(row2 != row1 - 2 || column2 != column1 + 2 || (!board[row1 - 1][column1 + 1].getMarker().equals("1") && !board[row1-1][column1+1].getMarker().equals("1̶"))){ //take piece possibility 1
                if(row2 != row1 - 2 || column2 != column1 - 2 || (!board[row1 - 1][column1 - 1].getMarker().equals("1")  && !board[row1-1][column1-1].getMarker().equals("1̶"))) { //take piece possibility 2
                    valid = false;
                    reason = "The chosen space is either too far or not diagonal from the chosen piece!";
                }
            }
        }
        //king pieces
        else if(board[row1][column1].getKing() && board[row1][column1].getMarker().equals("1̶") && ((row2 != row1 + 1 && row2 != row1 - 1) || (column2 != column1 + 1 && column2 != column1 - 1))){ //normal move for player 1 king
            if(row2 != row1 + 2 || column2 != column1 + 2 || (!board[row1 + 1][column1 + 1].getMarker().equals("2") && !board[row1+1][column1+1].getMarker().equals("2̶"))) { //take piece possibility 1
                if (row2 != row1 + 2 || column2 != column1 - 2 || (!board[row1 + 1][column1 - 1].getMarker().equals("2") && !board[row1+1][column1-1].getMarker().equals("2̶"))) { //take piece possibiility 2
                    if(row2 != row1 - 2 || column2 != column1 + 2 || (!board[row1 - 1][column1 + 1].getMarker().equals("2") && !board[row1-1][column1+1].getMarker().equals("2̶"))) { //take piece possibility 3
                        if(row2 != row1 - 2 || column2 != column1 - 2 || (!board[row1 - 1][column1 - 1].getMarker().equals("2") && !board[row1-1][column1-1].getMarker().equals("2̶"))) { //take piece possibility 4
                            valid = false;
                            reason = "The chosen space is either too far or not diagonal from the chosen piece!";
                        }
                    }
                }
            }
        }
        else if(board[row1][column1].getKing() && board[row1][column1].getMarker().equals("2̶") && ((row2 != row1 + 1 && row2 != row1 - 1) || (column2 != column1 + 1 && column2 != column1 - 1))){ //normal move for player 2 king
            if(row2 != row1 + 2 || column2 != column1 + 2 || (!board[row1 + 1][column1 + 1].getMarker().equals("1") && !board[row1+1][column1+1].getMarker().equals("1̶"))) { //take piece possibility 1
                if (row2 != row1 + 2 || column2 != column1 - 2 || (!board[row1 + 1][column1 - 1].getMarker().equals("1") && !board[row1+1][column1-1].getMarker().equals("1̶"))) { //take piece possibiility 2
                    if(row2 != row1 - 2 || column2 != column1 + 2 || (!board[row1 - 1][column1 + 1].getMarker().equals("1") && !board[row1-1][column1+1].getMarker().equals("1̶"))) {
                        if(row2 != row1 - 2 || column2 != column1 - 2 || (!board[row1 - 1][column1 - 1].getMarker().equals("1") && !board[row1-1][column1-1].getMarker().equals("1̶"))) {
                            valid = false;
                            reason = "The chosen space is either too far or not diagonal from the chosen piece!";
                        }
                    }
                }
            }
        }
        if(!valid)
            System.out.println("That isn't a valid move! " + reason);
        return valid;
    }
    public static boolean moveCheck(piece[][] board, String player, int row1, int column1, int posNeg){ //checks if anything more can be taken
        boolean result = false;
        String compare = "";
        String compare1 = "";
        if(player.equals("1")) {
            compare = "2";
            compare1 = "2̶";
        }
        else if(player.equals("2")) {
            compare = "1";
            compare1 = "1̶";
        }

        if(!board[row1][column1].getKing() &&
          row1+(posNeg * 2)>=0 && row1+(posNeg * 2)<8 &&
          ((column1+2<8 && (board[row1+posNeg][column1+1].getMarker().equals(compare) || board[row1+posNeg][column1+1].getMarker().equals(compare1)) && board[row1+(posNeg*2)][column1+2].getMarker().equals("—")) ||
          (column1-2>=0 && (board[row1+posNeg][column1-1].getMarker().equals(compare) || board[row1+posNeg][column1-1].getMarker().equals(compare1)) && board[row1+(posNeg*2)][column1-2].getMarker().equals("—")))){
            result = true;
        }
        else if(board[row1][column1].getKing() &&
                ((row1+2<8 && column1+2<8 && (board[row1+1][column1+1].getMarker().equals(compare) || board[row1+1][column1+1].getMarker().equals(compare1)) && board[row1+2][column1+2].getMarker().equals("—")) ||
                (row1+2<8 && column1-2>=0 && (board[row1+1][column1-1].getMarker().equals(compare) || board[row1+1][column1-1].getMarker().equals(compare1)) && board[row1+2][column1-2].getMarker().equals("—")) ||
                (row1-2>=0 && column1+2<8 && (board[row1-1][column1+1].getMarker().equals(compare) || board[row1-1][column1+1].getMarker().equals(compare1)) && board[row1-2][column1+2].getMarker().equals("—")) ||
                (row1-2>=0 && column1-2>=0 && (board[row1-1][column1-1].getMarker().equals(compare) || board[row1-1][column1-1].getMarker().equals(compare1)) && board[row1-2][column1+2].getMarker().equals("—")) )){
            result = true;
        }
        return result;
    }
    public static boolean moveCheck(piece[][] board, piece x){ //check if piece is movable
        boolean result = true;
        int row = x.getYCor();
        int col = x.getXCor();
        boolean king = x.getKing();
        String marker = x.getMarker();

        if(!king && marker.equals("1")){
            if(row+1<8 && col+1<8 && !board[row+1][col+1].getMarker().equals("—")) { //normal moves
                if (col-1>=0 && !board[row+1][col-1].getMarker().equals("—")) { //normal moves
                    if(row+2<8 && col+2<8 && !board[row+2][col+2].getMarker().equals("—")) { //taking moves
                        if(col-2>=0 && !board[row+2][col-2].getMarker().equals("—")) { //taking moves
                            result = false;
                        }
                    }
                }
            }
        }
        else if(!king && marker.equals("2")){
            if(row-1>=0 && col+1<8 && !board[row-1][col+1].getMarker().equals("—")) { //normal moves
                if (col-1>=0 && !board[row-1][col-1].getMarker().equals("—")) { //normal moves
                    if (row - 2 >= 0 && col + 2 < 8 && !board[row - 2][col + 2].getMarker().equals("—")) { //taking moves
                        if (col - 2 >= 0 && !board[row - 2][col - 2].getMarker().equals("—")) { //taking moves
                            result = false;
                        }
                    }
                }
            }
        }
        else if(king){
            if(row+1<8 && col+1<8 && !board[row+1][col+1].getMarker().equals("—")) {
                if (col - 1 >= 0 && !board[row + 1][col - 1].getMarker().equals("—")) {
                    if (row - 1 >= 0 && !board[row - 1][col + 1].getMarker().equals("—") && !board[row - 1][col - 1].getMarker().equals("—")){
                        if (row + 2 < 8 && col + 2 < 8 && !board[row + 2][col + 2].getMarker().equals("—")) { //taking moves
                            if (col - 2 >= 0 && !board[row + 2][col - 2].getMarker().equals("—")) { //taking moves
                                if (row - 2 >= 0 && !board[row - 2][col + 2].getMarker().equals("—") && !board[row - 2][col - 2].getMarker().equals("—")){ //taking moves
                                    result = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
