/**
 * A simple data structure with FIFO behavior. The underlying data structure is a plain String array.
 *
 * FIFO (First-In First-Out) is a queue model where items exit the queue in the order that they enter it.
 * FIFOs are the queues we experience at grocery store checkouts, waiting in line at a food counter, etc.
 */
public class WaitingArea {

    /** Underlying array for the FIFO queue */
    private String[] waitingArea;

    /** How many items are already queued up? */
    private int occupancy;


    /**
     * Basic constructor, initializes underlying array to specified size and sets occupancy to 0
     * @param capacity size of the queue
     */
    public WaitingArea(int capacity) {
        waitingArea = new String[capacity];
        occupancy = 0;
    } // basic constructor WaitingArea


    /**
     * Accessor for the length of the underlying array, which is the capacity of the FIFO queue
     * @return int with length of underlying array.
     */
    public int getCapacity() { return waitingArea.length; } // method getCapacity


    /**
     * Accessor for the occupancy of the array, ie how many positions are assigned to waiting items
     * @return int with number of array positions occupied by waiting items
     */
    public int getOccupancy() { return occupancy; } // method getOccupancy


    /**
     * Method to add a car to the waiting area, if there is room for it. Space availability is determined by
     * comparing the occupancy of the queue to its capacity. As long as occupancy < capacity, there is room
     * in the waiting area. The value of occupancy also indicates what's the available position in the array
     * to host the new item.
     *
     *      [4] [3] [2] [1] [0]
     *     +---+---+---+---+---+
     *     |   |   | x | x | x |
     *     +---+---+---+---+---+
     *
     * For example, the array above has a capacity (.legth) of 5. Three of its 5 elements are occupied so its
     * occupancy value is 3. A new arrival to this queue will be placed at position = occupancy = 3.
     *
     * @param carDescription String with car description
     * @return true is car added to waiting area; false otherwise
     */
    public boolean addCar(String carDescription) {
        boolean success = (occupancy < waitingArea.length); // Is there room for one more car?
        if ( success ) {
            waitingArea[occupancy] = carDescription; // occupancy also tells us where to place an item
            occupancy++;
        }
        return success;
    } // method addCar


    /**
     * Method to move a car from the front of the the line, and then every car in line also moves one position forward.
     *
     * @return carToWash String with car removed from the line
     */
    public String moveCartoWashingBay() {
        String carToWash = null;
        if (occupancy >0) {
            occupancy--; // let's adjust the size
            carToWash = waitingArea[0]; // always remove from the front
            /*
            Loop below moves everything one step closer to the front of the line. Notice that if occupancy drops to 0
            then the loop doesn't execute at all. This makes sense because there are no cars in line to move forward.
             */
            for (int i = 0; i < occupancy; i++) { // shift everyone towards the front
                waitingArea[i] = waitingArea[i+1];
            }
            waitingArea[occupancy] = null; // vacate last position
        }
        return carToWash;
    } // method moveCartoWashingBay

} // class WaitingArea
