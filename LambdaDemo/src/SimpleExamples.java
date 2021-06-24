import java.util.ArrayList;

public class SimpleExamples {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach( n -> { n=n+222;}  );
        numbers.forEach( n -> {
            System.out.println(n);
        });
        }
    }
