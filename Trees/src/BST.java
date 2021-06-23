import java.util.ArrayList;
import java.util.List;

/**
 * A simple Binary Search Tree (BST) class.
 */
public class BST {

    // A tree is just a root, really! Everything grows from here.
    private TreeNode root; // what's a TreeNode? See below.

    // And here's what a TreeNode looks like.
    class TreeNode {
        String value; // The data we store in this node
        TreeNode left; // left child
        TreeNode right; // right child
        // basic constructor
        public TreeNode(String s) {
            this.value = s; // assigns content to String
            left = right = null; // makes pointers to children null
        } // constructor TreeNode
    } // class TreeNode


    /**
     * Inserts unique value into tree; if value already
     * exists, method returns false.
     *
     * @param s value to insert
     */
    public boolean insert(String s) {
        boolean success = false;
        if (!valueExists(s)) { // Value is not stored in tree already; we can add it
            success = true; // Method will return this value to indicate successful insertion
            TreeNode newNode = new TreeNode(s); // Node with new value to be inserted
            if (root == null) { // If tree is empty,
                root = newNode; // new node becomes its root.
            } else { // Start our search from the root to find where to place new node.
                TreeNode currentNode = root; // We start our search from the root.
                boolean keepTrying = true; // Control variable from the principal loop, below.
                while (keepTrying) {  // Principal loop; exits only when keepTrying becomes false.
                    if (s.compareTo(currentNode.value) > 0) { // New value is greater than current node; go RIGHT
                        if (currentNode.right == null) { // If right child is null
                            currentNode.right = newNode; // place new value here
                            keepTrying = false; // Flag to exit the principal loop.
                        } else { // Right child is not null
                            currentNode = currentNode.right; // Make right child the current node and try again.
                        }
                    } else { // New value is less than current node; go LEFT
                        if (currentNode.left == null) { // If left child is null
                            currentNode.left = newNode; // place new value here.
                            keepTrying = false; // Flag to exit the principal loop.
                        } else { // Left child is not null.
                            currentNode = currentNode.left; // Make left child the current node and try again.
                        }
                    }
                }
            }
        }
        return success;
    } // method insert

    /**
     * Find if String searchForMe exists in the tree, in an iterative scan
     *
     * @param searchForMe Value to search for
     * @return true if searchForMe found; false otherwise
     */
    public boolean valueExists(String searchForMe) {
        boolean success = false; // Assume String is not in the tree.
        if (root != null) { // Start searching from the top.
            TreeNode currentNode = root; // initialize iterative node
            boolean keepTrying = true; // Loop control flag
            while (keepTrying) {
                if (currentNode.value.compareTo(searchForMe) == 0) { // found!
                    success = true; // flag success
                    keepTrying = false; // get out of the while loop
                } else if (searchForMe.compareTo(currentNode.value) > 0) { // Go right
                    if (currentNode.right == null) { // end of tree; no luck
                        keepTrying = false; // exit while loop
                    } else { // keep pushing right
                        currentNode = currentNode.right; // new value for next iteration
                    }
                } else { // Go left
                    if (currentNode.left == null) { // end of tree; no luck
                        keepTrying = false; // exit while loop
                    } else { // keep pushing left
                        currentNode = currentNode.left; // new value for next iteration
                    }
                }
            }
        }
        return success;
    } // method valueExists

    /**
     * Iterative in-Order traversal of the tree
     */
    public void inOrder() {
        if (root == null) { // empty tree
            System.out.println("Tree is empty");
        } else {
            System.out.println("\n\nIn-Order traversal of your tree:\n");
            int wordCount = 1; // tracks how many words are printed before new line
            int wordPerLine = 5; // I want this may words per line
            List<TreeNode> nodesToProcess = new ArrayList<TreeNode>(); // Simple "stack"
            // Start from the top
            TreeNode currentNode = root;
            // The following loop traverses while there are items in the "stack"
            while ( currentNode != null || nodesToProcess.size() > 0 ) {
                while (currentNode != null) {
                    nodesToProcess.add(0,currentNode);
                    currentNode = currentNode.left; // Go as left as you can
                }
                currentNode = nodesToProcess.get(0); // When no more left, print what's on top of the stack
                System.out.printf("%-15s ",currentNode.value);
                if ( wordCount%wordPerLine==0 ) {
                    System.out.printf("\n");
                }
                wordCount++;
                nodesToProcess.remove(0); // remove the current node from the stack
                currentNode = currentNode.right; // go right
            }
        }
    } // method inOrder

    /**
     * Method to find the smallest node of a tree (or subtree). The smallest node is the
     * left-most node of the tree (or subtree).
     * @param node the root of the tree or subtree we wish to scan
     * @return the node with the smallest value
     */
    public TreeNode minNode(TreeNode node) {
        TreeNode current = node;
        while ( current.left != null) { // Keep going left until no more
            current = current.left;
        }
        return current; // this is the smallest node
    } // method minNode

    /**
     * Method successor finds, iteratively, the node with the next highest value from the
     * node provided. If the node whose successor we seek has a right subtree, the successor
     * is the smallest node of that subtree. Otherwise, we start from the root, towards
     * the node whose successor we seek. Every time we go left at a node, we mark that
     * node as the successor.
     * @param ofThisNode Node whose successor we are seeking.
     * @return The node's successor; null if it has no successor
     */
    public TreeNode successor(TreeNode ofThisNode) {
        TreeNode succ = null;
        if ( ofThisNode.right != null) { // Node whose successor we seek, has a right subtree.
            succ = minNode(ofThisNode.right); // Successor is smallest node of right subtree.
        } else { //
            TreeNode current = root; // Start from root and go towards node whose successor we seek.
            boolean keepTraversing = true; // Switch to exit the while loop when done
            while (keepTraversing) {
                if ( ofThisNode.value.compareTo(current.value ) < 0 ) { // Node whose successor we seek should be to the left.
                    if ( current.left != null ) { // Can we go left?
                        succ = current; // Mark this node as successor
                        current = current.left; // Go left
                    } else { // We can no longer go left -- end of tree?
                        keepTraversing = false; // Signal to exit the while loop.
                    }
                } else { // Node whose successor we seek should be to the right.
                    if ( current.right != null ) { // Can we go right?
                        current = current.right; // Go right
                    } else { // We can no longer go right -- end of tree?
                        keepTraversing = false; // Signal to exit while loop.
                    }
                } // Done deciding left/right as we search for the node whose successor we seek.
            } // Done traversing the tree
        } // Done looking for the successor; we have it (or we end up with null, ie, end of tree).
        return succ;
    } // method successor

    /** Quick testing */
    public static void main (String[]args){

        // Instantiate a binary search tree.
        BST sycamore = new BST();

        // Favorite soliloquy to be used as content for the tree
        String text = "Now is the winter of our discontent " +
                "Made glorious summer by this sun of York; " +
                "And all the clouds that lour'd upon our house " +
                "In the deep bosom of the ocean buried.";

        // Split soliloquy into separate words (converting to lower case for uniformity).
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");

        // Add to tree.
        for (String word : words) {
            sycamore.insert(word);
        }

        // Print the tree using the in-Order traversal
        sycamore.inOrder();

    } // method main

} // class BST
