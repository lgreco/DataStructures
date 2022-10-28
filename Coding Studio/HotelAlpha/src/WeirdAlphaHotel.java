
public class WeirdAlphaHotel {

    /**
     * The number of rooms in the hotel. This is also the basis for mapping
     * (hashing) a guest to a room. The field has also a default value.
     */
    private int numberOfRooms;
    private static final int DEFAULT_NUMBER_OF_ROOMS = 128;

    /**
     * The number of rooms away from the designated room that we are willing to
     * consider placing a guest if their designated room is not available.
     * The field has also a default value.
     */
    private int probingLength;
    private static final int DEFAULT_PROBING_LENGTH = 3;

    /** The array of hotel rooms */
    private String[] hotel;

    /** The number of rooms currently in use */
    private int usage;

    /**
     * Basic constructor
     * @param numberOfRooms int number of rooms in the hotel
     * @param probingLength int number of rooms to the right of the designated
     *                      room to consider, if designated room is occupied by
     *                      another guest.
     */
    public WeirdAlphaHotel(int numberOfRooms, int probingLength) {
        this.numberOfRooms = numberOfRooms;
        this.probingLength = probingLength;
        this.usage = 0;
    }  // constructor WeirdAlphaHotel


    /**
     * Default constructor
     */
    public WeirdAlphaHotel() {
        this(DEFAULT_NUMBER_OF_ROOMS, DEFAULT_PROBING_LENGTH);
    }  // constructor WeirdAlphaHotel


    /**
     * Maps a string to an integer number, based on the string's initial letter's
     * ASCII value, modulo the number of rooms in the hotel.
     *
     * @param string String to map
     * @return int with the hash value described above
     */
    private int hash(String string) {
        return ((int) string.toUpperCase().charAt(0)) % this.numberOfRooms;
    }  // method hash


    /**
     * An easy way to tell if there are vacant rooms in hte hotel.
     * @return
     */
    private boolean hasVacancy() {
        return this.usage < this.hotel.length;
    }  // method hasVacancy


    /**
     * An easy way to tell if a hotel room is available
     * @param roomNumber int room number to check
     * @return true if room not assigned to a guest presently, false otherwise.
     */
    private boolean isAvailable(int roomNumber) {
        return this.hotel[roomNumber] == null;
    }  // method isAvailable


    /**
     * Adds a guest to the hotel, if there are empty rooms and if the designated
     * room or a nearby room is available.
     *
     * @param guestName String guest to accommodate
     * @return int with room number assigned to guest; or -1 if guest is rejected.
     */
    public int add(String guestName)  {
        // Assume that we cannot accommodate guest
        int assignedRoom = -1;
        // Check if hotel has available rooms
        if (this.hasVacancy()) {
            // Determine which room this guest should go to
            int designatedRoom = this.hash(guestName);
            // Check if that room is available
            if (this.isAvailable(designatedRoom)) {
                // Place guest here and update assignedRoom and usage
                assignedRoom = designatedRoom;
                this.hotel[assignedRoom] = guestName;
                this.usage++;
            } else {
                // Designated room is not available, try nearby rooms, using %
                // to wrap around if we are near the last room in the array.
                if (this.isAvailable((designatedRoom+1)%this.numberOfRooms)) {
                    // Place guest here and update assignedRoom and usage
                    assignedRoom = (designatedRoom+1)%this.numberOfRooms;
                    this.hotel[assignedRoom] = guestName;
                    this.usage++;
                } else if (this.isAvailable((designatedRoom+1)%this.numberOfRooms)) {
                    // Place guest here and update assignedRoom and usage
                    assignedRoom = (designatedRoom+2)%this.numberOfRooms;
                    this.hotel[assignedRoom] = guestName;
                    this.usage++;
                }
            }
        }
        return assignedRoom;
    }  // method add


    /**
     * Removes a guest from a room and makes the room available again.
     *
     * @param room int number of room to vacate
     * @return name of the departing guest
     */
    public String remove(int room) {
        String departingGuest = null;
        // TBD
        return departingGuest;
    }  // method remove


    /**
     * Tells if a guest is at the hotel.
     *
     * @param guestNane String with guest name to look up
     * @return true if guest is in a room; false otherwise.
     */
    public boolean isGuestHere(String guestNane) {
        boolean guestHere = false;
        // TBD
        return guestHere;
    }  // method isGuestHere

}
