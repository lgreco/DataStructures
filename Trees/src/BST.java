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
        String value; // The String we store in this node
        TreeNode leftChild; // left child
        TreeNode rightChild; // right child

        public TreeNode(String s) { // basic constructor
            this.value = s; // assigns content to String
            leftChild = rightChild = null; // makes pointers to children null
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
        if (!contains(s)) { // Value is not stored in tree already; we can add it
            success = true; // Method will return this value to indicate successful insertion
            TreeNode newNode = new TreeNode(s); // Node with new value to be inserted
            if (root == null) { // If tree is empty,
                root = newNode; // new node becomes its root.
            } else { // Start our search from the root to find where to place new node.
                TreeNode currentNode = root; // We start our search from the root.
                boolean keepTrying = true; // Control variable from the principal loop, below.
                while (keepTrying) {  // Principal loop; exits only when keepTrying becomes false.
                    if (s.compareTo(currentNode.value) > 0) { // New value is greater than current node; go RIGHT
                        if (currentNode.rightChild == null) { // If right child is null
                            currentNode.rightChild = newNode; // place new value here
                            keepTrying = false; // Flag to exit the principal loop.
                        } else { // Right child is not null
                            currentNode = currentNode.rightChild; // Make right child the current node and try again.
                        }
                    } else { // New value is less than current node; go LEFT
                        if (currentNode.leftChild == null) { // If left child is null
                            currentNode.leftChild = newNode; // place new value here.
                            keepTrying = false; // Flag to exit the principal loop.
                        } else { // Left child is not null.
                            currentNode = currentNode.leftChild; // Make left child the current node and try again.
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
    public boolean contains(String searchForMe) {
        boolean success = false; // Assume String is not in the tree.
        if (root != null) { // Start searching from the top.
            TreeNode currentNode = root; // initialize iterative node
            boolean keepTrying = true; // Loop control flag
            while (keepTrying) {
                if (currentNode.value.compareTo(searchForMe) == 0) { // found!
                    success = true; // flag success
                    keepTrying = false; // get out of the while loop
                } else if (searchForMe.compareTo(currentNode.value) > 0) { // Go right
                    if (currentNode.rightChild == null) { // end of tree; no luck
                        keepTrying = false; // exit while loop
                    } else { // keep pushing right
                        currentNode = currentNode.rightChild; // new value for next iteration
                    }
                } else { // Go left
                    if (currentNode.leftChild == null) { // end of tree; no luck
                        keepTrying = false; // exit while loop
                    } else { // keep pushing left
                        currentNode = currentNode.leftChild; // new value for next iteration
                    }
                }
            }
        }
        return success;
    } // method contains

    /**
     * Recursive method to search for node with specified value
     * @param currentNode entry note to begin search from; on initial call: root
     * @param searchForMe value to search for
     * @return null if not found; node with value otherwise
     */
    public TreeNode containsRecursively(TreeNode currentNode, String searchForMe) {
        if ( currentNode == null || currentNode.value.equals(searchForMe) ) {
            return currentNode;
        }
        if ( currentNode.value.compareTo(searchForMe) > 1 ) { // go left
            return containsRecursively(currentNode.leftChild, searchForMe);
        }
        return containsRecursively(currentNode.rightChild, searchForMe); // go right
    } // method containsRecursively

    /**
     * Wrapper method for containsRecursively, that converts the output to a boolean
     * @param searchForMe String to look for
     * @return true if String found in tree; false otherwise
     */
    public boolean containsRecursivelyWrapper(String searchForMe) {
        return containsRecursively(root,searchForMe) != null;
    } // method containsRecursivelyWrapper

    /**
     * Iterative in-Order traversal of the tree
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            // LIFO .. (we dont "know" about stacks yet).
            List<TreeNode> lifo = new ArrayList<TreeNode>();
            // Start from the top
            TreeNode currentNode = root;
            int lineCount = 1;
            while ( currentNode != null || lifo.size() > 0 ) {
                while (currentNode != null) {
                    lifo.add(0,currentNode);
                    currentNode = currentNode.leftChild;
                }
                    currentNode = lifo.get(0);
                    System.out.printf("%15s ", currentNode.value);
                    if ( lineCount % 5 == 0) {
                        System.out.println(); // print 5 nodes per line
                    }
                    lineCount++;
                    lifo.remove(0);
                    currentNode = currentNode.rightChild;
            }
        }
    } // method inOrder

    public void inOrderRecursively(TreeNode currentNode) {
        if ( root == null ) { // Nothing to see here
            System.out.println("The tree is empty");
        }
        if ( currentNode.leftChild != null ) { // process LEFT
            inOrderRecursively(currentNode.leftChild);
        }
        System.out.println(currentNode.value); // process NODE
        if ( currentNode.rightChild != null ) { // process RIGHT
            inOrderRecursively(currentNode.rightChild);
        }
    } // method inOrderRecursively

    /** Quick testing */
    public static void main (String[]args){

        // Instantiate a binary search tree.
        BST sycamore = new BST();

        // Favorite soliloquy
        String text = "Now is the winter of our discontent\n" +
                "Made glorious summer by this sun of York;\n" +
                "And all the clouds that lour'd upon our house\n" +
                "In the deep bosom of the ocean buried.";

        // Split soliloquy into separate words (converting to lower case for uniformity).
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");

        // Add to tree.
        for (String word : words) {
            sycamore.insert(word);
        }

        // Display tree contents, in-Order.
        sycamore.inOrder();
        System.out.println();

        // Test the recursive in-Order
        sycamore.inOrderRecursively(sycamore.root);
        System.out.println();

        // Check iterative contains
        System.out.println(sycamore.contains("the"));
        System.out.println();

        // Check recursive contains
        System.out.println(sycamore.containsRecursivelyWrapper("the"));

    } // method main
} // class BST
