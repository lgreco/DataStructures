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


    /**
     * Inserts a new station before a specific station.
     *
     * The method assumes that station with beforeName exists and therefore does
     * not offer any protection against a null pointer exception that may occur
     * in the while loop.
     *
     * @param beforeName name of the station where the new station will be
     *                   inserted before.
     * @param newName name of new station to insert
     */
    public void insertBefore(String beforeName, String newName) {
        // Create the new object to insert
        TrainStation newStation = new TrainStation(newName);
        // Inserting before the head station requires separate handling
        if (beforeName.equals(head.getName())) {
            // Have the new station point to head
            newStation.setNext(head);
            // And move the head label to the new station
            head = newStation;
        } else {
            // If we are not inserting before the head, prepare to traverse the list
            TrainStation current = this.head;
            // Looking for a station whose next station is the one we are inserting prior to
            while (!current.getNext().getName().equals(beforeName)) {
                current = current.getNext();
            }
            newStation.setNext(current.getNext());
            current.setNext(newStation);
        }
    }  // method insertBefore

    /**
     * Inserts a new station after a specific station.
     *
     * The method assumes that station with afterName exists and therefore does
     * not offer any protection against a null pointer exception that may occur
     * in the while loop. Method also assumes that there is no station with
     * newName in the train line, and therefore does not offer any protection
     * against a duplicate train station object.
     *
     * @param afterName name of the station where the new station will be
     *                   inserted before.
     * @param newName name of new station to insert
     */
    public void insertAfter(String afterName, String newName) {
        TrainStation newStation = new TrainStation(newName);
        TrainStation current = this.head;
        while (!current.getName().equals(afterName)) {
            current = current.getNext();
        }
        newStation.setNext(current.getNext());
        current.setNext(newStation);
    }  // method insertAfter


    /**
     * Deletes a station specified by name.
     *
     * @param name String with name of station to delete.
     */
    public void delete(String name) {
        if (this.head.getName().equals(name)) {
            // Remember what's after the head; we'll need it.
            TrainStation oldHeadPointedTo = this.head.getNext();
            // Make the current head point to nowhere.
            this.head.setNext(null);
            // Re-designate the head to the station after the old head.
            this.head = oldHeadPointedTo;
        } else {
            // Traverse line and fine station prior to one to be deleted
            TrainStation X = this.head;
            /*
            Traverse the list with a cursor called "previous" to signify that
            we are looking for the station prior to the one we wish to delete.
            Assume that d is the station to delete. Then
               d = previous.next
            To remove d, we need to connect the station before d (that would be
            the previous station) to the station after d (that would be d.next).
            Therefore, we want the assignment:
               previous.next = d.next
            Replacing d with previous.next above, we get
               previous.next = previous.next.next
            Or, using the get/set methods for the TrainStation object:
               previous.setNext(previous.getNext().getNext())
             */
            while ( X.hasNext() && (!X.getNext().getName().equals(name)) ) {
                System.out.printf("\nWe are at %s", X.getName());
                X = X.getNext();
            }
            System.out.printf("\nThe while loop has brought us to %s", X.getName());
            // Assign a new next station for station previous, if search successful
            if (X.hasNext()) {  // If X is not at the last station
                X.setNext(X.getNext().getNext());
            }
        }
    }  // method delete


    /**
     * String representation of the TrainLine.
     *
     * @return String with stations neatly arranged
     */
    public String toString() {
        // Introducing the use of StringBuilder objects
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            // If head is null, the train line is empty.
            sb.append("This train line has no stations.");
        } else {
            // There are stations. Prepare to traverse the line.
            TrainStation current = this.head;
            // Get the name of every station and add it to the StringBuilder object.
            while (current.hasNext()) {
                sb.append(String.format("%s --> ", current.getName()));
                // The "-->" needs to be a class constant not a "magic" value,
                // and I'll fix it later.
                current = current.getNext();
            }
            // The loop ends at the last station, which is very useful because
            // it allows us to omit the "-->" decoration after it.
            sb.append(current.getName());
        }
        // Convert the StringBuilder object to a String, using the StringBuilder
        // class's toString method, and return it.
        return sb.toString();
    }  // method toString


    /*
    For illustration only. A simple method to create a string representation of
    a TrainLine object, using just strings.
     */
    public String plainToString() {
        String string = new String();
        if (this.head == null) {
            string = "This train line has no stations.";
        } else {
            TrainStation current = this.head;
            while (current.hasNext()) {
                string = string + current.getName() + " --> ";
                current = current.getNext();
            }
            string = string + current.getName();
        }
        return string;
    }  // method plainToString


    /*
    For illustration only. The same simple method from above, slightly modified
    to use the format() method of the String class.
     */
    public String formattedToString() {
        String string = new String();
        if (this.head == null) {
            string = "This train line has no stations.";
        } else {
            TrainStation current = this.head;
            while (current.hasNext()) {
                string = String.format("%s --> ", current.getName());
                current = current.getNext();
            }
            string = string + current.getName();
        }
        return string;
    }  // method formattedToString

}
