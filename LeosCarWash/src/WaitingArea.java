/**
 * A simple data structure that behaves like a queue. The underlying data structure
 * is a simple String array.
 */
public class WaitingArea {

    private String[] waitingArea;
    private int size;

    public WaitingArea(int capacity) {
        waitingArea = new String[capacity];
        size = 0;
    }

    public int getCapacity() { return waitingArea.length; } ;

    public int getSize() { return size; }


    /**
     * Adds a car to the waiting area, if there is room for it.
     * @param carDescription
     * @return true is car added to waiting area; false otherwise
     */
    public boolean addCar(String carDescription) {
        boolean success = (size < waitingArea.length);
        if ( success ) {
            int endOfLinePosition = size;
            waitingArea[endOfLinePosition] = carDescription;
            size++;
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
        if (size>0) {
            size--; // let's adjust the size
            carToWash = waitingArea[0]; // always remove from the front
            for (int i = 0; i < size; i++) { // shift everyone towards the front
                waitingArea[i] = waitingArea[i+1];
            }
            waitingArea[size] = null; // vacate last position
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
