/**
 * A simple linkable object that can be used in building linked lists.
 */
public class Node {

    /** Points to another object of the same class. */
    private Node next;
    /** Data that the Node may be carrying. */
    private String payload;

    /**
     * Basic constructor.
     *
     * The constructor sets .next to null explicitly. This is superfluous since
     * the compiler would have assigned that default value anyway. It is useful
     * however, because it communicates out purpose to other programmers in a
     * clear manner.
     *
     * @param payload String with data stored in the Node.
     */
    public Node(String payload) {
        this.payload = payload;
        this.next = null;
    }  // Constructor Node


    /* Various get, set, and boolean methods */

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public Node getNext() {
        return this.next;
    }

    public String getPayload() {
        return this.payload;
    }

}