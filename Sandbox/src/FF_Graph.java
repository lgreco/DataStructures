import java.util.LinkedList;
import java.util.Queue;

public class FF_Graph {

    int[][] graph;
    int s, t;
    boolean[] processed;
    int[] parent;
    int[][] residualGraph;

    public FF_Graph(int[][] graph, int source, int target) {
        this.graph = graph;
        this.s = source;
        this.t = target;
        this.processed = new boolean[this.graph.length];
        this.parent = new int[this.graph.length];
        this.residualGraph = this.graph;
    }

    /**
     * A slightly modified BFS. The function returns a True/False indicating the presence or
     * absence of an s-t path. It also updates the parent[] list with the information necessary
     * to reconstruct the path.
     */
    public boolean breadthFirstSearch() {
        boolean pathExists = false;
        // Initialize parent[] and processed[]
        for (int i = 0; i < this.graph.length; i++) {
            this.parent[i] = -1;
            this.processed[i] = false;
        }
        // Set up a FIFO
        Queue<Integer> queue = new LinkedList<>();
        // Initialize the queue
        queue.add(this.s);
        // Mark source as processed
        this.processed[this.s] = true;
        while (queue.size() > 0) {
            // Obtain next-in-line vertex from q
            int u = queue.remove();
            // Look for adjacent vertices
            for (int v = 0; v < this.residualGraph.length; v++) {
                // Consider only edges with capacity > 0 with endpoints that
                // have not been processed yet.
                if (this.residualGraph[u][v] > 0 && !this.processed[v]) {
                    // Queue up the endpoint for subsequent iteration
                    queue.add(v);
                    // Mark endpoint as processed
                    this.processed[v] = true;
                    // Store the endpoint's parent ( u --> v)
                    this.parent[v] = u;
                    // If endpoint is target vertex, we found an s-t path
                    if (v == this.t)
                        pathExists = true;
                }
            }
        }
        return pathExists;
    }

    /** Implementation of the Ford-Fulkerson algorithm. */
    public int fordFulkerson() {
        // Initialize max flow to 0
        int maxFlow = 0;
        // Explore the residual graph as long as there is an s-t path in it.
        while (this.breadthFirstSearch()) {
            /*
            We are in the loop here because an s-t path exists in the residual
            graph; let's find how much fow we can push through this path.
            Look for the edge with the smallest (residual) capacity in the
            path. That's the path's bottleneck and it determines how much
            flow we can send through the path.
             */
            // Minimum residual capacity of path
            int mrc = Integer.MAX_VALUE;
            // Start from the end of the s-t path
            int y = this.t;
            // Walk back towards the source
            while (y != this.s) {
                int x = this.parent[y];
                if (this.residualGraph[x][y] < mrc)
                    mrc = this.residualGraph[x][y];
                y = x;
            }
            // Count the min residual capacity towards the graph's max flow.
            maxFlow += mrc;
            // Update residual capacities in the residual graph.
            // Start from the end of the s-t path
            int v = this.t;
            // Loop until we reach the source of the s-t path.
            while (v != this.s) {
                // Parent of current vertex, so we now have edge u --> v
                int u = this.parent[v];
                // Forward edge residual capacity
                this.residualGraph[u][v] -= mrc;
                this.residualGraph[v][u] += mrc;
                // Continue to the previous edge
                v = u;
            }
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] G2 = {
                {0, 20, 0, 0, 0, 10},
                {0, 0, 5, 0, 0, 10},
                {0, 0, 0, 15, 0, 15},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 10, 20, 0, 0},
                {0, 0, 0, 0, 10, 0}
        };

        FF_Graph g2 = new FF_Graph(G2, 0, 3);
        System.out.printf("\nThe max flow for this graph is %d.", g2.fordFulkerson());
    }
}