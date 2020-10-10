/**
 * A simple class to demonstrate the concept of a linked list.
 *
 *
 *   Methods added during 16 SEP 2020 lab session.
 *
 *              METHOD NAME  WHAT IT DOES
 *       ==================  ================================================================
 *     -      stationExists: method to tell if a station exists at a given location
 *     - insertAfterStation: method to insert a station in a location after a given location
 *     -      removeStation: write a method to remove a station at a given location
 *
 *
 *   Homework (due Monday 21 SEP 2020):
 *
 *     - BONUS question: develop an interface based on class TrainRoute;
 *       name the interface: Trains.
 *
 *     - write a method called reverseRouteDisplay to print all stations along a train route
 *       in reverse order, without modifying class TrainRoute's fields, and without using
 *       any other data structures.
 *
 *     - write a method called removeStationsBetween that will remove all stations between
 *       a beginning and an ending location, e.g., in a Route like:
 *         A  -->  B  -->  C  -->  D  -->  E  -->  F  -->  G  -->  H
 *       removeStationsBetween(C,G) shall reduce the route to:
 *         A  -->  B  -->  C  -->  G  -->  H
 *       ie, the boundaries C and G are preserved but everything in-between them
 *       has been removed.
 */
public class TrainRoute {

    /**
     * The only field of this class is a Station object named head.
     */
    private Station head;

    /** Class station is defined as an inner class here. */
    class Station {
        /** The city where the station is located */
        String city;
        /** The next station down the line */
        Station next;

        /** Simple constructor for a Station object. Leaves .next null */
        public Station(String c) {
            city = c;
            next = null;
        }
    } // class Station

    /**
     * Method to add a station to the line. Station is added after the
     * last station and becomes the line's last station.
     * @param c Name of city where new station is located.
     */
    public void addStation(String c) {
        // Create a new station object at the given city.
        Station newStation = new Station(c);

        // Find where to place the the new station
        if (head == null) {
            // Train line is empty; make the new station the head station
            head = newStation;
        } else {
            // Train line is not empty. Find the last station, then add
            // the new station after it.
            Station currentStation = head;             // Starting from the head of the line
            while (currentStation.next != null) {      // go through every station to find the
                currentStation = currentStation.next;  // one whose .next is null. That's
            }                                          // the last station and we'll now
            currentStation.next = newStation;          // its .next to the new station.
        }
    } // method addStation

    /**
     * Method to determine if a station exists at a specified location
     * @param location Is there a station here?
     * @return True if there is a station object at this location
     */
    public boolean stationExists(String location) {
        boolean found;
        if ( head == null) {
            found = false; // TrainRoute is empty
        } else {
            Station current = head;
            found = false;
            while ( !found && current.next != null ) {
                found = ( current.city.equals(location) ) ? true : found;
                current = current.next;
            }
            found = ( current.city.equals(location) ) ? true : found;
        }
        return found;
    } // method stationExists

    /** Quick method to display a train line */
    public void displayRoute() {
        if ( head == null ) {
            System.out.println("The route is empty.");
        } else {
            // Route is not empty; start from the head and visit every station
            // (following the .next pointers), printing the cities along the way.
            Station currentStation = head;
            String outputPrefix = "Start of route:\t";
            while ( currentStation.next != null ) {
                System.out.println(outputPrefix + currentStation.city);
                currentStation = currentStation.next;
                outputPrefix = "\t\t\t\t";
            }
            // The loop above will not print the last Station, so we
            // have to do it below.
            System.out.println("End of route:\t" + currentStation.city);
            System.out.println();
        }
    } // method displayRoute

