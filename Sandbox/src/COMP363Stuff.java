import java.util.Arrays;

public class COMP363Stuff {

public static void insertionSort(int[] a) {
    if (a.length>1) {
        for (int j = 1; j < a.length; j++) {
            int value = a[j];
            int i = j-1;
            while (i > -1 && a[i] > value) {
                a[i+1] = a[i];
                i = i-1;
            }
            a[i+1] = value;
        }
    }
}

public static void main(String[] args) {
    int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    System.out.printf("\n%s\n", Arrays.toString(a));
    insertionSort(a);
    System.out.printf("\n%s\n", Arrays.toString(a));
}
}
