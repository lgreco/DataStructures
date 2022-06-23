import java.util.Arrays;

public class Sorting {

    public static int[] sort(int[] a) {
        if (a.length > 1)
            for (int i = 0; i < a.length-1; i++)
                swap(a,i,positionOfSmallestElement(a,i));
        return a;
    }


    public static int positionOfSmallestElement(int[] arr, final int fromPosition) {
        int smallPosition = fromPosition;
        for (int k = fromPosition+1; k < arr.length; k++) {
            if (arr[k] < arr[smallPosition])
                smallPosition = k;
        }
        return smallPosition;
    }


    public static void swap(int[] arr, int positionA, int positionB) {
        int temp = arr[positionA];
        arr[positionA] = arr[positionB];
        arr[positionB] = temp;
    }


    public static void main(String[] args) {
        int x[] = {11, 21, 13, -7, 9, 3, 4, 8};
        System.out.println(Arrays.toString(x));
        sort(x);
        System.out.println(Arrays.toString(x));
    }

}
