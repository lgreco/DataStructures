/**
 * A simple linked list class
 */
public class SimpleLinkedList {

    /** The beginning of the list */
    private SimpleNode head;

    public boolean isEmpty() {
        return head==null;
    }
    public boolean isNotEmpty() { return head != null; }

    public void setHead(SimpleNode node) {
        this.head = node;
    }

    public SimpleNode getHead() {
        return head;
    }


    /**
     * Method to add a node to a list.
     * @param content String content of the new node
     */
    public void addNode(String content) {
        SimpleNode newNode = new SimpleNode(content); // Prepare the new node to add.
        if (this.isEmpty()) { // List is empty ...
            this.setHead(newNode); // ... make new node the list's head.
        } else { // The list is not empty ...
            SimpleNode current = this.getHead(); // ... so, let's prepare to traverse it, ...
            while (current.hasNext()) { // ... until we find a node whose next pointer is null ...
                current = current.getNext(); // .. and its next node will be the last node of the list.
            }
            current.setNext(newNode); // We make the new node, the next node of what was just now the last node.
        }
    } // method addNode


    /**
     * Stylized printing of a list, with tabulated content
     */
    public void displaySLL() {
        final String NEWLINE = "\n";
        final String TAB = "\t";
        final String STRING_DIRECTIVE = "%s";
        if (this.isEmpty()) {
            System.out.printf("\n\nThe list is empty.\n\n");
        } else {
            System.out.printf("\n\nThe contents of the list are:");
            String style = NEWLINE+STRING_DIRECTIVE; // Initialize the styling string for printf
            int count = 1; // Start a count of nodes, to tabulate accordingly.
            SimpleNode current = this.getHead(); // Get ready to traverse list beginning from its head.
            while (current.hasNext()) {
                System.out.printf(style, current.getContent());
                current = current.getNext();
                style = NEWLINE + TAB.repeat(count) + STRING_DIRECTIVE;
                count++;
            }
            style += NEWLINE+NEWLINE;
            System.out.printf(style, current.getContent());
        }
    } // method displaySLL

    public String getMiddleNodeContent() {
        String middle = "LIST IS EMPTY";
        if (this.isNotEmpty()) {
            SimpleNode fast = this.getHead();
            SimpleNode slow = this.getHead();
            while (fast.hasNext() && fast.getNext().hasNext()) {
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
            middle = String.format("MIDDLE NODE CONTENTS: %s",slow.getContent());
        }
        return middle;
    }


    /**
     * Method to add list a at the end of list b. The method is static because it does not have to be invoked
     * by a SimpleLinkedList object.
     * @param a List to be appended
     * @param b List to append to.
     */
    public static void join(SimpleLinkedList a, SimpleLinkedList b) {
        if (a.isNotEmpty() && b.isNotEmpty()) { // (!a.isEmpty()) && (!b.isEmpty()))
            // Find last node of b
            SimpleNode current = b.getHead();
            while (current.hasNext()) {
                current = current.getNext();
            }
            // current is now the last node of b
            current.setNext(a.getHead()); // last node of b now points to head of a.
        }
    } // method join


    /*
    If, for any reason, we prefer to invoke the join method from an existing SimpleLinkedList object, e.g.,
       a.join(b)
    we can implement the instance method below instead of the static method above.

    public void join(SimpleLinkedList b) {
        // Find last node of b
        SimpleNode current = b.getHead();
        while (current.hasNext()) {
            current = current.getNext();
        }
        // current is now the last node of b
        current.setNext(this.getHead());
    }
     */


    public static void main(String[] args) {
        SimpleLinkedList a = new SimpleLinkedList();
        a.addNode("Summit");
        a.addNode("Joliet");
        a.addNode("Dwight");
        a.addNode("Pontiac");

        SimpleLinkedList b = new SimpleLinkedList();
        b.addNode("Chicago");

        a.displaySLL();
        b.displaySLL();
        System.out.println(a.getMiddleNodeContent());

        SimpleLinkedList.join(a,b); // join a and b
        b.displaySLL(); // show the new b list
        System.out.println(b.getMiddleNodeContent());

    } // main method

} // class SimpleLinkedList
