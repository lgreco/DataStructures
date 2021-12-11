package Exams.SU21_Midterm.src;

/**
 * A Node with two pointers and a String value.
 *
 *
 *                          +---Node---+
 *                          |          |---- next --->
 *                          |  content |
 *        <--- previous ----|          |
 *                          +----------+
 *
 */
public class Node {

    /** The content of the node */
    private String content;

    /** A pointer to the next node */
    private Node next;

    /** A pointer to the previous node */
    private Node previous;


    /**
     * Basic constructor: assigns a value to the String of the object and
     * affirms that both pointers are null.
     *
     * @param content
     */
    public Node(String content) {
        this.content = content;
        previous = next = null;
    } // constructor Node


    /**
     * Method to tell is there is another node after a node.
     * @return true if node has another node after it.
     */
    public boolean hasNext() {
        return next!=null;
    } // method hasNext


    /**
     * Method to tell is there is another node before a node.
     * @return true if node has another node before it.
     */
    public boolean hasPrevious() {
        return previous!=null;
    } // method hasPrevious


    /** Automatically generated code */

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
} // class Node