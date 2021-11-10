public class Recursion002 {

    public static int fact(int n) {
        if (n == 0)
            return 1;
        return n*fact(n-1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static long fastFibonacci(int n) {
        long previous = 1L;
        long previousPrevious = 0L;
        long current = previous + previousPrevious;
        int i = 0;
        while (i < n) {
            previousPrevious = previous;
            previous = current;
            current = previous + previousPrevious;
            i++;
        }
        return current;
    }

    public static void main(String[] args) {
        for (int n = 0; n <100; n++) {
            System.out.printf("\nF(%d) = %d", n, fastFibonacci(n));
        }
    }
}
