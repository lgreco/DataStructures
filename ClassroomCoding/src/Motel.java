/**
 *
 * A simple class that simulates arrivals and departures at a motel.
 *
 */
public class Motel {

    // Motel capacity
    static int CAPACITY = 4;

    // Motel registry with guest names
    static String[] guestBook = new String[CAPACITY];

    // Number of occupied rooms
    static int COUNT_OCCUPIED = 0;

    /**
     * Process an arrival at the motel.
     *
     * If all rooms are occupied, guest is not admitted. Otherwise, the guest is
     * added to first available room.
     *
     * @param guestName String with name of arriving guest
     */
    public static void arrival(String guestName) {
        // if there are rooms available:
        if (COUNT_OCCUPIED < CAPACITY) {
            // welcome guest
            System.out.println("Welcome " + guestName + "!");
            // Add guest to registry
            guestBook[COUNT_OCCUPIED] = guestName;
            // count of occupied rooms ++
            COUNT_OCCUPIED++;
        } else {
            System.out.println("Sorry, no room at the inn.");
        }
    }  // method arrival


    /**
     * Process a departure from the motel.
     *
     * The method allows a departure as long as there are occupied rooms.
     */
    public static void departure() {
        // if there are guest to depart
        if (COUNT_OCCUPIED > 0) {
            // goodbye guest
            System.out.println("Goodbye " + guestBook[COUNT_OCCUPIED - 1]);
            // Remove guest name from room
            guestBook[COUNT_OCCUPIED-1] = null;
            // count of occupied rooms --
            COUNT_OCCUPIED--;
        }
    }  // method departure


    /**
     * Displays the hotel registry.
     */
    public static void displayGuests() {
        for (int i = 0; i < guestBook.length; i++) {
            String guestName = guestBook[i] == null ? "No guest" : guestBook[i];
            System.out.printf("\nRoom[%d]: %s", i, guestName);
        }
    }  // method displayGuests


    /**
     * Demo code
     */
    public static void main(String[] args) {
        arrival("Liam");
        arrival("Montse");
        arrival("Zach");
        arrival("Andrew");
        departure();
        departure();
        arrival("Kevin");
        displayGuests();
    }  // method main

}  // class Motel