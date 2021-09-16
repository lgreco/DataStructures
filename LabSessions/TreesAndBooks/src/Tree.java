public class Tree {

    /** The entry point to the tree */
    private Node root;

    /** How many nodes have we added to the tree? */
    private int numberOfNodes = 0;

    /** How many steps it took us for these nodes */
    private int performanceSteps = 0;


    /**
     * Method to add a node to the tree, following Binary Search Tree technique: less to the left, more to the right.
     *
     * The method does not insert nodes with a string already present in the tree.
     *
     * @param content String to form node that is inserted to the tree
     */
    public void add(String content) {
    } // method add

    public boolean contains(String content) {
        boolean result = false; // Assume content not present in tree
        if (root != null) { // If tree is not empty:
            Node current = root;
            boolean keepTraversing = true;
            while (keepTraversing) {
                if (content.equals(current.content)) {
                    result = true;
                    keepTraversing = false;
                } else if (content.compareTo(current.content) < 0) { // try going left
                    if (current.left == null) {
                        keepTraversing = false; // Not going to find target
                    } else {
                        current = current.left;
                    }
                } else if (content.compareTo(current.content) > 0) { // try going to the right
                    if (current.right == null) {
                        keepTraversing = false;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    } // method contains


    /**
     * Method that reports performance in terms of steps per unique insertion.
     */
    public void reportPerformance() {
        double perInsertion = ((double) performanceSteps)/((double) numberOfNodes);
        System.out.printf("Tree has %d unique elements that required %d steps for insertion.\nThat's %.1f steps per element.\n\n", numberOfNodes,performanceSteps, perInsertion);
    } // method reportPerformance

}
