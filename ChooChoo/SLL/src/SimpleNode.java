/**
 * Simple node with unidirectional pointer and string content
 */
public class SimpleNode {

    /** String contents of the node */
    private String content;

    /** Pointer to next node */
    SimpleNode next;

    /** Basic constructor
     *
     * Assigns string content to the node and leaves the next pointer null. The pointer will be assigned,
     * as needed, by the implementing class.
     * @param content String contents of the node.
     */
    public SimpleNode(String content) {
        this.content = content;
        this.next = null;
    } // constructor SimpleNode

    /**  GETTERS, SETTERS, AND SIMPLE BOOLEANS */

    public boolean hasNext() {
        return next != null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SimpleNode getNext() {
        return next;
    }

    public void setNext(SimpleNode next) {
        this.next = next;
    }
}
