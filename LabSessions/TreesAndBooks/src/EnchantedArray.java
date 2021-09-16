/**
 * COMP 271's implementation of a simple dynamic array class. Objects in this class are based on a
 * String array. They can grow, in size, in response to user needs. The class contains two fields:
 *
 *           String[] a: the underlying array that holds the strings we wish to store.
 *
 *            int inUse: the number of strings we have stored in a[]. As a plain array, a[]
 *                       has a specific size, i.e., a.length. But not every element in a[]
 *                       may be in use. Field inUse tells us how many elements of a[] we
 *                       currently use for storage. As such, inUse is always <= a.length.
 *                       This of a.length as the total number of rooms in a hotel, and inUse
 *                       as the number of rooms that have a guest.
 *
 * int performanceSteps: this is a field we use to measure performance, and specifically how many
 *                       steps it takes to add (or not) an element to the array using the addUnique method.
 *                       The performance of addUnique is dominated by the performance of method
 *                       contains. So we place this counter in method contains.
 */
public class EnchantedArray {

    /** Underlying array of the class. Everything in this class is based on a[] */
    private String[] a;

    /** How many elements are occupied. isUse <= a.length, always! */
    public int inUse;

    /** Number of steps for unique insertion. (To be used for performance demonstration) */
    int performanceSteps;

    /** Default constructor */
    public EnchantedArray() {
        a = new String[10];
        inUse = 0;
        performanceSteps = 0;
    } // constructor EnchantedArray

    /** Parameterized constructor */
    public EnchantedArray(int numberOfElements) {
        a = new String[numberOfElements];
        inUse = 0;
        performanceSteps = 0;
    } // constructor EnchantedArray

    /**
     * Method to add data to array a.
     *
     * The method ensures that there is room in the array. As long as inUse < a.length, there is room to add a
     * new element to a[]. The new element is added at the first available position, which is a[inUse]. If no
     * room is available, array a is resized.
     *
     * @param string String to be added in a[]
     */
    void add(String string) {
        if (inUse < a.length) { // There is room for one more entry
            a[inUse] = string; // New element goes at first available position
            inUse++; // Update number of elements stored in a[]
        } else { // Array a is full; need to make room
            String[] temporaryArray = new String[a.length + 1]; // Create a temp array larger than a[]
            for (int i = 0; i < a.length; i++) { // Copy every element used in a[] to the temp array
                temporaryArray[i] = a[i];
            }
            temporaryArray[inUse] = string; // Add new entry to temp, same way is a[] had room for it.
            a = temporaryArray; // Copy temp to a
            inUse++;  // Update number of elements stored in a[]
        }
    } // method add


    /**
     * Method that returns the contents of the Enchanted array at specified position.
     *
     * The method returns null if desired position is not occupied or out of array bounds.
     *
     * @param position int of position we wish to retrieve
     */
    String getContents(int position) {
        String content = null; // Assume the position is not occupied or is out of bounds.
        if (position < inUse) { // But if it is a legit position ...
            content = a[position]; // ... retrieve its content.
        }
        return content;
    } // method getContents


    /**
     * Method that tells if a string is present in array.
     *
     * The method scans only the elements of a[] that are in use. Use of while-loop optimizes performance because
     * the loop ends as soon as it finds a match. The only time the loop rouns through every element in 0...inUse-1
     * is when it fails to find the target string or when the target string is stored at a[inUse-1].
     *
     * @param string String we are searching for
     * @return true if string present in a[]; false otherwise
     */
    boolean contains(String string) {
        boolean result = false;
        int i = 0;
        while (!result && i < inUse) {
            result = a[i].equals(string);
            i++;
            performanceSteps++;
        }
        return result;
    } // method contains


    /**
     * Method that adds a string to a[] only if no similar string already stored.
     *
     * @param string String to add to array
     */
    void addUnique(String string) {
        if (! contains(string)) { // The string is not in the array, so ...
            add(string); // ...  ok to add it.
        }
    } // method addUnique


    /**
     * Accessor for inUse
     * @return int current value of field inUse
     */
    public int getInUse() {
        return inUse;
    } // method getInUse


    /**
     * Accessor for performanceSteps
     * @return int performanceSteps
     */
    public int getPerformanceSteps() {
        return performanceSteps;
    } // method getPerformanceSteps


    /**
     * Method that reports performance in terms of steps per unique insertion.
     */
    public void reportPerformance() {
        double perInsertion = ((double) performanceSteps)/((double) inUse);
        System.out.printf("Array has %d unique elements that required %d steps for insertion.\nThat's %.1f steps per element.\n\n", inUse,performanceSteps, perInsertion);
    } // method reportPerformance

} // class EnchantedArray
