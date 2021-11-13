import java.util.Random;

/**
 * Class with static content that demonstrates some silly (but fun) sorting techniques.
 *
 */
public class TemereOrdinem {

    /**
     * Create an int array and populate it with random numbers.
     * @param magnitudine int size of the array
     * @return int array with random values
     */
    public static int[] creare(int magnitudine) {
        Random random = new Random();
        // Declare and initialize array to return
        int[] ordo = new int[magnitudine];
        // Populate array with random values
        for (int i = 0; i < magnitudine; i++)
            // Range of random values is 0 to magnitudine^2 
            ordo[i] = random.nextInt(magnitudine*magnitudine);
        return ordo;
    } // method creare


    /**
     * Determine if an int[] array is sorted in ascending order
     * @param ordo int array to test
     * @return true if in ascending order; false otherwise
     */
    public static boolean ordinem(int[] ordo) {
        // Assume array is sorted in ascending order
        boolean ordinatus = true;
        int i = 0;
        while (ordinatus && i < ordo.length-1) {
            // All it takes is one pair of unsorted values to end things.
            ordinatus = ordo[i] <= ordo[i+1];
            i++;
        }
        return ordinatus;
    } // method ordinem


    /**
     * Resuffle the elements of an array at random.
     * @param ordo int array to reshuffle randomly
     * @return int array after random reshuffling
     */
    public static int[] temere(int[] ordo) {
        Random random = new Random();
        for (int i = 0; i < ordo.length; i++) {
            int randomIndex = random.nextInt(ordo.length);
            int temp = ordo[i];
            ordo[i] = ordo[randomIndex];
            ordo[randomIndex] = temp;
        }
        return ordo;
    } // method temere


    /**
     * Attempt to sort an array by reshuffling it at random, and count the attempts
     * until it is done.
     * @param ordo array to sort by reshuffling at random
     * @return int how many reshuffles it took to sort the array
     */
    public static int tempto(int[] ordo) {
        int numeratio = 0;
        while (!ordinem(ordo)) {
            temere(ordo);
            numeratio++;
        }
        return numeratio;
    } // method tempto


    /**
     * Create an array of given size with random values, attempt to sort it with
     * random reshuffling, and report the results.
     * @param magnitudine int size of array to play with
     */
    public static void tracto(int magnitudine) {
        int[] ordo = creare(magnitudine);
        System.out.printf("It took %d random shuffle(s) to sort an array with %d element(s).\n",
                tempto(ordo), magnitudine);
    } // method tracto


    /** Driver code */
    public static void main(String[] args) {
        final int INITIUM = 1;
        final int FINIS = 10;
        for (int magnitudine = INITIUM; magnitudine < FINIS; magnitudine++)
            tracto(magnitudine);
    } // method main

} // class TemereOrdinem
