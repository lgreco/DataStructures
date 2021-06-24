import java.util.ArrayList;
import java.util.List;

public class Node {
    private String data;
    private List<Node> adjacentNodes;

    public Node(String data) {
        this.data = data;
        adjacentNodes.add(null);
    }


    public static void main(String[] args) {
        Node node = new Node("Leo");
        System.out.println(node.adjacentNodes.size());
    }
}