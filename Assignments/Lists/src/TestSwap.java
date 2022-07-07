/*

Test class for swap nodes

 */

public class TestSwap {

    public static void main(String[] args) {

        // Create a few nodes

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

        // Set up a linked list and add the nodes to it.

        LinkedList271SU22 test5 = new LinkedList271SU22();

        test5.add(chi);
        test5.add(smt);
        test5.add(jol);
        test5.add(dwi);
        test5.add(pon);
        test5.add(blo);
        test5.add(lcn);
        test5.add(spi);
        test5.add(crl);
        test5.add(aln);
        test5.add(stl);

        // Invove the swapNodes method for Dwight and Springfield
        test5.swapNodes(dwi, spi);
        //    =========
        //    You must create this method prior to testing here.

        // First test
        boolean pass1 = test5.
                getHead().
                getNext().getNext().getNext().
                getData().
                equals(spi.getData());

        // Second test
        boolean pass2 = test5.
                getHead().
                getNext().getNext().getNext().getNext().getNext().getNext().getNext().
                getData().
                equals(dwi.getData());

        // Report results
        if (pass1 && pass2)
            System.out.printf("\n\nYour swap method seems to be working ok.\n");
        else
            System.out.printf("\n\nYour swap method is not working as expected.\n");
    }
}
