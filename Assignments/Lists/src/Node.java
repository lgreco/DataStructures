/**
 * A simple node class with a single pointer forward.
 */

public class Node {

    /** The content part of the node */
    private String data;
    /** Points to next node, if any */
    private Node next;

    /** Basic constructor */
    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    /** Copy constructor */
    public Node(Node another) {
        this.data = another.data;
        this.next = another.next;
    }

    /**
     * Chain constructor: creates a node and places in front of another node
     *
     * @param data String to store in the node
     * @param next becomes the new node's next node.
     */
    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    /* Accessor for the content part of the node */
    public String getData() {
        return this.data;
    }

    /** Accessor for the pointer to the next node */
    public Node getNext() {
        return this.next;
    }

    /** Mutator for the pointer to the next node */
    public void setNext(Node next) {
        this.next = next;
    }

    /** Tells if node has a next one; if false, this is the last node in a list */
    public boolean hasNext() {
        return this.next != null;
    }
}
