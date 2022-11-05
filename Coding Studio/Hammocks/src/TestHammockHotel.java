import java.util.ArrayList;
import java.util.Arrays;

public class TestHammockHotel {

    /*

    TESTING WILL BE AVAILABLE AFTER 11 AM SATURDAY 11/5/22

     */

    public static void main(String[] args) {

        // Create the test object   *** REFACTOR TO NON NFS CLASS FOR 11/5 RELEASE
        NFS_HammockHotel test = new NFS_HammockHotel(2, 2.0, 2);

        // Guest list
        String[] guests = {"HARRY", "RON", "HERMIONE", "DRACO", "SEVERUS",
                "SEAMUS", "MINERVA", "RUBIUS", "SIRIUS", "REMUS", "ARTHUR", "ALBUS"};

        for (int i = 0; i < guests.length; i++) {
            if (i%2==0) {
                test.add(guests[i]);
            }
        }

        boolean containsTest = true;
        for (int i = 0; i < guests.length; i++) {
            containsTest = (i%2==0) ?
                    containsTest && test.contains(guests[i]) :
                    containsTest && !test.contains(guests[i]);
        }

        if (containsTest) {
            System.out.println("contains() passed the test");
        } else {
            System.out.println("contains() failed the test");
        }


        boolean addUniqueTest = true;
        for (int i = 0; i < guests.length; i++) {
            addUniqueTest = (i%2==0) ?
                    addUniqueTest && !test.addUnique(guests[i]) :
                    addUniqueTest && test.addUnique(guests[i]);

        }

        if (addUniqueTest) {
            System.out.println("addUnique() passed the test");
        } else {
            System.out.println("addUnique() failed the test");
        }



        boolean toArrayTest = true;
        Arrays.sort(guests);
        String[] arrayNames = test.toArray();
        Arrays.sort(arrayNames);
        for (int i = 0; i < guests.length; i++) {
            toArrayTest = toArrayTest && guests[i].equals(arrayNames[i]);
        }

        if (toArrayTest) {
            System.out.println("toArray() passed the test");
        } else {
            System.out.println("toArray() failed the test");
        }


        boolean statsTest = true;
        int[] counts = test.stats();
        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum = sum+ counts[i];
        }
        statsTest = sum == test.

        boolean isEmptyTest = true;
    }

}
