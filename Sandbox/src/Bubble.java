import java.util.Arrays;

public class Bubble {

    public static void main(String[] args) {

        int a[] = { 8, 4, 3, 2, 1, 0, 10, 12, 123, 131, 21, 22,
                23, 34, 56, 78, 997, 43, 32,98,654, 23,22, 1212};

        System.out.println(Arrays.toString(a));
        for (int upTo = 1; upTo <a.length ; upTo++) {
            for (int i = 0; i < a.length - upTo; i++) {
                if (a[i] > a[i + 1]) {
                    // swap the elements
                    int temporary = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temporary;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
