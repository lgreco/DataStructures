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
            /*
            WHAT DO WE DO IF THE TREE IS EMPTY?
            ANSWER: we make the new node (nodeToInsert) the root of this tree and set the number of
            nodes to 1.
            */
            this.root = nodeToInsert;
            this.numberOfNodes = 1;
        } else { // Tree is not empty
            /*
            WHAT DO WE DO IF THE TREE IS NOT EMPTY? WHERE WILL THE NEW NODE GO?
            ANSWER: starting from the root, we traverse the tree to find a place to store the
            nodeToInsert. If there is already a node with the same content, we do not add the
            new node.
            */
            Node current = this.root;  // Current position as we move about the tree.
            boolean keepTraversing = true;  // Switch to turn off the traversal loop below, when done.
            while (keepTraversing) {  // Traversal loop
                // How does content of nodeToInsert compare to content of current node?
                int direction = content.compareTo(current.content);
                /*
                Is new content more, same, or less than content of current node? Based on this
                comparison output we'll determine our course of action. If less, we'll go left;
                if more, we'll go right; if same, we'll take no action because there is already
                a node with the current content.
                 */
                if (direction < 0) {  // Need to go left.
                    if (current.left == null) {  // Left child available.
                        current.left = nodeToInsert;  // Place new node here.
                        numberOfNodes++;  // Increase the number of nodes.
                        keepTraversing = false;  // Done! Turn off the while loop.
                    } else { // Left child occupied.
                        current = current.left;  // Move current position to left child and try again.
                    }
                } else if (direction > 0) {  // Need to go right.
                    if (current.right == null) {  // Right child available.
                        current.right = nodeToInsert;  // Place new node here.
                        numberOfNodes++;  // Increase the number of nodes.
                        keepTraversing = false;  // Done. Turn off the while loop.
                    } else {  // Right child occupied.
                        current = current.right;  // Move current position to right child and try again.
                    }
                } else { // only case left is direction == 0, so content exists; end loop
                    keepTraversing = false;
                }
            }
        }
    } // method add

} // class Treeee
