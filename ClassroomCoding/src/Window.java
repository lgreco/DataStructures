public class Window {

    public static final int SIZE = 6;

    public static void frame() {
        for (int i = 1; i <= 2 ; i++) {
            System.out.print("+");
            for (int j = 1; j <= SIZE ; j++) {
                System.out.print("=");
            }
        }
        System.out.print("+");
        System.out.println();
    }

    public static void main(String[] args) {
        frame();
    }

}
