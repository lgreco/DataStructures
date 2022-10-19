public class Recurse {

    static long fact(long n) {
        long product = 1L;
        if (n>0) {
            product = n*fact(n-1);
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(fact(21));
    }
}
