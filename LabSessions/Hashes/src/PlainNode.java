/**
 * A simple node class for use with linked list. The node comprises two fields: a string with
 * some data, and a pointer to the next node along the linked list.
 */
public class PlainNode {

    /** String with data */
    private String data;

    /** Pointer to next node */
    private PlainNode next;


    /**
     * Basic constructor. Builds a node with data and a null next pointer.
     * @param data String with data to store in node.
     */
    public PlainNode(String data) {
        this.data = data;
        this.next = null;
    } // constructor PlainNode;


    /** Setter for next node object */
    public void setNext(PlainNode plainNode) {
        this.next = plainNode;
    } // method setNext


    /** Getter for next node */
    public PlainNode getNext() {
        return this.next;
    } // method getNext()


    /** Getter for data content of a node */
    public String getData() {
        return this.data;
    } // method getData


    /** Boolean getter for next point
     *
     * @return true if next doesn't point to null
     */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

} // class PlainNode