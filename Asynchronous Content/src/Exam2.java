import java.util.Scanner;

public class Exam2 {

    /**
     * Method accepts numbers (until neg number is entered) and
     * keeps track of two smallest values. Every time a number
     * less than the smallest of the two is detected, it pushes
     * the smallest of the two up, and takes its place.
     */
    public static void smallestTwo(Scanner scanner) {
        // initialize variables for small and smaller
        int smaller = 2147483647; // highest int value possible
        int small = smaller;
        boolean continueLoop = true; // flag when to end loop
        while (continueLoop) {
            // obtain a number from the console
            System.out.printf("\nPlease enter an integer (type a neg number to quit): ");
            int number = scanner.nextInt();
            if (number >= 0) { // process only if number is non neg.
                if (number < smaller) { // number less than smaller?
                    small = smaller; // move smaller up to small
                    smaller = number; // make new number the smaller number
                } else if (number==smaller) { // in case the same number is entered again
                    small = smaller;
                }
            } else { // negative number detected
                continueLoop = false; // flag to end the loop
            }
        }
        System.out.printf("\n\nThe two smallest numbers are %d and %d\n\n", smaller,small);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        smallestTwo(s);

    }
}
