/**
 * A very simple Node class for binary search trees. A node is an object with a String and pointers to two other
 * nodes, we call left and right. The positional name is suitable for using this node in constructing binary
 * search trees.
 *
 *                             +------+
 *                             | word |
 *                             +------+
 *                            /        \
 *                           /          \
 *                       left            right
 *
 */
public class Node {

    /** The node holds a string */
    private String word;

    /** Pointers to left and right children */
    private Node left;
    private Node right; // left and right children


    /**
     * Basic constructor. Places a string in the node, and keeps both children null. Notice the use of setter
     * methods below replacing
     *    this.left = null; this.right = null;
     * with
     *    setLeft(null); setRight(null);
     * This is a bit too much, but if we have these setters why not use them throughout?
     */
    public Node(String word) {
        this.setWord(word);
        setLeft(null); // Redundant but it amplifies our ...
        setRight(null); // ... intention to keep these null for now.
    } // constructor Node

    /**
     * Booleans that tell if a node has a left/right child
     *
     * @return true if node has left/right child
     */
    public boolean hasLeft() { return left != null; }
    public boolean hasRight() { return right != null; }

    /** GETTERS AND SETTERS ENABLING ACCESS TO PRIVATE FIELDS */

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
} // class Node