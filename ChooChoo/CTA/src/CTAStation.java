/**
 * Class that models stations with inbound and outbound trains like those
 * at most CTA El stops.
 */
public class CTAStation {

    /** The name of the CTA Station */
    private String name;
    /** In a specific direction of travel, the following station */
    private CTAStation outBound;
    /** The prior station */
    private CTAStation inBound;
    /** A pointer to the prior station */
    private boolean traversed;

    /**
     * Basic constructor. Sets up a station object with a given name. The
     * outbound and inbound pointers are affirmed null.
     *
     * @param name The name of the station.
     */
    public CTAStation(String name) {
        this.name = name;
        outBound = inBound = null;
    } // constructor CTAStation

    /**
     * A method to tell if a downStream pointer is null or not
     *
     * @return false if downStream is null
     */
    public boolean hasOutBound() {
        return outBound != null;
    } // method hasOutBound

    /**
     * A method to tell if an upStream pointer is null or not
     * @return false if upStream is null
     */
    public boolean hasInBound() {
        return inBound != null;
    } // method hasInBound

    // AUTOMAGICALLY GENERATED GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CTAStation getOutBound() {
        return outBound;
    }

    public void setOutBound(CTAStation outBound) {
        this.outBound = outBound;
    }

    public CTAStation getInBound() {
        return inBound;
    }

    public void setInBound(CTAStation inBound) {
        this.inBound = inBound;
    }
} // class CTAStation
