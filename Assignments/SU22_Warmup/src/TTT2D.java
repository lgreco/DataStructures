
import java.util.Random;
import java.util.Scanner;

/*
 A simple Tic Tac Toe implementation
 BJP 5/e Ch. 7, Programming Project 5
 */

public class TTT2D {

    // CLASS CONSTANTS

    /** Game size */
    private static final int SIZE = 3;
    /** Symbols */
    private static final char
            EX = 'X',
            OH = 'O',
            SPACE = ' ',
            VER = '\u2503',
            HOR = '\u2501',
            CROSS = '\u254B';
    /** Legal keyboard entries */
    private static String ME = "M", COMPUTER = "C", QUIT = "Q", YES = "Y";

    // CLASS VARIABLES

    /** Keyboard scanner */
    static Scanner keyboard = new Scanner(System.in);
    /** Board places still available for playing */
    static int available;
    /** Game board is a 3x3 char array */
    private static char[][] board = new char[SIZE][SIZE];
    /** Random number generator */
    static Random rng = new Random();
    /** Player and computer symbols */
    private static char player, computer;
    /** Score keeping */
    private static int playerWon, computerWon, ties;
    private static String winner;


    /**
     * This is the game engine.
     */
    public static void gameController() {
        // Select your symbol
        playerSymbol();
        // Reset game statistics
        computerWon = 0;
        playerWon = 0;
        ties = 0;
        // Who's first?
        String first;
        first = keyboardInput("Who makes the first move? (m)e or (c)omputer? Anything else to quit. ");
        if (first.equals(ME) || first.equals(COMPUTER)) {
            // String for controlling do-loop for another round.
            String anotherRound="";
            // Loop to keep playing rounds.
            do {
                // Flag to tell is there is a winner.
                boolean playerWins = false, computerWins = false;
                // Initialize game board
                initializeBoard();
                // Keep playing while there are empty spots and no winner is declared
                while (available > 0 && !playerWins &&!computerWins) {
                    if (first.equals(ME)) {
                        // Player makes first move
                        displayBoard(); playerMove(); computerMove();
                    } else {
                        // Computer makes first move
                        computerMove(); displayBoard(); playerMove();
                    }
                    // Check if either have won
                    playerWins = haveWinner(player);
                    computerWins = haveWinner(computer);
                }
                // This round has ended, let's update scores
                if (playerWins) {
                    playerWon++;
                    System.out.println("** You won! **");
                } else if (computerWins) {
                    computerWon++;
                    System.out.println("== The computer won. ==");
                } else {
                    ties++;
                    System.out.println("## It's a tie. ##");
                }
                anotherRound = keyboardInput("Another round? y/n? ");
            } while (anotherRound.equals(YES));
        }
        // report score
        report();
    }  // method gameController


    /** Ask player tro select a symbol; assign second symbol to comptuer */
    public static void playerSymbol() {
        char result;
        do {
            result = keyboardInput("Select your marker: " + String.valueOf(EX) + " or " + String.valueOf(OH)).charAt(0);
        } while (!(result == EX || result == OH));
        player = result;
        computer = (result == EX) ? OH : EX;
    }  // method playerSymbol


    /**
     * Obtain an entry from the keyboard
     * @param prompt Message to display as an input prompt.
     * @return lowercased string with what was entered.
     */
    public static String keyboardInput(String prompt) {
        System.out.printf("\n\n%s ", prompt);
        String inputFromKeyboard = keyboard.next().toUpperCase();
        System.out.println();
        return inputFromKeyboard;
    }  // method keyboardInput


