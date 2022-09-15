/**
 * Dresser as a metaphor for objects.
 *
 */

public class UsefulDresser {

    // Class constants
    /** Upgrade factor: multiplier for old dresser size */
    public static final int UPGRADE_FACTOR = 2;
    /** Number of drawers for default constructor */
    static final int DEFAULT_DRAWERS = 4;
    /** Number of dresser columns for default constructor */
    static final int DEFAULT_COLUMNS = 1;
    /** Wood type for default constructor */
    static final String DEFAULT_WOOD = "Pine";
    /** Wood color for default constructor */
    static final String DEFAULT_COLOR = "Natural Stain";

    // Class fields
    /** Number of drawers */
    private int totalDrawers;
    /** How many columns of drawers */
    private int numberOfColumns;
    /** Wood type */
    private String typeOfWood;
    /** Color */
    private String color;
    /** Number of drawers used */
    private int usedDrawers;
    /** The dresser */
    private String[] dresser;


    /**
     * Full constructor
     *
     * @param totalDrawers int number of drawers in the dresser
     * @param numberOfColumns int number of columns of drawers
     * @param typeOfWood String the wood material of the dresser
     * @param color String the color of the dresser
     */
    public UsefulDresser(int totalDrawers,
                         int numberOfColumns,
                         String typeOfWood,
                         String color) {
        this.totalDrawers = totalDrawers;
        this.numberOfColumns = numberOfColumns;
        this.typeOfWood = typeOfWood;
        this.color = color;
        this.usedDrawers = 0;
        this.dresser = new String[totalDrawers];
    }  // full constructor


    /**
     * Default constructor. Creates a dresser object with basic characteristics.
     *
     */
    public UsefulDresser() {
        this.totalDrawers = DEFAULT_DRAWERS;
        this.numberOfColumns = DEFAULT_COLUMNS;
        this.typeOfWood = DEFAULT_WOOD;
        this.color = DEFAULT_COLOR;
        this.usedDrawers = 0;
        this.dresser = new String[totalDrawers];
    }  // Deault constructor


    /**
     * Adds an item to a drawer; each drawer can contain only one kind of items.
     *
     * @param item String with kind of items contained in drawer.
     */
    public void addToDrawer(String item) {
        // Make sure there is still empty drawers in the dresser
        if (usedDrawers == totalDrawers) {
            // upgrade dresser
            upgradeDresser();
        }
        // add the new item to a drawer
        dresser[usedDrawers] = item;
        // increment the count of used drawers
        usedDrawers++;
    }  // method addToDrawer


    /**
     * Resizes the dresser.
     *
     * Method creates a new array with twice as many elements as the dresser
     * array, then copies the contents of the dresser array to the new array,
     * and finally replaces the dresser array with the new array.
     *
     */
    public void upgradeDresser() {
        // Update the number of drawers to twice as many.
        this.totalDrawers = UPGRADE_FACTOR*this.totalDrawers;
        // Create a new array with the expanded number of drawers
        String[] newDresser = new String[this.totalDrawers];
        // Copy items from old dresser to new dresser
        for (int i = 0; i < dresser.length; i++) {
            newDresser[i] = dresser[i];
        }
        // Replace current dresser with new dresser
        dresser = newDresser;
    }  // method upgradeDresser


    /**
     * Clears the most recently used drawer.
     *
     * Method checks first that there is at least one drawer used.
     */
    public void clearDrawer() {
        // Make sure that there is at least one drawer used.
        if (usedDrawers > 0) {
            // Empty the contents of the most recently used drawer
            dresser[usedDrawers-1] = null;
            // Reduce the number of used drawers
            usedDrawers--;
        }
    }  // method clearDrawer


    /**
     * Displays contents of dresser
     */
    public void showContents() {
        System.out.printf("\n\nYour dresser has %d drawers with the following items:\n", totalDrawers);
        for (int i = 0; i < dresser.length; i++) {
            System.out.printf("\tDrawer %d: %s\n", i + 1, dresser[i]);
        }
    }  // method showContents

} // class Dresser