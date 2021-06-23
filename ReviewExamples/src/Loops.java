public class Loops {
    public static void main(String[] args) {

        /*
        DIRECT ENGINEERING: a single for loop statement that produces the first 12
        Fibonacci numbers:
           1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        The k-th term Fk in the Fibonacci sequence is F(k)=F(k−1)+F(k−2),
        with initial values F(1)=1 and F(2)=1.
         */

        int numberOfTerms = 12; // how many numbers?
        int minusOne = 1; // initialize F(k-1)
        int minusTwo = 1; // initialize F(k-2)
        int fibo; // the Fibonacci number

        System.out.printf("\n\nThe first %d Fibonacci numbers.\n\n",numberOfTerms);
        for (int k = 1; k <= numberOfTerms; k++) {
            if (k<3) {
                fibo = 1;
            } else {
                fibo = minusOne + minusTwo;
                minusTwo = minusOne;
                minusOne = fibo;
            }
            System.out.printf("F(%d) \t=%5d\n",k,fibo);
        }

        /*
        REVERSE ENGINEERING: a single for loop statement that produces
        the following numbers:
           0, 1, 3, 8, 21, 55, 144, 377, 987, 2584, 6765
        Hint: so far we have written simple for-loops where the increment part
        remains the same, e.g., i++, or i=i+2, etc. This may not always be the case.

        ANALYSIS OF THE PROBLEM. There are 11 terms in the sequence. When
        we look at the difference between successive terms we observe the following:

             terms: 0, 1, 3, 8, 21, 55, 144, 377, 987, 2584, 6765
        difference:   1  2  5  13  34  89  233  610  1597  4181

        Examining a term, e.g., 55, we notice that it is equal to the
        previous term (in this case 21) plus a step (34) that is equal to 21+13,
        ie the previous term (21) and its distance (13) from its previous ter (8).

        We can try and establish a pattern:

        index                  k-2     k-1      k
        term  t()         ...  8  ...  21  ...  55  ...
        diff                       13

        Here 55 = 21 + 21 + (21-8), and the corresponding pattern is

           t(k) = 3 * t(k-1) - t(k-2)

        with t(1) = 0 and t(2) = 1. So we can write a simple loop, as follows

        int numberOfFunnyTerms = 11;
        int t1 = 0, t2=1;
        int funnyTerm;
        for (int i = 1; i <= numberOfFunnyTerms; i++) {
            if (i==1) {
                funnyTerm = t1;
            } else if (i==2) {
                funnyTerm = t2;
            } else {
                funnyTerm = (3*t2) - t1;
                t1 = t2;
                t2 = funnyTerm;
            }
            System.out.printf("%d\n",funnyTerm);
        }

        But we don't want to make things too easy! The problem suggests that we
        use a variable step in the loop, i.e., instead of i++ we try something
        like
           i = i + somethingChangingAtEveryIteration.
        So we are going back to the drawing table and try to find another
        pattern in the sequence:

             terms: 0, 1, 3, 8, 21, 55, 144, 377, 987, 2584, 6765

        Looking at the term 55, we notice that it can be written as

           55 = previous term + sum of all previous terms + 1
                      21           21+8+3+1+0               1
                      21       +       33          +        1

         And here's our variable step:

            i = i + sum of all previous terms + 1

         Let's try it out.
         */

        int upTo = 6765; // ending value for the sequence
        int previousTerm;
        int sumAllPrevious = 1; // becomes the +1 we need

        System.out.printf("\n\nA few funny terms.\n\n");
        for (int i = 0; i <= upTo; i += sumAllPrevious) {
            System.out.printf("%d\n",i);
            previousTerm = i;
            sumAllPrevious += previousTerm;
        }
    }
}