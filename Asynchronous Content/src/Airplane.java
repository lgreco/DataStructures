public class Airplane {

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

    // full constructor only
    public Airplane(String tailNumber, String manufacturer,
                    Wings wings, Landing gear, boolean tailWheel,
                    int engines, PowerPlant powerPlant, int powerPerEngine,
                    Fuel fuel, int passengers)
    {
        this.tailNumber = tailNumber;
        this.manufacturer = manufacturer;
        this.wings = wings;
        this.gear = gear;
        this.tailWheel = tailWheel;
        this.engines = engines;
        this.powerPlant = powerPlant;
        this.powerPerEngine = powerPerEngine;
        this.fuel = fuel;
        this.passengers = passengers;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
