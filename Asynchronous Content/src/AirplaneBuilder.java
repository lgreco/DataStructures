/**
 * By implementing the Buider interface, class AirplaneBuilder allows
 * users to control each field of class Airplane individually. The
 * class declares exactly the same fields Airplane. Upon declaration,
 * these fields assume their default values (e.g., null for objects,
 * 0 for numbers, false for booleans). The class's mutators
 * assign values to as many fields as desired.
 *
 * This class also includes a method that puts all the field values
 * (assigned and default) into a call to Airplane's full constructor.
 */
public class AirplaneBuilder implements Builder {

    private String tailNumber;
    private String manufacturer;
    private Wings wings;
    private Landing gear;
    private boolean tailWheel;
    private int engines;
    private PowerPlant powerPlant;
    private int powerPerEngine;
    private Fuel fuel;
    private int passengers;

    @Override
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setWings(Wings wings) {
        this.wings = wings;
    }

    @Override
    public void setLanding(Landing gear) {
        this.gear = gear;
    }

    @Override
    public void setTailWheel(boolean tailWheel) {
        this.tailWheel = tailWheel;
    }

    @Override
    public void setEngines(int engines) {
        this.engines = engines;
    }

    @Override
    public void setPowerPlant(PowerPlant powerPlant) {
        this.powerPlant = powerPlant;
    }

    @Override
    public void setPowerPerEngine(int powerPerEngine) {
        this.powerPerEngine = powerPerEngine;
    }

    @Override
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
     * Call to Airplane's full constructor. Some of the parameters
     * below maintain their default values (nulls, 0s, falses) and
     * some have been assigned.
     * @return call to Airplane's full constructor
     */
    public Airplane fetch() {
        return new Airplane(tailNumber, manufacturer,
                wings, gear, tailWheel, engines,
                powerPlant, powerPerEngine, fuel, passengers);
    }
}
