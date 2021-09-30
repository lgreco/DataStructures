/**
 * Class for CTA bus stops. The class inherits fields and methods from CTALocation and captures state
 * and behavior specific to bus stops.
 */
public class CTAStop extends CTALocation {

    /** Does the stop have a canopy/shelter? */
    private boolean hasShelter;

    /** What is the stop's SMS number for bus arrival info? */
    private String smsInfo;


    /**
     * Basic constructor.
     *
     * Passes a station name to the superclass constructor, leaves everything else (except hashTag) to mutators for
     * assignment.
     *
     * @param name String with the name of the station we are creating.
     */
    public CTAStop(String name) {
        super(name);
    } // constructor CTAStop
}
