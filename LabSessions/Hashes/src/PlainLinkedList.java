/**
 * Simple Linked List class
 */
public class PlainLinkedList {

    /** The head node of the linked list */
    private PlainNode head;

    /** Tail node allows us to make O(1) insertions */
    private PlainNode tail;

    /** Count of nodes in currently present in this list */
    private int countOfNodes;


    /**
     * Adds a new node at the end of the linked list
     * @param data String with data to include in the new node
     */
    public void addToLinkedList(String data) {
        // Instantiate the new node
        PlainNode newNode = new PlainNode(data);
        // Determime where to place it
        if (this.head == null) {
            this.head = newNode;
            this.countOfNodes = 1;
        } else {
            tail.setNext(newNode);
            this.countOfNodes++;
        }
        // Update the last node of the list
        this.tail = newNode;
    } // method addToLinkedList

    public int getCountOfNodes() {
        return countOfNodes;
    }

    /**
     * Method to get the head node of a list
     * @return PlainNode at beginning of a linked list
     */
    public PlainNode getHead() {
        return head;
    } // method getHead


    /**
     * Determines if a node in the list contains a given string
     * @param data String to search for
     * @return true if linked list contains node with String data
     */
    public boolean contains(String data) {
        // Assume string not found
        boolean found = false;
        // Prepare to explore list only if it is not empty
        if (this.head != null) {
            PlainNode current = head;
            do {
                found = current.getData().equals(data);
                current = current.getNext();
            } while (!found && current != null);
        }
        return found;
    } // method contains

} // class PlainLinkedList
