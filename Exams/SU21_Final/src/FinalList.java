

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
        if ( this.head != null && finalList.head != null ) { // make sure neither list is empty
            /*
            The search technique below involves two nested while loops. The outer loop traverses the invoking list,
            one object at a time. The inner loop traversed the list passed to the method as an argument. The
            traversed nodes are named invokingCurrent and passedCurrent, respectively.

            For every node traversed in the outer loop, we traverse every node in the inner loop starting from its
            head. In other words, we compare each node of the invoking list to every node of the passed list, until
            we either find a match or we run out of nodes.

            Each loop ends when at least of these two conditions is satisfied:
              - the xCurrent node is null, i.e., we've reached the end of a list, or
              - an intersection has been found.
            Ending the loops when an intersection has been found allows us to save time. There is no reason to keep
            scanning the lists once we find the first intersection.
             */
            Node invokingCurrent = this.head; // Start the scan of the invoking list
            while (!found && invokingCurrent != null) { // The outer loop
                Node passedCurrent = finalList.head; // Start the scan of the passed list
                while (!found && passedCurrent != null) { // The inner loop
                    found = invokingCurrent.content.equals(passedCurrent.content); // are we there yet?
                    passedCurrent = passedCurrent.next; // move to the next node of passed list
                }
                invokingCurrent = invokingCurrent.next; // move to the next node of the invoking list
            }
        }
        return found;
        /*
        We could simplify this method to a single statement:
        return countCommom(finalList) > 0;
        that will return true if the count of common nodes is greater than 0. However, the count method has to go
        through every combination of nodes between the two lists. Our method above ends as soon as it finds the
        first common node, so it can be a bit faster.
         */
    } // method intersects


    /**
     * Method to count the number of common nodes between two lists. Commonality is defined as two nodes with the
     * same content. The method is based on two nested loops. The outer loop traverses the invoking list. The
     * inner loop traverses the passed list. For every node in the invoking list we perform one full traversal
     * of the inner list. Then we move to the next node of the invoking list and start all over again with the
     * passed list.
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
        int count = 0; // Initialize count, expecting no common nodes between the lists.
        Node invokingCurrent = this.head; // Start the scan of the invoking list
        while (invokingCurrent != null) { // The outer loop
            Node passedCurrent = finalList.head; // Start the scan of the passed list
            while (passedCurrent != null) { // The inner loop
                if (invokingCurrent.content.equals(passedCurrent.content)); {// are we there yet?
                    count++;
                }
                passedCurrent = passedCurrent.next; // move to the next node of passed list
            }
            invokingCurrent = invokingCurrent.next; // move to the next node of the invoking list
        }
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
        String toPrint = "";
        Node invokingCurrent = this.head;
        while (invokingCurrent != null) {
            Node passedCurrent = finalList.head;
            while (passedCurrent != null) {
                if (invokingCurrent.content.equals(passedCurrent.content)) {
                    toPrint = invokingCurrent.content + "\n" + toPrint;
                }
                passedCurrent = passedCurrent.next;
            }
            invokingCurrent = invokingCurrent.next;
        }
        toPrint = (toPrint.equals("")) ? "No common nodes found." : toPrint;
        System.out.println(toPrint);
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