    /**
     * Method to insert a new station right after a given station. The method
     * conducts safety checks to determine that the given station exists and
     * that there is no station already at the existing location.
     * @param prior Station to add new station after
     * @param c Name of new station's location
     * @return true if insertion successful, false otherwise;
     */
    public boolean insertAfterStation(String prior, String c) {
        // Status flag .. that's what we return
        boolean success = false;
        // Before we do anything we must ensure that station at
        // prior location exists and that station at new location
        // does not exist
        if ( stationExists(prior) && !stationExists(c) ) {
            // Prior location exists and new location doesn't; let's create new station.
            Station newStation = new Station(c);
            // Find where to place new station;
            Station current = head;
            while ( current.next != null & !success) {
                if ( current.city.equals(prior) ) {
                    // Prior station located. Insert new Station after it.
                    newStation.next = current.next;
                    current.next = newStation;
                    success = true;
                }
                current = current.next;
            }

            /*
            At this point we have traversed the TrainRoute linked list except for
            its last Station. If we have not already located the specified prior
            location, then it must be the last Station in the list. Why? Because
            we know that there is a station at the location specified by prior;
            we were told so by stationExists(prior).
             */
            if (!success) {
                // current is the last Station. We insert the new station after it.
                current.next = newStation;
                success = true;
            }
        }
        return success;
    } // method insertAfterStation

    /**
     * Method to remove a station from a route.
     * @param location Name of location to have station removed from.
     * @return True if removal is successful.
     */
    public boolean removeStation(String location) {
        // Status flag
        boolean success = false;
        if ( head != null ) {
            // Route not empty.
            if ( stationExists(location) ) {
                // Station to be removed, exists.

                // Special case: one station only
                if ( head.next == null ) {
                    head = null;
                    success = true;
                }

                // Special case: two stations only
                if (!success) {
                    // We don't need to be here if the previous special case was successful.
                    if (head.next.next == null) {
                        // Confirming that the route has two stations only.
                        if (head.city.equals(location)) {
                            // Removing the head Station: its next one becomes head.
                            head = head.next;
                            head.next = null;
                        } else {
                            // Removing the second station: head now has no next.
                            head.next = null;
                        }
                        success = true;
                    } else {
                        // General case: three or more stations ...
                        Station current = head;
                        while (current.next != null && !success) {
                            // scan the route to find the station to remove
                            if (current.next.city.equals(location)) {
                            /*
                            Found!
                            current.next is the Station to remove; its previous
                            Station (Station current) must be connected with
                            its next (Station current.next.next) via the assingment
                            current.next = current.next.next; However we must
                            ensure first that current.next.next is not null, i.e.,
                            that current.next is not the last Station in the route.
                             */
                                if (current.next.next == null) {
                                    // current.next is the last Station
                                    current.next = null;
                                } else {
                                    // current.next is not the last Station
                                    current.next = current.next.next;
                                }
                                success = true;
                            }
                            // Be careful advancing current to next in case we were dealing
                            // with the last Station and its next is now null. Check for
                            // success and if true, we are done!
                            current = (success) ? current : current.next;
                        }
                    }
                }
            }
        }
        return success;
    } // method RemoveStation

    /**
     * Method to print the reverse of the train route
     */
    public void reverseRouteDisplay(){
        if ( head == null ) { // If the route is empty, print that it is empty
            System.out.println("The route is empty.");
        }
        else if (head.next == null){ // If there is only one station, print the station
            System.out.println("Start and end of route:\t" + head.city);
        }
        else{ // There is more than one station
            Station currentStation = head;
            while (currentStation.next != null){
                currentStation = currentStation.next; // Finds the last station in the route
            }
            System.out.println("End of route:\t" + currentStation.city); // Print the last station
            String outputPrefix = "\t\t\t\t"; // For formatting
            Station previousStation = head;
            while (previousStation.next != null){ //Iterate through the stations until you find ths station before the current station
                if (previousStation.next == currentStation){
                    System.out.println(outputPrefix + previousStation.city); // Print the station before the current station
                    currentStation = previousStation; // Set the current station equal to the station just printed
                    previousStation = head; // Reset previousStation to find the station before the one just printed
                }
                previousStation = previousStation.next;
            }
            System.out.println("Start of route:\t" + head.city); // Print the head station at the end
        }
    } // method reverseRouteDisplay

