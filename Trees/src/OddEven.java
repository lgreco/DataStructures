import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int evenOrOdd = e.nextInt();
        // int n = evenOrOdd % 2;
        // // System.out.print("The number " + evenOrOdd + " is ");
        String parity;
        if ( (evenOrOdd % 2) == 0 ) {
            // System.out.println(evenOrOdd+" is even.");
            // // System.out.print("even.");
            parity = "even";
        } else {
            // System.out.println(evenOrOdd+" is odd.");
            // // System.out.print("odd.");
            parity = "odd";
        }
        System.out.println("The number " + evenOrOdd + " is " + parity + ".");
    }
}
