import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Application for managing traffic tickets
 */
public class TrafficTicketManagement {


    /** Keyboard input for any method in this class */
    protected static Scanner keyboard = new Scanner(System.in);


    /** Hashmaps for principal data to track */
    protected static HashMap<String, Driver> drivers = new HashMap<>();
    protected static HashMap<String, Vehicle> vehicles = new HashMap<>();
    protected static HashMap<Integer, Violation> violations = new HashMap<>();
    protected static HashMap<Integer, TrafficTicket> trafficTickets = new HashMap<>();


    /**
     * TrafficTicketManagement
     */
    public static void main(String[] args) throws ParseException, IOException {
        // Load the data from storage to the hashmaps -- method is in FileOperations class
        FileOperations.loadData();
        // Run the menu -- method is in MenuOperations class
        MenuOperations.menu();
    }  // method main


    /**
     * Write a ticket. Method checks if driver is already in database. If so,
     * the existing data are used; otherwise method asks for more information
     * about the driver. Same for vehicle.
     *
     * @throws ParseException
     * @throws IOException
     */
    public static void writeTicket() throws ParseException, IOException {
        // obtain drivers license
        String licenseNumber = AuxiliaryOperations.citedDriver();
        // obtain plate #
        String licensePlate = AuxiliaryOperations.citedPlate();
        // Obtain violation code
        int violationCode = AuxiliaryOperations.citedViolation();
        //take address
        String address = AuxiliaryOperations.citedAddress();
        // take date
        Date ticketDate = AuxiliaryOperations.citedDate();
        // ticket number
        int ticketNumber = FileOperations.maxTicketNumber++;
        // Create ticket object
        TrafficTicket trafficTicket = new TrafficTicket(ticketNumber,
                licenseNumber, licensePlate,
                violationCode,
                address,
                ticketDate);
        // Write tickets file
        FileOperations.writeToFile(FileOperations.TRAFFIC_TICKETS, trafficTicket);
    }


    /** Inactive method - do not implement */
    public static void editTicket() {}  // method editTicket


    /** Inactive method - do not implement */
    public static void searchForTicket() {}  // method searchForTicket


    /**
     * Looks up a driver by license # and reports findings
     */
    public static void searchForDriver() {
        // Get driver info
        System.out.printf("\nEnter a driver's license number: ");
        String driverLicenseNumber = keyboard.next();
        Driver driver = drivers.get(driverLicenseNumber);
        // Driver may not have a record
        if (driver == null) {
            System.out.printf("\nThere is no record for driver license number %s\n",
                    driver.driverLicenseNumber);
            //      ^^^^^^
            //      Notice the bug! We just confirmed that driver is null
            //      and yet we are trying to pull an object field out of null!!!!
        } else {
            System.out.printf("\n%s belongs to %s %s",
                    driver.driverLicenseNumber, driver.firstName, driver.lastName);
            // Header for ticket report
            System.out.printf("\n\n\tTicket date and time\t\t\tLocation\t\t\t\tPlate\t\tViolation");
            // Counter for how many tickets this driver has
            int ticketCounter = 0;
            // Search every ticket in the database but look for the ones matching the entered driver license number
            for (Map.Entry<Integer,TrafficTicket> trafficTicketEntry: trafficTickets.entrySet()) {
                // Get the value V of the <K,V> pair stored in the trafficTickets hashmap;
                // Remember it's a trafficTicket object
                TrafficTicket trafficTicket = trafficTicketEntry.getValue();
                // Is this a ticket for the driver we are looking for?
                if (trafficTicket.driverLicenseNumber.equals(driver.driverLicenseNumber)) {
                    // This is a ticket for the driver we are looking at.
                    // Pull the strings we want to print in the report and pad them for left-flush.
                    String licensePlate = AuxiliaryOperations.pad(trafficTicket.licensePlate, FileOperations.licensePlateMaxLength);
                    String date = trafficTicket.date.toString();
                    String address = AuxiliaryOperations.pad(trafficTicket.address, FileOperations.addressMaxLength);
                    String violation = AuxiliaryOperations.pad(violations.get(trafficTicket.violationCode).violationDescription, FileOperations.violationDescriptionMaxLength);
                    ticketCounter++;
                    System.out.printf("\n\t%s\t%s\t\t%s\t%s", date, address, licensePlate, violation);
                }
            }
            if (ticketCounter == 0) {
                System.out.printf("\nNo tickets found.");
            }
            System.out.printf("\n");
        }
    }  // method searchForDriver


