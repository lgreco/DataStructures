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

    public String content;
    public Node left;
    public Node right;


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

}
