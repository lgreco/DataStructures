/**
 * Dresser as a metaphor for objects.
 * 
 */

public class DresserBlueprint {


    /** Number of drawers for default dresser */
    private static final int DEFAULT_DRAWERS = 4;
    /** Number of drawer columns for default dresser */
    private static final int DEFAULT_COLUMNS = 1;
    /** Default upgrade factor for dresser */
    private static final int UPGRADE_FACTOR = 2;
    /** Wood material for default dresser */
    private static final String DEFAULT_WOOD = "Pine";
    /** Color of default dresser */
    private static final String DEFAULT_COLOR = "Natural Stain";


    /** Number of drawers */
    private int totalDrawers;
    /** How many columns of drawers */
    private int numberOfColumns;
    /** Wood type */
    private String typeOfWood;
    /** Color */
    private String color;
    /** Number of drawers used */
    private int usedDrawers = 0;
    /** The dresser */
    private String[] ourDresser;


    /**
     * Default constructor. Calls full constructor with default values as
     * arguments.
     */
    public DresserBlueprint() {
        this(DEFAULT_DRAWERS,
                DEFAULT_COLUMNS,
                DEFAULT_WOOD,
                DEFAULT_COLOR);
    }  // default constructor


    /**
     * Full constructor
     * @param totalDrawers int total number of drawers in dresser
     * @param numberOfColumns int how many columns of drawers
     * @param typeOfWood String type of wood the dresser is made off
     * @param color String the color of the dresser.
     */
    public DresserBlueprint(int totalDrawers,
                            int numberOfColumns,
                            String typeOfWood,
                            String color) {
        this.totalDrawers = totalDrawers;
        this.numberOfColumns = numberOfColumns;
        this.typeOfWood = typeOfWood;
        this.color = color;
        this.ourDresser = new String[totalDrawers];
    }  // full constructor


    /**
     * Adds an item to the first available drawer
     *
     * @param item String with kind of items contained in drawer.
     */
    void addToDrawer(String item) {
        // Make sure there is still empty drawers in the dresser
        if (usedDrawers == totalDrawers) {
            // upgrade dresser
            upgradeDresser();
        }
        // Start from the top drawer and find the first empty drawer
        int drawer = 0;
        /*
        If drawer is not empty, try the next one. The loop is guaranteed to find
        an empty drawer, before the index [drawer] runs pasts the end of the
        array. There will always be an empty drawer because the method upgrades
        the dresser if necessary, before running this loop.
         */
        while (ourDresser[drawer] != null) {
            drawer++;
        }
        // At the end of the loop, we are at an empty drawer; add item
        ourDresser[drawer] = item;
        // increment the count of used drawers
        usedDrawers++;
    }  // method addToDrawer


    /**
     * Resizes the dresser.
     *
     */
    void upgradeDresser() {
        // Create a new dresser that is larger than the old dresser
        this.totalDrawers = UPGRADE_FACTOR*ourDresser.length;
        String[] newDresser = new String[this.totalDrawers];
        // Copy items from old dresser to new dresser
        for (int i = 0; i < ourDresser.length; i++) {
            newDresser[i] = ourDresser[i];
        }
        // Replace current dresser with new dresser
        ourDresser = newDresser;
    }  // method upgradeDresser


    /**
     * Clears the specified drawer.
     *
     * Preconditions:
     * Prior to emptying the drawer, the method ensures that the dresser has at
     * least one used drawer (no point of emptying a drawer in an unused
     * dresser), that the specified drawer is within the array range (to avoid
     * an index out of bounds exception), and that the target drawer is not
     * already empty.
     *
     * @param drawer int the drawer to empty
     */
    void clearDrawer(int drawer) {
        // Check for preconditions
        if (usedDrawers > 0 &&
                drawer >= 0 && drawer < ourDresser.length &&
                ourDresser[drawer] != null) {
            // Empty the contents of the most recently used drawer
            ourDresser[usedDrawers-1] = null;
            // Reduce the number of used drawers
            usedDrawers--;
        }
    }  // method clearDrawer


    /**
     * Displays contents of dresser
     */
    void showContents() {
        System.out.printf("\n\nYour dresser has %d drawers with the following items:\n", totalDrawers);
        for (int i = 0; i < ourDresser.length; i++) {
            System.out.printf("\tDrawer %d: %s\n", i + 1, ourDresser[i]);
        }
    }  // method showContents

} // class Dresser