public class Square {
    public static void main(String[] args) {
        int N = 15;
        for (int line = 0; line < N; line++) {
            System.out.print(" ".repeat(2*N));
            for (int col = 0; col < N; col++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
