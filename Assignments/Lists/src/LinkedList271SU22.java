/*
Note 2022 07 26: class is modified to implement Comparable, in preparation for
the final exam for COMP 271 SU 22.
 */
public class LinkedList271SU22 implements Comparable<LinkedList271SU22> {
    /*                         ========================================
                               This is our contract that the class will
                               fulfill the requirements of the Comparable
                               interface.

             The comparable interface is described below:
             https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html

             It's a quite simple interface, requiring only one method.
     */

    /** Only the head is visible; everything else by sequential access */
    private Node head;


    /** Default constructor */
    public LinkedList271SU22() {
        this.head = null;
    }


    /** Simple accessor for the list's head */
    public Node getHead() {
        return head;
    }  // method getHead


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
     * Adds a node on the list, constructed with the supplied string.
     *
     * @param data String to store in node
     */
    public void add(String data) {
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            Node cursor = this.head;
            while (cursor.hasNext())
                cursor = cursor.getNext();
            cursor.setNext(new Node(data));
        }
    }  // method add


    /**
     * Adds a node after a specific node.
     *
     * @param newNode new node to add
     * @param afterNode node to add after
     */
    public void add(Node newNode, Node afterNode) {
        // Operate on a non-empty list
        if (this.head != null) {
            // Traverse the list to find the node after which we are inserting
            Node cursor = this.head;
            boolean keepGoing = true;
            while (cursor.hasNext() && keepGoing) {
                if (cursor == afterNode) {
                    // execute the insertion and stop the loop
                    Node nodeFollowing = cursor.getNext();
                    cursor.setNext(newNode);
                    newNode.setNext(nodeFollowing);
                    keepGoing = false;
                }
                cursor = cursor.getNext();
            }
            // Just in case the node we are looking for, is the last node
            if (keepGoing && cursor == afterNode) {
                cursor.setNext(newNode);
                // Make the inserted node, the last node.
                newNode.setNext(null);
            }
        }
    }  // method add


    /**
     * Sets a new head for the list.
     *
     * @param newHead node to become new head
     */
    public void setHead(Node newHead) {
        if (this.head == null) {
            this.head = newHead;
        } else if (this.head != newHead) {
            // condition to ensure that head doesn't point to itself -- will cause infinite loop
            // when other methods try to traverse the list.
            newHead.setNext(this.head);
            this.head = newHead;
        }
    }  // method setHead


    /**
     * Removes and returns the head node of a list and labels the next node as the list's new head.
     * If the removed node is the last one, the method sets the head to null, rendering the list empty.
     *
     * @return removed node.
     */
    public Node removeHead() {
        Node removed = null;
        if (this.head != null) {
            removed = this.head;
            this.head = (this.head.hasNext()) ? this.head.getNext() : null;
        }
        return removed;
    }  // method removeHead


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


    /**
     * String representation of this linked list.
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            sb.append("This list is empty.");
        } else {
            sb.append(head.getData());
            Node cursor = this.head.getNext();
            while (cursor != null) {
                sb.append(String.format(" -> %s", cursor.getData()));
                cursor = cursor.getNext();
            }
        }
        return sb.toString();
    }  // method toString


    /**
     * Creates a link that is the reverse of the invoking list
     *
     * @return reversed list
     */
    public LinkedList271SU22 reverse() {
        LinkedList271SU22 reversed = new LinkedList271SU22();
        if (this.head != null) {
            // first the end of the invoking list and make it the head of the returned list.
            Node cursor = this.head;
            while (cursor.hasNext())
                cursor = cursor.getNext();
            Node last = cursor;
            reversed.add(new Node(last));
            // Iterate over the invoking list, add its last node to the return list and
            // moving the last node closer to the beginning.
            while (last != this.head) {
                cursor = this.head;
                while (cursor.getNext() != last) {
                    cursor = cursor.getNext();
                }
                last = cursor;
                Node nodeToAdd = new Node(last);
                nodeToAdd.setNext(null);
                reversed.add(nodeToAdd);
                // last.setNext(null);
            }
            reversed.add(new Node(this.head));
            // reversed.head.setNext(null);
        }
        return reversed;
    }


    /**
     * Deletes a node from a linked list. The method assumes that the list has 4 or more nodes
     * and that the node to delete is either the first nor any of its last two nodes. This
     * assumption allows us to reach two nodes ahead when it's time to bypass the deleted node.
     *
     * @param nodeToDelete node to delete.
     */
    public void simpleDelete(Node nodeToDelete) {
        // Operate only on non empty lists
        if (this.head != null) {
            // Switch to stop the list traversal when node is deleted
            boolean nodeFound = false;
            // Traversing cursor
            Node cursor = this.head;
            while (cursor.hasNext() && !nodeFound) {
                // It's ok to use == between objects (we are not comparing their contents)
                if (cursor.getNext() == nodeToDelete) {
                    // Safe to look for .next.next because we are not deleting either of last two nodes.
                    cursor.setNext(cursor.getNext().getNext());
                    // Stop the loop
                    nodeFound = true;
                }
                cursor = cursor.getNext();
            }
        }
    }  // method simpleDelete



    // ================ dummies to satisfy test classes ===============
    public boolean contains(String string) { return true; }
    public void swapNodes(Node a, Node b) {}

}
