public class OurLinkedList<E> {
    Node<E> head;
    class Node<E> {
        E data;
        Node next;
        public Node(E e){
            data = e;
            next = null;
        }
    }

    public static void main(String[] args) {
        OurLinkedList<String> demo = new OurLinkedList<>();
        System.out.println(demo.head);
    }


}