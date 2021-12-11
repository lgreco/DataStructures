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
                this.comp[x] = count;
                System.out.printf("\n*** vertex %d is assigned go component %d", x, count);
                for (int i = 0; i <this.G[x].length; i++) {
                    if (G[x][i] < Integer.MAX_VALUE)
                        bag.add(i);
                }
            }
        }
    } // method label

    /**
     * The principal implementation of Boruvka.
     *
     # The MST is represented by its adjacency matrix, named F below. The
     # matrix has the same size as G -- the input graph's adj. matrix. All
     # edge weights in F are set to infinity to indicate that the vertices in
     # F are all disconnected.
     * @return int array with MST
     */
    public Graph boruvka() {
        int[][] mstAdjacency = new int[this.G.length][this.G[0].length];
        for (int i = 0; i < mstAdjacency.length; i++) {
            for (int j = 0; j < mstAdjacency[0].length; j++) {
                mstAdjacency[i][j] = Integer.MAX_VALUE;
            }
        }
        Graph F = new Graph(mstAdjacency);
        System.out.println("New F instantiated");
        int count = F.countAndLabel();
        System.out.printf("\nInitial count of F is %d", count);
        while (count > 1) {
            this.addAllSafeEdges(F,count);
            count = F.countAndLabel();
            System.out.printf("\nNew count of F is %d", count);
        }
        return F;
    }

    public void addAllSafeEdges(Graph F, int count) {
        // Need a 2D array for safe edge's both vertices
        int safe[][] = new int[count+1][2];
        for (int i = 1; i < safe.length; i++) {
            safe[i][0] = -1; // -1 indicates no safe edge for this component.
            safe[i][1] = -1;
        }
        for (int u = 0; u < F.G.length; u++) {
            for (int v = 0; v < F.G[0].length; v++) {
                System.out.printf("\n\tChecking for edge [%d] -- [%d]", u, v);
                if (this.G[u][v] < Integer.MAX_VALUE) {
                    System.out.printf("\n\t\tEdge exists");
                    if (F.comp[u] != F.comp[v]) {
                        System.out.printf("\n\t\t\tEdge across different components");
                        if (safe[F.comp[u]][0] == -1) {
                            System.out.printf("\n\t\t\t\tu-component has no safe edge. Adding one.");
                            safe[F.comp[u]][0] = u;
                            safe[F.comp[u]][1] = v;
                        } else {
                            int x = safe[F.comp[u]][0];
                            int y = safe[F.comp[u]][1];
                            if (this.G[u][v] < this.G[x][y]) {
                                safe[F.comp[u]][0] = x;
                                safe[F.comp[u]][1] = y;
                            }
                        }
                        if (safe[F.comp[v]][0] == -1) {
                            safe[F.comp[v]][0] = u;
                            safe[F.comp[v]][1] = v;
                        } else {
                            int x = safe[F.comp[v]][0];
                            int y = safe[F.comp[v]][1];
                            if (this.G[u][v] < this.G[x][y]) {
                                safe[F.comp[v]][0] = x;
                                safe[F.comp[v]][1] = y;
                            }
                        }
                    }
                }
            } // end for v
        } // end for u
        // Add safe edges to adjacency matrix for MST.
        for (int i = 1; i < count+1; i++) {
            int u = safe[i][0];
            int v = safe[i][1];
            F.G[u][v] = this.G[u][v];
            F.G[v][u] = this.G[u][v];
        }
    }

    /** Driver method */   public static void main(String[] args) {
        int __ = Integer.MAX_VALUE;
        int[][] G = {
                {__, __, 1, __, __, __, __, __},
                {__, __, 1, 1, __, __, __, __},
                {1, 1, __, __, __, __, __, __},
                {__, 1, __, __, __, __, __, __},
                {__, __, __, __, __, 1, __, __},
                {__, __, __, __,  1, __, 1, __},
                {__, __, __, __, __, 1, __, __},
                {__, __, __, __, __, __, __, __}
        }   ;
        Graph g = new Graph(G);
        g.boruvka();
        for (int i = 0; i < g.comp.length; i++) {
            System.out.println(g.comp[i]);
        }
    } // method main

} // class Graph
