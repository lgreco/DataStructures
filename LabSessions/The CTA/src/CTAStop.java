/**
 * Class for CTA bus stops. The class inherits fields and methods from CTALocation and captures state
 * and behavior specific to bus stops.
 */
public class CTAStop extends CTALocation {

    /** Does the stop have a canopy/shelter? */
    private boolean hasShelter;

    /** What is the stop's SMS number for bus arrival info? */
    private String smsInfo;

    public CTAStop(String name) {
        super(name);
    }
}
