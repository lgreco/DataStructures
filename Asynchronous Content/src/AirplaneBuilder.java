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

    public Airplane fetch() {
        return new Airplane(tailNumber, manufacturer,
                wings, gear, tailWheel, engines,
                powerPlant, powerPerEngine, fuel, passengers);
    }
}
