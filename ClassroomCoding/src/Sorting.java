import java.util.Arrays;

public class Sorting {

    public static int[] sort(int[] a) {
        if (a.length > 1)
            for (int i = 0; i < a.length-1; i++)
                swap(a, i, positionOfSmallest(a,i));
        return a;
    }

    public static int positionOfSmallest(int[] a, int from) {
        for (int k = from+1; k < a.length; k++)
            if (a[k] < a[from])
                from = k;
        return from;
    }


    public static void swap(int[] a, int s, int t) {
        int temp = a[s];
        a[s] = a[t];
        a[t] = temp;
    }

    public static void main(String[] args) {
        int x[] = {11, 21, 13, -7, 9, 3,4,8};
        System.out.println(Arrays.toString(x));
        sort(x);
        System.out.println(Arrays.toString(x));

        int y[] = {11, 21, 13, -7, 9, 3,4,8};
        System.out.println(Arrays.toString(y));
        verboseSort(y);
        System.out.println(Arrays.toString(y));
    }

    public static int[] verboseSort(int[] a) {
        if (a.length > 1) {
            for (int i = 0; i < a.length-1; i++) {
               int positionOfSmallest = i;
                for (int j = i+1; j < a.length; j++) {
                    if (a[j] < a[positionOfSmallest])
                        positionOfSmallest = j;
                }
                // swap
                int temp = a[i];
                a[i] = a[positionOfSmallest];
                a[positionOfSmallest] = temp;
            }
        }
        return a;
    }
}
