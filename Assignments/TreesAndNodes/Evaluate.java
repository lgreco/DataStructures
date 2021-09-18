/**
 * Driver class to evaluate Treeee and Node.
 */
public class Evaluate {
    public static void main(String[] args) {
        Treeee demo = new Treeee();
        demo.add("now");
        demo.add("is");
        demo.add("the");
        demo.add("winter");
        demo.add("of");
        demo.add("our");
        demo.add("discontent");
        if (demo.root == null) {
            System.out.println("Root is null!");
        } else {
            if (demo.root.right.right != null)
                System.out.println(demo.root.right.right.content);
            else
                System.out.println("root.right.right is null");
            if (demo.root.left != null)
                System.out.println(demo.root.left.content);
            else
                System.out.println("root.left is null");
        }
    }
}
