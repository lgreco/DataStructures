import java.util.ArrayList;

public class COMP363Fall21 {

    static int[][] adjListToMatrix(ArrayList<ArrayList> graphList) {
        int n = graphList.size();
        int[][] graphMatrix = new int[n][n];
        for (int u = 0; u < graphList.size(); u++) {
            for (int j = 0; j < graphList.get(u).size(); j++) {
                int v = (int) graphList.get(u).get(j);
                System.out.printf("\nu, j, v are: %d, %d, %d", u,j,v);
                graphMatrix[u][v] = 1;
            }
        }
        return graphMatrix;
    }

    public static void main(String[] args) {
        int a=0, b=1, c=2, d=3;

        ArrayList<ArrayList> G = new ArrayList<>();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        A.add(b); A.add(c);
        B.add(a); B.add(c);
        C.add(a); C.add(b); C.add(d);
        D.add(c);
        G.add(A); G.add(B); G.add(C); G.add(D);

        System.out.println(G.toString());

        int[][] result = adjListToMatrix(G);
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.printf("%4d",result[i][j]);
            }
            System.out.printf("\n");
        }

    }
}
