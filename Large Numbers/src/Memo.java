public class Memo {

    static final int EXPERIMENTS = 500000;
    static final long N_MAX = 5685;
    static final long N_STEPS = 50;
    static long[] memo = new long[(int)N_MAX]; // memoization device
    static final long CUT_OFF_TIME = 5L; // stop classic recursion after that
    static boolean performClassicRecursion = true;

    /**
     * Wrapper method for tail recursion. Calls tail recursive version
     * @param n
     * @return Fibonacci value for n
     */
    public static long tailFibonacci(int n) {
        return tailFibonacci(n,0,1);
    }

    /**
     * Tail recursion computed Fibonacci by traversing sequence from
     * back to front.
     * @param count Count down along the back-to-front sequence
     * @param a current term
     * @param b previous term
     * @return Fibonacci number for count
     */
    public static long tailFibonacci(int count, long a, long b){
        if (count!=0)
            return tailFibonacci(count-1,b,a+b);
        return a;
    }

    public static long fastFibonacci(long n) {
        long fibo = 0;
        if (n<=1L) {
            return n;
        } else if (memo[(int)n]!=0) {
            return memo[(int)n];
        } else {
            fibo = fastFibonacci(n-1L) + fastFibonacci(n-2L);
            memo[(int)n] = fibo;
            return fibo;
        }
    }

    public static long classicFibonacci(long n) {

        if (n<=1L) {
            return n;
        } else {
            return classicFibonacci(n - 1) + classicFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {

        long nFrom = 2L;
        long nTo = N_MAX;
        long step = (nTo - nFrom)/N_STEPS;

        long startTime,
                fClassic, classicTime=0,
                fTail=0L, tailTime,
                fMemo=0L, memoTime;

        for (long n = nFrom; n <= 1000L; n+=5) {
            if (performClassicRecursion) {
                startTime = System.currentTimeMillis();
                for (int i = 0; i < EXPERIMENTS; i++) {
                    fClassic = classicFibonacci(n);
                }
                classicTime = System.currentTimeMillis() - startTime;
                performClassicRecursion = (classicTime < CUT_OFF_TIME);
            }

            startTime = System.currentTimeMillis();
            for (int i = 0; i < EXPERIMENTS; i++) {
                fMemo = fastFibonacci(n);
            }
            memoTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();
            for (int i = 0; i < EXPERIMENTS; i++) {
                fTail = tailFibonacci((int) n);
            }
            tailTime = System.currentTimeMillis() - startTime;

            System.out.printf("\n fastF(%d) = %d, tailF(%d) = %d", n, fMemo, n, fTail);
        }
    }
}
