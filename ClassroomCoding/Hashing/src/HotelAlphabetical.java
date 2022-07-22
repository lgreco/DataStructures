/**
 * A class to simulate Hotel Alphabetical. This hotel has 26 rooms, labeled A through Z.
 * Arriving guests are assigned to a room whose label matches the first letter of their
 * last name, e.g, Albus Dumbledore will be assigned to room D. Room assignment are subject
 * to collisions, e.g. two guest with the same first letter of their last name. Collisions
 * are resolved by assigning the second guest to the room next to their letter-matched room,
 * if that room is available. If the adjacent room is not available, the guest is rejected.
 */
public class HotelAlphabetical {

    /** Class constants to avoid using magic values later */
    private static final int LETTERS = 26;
    private static final char LAST_LETTER = 'Z';

    /** Underlying array for this class */
    private String[] hotel = new String[LETTERS];


    /**
     * Map a guest's last name to a room number
     *
     * @param lastName String with guest's last name.
     * @return int index of room position in underlying array
     */
    public int room(String lastName) {
        /*
        Rooms are labeled in upper case letters, so let's make sure last name in UC as well
        before extracting its first letter.
         */
        return (this.hotel.length-1) - (int) (LAST_LETTER - lastName.toUpperCase().charAt(0));
    }  // method room


    /**
     * Tells if a room is occupied or not. An unoccupied room corresponds to an array
     * position whose value is null.
     *
     * @param room int with array position corresponding to a room
     * @return true if room occupied, false otherwise.
     */
    public boolean isOccupied(int room) {
        return this.hotel[room] != null;
    }  // method isOccupied


    /**
     * Assigns a guest to an available room. If room is not available but adjacent room is,
     * guest is assigned to adjacent room.
     *
     * @param lastName guest to accommodate
     */
    public void assignRoom(String lastName) {
        // find the room number for this guest
        int tentativeRoom = this.room(lastName);
        // if room available, assign guest to room
        if (!assigned(tentativeRoom, lastName))               /* simplify by  */
            // If room unavailable, try next room             /* reducing     */
            assigned((tentativeRoom+1) % LETTERS, lastName);  /* redundancies */
    }  // method assignRoom


    /**
     * Helper method to assign guest to room, if room is available. The method
     * returns an indication if the assignment was successful or not.
     *
     * @param room int room number
     * @param string String guest name
     * @return true if assignment successful; false if room was occupied and
     *         could not be assigned to new guest.
     */
        public boolean assigned(int room, String string) {
        if (!isOccupied(room))
            this.hotel[room] = string;
        return isOccupied(room);
    }  // method assigned


    /**
     * Finds the room number of a given guest.
     *
     * @param lastName String with guest's last name
     * @return int with room number; -1 if guest not present at hotel.
     */
    public int whereIs(String lastName) {
        // Based on guest's last name, this is the room we expect to find them.
        int roomExpected = room(lastName);
        // Variable to return; Is the guest in the room we expect them?
        int roomFound = found(roomExpected, lastName);             /* simplify     */
        if (roomFound == -1)                                       /* by removing  */
            roomFound = found((roomExpected+1)%LETTERS, lastName); /* redundancies */
        // return room number or -1 if guest not present
        return roomFound;
    }  // method whereIs


    /**
     * Returns the hotel room number if occupied by the specified guest, -1 otherwise
     * @param room int room to check
     * @param string String with guest name
     * @return room number if occupied by guest, -1 otherwise
     */
    private int found(int room, String string) {
        return (this.hotel[room].equals(string)) ? room : -1;
    }  // method found

}  // class HotelAlphabetical
