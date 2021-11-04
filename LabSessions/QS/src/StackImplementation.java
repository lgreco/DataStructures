public class StackImplementation {


    /** Driver code */
    public static void main(String[] args) {
        Stack ourFirstStack = new Stack(4);
        System.out.println(ourFirstStack);
        ourFirstStack.push("Alex");
        ourFirstStack.push("Paolo");
        ourFirstStack.push("Drake");
        ourFirstStack.push("Julia");
        ourFirstStack.push("Juan");
        ourFirstStack.pop();
        ourFirstStack.pop();
        ourFirstStack.pop();
        System.out.println(ourFirstStack.pop());
        System.out.println(ourFirstStack.pop());
        System.out.println(ourFirstStack);
    }

}
