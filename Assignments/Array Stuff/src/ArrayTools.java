import java.util.Arrays;

public class ArrayTools {

    public static int[] removeDuplicates(int[] a) {
        if (a.length > 1) {
            System.out.printf("\nStarting with: %s", Arrays.toString(a));
            int[] temporary = new int[a.length];
            int uniqueElements = 0;
            for (int i = 0; i < a.length; i++) {
                temporary[uniqueElements] = a[i];
                System.out.printf("\n\tCopying a[%d] to temporary[%d]", i, uniqueElements);
                uniqueElements++;
                if (i < a.length - 1) {
                    System.out.printf("\n\t\tScanning forward of a[%d]: ", i);
                    int j = i + 1;
                    while (j < a.length && a[i] == a[j]) {
                        System.out.printf("a[%d] == a[%d], next ... ", i, j);
                        j++;
                    }
                    System.out.printf("\n\t\tSetting i to %d", j);
                    i = j - 1;
                }
            }
            System.out.printf("\nDone with scan.");
            a = new int[uniqueElements];
            System.out.printf("\nCopy %d elements into resized a.", uniqueElements);
            for (int i = 0; i < uniqueElements; i++) {
                a[i] = temporary[i];
            }
            System.out.printf("\nReturning %s\n\n", Arrays.toString(a));
        }
        return a;
    }

    public static void main(String[] args) {
        int[] test = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7};
        int[] result = removeDuplicates(test);
        boolean success = true;
        for (int i = 0; i < result.length ; i++) {
            success = success && (result[i] == i);
        }
        System.out.println(success);
    }
}
