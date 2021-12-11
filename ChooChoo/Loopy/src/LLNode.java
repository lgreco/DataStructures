package ChooChoo.Loopy.src;

/** Simple node class */
public class LLNode {

        String content;
        LLNode next;

        /** Partial constructor for inner class Node */
        public LLNode(String content) {
            this.content = content;
            this.next = null;
        }

        /** Full constructor */
        public LLNode(String content, LLNode next) {
            this.content = content;
            this.next = next;
        }

} // class Node
