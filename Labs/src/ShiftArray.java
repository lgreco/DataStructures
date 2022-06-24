import java.util.Arrays;

public class ShiftArray {

    public static String[] remove(String[] a, int position) {
        if (position > -1 && position < a.length) {
            for (int i = position ; i < a.length-1 ; i++)
                a[i] = a[i+1];
            a[a.length-1] = null;
        }
        return a;
    }

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
