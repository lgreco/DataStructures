public class TestXIFO {
    public static void main(String[] args) {
        XIFO q = new XIFO(4);
        q.add("A"); q.add("B"); q.add("C");
        boolean b1 = q.remove().equals("A");
        boolean b2 = q.remove().equals("B");
        boolean b3 = q.remove().equals("C");
        boolean b4 = q.remove() == null;
        if (b1 && b2 && b3 && b4)
            System.out.println("\nadd and remove methods seem to be working ok.");
        else
            System.out.println("\nadd and remove methods are not working as expected.");

        XIFO s = new XIFO(4);
        s.firstElement("A"); s.firstElement("B"); s.firstElement("C");
        boolean b5 = s.remove().equals("C");
        boolean b6 = s.remove().equals("B");
        boolean b7 = s.remove().equals("A") ;
        boolean b8 = s.remove() == null;
        if (b5 && b6 && b7 && b8)
            System.out.println("\nfirstElemeng and remove methods seem to be working ok.");
        else
            System.out.println("\nfirstElement and remove methods are not working as expected.");
    }
}
