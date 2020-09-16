import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformance {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        Random rng = new Random();
        int N = 15;
        int maxN = 28;
        System.out.println("         N                ADD                    REMOVE                 CONTAINS" );
        System.out.println("                     AL          LL          AL          LL          AL          LL");
        while ( N <= maxN ) {

            int numberOfElements = (int) Math.pow(2.0, (double) N);

            long startTime = System.currentTimeMillis();

            for ( int i = 0; i < numberOfElements; i++ ) {
                int value = rng.nextInt(2*numberOfElements);
                arrayList.add(value);
            }

            long arrayListAddTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();

            for ( int i = 0; i < numberOfElements; i++) {
                int value = rng.nextInt(2*numberOfElements);
                linkedList.add(value);
            }

            long linkedListAddTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();

            for ( int i = 1; i < numberOfElements; i=2*i) {
                arrayList.remove(i);
            }

            long arrayListRemoveTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();

            for ( int i = 1; i < numberOfElements; i=2*i) {
                linkedList.remove(i);
            }

            long linkedListRemoveTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();

            for ( int i = 1; i < numberOfElements; i=2*i) {
                arrayList.contains(i);
            }

            long arrayListContainsTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();

            for ( int i = 1; i < numberOfElements; i=2*i) {
                linkedList.contains(i);
            }

            long linkedListContainsTime = System.currentTimeMillis() - startTime;

            System.out.printf("%10d, %10d, %10d, %10d, %10d, %10d, %10d\n", numberOfElements, arrayListAddTime, linkedListAddTime,arrayListRemoveTime, linkedListRemoveTime, arrayListContainsTime, linkedListContainsTime);



            N++;

        }
    }
}
