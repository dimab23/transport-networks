package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dima B
 * @version problema3
 * @apiNote 14.05.2020
 */


public class Graph {
    private final int vCount;
    private final float[][] adj;

    public Graph(int vCount) {
        this.vCount = vCount;
        adj = new float[vCount][vCount];
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                adj[i][j] = 0;
            }
        }
    }

    public int getvCount() {
        return vCount;
    }

    public float[][] getAdj() {
        return adj;
    }

    public void addEdge(int i, int j, float weight) {
        adj[i][j] = weight;
    }

    public boolean hasEdge(int i, int j) {
        return adj[i][j] != 0;
    }

    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<>();
        for (int i = 0; i < vCount; i++)
            if (hasEdge(vertex, i))
                edges.add(i);
        return edges;
    }

    public void printGraph() {
        for (int i = 0; i < vCount; i++) {
            List<Integer> edges = neighbours(i);
            System.out.print(i + ": ");
            for (Integer edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}