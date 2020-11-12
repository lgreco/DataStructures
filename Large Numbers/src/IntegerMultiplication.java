/**
 * Demo class to illustrate 4- and 3-call recursive methods for integer multiplication.
 * The 3-call recursion is based on Karatsuba's algorithm. This is based on the lab
 * session of 11/11/2020.
 */
public class IntegerMultiplication {

    /**
     * Standard recursive method to multiply two numbers each with N digits and N a power of 2
     * @param x integer assumed equal to pow(10, N/2)*a + b
     * @param y integer assumed equal to pow(10, N/2)*c + d
     * @return product x*y
     */
    public static int RecursiveMultiplication(int x, int y) {
        int product;
        int n = 1 + (int) Math.log10((double) x); // number of digits
        if ( n==1 ) { // base case
            product = x*y;
        } else { // recursive calls
            int powerOf10 = (int) Math.pow(10, n/2); // compute once, use multiple times
            int a = x / powerOf10; // left half of x
            int b = x - a*powerOf10; // right half of x
            int c = y / powerOf10; // left half of y
            int d = y - c*powerOf10; // right half of y
            int ac = RecursiveMultiplication(a,c);
            int ad = RecursiveMultiplication(a,d);
            int bc = RecursiveMultiplication(b,c);
            int bd = RecursiveMultiplication(b,d);
            product = powerOf10*powerOf10*ac + powerOf10*(ad+bc) + bd;
        }
        return product;
    } // method RecursiveMultiplication

    /**
     * Karatsuba recursive method to multiply two numbers each with N digits and N a power of 2
     * @param x integer assumed equal to pow(10, N/2)*a + b
     * @param y integer assumed equal to pow(10, N/2)*c + d
     * @return product x*y
     */
    public static int RecursiveKaratsuba(int x, int y) {
        int product;
        int n = 1 + (int) Math.log10((double) x); // number of digits
        if ( n==1 ) { // base case
            product = x*y;
        } else { // recursive calls
            int powerOf10 = (int) Math.pow(10, n/2); // compute once, use multiple times
            int a = x / powerOf10; // left half of x
            int b = x - a*powerOf10; // right half of x
            int c = y / powerOf10; // left half of y
            int d = y - c*powerOf10; // right half of y
            int p = a + b; // p sum
            int q = c + d; // q sum
            int ac = RecursiveKaratsuba(a,c);
            int bd = RecursiveKaratsuba(b,d);
            int pq = RecursiveKaratsuba(p,q);
            int adbc = pq - ac - bd; // same as ad+bc
            product = powerOf10*powerOf10*ac + powerOf10*adbc + bd;
        }
        return product;
    } // method RecursiveKaratsuba

    /** Quick test */
    public static void main(String[] args) {
        int x = 5678;
        int y = 1234;
        System.out.printf("\n\n Standard technique: %d times %d is %d", x,y, RecursiveMultiplication(x,y));
        System.out.printf("\n\nKaratsuba technique: %d times %d is %d\n\n", x,y, RecursiveKaratsuba(x,y));
    }
}
