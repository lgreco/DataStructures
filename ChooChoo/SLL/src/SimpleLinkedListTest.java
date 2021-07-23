import org.junit.jupiter.api.Assertions;

class SimpleLinkedListTest {

    /**
     * Test method for compareTo
     */
    @org.junit.jupiter.api.Test
    void compareTo() {

        /* Set up four testing lists; last one will be left empty */
        SimpleLinkedList a = new SimpleLinkedList();
        SimpleLinkedList b = new SimpleLinkedList();
        SimpleLinkedList c = new SimpleLinkedList();
        SimpleLinkedList d = new SimpleLinkedList();

        /* Add three nodes to this list */
        a.addNode("A");
        a.addNode("B");
        a.addNode("C");

        /* Add four nodes to this list */
        b.addNode("I");
        b.addNode("J");
        b.addNode("K");
        b.addNode("L");

        /* Add one node to this list */
        c.addNode("X");

        /* Test */
        Assertions.assertEquals(-1, a.compareTo(b)); // ODD compared to EVEN
        Assertions.assertEquals(-1, a.compareTo(d)); // ODD compared to empty list
        Assertions.assertEquals(0, a.compareTo(c));  // ODD compared to ODD
        Assertions.assertEquals(0, b.compareTo(d));  // EVEN compared to empty list

    }
}