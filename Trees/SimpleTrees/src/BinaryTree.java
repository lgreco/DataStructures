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


    /**
     * Helper method to call recursive traversal of a tree.
     */
    public void printAlphabetically() {
        if (root == null ) { // Empty tree
            System.out.printf("\nThe tree is empty.");
        } else { // Tree not empty ... do something ...
            traverseTree(root);
        }
    } // method printAlphabetically


    /**
     *
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
        System.out.printf("\n%s",node.word);
        // explore right
        if (node.right != null)
            traverseTree(node.right);
    } // method traverseTree


    /**
     * Method to return the successor of a node.
     *
     * @param node Node whose successor we are looking for
     * @return successor Node
     */
    public Node successor(Node node) {
        Node succ = null;
        if (node != null) { // Make sure node whose successor we want, is not null
            if (node.right != null) { // If node right child is not null, it has no successor
                succ = node.right; // We need to begin traversing left-wise from top of node's right child
                while (succ.left != null) { // as long as there is a left child ...
                    succ = succ.left; // ... follow that left child.
                } // we got it!
            }
        }
        return succ;
    } // method successor


    /**
     * Method to find the paren of a node. The method is iterative, for illustrative purposes.
     * @param target Node whose parent we are seeking
     * @return the parent of the target node; or null if no parent or if target null.
     */
    private Node findParent(Node target) {
        Node parent = null; // Assume no parent node will be found.
        if (root != null) { // Execute only if tree is not empty.
            /*
            Now that we now the tree is not empty, we'll traverse it from the top (root) to find the target node.
            During this traversal, we keep track of the node that leads us to the next one. Because that node may
            be the parent we are seeking. To visualize things:

                  current node   <---------------- current node is the parent we seek if it has a left child
                 /            \                    and that left child is the target node, or if it has a right
                /              \                   child and that child is the target node.
              left           right                    But how we decide which child to test? It depends on how
                                                   Node:target compares with Node:current. That tells us if
                                                   Node:target is expected to be to the left or to the right of
                                                   Node:current. And we need to be ready for the possibility that
             the Node:target cannot be found in the tree. In other words, we  are told to look for it to the left
             (or the right) of the current node, only to find that child null. In that case we declare the search
             as failed and we return a null. The search also fails when the target node is the current node.
             */
            Node current = root; // We start the search from top
            boolean keepGoing = true; // Variable to control the while-loop
            while (keepGoing) { // Traversal loop

                if (current.word.compareTo(target.word) > 0) { // First, tests if we need to go left.
                    if (current.left != null) { // The left child is present.
                        if (current.left.equals(target)) { // The left child is the node we seek.
                            parent = current; // Name the parent as the node that lead us here.
                            keepGoing = false; // Flag to terminate the loop.
                        } else { //The left child is not the node we seek.
                            current = current.left; // Move one level down and try again.
                        }
                    }
                } // endif for going left

                if (current.word.compareTo(target.word) < 0) { // Maybe we need to go right.
                    if (current.right != null) { // The right child is present.
                        if (current.right.equals(target)) { // The right child is the node we seek.
                            parent = current; // Name the parent as the node that lead us here.
                            keepGoing = false; // Flag to terminate the loop.
                        } else { //The right child is not the node we seek.
                            current = current.right; // Move one level down and try again.
                        }
                    }
                } // endif for going right

                if (current.word.compareTo(target.word) == 0) { // if the current node is the target, fail.
                    keepGoing = false; // end the while loop.
                }

            } // while loop traversing the tree
        } // endif for empty tree
        return parent;
    } // method findParent


    /** Driver method */
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
