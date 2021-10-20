import java.util.ArrayList;
import java.util.Scanner;

public class CTATrainRoute {

    private static final String ALL_STATIONS_CSV =
            "https://raw.githubusercontent.com/lgreco/DataStructures/master/data/stations.csv";
    private static final String RED_LINE_SOUTHBOUND_TXT =
            "https://raw.githubusercontent.com/lgreco/DataStructures/master/data/RedLineSouthBound.txt";

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
    public CTATrainRoute buildRoute(String linkToSequenceFile) {
        // Set up the train route object we'll be returning.
        CTATrainRoute ctaTrainRoute = new CTATrainRoute();
        // Set up a scanner to the file with the station sequence.
        Scanner sequence = CTAUtilities.CTAScanner(linkToSequenceFile);
        // If null, we can't connect to file.
        if (sequence != null) {
            // Pull all stations into an array list.
            ArrayList<CTAStation> allStations = CTAUtilities.pullCTAData(ALL_STATIONS_CSV);
            // Go through the sequence file, line by line.
            while(sequence.hasNext()) {
                // Each line in the sequence file is the name of a station.
                String nameFromSequence = sequence.nextLine();
                // Use the enhanced for-loop go over the CTAStation objects in the array list.
                for (CTAStation station: allStations) {
                    // If a CTAStation has the same name as what we get from sequence, add the object to the route.
                    if(station.getName().equals(nameFromSequence)) {
                        ctaTrainRoute.add(station);
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
     * @param name String with name of station we are looking for
     * @return true if station exists in route
     */
    public boolean contains(String name) {
        boolean success = false;
        return success;
    } // method contains


    /**
     * Method to invert an existing route.
     *
     * @return
     */
    public CTATrainRoute invertRoute(CTATrainRoute oppositeRoute) {
        CTATrainRoute inverted = new CTATrainRoute();
        inverted.add(oppositeRoute.head);
        System.out.println("New inverted head added");
        CTAStation current = oppositeRoute.head.getNext();
        System.out.println(current.getName());
        System.out.println(inverted.head.getName());
        while (current.hasNext()) {
            System.out.println(current.getName());
            CTAStation copyCurrent = current;
            copyCurrent.setNext(inverted.head);
            inverted.head = copyCurrent;
            current = current.getNext();
        }

        return inverted;
    } // method invertRoute


    /**
     *
     * @return
     *
     */
    public String toString() {
        String result;
        if (head == null) {
            result = "This line is empty.";
        } else {
            // String result = "This route starts at " + head.getName() + " and continues to:";
            result = String.format("\nThis route starts at %s and continues to:", head.getName());
            // bad bad bad decision ...
            CTAStation current = head.getNext();
            // While not at the last station ...
            while (current.hasNext()) {
                result = result + String.format("\n\t%15s", current.getName());
                current = current.getNext();
            }
            // current is now the last station
            result = result + String.format("\nand ends at: %s", current.getName());
        }
        return result;
    } // method toString

    /** Driver method for quick testing */
    public static void main(String[] args) {
        CTATrainRoute redLineSouthBound = new CTATrainRoute();
        redLineSouthBound = redLineSouthBound.buildRoute(RED_LINE_SOUTHBOUND_TXT);
        // System.out.println(redLineSouthBound);

        CTATrainRoute redLineNorthBound = redLineSouthBound.invertRoute(redLineSouthBound);
        //System.out.println(redLineNorthBound);
    }

} // class CTATRainRoute

