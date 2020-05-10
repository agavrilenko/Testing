package org.my.hrank.data_structures.graph;

import java.util.LinkedList;

public class FordFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;

    public FordFulkerson(FlowNetwork g, int s, int t) {
        value = 0;
        //hasAugmentingPath build path from s to t if it is possible
        while (hasAugmentingPash(g, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;
            //cycle goes from t to s and finds bottleneck
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }
            //adds bottleneck to residual capacity to all edges.
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }
            value += bottle;
        }
    }

    private boolean hasAugmentingPash(FlowNetwork g, int s, int t) {
        edgeTo = new FlowEdge[g.v()];
        marked = new boolean[g.v()];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (FlowEdge e : g.adj(v)) {
                int w = e.other(v);
                if (e.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        return marked[t];
    }
}
