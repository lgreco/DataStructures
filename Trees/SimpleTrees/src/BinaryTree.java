import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryTree {

    /** The principal field of the class is its root node. Everything flows from it through left/right pointers */
    private Node root;

    /** Number of nodes in the tree */
    private int nodesCount;

    /** Number of levels in the tree */
    private int levelsCount;

    /** SETTER, GETTER, and BOOLEANS for Node root */

    public Node getRoot() { return root; }

    public void setRoot(Node root) { this.root = root; }

    public boolean isEmpty() { return root==null; }

    public boolean isNotEmpty() { return root != null; }

    /** GETTERS for int fields. NO NEED FOR SETTERS BECAUSE FIELDS ARE CALCULATED ON THE GO */

    public int getNodesCount() { return nodesCount; }
    public int getLevelsCount() { return  levelsCount; }


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
        if (getRoot() == null) { // tree empty
            setRoot(newNode);
            success = true;
            nodesCount = 1;
        } else { // tree not empty
            // Let's start at root and find the appropriate place for newWord
            Node current = getRoot();
            boolean keepSearchingTheTree = true; // boolean to control while loop
            while (keepSearchingTheTree) {
                // Check if newNode needs to go left or right of current node
                int comparison = current.getWord().compareTo(newWord); // Emphasizing that compareTo() returns an int
                if (comparison != 0) { // current node's contents not the same with newWord; we can proceed
                    if (comparison > 0) { // newWord is "less" that current node's content: go left
                        if (current.getLeft() == null) { // Oh, goodie, left spot is available
                            current.setLeft(newNode); // Make newNode the left spot of the current node
                            nodesCount++; // Update nodes count
                            success = true; // Declare success and
                            keepSearchingTheTree = false; // end the while loop
                        } else { // current node's left spot is occupied by another node; let's try our luck there
                            current = current.getLeft(); // Move to the left node and try again
                        } // left if
                    } else {  // newWord is "more" that current node's content: go right
                        if (current.getRight() == null) { // Oh, goodie, right spot is available
                            current.setRight(newNode); // Make newNode the right spot of the current node
                            nodesCount++; // Update nodes count
                            success = true; // Declare success and
                            keepSearchingTheTree = false; // end the while loop
                        } else { // current node's right spot is occupied by another node; let's try our luck there
                            current = current.getRight(); // Move to the left node and try again
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
        if (getRoot() == null) { // Empty tree
            System.out.printf("\n\nThe tree is empty.");
        } else { // Tree not empty ... do something ...
            System.out.printf("\n\nContents of tree:\n");
            traverseTree(getRoot());
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
        if (node.getLeft() != null)
            traverseTree(node.getLeft());
        // print node
        System.out.printf("\n%s", node.getWord());
        if (node.equals(getRoot()))
            System.out.printf(" ... (root)");
        // explore right
        if (node.getRight() != null)
            traverseTree(node.getRight());
    } // method traverseTree


    /**
     * Method to read the contents of a text file and populate a BinaryTree object with the words found therein.
     * The method assumes that the input text file is clear of punctuation and other artifacts,
     * i.e., it contains only words.
     * @param filename Input file; expected in the same directory as the code.
     * @return BinaryTree with words in the file
     */
    public void populateFromFile(String filename) throws FileNotFoundException {
        setRoot(null); // Make sure the tree appears empty.
        File f = new File(filename); // Creates file object for the given filename
        Scanner s = new Scanner(f); // Connects a scanner to the file object
        while (s.hasNext()) { // Reads file until empty ...
            String wordFromFile = s.next(); // ... one word at a time.
            addNode(wordFromFile.toLowerCase()); // Notice the conversion to lowercase for better sorting
        }
    } // method populatedFromFile


    /**
     * Driver method
     */
    public static void main(String[] args) throws FileNotFoundException {
        /* Demo for a simple tree with a few words */
        BinaryTree t = new BinaryTree();
        t.addNode("elf");
        t.addNode("audit");
        t.addNode("apple");
        t.addNode("noodle");
        t.addNode("dollar");
        t.addNode("hair");
        t.printAlphabetically();
        /* Demo for a tree populated from a file */
        BinaryTree richard3 = new BinaryTree();
        richard3.populateFromFile("sample.txt");
        richard3.printAlphabetically();
    } // method main
} // class BinaryTree