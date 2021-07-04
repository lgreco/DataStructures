/**
 * Implementation class with double-linked lists.
 */
public class Demo {
    /**
     * Main method creates an instance of the DoubleLinkedList, populates
     * it with single-letter Strings, and then applies the display method
     * (a midterm exam deliverable) to print the list going forward and
     * backwards.
     */
    public static void main(String[] args) {

        // Set up demo list
        DoubleLinkedList demo = new DoubleLinkedList();

        /*
         Being silly with for loops and char primitives while building a
         double-linked list with 5 nodes.
         */
        for (char c = 'A'; c < 'F'; c++) {
            demo.add(String.valueOf(c));
        }

        /*
        Call the display method. The output, when running the code, should be:

        [A] [B] [C] [D] [E] [D] [C] [B] [A]
         */
        demo.display();

        //Test removeNode method -- DO NOT MODIFY THE CODE BELOW
        System.out.printf("\n\nRemoval of non-existing node: %b (expecting true)", demo.removeNode("Z")==null); // should print true
        System.out.printf("\nRemoval of node \"C\": %b (expecting true)",demo.removeNode("C").getContent().equals("C")); // should print true
        System.out.printf("\nRemoval of node \"A\": %b (expecting true)", demo.removeNode("A").getContent().equals("A")); // should print true
        System.out.printf("\nRemoval of node \"E\": %b (expecting true)", demo.removeNode("E").getContent().equals("E")); // should print true
        demo.display(); // should print [B] [D] [B] only
        // DO NOT MODIFY THE CODE ABOVE

    }
}
