package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Minimum spanning tree.
 * Kruskal's implementation
 * Add edges sorted by weight if they do not add cycle
 * cycles can be tested with union find algorithm
 */
public class KruskalMST {

    private LinkedList<Edge> mst = new LinkedList<>();
    private int[] connected;
    private int numberOfGroups = 0;

    public KruskalMST(EdgeWeightedGraph g) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        connected = new int[g.size()];
        for (Edge e : g.edges()) {
            pq.add(e);
        }

        while (!pq.isEmpty() && mst.size() < g.size() - 1) {
            Edge e = pq.remove();
            if (!isConnected(e.from(), e.to())) {
                connect(e.from(), e.to());
                mst.add(e);
            }
        }
    }

    public Collection<Edge> edges() {
        return mst;
    }

    private boolean isConnected(int v, int w) {
        return parent(v) == parent(w);
    }

    private int parent(int v) {
        int parent = v;
        while (connected[parent] != 0) {
            parent = connected[parent];
        }
        return parent;
    }

    private void connect(int v, int w) {
        connected[parent(v)] = parent(w);
    }
}
