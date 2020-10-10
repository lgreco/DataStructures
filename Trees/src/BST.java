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

    private TreeNode insertRecursively(TreeNode currentNode, String value) {
        if (currentNode == null ) { // found an empty !
            currentNode = new TreeNode(value); // place the new value here
            return currentNode;
        }
        if ( value.compareTo(currentNode.value) < 0 ) { // go left
            currentNode.leftChild = insertRecursively(currentNode.leftChild, value);
        } else { // go right
            currentNode.rightChild = insertRecursively(currentNode.rightChild, value);
        }
        return currentNode;
    } // method insertRecursively

    public boolean insertRecursivelyWrapper(String value) {
        boolean success = false;
        if ( !valueExists(value) ) {
            success = true;
            if ( root == null ) {
                root = new TreeNode(value);
            } else {
                root = insertRecursively(root, value);
            }
        }
        return success;
    } // method insertRecursivelyWrapper


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
    private TreeNode containsRecursively(TreeNode currentNode, String searchForMe) {
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

    public TreeNode successor(TreeNode node) {
        if ( node.rightChild != null ) {
            return minNode(node.rightChild);
        } else {
            return null;
        }
        /*
        TreeNode parentNode = node.parent
        while ( parentNode != null && node == p.right ) {
          node = parentNode;
          parentNode = parentNode.parent;
        }
        return parentNode;
         */
    } // method successor

    public TreeNode minNode(TreeNode node) {
        TreeNode current = node;
        while ( current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    } // method minNode

    public String successorWithChildrenOnly(String value) {
        TreeNode node = new TreeNode(value);
        if ( node.rightChild != null ) {
            return minNode(node.rightChild).value;
        }
        // start from the top
        TreeNode successor = null;
        TreeNode current = root;
        while ( current != null) {
            if ( node.value.compareTo(current.value) < 0) {
                successor = current;
                current = current.leftChild;
            } else // if ( node.value.compareTo(current.value) > 0 ) {
                current = current.rightChild;
            }
        return (successor == null) ? "/* END OF TREE */" : successor.value;
    }

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
                "Made glorious summer by this sun of York; \n" +
                "And all the clouds that lour'd upon our house\n" +
                "In the deep bosom of the ocean buried.";

        // Split soliloquy into separate words (converting to lower case for uniformity).
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");

        // Add to tree.
        for (String word : words) {
            sycamore.insert(word);
        }

        System.out.printf("\n\nThe root of the tree is %s\n\nIts left child is %s and its right child is %s\n\n",
                sycamore.root.value,
                sycamore.root.leftChild.value,
                sycamore.root.rightChild.value);

        System.out.printf("Going left, then right from root, we expect the word OF: %s\n\n",sycamore.root.rightChild.leftChild.value);

        // Display tree contents, in-Order.
        sycamore.inOrder();
        System.out.println();


    } // method main
} // class BST
