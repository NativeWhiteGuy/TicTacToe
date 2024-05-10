import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//This is two player TicTacToe
public class Tic {

        static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
        static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
        //static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

        static boolean continueGame = true;

    public static void main(String[] args) {

        char gameBoard [][] =   {{' ', '|', ' ', '|', ' ', },
        {'-', '+', '-', '+', '-', },
        {' ', '|', ' ', '|', ' ', },
        {'-', '+', '-', '+', '-', },
        {' ', '|', ' ', '|', ' ', }};

        printGameBoard(gameBoard);
        char move = 'X';
        Scanner scan = new Scanner(System.in);



        while(continueGame == true){
            System.out.println();
            System.out.print("Enter your placement: ");
            int pos = scan.nextInt();

            while(player1Positions.contains(pos) || player2Positions.contains(pos)) {
                System.out.println();
                System.out.println("Placement already taken. Choose another placement.");
                System.out.println("Enter your placement: ");

                pos = scan.nextInt();
            }

            makeMove(gameBoard, move, pos);

            if(move == 'X'){
                move = 'O';
                player1Positions.add(pos);
            }
            else{
                move = 'X';
                player2Positions.add(pos);
            }
            checkGameWinner(gameBoard);
            printGameBoard(gameBoard);
        }

    }

    public static void checkGameWinner(char[][] gameBoard){
        List topRow =  Arrays.asList(1, 2, 3);
        List middleRow =  Arrays.asList(4, 5, 6);
        List bottomRow =  Arrays.asList(7, 8, 9);
        List leftCol =  Arrays.asList(1, 4, 7);
        List middleCol =  Arrays.asList(2, 5, 8);
        List rightCol =  Arrays.asList(3, 6, 9);
        List cross1 =  Arrays.asList(1, 5, 9);
        List cross2 =  Arrays.asList(3, 5, 7);

        List<List> winningPositions = new ArrayList<List>();
        winningPositions.add(topRow);
        winningPositions.add(middleRow);
        winningPositions.add(bottomRow);
        winningPositions.add(leftCol);
        winningPositions.add(middleCol);
        winningPositions.add(rightCol);
        winningPositions.add(cross1);
        winningPositions.add(cross2);

        for (List l : winningPositions){
            if (player1Positions.containsAll(l)){
                System.out.println("Player 'X' Won!");
                continueGame = false;
            }
            else if (player2Positions.containsAll(l)){
                System.out.println("Player 'O' Won!");
                continueGame = false;
            }
        }
        if ((player1Positions.size() + player2Positions.size() == 9) && (continueGame == true)){
            System.out.println("It is a tie!");
            continueGame = false;
        }
    }

    public static void makeMove(char[][] gameBoard, char move, int pos) {
        switch(pos){
            case 1:
                gameBoard[0][0] = move;
                break;
            case 2:
                gameBoard[0][2] = move;
                break;
            case 3:
                gameBoard[0][4] = move;
                break;
            case 4:
                gameBoard[2][0] = move;
                break;
            case 5:
                gameBoard[2][2] = move;
                break;
            case 6:
                gameBoard[2][4] = move;
                break;
            case 7:
                gameBoard[4][0] = move;
                break;
            case 8:
                gameBoard[4][2] = move;
                break;
            case 9:
                gameBoard[4][4] = move;
                break;
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
