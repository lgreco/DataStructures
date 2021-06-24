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
public class TrainRouteLEO {

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


    /** Quick demo */
    public static void main(String[] args) {
        // Instantiate class TrainRoute to model Amtrak's Lincoln Service
        TrainRouteLEO lincolnService = new TrainRouteLEO();

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

        lincolnService.insertAfterStation("Chicago", "Aurora");
        lincolnService.displayRoute();

        // Attempt to remove a non existing station from a populated route.
        lincolnService.removeStation("Rockford");

        lincolnService.removeStation("Alton");
        lincolnService.removeStation("St. Louis");
        lincolnService.removeStation("Carlinville");
        lincolnService.removeStation("Springfield");
        lincolnService.removeStation("Chicago");
        lincolnService.removeStation("Bloomington-Normal");
        lincolnService.removeStation("Aurora");
        lincolnService.removeStation("Joliet");
        lincolnService.removeStation("Dwight");
        lincolnService.removeStation("Summit");
        lincolnService.removeStation("Pontiac");
        lincolnService.removeStation("Chicago");
        lincolnService.removeStation("Lincoln");

        // Attempt to remove a non existing station from an empty route.
        lincolnService.removeStation("Rockford");

    }
}