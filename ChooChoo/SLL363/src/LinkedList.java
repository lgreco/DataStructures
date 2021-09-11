/**
 * Chains Nodes in single direction.
 */
public class LinkedList {

    private Node head;

    private int elegantSteps;
    private int efficientSteps;

    public LinkedList() {
        this.head = null;
        this.elegantSteps = 0;
        this.efficientSteps = 0;
    }

    /**
     * Adds new node to end of list.
     * @param content String content of new node
     */
    public void addNode(String content) {
        Node newNode = new Node(content);
        if (head == null) { // If list is empty new node becomes its head.
            head = newNode;
        } else { // If list is not empty, find last node
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode); // # New node goes after last node.
        }
    } // method addNone


    /**
     * Prints contents of list
     */
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println("--> " + current.getContent());
                current = current.getNext();
            }
        }
    } // method printList


    /**
     * Reports number of nodes in present list
     * @return int count of nodes in a list
     */
    public int countNodes() {
        int count = 0;
        if (head != null) {
            Node current = head;
            while (current != null) {
                count++;
                current = current.getNext();
            }
        }
        return count;
    } // method countNodes


    /**
     * Counts common nodes between two lists.
     *
     *         The function returns the number of common nodes between the two
     *         lists. It also returns the number of steps it took to count the
     *         number of common nodes. We use that return value (steps) to measure
     *         the performance of this function.
     *
     * @param other LinkedList to compare current list with
     * @return int count of common nodes between this and othe list
     */
    public int countCommonNodes(LinkedList other) {
        int count = 0;
        elegantSteps = 0;
        if (this.head != null && other.head != null) {
            Node thisCurrent = this.head;
            while (thisCurrent != null) {
                Node otherCurrent = other.head;
                while (otherCurrent != null) {
                    elegantSteps++;
                    if (thisCurrent.getContent().equals(otherCurrent.getContent()))
                        count++;
                    otherCurrent = otherCurrent.getNext();
                }
                thisCurrent = thisCurrent.getNext();
            }
        }
        return count;
    } // method countCommonNodes


    /**
     * Determines intersection of lists by count of common nodes
     *
     *         The function returns true/false to indicate if the two lists
     *         intersect. It also returns the number of steps it took its
     *         helper method to count the number of common nodes between the
     *         two lists. We use that return value (steps) to measure the
     *         performance of this function.
     *
     * @param other LinkedList to compare with
     * @return true if they intersect
     */
    public boolean intersectionByCount(LinkedList other) {
        return countCommonNodes(other) > 0;
    } // method intersectionByCount


    /**
     * Checks if present list intersects with other list.
     *
     *         The function returns true/false to indicate if the two lists
     *         intersect. It also returns the number of steps it took to count
     *         the number of common nodes between the two lists. We use that
     *         return value (steps) to measure the performance of this function.
     *
     * @param other LinkedList to compare present list with
     * @return true if they intersect
     */
    public boolean intersects(LinkedList other) {
        efficientSteps = 0;
        boolean intersectionFound = false;
        if (this.head != null && other.head != null) {
            boolean keepGoing = true;
            Node thisCurrent = this.head;
            while (keepGoing && thisCurrent != null) {
                Node otherCurrent = other.head;
                while (keepGoing && otherCurrent != null) {
                    efficientSteps++;
                    if (thisCurrent.getContent().equals(otherCurrent.getContent())) {
                        keepGoing = false;
                        intersectionFound = true;
                    }
                    otherCurrent = otherCurrent.getNext();
                }
                thisCurrent = thisCurrent.getNext();
            }
        }
        return intersectionFound;
    } // method intersects

    /* Automagically generated accessors */

    public int getElegantSteps() {
        return elegantSteps;
    }

    public int getEfficientSteps() {
        return efficientSteps;
    }
}
