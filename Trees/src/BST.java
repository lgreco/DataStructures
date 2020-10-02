import java.util.ArrayList;
import java.util.List;

/**
 * A simple Binary Search Tree (BST) class.
 */
public class BST {

    // A tree is just a root, really! Everything grows from here.
    private TreeNode root;

    class TreeNode {
        String s;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(String s) {
            this.s = s;
            leftChild = rightChild = null;
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
        if (!contains(s)) {
            success = true;
            // This is the node we wish to insert
            TreeNode newNode = new TreeNode(s);
            if (root == null) {
                root = newNode;
            } else {

                // Start our search from the root
                TreeNode currentNode = root;

                // flag to control loop
                boolean keepTrying = true;

                while (keepTrying) {

                    if (s.compareTo(currentNode.s) > 0) {
                        if (currentNode.rightChild == null) {
                            currentNode.rightChild = newNode;
                            keepTrying = false;
                        } else {
                            currentNode = currentNode.rightChild;
                        }
                    } else {
                        if (currentNode.leftChild == null) {
                            currentNode.leftChild = newNode;
                            keepTrying = false;
                        } else {
                            currentNode = currentNode.leftChild;
                        }
                    }
                }
            }
        }
        return success;
    } // method insert

    /**
     * Find if value s exists in the tree
     *
     * @param s Value to search for
     * @return true if s found; false otherwise
     */
    public boolean contains(String s) {
        boolean success = false;
        if (root != null) {

            // Start searching from the top.
            TreeNode currentNode = root;

            // Loop control flag
            boolean keepTrying = true;

            while (keepTrying) {

                if (currentNode.s.compareTo(s) == 0) {
                    success = true;
                    keepTrying = false;
                } else if (s.compareTo(currentNode.s) > 0) {
                    // Go right
                    if (currentNode.rightChild == null) {
                        keepTrying = false;
                    } else {
                        currentNode = currentNode.rightChild;
                    }
                } else {
                    // Go left
                    if (currentNode.leftChild == null) {
                        keepTrying = false;
                    } else {
                        currentNode = currentNode.leftChild;
                    }
                }
            }
        }
        return success;
    } // *** method contains

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
                    System.out.printf("%15s ", currentNode.s);
                    if ( lineCount % 5 == 0) {
                        System.out.println();
                    }
                    lineCount++;
                    lifo.remove(0);

                    currentNode = currentNode.rightChild;
            }
        }
    } // method inOrder

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

    } // method main
} // class BST
