/**
 * A basic class for FIFO and LIFO operations, with fixed time operations. In this
 * implementation, we use two variables to mark the front and the back of the data
 * structure. These markers move, as needed, from left to right, reaching the end
 * of the underlying array, and then they move to the beginning. Moving the markers
 * requires only an addition and a modulo operation, essentially yielding constant
 * time performance for insertions and deletions.
 */

public class XIFO_ConstantTime {

    /** Default array size */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array of the class */
    private String[] values;

    /** How many elements are occupied? */
    private int usage;

    /** Front and pack markers for the queue */
    int front, back;


    /** Basic constructor */
    public XIFO_ConstantTime(int size) {
        this.values = new String[size];
        this.usage = 0;
        this.front = 0;
        this.back = 0;
    }


    /** Default constructor */
    public XIFO_ConstantTime() {
        this(DEFAULT_SIZE);
    }


    /**
     * Returns the fraction of used elements over total elements in the array
     * @return a value between 0.0 and 1.0 indicating utilization of array elements.
     */
    public float utilization() {
        return ((float) this.usage)/((float) this.values.length);
    }  // method utilization


    /**
     * Method to remove and return the first element of array values.
     */
    public String remove() {
        String removed = null;
        // Operate on non-empty lists
        if (this.usage > 0) {
            // remove from the front of the array
            removed = this.values[this.front];
            // Move the front marker to the next position (eventually moving to [0] and repeat)
            this.front = (this.front+1)%this.values.length;
            // Decrease usage
            this.usage--;
        }
        return removed;
    }  // method remove


    /**
     * Adds an element at the *first available* position of array values.
     * Method checks to ensure that there is room for the new element.
     *
     * @param string to add to the array
     */
    public void add(String string) {
        // Operate only if there is room for one more arrival
        if (this.usage < this.values.length) {
            // Place the new arrival to the back of the array
            this.values[this.back] = string;
            // Move the back marker to the next position (eventually wrapping around)
            this.back = (this.back+1)%this.values.length;
            // Increase usage
            this.usage++;
        }
    }  // method add


    /**
     * Adds an element at the first position (`[0]`) of array values.
     * Method checks to ensure that there is room for the new element.
     *
     * @param string to add to the array.
     */
    public void firstElement(String string) {
        // Will finish this later
    }  // method firstElement
}
