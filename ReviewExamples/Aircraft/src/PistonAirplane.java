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
     */
    @Override
    public String toString() {
        /*
        The original code below that used boolean isGearRetractable() to determine
        the value of local String gear and use in in the return item, is obsolete
        because we can call the newly created FixedWing.getGear() method that returns
        a String with the desired content.

        String gear = "fixed";
        if (isGearRetractable()) { gear = "retractable"; }
        */
        return String.format("%S is a piston-powered airplane with %d engine(s) and %s gear.\n" +
                        "This %s (%s) was manufactured by %s in %d.",
                getTailNumber(), getNumberOfEngines(), getGear(), // <-- newly created FixedWing.getGear()
                getModelName(), getModelCode(), getManufacturer(), getYearManufactured());

    } // method toString
}
