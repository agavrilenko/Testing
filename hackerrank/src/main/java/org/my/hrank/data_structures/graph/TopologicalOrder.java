package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Based on DFS
 */
public class TopologicalOrder {
    private boolean[] marked;
    private LinkedList<Integer> reversePost;

    public TopologicalOrder(DirectedGraph g) {
        reversePost = new LinkedList<>();
        marked = new boolean[g.size()];
        for (int v = 0; v < g.size(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(DirectedGraph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
            reversePost.addFirst(v);
        }
    }

    /**
     * Vertexes are in post order.
     * So first will that which has only outgoing edges
     *
     * @return
     */
    public Collection<Integer> reversePost() {
        return reversePost;
    }
}
