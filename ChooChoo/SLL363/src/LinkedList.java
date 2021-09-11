public class LinkedList {

    private Node head;

    private int elegantSteps;
    private int efficientSteps;

    public LinkedList() {
        this.head = null;
        this.elegantSteps = 0;
        this.efficientSteps = 0;
    }

    public void addNode(String content) {
        Node newNode = new Node(content);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println("--> " + current.getContent());
                current = current.getNext();
            }
        }
    }

    public int countNodes() {
        int count = 0;
        if (head != null) {
            Node current = head;
            while (current != null) {
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    public int countCommonNodes(LinkedList other) {
        int count = 0;
        elegantSteps = 0;
        if (this.head != null && other.head != null) {
            Node thisCurrent = this.head;
            while (thisCurrent != null) {
                Node otherCurrent = other.head;
                while (otherCurrent != null) {
                    elegantSteps++;
                    if (thisCurrent.getContent().equals(otherCurrent.getContent()))
                        count++;
                    otherCurrent = otherCurrent.getNext();
                }
                thisCurrent = thisCurrent.getNext();
            }
        }
        return count;
    }

    public boolean intersectionByCount(LinkedList other) {
        return countCommonNodes(other) > 0;
    }

    public boolean intersects(LinkedList other) {
        efficientSteps = 0;
        boolean intersectionFound = false;
        if (this.head != null && other.head != null) {
            boolean keepGoing = true;
            Node thisCurrent = this.head;
            while (keepGoing && thisCurrent != null) {
                Node otherCurrent = other.head;
                while (keepGoing && otherCurrent != null) {
                    efficientSteps++;
                    if (thisCurrent.getContent().equals(otherCurrent.getContent())) {
                        keepGoing = false;
                        intersectionFound = true;
                    }
                    otherCurrent = otherCurrent.getNext();
                }
                thisCurrent = thisCurrent.getNext();
            }
        }
        return intersectionFound;
    }

    public int getElegantSteps() {
        return elegantSteps;
    }

    public int getEfficientSteps() {
        return efficientSteps;
    }
}
