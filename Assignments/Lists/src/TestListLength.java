public class TestListLength {

    /* Driver code to test assignment results*/

    public static void main(String[] args) {

        Node chi = new Node("Chicago");
        Node smt = new Node("Summit");
        Node jol = new Node("Joliet");
        Node dwi = new Node("Dwight");
        Node pon = new Node("Pontiac");
        Node blo = new Node("Bloomington");
        Node lcn = new Node("Lincoln");
        Node spi = new Node("Springfield");
        Node crl = new Node("Carlinville");
        Node aln = new Node("Alton");
        Node stl = new Node("St. Louis");

        LinkedList271SU22 test4 = new LinkedList271SU22();

        test4.add(chi);
        test4.add(smt);
        test4.add(jol);
        test4.add(dwi);
        test4.add(pon);
        test4.add(blo);
        test4.add(lcn);
        test4.add(spi);
        test4.add(crl);
        test4.add(aln);
        test4.add(stl);


        int length4 = test4.length();
        test4.simpleDelete(blo);
        boolean pass4_1 = test4.length() == length4-1;
        test4.simpleDelete(lcn);
        boolean pass4_2 = test4.length() == length4-2;

        if (pass4_1 && pass4_2)
            System.out.println("\n\nYour simpleDelete seems to be working ok.\n\n");
        else
            System.out.println("\n\nYour simpleDelete is not working as expected.\n\n");


        /*

        // Test code for earlier assignment disabled

        LinkedList271SU22 test1 = new LinkedList271SU22();
        LinkedList271SU22 test2 = new LinkedList271SU22();
        LinkedList271SU22 test3 = new LinkedList271SU22();

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
        */
    }
}
