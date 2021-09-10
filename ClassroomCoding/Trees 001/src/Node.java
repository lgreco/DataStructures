public class Node {

    private String content;
    private Node left;
    private Node right;

    public Node(String content) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.toLowerCase();
    }
}
