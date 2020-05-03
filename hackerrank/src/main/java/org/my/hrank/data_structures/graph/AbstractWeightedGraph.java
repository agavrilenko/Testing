package org.my.hrank.data_structures.graph;

import java.util.Collection;
import java.util.LinkedList;

public abstract class AbstractWeightedGraph {
    protected int cnt;
    LinkedList<Edge>[] vertices;

    public abstract void add(Edge e);

    public Collection<Edge> adj(int v) {
        return vertices[v];
    }

    public int size() {
        return cnt;
    }
}
