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

    public CTAStation(String name) {
        super(name);
    }

}
