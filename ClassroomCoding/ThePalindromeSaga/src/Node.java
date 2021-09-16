/**
 * A simple node object for a binary tree.
 *
 * The object has three fields:
 *
 * String content: the data stored in the content, as a string.
 *      Node left: information about the node to the left of present node.
 *     Node right: information about the node to the right of present node.
 */
public class Node {

    private String content;
    private Node left;
    private Node right;


    /**
     * Basic constructor.
     *
     * @param content String to hold in this node.
     */
    public Node(String content) {
        this.content = content;
        this.left = null;
        this.right = null;
    } // constructor Node

    /* Accessors and mutators */

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
            this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
