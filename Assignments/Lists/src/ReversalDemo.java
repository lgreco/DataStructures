public class ReversalDemo {


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

        LinkedList271SU22 demo = new LinkedList271SU22();

        demo.add(chi);
        demo.add(smt);
        demo.add(jol);
        demo.add(dwi);
        demo.add(pon);
        demo.add(blo);
        demo.add(lcn);
        demo.add(spi);
        demo.add(crl);
        demo.add(aln);
        demo.add(stl);

        System.out.println();
        System.out.println(demo.toString());

        LinkedList271SU22 omed = demo.reverse();

        System.out.println();
        System.out.println(omed.toString());

        System.out.println();
        System.out.println(demo.toString());
    }
}
