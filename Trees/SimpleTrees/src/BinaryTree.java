public class BinaryTree {

    /** The principal field of the class is its root node. Everything flows from it through left/right pointers */
    Node root;


    /**
     * Method to insert a node to the tree. The method inserts only nodes with unique content, thus avoiding
     * duplicates. Insertion start from the root of the tree. If the root is empty, things are easy. The new node
     * becomes the tree. Otherwise we traverse the tree from the root down to find the approrpiate location for the
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
        if (root==null) { // tree empty
            root = newNode;
            success = true;
        } else { // tree not empty
            // Let's start at root and find the appropriate place for newWord
            Node current = root;
            boolean keepSearchingTheTree = true; // boolean to control while loop
            while (keepSearchingTheTree) {
                // Check if newNode needs to go left or right of current node
                int comparison = current.word.compareTo(newWord); // Emphasizing that compareTo() returns an int
                if ( comparison != 0) { // current node's contents not the same with newWord; we can proceed
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


/*
Things to do on Tue 13JUL
 inOrder traversals
 discuss removals
 discuss viz (very challenging)
 */
}
