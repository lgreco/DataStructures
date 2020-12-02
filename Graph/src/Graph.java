public class Graph {
    private Node source;
    private Node target;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean exists(Node node) {
        boolean success = false;
        if ( size > 0 ) {
            Node current = source;
            while ( ! current.equals(target)) {
                // network traversal ... oh, fun
            }
        }
        return success;
    }

    public boolean add(Node node) {
        boolean success = false;
        if ( source==null ) {
            source = node;
            size = 1;
            success = true;
        } else {

            success = true;
        }
        return success;
    }
}
