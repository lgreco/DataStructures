/**
 * Simple linked list.
 */
public class LL {

    /** Pointer to first node of the linked list. */
    private Node head;

    /** Pointer to last node of the linked list. */
    private Node tail;


    /**
     * Method to add node to linked list. In previous techniques, we supplied the add method
     * with the data we wanted to store in a node, create the node, and then added the node
     * to the list. Here, we supply the add method with a node that is created by another
     * part of the program. The supplied node is then added to the end of the list, superfast
     * because we know where that end is (at the tail pointer).
     *
     * @param node Node to add at the end of the list
     */
    public void add(Node node) {
        if (this.head == null) {
            // List is empty; make passed node the head (and the tail).
            this.head = node;
        } else {
            // List is not empty. Add passed node after the tail node
            this.tail.setNext(node);
        }
        // And in either case, make this newly added node, the tail of the list.
        this.tail = node;
    } // method add

    /********************** DO NOT CHANGE/EDIT ANYTHING ABOVE THIS LINE ******************/
    /*************************************************************************************/


    /**
     * Determine if a list contains loop. A list with a loop has no node that points to null.
     * Instead, the node that could have been the last node, points to another node instead of null.
     *
     * ********* THIS IS THE ONLY PART OF THE CODE THAT YOU CAN EDIT AND WORK ON. *********
     *
     * @return true if list has loop; false otherwise.
     */
    public boolean hasLoop() {
        boolean loopFound = false;
        // WRITE YOUR CODE HERE
        return loopFound;
    } // method hasLoop


    /*************************************************************************************/
    /********************** DO NOT CHANGE/EDIT ANYTHING BELOW THIS LINE ******************/

    /** Quick test reporting */
    private String testResult(boolean expected) {
        String output = "\tTest: ";
        if (this.hasLoop() == expected)
            output += "successful!";
        else
            output += "FAILED!";
        return output;
    } // method testResult


    /**
     * Evaluation code.
     */
    public static void main(String[] args) {
        // Nodes
        Node a = new Node("A"); Node i = new Node("I");
        Node b = new Node("B"); Node j = new Node("J");
        Node c = new Node("C"); Node k = new Node("K");
        Node d = new Node("D"); Node l = new Node("L");
        Node e = new Node("E"); Node m = new Node("M");
        Node f = new Node("F"); Node n = new Node("N");
        Node g = new Node("G"); Node o = new Node("O");
        Node h = new Node("H"); Node p = new Node("P");
        Node x = new Node("X"); Node y = new Node("Y");

        // test lists
        LL list1 = new LL();  // Has nodes a, b, c, d, e, f, g, h
        LL list2 = new LL();  // Has nodes i, j, k, l, m, n, o, p
        LL list3 = new LL();  // Empty list
        LL list4 = new LL();  // List with one node, x, and no loop
        LL list5 = new LL();  // List with one node, y, and a loop

        // Populate lists
        list1.add(a);   list2.add(i);
        list1.add(b);   list2.add(j);
        list1.add(c);   list2.add(k);
        list1.add(d);   list2.add(l);
        list1.add(e);   list2.add(m);
        list1.add(f);   list2.add(n);
        list1.add(g);   list2.add(o);
        list1.add(h);   list2.add(p);

        list4.add(x);   list5.add(y);

        // Create a loop in list 2: P points back to L
        p.setNext(l);
        // Create a loop in list 5: Y points back to itself
        y.setNext(y);

        // Report results
        System.out.println(list1.testResult(false));
        System.out.println(list2.testResult(true));
        System.out.println(list3.testResult(false));
        System.out.println(list4.testResult(false));
        System.out.println(list5.testResult(true));
    }
}