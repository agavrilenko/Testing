package org.my.hrank.data_structures.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class BFS {
    AbstractGraph graph;
    int[] pathTo;

    public BFS(AbstractGraph graph) {
        this.graph = graph;
        pathTo = new int[graph.size()];
        Arrays.fill(pathTo, -1);
    }

    public void bfs(int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            Integer vert = queue.removeFirst();
            if (pathTo[vert] == -1) {
                for (Integer vx : graph.adj(vert)) {
                    pathTo[vx] = vert;
                    queue.addAll(graph.adj(vx));
                }
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
