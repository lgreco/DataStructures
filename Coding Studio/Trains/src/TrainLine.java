/**
 * A train line to demonstrate the concept of a simple linked list.
 */

public class TrainLine {

    /** The only field of this class!!!!!! */
    private TrainStation head;

    /**
     * Default constructor; not needed really but never hurts to write one.
     */
    public TrainLine() {
        this.head = null;
    }  // default constructor

    /**
     * Adds a train station to the end of a train line.
     *
     * @param name Name of station to add, assuming this is a unique
     *             station for this train line.
     */
    public void addStation(String name) {
        // The new station to add
        TrainStation station = new TrainStation(name);
        // Where to add it?
        if (this.head == null) {
            // If there is no station in the line yet, new station becomes head
            this.head = station;
        } else {
            // Traverse the train line from the head station ...
            TrainStation current = this.head;
            // ..until you find the last station.
            while (current.hasNext()) {
                // If there is a station after this, move current pointer there.
                current = current.getNext();
            }
            // Loop ends when current is at the end of line; add new station here
            current.setNext(station);
        }
    }  // method addStation


    /**
     * Tells if a station with a specified name exista in the train line.
     *
     * @param name String with name of the station to search for.
     * @return true if station with specified name exists, false otherwise.
     */
    public boolean lineHasStation(String name) {
        // Assume station not present in train line.
        boolean found = false;
        // Prepare to traverse the linked list from its head on.
        TrainStation current = this.head;
        // Loop continues while there are stations to explore and name has not been found.
        while (!found && current != null) {
            // Update found variable
            found = current.getName().equals(name);
            // Move to the next station
            current = current.getNext();
        }
        return found;
    }  // method lineHasStation

}
