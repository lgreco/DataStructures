import java.util.Random;


/**
 * Utility class to measure performance between the two intersection methods develoed in
 * class LinkedList.
 */
public class PerformanceAnalysis {

    private static final int A = 'A';
    private static final int LETTERS_IN_ALPHABET = 26;

    /**
     * Creates a string of specified length with random upper case letters
     * @param howMany
     * @return
     */
    public static String randomLetters(int howMany) {
        Random rng = new Random();
        String output = "";
        for (int i = 0; i < howMany; i++) {
            output += (char)(A+rng.nextInt(LETTERS_IN_ALPHABET));
        }
        return output;
    } // method randomLetters


    /**
     * Creates a list with a specific number of elements and populated them with
     * random strings
     * @param ofSize int size of list
     * @param stringLength int number of characters in content string
     * @return LinkedList populated with random strings
     */
    public static LinkedList populateList(int ofSize, int stringLength) {
        LinkedList newList = new LinkedList();
        for (int i = 0; i < ofSize; i++) {
            newList.addNode(randomLetters(stringLength));
        }
        return newList;
    } // method populateList


    /**
     * Counts steps for finding intersections using two different functions.
     *
     * Method tests only efficient method. The performance of the elegant method is
     * always N*N.
     *
     * @param listSize int size of lists to test
     * @param stringLength int length of content string in these lists
     * @param smooth int how many times to run the experiment for smooth averaging
     * @return double[] with results for elegant and efficient method
     */
    public static double[] countSteps(int listSize, int stringLength, int smooth) {
        double stepsCount[] = new double[2];
        int efficiencyAccumulator = 0;
        for (int i = 0; i < smooth; i++) {
            LinkedList listA = populateList(listSize,stringLength);
            LinkedList listB = populateList(listSize, stringLength);
            listA.intersects(listB); // Test efficient method only to obtain efficientSteps
            efficiencyAccumulator += listA.getEfficientSteps();
        }
        stepsCount[0] = (double) (listSize*listSize);
        stepsCount[1] = ((double) efficiencyAccumulator)/((double) smooth);
        return stepsCount; // [0] elegance; [1] efficiency
    } // method countSteps


    /**
     * Prob two words with same number of letters are same.
     *
     *     The computation is similar to the "birthday problem" and based on the
     *     fact that
     *
     *       prob[two words same] = 1 - prob[not same]
     *
     *     because it is easier to compute the second probability above. The
     *     function uses the Taylor series expansion for exp(x):
     *
     *       exp(x) = 1 + x + x^2/2 + ...
     *
     *     which for sufficiently small values of x can be shorted to exp(x) = 1+x
     *     and therefore exp(-x) = 1-x, or x = 1-exp(-x)
     *
     * @param among int number of total nodes
     * @param length int string length in nodes content
     * @return double probability two nodes will have them same content
     */
    public static double probSameWord(int among, int length) {
        double amg = (double) among;
        double len = (double) length;
        return 1.0 - Math.exp((-Math.pow(amg,2)/(2.0*(Math.pow(26,len)))));
    } // method probSameWord


    /**
     * Collects data over a range of list sizes.
     *
     * Usage:
     *
     *     from_power_2: determines size of smallest list as 2**from_power_2
     *       to_power_2: determines size of largest list as 2**to_power_2
     *    string_length: how many letters to store in each node
     *           smooth: how many times to test two lists of given size and random
     *                   configuration every time.
     *
     *  Output
     *          size: the number of elements in each of the two lists we test
     *                for intersections.
     *   probability: the probability that two lists of that size, where each node
     *                has string_length, will have at least one common node.
     *      elegance: the steps it takes for the elegant implementation to
     *                reach a conclusion.
     *    efficiency: the steps it takes for the efficient implementation to
     *                reach a conclusion.
     *       speedup: how faster the efficient function runs compared to
     *                the elegant function.
     *
     *  Notes:
     *  - For values of to_power_2 > 10, results may take a while to obtain.
     *  - The higher the string_length is, the less likely is to find an
     *    intersection between two lists. As this likelihood decreases, the
     *    performance of the two methods becomes comparable: when there is no
     *    intersection between two lists, both functions we test take the same
     *    time to reach their conclusion.
     *
     * @param fromPower2 int size of smallest list as 2**from_power_2
     * @param toPower2 int size of largest list as 2**to_power_2
     * @param stringLength int number of letters to store in each node
     * @param smooth int how many times to test two lists.
     */
    public static void collectData(int fromPower2, int toPower2, int stringLength, int smooth){
        int currentPower2 = fromPower2;
        System.out.printf("%5s %12s   %10s   %10s %15s\n", "size", "prob", "elegance", "efficiency", "speedup");
        while (currentPower2 <= toPower2) {
            int listSize = (int) Math.pow(2,currentPower2);
            double results[] = countSteps(listSize, stringLength, smooth);
            double speedUp = 100.0*(results[0]-results[1])/results[1];
            double probability = probSameWord(listSize, stringLength);
            System.out.printf("%5d %12.7f %10.0f %10.0f %20.6f%%\n", listSize, probability, results[0], results[1], speedUp);
            currentPower2++;
        }
    } // method collectData


    /** Driver */
    public static void main(String[] args) {
        collectData(0, 12, 2,10);
    } // method main
} // class PerformanceAnalysis
