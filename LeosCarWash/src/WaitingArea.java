/**
 * A simple data structure with FIFO behavior. The underlying data structure is a plain String array.
 *
 * FIFO (First-In First-Out) is a queue model where items exit the queue in the order that they enter it.
 * FIFOs are the queues we experience at grocery store checkouts, waiting in line at a food counter, etc.
 */
public class WaitingArea {

    private String[] waitingArea;
    private int occupancy; // cars currently in waiting

    public WaitingArea(int capacity) {
        waitingArea = new String[capacity];
        occupancy = 0;
    }

    public int getCapacity() { return waitingArea.length; } ;

    public int getOccupancy() { return occupancy; }


    /**
     * Adds a car to the waiting area, if there is room for it.
     * @param carDescription
     * @return true is car added to waiting area; false otherwise
     */
    public boolean addCar(String carDescription) {
        boolean success = (occupancy < waitingArea.length);
        if ( success ) {
            int endOfLinePosition = occupancy;
            waitingArea[endOfLinePosition] = carDescription;
            occupancy++;
        }
        return success;
    } // method addCar


    /**
     * Method to move a car from the front of the the line, and then
     * every car in line also moves one position forward.
     * @return carToWash String with car removed from the line
     */
    public String moveCartoWashingBay() {
        String carToWash = null;
        if (occupancy >0) {
            occupancy--; // let's adjust the size
            carToWash = waitingArea[0]; // always remove from the front
            for (int i = 0; i < occupancy; i++) { // shift everyone towards the front
                waitingArea[i] = waitingArea[i+1];
            }
            waitingArea[occupancy] = null; // vacate last position
        }
        return carToWash;
    } // method moveCartoWashingBay

    public static void main(String[] args) {
        int N = 5;
        WaitingArea leoCarWash = new WaitingArea(N);
        for (int i = 0; i < N+1; i++) {
            String car = String.format("Car%02d",i);
        }

        for (int i = 0; i < N+1; i++) {
            String car = String.format("Car%02d",i);
            leoCarWash.moveCartoWashingBay();
        }
    }
} // class WaitingArea
