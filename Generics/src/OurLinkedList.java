
public class OurLinkedList<E> {
    Node<E> head;
    class Node<E> {
        E data;
        Node next;
        public Node(E e){
            data = e;
            next = null;
        }
    } // class Node

    public static void main(String[] args) {
        String test = "HelloHelloHelloHelloHelloHelloHelloHelloHello";
        int h = 0;
        for (int i=0; i<test.length();i++) {
            h = 31*h+test.charAt(i);
            System.out.println(h);
        }
        System.out.printf("%d %d", h, test.hashCode());
    }
}