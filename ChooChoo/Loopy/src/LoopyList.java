/**
 * Simple linked list to illustrate loops.
 */

public class LoopyList {

    /** The list's head node. Every node can be found by traversing the list from the head */
    Node head;

    /**
     * BAD DESIGN CHOICE. Allowing users to add node objects to the list. This method may be necessary for the
     * programmer-developer -- if so, make it private so that programmer-users cannot access it. These users
     * should be allowed access only to addNode method where they specify the name of the station. Users should not
     * be able to specify the value of the pointer next.
     *
     */
    void addNode(Node node) {
        if (head==null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    } // method addNode

    /**
     * This method should be public allowing users to create a node by specifying its name and leaving the
     * class, through its design, to determine where this node will be placed: we want it at the end and we
     * want its next pointer to be null.
     *
     * @param content
     */
    void addNode(String content) {
        addNode(new Node(content,null));
    } // method addNode


    /**
     * Method to print all nodes in a list. If the list has a loop, this method will run for ever.
     */
    void printList() {
        if (head==null) {
            System.out.printf("\n\nYour list is empty.");
        } else {
            Node current = head;
            System.out.printf("\n\nThe contents of your list are:");
            while (current.next != null) {
                System.out.printf("\n%s", current.content);
                current = current.next;
            }
            System.out.printf("\n%s (last node)\n", current.content);
        }
    } // method printList

    /**
     * Method to determine if a list has a loop.
     *
     * @return true if list has loop; false otherwise.
     */
    boolean hasLoop() {
        boolean result = false;
        // YOUR CODE HERE
        return result;
    } // method hasLoop
} // class LoopyList
