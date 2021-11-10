public class Recursion {

    static public int fibo(int n) {
        if (n == 1 || n == 0)
                return n;
        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 111; i++) {
            if (i > 1) {
                System.out.printf("\nF(%d) = F(%d) + F(%d) = %d", i, i - 1, i - 2, fibo(i));
            } else {
                System.out.printf("\nF(%d) = %d", i, fibo(i));
            }
        }
    }
}
