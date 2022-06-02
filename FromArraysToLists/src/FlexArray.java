import java.util.Arrays;

public class FlexArray {

    /** Default size for array; must be > 0. */
    private static final int DEFAULT_SIZE = 10;

    /** Default resizing factor. */
    private static final int DEFAULT_RESIZE = 2;

    /** The core array for this object. */
    private String[] values;

    /** Next available spot in the core array. */
    private int location;

    /**
     * Parameterized constructor.
     *
     * @param size int that determines the size of the core array.
     */
    public FlexArray(int size) {
        // Size must be realistic, i.e, > 0
        if (size > 0)
            this.values = new String[size];
        else
            // Otherwise, use the default size.
            this.values = new String[DEFAULT_SIZE];
        // Initialize the location for placement in the core array.
        this.location = 0;
    }  // constructor FlexArray


    /**
     * Default constructor. Calls parameterized constructor with default size.
     */
    public FlexArray() {
        this(DEFAULT_SIZE);
    }  // constructor FlexArray


    /**
     * Adds a string to the first available place in the core array.
     *
     * @param s String to be added to the core array.
     */
    public void add(String s) {
        // First, make sure there is room in the array
        if (location == values.length) {
            System.out.printf("\nRESIZING: Location=%d, values.length=%d", location, values.length);
            resize(DEFAULT_RESIZE);
        }
        System.out.printf("\nAdding element to location %d with values.length=%d", location, values.length);
        values[location] = s;
        location++;
        System.out.printf("\nLocation=%d\n", location);
    }  // method add

    public void resize(int byFactor) {
        String[] temporary = new String[values.length];
        temporary = values;
        values = new String[values.length * byFactor];
        for (int i = 0; i < temporary.length; i++)
            values[i] = temporary[i];
        System.out.println("\nResizing completed.");
    }  // method resize

    public boolean remove(String s) {
        boolean success = false;
        int index = 0;
        while (!success && index < values.length) {
            success = values[index].equals(s);
            index++;
        }
        if (success) {
            for (int i = index-1; i < location-1; i++) {
                values[i] = values[i+1];
            }
            location--;
        }
        return success;
    }

    @Override
    public String toString() {
        return "\nFlexArray{" +
                "values=" + Arrays.toString(values) +
                ", used=" + location +
                '}';
    }
}
