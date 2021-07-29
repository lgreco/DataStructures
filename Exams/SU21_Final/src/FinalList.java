

/**
 * Simple linked list class. The class contains an inner class with the Node object, to keep things compact. In
 * the interest of compactness, no accessors and mutators are offered. Also in the interest of brevity, access
 * modifiers (public, private, etc) are omitted.
 */
class FinalList {

    /**
     * Inner class with Node objects that are used to build the list. This is a simple node, with a String
     * for content and, of course, a pointer to the next node. A simple constructor is also provided.
     */
    class Node {
       String content;
       Node next;

       /** Partial constructor */
       Node(String content) {
           this.content = content;
       }
    } // Inner class Node


    /** The head of the FinalList */
    Node head;


    /**
     * Method to add node to list. The method checks to see if the list is emtpy (head==null). If it is empty,
     * makes the new node the head of the list. Otherwise, it starts from the head, traverses the list to the
     * end, finds that last node, and adds the new node after the last.
     *
     * @param withContent String content of the new node.
     */
    void addNode(String withContent) {
        Node newNode = new Node(withContent); // Prep the new node.
        if (head==null) { // List empty? Oh, goodie!
            head = newNode;
        } else { // List is not empty. Let's traverse.
            Node current = head; // Start from the head.
            while (current.next != null) { // Stop short of the last node.
                current = current.next;
            } // And now current *is* the last node.
            current.next = newNode; // Make the new node to be after the last node.
        }
    } // method addNode


    /**
     * Method to tell if the invoking list intersects the passed list. The lists intersect if they have at least
     * one node in common.  Commonality is defined as two nodes with the same content.
     *
     * Usage:      FinalList a; FinalList b
     *             a.intersects(b)
     *             ^            ^
     *             |            |
     *             |            +--- passed (as argument) list
     *             |
     *             +---------------- invoking list
     *
     * @param finalList passed (as argument) list
     * @return true if lists share at least one node; false otherwise.
     */
    boolean intersects(FinalList finalList) {
        boolean found = false; // Assume lists do not intersect.
        /* ADD YOUR CODE HERE */
        return found;
    } // method intersects


    /**
     * Method to count the number of common nodes between two lists. Commonality is defined as two nodes with the
     * same content.
     *
     * Usage:      FinalList a; FinalList b
     *             a.countCommon(b)
     *             ^             ^
     *             |             |
     *             |             +--- passed (as argument) list
     *             |
     *             +----------------- invoking list
     *
     * @param finalList passed (as argument) list
     * @return int with number of common nodes; 0 if none.
     */
    int countCommon(FinalList finalList) {
        int count = -1; // Initialize count, expecting no common nodes between the lists.
        /* ADD YOUR CODE HERE */
        return count;
    } // method countCommon


    /**
     * Method to display the common nodes (their content to be specific) between the invoking list and the passed one.
     *
     * Usage:      FinalList a; FinalList b
     *             a.displayCommmonNodes(b)
     *             ^                     ^
     *             |                     |
     *             |                     +--- passed (as argument) list
     *             |
     *             +------------------------- invoking list
     *
     * @param finalList passed (as argument) list
     */
    void displayCommmonNodes(FinalList finalList) {
        /* REPLACE THE FOLLOWING LINE WITH YOUR CODE */
        System.out.printf("\ndisplayCommonNodes method not completed.");
    } // method displayCommmonNodes


    /** Driver and evaluation method *** MODIFYING THE CONTENTS OF THIS METHOD MAY LEAD TO WRONG RESULTS. */
    public static void main(String[] args) {

        FinalList route66States = new FinalList(); // States that Route 66 crosses
        route66States.addNode("California");
        route66States.addNode("Arizona");
        route66States.addNode("New Mexico");
        route66States.addNode("Texas");
        route66States.addNode("Oklahoma");
        route66States.addNode("Kansas");
        route66States.addNode("Missouri");
        route66States.addNode("Illinois");

        FinalList mississippiStates = new FinalList(); // States that the Mississippi River crosses
        mississippiStates.addNode("Minnesota");
        mississippiStates.addNode("Wisconsin");
        mississippiStates.addNode("Iowa");
        mississippiStates.addNode("Illinois");
        mississippiStates.addNode("Missouri");
        mississippiStates.addNode("Kentucky");
        mississippiStates.addNode("Tennessee");
        mississippiStates.addNode("Arkansas");
        mississippiStates.addNode("Mississippi");
        mississippiStates.addNode("Louisiana");

        FinalList route101States = new FinalList(); // States that Route 101 crosses
        route101States.addNode("California");
        route101States.addNode("Oregon");
        route101States.addNode("Washington");

        FinalList anEmptyList = new FinalList(); // An empty list.

        boolean route66_mississippi = route66States.intersects(mississippiStates);
        boolean route101_mississippi = route101States.intersects(mississippiStates);
        boolean empty_mississippi = anEmptyList.intersects(mississippiStates);
        boolean route66_route66 = route66States.intersects(mississippiStates);
        System.out.printf("\n\nIntersection tests" +
                "\n\tRoute66 and Mississippi: %b" +
                "\n\tRoute101 and Mississippi: %b" +
                "\n\tEmpty list and Mississippi: %b" +
                "\n\tRoute 66 and itself: %b" +
                "\n\tSUMMARY (must be true): >>> %B <<<",
                route66_mississippi, route101_mississippi, empty_mississippi, route66_route66, (route66_mississippi && !route101_mississippi && !empty_mississippi && route66_route66));

        route66_mississippi = (2 == route66States.countCommon(mississippiStates));
        route101_mississippi = (0 == route101States.countCommon(mississippiStates));
        empty_mississippi = (0 == anEmptyList.countCommon(mississippiStates));
        route66_route66 = (8 == route66States.countCommon(route66States));
        System.out.printf("\n\nCount tests" +
                "\n\tRoute66 and Mississippi: %b" +
                "\n\tRoute101 and Mississippi: %b" +
                "\n\tEmpty list and Mississippi: %b" +
                "\n\tRoute 66 and itself: %b" +
                "\n\tSUMMARY (must be true): >>> %B <<<\n",
                route66_mississippi, route101_mississippi, empty_mississippi, route66_route66, (route66_mississippi && route101_mississippi && empty_mississippi && route66_route66));

        route66States.displayCommmonNodes(mississippiStates);
        route101States.displayCommmonNodes(mississippiStates);
        anEmptyList.displayCommmonNodes(mississippiStates);
        route66States.displayCommmonNodes(route66States);

    } // method main

} // class FinalList
