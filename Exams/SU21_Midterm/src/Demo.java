
/**
 * Implementation class with double-linked lists.
 *
 * Updates:
 *
 *          2021 JUL 07 1520 - METHOD FOR PROBLEM 4 UPDATED TO IGNORE
 *                             ANY EMPTY SPACES AT THE END OF THE
 *                             REVERSE STRING.
 *
 *          2021 JUL 06 1530 - METHODS FOR PROBLEMS 3, 4 UPDATED TO
 *                             REFLECT CORRECT NUMBER OF NODES IN
 *                             THE LIST -- SINCE PROBLEM 2 METHOD
 *                             IS NOT INVOKED IN APRICOT BRANCH.
 *
 * **********************************************************************
 * **********************************************************************
 * *                                                                   **
 * *              DO NOT MODIFY THE CODE IN THIS CLASS.                **
 * *                                                                   **
 * **********************************************************************
 * **********************************************************************
 */
public class Demo {

    static final String PASS = "Pass", FAIL = "Failed";

    /*
    Correct answers for problem 3 and 4; when running for full solutions flavor these
    answers need to change (main() modifies them).
     */
    static int countForProblem3 = 5;
    static String stringForProblem4 = "[E] [D] [C] [B] [A]";

    // Set up demo lists
    static DoubleLinkedList demo = new DoubleLinkedList();
    static DoubleLinkedList zero = new DoubleLinkedList();

    /**
     * Main method creates an instance of the DoubleLinkedList, populates
     * it with single-letter Strings, and then calls the appropriate
     * methods to evaluate the assignment
     */
    public static void main(String[] args) {

        // Ensure that FLAVOR has been assigned in DoubleLinkedList
        if (demo.FLAVOR.equalsIgnoreCase("PEACH") || demo.FLAVOR.equalsIgnoreCase("APRICOT") || demo.FLAVOR.equalsIgnoreCase("SOLUTIONS")) {
            System.out.printf("\n\nTHIS CLASS SOLVES THE %S FLAVOR OF THE EXAM", demo.FLAVOR);

            /*
            Adjust some answers for FLAVOR = SOLUTIONS because the list content may be different.
             */

            if (demo.FLAVOR.equalsIgnoreCase("SOLUTIONS")) {
                countForProblem3 = 2;
                stringForProblem4 = "[D] [B]";
            }

            // Add a few nodes
            for (char c = 'A'; c < 'F'; c++) { // c++ get it? :-)
                demo.add(String.valueOf(c));
            }

            // Problem 1 is common to both flavors of the exam
            problem1();

            // Run PEACH flavor -- problem 2
            if (demo.FLAVOR.equalsIgnoreCase("PEACH") || demo.FLAVOR.equalsIgnoreCase("SOLUTIONS")) {
                problem2();
            }

            // Run APRICOT flavor -- problems 3, 4, 5
            if (demo.FLAVOR.equalsIgnoreCase("APRICOT") || demo.FLAVOR.equalsIgnoreCase("SOLUTIONS")) {
                problem3();
                problem4();
                problem5();
            }

            System.out.printf("\n\n--- End of Assessment --- \n");

        } else {

            // No FLAVOR assigned. Inform programmer to do so.
            System.out.printf("\n\nYOU MUST CHANGE THE VALUE OF FLAVOR IN CLASS DoubleLinkedList\n" +
                    "TO EITHER \"PEACH\" OR \"APRICOT\" ACCORDING TO THE INSTRUCTIONS\n" +
                    "PROVIDED, BEFORE SUBMITTING THE FILE FOR GRADING.\n");
        }
    } // method main


    public static void problem1() {
        /*
        Call the display method. The output, when running the code, should be
        [A] [B] [C] [D] [E] [D] [C] [B] [A]
         */
        System.out.printf("\n\nProblem 1\nExpected:\n[A] [B] [C] [D] [E] [D] [C] [B] [A]\nActual:");
        demo.display();
    }

    public static void problem2() {

        // Testing removals (Problem 2)

        String removeZ = (demo.removeNode("Z") == null) ? PASS : FAIL;
        String removeC = (demo.removeNode("C").getContent().equals("C")) ? PASS : FAIL;
        String removeA = (demo.removeNode("A").getContent().equals("A")) ? PASS : FAIL;
        String removeE = (demo.removeNode("E").getContent().equals("E")) ? PASS : FAIL;

        System.out.printf("\n\nProblem 2");
        System.out.printf("\nRemoval of node \"Z\": %s", removeZ);
        System.out.printf("\nRemoval of node \"C\": %s", removeC);
        System.out.printf("\nRemoval of node \"A\": %s", removeA);
        System.out.printf("\nRemoval of node \"E\": %s", removeE);
        demo.display(); // should print [B] [D] [B] only
    }


    public static void problem3() {
        // Testing counting (Problem 3)
        String countCorrectly = (demo.countNodes() == countForProblem3) ? PASS : FAIL;
        System.out.printf("\n\nProblem 3");
        System.out.printf("\nNode counting: %s", countCorrectly);
        countCorrectly = (zero.countNodes() == 0) ? PASS : FAIL;
        System.out.printf("\nNode counting, empty list: %s", countCorrectly);
    }


    public static void problem4() {
        // Testing reverse printing (Problem 4)
        String reverseNonEmpty = (demo.toString().trim().equals(stringForProblem4)) ? PASS : FAIL;
        String reverseEmpty = (zero.toString().equals("List is empty")) ? PASS : FAIL;
        System.out.printf("\n\nProblem 4");
        System.out.printf("\nList in reverse: %s", reverseNonEmpty);
        System.out.printf("\nEmpty list in reverse: %s", reverseEmpty);
    }


    public static void problem5() {
        //Testing unique add (Problem 5)
        String addUniqueD = (!demo.addUnique("D")) ? PASS : FAIL; // ! for reverse logic
        String addUniqueL = (demo.addUnique("L")) ? PASS : FAIL;
        System.out.printf("\n\nProblem 5");
        System.out.printf("\nAdd node with \"D\": %s", addUniqueD);
        System.out.printf("\nAdd node with \"L\": %s", addUniqueL);
    }

    //          DO NOT MODIFY THE CODE IN THIS CLASS
}
