import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

/*
        ====================================
        DO NOT MODIFY THE CODE IN THIS CLASS
        ====================================

        This class tests the correctness of class Chronos. The test compares the
        day of the week returned by Java's LocalDate class and the day of the
        week returned by our Chronos' dayOfWeek method. The two strings must be
        equal to each other. The method goes over multiple dates, beginning with
        January 1, 1601. The dates are advanced by random intervals of 1-30 days
        until we move passed today's date. A single mismatch between the two
        strings we compare, will stop the test and declare a failure.
 */

public class TestChronos {
    public static void main(String[] args) {
        // We start testing from this January 1, 1601.
        LocalDate test = LocalDate.of(1601,1,1);
        // Today's date; we use it to end the testing when we reach it.
        LocalDate today = LocalDate.now();
        // Our date object to test
        Chronos testChronos;
        // Tracking the success of testing;
        boolean success = true;
        // Count the testing comparisons.
        int counter = 0;
        // RNG to advance the testing date
        Random rng = new Random();
        // String with day of the week obtain by Java and by our methods.
        String whatJavaSays, whatOurMethodSays;
        // Begin displaying test progress.
        System.out.printf("\n\nTesting ");
        /*
        The principal loop continues until the test fails because of two
        mismatched dates or until we get passed today's date.
         */
        do {
            // Set our date object to match the test date
            testChronos = new Chronos(
                    test.getYear(),
                    test.getMonthValue(),
                    test.getDayOfMonth());
            // Day of the week for test date, according to Java
            whatJavaSays = test.
                    getDayOfWeek().
                    getDisplayName(TextStyle.FULL, Locale.US);
            // Day of the week for test date, according to our method
            whatOurMethodSays = testChronos.dayOfWeek();
            // Our method must agree with Java's result.
            success = whatJavaSays.equals(whatOurMethodSays);
            // Try another day, at random.
            test = test.plusDays(rng.nextInt(30));
            // Increment the number of comparisons.
            counter++;
            // Print a dot now and then to show progress
            if (counter%250==0)
                System.out.printf(".");
            if (counter%25000==0)
                System.out.printf("\n        ");
            // End testing when we reach today's date or as soon as our method
            // doesn't match Java's result.
        } while (success && !(test.compareTo(today)>0));
        // Report
        System.out.printf("\n\nTest report:\n\t" +
                        "After %,d comparisons, your method %s the test.\n\n",
                counter, ((success) ? "passed": "FAILED"));
        // Which date broke the test?
        if (!success)
            System.out.printf("\nThe offending date is %s.\n" +
                            "\tJava's method says it's a %s.\n" +
                            "\t  Your method days it's a %s.\n\n",
                    testChronos, whatJavaSays, whatOurMethodSays);
    }
}
