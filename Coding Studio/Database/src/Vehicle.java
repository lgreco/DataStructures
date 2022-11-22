public class Vehicle {

    /** This will be the object's key */
    protected String licensePlate;
    protected String make; //  honda HONDA  hOnDa
    protected String model;
    protected int year;
    protected String color;

    /** Full constructor */
    public Vehicle(String licensePlate, String make, String model, int year, String color) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    /**
     * String representation of the object, suitable for naive serialization.
     * @return CSV-friendly string with all object values separated by commas.
     */
    public String toString() {
        return String.format("%s,%s,%s,%d,%s\n",
                this.licensePlate,
                this.make,
                this.model,
                this.year,
                this.color);
    }  // method toString
}
