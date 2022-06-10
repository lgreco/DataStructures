/**
 * An instantiable class to store strings.
 */
public class DynamicArray {

    /** Default array size constant */
    private static final int DEFAULT_SIZE = 5;
    /** Default resizing factor */
    private static final int DEFAULT_RESIZE_FACTOR = 2;


    /** Underlying storage mechanism: a humble array! */
    private String[] aHumbleArray;
    /** Next available location in the array to store new data */
    private int nextAvailable;


    /**
     * Parameterized constructor. It ensures that the passed size is greater than 0.
     * If a negative size is passed to the constructor, we use the default size
     * for the underlying array.
     *
     * @param size int with desired size for the underlying array.
     *
     */
    public DynamicArray(int size) {
        // Ensure that size is > 0
        size = (size > 0) ? size : DEFAULT_SIZE;
        // Initialize the humble array
        aHumbleArray = new String[size];
        // Initialize pointer to the next available opening in the array.
        nextAvailable = 0;
    }  // parameterized constructor


    /**
     * Tell the class how to create a simple copy of itself.
     *
     */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    }  // default constructor


    /**
     * Adds a string to the array.
     *
     * Method ensures that there is always room to add the string. If the array is full,
     * the array is resized to make room.
     *
     * @param s String to add to the dynamic array. This parameter is made final to
     *          protect it from any accidental or intentional modification.
     */
    public void add(final String s) {
        // If we are out of room, resize first
        if (nextAvailable == aHumbleArray.length)
            resize();
        // Room assured; add the new string
        aHumbleArray[nextAvailable] = s;
        // Update the pointer to the next available spot.
        nextAvailable++;
    }  // method add


    /**
     * Resizes the underlying array when we need more storage room.
     *
     * @param factor int multiplier for resizing the array. Must be > 1
     */
    private void resize(int factor) {
        // Ensure that factor > 1
        factor = (factor > 1) ? factor : DEFAULT_RESIZE_FACTOR;
        // Create a temporary array with more room
        String[] temporary = new String[2*aHumbleArray.length];
        // Copy the humble array contents to the temporary array
        for (int i = 0; i < aHumbleArray.length; i++)
            temporary[i] = aHumbleArray[i];
        // Copy the temporary array to the humble array.
        aHumbleArray = temporary;
    }  // method resize


    /** Default resize method doubles the array */
    private void resize() {
        // Call the parameterized resize method with a factor 2
        resize(DEFAULT_RESIZE_FACTOR);
    }  // method resize


}  // class DynamicArray
