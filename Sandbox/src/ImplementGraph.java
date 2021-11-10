public class ImplementGraph {
    public static void main(String[] args) {
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
        System.out.println(g.countAndLabel());
        for (int i = 0; i < g.comp.length; i++) {
            System.out.println(g.comp[i]);
        }
    }

}
