import java.util.Arrays;

public class NFS_ArrayTools {

    /** Complete this method below @version 202207261000 */
    public static int[] removeDuplicates(int[] a) {
        return a;
    }  // method removeDuplicates


    /** Simple test code for removeDuplicates*/
    public static void main(String[] args) {
        int[] test = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7};
        int[] result = removeDuplicates(test);
        boolean success = true;
        for (int i = 0; i < result.length ; i++) {
            success = success && (result[i] == i);
        }
        if (success)
            System.out.println("\n\nYour method seems to be working as expected\n\n");
        else
            System.out.println("\n\nYour method is not working as specified.\n\n");
    }
}
