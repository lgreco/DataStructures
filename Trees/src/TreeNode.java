
public class TreeNode {

    private String s;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(String s) {
        this.s = s;
        leftChild = null;
        rightChild = null;
    }

    public void describeNode() {
        System.out.println("Node contents: " + s);
        String leftContent  =  ( leftChild == null ) ? "Null" : leftChild.s;
        String rightContent = ( rightChild == null ) ? "Null" : rightChild.s;
        System.out.println("\t Left child content: " + leftContent);
        System.out.println("\tRight child content: " + rightContent);
    }
}
