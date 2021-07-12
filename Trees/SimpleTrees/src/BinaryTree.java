public class BinaryTree {

    /** The principal field of the class is its root node. Everything flows from it through left/right pointers */
    Node root;

    
    /**
     * Method to insert a node to the tree. The method inserts only nodes with unique content, thus avoiding
     * duplicates.
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
        boolean success = false; // assume no insertion, ie newWord is duplicate
        Node newNode = new Node(newWord); // Prepare new node in case we decide to insert
        if (root==null) {
            // tree empty
            root = newNode;
            success = true;
        } else {
            // tree not empty
            // Let's start at root and find the appropriate place for newWord
            Node current = root;
            while (true) {
                // check if newNode needs to go left or right of current node
                int comparison = current.word.compareTo(newWord);
                if ( comparison != 0) {
                    // we can proceed with insertion
                    if (comparison>0) {
                        // go left
                        if (current.left == null) {
                            current.left = newNode;
                            success = true;
                        } else {
                            current = current.left;
                        }
                    } else {
                        // go right
                        if (current.right == null) {
                            current.right = newNode;
                            success = true;
                        } else {
                            current = current.right;
                        }
                    } // if comparison
                }
            }
        } // if tree empty
        return success;
    } // method addNode
}
