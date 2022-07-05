public class TestNodeDeletions {

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
    }

}
