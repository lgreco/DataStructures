public class TestMiddle {

    /*
    Driver code to test assignment results @version 202207261100

    DO NOT MODIFY THE CODE IN THIS CLASS

    */

    public static void main(String[] args) {

        LinkedList271SU22 test = LinkedList271SU22();

        Node chi = new Node("Chicago");
        Node smt = new Node("Summit");
        Node jol = new Node("Joliet");
        Node dwi = new Node("Dwight");
        Node pon = new Node("Pontiac");
        Node blo = new Node("Bloomington");
        Node lcn = new Node("Lincoln");


        test.add(chi);
        test.add(smt);
        test.add(jol);
        test.add(dwi);
        test.add(pon);
        test.add(blo);
        test.add(lcn);

        if (test.middleNode().equals("Dwight"))
            System.out.println("\n\nYour method seems to be working as expected.\n\n");
        else
            System.out.println("\n\nYour method is not working as specified.\n\n");

    }
}
