public class Parity extends SimpleLinkedList {

    public int compareTo(SimpleLinkedList providedList) {
        int presentParity = this.countNodes() % 2; // Integer remainder of present list count: 0 or 1
        int providedParity = providedList.countNodes() % 2; // Same here for provided list: 0 or 1
        return providedParity - presentParity; /* This will be -1, 0, or 1, depending on the parity values:
                                                  present-provided = -1 means present:0 (even); provided:1 (odd)
                                                  present-provided =  0 means that present:0 and provided:0 or
                                                                                   present:1 and provided:1
                                                  present-provided =  1 means present:1 (odd); provided:0 (even)
                                                  */
    } // method compareTo


    /**
     * Utility method that counts the nodes of a list. This method is private, i.e., not accessible from outside
     * this class. And, quite honest, not a very useful one, because it requires some time to compute its value.
     * A better way to obtain a node count is to add a int field in the linked list class, and update it every
     * time a node is added or removed. Then all we need is an accessor for that field.
     *
     * @return int count of nodes in list invoking the method.
     */
    private int countNodes() {
        int count = 0; // Initialize counter.
        if (isNotEmpty()) { // If list empty just return the initialized value (0).
            SimpleNode current = getHead(); // Start list traversal at head.
            while (current.hasNext()) { // Continue traversal while node is not last one.
                count++; // Increment count.
                current = current.getNext(); // Go to the next node.
            }
            count++; // Account for last node.
        }
        return count;
    } // method countNodes

}
