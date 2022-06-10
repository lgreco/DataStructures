/**
 * An instantiable class to store strings.
 */
public class DynamicArray {

    /** Default array size constant */
    private static final int DEFAULT_SIZE = 5;


    /** Underlying storage mechanism: a humble array! */
    private String[] aHumbleArray;
    /** Next available location in the array to store new data */
    private int nextAvailable;


    /** Tell the class how to create a simple copy of itself */
    public DynamicArray() {
        // Initialize the array to the default size
        aHumbleArray = new String[DEFAULT_SIZE];
        // Pointer to next available spot in the array, to store data
        nextAvailable = 0;
    }  // default constructor


    /**
     * Adds a string to the array.
     *
     * Method ensures that there is always room to add the string. If the array is full,
     * the array is resized to make room.
     * @param s
     */
    public void add(String s) {
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
     */
    private void resize() {
        // Create a temporary array with more room
        String[] temporary = new String[2*aHumbleArray.length];
        // Copy the humble array contents to the temporary array
        for (int i = 0; i < aHumbleArray.length; i++)
            temporary[i] = aHumbleArray[i];
        // Copy the temporary array to the humble array.
        aHumbleArray = temporary;
    }  // method resize

}
