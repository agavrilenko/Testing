package org.my.hrank.data_structures.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class DFS {
    AbstractGraph graph;
    int[] pathTo;

    public DFS(AbstractGraph graph) {
        this.graph = graph;
        pathTo = new int[graph.size()];
        Arrays.fill(pathTo, -1);
    }

    public void dfs(int v) {
        pathTo = new int[graph.size()];
        Arrays.fill(pathTo, -1);
        dfs(v, -1);
    }

    void dfs(int v, int w) {
        if (pathTo[v] == -1) {
            pathTo[v] = w;
            for (Integer vertex : graph.adj(v)) {
                dfs(vertex, v);
            }
        }
    }

    public Integer[] pathTo(int v) {
        LinkedList<Integer> path = new LinkedList<>();
        int next = v;
        path.add(v);

        while (pathTo[next] != -1) {
            next = pathTo[next];
            path.add(next);
        }
        return (Integer[]) path.toArray();
    }
}
