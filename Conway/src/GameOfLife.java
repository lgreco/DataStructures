import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Transient;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameOfLife extends JPanel {

    private static final int PIXELS_PER_CELL = 4;
    private static final double DEFAULT_PROBABILITY = 0.05;
    private boolean[][] currentUniverse; // current generation
    private boolean[][] nextUniverse; // next generation
    private static final Random r = new Random(); // RNG
    private int generationCounter;
    private int rows, cols; // array size -- better than accessing .length and [i].length all the time

    /**
     * Constructor to setup size of universe. Size is derived from the dimensions of the
     * display window, expresses as width x height pixels. I use more than one pixels
     * per cell, for better display: each cell is PIXELS_PER_CELL x PIXELS_PER_CELL
     * large, and I need to scale the width and height accordingly to obtain the size
     * of the array.
     * @param width graphic output width in pixels
     * @param height graphic output height in pixels
     */
    public GameOfLife(int width, int height) {
        this.rows = width / PIXELS_PER_CELL; // how many rows
        this.cols = height / PIXELS_PER_CELL; // how many columns
        currentUniverse = new boolean[rows][cols];
        nextUniverse = new boolean[rows][cols];
        initialize(DEFAULT_PROBABILITY);
    } // constructor GameOfLife

    /**
     * Method to initialize grid, randomly, based on a given probability to
     * mark a cell alive or dead. This version of the GoL works with any
     * rectangular dimensions, so the number of rows and the number of columns
     * may not always be equal. Method is private as it is only called from
     * constructor.
     *
     * @param probability
     */
    private void initialize(double probability) {
        for (int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++ ) {
                currentUniverse[i][j] = (r.nextDouble() < probability);
            }
        }
    } // method initialize


    /**
     * The main engine. Scans the array, computes the fate of each cell, stores it
     * in nextUniverse[][], and at the end copies nextUniverse to currentUniverse
     */
    private void updateUniverse() {

        for ( int i = 0; i < rows; i++ ) { // for each row ...
            for (int j = 0; j < cols; j++) { // for each column ...

                // we are examining the cell at row [i], column [j]

                // do some math upfront

                int iMinus = Math.abs((i - 1) % rows);
                int jMinus = Math.abs((j - 1) % cols);
                int iPlus = (i + 1) % rows;
                int jPlus = (j + 1) % cols;

                int nearestNeighbors = 0; // number of neighbors for this cell

                // cardinal neighbors
                if (currentUniverse[iMinus][j]) nearestNeighbors++; // north
                if (currentUniverse[iPlus][j])  nearestNeighbors++; // south
                if (currentUniverse[i][jMinus]) nearestNeighbors++; // west
                if (currentUniverse[i][jPlus])  nearestNeighbors++; // east
                // diagonal neighbors
                if (currentUniverse[iMinus][jMinus]) nearestNeighbors++; // northwest
                if (currentUniverse[iMinus][jPlus])  nearestNeighbors++; // northeast
                if (currentUniverse[iPlus][jMinus])  nearestNeighbors++; // southwest
                if (currentUniverse[iPlus][jPlus])   nearestNeighbors++; // southeast

                // life and death decisions!

                // .. alive and with 2 or 3 neighbors? Survive!
                if (currentUniverse[i][j] && (nearestNeighbors == 2 || nearestNeighbors == 3))
                    nextUniverse[i][j] = true;
                // .. dead but with three neighbors? Return to life!
                if (!currentUniverse[i][j] && nearestNeighbors == 3)
                    nextUniverse[i][j] = true;
                // .. alive and with fewer than 2 neighbors or more than 3? Die!
                if (currentUniverse[i][j] && (nearestNeighbors < 2 || nearestNeighbors > 3))
                    nextUniverse[i][j] = false;
            }
        }
        currentUniverse = nextUniverse;
        generationCounter++;
    }

    /**
     * Output window size as a Dimension object to be used by Graphics g instance later
     * @return Dimension object of graphics display in pixels
     */
    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(currentUniverse.length * PIXELS_PER_CELL, currentUniverse[0].length * PIXELS_PER_CELL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();

        g.drawString("Generation: " + generationCounter, 0, 10);
        for (int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++ ) {
                if (currentUniverse[i][j]) {
                    g.setColor(Color.magenta);
                    g.fillRect(j * PIXELS_PER_CELL, i * PIXELS_PER_CELL, PIXELS_PER_CELL, PIXELS_PER_CELL);
                }
            }
        }
        g.setColor(gColor);
    }

    public static void main(String[] args) {
        final GameOfLife c = new GameOfLife(1024, 1024);
        JFrame frame = new JFrame(); // the display window
        frame.getContentPane().add(c);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        new Timer(10, new ActionListener() { // repaint every 10 msec -

            @Override
            public void actionPerformed(ActionEvent e) {
                c.updateUniverse();
                c.repaint();
            }
        }).start();
    }
}