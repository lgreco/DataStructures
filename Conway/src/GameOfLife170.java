import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameOfLife170 {

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.printf("\nSize of the universe: ");
        int N = s.nextInt();
        System.out.printf("\nHow many iterations to run: ");
        int T = s.nextInt();
        System.out.printf("\nInitial density: ");
        double density = s.nextDouble();
        System.out.printf("\n\nImplementing Conway's Game of Life on a %dx%d board over %d iterations and with initial density %.2f.\n\n", N, N, T, density);

        // setup the array
        boolean[][] universe = new boolean[N][N];

        // randomly populate universe
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            for ( int j = 0; j < N; j++) {
                universe[i][j] = (r.nextDouble() < density);
            }
        }

        // iteration loop
        for (int iteration = 1; iteration <= T; iteration++) {
            boolean[][] nextUniverse = new boolean[N][N];
            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < N; j++ ) {
                    int iMinus = Math.abs((i-1)%N);
                    int jMinus = Math.abs((j-1)%N);
                    int iPlus = (i+1)%N;
                    int jPlus = (j+1)%N;
                    int nearestNeighbors = 0;
                    // cardinal neighbors
                    if ( universe[iMinus][j] ) nearestNeighbors++;
                    if ( universe[iPlus][j] ) nearestNeighbors++;
                    if ( universe[i][jMinus] ) nearestNeighbors++;
                    if ( universe[i][jPlus] ) nearestNeighbors++;
                    // diagonal neighbors
                    if ( universe[iMinus][jMinus] ) nearestNeighbors++;
                    if ( universe[iMinus][jPlus] ) nearestNeighbors++;
                    if ( universe[iPlus][jMinus] ) nearestNeighbors++;
                    if ( universe[iPlus][jPlus] ) nearestNeighbors++;
                    // life and death decisions!
                    // .. alive and with 2 or 3 neighbors? Survive!
                    if ( universe[i][j] && (nearestNeighbors == 2 || nearestNeighbors == 3) ) nextUniverse[i][j] = true;
                    // .. dead but with three neighbors? Return to life!
                    if ( !universe[i][j] && nearestNeighbors == 3 ) nextUniverse[i][j] = true;
                    // .. alive wand with fewer than 2 neighbors or more than 3? Die!
                    if ( universe[i][j] && (nearestNeighbors<2 || nearestNeighbors > 3) ) nextUniverse[i][j] = false;
                }
            }
            // next universe complete .. print current universe, then copy next to current
            System.out.printf("\n\nIteration %05d:\n",iteration);
            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < N; j++ ) {
                    // ternary operator below:
                    //    char c = (universe[i][j]) ? '*' : '_';
                    // same as following declaration and if-block together:
                    char c;
                    if (universe[i][j]) {
                        c = '*';
                    } else {
                        c = '_';
                    }
                    System.out.printf("%s ",c);
                }
                System.out.printf("\n");
            }
            // copy nex to current
            universe = nextUniverse;
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
