/**
 * A simple interface to provide array flexibility, allowing the resizing
 * of an array, as elements are added to it.
 *
 * @author lgreco@gmail.com
 *
 */
public interface Flexibility {
    /**
     * Method to return the number of elements this array can accommodate.
     * @return the number of elements this array can accommodate
     */
    int size();

    /**
     * Method to return the number of elements currently stored in the array.
     *
     * @return the number of elements currently stored in the array.
     */
    int occupancy();

    /**
     * Method to return a newly created, flexible array.
     * @return the newly created, flexible array.
     */
    int[] newArray();

    /**
     * Method to add a value after the last inserted element in the array and,
     * if necessary, expand the size of the array to accommodate the new value.
     *
     * @param value the value to be added to the array.
     * @return the array with the new value added to it.
     */
    int[] addElement(int value);

    /**
     * Method to add a value at a given position in the array - that position
     * may or may not be within current bounds. If necessary, this method
     * expands the array to provide the space for the requested position.
     * It is left to the Developer to determine where the next addElement(int value)
     * operation will place the new value.
     *
     * @param value the value to be added to the array.
     * @param position the position where the new value should be placed at.
     * @return the array with the new value added to it.
     */
    int[] addElement(int value, int position);
}