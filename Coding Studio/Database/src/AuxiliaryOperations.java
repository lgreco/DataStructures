import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuxiliaryOperations {
    /**
     * Keyboard input for a driver to be cited. If the driver is not found in
     * the drivers hashmap, a new driver is added to the hashmap and to the
     * drivers file.
     *
     * @return String with cited driver license number
     *
     * @throws IOException
     */
    public static String citedDriver() throws IOException {
        // obtain drivers license
        System.out.printf("\nEnter drivers license number: ");
        String licenseNumber = TrafficTicketManagement.keyboard.next();
        // look it up in drivers hashmap
        Driver driver = TrafficTicketManagement.drivers.get(licenseNumber);
        if (driver == null) {
            // Driver not in hashmap; take driver information, add new driver to drivers hashmap and drivers.txt.
            System.out.printf("\nEnter driver's first name: ");
            String firstName = TrafficTicketManagement.keyboard.next();
            System.out.printf("\nEnter driver's last name: ");
            String lastName = TrafficTicketManagement.keyboard.next();
            // Create new driver object
            driver = new Driver(licenseNumber, firstName, lastName);
            // Add driver to the database
            TrafficTicketManagement.drivers.put(licenseNumber, driver);
            // Write drivers file
            FileOperations.writeToFile(FileOperations.DRIVERS, driver);
        }
        return licenseNumber;
    }  // method citedDriver

    /**
     * Keyboard input for the car to be cited. If the vehicle is not found in
     * the vehicles hashmap, a new vehicle is added to the hashmap and to the
     * vehicles file.
     *
     * @return String with cited car's license plate.
     *
     * @throws IOException
     */
    public static String citedPlate() throws IOException {
        System.out.printf("\nEnter license plate (no spaces): ");
        String licensePlate = TrafficTicketManagement.keyboard.next();
        // look it up in vehicles hashmap
        Vehicle vehicle = TrafficTicketManagement.vehicles.get(licensePlate);
        if (vehicle == null) {
            // plate not in hashmap, take vehicle info, add new vehicle to vehicles hashmap and vehicles.txt.
            System.out.printf("\nEnter vehicle's make: ");
            String make = TrafficTicketManagement.keyboard.next();
            System.out.printf("\nEnter vehicle's model: ");
            String model = TrafficTicketManagement.keyboard.next();
            System.out.printf("\nEnter vehicle's year: ");
            int year = TrafficTicketManagement.keyboard.nextInt();
            System.out.printf("\nEnter vehicle's color: ");
            String color = TrafficTicketManagement.keyboard.next();
            // Create new vehicle object
            vehicle = new Vehicle(licensePlate, make, model, year, color);
            // Write vehicles file
            FileOperations.writeToFile(FileOperations.VEHICLES, vehicle);
        }
        return licensePlate;
    }  // method citedPlate

    /**
     * Keyboard input for violation to be cited.
     *
     * @return int with violation code.
     */
    public static int citedViolation() {
        // select violation
        System.out.printf("\nSelect a violation:\n");
        MenuOperations.showAllViolations();
        System.out.printf("\nEnter violation code: ");
        int infraction = TrafficTicketManagement.keyboard.nextInt();
        // Clear the scanner to prepare for address input
        TrafficTicketManagement.keyboard.nextLine();
        return  infraction;
    }  // method citedViolation

    /**
     * Keyboard input for location of the citation
     *
     * @return String with address where violation occured.
     */
    public static String citedAddress() {
        System.out.printf("\nEnter location address: ");
        String address = TrafficTicketManagement.keyboard.nextLine();
        // Update addressMaxLength
        if (address.length() > FileOperations.addressMaxLength) {
            FileOperations.addressMaxLength = address.length();
        }
        return address;
    }  // method citedAddress

    /**
     * Keyboard input for date and time of violation
     *
     * @return Date object
     *
     * @throws ParseException
     */
    public static Date citedDate() throws ParseException {
        System.out.printf("\n\nEnter date and time of violation YYYY-MM-DD hhmm: ");
        String date = TrafficTicketManagement.keyboard.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hhmm");
        Date ticketDate = df.parse(date);
        return ticketDate;
    }  // method citedDate

    /**
     * Pads a string with some space at the end to produce a left-flushed string.
     *
     *     |--- string ---|----- padding -----|
     *     |-------- padded string -----------|
     *
     *     padded string length = max length for that string collection, + 1
     *                                                -----------------
     *     padding = padded string length             This collection can be the
     *               - string.length                  strings with addresses or
     *                                                the strings with the
     *                                                violation descriptions.
     *                                                When we load these strings
     *                                                from storage to memory we
     *                                                keep track of the longest
     *                                                address, longest violation
     *                                                description, etc. These
     *                                                values are kept as
     *                                                variables maxSomething
     *                                                variables in FileOperations.java
     *
     * @param string String to pad
     * @param padding int with length of padded string
     * @return String with total length padding that contains the input string
     */
    public static String pad(String string, int padding) {
        return String.format("%s%s",
                string,
                " ".repeat(padding-string.length()+1));
    }  // method pad
}
