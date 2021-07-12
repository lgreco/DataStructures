/**
 * A very simple Node class for binary search trees.
 */
public class Node {

    /** The node holds a string */
    String word;

    /** Pointers to left and right children */
    Node left, right; // left and right children


    /**
     * Basic constructor. Places a string in the node, and keeps both children null
     * */
    public Node(String word) {
        this.word = word;
        left = right = null; // Redundant but it amplifies our intention to keep these null for now.
    } // constructor Node

} // class Node
