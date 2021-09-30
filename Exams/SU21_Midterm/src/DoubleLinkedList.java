/**
 * A simple double-linked list.
 *
 *              +---+       next         +---+              +---+
 *              |   |      ------->      |   |   ... --->   |   | ---> [null]
 *  [null] <--- |   |      <-------      |   |   <--- ...   |   |
 *              +---+      previous      +---+              +---+
 *
 * Each node has pointers to a next and a previous node. A double-linked list
 * has a head node. It ends to the right with a node whose next pointer is null.
 *
 * Nodes are defined in class Node.
 */
public class DoubleLinkedList {

    /*
    CHANGE THE FOLLOWING STRING TO
      PEACH ....... IF YOU ARE SUBMITTING SOLUTIONS TO PROBLEMS 1 + 2
      APRICOT ..... IF YOU ARE SUBMITTING SOLUTIONS TO PROBLEMS 1 + 3 + 4 + 5
      SOLUTIONS ... TO PUBLISH SOLUTIONS AFTER DEADLINE (FOR LEO ONLY)
     */
    public final String FLAVOR = "SOLUTIONS"; // MUST BE PEACH OR APRICOT OR SOLUTIONS


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
        if (head==null) { // head node null means there is nothing yet in our list (ie list is empty)
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


    /**
     * PROBLEM 1
     *
     * DEVELOP THE METHOD display() SO THAT IT TRAVERSES A DOUBLE-LINKED LIST FROM
     * THE HEAD NODE TO THE RIGHTMOST NODE AND THEN BACK TO HEAD, PRINTING THE
     * STRING CONTENT OF EACH NODE ALONG THE WAY. THE METHOD SHALL USE THE NEXT
     * POINTERS TO MOVE TO THE RIGHT AND THE PREVIOUS POINTERS TO MOVE TO THE LEFT.
     * ASSUME THAT EACH NODE IS DOUBLE-LINKED, I.E., IT HAS A NON-NULL NEXT NODE AND
     * A NON-NULL PREVIOUS NODE. THE ONLY EXCEPTIONS ARE THE HEAD NODE THAT HAS A
     * NULL PREVIOUS, AND THE RIGHTMOST NODE THAT HAS A NULL NEXT.
     *
     * THE FORMAT OF THE METHOD'S OUTPUT SHALL BE
     *
     *   [A] [B] ... [B] [A]
     *
     * EVERY NODE APPEARS TWICE IN THIS DISPLAY. ONLY THE RIGHTMOST NODE MAY
     * APPEAR ONCE.
     */
    public void display() {
        if (head == null) { // is list empty?
            System.out.println("\nThe list is empty.\n");
        } else { // list is not empty
            Node current = head; // start at the top
            /*
            We use a single while-loop to move forward and backwards. The loop
            is controlled by boolean:traverse. It remains true until the
            traversal is on backwards (ie follows the previous pointers) and
            the current node has a null previous (which is a sign that we've
            reached the head of the list again).

            Direction of traversal is determined by boolean:forward. As long
            as it is true, we move to the current node's next node. When
            boolean:forward is false, we move to the current node's previous
            node. Boolean:forward changes from true to false when we encounter
            a node whose next pointer is null.
             */
            boolean traverse = true; // controls the while loop
            boolean forward = true; // determines direction of traversal
            System.out.println();
            while (traverse) {
                if (!current.hasNext()) { // Notice the "!". We reached rightmost node
                    forward = false; // change direction of traversal
                }
                System.out.printf("[%s] ", current.getContent()); // print contents of node
                /*
                Determine which pointer to follow. We have two choices: next
                (traversing forward) and previous (traversing backwards).
                Boolean:forward determines the direction of traversal.

                And then determine if it is time to end the loop.
                 */
                current = (forward) ? current.getNext() : current.getPrevious();
                /*                    -------^--------    -------^-------------
                The ternary           follow the          follow the pointer
                operator allows       pointer to the      to the previous node
                us to write an        next node, if       if boolean:forward
                if-else bloc          boolean:forward     is false.
                in one line!          is true.
                 */
                traverse = forward || current.hasPrevious(); // time to exit the loop?
            } // while loop
            /*
            Done with the loop but we have one last node to process, so here it is.
            This is the head node. We started from the head node, moved forward until
            the rightmost node, reversed our traversal, and landed at the head node
            again.
             */
            System.out.printf("[%s] ", current.getContent());
        } // if head==null
    } // method display


    /**
     * PROBLEM 2
     *
     * DEVELOP THE METHOD remove BELOW SO THAT IS FINDS THE FIRST NODE IN THE
     * LIST THAT CONTAINS STRING content, REMOVES IT, AND RETURNS IT TO THE
     * CALLING PART OF THE PROGRAM.
     *
     * @param whatWeAreLookingFor Contents of node to remove
     * @return removed Node object; null if no such node exists in list
     */
    public Node removeNode(String whatWeAreLookingFor) {
        Node removedNode = null; // assign null because we may not find what we are looking for
        /*
        Determine if the list is empty. If it is empty, skip to the end of the method
        and return Node:removeNode which, right now, is null.

        If the list is not empty (ie if head is not null), then we have two possibilities
        to consider: if we are lucky, it's the head node that needs to be removed.
        Otherwise we have to scan the list and find where is (if it exists) the node we
        wish to remove.
         */
        if (head != null) { // list is not empty
            if (head.getContent().equals(whatWeAreLookingFor)) {
                /*
                Oh joy, oh rapture unforeseen,         Lyrics by:
                The clouded sky is now serene,                W. S. Gilbert and
                the head node we contravene!                  Leo Irakliotis

                The head node contains String:whatWeAreLookingFor and we need to
                look no further. Just remove the head node! Removing the head
                node however can be a bit tricky. If this is the only node in the
                list, deleting the head node is simple: we set head=null and the
                list is now empty. If there is a node after the head, we need to
                make that node the new head of the list.
                 */
                removedNode = head; // copy to return at end of method
                if (head.hasNext()) { // head has a node after it; that node shall become head
                    head = head.getNext(); // assign new head node
                    head.getPrevious().setNext(null); // former head node's next pointer nullified
                    head.setPrevious(null); // current head must not have previous
                } else { // in case of single node list
                    head = null; // and the list is now empty
                }
            } else {
                /*
                If the head node is not the one we were looking for, we have to scan the list now and find which node
                to delete, anticipating that there may be no such node in the list.

                The strategy here is to scan the list until we find what we are looking for or until we get to the
                penultimate node. After the loop below, we are at a Node:current which could be one of the following:

                  * the last node but without what we are looking for,
                    so we cannot remove it in this case;

                  * the last node with what we are looking for, and can be removed,

                  * some other node between first and last that has what we are
                    looking for and we can remove it.

                  The last two scenarios are the same: we are at some node (could be the last, could be any other node
                  after the head node) that contains what we are looking for, and therefore must be removed.

                  The first scenario is when we declare our search unsuccessful. There is no node in the list with what
                  we are looking for.
                 */
                Node current = head;
                while (current.hasNext() && !current.getContent().equals(whatWeAreLookingFor)) {
                    current = current.getNext();
                }
                // Time to decide if Node:current can be removed or not.
                if (current.getContent().equals(whatWeAreLookingFor)) {
                    /*
                    Node:current contains what we are looking for. So this is the node ot remove. During removal we
                    shall check if this is also the rightmost node, ie, the node whose next pointer is null.
                    If it is NOT, then we have to bridge the gap between the nodes before and after the one we are
                    removing. In other words, we are looking to take the following scenario:

                        (P)revious                           (C)urrent                             (N)ext

                        | node    |                                                           |    node |
                        | before  |---- next ----->         | node to |---- next ----->       |   after |
                        | node to |        <--- previous ---| remove  |      <--- previous ---| node to |
                        | remove  |                                                           |  remove |

                    and convert it to this:

                        | node    |                                                           |    node |
                        | before  |----------- next ------------------------------------->    |   after |
                        | removed |    <---------------------------------- previous ----------| removed |
                        | node    |                                                           |    node |
                     */
                    removedNode = current; // set the return value;
                    if (current.hasNext()) { // not the last node
                        current.getPrevious().setNext(current.getNext()); //   P -> C -> N    becomes P -> N
                        current.getNext().setPrevious(current.getPrevious()); //   P <- C <- N    becomes P <- N
                    } else { // it is the last node that we are removing
                        current.getPrevious().setNext(null); //   P -> C -> NULL    becomes P -> NULL, ie P is now last
                        current.setPrevious(null); //   P <- C   becomes P ... redundant but just in case.
                    }
                }
            } // if node to remove is head node
        } // if head == null
        return removedNode;
    } // method removeNode


    /**
     * PROBLEM 3
     *
     * DEVELOP A METHOD THAT COUNTS THE NUMBER OF NODES IN A LIST
     *
     * @return non negative integer with number of nodes.
     */
    public int countNodes() {
        int count = 0;
        if (head != null) { // count only if list not empty
            Node current = head;
            while (current.hasNext()) {
                count++;
                current = current.getNext();
            }
            count++; // for the last node
        }
        return count;
    } // method countNodes


    /**
     * PROBLEM 4
     *
     * DEVELOP A METHOD TO ARRANGE NODE CONTENT IN REVERSE ORDER
     *
     * @return String with node contents in reverse order
     */
    public String toString() {
        String listInReverse = "";
        if (head==null) {
            listInReverse += "List is empty";
        } else {
            /*
            As we traverse the list forward, ie, following the next pointers, we write the nodes we are visiting,
            beginning at the end of the string. Every new node is added on top of the just visited node. This is
            the equivalent of traveling from Chicago to Summit to Joliet, and writing the names of the stations
            as we visit them on a piece of paper, but beginning from the bottom:

            First            Second           Third
            station          station          station

                                              Joliet
                             Summit           Summit
            Chicago          Chicago          Chicago
             */
            Node current = head;
            while (current.hasNext()) {
                listInReverse = String.format("[%s] %s", current.getContent(),listInReverse);
                /* if the use of String.format() is confusing, the line above is the equivalent of
                listInReverse = "[" + current.getContent() + "] " + listInReverse;
                 */
                current = current.getNext();
            }
            listInReverse = String.format("[%s] %s", current.getContent(),listInReverse); // last node
        }
        return listInReverse;
    } // method toString


    /**
     * PROBLEM 5
     *
     * DEVELOP A METHOD TO ADD NODE TO LIST ONLY IF THERE IS NO OTHER NODE
     * WITH SAME CONTENT
     *
     * @param s String content of new node
     * @return true if addition successful; false otherwise
     */
    public boolean addUnique(String s) {
        boolean success = false, exists = false;
        Node newNode = new Node(s);
        /*
        Our strategy here has two parts: first, we check to see if the head node is empty (null). If it is,
        we just create a new node and make it head. No need to check for uniqueness, because the list is
        empty, so whatever we add first is unique.

        But if the head is not null, the list is not empty, and we must check for uniqueness first. To do so,
        we start at the head node and scan the entire list. If a existing node matches the contents we want to
        add we flag its presence with the boolean:exists.

        After scanning the list for an existing node with the data we wish to add, we decide whether or not to add
        the new node. If exists is set to true, we do not proceed beause there is already a node with the same content.
         */
        if (head==null) { // empty list
            head = newNode; // anything we add is unique
            success = true; // that was easy!
        } else {
            Node current = head;
            /*
            Scan the list to see if there is already a node with the content we wish to add.
             */
            while (current.hasNext()) {
                if (current.getContent().equals(s)) {
                    exists=true;
                }
                current = current.getNext();
            }
            /*
            The while loop above ends at the penultimate node, so, don't forget to check the last node too.
             */
            if (current.getContent().equals(s)) {
                exists = true;
            }
            /*
            At this point we now if an existing node contains the data we wish to add. If such node exists, the data
            we are trying to add are not unique, and no new node shall be added. The method will return boolean:success
            with a false value. Otherwise, the new node with the unique data will be added at the end of the list.
             */
            if (!exists) {
                current.setNext(newNode);
                newNode.setPrevious(current);
                success = true;
            }
        }
        return  success;
    } // method addUnique
} // class DoubleLinkedList