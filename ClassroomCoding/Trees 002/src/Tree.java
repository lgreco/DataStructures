public class Tree {

    private Node root;

    void add(String content) {
        Node newNode = new Node(content);
        if (root==null) {
            root = newNode;
        } else {
            // Determine left/right placement
            Node current = root;
            String currentContent = current.getContent();
        }
    }

}
