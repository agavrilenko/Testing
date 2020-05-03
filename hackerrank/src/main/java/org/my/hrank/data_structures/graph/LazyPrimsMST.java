package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Adds minimal edge from existing MST to non-mst vertexes
 * Add all edges from newly added vertex
 * Edges sorted by weight
 */
public class LazyPrimsMST {
    private boolean[] marked;
    private LinkedList<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimsMST(EdgeWeightedGraph g) {
        pq = new PriorityQueue<>();
        mst = new LinkedList<>();
        marked = new boolean[g.size()];
        visit(g, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            if (marked[e.from()] && marked[e.to()]) {
                continue;
            }
            mst.add(e);
            if (!marked[e.from()]) {
                visit(g, e.from());
            }
            if (!marked[e.to()]) {
                visit(g, e.to());
            }
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public Collection<Edge> edges() {
        return mst;
    }
}
