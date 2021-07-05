/**
 * Implementation class with double-linked lists.
 */
public class Demo {
    /**
     * Main method creates an instance of the DoubleLinkedList, populates
     * it with single-letter Strings, and then applies the display method
     * (a midterm exam deliverable) to print the list going forward and
     * backwards.
     *
     ***********************************************************************
     ***********************************************************************
     **                                                                   **
     **              DO NOT MODIFY THE CODE IN METHOD MAIN.               **
     **                                                                   **
     ***********************************************************************
     ***********************************************************************
     */
    public static void main(String[] args) {

        // Set up demo list
        DoubleLinkedList demo = new DoubleLinkedList();
        DoubleLinkedList zero = new DoubleLinkedList();

        /*
         Being silly with for loops and char primitives while building a
         double-linked list with 5 nodes.
         */
        for (char c = 'A'; c < 'F'; c++) {
            demo.add(String.valueOf(c));
        }

        /*
        Call the display method. The output, when running the code, should be
        [A] [B] [C] [D] [E] [D] [C] [B] [A]
         */
        System.out.printf("\n\nProblem 1\nExpected:\n[A] [B] [C] [D] [E] [D] [C] [B] [A]\nActual:");
        demo.display();

        // Testing removals (Problem 2)
        final String PASS = "Pass", FAIL = "Failed";
        String removeZ = (demo.removeNode("Z")==null) ? PASS : FAIL;
        String removeC = (demo.removeNode("C").getContent().equals("C")) ? PASS : FAIL;
        String removeA = (demo.removeNode("A").getContent().equals("A")) ? PASS : FAIL;
        String removeE = (demo.removeNode("E").getContent().equals("E")) ? PASS : FAIL;

        System.out.printf("\n\nProblem 2");
        System.out.printf("\nRemoval of node \"Z\": %s", removeZ);
        System.out.printf("\nRemoval of node \"C\": %s", removeC);
        System.out.printf("\nRemoval of node \"A\": %s", removeA);
        System.out.printf("\nRemoval of node \"E\": %s", removeE);
        demo.display(); // should print [B] [D] [B] only

        // Testing counting (Problem 3)
        String countCorrectly = (demo.countNodes()==2) ? PASS : FAIL;
        System.out.printf("\n\nProblem 3");
        System.out.printf("\nNode counting: %s",countCorrectly);
        countCorrectly = (zero.countNodes()==0) ? PASS : FAIL;
        System.out.printf("\nNode counting, empty list: %s",countCorrectly);

        // Testing reverse printing (Problem 4)
        String reverseNonEmpty = (demo.toString().equals("[D] [B] ")) ? PASS : FAIL;
        String reverseEmpty = (zero.toString().equals("List is empty")) ? PASS : FAIL;
        System.out.printf("\n\nProblem 4");
        System.out.printf("\nList in reverse: %s", reverseNonEmpty);
        System.out.printf("\nEmpty list in reverse: %s", reverseEmpty);

        //Testing unique add (Problem 5)
        String addUniqueD = (!demo.addUnique("D")) ? PASS : FAIL; // ! for reverse logic
        String addUniqueL = (demo.addUnique("L")) ? PASS : FAIL;
        System.out.printf("\n\nProblem 5");
        System.out.printf("\nAdd node with \"D\": %s", addUniqueD);
        System.out.printf("\nAdd node with \"L\": %s", addUniqueL);

        System.out.printf("\n\n--- End of Assessment --- ");
    } // method main
    /*
                     DO NOT MODIFY THE CONTENTS OF METHOD MAIN ABOVE
     */
}
