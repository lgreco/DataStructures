public class Tree {

    Node root;

    void add(String content) {
        // Prepare the new node
        Node newNode = new Node(content);
        // Find a place for it on the tree
        if (root == null) {
            // Tree is empty; make newNode the root of the tree
            root = newNode;
        } else {
            // Tree not empty... find a place for newNode
            Node current = root;
            String currentContent = current.getContent();
            current.setContent("Hello World");

        }
    }

}
