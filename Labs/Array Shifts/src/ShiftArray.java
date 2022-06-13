public class ShiftArray {

    /*
    WRITE YOUR REMOVE METHOD HERE ...
     */

    public static void main(String[] args) {
        String[] test = {"A", "B", "C", "D", "E", "F"};
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(remove(test,222)));
        System.out.println(Arrays.toString(remove(test,-1222)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,2)));
        System.out.println(Arrays.toString(remove(test,0)));
        System.out.println(Arrays.toString(remove(test,0)));
        System.out.println(Arrays.toString(remove(test,0)));
    }
}
