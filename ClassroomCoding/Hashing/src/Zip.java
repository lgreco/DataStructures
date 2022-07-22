/**
 * A linkable class of zip codes and corresponding towns. This class can be
 * used for key-value pairing, using the zipCode field as a key.
 */
public class Zip {

    /** zipCode can be used as a key in a key-value pair */
    private int zipCode;

    /** The town associated with this zip code */
    private String town;

    /** Pointer to next object if it is used in a linked list */
    Zip next;

    /**
     * Full constructor
     * @param zipCode int with the zip code value. This value can be used
     *                as a key in a key-value pair.
     *
     * @param town String with town of the zip code.
     *
     * @param next Zip object following this Zip object, if we chain them
     *             un in a linked list.
     */
    public Zip(int zipCode, String town, Zip next) {
        this.zipCode = zipCode;
        this.town = town;
        this.next = next;
    }  // full constructor

    // Basic accessors =========================================================
    public int getZipCode() {
        return zipCode;
    }

    public String getTown() {
        return town;
    }

    public Zip getNext() {
        return next;
    }


    /**
     * Is there another object after this one?
     *
     * @return true if object points to another Zip object; null otherwise.
     */
    public boolean hasNext() {
        return this.next != null;
    }  // method hasNext

}  // class Zip