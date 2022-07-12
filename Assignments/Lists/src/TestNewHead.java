public class TestNewHead {
    public static void main(String[] args) {
        LinkedList271SU22 test1 = new LinkedList271SU22();
        Node chi = new Node("Chicago");
        Node smt = new Node("Summit");
        Node jol = new Node("Joliet");
        Node dwi = new Node("Dwight");
        test1.add(smt);
        test1.add(jol);
        test1.add(dwi);
        System.out.println();
        System.out.println(test1);
        test1.setHead(chi);
        System.out.println();
        System.out.println(test1);
        test1.setHead(chi);
        System.out.println();
        System.out.println(test1);
    }
}
