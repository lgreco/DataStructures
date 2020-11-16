public class Fibonacci {

    public static long fibonacci(long n) {
        if ( n == 0 ) {
            return 0;
        } else if ( n == 1 ) {
            return 1;
        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        long N = 45L;
        long start, took, testFib;

        if ( N < 46L ) {
            start = System.nanoTime();
            testFib = fibonacci(N);
            took = System.nanoTime() - start;
            System.out.printf("\n\nConventional Fibonacci recursive computing for %d took %d nsec\n\tFib(%d) = %d", N, took, N,testFib);
        }

        start = System.nanoTime();
        testFib = fastFibonacci(N);
        took = System.nanoTime() - start;
        System.out.printf("\n\nMemoized Fibonacci recursive computing for %d took %d nsec\n\tFib(%d) = %d\n\n", N, took, N,testFib);

    }

    public static long fastFibonacci(long n) {
        long fibo = 0L;
        if ( n == 0 ) {
            return 0;
        } else if ( n == 1 ) {
            return 1;
        } else if ( fibMemo[(int) n] != 0 ) {
            return fibMemo[(int) n];
        } else {
            fibo = fastFibonacci(n-1) + fastFibonacci(n-2);
            fibMemo[(int) n] = fibo;
            return fibo;
        }
    }

    static long[] fibMemo = new long[2000];

}
