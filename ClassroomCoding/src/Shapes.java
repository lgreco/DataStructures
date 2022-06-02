public class Shapes {

    public static void plain() {

        int L = 7;  // height of diamond shape
        int L2 = (int) Math.ceil(L/2.0);
        System.out.printf("Height is %d lines with midpoint at line %d\n\n", L, L2);
        for (int i = 1; i <= L; i++) {
            if (i <= L2) {
                for (int j = 1; j <= L2 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <=i-L2 ; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <=2*(L-i)+1 ; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void twoLoops() {
        int L = 7;
        int L2 = (int) Math.ceil(L / 2.);
        for (int i = 1; i < L2; i++) {
            for (int j = 1; j <= L2 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = L2; i <= L; i++) {
            for (int j = 1; j <= i - L2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (L - i) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void x() {
        System.out.println("+----+");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\\    /");
            System.out.println("/    \\");
        }
        System.out.println("+----+");
    }

    public static void main(String[] args) {
        plain();
        System.out.println();
        twoLoops();
        System.out.println();
        x();
    }
}
