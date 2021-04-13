/*
 * Lab friday 12
 * Description: creating a multi deimensional array then doing test cases to check if requirment for win is met.
 * Name: Alex Zaste
 * ID: 921392612
 * Class: CSC 211-02
 * Semester: spring 21
 */
import java.util.Scanner;

public class TicTacToe {
    public static Scanner input = new Scanner(System.in);
    public static int rows;// controls left to right
    public static int colums;//controls up and down
    public static char[][] board = new char[3][3]; //possibly make this a user input
    public static char turn = 'X'; // rotates between being equal to X and O
    //calls play method and creates the board.
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        //method plays a game of tictactoe
        StartGame();

    }

    //A method that continue until the boolean playing is changed to false.

    public static void StartGame() {
        boolean Playing = true;
        PrintBoard();
        while (Playing) {
            System.out.println("Enter a row followed by a column, you may choose between 1-3: ");//instructions
            System.out.println("It is now "+turn);
            rows = input.nextInt() - 1; // minus 1 so the use doesn't need to input 0
            colums = input.nextInt() - 1;
            board[rows][colums] = turn;
            //exit condition
            if (GameOver(rows, colums)) {
                Playing = false;
                System.out.println("The winner is! " + turn);
            }
            PrintBoard();
            if (turn == 'X')
                turn = 'O';
            else
                turn = 'X';
        }
    }

    // prints the array created in main via nested loops by interating through the loop and moving coordinates by 1 each itteration
    public static void PrintBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {

                if (j == 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " | ");

            }
        }
        System.out.println();
    }

    // determins if the game is over based on tic tac rules
    //uses if statements and & to check if coordinates are the same
    public static boolean GameOver(int rMove, int cMove) {
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove])
            return true;
        if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2])
            return true;
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
            return true;
        return false;
    }
}