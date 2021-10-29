public class Node {

    String content;
    Node left;
    Node right;

    /**
     * Basic constructor.
     *
     * @param content String to place in node.
     */
    public Node(String content) {
        this.content = content;
        this.left = null;
        this.right = null;
    } // constructor Node

    public static void main(String[] args) {
        Node demo = null;
    }

    public String toString() {
        String s = new String("Nothing to see here folks!");
        if (this!=null&& this.content != null) {
            // ...
        }}

} // class Node
