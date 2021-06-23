public class Batman {

    /**
     * Looks at a 4-digit number in the form of
     *    a x 1000 + b x 100 + c x 10 + d x 1
     * and checks against the Batman address criteria:
     * 	 All four digits are different
     * 	 The digit in the thousands place is three times the digit in the tens place
     * 	 The number is odd
     *   The sum of the digits is 27
     * @return Four digit number that meets criteria, or -1 if no such number exist
     */
    static int bruteForce() {
        int address = -1 ;
        for (int a = 0; a < 10; a++) { // thousands
            for (int b = 0; b < 10; b++) { // hundreds
                for (int c = 0; c < 10; c++) { // tens
                    for (int d = 0; d < 10; d++) { // units
                        if ( a == 3*c ) {
                            if (a != b && b != d && a != d) {
                                if (a+b+c+d == 27 ) {
                                    if ((a * 1000 + b * 100 + c * 10 + d)%2==1) {
                                        address = (a * 1000 + b * 100 + c * 10 + d);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return address;
    }

    static int elegant() {
        int address = -1;
        int a = 9;
        int c = 3;
        for (int d = 1; d < 9; d=d+2) {
            for ( int b = 0; b < 9; b=b+2) {
                int z = a * 1000 + b * 100 + c * 10 + d;
                //System.out.println(z);
                if (a+b+c+d == 27) {
                    address = z;
                }
            }
        }
        return address;
    }

    public static void main(String[] args) {
//        System.out.println(bruteForce());
        System.out.println(elegant());
    }
}
