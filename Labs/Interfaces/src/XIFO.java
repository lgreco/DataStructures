public class XIFO {

    /** Default array size */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array of the class */
    private String[] values;

    /** How many elements are occupied? */
    private int usage;

    /** Basic constructor */
    public XIFO(int size) {
        this.values = new String[size];
        this.usage = 0;
    }

    /** Default constructor */
    public XIFO() {
        this(DEFAULT_SIZE);
    }

    public float utilization() {
        return ((float) this.usage)/((float) this.values.length );
    }

    /**
     * Method to remove and return the first element of `values`.
     */
    public String remove() {
        String removed = null;
        if (this.usage > 0) {
            // Array is not empty
            removed = this.values[0];
            // DUE THU 7/14: write a loop to move remaining elements one position to the left, and null at the end.
        }
        return removed;
    }  // method remove

    /** JOSE: Method to add an element at the *first available* position of `values`. */
    public void add(String string) {
        if (this.usage < this.values.length) {
            // There is room for one more element
           this.values[this.usage] = string;
           this.usage++;
        }
    }  // method add


    /** FATEHA: Method to add an element at the first position (`[0]`) of `values`. */
    public void firstElement(String string) {
        if (this.usage < this.values.length) {
            // There is room to add the new string
            // DUE THU 7/14: First, move everything one position to the right
            // Second:
            this.values[0] = string;
        }
    }
}
