public class firstN {
    static final int SIZE = 5;


    // Your code should include a class variable called SIZE
    // and at least two (actually just two) methods. Please
    // use descriptive names for these methods, properly capitalized.
    // For example, if a method computes the trajectory of a
    // comet, you may want to call it findTrajectory.

    // Add comments to your code, explaining what you are doing.

        // code for method main goes here
        public static void leftTriangle() {
            for (int i = 1; i <= SIZE - 2; i++) {
                for (int j = 1; j <= i; j++)
                    System.out.print("*");
                System.out.println();
                System.out.print("\"S=\"+SIZE.");
                System.out.println();
            }
        }


        public static void centerTriangle() {
            for (int i = 1; i <= SIZE; i++) {
                for (int j = 1; j <= i; j++)
                    System.out.print("*");
                System.out.println();
                System.out.print("\"S=\"+SIZE.");
                System.out.println();
            }
        }


        public static void main(String[]args){
            leftTriangle();
            centerTriangle();
        }
    }