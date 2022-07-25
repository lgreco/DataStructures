/**
 * A simple mapping class between zipcodes (keys) and towns (values).
 * @version 2207242000
 *
 */
public class PostalCodes {

    /** The underlying array of the class */
    private Zip[] codes;

    /** How many zip objects are stored in this structure */
    private int usage = 0;


    /** Basic constructor */
    public PostalCodes(int size) {
        this.codes = new Zip[size];
        this.usage = 0;
    }  // basic constructor


    /** Simple accessor */
    public Zip[] getCodes() {
        return codes;
    }


    /**
     * The object's hashFunction with respect to the size of the underlying
     * array.
     *
     * @param zipCode int zip code to hash into one of the underlying
     *                array's position.
     *
     * @return int position in the underlying array.
     */
    public int hashFunction(int zipCode) {
        return zipCode % this.codes.length;
    }  // method hashFunction


    /**
     * Insert a Zip object to the underlying array. The Zip object is
     * created based on the passed parameters. It becomes the first object
     * in the linked list stored in the array. Its location in the array
     * is determined by the hash function value for the zip code parameter.
     *
     * @param zipCode int zip code for the new zip object
     * @param town String with the town corresponding to that zip code
     *
     */
    public void put(int zipCode, String town) {
        // Find where in the array to place the object
        int position = hashFunction(zipCode);
        /*
        Create a new zip object and append to it whatever is stored already
        at this array position. Then place this new object at this array
        position, effectively creating a linked list.

         */
        this.codes[position] = new Zip(zipCode, town, this.codes[position]);
        // Update usage
        this.usage++;
    }  // method put


    /**
     * Creates a string representation of the structure.
     *
     * @return String with print-friendly representation of the structure.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n\n%s There are %d nodes %s",
                "#".repeat(35),
                usage,
                "#".repeat(35)));
        for (int i = 0; i < this.codes.length; i++) {
            sb.append(String.format("\nGroup[%02d]: ",i));
            Zip cursor = this.codes[i];
            if (cursor == null) {
                sb.append("no data.");
            } else {
                while (cursor.hasNext()) {
                    sb.append(String.format("(%05d, %s),  ",
                            cursor.getZipCode(),
                            cursor.getTown()));
                    cursor = cursor.getNext();
                }
                // Fencepost: last node
                sb.append(String.format("(%05d, %s)",
                        cursor.getZipCode(),
                        cursor.getTown()));
            }
        }
        return sb.toString();
    }  // method toString

}  // class PostalCodes
