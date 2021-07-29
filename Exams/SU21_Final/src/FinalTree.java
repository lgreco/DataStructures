class FinalTree {

    /**
     * Inner class with Node objects that are used to build the tree. This is a simple node, with a String
     * for content and, of course, pointers for up to two children. A simple constructor is also provided.
     */
    class Node {
        String content;
        Node left, right;

        /** Partial constructor */
        public Node(String content) {
            this.content = content;
            left = right = null;
        }

        /**
         *
         * A method that determines if the invoking node is a leaf or not. A leaf is a node without children.
         *
         * Usage:                Node n;
         *                       n.isLeaf()
         *                       ^
         *                       |
         *                       +---- invoking node
         *
         * @return true is node is leaf; false otherwise.
         */
        boolean isLeaf() {
            return false; // REPLACE THIS LINE WITH YOUR CODE
        } // method isLeaf

    } // Inner class Node


    /** The root of our tree */
    Node root;


    /**
     * Method to insert a node to the tree. The method inserts only nodes with unique content, thus avoiding
     * duplicates. Insertion start from the root of the tree. If the root is empty, things are easy. The new node
     * becomes the tree. Otherwise we traverse the tree from the root down to find the appropriate location for the
     * new node.
     *
     * @param content contents of the new node
     */
    void addNode(String content) {
        Node newNode = new Node(content); // Prepare the new node to be added
        if (root == null) { // If tree, empty ...
            root = newNode; // ... make new node, the root node.
        } else { // If tree is not empty ...
            Node current = root; // ... get ready to traverse the tree ...
            boolean keepTraversingTree = true; // ... as long as this flag is set to true.
            while (keepTraversingTree) {
                if (content.compareTo(current.content) != 0) { // Do not insert duplicate content
                    if (content.compareTo(current.content) <0) { // go left
                        if (current.left == null) { // Found a spot for the new node ...
                            current.left = newNode; // ... place it here and ...
                            keepTraversingTree = false; // ... signal to end the while loop.
                        } else { // If this spot is occupied ...
                            current = current.left; // .. go down and left and try again.
                        }
                    } else { // go right
                        if (current.right == null) { // Found a spot for the new node ...
                            current.right = newNode; // ... place it here and ...
                            keepTraversingTree = false; // ... signal to end the while loop.
                        } else { // If this spot is occupied ...
                            current = current.right; // .. go down and right and try again.
                        }
                    }
                } else { // In case of a duplicate content ...
                    keepTraversingTree = false; // ... end the while loop.
                }
            } // while loop
        } // empty tree if
    } // method addNode


    /** Driver and evaluation method *** MODIFYING THE CONTENTS OF THIS METHOD MAY LEAD TO WRONG RESULTS. */
    public static void main(String[] args) {
        FinalTree richardIII = new FinalTree();
        richardIII.addNode("now");
        richardIII.addNode("is");
        richardIII.addNode("the");
        richardIII.addNode("winter");
        richardIII.addNode("of");
        richardIII.addNode("our");
        richardIII.addNode("discontent");

        System.out.printf("\n\nNode with content [%s] is leaf: %B (should be false)", richardIII.root.content, (richardIII.root.isLeaf()));
        System.out.printf("\nNode with content [%s] is leaf: %B (should be false)", richardIII.root.left.content, (richardIII.root.left.isLeaf()));
        System.out.printf("\nNode with content [%s] is leaf: %B (should be true)", richardIII.root.left.left.content, (richardIII.root.left.left.isLeaf()));
        System.out.printf("\nNode with content [%s] is leaf: %B (should be true)", richardIII.root.right.left.right.content, (richardIII.root.right.left.right.isLeaf()));

    }
}
