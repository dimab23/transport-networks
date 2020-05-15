import model.Graph;

import java.util.LinkedList;

/**
 * @author Dima B
 * @version problema3
 * @apiNote 14.05.2020
 */


public class FordFulkerson {

    public float fordFulkerson(Graph g, int source, int dest) {
        if (source == dest) {
            return 0;
        }
        int V = g.getvCount();

        Graph rg = new Graph(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                rg.getAdj()[i][j] = g.getAdj()[i][j];
            }
        }

        int[] parent = new int[V];

        float max_flow = 0;

        while (bfs(rg, source, dest, parent)) {
            float path_flow = Float.MAX_VALUE;

            for (int i = dest; i != source; i = parent[i]) {
                int j = parent[i];
                path_flow = Math.min(path_flow, rg.getAdj()[j][i]);
            }

            for (int i = dest; i != source; i = parent[i]) {
                int j = parent[i];
                rg.getAdj()[j][i] -= path_flow;
                rg.getAdj()[i][j] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }

    public boolean bfs(Graph rg, int source, int dest, int[] parent) {
        boolean[] seen = new boolean[rg.getvCount()];
        for (int i = 0; i < rg.getvCount(); i++)
            seen[i] = false;

        LinkedList<Integer> q = new LinkedList<>();

        q.add(source);
        seen[source] = true;
        parent[source] = -1;

        while (!q.isEmpty()) {
            int i = q.poll();
            for (Integer j : rg.neighbours(i)) {
                if ((!seen[j]) && (rg.getAdj()[i][j] > 0)) {
                    q.add(j);
                    seen[j] = true;
                    parent[j] = i;
                }
            }
        }
        return seen[dest];
    }
}
