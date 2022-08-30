import java.time.LocalDate; // Use only for testing
import java.time.format.TextStyle; // Use only for testing
import java.util.Locale; // Use only for testing

public class Chapter4_ProgrammingProject2 {

    // CLASS CONSTANTS

    /** Names of days, with Sunday as day [0] */
    private static final String[] DAY_OF_THE_WEEK = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};

    /** Start counting days from Jan 1, 1601 */
    private static final int BASE_YEAR = 1601;
    private static final int BASE_MONTH = 1;
    private static final int BASE_DAY = 1;

    /** What day of the week is Jan 1, 1601? Monday (array index [1]) */
    private static final int BASE_DOW = 1;

    /** How may days in the week */
    private static final int DAYS_IN_WEEK = 7;
    /** What's the int value for last month of the year */
    private static final int LAST_MONTH = 12;

    /** Array index for method that returns date as an array */
    private static final int YEAR_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int DAY_INDEX = 2;


    /**
     * Tests if the combination of year, month, day can form a valid date.
     * For example 2022, 4, 31 is not a valid group of numbers because April
     * has only 30 days.
     *
     * This is useful for when we prompt user to enter a date, as it will
     * reject entries like 2022 17 42 or 2022 06 31 etc.
     *
     * @param year  )
     * @param month )  Group of values to check if they form valid date.
     * @param day   )
     *
     * @return true if group of int above forms valid date
     */
    public static boolean isDateValid(int year, int month, int day) {
        return ((year >= 1601) &&
                (month >=1 && month <=12) &&
                (   (month31(month) && day <= 31) ||
                    (month30(month) && day <= 30) ||
                    (isLeapYear(year) && month == 2 && day <= 29) ||
                    (!isLeapYear(year) && month == 2 && day <=28)));
    }  // method isDateValid


    /**
     * Helper method to identify a 31-day month.
     *
     * @param month
     * @return true if this month has 31 days.
     */
    private static boolean month31(int month) {
        return (month == 1 || month == 3 ||
                month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12);
    }  // method month31


    /**
     * Helper method to identify a 30-day month.
     * @param month
     * @return true if this month has 31 days.
     */
    private static boolean month30(int month) {
        return (month == 4 || month == 6 ||
                month == 9 || month == 11);
    }  // method month30


    /**
     * Determine if a year is a leap year. A leap year is divisible by 4.
     * Century years are not leap years unless they are divisible by 400.
     *
     * @param year int to evaluate
     *
     * @return true if passed argument is leap year; false otherwise.
     */
    public static boolean isLeapYear(int year) {
        return (((year % 4 == 0) && (year % 100!= 0)) ||
                (year % 400 == 0) );
    }  // method isLeapYear


    /**
     * Determines if a given date falls on the last day of a month.
     *
     * The method comprises a single return statement, broken over multiple
     * lines. The first 11 conditions check for the months with fixed days,
     * ie all months except February. The last condition checks for February,
     * which may have 29 or 28 days. To keep the code compact, ie, a single
     * return statement, we use the ternary operator to tell if it's a leap
     * year, and determine when February should end.
     *
     * @return true if date falls on last day of a month, false otherwise.
     */
    public static boolean isLastDayOfMonth(int year, int month, int day) {
        return (
                (month ==  1 && day == 31) ||
                        (month ==  3 && day == 31) ||
                        (month ==  4 && day == 30) ||
                        (month ==  5 && day == 31) ||
                        (month ==  6 && day == 30) ||
                        (month ==  7 && day == 31) ||
                        (month ==  8 && day == 31) ||
                        (month ==  9 && day == 30) ||
                        (month == 10 && day == 31) ||
                        (month == 11 && day == 30) ||
                        (month == 12 && day == 31) ||
                        (isLeapYear(year) ?
                                (month == 2 && day == 29) :
                                (month == 2 && day == 28))
        );
    }  // method isLastDayOfMonth


    /**
     * Determines if is the last month of the year.
     *
     * @return true if month is December (12)
     */
    public static boolean isLastMonthOfYear(int month) {
        return month == LAST_MONTH;
    }  // method isLastMonthOfYear


    /**
     * Determines if day is the last day of the year.
     *
     * @return true if day is the last day of the month and month
     * is the last month of the year.
     */
    public static boolean isLastDayOfYear(int year, int month, int day) {
        return (isLastMonthOfYear(month) && isLastDayOfMonth(year, month, day));
    }  // method isLastDayOfYear


    /**
     * Determines order between two dates.
     *
     * @param yearA  )
     * @param monthA ) Elements of first date
     * @param dayA   )
     *
     * @param yearB  )
     * @param monthB ) Elements of second date
     * @param dayB   )
     *
     * @return a negative number if date A is prior to date B, 0 if both dates
     * are the same, or a positive number if date A is after date B.
     */
    public static int compareTo(int yearA, int monthA, int dayA,
                         int yearB, int monthB, int dayB) {
        return (yearA-yearB)*10000 +
                (monthA-monthB)*100 +
                dayA-dayB;
    }  // method compareTo


    /**
     * Determines if two dates are equal.
     *
     * The method calls compareTo and expects it to return a 0, to establish
     * that dates A and B are the same.
     *
     * @param yearA  )
     * @param monthA ) Elements of first date
     * @param dayA   )
     *
     * @param yearB  )
     * @param monthB ) Elements of second date
     * @param dayB   )
     *
     * @return true if date A same as date B.
     */
    public static boolean equal(int yearA, int monthA, int dayA,
                                int yearB, int monthB, int dayB) {
        return compareTo(yearA, monthA, dayA, yearB, monthB, dayB) == 0;
    }  // method equal


    /**
     * Counts the number of days between two dates.
     *
     * @param yearA  )
     * @param monthA ) Elements of first date
     * @param dayA   )
     *
     * @param yearB  )
     * @param monthB ) Elements of second date
     * @param dayB   )
     *
     * @return int count of days between date A and date B.
     */
    public static int difference(int yearA, int monthA, int dayA,
                                 int yearB, int monthB, int dayB) {
        // Establish which of the two input dates is earlier and which later.
        int earlierYear, earlierMonth, earlierDay,
            laterYear, laterMonth, laterDay;
        if (compareTo(yearA, monthA, dayA, yearB, monthB, dayB) < 0) {
            earlierYear = yearA;
            earlierMonth = monthA;
            earlierDay = dayA;
            laterYear = yearB;
            laterMonth = monthB;
            laterDay = dayB;
        } else {
            earlierYear = yearB;
            earlierMonth = monthB;
            earlierDay = dayB;
            laterYear = yearA;
            laterMonth = monthA;
            laterDay = dayA;
        }
        // Initialize count of days
        int count = 0;
        // Advance the earlier day, one day at a time, until matches later one.
        while (!equal(earlierYear, earlierMonth, earlierDay,
                laterYear, laterMonth, laterDay)) {
            int[] tomorrow = advanceByOneDay(
                    earlierYear,
                    earlierMonth,
                    earlierDay);
            earlierYear = tomorrow[YEAR_INDEX];
            earlierMonth = tomorrow[MONTH_INDEX];
            earlierDay = tomorrow[DAY_INDEX];
            count++;
        }
        return count;
    }  // method difference


    /**
     * Advances a date by one day.
     *
     * @param year  )
     * @param month ) Elements of date to advance
     * @param day   )
     *
     * @return an array with the next date from the input elements. The array
     * has the year, month, and day information in positions YEAR_INDEX,
     * MONTH_INDEX, and DAY_INDEX respectively.
     *
     */
    public static int[] advanceByOneDay(int year, int month, int day) {
        // Output array
        int[] tomorrow = new int[3];
        // Assign give date values to array -- not all elements may change,
        // for example May 5 + 1 day is May 6: month value remains same.
        tomorrow[YEAR_INDEX] = year;
        tomorrow[MONTH_INDEX] = month;
        tomorrow[DAY_INDEX] = day;
        // Check for boundaries between month or year transitions.
        if (isLastDayOfMonth(year, month, day)) {
            if (isLastMonthOfYear(month)) {
                tomorrow[YEAR_INDEX] = ++year;  // advance year
                tomorrow[MONTH_INDEX] = 1;  // Set month to Jan
                tomorrow[DAY_INDEX] = 1;  // Set date to Jan 1
            } else {
                tomorrow[MONTH_INDEX] = ++month;  // advance month
                tomorrow[DAY_INDEX] = 1; // Set date to month 1st.
            }
        } else {
            tomorrow[DAY_INDEX] = ++day;  // advance day
        }
        return tomorrow;
    }  // method advanceByOneDay


    /**
     * Compute day of week for a given date.
     *
     * The method uses 1/1/1601 -- a Monday -- as the basis.
     *
     * @param year  )
     * @param month ) The date whose day of week we wish to know
     * @param day   )
     *
     * @return String with day of week for above date.
     */
    public static String dayOfWeek(int year, int month, int day) {
        // How many days between basis date and given date?
        int diffFromBase = difference(
                year, month, day,
                BASE_YEAR, BASE_MONTH, BASE_DAY);
        // Convert this difference on an index for the array with day names.
        return DAY_OF_THE_WEEK[(BASE_DOW+diffFromBase%DAYS_IN_WEEK)%DAYS_IN_WEEK];
    }  // method dayOfWeek


    /** Test code */
    public static void main(String[] args) {
        // We start testing from this January 1, 1601.
        int testYear = BASE_YEAR;
        int testMonth = BASE_MONTH;
        int testDay = BASE_DAY;
        // Use today as the date to find its day-of-the-week
        int nowYear = LocalDate.now().getYear();
        int nowMonth = LocalDate.now().getMonthValue();
        int nowDay = LocalDate.now().getDayOfMonth();
        // Tracking the success of testing;
        boolean success = true;
        // Count the testing comparisons.
        int counter = 0;
        // String with day of the week obtain by Java and by our methods.
        String whatJavaSays, whatOurMethodSays;
        // Begin displaying test progress.
        System.out.printf("\n\nTesting ");
        /*
        The principal loop continues until the test fails because of two
        mismatched dates or until we get passed today's date.
         */
        do {
            // Day of the week for test date, according to Java
            whatJavaSays = LocalDate.of(testYear,testMonth,testDay).getDayOfWeek().
                    getDisplayName(TextStyle.FULL, Locale.US);
            // Day of the week for test date, according to our method
            whatOurMethodSays = dayOfWeek(testYear,testMonth,testDay);
            // Our method must agree with Java's result.
            success = whatJavaSays.equals(whatOurMethodSays);
            // Advance dates
            int nextDate[] = advanceByOneDay(testYear,testMonth,testDay);
            testYear = nextDate[YEAR_INDEX];
            testMonth = nextDate[MONTH_INDEX];
            testDay = nextDate[DAY_INDEX];
            // Increment the number of comparisons.
            counter++;
            // Print a dot now and then to show progress
            if (counter%500==0)
                System.out.printf(".");
            if (counter%25000==0)
                System.out.printf("\n        ");
            // End testing when we reach today's date or as soon as our method
            // doesn't match Java's result.
        } while (success && !equal(testYear,testMonth,testDay,nowYear,nowMonth,nowDay));
        // Report
        System.out.printf("\n\nTest report:\n\t" +
                        "After %,d comparisons, your method %s the test.\n\n",
                counter, ((success) ? "passed": "FAILED"));
        // Which date broke the test?
        if (!success)
            System.out.printf("\nThe offending date is %4d-%02d-%02d.\n" +
                            "\tJava's method says it's a %s.\n" +
                            "\t  Your method days it's a %s.\n\n",
                    testYear, testMonth, testDay, whatJavaSays, whatOurMethodSays);
    }  // method main

}  // class Chapter4_ProgrammingProject2
