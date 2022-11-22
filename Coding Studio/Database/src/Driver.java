public class Driver {

    /** This will be the object's key */
    protected String driverLicenseNumber;
    protected String firstName;
    protected String lastName;

    /** Full constructor */
    public Driver(String driverLicenseNumber, String firstName, String lastName) {
        this.driverLicenseNumber = driverLicenseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * String representation of the object, suitable for naive serialization.
     * @return CSV-friendly string with all object values separated by commas.
     */
    public String toString() {
        return String.format("%s,%s,%s\n",
                this.driverLicenseNumber,
                this.firstName,
                this.lastName);
    }  // method toString
}  // clas Driver
