public class RecursionExamples {

    static long factorialIterative(long n) {
        long fact = 1;
        for (long i = 1; i <= n; i++)
            fact = fact * i;
        return fact;
    }

    static long factorialResursive(long n) {
        if (n==0L)
            return 1L;
        return n*factorialResursive(n-1L);
    }

    public static void main(String[] args) {
        System.out.println(factorialIterative(5L));
        System.out.println(factorialResursive(5L));
    }
}
