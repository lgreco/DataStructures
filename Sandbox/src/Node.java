/**
 * Plain linkable node with String for its data
 */
public class Node {

    /** Data stored in this node */
    private String data;

    /** Pointer to the next node */
    private Node next;

    /** Basic constructor; new nodes always point to null for next */
    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    /** Setter for next node */
    public void setNext(Node node) {
        this.next = node;
    }

    /* Getter of next node */
    public Node getNext() {
        return next;
    }

    /** Getter for node's content */
    public String getData() {
        return data;
    }

    /** Boolean to tell if node has next */
    public boolean hasNext() {
        return this.next != null;
    }
}
