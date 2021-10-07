/**
 * Class for CTA train stations. The class inherits fields and methods from CTALocation and captures state
 * and behavior specific to train stations.
 */
public class CTAStation extends CTALocation {

    /** Is there an elevator at the station? */
    private boolean hasElevator;

    /** Is there an escalator at the station? */
    private boolean hasEscalator;

    /** Is the station accessible for people with disabilities? */
    private boolean isAccessible;

    /** In the direction of travel, what is the next station? */
    private CTAStation next;


    /**
     * Basic constructor.
     *
     * Passes a station name to the superclass constructor, leaves everything else (except hashTag) to mutators for
     * assignment.
     *
     * @param name String with the name of the station we are creating.
     */
    public CTAStation(String name) {
        super(name); // Hello super() call
        this.next = null;
    } // constructor CTAStation


    /**
     * Constructor with name and geographic coordinates.
     *
     * This constructor is used when we are scanning data from the Chicago Data Portal
     *
     * @param stationName String with name of station
     * @param latitude double latitude of station
     * @param longitude double longitude of station
     */
    public CTAStation(String stationName, double latitude, double longitude) {
        super(stationName, latitude, longitude);
    } // constructor CTAStation


    /* Automatically generated code */

    public CTAStation getNext() {
        return next;
    }

    public void setNext(CTAStation next) {
        this.next = next;
    }
}