    /**
     * Method to remove the stations between two given stations while preserving the beginning and end stations.
     * The method first the beginning station and tarts removing each station thereafter until it arrives at the end station.
     * @param beginning Name of station to start at
     * @param end Name of station to end at
     * @return true if successful removal
     */
    public boolean removeStationsBetween_1(String beginning, String end){
        Station beginningStation = null;
        Station endStation = null;
        // Find the station at the beginning of the segment to delete
        Station currentStation = head;
        while (currentStation.next != null){
            if (currentStation.city.equals(beginning)){ // Found beginning station
                beginningStation = currentStation;
            }
            currentStation = currentStation.next; // We continue scanning just in case the beginning station is the last station in the route.
        }
        if (currentStation.city.equals(beginning)){ // If the last station is equal to the beginning argument
            return false; // Cannot use the last station as the beginning station
        }

        // Find the end station
        currentStation = head; // Reset current station
        if (currentStation.city.equals(end)){
            return false; // Cannot use first station as the end station
        }
        currentStation = currentStation.next; // possible bug: what if .next == null?
        while (currentStation.next != null){
            if (currentStation.city.equals(end)){ // Found the end station
                endStation = currentStation;
            }
            currentStation = currentStation.next;
        }
        if (currentStation.city.equals(end)){ // Accounts for the last station
            endStation = currentStation;
        }

        // Now that we have the beginning and end stations marked, we can
        // traverse between them, removing each station along the way.

        while(beginningStation.next != endStation){
            removeStation(beginningStation.next.city); // Remove the station after beginning until you reach the end station
        }
        return true; // Successful removal
    } // method removeStationsBetween_1

    /**
     * This msthod deletes a route segment between a beginning and end station, by simply
     * chaining the two stations together. But first it finds the beginning and end stations,
     * verify that they are connected with a number of stations in between them, and then
     * connects them, effectively dereferencing the inbetween stations, committing them to
     * the oblivion of garbage collection.
     * @param beginning
     * @param end
     * @return
     */
    public boolean removeStationsBetween_2(String beginning, String end) {
        Station deleteFromHere =null, deleteToHere = null;
        boolean success = false;
        if ( stationExists(beginning) && stationExists(end) ) { // stations exist
            // Let's make sure there is a ocntinuous route between them
            boolean continuousRoute = false;
            Station current = head;
            boolean scanRoute = true; // flag to scan route for the beginning station
            while (scanRoute) {
                if (current.city == beginning) {
                    deleteFromHere = current;
                    // scan from here to see if there is direct connection to end
                    scanRoute = false; // no need to continue scanning the route looking for the beginning station; we found it.
                    // determine if there is a direct path from here to the end station
                    while ( current.next != null ) {
                        if ( current.city == end) {
                            continuousRoute = true; // a continuous route was found
                            deleteToHere = current; // and this is the end station
                        }
                        current = current.next;
                    }
                    if ( current.city == end ) { // special case to check on the end node
                        continuousRoute = true; // because it's outside the scope of the
                        deleteToHere = current; // while loop above.
                    }
                } else { // let's try the next node to see if it's the beginning of the segment to delete
                    if ( current.next == null ) { // last node on the route; even if this station matches the
                        scanRoute = false; // beginning value, there is nothing after it to delete, so end the scanRoute
                    } else {
                        current = current.next; // try the next station
                    }
                }
            }
            // At this point continuousRoute tells us if there is a path from beginning to end
            if ( continuousRoute ) {
                success = true;
                // resect the stations in between
                deleteFromHere.next = deleteToHere;
            }
        }
        return success;
    } // method removeStationsBetween_2


    /** Quick demo */
    public static void main(String[] args) {
        // Instantiate class TrainRoute to model Amtrak's Lincoln Service
        TrainRoute lincolnService = new TrainRoute();

        lincolnService.addStation("Chicago"); // Becomes head station
        lincolnService.addStation("Summit");
        lincolnService.addStation("Joliet");
        lincolnService.addStation("Dwight");
        lincolnService.addStation("Pontiac");
        lincolnService.addStation("Bloomington-Normal");
        lincolnService.addStation("Lincoln");
        lincolnService.addStation("Springfield");
        lincolnService.addStation("Carlinville");
        lincolnService.addStation("Alton");
        lincolnService.addStation("St. Louis");

        System.out.println("\n\nReverse route:\n");
        lincolnService.reverseRouteDisplay();
        System.out.println("\n\nAfter removals:\n");
        lincolnService.removeStationsBetween_2("Summit", "Lincoln");
        lincolnService.displayRoute();

    }
}