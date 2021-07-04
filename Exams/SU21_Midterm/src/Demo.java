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
        DoubleLinkedList demo = new DoubleLinkedList();
        /*
         Being silly with for loops and char primitives while building a
         double-linked list with 5 nodes.
         */
        for (char c = 'A'; c < 'F'; c++) { // c++, get it? :-
            // Convert char to String, make string content of new node to add to list
            demo.add(String.valueOf(c));
        }
        /*
        Call the display method. The output, when running the code, should be:

        [A] [B] [C] [D] [E] [D] [C] [B] [A]
         */
        demo.display();
    }
}
