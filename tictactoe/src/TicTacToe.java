import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

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

        // now we want to make sure that the game is waiting for the user to make a decision
        // so now we need to make sure the system keeps waiting
        // to do this we need to place the code inside a while true statement which loops the code forever

        while (true) {
            System.out.println("Enter your placement (1-9): "); // we'll prompt the user to place a number here
            int playerPos = scan.nextInt(); // we use scan.nextInt because we're asking the user for a number 1 - 9
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("position taken! Enter a correct Position");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            String result = checkWinner();
            if (result.length() > 0 ) {
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }

    }

    public static void printGameBoard(char [] [] gameBoard){
        for (char [] row : gameBoard) {
            for (char c : row) {
                System.out.println(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos /* pass in a position */ , String user /*define a user*/) {

        char symbol = ' ';

        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = '0';
            cpuPositions.add(pos);
        } // this way we can switch between X and O depending on what player we give the system


        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;

        }
    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List LeftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(LeftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.contains(l)) {
                return "CPU Wins! Sorry...";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT!";
            }
        }

        return "";
    }
}