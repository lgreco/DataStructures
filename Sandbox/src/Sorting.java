public class Sorting {

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = new int[array.length/2];
            int[] right = new int[array.length/2];
            for (int i = 0; i < array.length / 2; i++) {
                left[i] = array[i];
                right[i] = array[i+array.length/2];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int leftPointer = 0, rightPointer = 0;
        for (int i = 0; i < array.length; i++) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    array[i] = left[leftPointer];
                    leftPointer++;
                } else {
                    array[i] = right[rightPointer];
                    rightPointer++;
                }
            } else if (leftPointer >= left.length) {
                array[i] = right[rightPointer];
                rightPointer++;
            } else {
                array[i] = left[leftPointer];
                leftPointer++;
            }
        }
    }

}
