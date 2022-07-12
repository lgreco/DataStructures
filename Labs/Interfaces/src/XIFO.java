public class XIFO {

    /** Default array size */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array of the class */
    String[] values;

    /** Basic constructor */
    public XIFO(int size) {
        this.values = new String[size];
    }

    /** Default constructor */
    public XIFO() {
        this(DEFAULT_SIZE);
    }


}
