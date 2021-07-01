import java.util.ArrayList;
import java.util.List;

/**
 * A class to string together stations with bi- and unidirectional traffic,
 * modeling CTA lines. Given the layout of CTA lines, this class chooses to
 * use the northernmost station as the head station of a line whose principal
 * orientation is north/south. For east/west routes, the preferred head is
 * the westernmost station. When a line has prominent north and west points
 * (for example, Blue line), its head will be the northernmost station.
 */

public class CTALine {

    /**
     * The first station of a line. Use north or west terminus, based on the
     * convention stated above.
     */
    CTAStation head;

    /**
     * A pad to write down stations during outbound trips so that we can
     * remember them during inbound traveling. This pad, in the form of
     * an arraylist, helps us determine direction of travel when we reach
     * a bidirectional station from a unidirectional one.
     */
    List<CTAStation> visited = new ArrayList<CTAStation>();


    /**
     * Basic constructor that assigns a station as the head station of a line.
     *
     * @param head The first station on a line
     */
    public CTALine(CTAStation head) {
        this.head = head;
    } // constructor CTALine


    /**
     * Method to add a new station after a specified station. The method allows
     * us to specify if the new station accommodates bi- or uni-directional
     * traffic. Based on that specification, the method makes the necessary
     * outbound and inbound connections.
     *
     * Suggested revisions/improvements: make this method of boolean reference
     * so that we can have confirmation of successful addition. (Think first
     * if we need this modification. Under what conditions can this method go
     * wrong?)
     *
     * @param newStation The new station to be added.
     * @param afterStation The station after which to add the new station
     * @param bidirectional Will the new station be bi- or uni-directional
     */
    void addStation(CTAStation newStation, CTAStation afterStation, boolean bidirectional) {
        /*
        First check to see if the head has been assigned. If not, make the new
        station the head station and take no further action.
         */
        if (head == null) {
            head = newStation;
        } else {
            afterStation.setOutBound(newStation); // (afterStation) ---outBound---> (newStation)
            if (bidirectional) { // is station bidirectional?
                newStation.setInBound(afterStation); // (afterStation) <---inBound--- (newStation)
            }
        }
    } // method addStation


    /**
     * Method to print the stations along the route, by traversing the route.
     */
    void displayCTALine() {
        resetVisited(); // Start a fresh note pad to write down stations we pass
        CTAStation current = head; // Begin from the head
        boolean traverse = true; // Loop controller
        /*
        The while-loop below runs as long as variable:traverse is true. This
        variable becomes false and terminates the loop when we reach the head
        of the line from an inbound direction. Inside the loop, first we check
        is we have gone through the station before (maybe we crossed the
        station during the outbound trip and we are now back to it as we move
        inbound). Based on that we determine the next station to reach.
         */
        while (traverse) {
            System.out.printf("\n\nAt Station %s:", current.getName());
            if (visited.contains(current)) {
                // We've been to this station before.
                System.out.printf("\n\tThis station has been visited before.", current.getName());
                if (current.hasInBound()) {
                    System.out.printf("\n\t\tIt has an inbound pointer to station %s.", current.getInBound().getName());
                    current = current.getInBound();
                } else {
                    System.out.printf("\n\t\tIt has no inbound pointer. This must be end of line.\n");
                    traverse = false; // Setting this to false, ends the while loop
                }
            } else {
                // This is our first stop at this station; we're on an outbound run
                System.out.printf("\n\tThis Station has not been visited yet. Marking it as visited now.");
                visited.add(current);
                if (current.hasOutBound()) {
                    System.out.printf("\n\t\tThe outbound station is %s.", current.getOutBound().getName());
                    current = current.getOutBound();
                } else {
                    // No outbound pointer for this station
                    System.out.printf("\n\t\tNo outbound, but there is an inbound pointer to %s.", current.getInBound().getName());
                    current = current.getInBound();
                }
            }
        } // while
    } // method displayCTALine


    /**
     * Method to connect a unidirectional station to a bidirectional one.
     * The connection is always outbound from station1 to station2.
     *
     * @param station1 unidirectional station with outbound to bidirectional station
     * @param station2 bidirectional station that is outbound to unidirectional one
     * @return
     */
    public boolean connect(CTAStation station1, CTAStation station2){
        boolean success=false;
        // confirm that both stations exists, set success = true
        station1.setOutBound(station2);
        success=true;
        return success;
    } // method connect


    /**
     * Method to reset the Visited arraylist before each traversal. There is
     * no need to expose this method to class users, hence we declare it private.
     */
    private void resetVisited(){
        visited=new ArrayList<>();
    } // method resetVisited

} // class CTALine
