public class SpinTop {

    public static final int SIZE = 3;

    /**
     * Prints a single line with the basic axle pattern, i.e.,
     * a number of preceding spaces following by the two
     * vertical bars. The number of preceding spaces is SIZE-1
     */
    public static void axleBasis() {
        for (int i = 1; i < SIZE; i++) {
            System.out.print(" ");
        }
        System.out.print("||");
        System.out.println();
    } // method axleBasis


    /**
     * Calls the axleBasis method a number of times, determined
     * by variable SIZE, to form the long structure of the spintop
     */
    public static void axle() {
        for (int i = 0; i < SIZE; i++) {
            axleBasis();
        }
    } // method axle


    /**
     * Method to print the top part of the spin's round component
     */
    public static void topRound() {
        for (int i = 1; i <= SIZE-1; i++) {
            for (int j = 1; j <= SIZE-1-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("||");
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    } // method topRound


    /**
     * Method to print the bottom part of the spin's round component
     */
    public static void bottomRound() {
        for (int i = 1; i <= SIZE-1; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= SIZE-i; j++) {
                System.out.print("*");
            }
            System.out.print("||");
            for (int j = 1; j <= SIZE-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    } // method bottomRound


    public static void bottom() {
        for (int i = 0; i < SIZE; i++) {
            widePart();
        }
    }


    /**
     * Method to print the widest part of the spin
     */
    public static void widePart() {
        for (int i = 1; i <= 2*SIZE; i++) {
            System.out.print("=");
        }
        System.out.println();
    } // method widePart

    public static void main(String[] args) {
        axleBasis();
        axle();
        topRound();
        widePart();
        bottomRound();
        axle();
        axle();
        axleBasis();
        bottom();
    }
}
