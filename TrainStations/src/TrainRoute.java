/**
 * A simple class tp demonstrate the concept of a linked list.
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
        }
    } // method displayRoute




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

        lincolnService.displayRoute();

        System.out.println(lincolnService.stationExists("Summit"));
        System.out.println(lincolnService.stationExists("Drama"));
    }
}
