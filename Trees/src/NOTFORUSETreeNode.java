
public class NOTFORUSETreeNode {

    private String s;
    private NOTFORUSETreeNode leftChild;
    private NOTFORUSETreeNode rightChild;

    public NOTFORUSETreeNode(String s) {
        this.s = s;
        leftChild = null;
        rightChild = null;
    }

    public void setLeftChild(NOTFORUSETreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(NOTFORUSETreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void describeNode() {
        System.out.println("Node contents: " + s);
        String leftContent  =  ( leftChild == null ) ? "Null" : leftChild.s;
        String rightContent = ( rightChild == null ) ? "Null" : rightChild.s;
        System.out.println("\t Left child content: " + leftContent);
        System.out.println("\tRight child content: " + rightContent);
    }
}
