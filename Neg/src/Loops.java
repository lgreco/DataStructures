public class Loops {
    public static void main(String[] args) {

        // FOR LOOP
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%5d\n", i);
        }

        // WHILE LOOP EQUIVALENT
        int i = 1;
        while ( i <= 10 ) {
            System.out.printf("\n%5d",i);
            i++;
        }

        // DO LOOP EQUIVALENT
        int j = 1;
        do {
            System.out.printf("\n%5d",j);
            j++;
        } while (j<=10);
    }
}