    /**
     * Searches for a license plate and returns ticket history for vehicle.
     */
    public static void searchForPlate() {
        // Get plate info
        System.out.printf("\nEnter a vehicle license plate: ");
        String licensePlate = keyboard.next();
        // Obtain vehicle record
        Vehicle vehicle = vehicles.get(licensePlate);
        if (vehicle == null) {
            System.out.printf("\nThere is no record for license plate %s",
                    licensePlate);
            //      ^^^^^^^^^^^^
            //      If you tried vehicle.licensePlate here, you would have discovered the
            //      bug planted in line 84 above!
        } else {
            System.out.printf("\n%s is a %d %s %s %s",
                    vehicle.licensePlate, vehicle.year, vehicle.color, vehicle.make, vehicle.model);
            // Header for ticket report
            System.out.printf("\n\n\tTicket date and time\t\t\tLocation\t\t\t\tDriver\t\tViolation");
            // Count how many tickets for this vehicle
            int ticketCounter = 0;
            // Search every ticket in the database but look for the ones that match the license plate
            for (Map.Entry<Integer,TrafficTicket> trafficTicketEntry: trafficTickets.entrySet()) {
                // Get the value V of the <K,V> pair stored in the trafficTickets hashmap;
                // Remember it's a trafficTicket object
                TrafficTicket trafficTicket = trafficTicketEntry.getValue();
                // Is this ticket matching the plate we are searching for?
                if (trafficTicket.licensePlate.equals(vehicle.licensePlate)) {
                    // This is a ticket for the vehicle we are looking for
                    // Pull the strings we want to print in the report and pad them for left-flushing
                    String date = trafficTicket.date.toString();
                    String address = AuxiliaryOperations.pad(trafficTicket.address, FileOperations.addressMaxLength);
                    String driver = AuxiliaryOperations.pad(trafficTicket.driverLicenseNumber, FileOperations.driverLicenseMaxLength);
                    //                                  ^^^               ^^^^^^^^^^^^^^^^^^^
                    // Very important to demonstrate understanding of method pad and its needs.
                    String violation = AuxiliaryOperations.pad(violations.get(trafficTicket.violationCode).violationDescription, FileOperations.violationDescriptionMaxLength);
                    ticketCounter++;
                    System.out.printf("\n\t%s\t%s\t\t%s\t%s",
                            date, address, driver, violation);
                    //                     ^^^^^^
                    //                     very important to print driver information here
                    //                     instead of copying earlier code that prints
                    //                     plate numbers.
                }
            }
            if (ticketCounter == 0) {
                System.out.printf("\nNo tickets found.");
            }
            System.out.printf("\n");
        }
    }  // method searchForPlate


    /** Inactive method - do not implement */
    public static void searchForViolation() {}  // method searchForViolation


    /**
     * Finds the most frequently cited violation code.
     *
     * @return int with violation code most frequently cited.
     *
     */
    public int mostFrequentViolation() {
        int mostFrequentCode = -1;
        /*
         To count the occurrences of each violation code, we need an array with
         as many places as there are violations. We know that violations are
         numbered sequentially beginning with 1, so we map violation code 1 to
         occurrence counter [0], code 1 to occurrence [2], etc
         */
        int[] occurrences = new int[violations.size()];
        // Iterate over every ticket.
        for (Map.Entry<Integer,TrafficTicket> trafficTicketEntry: trafficTickets.entrySet()) {
            // Pull violation code from entry
            int violationCode = trafficTicketEntry.getValue().violationCode;
            // Update the corresponding occurrence counter
            occurrences[violationCode-1]++;
        }
        /*
        At this point, array occurences has the counts for each violaton code.
        Let's find the array element with the highest value. This is a standard
        loop seeking the max value in an array, and capturing the index position
        where that max value is found. The index position is that assigned as i+1
        to the return variable, since there is a correspondence between the index
        and the violation code: violation code = i+1
         */
        int maxCount = 0;
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > maxCount) {
                maxCount = occurrences[i];
                mostFrequentCode = i+1;
            }
        }
        return mostFrequentCode;
    }  // method mostFrequentViolation

}  // class TrafficTicketManagement