    /** Initialize board before a new game and reset the number of available spots This
     * number helps determine when the game ends.
     */
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = SPACE;
        // Reset the number of available cells for the game.
        available = SIZE * SIZE;
    }  // method initializeBoard


    /** Display the game board. */
    private static void displayBoard() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("| %s ", board[i][j]);
            }
            System.out.print("|\n\n");
        }
        System.out.println();
    }  // method displayBoard


    /** Ask player to make a move and ensure it's a valid one */
    public static void playerMove() {
        String cell;
        do {
            cell = keyboardInput("Enter a row and column (e.g. A2): ");
        } while (available > 0 && !isValid(cell));
        board[cellRow(cell)][cellCol(cell)] = player;
        // Reduce available spots by one.
        available--;
    }  // method playerMove


    /** Computer makes random move, ensure the chosen spot is empty. */
    public static void computerMove() {
        int i, j;
        do {
            i = rng.nextInt(SIZE);
            j = rng.nextInt(SIZE);
        } while (available > 0 && !isValid(i,j));
        board[i][j] = computer;
        // Reduce available spots by one.
        available--;
    }  // method computerMove


    /**
     * Determines if the player with a given symbol (X or O) has won the game.
     * @param symbol char to check for
     * @return true if player with symbol has won.
     */
    public static boolean haveWinner(char symbol) {
        // Tests for a winner across a row, column, main diagonal, and antidiagonal.
        // Notice that diagonal tests are initialized to true; orthogonal to false.
        boolean horizontal = false, vertical = false, diagonal = true, antidiagonal = true;
        // Nest loops check for horizontal and vertical winning patters.
        for (int i = 0; i < SIZE; i++) {
            boolean hor = true, ver = true;
            for (int j = 0; j < SIZE - 1; j++) {
                hor = hor && board[i][j] == board[i][j+1] && board[i][j] == symbol;
                ver = ver && board[j][i] == board[j+1][i] && board[j][i] == symbol;
            }
            horizontal = horizontal || hor;
            vertical = vertical || ver;
        }
        // Loop to check diagonals. Can be incorporated with loop above, but this is more readable.
        for (int d = 0; d < SIZE - 1; d++) {
            diagonal = diagonal && board[d][d] == board[d+1][d+1] && board[d][d] == symbol;
            antidiagonal = antidiagonal && board[d][SIZE-1-d] == board[d+1][SIZE-1-(d+1)] && board[d][SIZE-1-d] == symbol;
        }
        // If one of the tests comes true, we have a winner.
        return horizontal || vertical || diagonal || antidiagonal;
    }  // method haveWinner


    /** Reports scores at the end of the rounds */
    public static void report() {
        System.out.println();
        System.out.printf("\n\t     Number of games you won: %3d", playerWon);
        System.out.printf("\n\tNumber of games computer won: %3d", computerWon);
        System.out.printf("\n\t                  Tied games: %3d\n\n", ties);
    }  // method report


    /** Convert the row label to an array row index. */
    public static int cellRow(String cell) {
        return (int) cell.charAt(0) - (int) 'A';
    }  // method cellRow


    /** Convert the column label into an array column index */
    public static int cellCol(String cell) {
        return (int) cell.charAt(1) - (int) '1';
    }  // method cellCol


    /**
     * Check the validity of a coordinates string. For example, string B2 should correspond to the
     * second row, second column of the game board.
     *
     * The method pulls the integer values of the coordinate string for row and column, then
     * calls its overloaded copy to assess the validity of those array coordinates.
     *
     * @param cell String with coordinates
     * @return true if coordinates within game board dimensions and cell is available (empty).
     */
    public static boolean isValid(String cell) {
        boolean result = cell.length() == 2; // MAGIC NUMBER correct it!
        if (result) {
            int row = cellRow(cell);
            int col = cellCol(cell);
            result = isValid(row, col);
        }
        return result;
    }  // method isValid


    /**
     * Method to check if two integers are legal array indices and if the corresponding
     * element is empty and therefore available for play.
     * @param i int row index
     * @param j int column index
     * @return true if i, j within array dimensions and if cell is empty.
     */
    public static boolean isValid(int i, int j) {
        return  i >= 0 && i < SIZE &&
                j >= 0 && j < SIZE &&
                board[i][j] == SPACE;
    }  // method isValid


    /** Driver code */
    public static void main(String[] args) {
        gameController();
    }
}  // class TTT2D