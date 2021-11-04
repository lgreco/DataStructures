import java.util.ArrayList;
import java.util.Scanner;

public class CTATrainRoute {

    /** The first station of a train line */
    private CTAStation head;

    /**
     * Method to add train stations to the line.
     *
     * New stations are ALWAYS added to the end of the list.
     *
     * @param ctaStation The CTAStation object to add to the end of this train route
     */
    public void add(CTAStation ctaStation) {
        if (head == null) {
            // Route is empty. Make new station the beginning of the line.
            head = ctaStation;
        } else {
            /*
            Route is not empty!

            Find where this route ends. To do so, board a train at the head of the line and
            let the train travel along the route. You can send the train to the next station,
            if there is one, and repeat these one-station-at-a-time trips. Until there is
            nowhere else to go. That's the last station.
             */
            CTAStation current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            /*
            The while-loop above lands you at the last station of the line. What do you need to do?
             */
            current.setNext(ctaStation);
        }
    } // method add


    /**
     * Method to build a train route based on station sequence.
     *
     * The station sequence is described in a text file available as a URL. The method uses an arraylist collection
     * of complete CTAStation objects to assemble the route.
     *
     * @param sequenceURL String with URL to sequence data
     * @return CTATrainRoute object with the station in the order specified; returns null if
     *         access to sequence data cannot be established
     */
    public CTATrainRoute buildRoute(String linkToSequenceFile, String linkToAllStations) {
        // Set up the train route object we'll be returning.
        CTATrainRoute ctaTrainRoute = new CTATrainRoute();
        // Set up a scanner to the file with the station sequence.
        Scanner sequence = CTAUtilities.CTAScanner(linkToSequenceFile);
        // If null, we can't connect to file.
        if (sequence != null) {
            // Pull all stations into an array list.
            ArrayList<CTAStation> allStations = CTAUtilities.pullCTAData(linkToAllStations);
            // Go through the sequence file, line by line.
            while(sequence.hasNext()) {
                // Each line in the sequence file is the name of a station.
                String nameFromSequence = sequence.nextLine();
                // Use the enhanced for-loop go over the CTAStation objects in the array list.
                for (CTAStation station: allStations) {
                    // If a CTAStation has the same name as what we get from sequence, add the object to the route.
                    if(station.getName().equals(nameFromSequence)) {
                        ctaTrainRoute.add(station);
                        System.out.printf("\n *** Adding %s with next set to %s", station.getName(), station.getNext());
                    }
                }
            }
        }
        // Return the (hopefully populated) route.
        return ctaTrainRoute;
    } // method buildRoute


    /**
     * Method that tells if a route contains a station, based on the name of it.
     *
     * @param nameLookingFor String with name of station we are looking for
     * @return true if station exists in route
     */
    public boolean contains(String nameLookingFor) {
        boolean success = false;
        // Traverse the route only if it is not empty0
        if (this.head != null) {
            CTAStation current = this.head;
            while (current != null && !success) {
               success = current.getName().equals(nameLookingFor);
                System.out.printf("\nIs \"%s\" equal to \"%s\"? %s", nameLookingFor,current.getName(), success);
               current = current.getNext();
                System.out.printf("\nGoing to next station: %s", current.getName());
            }
        }
        return success;
    } // method contains


    /**
     * Method to remove a train station from the present route.
     *
     * @param String with name of the station to remove
     * @return CTAStation removed, or null if station name not found
     */
    public CTAStation removeStation(String nameOfStationToRemove) {
        // Prepare the object that will be returned ...
        CTAStation removedStation = null;
        // Ensure that route is not empty
        if (head != null) {
            // Are we removing the head node by any chance?
            if (head.getName().equals(nameOfStationToRemove)) {
                // Capture what to return
                removedStation = head;
                // Assign head value using ternary operator 'cause it's cool to use
                head = (head.hasNext()) ? head.getNext() : null;
            } else {
                // We are not removing the head, so let's traverse.
                CTAStation current = head;
                CTAStation previous = null;
                // Loop below exits at station to delete or end of route if such station not present
                while (current != null && !current.getName().equals(nameOfStationToRemove)) {
                    previous = current;
                    current = current.getNext();
                }
                // If station to delete is present, remove it
                if (current != null) {
                    // Capture what to return
                    removedStation = current;
                    // Even if station to remove is the last one, the assignment below ensures a proper setNext
                    previous.setNext(current.getNext());
                }
            }
        }
        return removedStation;
    } // method removeStation


