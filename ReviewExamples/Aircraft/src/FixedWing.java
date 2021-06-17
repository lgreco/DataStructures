/**
 * A simple class for Fixed Wing aircraft that can be used as a superclass
 * for piston and turbine-powered airplanes.
 */
public class FixedWing {

    private int numberOfEngines; // 1, 2, 3, 4
    private boolean isGearRetractable; // true, false
    private String tailNumber; // N-registration, e.g., N4335K
    private int airSpeed; // in knots
    private int operationalCeiling; // in feet
    private String manufacturer; // e.g., Cessna
    private String modelCode; // e.g., C172,    P28A,   SF50, etc
    private String modelName; // e.g., Skyhawk, Archer, Vision Jet
    private int yearManufactured;

    /**
     * Basic constructor, with the minimum necessary information we need to
     * create a FixedWing object.
     *
     * @param numberOfEngines how many engines the aircraft has
     * @param tailNumber what is its registration number
     * @param modelName what is its model (common) name
     */
    public FixedWing(int numberOfEngines, String tailNumber, String modelName) {
        this.numberOfEngines = numberOfEngines;
        this.tailNumber = tailNumber;
        this.modelName = modelName;
    } // constructor FixedWing

    /*
    AUTOMAGICALLY GENERATED CODE: MUTATORS (SETTERS)
    Methods to change the value of variables in existing objects
    */

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public void setGearRetractable(boolean gearRetractable) {
        isGearRetractable = gearRetractable;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public void setAirSpeed(int airSpeed) {
        this.airSpeed = airSpeed;
    }

    public void setOperationalCeiling(int operationalCeiling) {
        this.operationalCeiling = operationalCeiling;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setYearManufactured(int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }


    /*
    AUTOMAGICALLY GENERATED CODE: ACCESSORS (GETTERS)
    Methods to obtain the value of variables in existing objects
    */

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public boolean isGearRetractable() {
        return isGearRetractable;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public int getAirSpeed() {
        return airSpeed;
    }

    public int getOperationalCeiling() {
        return operationalCeiling;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelCode() {
        return modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }
}
