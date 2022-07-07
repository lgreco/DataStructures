public class TestFind {

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
        Node blo = new Node("Bloomington");

        test2.add(chi);

        test3.add(smt);
        test3.add(jol);
        test3.add(dwi);
        test3.add(pon);
        test3.add(blo);

        boolean pass1_1 = test1.contains("Chicago");        // false
        boolean pass2_1 = test2.contains("Chicago");        // true
        boolean pass2_2 = test2.contains("Pontiac");        // false
        boolean pass3_1 = test3.contains("Summit");         // true
        boolean pass3_2 = test3.contains("Joliet");         // true
        boolean pass3_3 = test3.contains("Bloomington");    // true
        boolean pass3_4 = test3.contains("Chicago");        // false

        System.out.printf("%s %s %s %s %s %s %s", pass1_1, pass2_1, pass2_2, pass3_1, pass3_2, pass3_3, pass3_4);

        if (!pass1_1 && pass2_1 && !pass2_2 && pass3_1 && pass3_2 && pass3_3 && !pass3_4)
            System.out.printf("\n\nYour method seems to work as expected.\n");
        else
            System.out.printf("\n\nYour method is not working as expected.");
    }
}
