import java.util.Scanner;

public class PhoneNumbersStarter
{
    public static void main(String[] args)
    {
		/* Two parallel arrays to hold phone numbers and names
			ith name matches ith phone number; 0 indicates number unknown
			the L tag at the end of the numbers makes them a java long primitive type
			(necessary to fit 10 digits)
			You may extend these arrays but DO NOT modify the types
		 */
        long[] numbers = {9876543210L, 0, 3129152000L, 9094567890L, 3034061234L, 0, 0, 8133774578L,0,0};
        String[] names = {
                "Adam Smith",
                "George Washington",
                "Alexander Hamilton",
                "Thomas Payne",
                "Betsy Ross",
                "Martha Washington",
                "Deborah Sampson",
                "Patience Wright",
                "Leo",
                "Riya"};

        updateNumbers(numbers,names);
    }

    /**
     * Ask the user to update zero or more phone numbers using a Scanner170 object. User enters name
     * of person, if that person found in people parameter, then allow update of corresponding phone number
     * in phoneNumbers parameter.
     *
     * Loop asking for names for which to update the phone number until user enters *Done*
     *
     * @param phoneNumbers - array of phone numbers in order matching names (0 indicates number unknown)
     * @param people - array of people names in same order as phone numbers
     * @return boolean true if any numbers were changed; false if no numbers changed successfully (for
     * 			example if user never enters a name found in people
     *
     * 	TO DO: Enter the rest of your pseudo code here (give details on how you will process user requests,
     * 	search and make changes.
     */
    public static boolean updateNumbers(long[] phoneNumbers, String[] people) {
        final String terminatingString = "*Done*"; // terminating string; when entered, exit method.
        Scanner s = new Scanner(System.in);
        String personLookingFor; // the String we'll be reading from the keyboard

        // setup a loop to run while the String input is not equal to the terminatingString
        do {
            System.out.printf("\nEnter name to look for: ");
            personLookingFor = s.next();
            if ( !personLookingFor.equals(terminatingString) ) { // input string != terminatingString
                // see if this person exists in people[]
                int i = 0; // start at the first element of the array
                while ( i < people.length && ( ! people[i].equals(personLookingFor) ) ) {
                    /*  -----------------      ------------------------------------
                        condition to           now that the first condition
                        prevent the value      here guarantees that i is a
                        of i from              legal value, we can check
                        exceeding the          if the i-th element of
                        length of the          people[] is not equal
                        array; thus            to the personLookingFor,
                        avoiding an            and advance i to the
                        out of bounds          next value.
                        error.
                    */
                    i++;
                }
                /*
                At this point variable i can have one of the possible two values: either is is
                less that the people.length or it is not. If i < people.length, it
                points to the element in array people[] that is equal to the
                personLookingFor. If not, then the personLookingFor does not exist
                in array people[].
                 */
                if ( i >= people.length) {
                    System.out.printf("\n*** %s is not in the array ***\n", personLookingFor);
                } else {
                    System.out.printf("\n*** %s is in position [%d] and you may proceed with changing the number ***\n",personLookingFor,i);
                }
            }
        } while ( !personLookingFor.equals(terminatingString) ); // terminating condition for reading data from keyboard
        return false;
    }

    /**
     * Show the full set of names and phone numbers in the format indicated in the assignment
     * (Display them to the console)
     *
     * @param phoneNumbers- array of phone numbers in order matching names (0 indicates number unknown)
     * @param people- array of people names in same order as phone numbers
     *
     * TO DO:  Enter full pseudo code here (give details about how you will process the input parameters
     *              and how you will create the correct format.  If helpful, mention key variables to use
     *
     *
     *
     *
     */
    public static void showPhoneNumbers(long[] phoneNumbers, String[] people) {
        //TO DO:  write your code here
    }

}