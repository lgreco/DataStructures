/**
 * Testing/driver class for implementations of the Flexibility interface.
 * The interface should be implemented as:
 *
 *   public class FlexibleArray implements Flexibility { . . .}
 *
 * in order to be used with the following class.
 */
public class FlexibilityDriver {
    public static void main(String[] args) {

        /*
        VERY IMPORTANT to implement the Flexibility interface as a class called
        FlexibleArray, otherwise the following instantiation will not work.
         */
        FlexibleArray flex = new FlexibleArray();
        int test[] = flex.newArray();
        for ( int i = 1; i <= 4096; i ++) {
            test = flex.addElement(i);
            if (i%test.length==0) {
                System.out.println(test.length);
            }
        }
        test = flex.addElement(5000,1+test.length);
        System.out.println(test.length);
    }
}
