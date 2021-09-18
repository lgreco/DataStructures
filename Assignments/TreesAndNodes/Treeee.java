/**
 * A basic binary search tree.
 *      (intentionally misspelled to avoid any confusion with more serious and reliable code)
 *
 *
 */
public class Treeee {

    /** The root node of the tree. Everything begins here! */
    Node root;

    /** Number of nodes in the tree */
    int numberOfNodes;

    /** Step counter for performance measurements */
    int performanceSteps = 0;


    /**
     * Method to determine if a node containing a target string exists in the tree.
     *
     * @param target String to search for
     * @return true if node with target string present in tree; false otherwise or if tree empty
     */
    public boolean contains(String target) {
        boolean found = false; // Assume target doesn't exist.
        if (this.root != null) { // Tree is not empty; let's traverse it.
            Node current = root; // Node current tells us where we are while traversing the tree
            boolean keepTraversal = true; // Switch to stop traversal when target found or certain it doesn't exist
            while (keepTraversal) {
                if (target.compareTo(current.content) == 0) {
                    found = true; // target found!
                    keepTraversal = false; // End tree traversal
                } else if (target.compareTo(current.content) < 0) { // Target should be to the left of current node
                    if (current.left == null) { // But left is empty, so ...
                        keepTraversal = false; // ... stop the tree traversal
                    } else { // There is a path to the left ...
                        current = current.left; // ... follow it and try again
                    }
                } else if (target.compareTo(current.content) > 0) { // Target should be to the right of current node
                    if (current.right == null) { // But right is empty, so ...
                        keepTraversal = false; // ... stop the tree traversal.
                    } else { // There is a path to the right ...
                        current = current.right; // ... follow it and try again.
                    }
                } // compareTo if-block
            } // traversing while-loop
        } // tree not empty if-block
        return found;
    } // method contains


    /**
     * Method to add a node to the tree.
     *
     * The method creates a new node object and find a place in the tree to store it. If another node with
     * the same content exists, the new node will not be added. The method also updates the two counters in
     * this class: number of nodes in the tree, and steps taken towards insertion.
     *
     * @param content String to include in node.
     */
    public void add(String content) {
        Node nodeToInsert = new Node(content); // Prepare the new node to insert
        if (this.root == null) { // Tree is empty
            /* WHAT DO WE DO IF THE TREE IS EMPTY? */
        } else { // Tree is not empty
            /* WHAT DO WE DO IF THE TREE IS NOT EMPTY? WHERE WILL THE NEW NODE GO? */
        }
    } // method add

} // class Treeee
