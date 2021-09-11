/**
 * Singly linkable object.
 *
 *     The object comprises a content field and a pointer to the next object in
 *     the list it participates. Object is created without pointing to the next
 *     object in the list. The value of self.next is assigned by the calling code.
 *     
 */
public class Node {

    private String content;
    private Node next;

    public Node(String content) {
        this.content = content;
        this.next = null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
