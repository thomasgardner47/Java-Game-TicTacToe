import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        //2D array of chars
        // in a 2D array, an array starts with a row

        char[] [] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        // the below code allows the user to place a piece inside a space
        // to do this we will pass in index's
        // however it is easier if we just give each box a number e.g. 1 - 9



        Scanner scan = new Scanner(System.in); // the scanner allows the user to input information
        System.out.println("Enter your placement (1-9): "); // we''ll prompt the user to place a number here
        int pos = scan.nextInt(); // we use scan.nextInt because we're asking the user for a number 1 - 9


        System.out.println(pos);

        switch(pos) {
            case 1:
                gameBoard[0][0] = 'X';
                break;
            case 2:
                gameBoard[0][2] = 'X';
                break;
            case 3:
                gameBoard[0][4] = 'X';
                break;
            case 4:
                gameBoard[2][0] = 'X';
                break;
            case 5:
                gameBoard[2][2] = 'X';
                break;
            case 6:
                gameBoard[2][4] = 'X';
                break;
            case 7:
                gameBoard[4][0] = 'X';
                break;
            case 8:
                gameBoard[4][2] = 'X';
                break;
            case 9:
                gameBoard[4][4] = 'X';
                break;

        }
        printGameBoard(gameBoard);
    }

    public static void printGameBoard(char [] [] gameBoard){
        for (char [] row : gameBoard) {
            for (char c : row) {
                System.out.println(c);
            }
            System.out.println();
        }
    }
}