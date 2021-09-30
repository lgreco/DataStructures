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
    } // constructor CTAStation

}
