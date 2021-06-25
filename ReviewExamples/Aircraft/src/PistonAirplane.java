public class PistonAirplane extends FixedWing {

    /**
     * Basic constructor defers to same in superclass.
     */
    public PistonAirplane(int numberOfEngines, String tailNumber, String modelName) {
        super(numberOfEngines, tailNumber, modelName);
    } // constructor PistonAirplane

    /**
     * We limit the value of operationalCeling to 20000 for
     * piston powered aircraft.
     *
     * @param operationalCeiling
     */
    @Override
    public void setOperationalCeiling(int operationalCeiling) {
        if (operationalCeiling > 20000) {
            operationalCeiling = 20000;
        }
        super.setOperationalCeiling(operationalCeiling);
    } // method setOperationalCeiling

    /**
     * @return descriptive string for this aircraft
     * UPDATE FOR HOMEWORK 6/24/21: THE CODE BELOW HAS BEEN SIMPLIFIED BY REMOVING THE
     * LINES THAT DETERMINE THE GEAR TYPE. INSTEAD WE USE THE GETGEAR() METHOD TO INCLUDE
     * THE ACTUAL GEAR STRING DIRECTLY INTO THE STRING.FORMAT() CALL.
     * THE OLD CODE IS STILL BELOW, FOR REFERENCE, NEUTRALIZED AS A COMMENT BLOCK.
     */
    @Override
    public String toString() {
        return String.format("%S is a piston-powered airplane with %d engine(s) and %s gear.\n" +
                        "This %s (%s) was manufactured by %s in %d.",
                getTailNumber(), getNumberOfEngines(), getGear(), // <--- GETGEAR() IS A STRING
                getModelName(), getModelCode(), getManufacturer(), getYearManufactured());

        /*

        String gear = new String("fixed");
        if (isGearRetractable()) { gear = "retractable"; }
        return String.format("%S is a piston-powered airplane with %d engine(s) and %s gear.\n" +
                "This %s (%s) was manufactured by %s in %d.",
                getTailNumber(), getNumberOfEngines(), gear,
                getModelName(), getModelCode(), getManufacturer(), getYearManufactured());

         */
    } // method toString
}
