/**
 * Interface based on the structure (fields) of class Airplane.
 * The interface specifies one mutator for each field.
 */
public interface Builder {

    void setTailNumber(String tailNumber);
    void setManufacturer(String manufacturer);
    void setWings(Wings wings);
    void setLanding(Landing gear);
    void setTailWheel(boolean tailWheel);
    void setEngines(int engines);
    void setPowerPlant(PowerPlant powerPlant);
    void setPowerPerEngine(int powerPerEngine);
    void setFuel(Fuel fuel);
    void setPassengers(int passengers);

}
