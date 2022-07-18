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
        if (!isOccupied(tentativeRoom)) {
            hotel[tentativeRoom] = lastName;
        } else {
            // if room not available, follow collision resolution; % to wrap around array
            tentativeRoom = (tentativeRoom+1)%LETTERS;
            if (!isOccupied(tentativeRoom))
                hotel[tentativeRoom] = lastName;
        }
    }  // method assignRoom


    /**
     * Finds the room number of a given guest.
     *
     * @param lastName String with guest's last name
     * @return int with room number; -1 if guest not present at hotel.
     */
    public int whereIs(String lastName) {
        // Variable to return; initial value assumes guest not present at hotel.
        int roomFound = -1;
        // Based on guest's last name, this is the room we expect to find them.
        int roomExpected = room(lastName);
        // Is the guest in the room we expect them?
        if (this.hotel[roomExpected].equals(lastName)) {
            roomFound = roomExpected;
        } else {
            // If not, follow collision resolution to see if guest is nearby
            roomExpected = (roomExpected+1)%LETTERS;
            if (this.hotel[roomExpected].equals(lastName))
                roomFound = roomExpected;
        }
        // return room number or -1 if guest not present
        return roomFound;
    }  // method whereIs
}
