package xerweek1.src;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        char[] board = createBoard();
        String winner = null;
        boolean finished = false;
        Player current = new Player (null, ' ');
        int i = 0;
        Player[] d = {p1,p2,p1,p2,p1,p2,p1,p2,p1};

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);



        while (!isFull(board)) {
            // -- Input ----------
            current = d[i];
            board[getPlayerSelection(current,board)] = current.mark;

            // --- Process ----------

            // Straight horizontal
            for (int j = 0; j < board.length; j+=3) {
                if (board[j] == current.mark && board[j+1] == current.mark && board[j+2] == current.mark ) {
                    winner = current.name;
                    finished = true;
                    break;
                }
            }
            // Straight vertical
            for (int j = 0; j < 3; j++) {
                if (board[j] == current.mark && board[j+3] == current.mark && board[j+6] == current.mark ) {
                    winner = current.name;
                    finished = true;
                    break;
                }
            }
            // Diagonal
            for (int j = 0; j < 1; j++) {
                if (board[0] == current.mark && board[4] == current.mark && board[8] == current.mark ) {
                    winner = current.name;
                    finished = true;
                    break;
                }
            }

            // Anti-diagonal
            for (int j = 0; j < 1; j++) {
                if (board[2] == current.mark && board[4] == current.mark && board[6] == current.mark ) {
                    winner = current.name;
                    finished = true;
                    break;
                }
            }
            if (finished) {
                break;
            }
            // -- Output --------
            plotBoard(board);
            i++;
        }

        out.println("Game over!");
        plotBoard(board);


        if (winner != null) {
            out.println("Winner is " + current.name);
        } else {
            out.println("Draw");
        }
    }


    // ---------- Methods  ----------------
    char[] createBoard(){
        char[] array = {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY};
        return array;   // For now return nothing!
    }

    boolean isFull(char[] board){
        for (char s : board) {
            if ('-' == s) {
                return false;
            }
        }
        return true;   // For now return false
    }

    // ---------- IO Methods  ----------------

    int getPlayerSelection(Player player, char[] board) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (1-9) > ");
            selection = sc.nextInt()-1;
            if (0 <= selection && selection <= 8 && board[selection] == '-') {
                break;
            }
            out.println("Bad choice (0-8 allowed, no overlap)");
        }
        return selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
        Player(String n, char m) {
            name = n;
            mark = m;
        }
    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);


        exit(0);
    }
}