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



    /*
            WEDNESDAY 30 SEP 2020 LAB SESSION
            FLESH OUT THE FOLLOWING THREE METHODS
     */
    public boolean insert(String s)   { return true; } // *** method insert
    public boolean contains(String s) { return true; } // *** method contains
    public void    inOrder()                        {} // method inOrder

    /** Quick testing */
    public static void main(String[] args) {

        // Instantiate a binary search tree.
        BST sycamore = new BST();

        // Favorite soliloquy
        String text = "Now is the winter of our discontent\n" +
                "Made glorious summer by this sun of York;\n" +
                "And all the clouds that lour'd upon our house\n" +
                "In the deep bosom of the ocean buried.";

        // Split soliloquy into separate words (converting to lower case for uniformity).
        String[] words = text.toLowerCase().split(" ");

        // Add to tree. If .root is null make that word the tree's root; otherwise use insert.
        for (String word: words) {
            if ( sycamore.root == null ) {
                //....;
            } else {
                sycamore.insert(word);
            }
        }

        // Display tree contents, in-Order.
        sycamore.inOrder();

    } // method main
} // class BST
