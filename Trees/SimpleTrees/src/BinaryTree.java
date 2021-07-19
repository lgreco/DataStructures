public class BinaryTree {

    /**
     * The principal field of the class is its root node. Everything flows from it through left/right pointers
     */
    Node root;



    /**
     * Method to insert a node to the tree. The method inserts only nodes with unique content, thus avoiding
     * duplicates. Insertion start from the root of the tree. If the root is empty, things are easy. The new node
     * becomes the tree. Otherwise we traverse the tree from the root down to find the appropriate location for the
     * new node.
     *
     * @param newWord contents of the new node
     * @return true if insertion was completed; false if node with newWord already exists in three
     */
    public boolean addNode(String newWord) {
        /*
        If tree empty (root==null), so make new node and assign it as root;
        Otherwise, start from root, and keep going left/right as needed by
        alphabetical order, to find an empty spot for the newWord. Anticipating
        that the newWord may already be present in the tree, in which case no
        insertion needed.
         */
        boolean success = false; // Assume no insertion, ie newWord is duplicate
        Node newNode = new Node(newWord); // Prepare new node in case we decide to insert
        if (root == null) { // tree empty
            root = newNode;
            success = true;
        } else { // tree not empty
            // Let's start at root and find the appropriate place for newWord
            Node current = root;
            boolean keepSearchingTheTree = true; // boolean to control while loop
            while (keepSearchingTheTree) {
                // Check if newNode needs to go left or right of current node
                int comparison = current.word.compareTo(newWord); // Emphasizing that compareTo() returns an int
                if (comparison != 0) { // current node's contents not the same with newWord; we can proceed
                    if (comparison > 0) { // newWord is "less" that current node's content: go left
                        if (current.left == null) { // Oh, goodie, left spot is available
                            current.left = newNode; // Make newNode the left spot of the current node
                            success = true; // Declare success and
                            keepSearchingTheTree = false; // end the while loop
                        } else { // current node's left spot is occupied by another node; let's try our luck there
                            current = current.left; // Move to the left node and try again
                        } // left if
                    } else {  // newWord is "more" that current node's content: go right
                        if (current.right == null) { // Oh, goodie, right spot is available
                            current.right = newNode; // Make newNode the right spot of the current node
                            success = true; // Declare success and
                            keepSearchingTheTree = false; // end the while loop
                        } else { // current node's right spot is occupied by another node; let's try our luck there
                            current = current.right; // Move to the left node and try again
                        } // right if
                    }
                } else {
                    keepSearchingTheTree = false; // duplicate found; exit the loop and declare no insertion
                }
            } // while ... traversing the tree
        } // if tree empty
        return success;
    } // method addNode

    /**
     * Helper method to call recursive traversal of a tree.
     */
    public void printAlphabetically() {
        if (root == null) { // Empty tree
            System.out.printf("\nThe tree is empty.");
        } else { // Tree not empty ... do something ...
            traverseTree(root);
        }
    } // method printAlphabetically

    /**
     * Recursive implementation for in-order traversal of a tree. In-order means that we process nodes
     * in the way to see them, from left-to-right.
     *
     * @param node
     */
    public void traverseTree(Node node) {
        // explore left
        if (node.left != null)
            traverseTree(node.left);
        // print node
        System.out.printf("\n%s", node.word);
        if (node.equals(root))
            System.out.printf(" ... (root)");
        // explore right
        if (node.right != null)
            traverseTree(node.right);
    } // method traverseTree


    /**
     * Driver method
     */
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.addNode("elf");
        t.addNode("audit");
        t.addNode("apple");
        t.addNode("noodle");
        t.addNode("dollar");
        t.addNode("hair");

        t.printAlphabetically();

    }

}