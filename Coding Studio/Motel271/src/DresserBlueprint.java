/**
 * Dresser as a metaphor for objects.
 * 
 */

public class DresserBlueprint {

    static final int DEFAULT_DRAWERS = 4;
    static final int DEFAULT_COLUMNS = 1;
    static final String DEFAULT_WOOD = "Pine";
    static final String DEFAULT_COLOR = "Natural Stain";

    /** Upgrade factor: multiplier for old dresser size */
    public static final int UPGRADE_FACTOR = 2;

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
     *
     * @param totalDrawers
     * @param numberOfColumns
     * @param typeOfWood
     * @param color
     */
    public DresserBlueprint(int totalDrawers,
                            int numberOfColumns,
                            String typeOfWood,
                            String color) {
        this.totalDrawers = totalDrawers;
        this.numberOfColumns = numberOfColumns;
        this.typeOfWood = typeOfWood;
        this.color = color;
    }  // full constructor

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("Puke Green")) {
            this.color = "Maroon";
        } else {
            this.color = color;
        }
    }

    public DresserBlueprint() {
        // for every attribute in this object:
        //   initialize attribute to its default value.
    }

    /**
     * Adds an item to a drawer; each drawer can contain only one kind of items.
     *
     * @param item String with kind of items contained in drawer.
     */
    void addToDrawer(String item) {
        // Make sure there is still empty drawers in the dresser
        if (usedDrawers == totalDrawers) {
            // upgrade dresser
            upgradeDresser();
        }
        // add the new item to a drawer
        ourDresser[usedDrawers] = item;
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
     * Clears the most recently used drawer.
     *
     * Method checks first that there is at least one drawer used.
     */
    void clearDrawer() {
        // Make sure that there is at least one drawer used.
        if (usedDrawers > 0) {
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