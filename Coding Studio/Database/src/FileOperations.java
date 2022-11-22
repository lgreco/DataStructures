import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class FileOperations {

    /** File names */
    protected static final String DRIVERS = "drivers.txt";
    protected static final String VEHICLES = "vehicles.txt";
    protected static final String VIOLATIONS = "violations.txt";
    protected static final String TRAFFIC_TICKETS = "trafficTickets.txt";


    /** The most recent ticket's serial number so that we can create a serial number for the next ticket */
    protected static int maxTicketNumber;


    /** Max string lengths for certain fields, for formatting purposes */
    protected static int violationDescriptionMaxLength = 0;
    protected static int addressMaxLength = 0;
    protected static int licensePlateMaxLength = 0;


    /**
     * Scanner to data file to read
     * @param filename String with file to read
     * @return scanner stream from file, or null if connection cannot be established
     */
    public static Scanner fileScanner(String filename) {
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            sc = null;
        }
        return sc;
    }  // method fileScanner


    /**
     * Builds the hashmap for drivers based on the contents of the corresponding file.
     * @return HashMap with drivers
     */
    public static HashMap<String, Driver> getDrivers() {
        HashMap<String, Driver> drivers = new HashMap<>();
        Scanner sc = fileScanner(DRIVERS);
        // Make sure scanner is good
        if (sc != null) {
            while (sc.hasNextLine()) {
                String[] record = sc.nextLine().split(",");
                // Show how the record[] corresponds to Driver fields
                String driverLicenseNumber = record[0];
                String firstName = record[1];
                String lastName = record[2];
                // Create a new driver object
                Driver newDriver = new Driver(driverLicenseNumber, firstName, lastName);
                // Add this driver to the drivers hashmap using the driverLicenseNumber as key
                drivers.put(driverLicenseNumber,newDriver);
            }
        }
        return drivers;
    }  // method getDrivers


    /**
     * Builds the hashmap for vehicles based on the contents of the corresponding file.
     * @return HashMap with vehicles
     */
    public static HashMap<String, Vehicle> getVehicles() {
        HashMap<String, Vehicle> vehicles = new HashMap<>();
        Scanner sc = fileScanner(VEHICLES);
        // Make sure scanner is good
        if (sc != null) {
            while (sc.hasNextLine()) {
                String[] record = sc.nextLine().split(",");
                // Show how the record[] corresponds to Vehicle fields
                String licensePlate = record[0];
                String make = record[1];
                String model = record[2];
                int year = Integer.valueOf(record[3]);
                String color = record[4];
                // Adjust variable with longest license place (for formatting purposes)
                if (licensePlate.length() > licensePlateMaxLength) {
                    licensePlateMaxLength = licensePlate.length();
                }
                // Create a new vehicle object
                Vehicle newVehicle = new Vehicle(licensePlate, make, model, year, color);
                // Add this vehicle to the vehicles hashmap with licensePlate as the key
                vehicles.put(licensePlate, newVehicle);
            }
        }
        return vehicles;
    }  // method getVehicles


    /**
     * Builds the hashmap for violations based on the contents of the corresponding file.
     * @return HashMap with violations
     */
    public static HashMap<Integer, Violation> getViolations() {
        HashMap<Integer, Violation> violations = new HashMap<>();
        Scanner sc = fileScanner(VIOLATIONS);
        // Make sure scanner is good
        if (sc != null) {
            while (sc.hasNext()) {
                String[] record = sc.nextLine().split(",");
                // Show how the record[] corresponds to Violation fields
                int violationCode = Integer.valueOf(record[0]);
                String violationDescription = record[1];
                double fine = Double.valueOf(record[2]);
                // Adjust variable with longest violation description place (for formatting purposes)
                if (violationDescription.length() > violationDescriptionMaxLength) {
                    violationDescriptionMaxLength = violationDescription.length();
                }
                // Create new Violation object
                Violation newViolation = new Violation(violationCode, violationDescription, fine);
                // Add this new violation to violations hashmap with violationCode as key
                violations.put(Integer.valueOf(record[0]), newViolation);
            }
        }
        return violations;
    }  //method getViolations


    /**
     * Builds the hashmap for traffic tickets based on the contents of the corresponding file.
     * The method also finds the more recent ticker number so that we can produce the serial
     * number for the next ticket.
     * @return HashMap with traffic tickets
     */
    public static HashMap<Integer, TrafficTicket> getTrafficTickets() throws ParseException {
        maxTicketNumber = 0;
        HashMap<Integer, TrafficTicket> trafficTickers = new HashMap<>();
        Scanner sc = fileScanner(TRAFFIC_TICKETS);
        if (sc != null) {
            // Make sure scanner is good
            while (sc.hasNextLine()) {
                String[] record = sc.nextLine().split(",");
                // Show how the record[] corresponds to trafficTicket fields
                int ticketNumber = Integer.valueOf(record[0]);
                // Second field is the driver's license number
                String driverLicenseNumber = record[1];
                // Third field is the car plate
                String licensePlace = record[2];
                // Fourth field is the code corresponding to the violation
                int violation = Integer.valueOf(record[3]);
                // Firth field is the address of the violation
                String address = record[4];
                // Adjust variable with longest violation description place (for formatting purposes)
                if (address.length() > addressMaxLength) {
                    addressMaxLength = address.length();
                }
                // Sixth field is the date and time
                Date date = new SimpleDateFormat("yyy-MM-dd hhmm").parse(record[5]);
                // create a new ticket object with these data
                TrafficTicket trafficTicket = new TrafficTicket(
                        ticketNumber,
                        driverLicenseNumber,
                        licensePlace,
                        violation,
                        address,
                        date
                );
                // Add this object to the hashmap using ticketNumber as key
                trafficTickers.put(ticketNumber, trafficTicket);
                // Update serial ticker number
                if (Integer.valueOf(record[0]) > maxTicketNumber) {
                    maxTicketNumber = Integer.valueOf(record[0]);
                }
            }
        }
        return trafficTickers;
    }  // method getTrafficTickets


    /**
     * Appends an object's string representation to a file
     *
     * @param fileName Filename to append
     * @param o object to add to file. Objects passed to this method include
     *          Driver, Vehicle, Violation, and TrafficTicket. They all have
     *          a toString() method that returns a CSV-friendly string with a
     *          \n at its end.
     *
     * @throws IOException
     */
    public static void writeToFile(String fileName, Object o) throws IOException {
        // FileWriter object with append=true argument
        FileWriter fileWriter = new FileWriter(fileName, true);
        fileWriter.append(o.toString());
        // Be nice.
        fileWriter.close();
    }  // method writeToFile


    /**
     * Loads data from files to the hashmaps
     * @throws ParseException because of date parsing used in some methods.
     */
    public static void loadData() throws ParseException {
        TrafficTicketManagement.drivers = getDrivers();
        TrafficTicketManagement.vehicles = getVehicles();
        TrafficTicketManagement.violations = getViolations();
        TrafficTicketManagement.trafficTickets = getTrafficTickets();
    }  // method loadData
}  // class FileOperations
