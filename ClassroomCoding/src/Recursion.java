public class Recursion {

    public static long factorial(long n) {
        if (n == 0)
            return 1;
        return n*factorial(n-1);
    }

    public static long factTail(long n, long acc) {
        if (n == 1) return acc;
        return factTail(n - 1, n * acc);
    }

    public static void main(String[] args) {
        long n = 20L;
        long t = System.nanoTime();
        System.out.printf("\n%d! = %d, in %d nsec\n", n,factorial(n), System.nanoTime()-t);
        t = System.nanoTime();
        System.out.printf("\n%d! = %d, in %d nsec\n", n, factTail(n,1), System.nanoTime()-t);    }


}
