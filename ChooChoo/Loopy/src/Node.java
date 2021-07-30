/** Simple node class */
public class Node {

        String content;
        Node next;

        /** Partial constructor for inner class Node */
        public Node(String content) {
            this.content = content;
            this.next = null;
        }

        /** Full constructor */
        public Node(String content, Node next) {
            this.content = content;
            this.next = next;
        }

} // class Node
