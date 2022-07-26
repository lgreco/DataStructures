public class TestComparable {

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

        boolean pass11 = test1.compareTo(test1) == 0;
        boolean pass22 = test2.compareTo(test2) == 0;
        boolean pass33 = test3.compareTo(test3) == 0;
        boolean pass12 = test1.compareTo(test2) < 0;
        boolean pass21 = test2.compareTo(test1) > 0;
        boolean pass23 = test2.compareTo(test3) < 0;
        boolean pass32 = test3.compareTo(test2) > 0;

        System.out.printf("%s %s %s %s %s %s %s", pass11, pass22, pass33, pass12, pass21, pass23, pass32);

        if (pass11 && pass22 && pass33 && pass12 && pass21 && pass23 && pass32)
            System.out.printf("\n\nYour method seems to work as expected.\n");
        else
            System.out.printf("\n\nYour method is not working as expected.");
    }
}
