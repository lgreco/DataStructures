/**
 * A simple double-linked list.
 *
 *              +---+   next     +---+          +---+
 *              |   |  ------->  |   | ... ---> |   | ---> [null]
 *  [null] <--- |   |  <-------  |   | <--- ... |   |
 *              +---+  previous  +---+          +---+
 *
 * Each node has pointers to a next and a previous node. A double-linked list
 * has a head node. It ends to the right with a node whose next pointer is null.
 *
 * Nodes are defined in class Node.
 */
public class DoubleLinkedList {

    /** The head node of a double linked list */
    Node head;


    /**
     * Method to add a Node to the list. If the list is empty, the node
     * becomes its head; otherwise it's placed at the end. Connections are
     * made so that the last node's next pointer connects to the newly
     * added node; and the newly added node's previous pointer connect to
     * the (now former) last node.
     *
     * @param content The string content of the new node to add
     */
    public void add(String content) {
        Node newNode = new Node(content); // Create node with given content
        if (head==null) { // List empty?
            head = newNode; // new node becomes head
        } else { // List not empty?
            Node current = head; // Start at head; find last node
            while (current.hasNext()) { // Keep going while current node has a next one
                current = current.getNext(); // Advance to the next node
            } // Loop exits when node has null next pointer: we are at the last node!
            /*
            current is now at the last node. That's where we want to add the newNode.
            Adding a newNode to a double-linked list means two things, shown below.

              (last)
            +---------+                    +---------+
            |         |------- next ---->  |         |--- next --> [ null ]
            | current |                    | newNode |
            |         |   <-- previous ----|         |
            +---------+                    +---------+

            First, the next pointer of current (ie the last node) should be assigned
            to the newNode.

            Second, the previous pointer of the newNode should be assigned to the current.

            Notice that newNode's next pointer is null (we affirm this null in the basic
            Node constructor). This null pointer is the evidence we need to recognize the
            newly added node as the last node in the chain, from now on.
             */
            current.setNext(newNode); // current.next:  | current |---->  | newNode|
            newNode.setPrevious(current); // newNode.previous:  | current |   <----| newNode |
        }
    } // method add
} // class DoubleLinkedList
