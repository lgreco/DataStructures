public class LinkedList271SU22 {

    /** Only the head is visible; everything else by sequential access */
    private Node head;


    /** Default constructor */
    public LinkedList271SU22() {
        this.head = null;
    }


    /**
     * Adds a node to the end of the linked list. If list is empty, new node
     * becomes its head. Otherwise, the list is traversed in sequence, until
     * its last node is found. Then the new node is appended there.
     * @param newNode
     */
    public void add(Node newNode) {
        if (this.head == null) {
            // List is empty; make new node its head node.
            this.head = newNode;
        } else {
            // List not empty; start at head and traverse it to find last node
            Node cursor = this.head;
            while (cursor.hasNext()) {
                // Keep sliding to the next node until last node is found
                cursor = cursor.getNext();
            }
            // cursor is at last node; append new node to it.
            cursor.setNext(newNode);
        }
    }  // method add


    /**
     * Computes the number of nodes in the linked list.
     *
     * @return count of nodes
     */
    public int length() {
        // Assume list is empty
        int len = 0;
        // An empty list has a null head
        if (this.head != null) {
            // List is not empty, so it must have at least one node
            len = 1;
            // Set up cursor for traversal from node to node
            Node current = this.head;
            // Keep traversing as long as node has a next one
            while (current.hasNext()) {
                // Increment counter
                len++;
                // Slide to the next node
                current = current.getNext();
            }
        }
        return len;
    }  // method length

}
