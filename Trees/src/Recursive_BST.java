/**
 * A simple Binary Search Tree (BST) class using recursive methods.
 */
public class Recursive_BST {

    // A tree is just a root, really! Everything grows from here.
    private TreeNode root; // what's a TreeNode? See below.

    // And here's what a TreeNode looks like.
    class TreeNode {
        String value; // The String we store in this node
        TreeNode left; // left child
        TreeNode right; // right child
        // basic constructor
        public TreeNode(String s) {
            this.value = s; // assigns content to String
            left = right = null; // makes pointers to children null
        } // constructor TreeNode
    } // class TreeNode

    /**
     * Recursive insertion of data in the tree. The method is front-ended by a wrapper
     * method and is not directly accessible to users. The technique we use below is
     * to look at a basic tree (a parent with two children pointers). If the parent
     * (which is called node) is null, we insert the new value there. Otherwise
     * we determine a direction (left for less, right for more) and we repeat the
     * process.
     * @param node parent node in the subtree we are examining
     * @param value value to insert to the tree
     * @return node where value was inserted.
     */
    private TreeNode insertRecursively(TreeNode node, String value) {
        if (node == null ) { // found an empty one!
            return new TreeNode(value); // place the new value here
        }
        if ( value.compareTo(node.value) < 0 ) { // go left
            node.left = insertRecursively(node.left, value);
        } else { // go right
            node.right = insertRecursively(node.right, value);
        }
        return node;
    } // method insertRecursively

    /**
     * Front-end method for recursive insertion. This method returns true or false to
     * indicate a successive (or not) insertion. A false return is indication that the
     * value we attempt to insert, already exists in the tree.
     * @param value value to insert into the tree
     * @return true if insertion successful; false if value exists in tree already.
     */
    public boolean insertRecursivelyWrapper(String value) {
        boolean success = false;
        if ( !valueExistsRecursivelyWrapper(value) ) { // the value is not present in the tree; we can insert it
            success = true;
            if ( root == null ) { // if tree is empty, this value becomes its root
                root = new TreeNode(value);
            } else { // otherwise we engage the recursive insertion
                root = insertRecursively(root, value);
            }
        }
        return success;
    } // method insertRecursivelyWrapper

    /**
     * Recursive method to search for node with specified value. The method is front-ended by
     * a public wrapper method.
     * @param node entry note to begin search from; on initial call: root
     * @param searchForMe value to search for
     * @return null if not found; node with value otherwise
     */
    private TreeNode valueExistsRecursively(TreeNode node, String searchForMe) {
        if ( node == null || node.value.equals(searchForMe) ) {
            return node;
        }
        if ( node.value.compareTo(searchForMe) > 1 ) { // go left
            return valueExistsRecursively(node.left, searchForMe);
        }
        return valueExistsRecursively(node.right, searchForMe); // go right
    } // method valueExistsRecursively

    /**
     * Wrapper method for containsRecursively, that converts the output to a boolean
     * @param searchForMe String to look for
     * @return true if String found in tree; false otherwise
     */
    public boolean valueExistsRecursivelyWrapper(String searchForMe) {
        return valueExistsRecursively(root,searchForMe) != null;
    } // method valueExistsRecursivelyWrapper

    /**
     * Method to find node with smallest value in a subtree starting at a give note.
     * @param node starting node for searching
     * @return node with smallest value
     */
    public TreeNode minNode(TreeNode node) {
        TreeNode current = node;
        while ( current.left != null) {
            current = current.left;
        }
        return current;
    } // method minNode

    private static int traversalCount = 0; // A local variable to use for in-Order traversal printing
    private static final int wordsPerLine = 6; // ditto

    /**
     * In-order traversal of tree, done recursively
     * @param node traverse from this node
     */
    public void inOrderTraversalRecursively(TreeNode node) {
        if ( root == null ) { // Nothing to see here
            System.out.println("The tree is empty.");
        }
        if ( node.left != null ) { // process LEFT
            inOrderTraversalRecursively(node.left);
        }
        traversalCount++; //
        System.out.printf("%15s ", node.value); // process NODE
        if (traversalCount % wordsPerLine == 0) { System.out.println(); } // every six line
        if ( node.right != null ) { // process RIGHT
            inOrderTraversalRecursively(node.right);
        }
    } // method inOrderRecursively

    /** Quick testing */
    public static void main (String[]args){
        // Instantiate a binary search tree.
        Recursive_BST sycamore = new Recursive_BST();
        // Favorite soliloquy
        String text = "Now is the winter of our discontent \n" +
                "Made glorious summer by this sun of York; \n" +
                "And all the clouds that lour'd upon our house \n" +
                "In the deep bosom of the ocean buried.";
        // Split soliloquy into separate words (converting to lower case for uniformity).
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");
        // Add words to tree with a bit of verbosity
        for (String word : words) {
            if (sycamore.insertRecursivelyWrapper(word)) {
                System.out.printf("\n%15s\t + added successfully to the tree", word);
            } else {
                System.out.printf("\n%15s\t - already in the tree; not added again", word);
            }
        }
        // In-order traversal
        System.out.printf("\n\n In order traversal of tree\n\n");
        sycamore.inOrderTraversalRecursively(sycamore.root);
        System.out.printf("\n\n");
    } // method main
} // class BST
