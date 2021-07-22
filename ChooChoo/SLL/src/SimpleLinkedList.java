/**
 * A simple linked list class
 */
public class SimpleLinkedList {

    /** The beginning of the list */
    private SimpleNode head;

    public boolean isEmpty() {
        return head==null;
    }

    public void setHead(SimpleNode node) {
        this.head = node;
    }

    public SimpleNode getHead() {
        return head;
    }


    /**
     * Method to add a node to a list.
     * @param content String content of the new node
     */
    public void addNode(String content) {
        SimpleNode newNode = new SimpleNode(content); // Prepare the new node to add.
        if (this.isEmpty()) { // List is empty ...
            this.setHead(newNode); // ... make new node the list's head.
        } else { // The list is not empty ...
            SimpleNode current = this.getHead(); // ... so, let's prepare to traverse it, ...
            while (current.hasNext()) { // ... until we find a node whose next pointer is null ...
                current = current.getNext(); // .. and its next node will be the last node of the list.
            }
            current.setNext(newNode); // We make the new node, the next node of what was just now the last node.
        }
    } // method addNode
}
