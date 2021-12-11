package ChooChoo.Loopy.src;

import java.util.ArrayList;

/**
 * Simple linked list to illustrate loops.
 */

public class LoopyList {

    /** The list's head node. Every node can be found by traversing the list from the head */
    LLNode head;

    /**
     * BAD DESIGN CHOICE. Allowing users to add node objects to the list. This method may be necessary for the
     * programmer-developer -- if so, make it private so that programmer-users cannot access it. These users
     * should be allowed access only to addNode method where they specify the name of the station. Users should not
     * be able to specify the value of the pointer next.
     *
     */
    void addNode(LLNode LLNode) {
        if (head==null) {
            head = LLNode;
        } else {
            LLNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = LLNode;
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
        addNode(new LLNode(content,null));
    } // method addNode


    /**
     * Method to print all nodes in a list. If the list has a loop, this method will run for ever.
     */
    void printList() {
        if (head==null) {
            System.out.printf("\n\nYour list is empty.");
        } else {
            LLNode current = head;
            System.out.printf("\n\nThe contents of your list are:");
            while (current.next != null) {
                System.out.printf("\n%s", current.content);
                current = current.next;
            }
            System.out.printf("\n%s (last node)\n", current.content);
        }
    } // method printList

    /**
     * Method to determine if a list has a loop. The method uses an arraylist to keep track of the nodes as it
     * traverses a linked list. If it reaches a node that has been traversed before, it means that the
     * linked list has a loop. This is, admittedly, a lazy technique because it delegates some effort to the
     * ArrayList. Specifically, the contains method forces a scan of the entire arraylist. What appears as a
     * single statement here can be an expensive computation.
     *
     * The method is guaranteed to work for solitary loops, e.g.
     * A -> A            or A -> B -> B
     *
     * @return true if list has loop; false otherwise including the case the list is empty.
     */
    boolean hasLoop() {
        boolean loopFound = false; // Result of the search; let's be hopeful and expect no loop to be found
        if (head != null) { // List is not empty.
            ArrayList<LLNode> visited = new ArrayList<>(); // Keeps track of traversed nodes
            LLNode current = head; // Start scanning the list from its head
            while (!loopFound && current != null) { // Traverse until loop found or reach end of linked list.
                if (visited.contains(current)) { // if current node has been visited before ...
                    loopFound = true; // ... signal that a loop has been found ...
                } else { // ... otherwise, ...
                    visited.add(current); // ... mark the current node as visited and ...
                    current = current.next; // .. advance to the next one.
                }
            }
        }
        return loopFound;
    } // method hasLoop


    /**
     * This method finds loops based on Floyd's Cycle Detection. This is part of an algorithm for shortest paths
     * in graphs, so it's not trivial though it appears easy in its description. The technique uses two traversals,
     * one slow, one fast, if there is a loop in the linked list, the fast moving traversal will eventually catch up
     * with the slow moving one. As soon as we detect that, we declare a loop. Notice that this technique may require
     * us to go around the loop a couple of times before the slow and fast moving parts catch up.
     *
     * @return true if list has loop; false otherwise including the case the list is empty.
     */
    boolean hasLoop2() {
        boolean loopFound = false; // Being optimistic, we assume no loop is expected
        if (head!=null && head.next !=null) { // Perform the search if the list is not empty and its head points somewhere
            LLNode tortoise = head; // slow moving traversal
            LLNode hare = head.next; // fast moving traversal
            while (!loopFound && tortoise != null && hare.next.next != null) {
                loopFound = tortoise.equals(hare); // If slow and fast parts catch up it's time to end the while loop.
                tortoise = tortoise.next; // slow moving part advances one node at a time.
                hare = hare.next.next; // fast moving part advances two nodes at a time.
            }
        }
        return loopFound;
    } // method hasLoop2
} // class LoopyList
