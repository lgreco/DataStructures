import java.util.Arrays;

    /**

    THIS IS THE TESTING CODE FOR THE ENHANCED HAMMOCK HOTEL.
    @version 20221104.2130

     */

public class TestHammockHotel {



    public static void main(String[] args) {

        // Create the test object   *** REFACTOR TO NON NFS CLASS FOR 11/5 RELEASE
        HammockHotel test = new HammockHotel(2, 2.0, 2);

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
            sum = sum+counts[i];
        }

        if (statsTest) {
            System.out.println("stats() passed the test");
        } else {
            System.out.println("stats() failed the test");
        }


        boolean isEmptyTest = true;
        isEmptyTest = isEmptyTest && !test.isEmpty();


        boolean clearTest = true;
        test.clear();
        clearTest = test.isEmpty();


        isEmptyTest = isEmptyTest && test.isEmpty();

        if (clearTest) {
            System.out.println("isEmpty() passed the test");
        } else {
            System.out.println("isEmpty() failed the test");
        }

        if (clearTest) {
            System.out.println("clear() passed the test");
        } else {
            System.out.println("clear() failed the test");
        }
    }

}
