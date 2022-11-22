import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;

public class MenuOperations {
    /** Menu items. Use their position in the array as menu prompt value */
    protected static String[] menuItems = {
            "Exit",
            "Write a ticket",
            "Edit a ticket",
            "Search for a ticket",
            "Search for a driver",
            "Search for a license plate",
            "Search for a violation",
            "Show all violations"
    };

    /**
     * Prints all violations
     */
    public static void showAllViolations() {
        for (Map.Entry<Integer, Violation> violationEntry: TrafficTicketManagement.violations.entrySet()) {
            Integer violationCode = violationEntry.getKey();
            Violation violation = violationEntry.getValue();
            String violationDescription = violation.violationDescription;
            double fine = violation.violationFine;
            System.out.printf("\n\t%5d - %s (%.2f)",violationCode, violationDescription,fine);
        }
    }  // method showAllViolations

    /**
     * Display the opening banner of the menu
     */
    public static void openingBanner() {
        // Print the menu. Use array index values as menu keys.
        System.out.println("\n\nTraffic Ticket Management System");
        System.out.printf("Current database status: %3d tickets | %3d drivers | %3d vehicles | %3d violations\n",
                TrafficTicketManagement.trafficTickets.size(), TrafficTicketManagement.drivers.size(), TrafficTicketManagement.vehicles.size(), TrafficTicketManagement.violations.size());
    }  // method openingBanner

    /**
     * Prints all menu options
     */
    public static void listMenu() {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("\n\t\t%d. %s", i, menuItems[i]);
        }
    }  // method listMenu

    /**
     * Obtains a valid menu input
     * @return int with valid menu input
     */
    public static int menuChoice() {
        int choice = -1;
        while (choice < 0 || choice >= menuItems.length) {
            System.out.printf("\nEnter a menu items (0-%d): ", menuItems.length);
            choice = TrafficTicketManagement.keyboard.nextInt();
        }
        return choice;
    }  // method menuChoice

    /**
     * Prints the closing banner when the application exits
     */
    public static void closingBanner(){
        System.out.printf("\nThank you for using the TwoSevenOne traffic citation system.\n");
    }  // method closingBanner

    /**
     * The applications main menu. It solicits input from the user and calls the
     * appropriate task.
     */
    public static void menu() throws ParseException, IOException {
        // Flag to keep the menu running until user chooses to exit.
        boolean exit = false;
        // Scanner for keyboard input
        Scanner sc = new Scanner(System.in);
        // Repeat menu loop until user selects exit (0)
        while (!exit) {
            // Display opening banner
            openingBanner();
            // List menu
            listMenu();
            // Solicit a selection:
            int choice = menuChoice();
            exit = choice == 0;
            if (!exit) {
                if (choice == 1)
                        TrafficTicketManagement.writeTicket();
                if (choice == 2)
                        TrafficTicketManagement.editTicket();
                if (choice == 3)
                        TrafficTicketManagement.searchForTicket();
                if (choice == 4)
                        TrafficTicketManagement.searchForDriver();
                if (choice == 5)
                        TrafficTicketManagement.searchForPlate();
                if (choice == 6)
                        TrafficTicketManagement.searchForViolation();
                if (choice == 7)
                        showAllViolations();
            }
        }
        closingBanner();
    }  // method menu
}
