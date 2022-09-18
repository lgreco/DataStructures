/**
 * Dresser as a metaphor for a dynamically sized array.
 *
 * @version 20220909.1700
 *
 */

public class Solutions_Dresser {

    /** Upgrade factor: multiplier for old dresser size */
    public static final int UPGRADE_FACTOR = 2;

    /** Number of drawers */
    static int totalDrawers = 4;

    /** Number of drawers used */
    static int usedDrawers = 0;

    /** The dresser */
    static String[] ourDresser = new String[totalDrawers];


    /**
     * Adds an item to THE FIRST AVAILABLE drawer.
     *
     * @param item String with kind of items contained in drawer.
     */
    public static void addToDrawer(String item) {
        // Make sure there is still empty drawers in the dresser
        if (usedDrawers == totalDrawers) {
            // upgrade dresser
            upgradeDresser();
        }
        // Find the first available drawer, start looking from the top
        int drawer = 0;
        // If a drawer is not empty
        while (ourDresser[drawer] != null) {
            // Move to the next drawer
            drawer++;
        }
        // At the end of the loop, we are at an empty drawer. Fill it.
        ourDresser[drawer] = item;
        // increment the count of used drawers
        usedDrawers++;
    }  // method addToDrawer


    /**
     * Resizes the dresser.
     */
    public static void upgradeDresser() {
        // Create a new dresser that is larger than the old dresser
        String[] newDresser = new String[UPGRADE_FACTOR*ourDresser.length];
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
    public static void clearDrawer() {
        // Make sure that there is at least one drawer used.
        if (usedDrawers > 0) {
            // Empty the contents of the most recently used drawer
            ourDresser[usedDrawers-1] = null;
            // Reduce the number of used drawers
            usedDrawers--;
        }
    }  // method clearDrawer


    /**
     * Empties a specific drawer.
     *
     * The method executes only if there is at least one drawer used. And only
     * if the specified drawer is not empty.
     *
     * @param drawer int of drawer to empty. Must be within range of drawers.
     *
     */
    public static void clearDrawer(int drawer) {
        if (usedDrawers > 0 &&
                drawer >= 0 && drawer < ourDresser.length &&
                ourDresser[drawer] != null) {
            ourDresser[drawer] = null;
            usedDrawers--;
        }
    }  // method clearDrawer


    /**
     * Displays contents of dresser
     */
    public static void showContents() {
        System.out.printf("\n\nYour dresser has %d drawers with the following items:\n", totalDrawers);
        for (int i = 0; i < ourDresser.length; i++) {
            System.out.printf("\tDrawer %d: %s\n", i + 1, ourDresser[i]);
        }
    }  // method showContents


    /**
     * Test code
     */
    public static void main(String[] args) {
        addToDrawer("Socks");
        addToDrawer("Tee-shirts");
        addToDrawer("Cufflinks");
        addToDrawer("Bowties");
        addToDrawer("Neckties");
        clearDrawer(1);
        showContents();
    }  // method main

} // class Dresser