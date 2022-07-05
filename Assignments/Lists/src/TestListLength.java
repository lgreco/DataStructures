public class TestListLength {

    /* Driver code to test assignment results*/

    public static void main(String[] args) {
        LinkedList271SU22 test1 = new LinkedList271SU22();
        LinkedList271SU22 test2 = new LinkedList271SU22();
        LinkedList271SU22 test3 = new LinkedList271SU22();

        Node chi = new Node("Chicago");
        Node smt = new Node("Summit");
        Node jol = new Node("Joliet");
        Node dwi = new Node("Dwight");
        Node pon = new Node("Pontiac");

        test2.add(pon);
        test3.add(chi);
        test3.add(smt);
        test3.add(jol);
        test3.add(dwi);

        boolean pass1 = (test1.length() == 0);
        boolean pass2 = (test2.length() == 1);
        boolean pass3 = (test3.length() == 4);

        if (pass1 && pass2 && pass3)
            System.out.println("\n\nYour code passed all three tests.\n");
        else
            System.out.println("\n\nYour code failed at least one of the tests.\n");

    }
}