    /**
     * Method to detect intersection between two route.
     *
     * Usage:
     *
     *    routeA.intersects(routeB)
     *
     * @param other CTATrainRoute to compare with.
     * @return true if invoking route intersects other route.
     */
    public boolean intersects(CTATrainRoute other) {

        boolean intersection = false;
        CTAStation current = this.head;
        while (!intersection && current != null) {
            intersection = other.contains(current.getName());
            current = current.getNext();
        }
        return intersection;
        /*
        boolean intersection = false; // boolean we return
        int check = 0; // used to end while loops
        CTAStation thisCurrent = this.head; // used to cycle through initial train route stations
        CTAStation otherCurrent = other.head; //used to cycle through other train route stations
        while(check == 0) { // run indefinitely until line below returns true
            System.out.println("while(check == 0)");
            if(other.contains(thisCurrent.getName())) { // check if  the other train route has a station by the same name as the current station
                System.out.println("\tif(other.contains(thisCurrent.getName()) == true)");
                check++; // we then break the loop and continue
                while(check == 1) { // while the check is at this value
                    System.out.println("\t\twhile(check == 1)");
                    if(otherCurrent.getName().equals(thisCurrent.getName())) { // indefinitely look to see if otherCurrent has the same name as thisCurrent
                        check++; // if they share a name, we break the loop and move on
                    }
                    else {
                        otherCurrent = otherCurrent.getNext(); // otherwise we cycle through the route to find the station with the same name
                    }
                }
            }
            System.out.println("...");
            if(thisCurrent.getLatitude() == otherCurrent.getLatitude() && thisCurrent.getLongitude() == otherCurrent.getLongitude()) {
                System.out.println("\tif(thisCurrent.getLatitude() == otherCurrent.getLatitude() && ...");
                intersection = true; // then compare the latitudes and longitudes of both to see if they intersect. assuming they match set the boolean to true
            }
            else { // if the current station's name isn't found on the other route
                if(thisCurrent.getNext() != null) { // and if the next station on the current route isn't empty
                    System.out.println("\t\tif(thisCurrent.getNext() != null)");
                    thisCurrent = thisCurrent.getNext(); // we cycle through the current train route until it ends or finds a match
                }
                else {
                    check++; // if the route ends or a station is empty, we break the while loop
                    System.out.println("\t\t\tcheck++");
                }
                System.out.println("Still while");
            }
            System.out.println("endif");
        }// traverse this route and compare each station to every station from the other route.
        return intersection; //we return our variable */
    } // method intersects


    /**
     * Creates a new train route in the opposite direction.
     *
     * @return CTATrainRoute with stations in opposite direction.
     */
    public CTATrainRoute reverseRoute() {
        CTATrainRoute inverted = this;
        // Pointers to retain previous station and following station
        CTAStation previous = null, following = null, buffer = null;
        // Traverse the route
        CTAStation current = inverted.head;
        while (current != null) {
            // What's the following station ?
            following = current.getNext();
            // Flip current's next pointer to previous station
            current.setNext(previous);
            previous = current;
            // Slide to the next station
            current = following;
        }
        inverted.head = previous;
        return inverted;
    } // method reverseRoute


    /**
     * String representation of a train route
     *
     * @return String with nicely formatted contents from the train route.
     *
     */
    public String toString() {
        String result = "This line is empty.";
        if (head != null) {
            result = String.format("\nThis route starts at %s", head.getName());
            // Set up to print the rest of the route (if there are stations after the head station
            if (head.hasNext()) {
                result +=  " and continues to:";
                CTAStation current = head.getNext();
                // While not at the last station ...
                while (current.hasNext()) {
                    result = result + String.format("\n\t%15s", current.getName());
                    current = current.getNext();
                }
                // current is now the last station
                result = result + String.format("\nand ends at: %s", current.getName());
            } else {
                result += " and that as far as it goes.";
            }
        }
        return result;
    } // method toString
} // class CTATRainRoute

