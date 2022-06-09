import java.util.Random;
import java.util.Scanner;

/*
 A simple Rock Paper Scissors implementation
 BJP 5/e Ch. 5, Programming Project 5
 */
public class RPS {

    // CLASS CONSTANTS

    /** Class constants with move symbols */
    private static final String PAPER = "p", SCISSORS = "s", ROCK = "r";
    /** Class constant with symbol for "yes" answer */
    private static final String YES = "y";
    /** Array with game elements. Position in array is measure of element's strength. */
    private static final String order[] = {"Paper", "Scissors", "Rock"};

    // CLASS VARIABLES

    /** Game choices for computer and player */
    private static int computerChoice, playerChoice;
    /** Score keeping */
    private static int computerWins, playerWins, ties;
    /** Keyboard scanner */
    private static Scanner keyboard = new Scanner(System.in);
    /** Random number generator */
    static Random rng = new Random();


    /**
     * Obtain the player's next move.
     */
    public static void playerMove() {
        // Prompt player for a choice
        String move = keyboardInput("Your move (p)aper (s)cissors (r)ock: ");
        // Validate choice and if legal, update class variable for players choice
        if (move.length() == 1 && (move.equals(PAPER) || move.equals(SCISSORS) || move.equals(ROCK))) {
            if (move.equals(PAPER))
                playerChoice = 0;
            if (move.equals(SCISSORS))
                playerChoice = 1;
            if (move.equals(ROCK))
                playerChoice = 2;
        } else {
            // If choice not legit, ask again.
            playerMove();
        }
    }  // method playerMove


    /**
     * Obtain computer's next move.
     *
     * This method could evolve to include gaming strategies. For now, it uses a random number
     * generator to select the computer's game choice. Any choice obtained by the nextInt(3)
     * below is legal, because the resulting values are always 0, 1, or 2.
     */
    public static void computerMove() {
        computerChoice = rng.nextInt(3);
    }  // method computerMove


    /**
     * Game control. A game comprises one or more moves.
     *
     * This is the game engine. It comprises two nested while loops. The outer loop controls the game
     * itself. When the user is done playing, this loop ends the game, prints the results, and stops
     * the program.
     *
     * The inner while loop allows the player to try one more rounds.
     *
     */
    public static void gameControl() {
        welcome();
        boolean ready = true;
        while (ready) {
            String readyToPlay = keyboardInput("Ready to play? (y/n)");
            // Continue or stop the game based on user input
            ready = readyToPlay.equals(YES);
            if (ready) {
                // Initialize scores
                playerWins = 0;
                computerWins = 0;
                ties = 0;
                // Initialize control for multiple rounds.
                boolean playAgain = true;
                while (playAgain) {
                    // Ask the player for a move
                    playerMove();
                    // Get the computer's move
                    computerMove();
                    // Find the winner
                    outcome();
                    // Determine if the player wants to play another round.
                    String anotherRound = keyboardInput("Play another round? (y/n)");
                    playAgain = anotherRound.equals(YES);
                }
                // End of game; report results.
                reportResults();
            }
        }
    }  // method gameControl


    /**
     * Compare player and computer moves and determine outcome.
     *
     * The method compares class variables playerChoice and computerChoice to establish winner or tie,
     * displays the outcome, and updates the corresponding class variables for score keeping.
     */
    public static void outcome() {
        System.out.printf("You: %S -- Computer: %S ---- ",
                order[playerChoice], order[computerChoice]);
        if (playerChoice > computerChoice) {
            System.out.println("You win!");
            playerWins++;
        } else if (playerChoice < computerChoice) {
            System.out.println("The computer wins.");
            computerWins++;
        } else {
            System.out.println("It's a tie.");
            ties++;
        }
    }  // method outcome


    /**
     * Print the welcome message at the beginning of the game
     */
    public static void welcome() {
        System.out.println("\nWelcome to Rock-Scissors-Paper\n");
    }  // method welcome


    /**
     * Obtain an entry from the keyboard
     * @param prompt Message to display as an input prompt.
     * @return lowercased string with what was entered.
     */
    public static String keyboardInput(String prompt) {
        System.out.printf("\n\n%s ", prompt);
        String inputFromKeyboard = keyboard.next().toLowerCase();
        System.out.println();
        return inputFromKeyboard;
    }  // method keyboardInput


    /**
     * Display game results before ending the program.
     */
    public static void reportResults() {
        int totalGames = playerWins + computerWins + ties;
        System.out.println("Here's the score:");
        System.out.printf("\n\t      Games you won: %5d", playerWins);
        System.out.printf("\n\t Games computer won: %5d", computerWins);
        System.out.printf("\n\tGames ending in tie: %5d", ties);
        System.out.printf("\n\t Total games played: %5d", totalGames);
    }  // method reportResults


    /**
     * Driver code
     */
    public static void main(String[] args) {
        gameControl();
    }

}
