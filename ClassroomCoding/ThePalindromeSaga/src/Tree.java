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
    void add(String content) {
        Node nodeToInsert = new Node(content);
        if (root == null) { // Tree is empty!
            root = nodeToInsert;
            numberOfNodes++;
        } else { // The tree is not empty!
            Node current = root;
            boolean keepTraversing = true;
            while (keepTraversing) {
                if (nodeToInsert.getContent().compareTo(current.getContent()) < 0) { // go left
                    if (current.getLeft() == null) {
                        current.setLeft(nodeToInsert);
                        numberOfNodes++;
                        keepTraversing = false;
                    } else {
                        current = current.getLeft();
                    }
                } else if (nodeToInsert.getContent().compareTo(current.getContent()) > 0) { // go right
                    if (current.getRight() == null) {
                        current.setRight(nodeToInsert);
                        numberOfNodes++;
                        keepTraversing = false;
                    } else {
                        current = current.getRight();
                    }
                } else { // contents are equal, exit loop
                    keepTraversing = false;
                }
            }
        }
    } // method add

    public static void main(String[] args) {
        Tree t = new Tree();
        t.add("now");
        t.add("is");
        t.add("the");
        t.add("winter");
        t.add("of");
        t.add("our");
        t.add("discontent");
        System.out.println(t.numberOfNodes);
    }


    /**
     * Method that reports performance in terms of steps per unique insertion.
     */
    public void reportPerformance() {
        double perInsertion = ((double) performanceSteps)/((double) numberOfNodes);
        System.out.printf("Tree has %d unique elements that required %d steps for insertion.\nThat's %.1f steps per element.\n\n", numberOfNodes,performanceSteps, perInsertion);
    } // method reportPerformance

}
