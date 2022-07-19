public class LinkedList271SU22_FixedTime {

    /** Only the head and tail nodes are visible; everything else by sequential access */
    private Node head;
    private Node tail;


    /** Default constructor */
    public LinkedList271SU22_FixedTime() {
        this.head = null;
        this.tail = null;
    }


    /** Simple accessor for the list's head */
    public Node getHead() {
        return head;
    }  // method getHead


    /**
     * Adds a node to the end of the linked list. If list is empty, new node
     * becomes its head. Otherwise, the new node is added after the tail one.
     * This operation is done in constant time. There is no need to traverse
     * the list and find its last node. Class variable tail points always to
     * the last node.\
     *
     * @param newNode Node to add to the list.
     */
    public void add(Node newNode) {
        if (this.head == null) {
            // List is empty; make new node its head node.
            this.head = newNode;
        } else {
            // List not empty; add new node after the current tail
            this.tail.setNext(newNode);
        }
        // update the tail
        this.tail = newNode;
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
    public LinkedList271SU22_FixedTime reverse() {
        LinkedList271SU22_FixedTime reversed = new LinkedList271SU22_FixedTime();
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

}
