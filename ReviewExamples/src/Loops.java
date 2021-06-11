public class Loops {
    public static void main(String[] args) {
        int step = 1;
        for (int i = 0; i < 10000; i=i+step) {
            System.out.println(i);
            step=step+i;
        }
    }
}
