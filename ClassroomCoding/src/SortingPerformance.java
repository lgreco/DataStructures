import java.util.Arrays;
import java.util.Random;

// A class to test the performance of Select and Merge sorts and report findings


public class SortingPerformance {

    /**
     * Driver code, calls the method that runs the experiment.
     */
    public static void main(String[] args) {
        int sizeExponentFrom = 0;
        int sizeExponentTo = 20;
        int timesToRepeat = 10;
        /*
        Run an experiment with arrays from 2^sizeExponentFrom elements up to sizeExponentTo elements,
        doubling the size at every step. Each experiment is repeated 10 times to obtain smoother average
        performance times.
         */
        experiment(
                sizeExponentFrom,
                sizeExponentTo,
                timesToRepeat
        );
    }  // method main


    /**
     * Method that orchestrates the experiment.
     *
     * @param arraySizeFrom Exponent for initial array size (2^arraySizeFrom)
     * @param arraySizeTo  Exponent for final array size (2^arraySizeTo)
     * @param tries Times to repeat the experiment for each size, for smooth averaging.
     */
    public static void experiment(int arraySizeFrom, int arraySizeTo, int tries) {
        System.out.printf("\n\nPerformance time for Select and Merge sorts.");
        System.out.printf("\nArray sizes from %d to %,d elements.",
                (int) Math.pow(2,arraySizeFrom), (int) Math.pow(2,arraySizeTo));
        System.out.printf("\nFor each size, we sort %d different arrays, for smooth averaging.\n", tries);
        System.out.printf("\n%15s\t%25s\t%25s", "Array", "Select Sort", "Merge Sort");
        System.out.printf("\n%15s\t%25s\t%25s", "length", "(seconds)", "(seconds)\n");
        for (int sizeExponent = arraySizeFrom; sizeExponent <= arraySizeTo; sizeExponent++) {
            int arrayLength = (int) Math.pow(2,sizeExponent);
            // Averaging accumulators
            double avgSelectSort = 0.0;
            double avgMergeSort = 0.0;
            // Timing variables
            long start;
            double duration;
            for (int t = 0; t < tries; t++) {
                // Create a random array to use for Selection Sorting.
                int[] testArray1 = generateArray(arrayLength, -arrayLength, arrayLength);
                // Make a copy of that array to use in Merge Sorting.
                int[] testArray2 = Arrays.copyOf(testArray1, testArray1.length);
                // Start the stopwatch for Selection sorting.
                start = System.nanoTime();
                // Perform selection sorting on the first test array.
                selectionSort(testArray1);
                // Stop the stopwatch and record the time it took.
                duration = (double) (System.nanoTime()-start);
                // Update averaging accumulator
                avgSelectSort += ((double) duration)/((double) 1_000_000_000L);
                // Start the stopwatch for merge sorting.
                start = System.nanoTime();
                // Perform merge sorting on the second test array.
                mergeSort(testArray2);
                // Stop the stopwatch and record the time it took.
                duration = (double) (System.nanoTime()-start);
                // Update averaging accumulator.
                avgMergeSort += ((double) duration)/((double) 1_000_000_000L);
            }
            // Compute average times.
            avgSelectSort = avgSelectSort/((double) tries);
            avgMergeSort = avgMergeSort/((double) tries);
            // Report average times.
            System.out.printf("\n%,15d\t%,25.9f\t%,25.9f", arrayLength, avgSelectSort, avgMergeSort);
        }
    }  // method experiment


    /**
     * Creates an int array with random values, within a specified range.
     * @param length size of the array
     * @param rangeFrom smallest value possible in the array
     * @param rangeTo largesg value possible in the array
     * @return int array of given length and random values within a range
     */
    public static int[] generateArray(int length, int rangeFrom, int rangeTo) {
        int[] array = new int[length];
        Random rng = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rangeFrom + rng.nextInt(Math.abs(rangeTo-rangeFrom)+1);
        }
        return array;
    }  // method generateArray


    /**
     * Swaps two elements in an array
     * @param array with elements to swap
     * @param positionA first element to swap
     * @param positionB second element to swap
     */
    public static void swap(int[] array, int positionA, int positionB) {
        int temp = array[positionA];
        array[positionA] = array[positionB];
        array[positionB] = temp;
    }  // method swap


    /**
     * Reports the position of the smallest element in an array from a given position forward
     * @param array to find the position of its smallest element
     * @param from position to look for the smallest element, forward
     * @return int with position of smallest element between [from] and [array.length-1]
     */
    public static int positionOfSmallestElemement(int[] array, int from) {
        int position = from;
        for (int k = from+1; k < array.length; k++)
            if (array[k] < array[position])
                position = k;
        return position;
    }  // method positionOfSmallestElemement


    /**
     * Selection sort
     * @param array to sort
     * @return sorted array
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            swap(array,i,positionOfSmallestElemement(array,i));
        return array;
    }  // method selectionSort


    /**
     * Recursive method to merge sort an array
     * @param array to sort
     */
    public static void mergeSort(int[] array) {
        //System.out.printf("\n\nReceiving array %s", Arrays.toString(array));
        if (array.length > 1) {
            //System.out.printf("\n\tSplitting it into halves");
            // Split array into two halves
            int midPoint = array.length / 2;
            int[] left = new int[midPoint];
            int[] right = new int[array.length - midPoint];
            for (int i = 0; i < Math.max(midPoint, array.length) - midPoint; i++) {
                if (i < midPoint)
                    left[i] = array[i];
                right[i] = array[midPoint + i];
            }
            // recurse
            //System.out.printf("\n\tleft: %s", Arrays.toString(left));
            //System.out.printf("\n\tright: %s", Arrays.toString(right));
            mergeSort(left);
            mergeSort(right);
            merge(array,left,right);
        }
    }  // method mergeSort


    /**
     * Method to merge two sorted arrays into a large, also sorted array
     * @param merged output array
     * @param left input array
     * @param right the other input array
     */
    public static void merge(int[] merged, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < merged.length; i++) {
            if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
                merged[i] = left[leftIndex];
                leftIndex++;
            } else {
                merged[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }  // method merge

}
