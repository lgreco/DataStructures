/**
 * Paul Petelski
 * COMP 271
 *
 * Plot a sine function using characters and a 2D array
 *
 */

import java.util.Scanner;

public class Plots {

    public static double toX,fromX, xStep, yStep;
    public static int rows, columns;
    public static String plotCharacter = "*",
            horizontalAxis="-",
            verticalAxis="|",
            intersection="+",
            spaceCharacter=" ";
    public static double minY=Double.MAX_VALUE, maxY=Double.MIN_VALUE; // initialize min and max value
    public static String[][] screen;


    /**
     * Function to plot
     */
    public static double f(double x){
        return Math.sin(x);
    }

    public static void collectData(){
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to your 1980s plotter!\n");
        System.out.printf("What range of x do you want?\nFrom x = ");
        fromX = s.nextDouble();
        System.out.printf("to x = ");
        toX = s.nextDouble();
        System.out.printf("\nwhat resolution do you want?\nHow many rows? ");
        rows = s.nextInt();
        System.out.printf("and how many columns? ");
        columns = s.nextInt();
        System.out.printf("\nFinally, what is your plot character? [*] ");
        plotCharacter = s.next();
        // derive steps
        xStep = Math.abs(fromX-toX)/(double) columns;
        // find the min and max
        findMinMax();
        // find yStep after est. min and max values for function
        yStep= Math.abs(maxY-minY)/((double) rows);
        //report summary of computations
        System.out.printf("We'll plot the function from %.3f to %.3f on a %d x %d grid\n", fromX, toX, rows, columns);
        System.out.printf("\nThe dx is %.4f. The dy is %.4f with min = %.3f and max = %.3f", xStep, yStep, minY, maxY);

    } // method collectData

    // how to switch to int in loop
    public static void findMinMax(){
        for (double x = fromX; x < toX; x += xStep){
            double y = f(x);
            minY = (y<minY) ? y : minY; // ternary operator --- same as if statement
            maxY = (y>maxY) ? y : maxY;
        }
    } // method findMinMax

    public static void plot(){
        // create 2D array
        screen= new String[rows][columns];
        System.out.println();
        // x value
        double x=fromX;

        for (int j=0; j<columns;j++){
            double y=f(x);
            int convertedX = (int) x;
            x = x + xStep;

            //System.out.println(y);

            //convert y into int
            int convertedY = (int) ((rows-1)*((maxY-y)/(maxY-minY)));

            for (int i=0; i<rows; i++){

                // if y value is equal to the row number
                if (convertedY==i){
                    screen[i][j] = "*";
                }
                else {
                    screen[i][j] = " ";
                }

               // System.out.print(screen[i][j]);
            }
            //System.out.println();
            //System.out.println(convertedX + "...." + convertedY);
        }




    } // method plot

    public static void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <columns; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }


    // method prints out the x's and f(x)'s rounded
    public static void findPlot(){
        // find the y value
        // i = x value
        System.out.println();
        // print out x and value of f(x)
        for (double i=fromX; i<=columns; i+=xStep){
            System.out.println("x = " + i + " " + "f(x)= " +Math.round(f(i)*30));
        }
    }

    public static void main(String[] args) {
        collectData();
        //findPlot();
        plot();
        display();

    } // method main



}