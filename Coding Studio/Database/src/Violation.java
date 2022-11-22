
public class Violation {

    /** This will be the object's key */
    protected int violationCode;
    protected String violationDescription;
    protected double violationFine;

    /** Full constructor */
    public Violation(int violationCode, String violationDescription, double violationFine) {
        this.violationCode = violationCode;
        this.violationDescription = violationDescription;
        this.violationFine = violationFine;
    }

    /**
     * String representation of the object, suitable for naive serialization.
     * @return CSV-friendly string with all object values separated by commas.
     */
    public String toString() {
        return String.format("%d,%s,%.2f\n",
                this.violationCode,
                this.violationDescription,
                this.violationFine);
    }  // method toString
}
