/**
 * A simple linked list, produced by Node objects linked together.
 */
public class LinkedList {

    /** The entry point to the list */
    private Node head;


    /**
     * Adds a new node at the end of the linked list. This is the standard list
     * behavior we saw in the example with the TrainLine class.
     *
     * @param payload String with data to store in new node.
     */
    public void addLast(String payload) {
        // Create the new node object to add to the list.
        Node nodeToAdd = new Node(payload);
        // This may be the first node in the list.
        if (this.head == null) {
            // If list is empty, make this the head node.
            this.head = nodeToAdd;
        } else {
            // List is not empty. Find where it ends by traversing it.
            Node current = this.head;
            // Follow the .next pointers. Loop stops at last node.
            while (current.hasNext()) {
                current = current.getNext();
            }
            // At present current .next is null. Set it to new node.
            current.setNext(nodeToAdd);
            // New node was created with its next set to null, so that makes
            // it now the last node. We are done!
        }
    }  // method addLast


    /**
     * Removes the first node from a list and returns its payload contents.
     *
     * @return String with payload of deleted node or null if list is empty.
     */
    public String deleteFirst() {
        String deletedPayload = null;
        // Make sure the list is not empty
        if (this.head != null) {
            // get payload of node to remove
            deletedPayload = this.head.getPayload();
            // Node after present head.
            Node aftedHead = this.head.getNext();
            // Break the pointer before head (to be deleted) and its next node
            this.head.setNext(null);
            // Make the node after the head we are deleting, the new head
            this.head = aftedHead;
        }
        return deletedPayload;
    }  // method deleteFirst


    /**
     * Adds a new node at the beginning of the list.
     *
     * @param payLoad String with data to store in new node.
     */
    public void addFirst(String payLoad) {
        // Create the new node object to add to the list.
        Node nodeToAdd = new Node(payLoad);
        // This may be the first node in the list.
        if (this.head == null) {
            // If list is empty, make this the head node.
            this.head = nodeToAdd;
        } else {
            // List already has a head. Make that head the next node from the
            // new node we are adding.
            nodeToAdd.setNext(this.head);
            // Designate that new node as the head of the list.
            this.head = nodeToAdd;
        }
    }  // method addFirst


    /**
     * String representation of the object.
     * @return String representation of the object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            sb.append("This list is empty");
        } else {
            sb.append("The contents of the list are:\n");
            Node current = this.head;
            while (current.hasNext()) {
                sb.append(String.format("%s, ", current.getPayload()));
                current = current.getNext();
            }
            sb.append(current.getPayload());
        }
        return sb.toString();
    }  // method toString
}
