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
        NFS_Solutions demo = new NFS_Solutions();

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
        demo.display();

        //Test removeNode method -- DO NOT MODIFY THE CODE BELOW

        final String PASS = "Pass", FAIL = "Failed";
        String removeZ = (demo.removeNode("Z")==null) ? PASS : FAIL;
        String removeC = (demo.removeNode("C").getContent().equals("C")) ? PASS : FAIL;
        String removeA = (demo.removeNode("A").getContent().equals("A")) ? PASS : FAIL;
        String removeE = (demo.removeNode("E").getContent().equals("E")) ? PASS : FAIL;

        System.out.printf("\nRemoval of node \"Z\": %s", removeZ);
        System.out.printf("\nRemoval of node \"C\": %s", removeC);
        System.out.printf("\nRemoval of node \"A\": %s", removeA);
        System.out.printf("\nRemoval of node \"E\": %s", removeE);
        demo.display(); // should print [B] [D] [B] only

        // DO NOT MODIFY THE CODE ABOVE

    }
}
