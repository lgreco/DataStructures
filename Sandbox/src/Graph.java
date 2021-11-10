import java.util.ArrayList;

/**
 * Class with MST and other graph techniques.
 *
 *     The class requires an adjacency matrix G to be instantiated. It sets up two
 *     more class-wide fields: marked[] to mark all visited vertices, and comp{}
 *     to label every vertex with its component number.
 */
public class Graph {

    /** The adjacency matrix of the graph to process */
    int[][] G;

    /** Visited status of vertices */
    boolean[] marked;

    /** Labeling vertices with their component number */
    int[] comp;


    /**
     * Basic constructor.
     *
     * @param G Adjacency matrix for the graph to process
     */
    public Graph(int[][] G) {
        this.G = G;
        this.marked = new boolean[G.length];
        this.comp = new int[G.length];
    }  // constructor Graph


    /**
     * Function that counts graph components and labels vertices.
     *
     * The function returns the number of graph components based on the
     * class-wide adjacency matrix self.G. It also labels every vertex found
     * in self.G[0] with its corresponding component number. Each component
     * is identified by a sequential number beginning with 1, produced by the
     * counter. The range of the value of count is
     *
     *     1 ≤ count ≤ len(self.G[0])
     *
     * ie, a graph may have 1 component if it is fully connected, or as many
     * components as its vertices, if it is fully disconnected. The number of
     * vertices in a graph represented by adjacency matrix self.G is given by
     * self.len(G[0]).
     *
     * @return int number of components in graph
     */
    public int countAndLabel() {
        int count = 0;
        this.marked = new boolean[this.G.length];
        for (int i = 0; i < this.G[0].length; i++) {
            if (!marked[i]) {
                count++;
                label(i,count);
            }
        }
        return count;
    } // method countAndLabel


    /**
     * Function to label a vertex and everything adjacent to it.
     *
     * The function labels vertex v and every vertex adjancent to it with
     * the component count value. This function is an iterative implementation
     * of the Depth-First Search, using an explicit data structure (bag) as a
     * stack. I felt that the iterative code here will be more illustrative
     * than a recursive DFS process.
     *
     * @param v
     * @param count
     */
    public void label(int v, int count) {
        ArrayList<Integer> bag = new ArrayList<>();
        bag.add(v);
        while (bag.size() > 0) {
            int x = bag.remove(0);
            if (!marked[x]) {
                marked[x] = true;
                comp[x] = count;
                for (int i = 0; i <this.G[x].length; i++) {
                    if (G[x][i] < Integer.MAX_VALUE)
                        bag.add(i);
                }
            }
        }
    } // method label


    /** Driver method */
    public static void main(String[] args) {
        int __ = Integer.MAX_VALUE;
        int[][] G = {
                {__, __,  1, __, __, __, __, __},
                {__, __,  1,  1, __, __, __, __},
                { 1,  1, __, __, __, __, __, __},
                {__,  1, __, __, __, __, __, __},
                {__, __, __, __, __,  1, __, __},
                {__, __, __, __,  1, __,  1, __},
                {__, __, __, __, __,  1, __, __},
                {__, __, __, __, __, __, __, __}
        }   ;
        Graph g = new Graph(G);
    } // method main

} // class Graph
