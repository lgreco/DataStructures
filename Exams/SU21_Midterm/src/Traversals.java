public class Traversals extends DoubleLinkedList {

    public void traverseByNext() {
        if (head != null) {
            System.out.println("\n\nTraversing by looking ahead to check if next is null.\n");
            Node current = head;
            while (current.hasNext()) {
                System.out.println(current.getContent());
                current = current.getNext();
            }
            System.out.println(current.getContent());
            System.out.println("\nAt the end of traversal we are at node: " + current.getContent());
        } else {
            System.out.println("Empty list.");
        }
    }

    public void traverseByLocal() {
        if (head !=null) {
            System.out.println("\n\nTraversing by checking if current node is null.\n");
            Node current = head;
            while (current != null) {
                System.out.println(current.getContent());
                current = current.getNext();
            }
            System.out.println("\nAt the end of traversal we are at node: " + current.getContent());
        } else {
            System.out.println("Empty list.");
        }
    }

    public static void main(String[] args) {
        Traversals t = new Traversals();
        t.add("Chicago");
        t.add("Summit");
        t.add("Joliet");
        t.add("Dwight");
        t.add("Pontiac");

        t.traverseByNext();
        t.traverseByLocal();
    }
}
